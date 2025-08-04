package solver.simulate;

import enums.Category;
import enums.ElvesType;
import solver.database.ChildInfo;
import solver.database.Database;
import solver.database.Gift;
import solver.simulate.output.ChildOutputInfo;
import solver.simulate.strategies.simulationstrategy.SimulationStrategy;
import solver.utils.Utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Simulator {
    /**
     * The Database used for the simulation.
     */
    private Database database;
    /**
     * List of children used for the current simulation.
     */
    private List<Child> children;
    /**
     * The budget unit for the current year.
     */
    private Double budgetUnit;

    /**
     * @param database used for this simulation.
     */
    public Simulator(final Database database) {
        this.database = database;
        this.children = new ArrayList<>();
        for (ChildInfo c : database.getInitialData().getChildren()) {
            children.add(new Child.Builder(c)
                    .niceScoreBonus(c.getNiceScoreBonus())
                    .build());
        }
    }

    /**
     * Computes the budget unit for the current year.
     * @return the budged unit
     */
    public Double computeBudgetUnit() {
        this.children.sort(new Comparator<Child>() {
            @Override
            public int compare(final Child c1, final Child c2) {
                return c1.getChildInfo().getId().compareTo(c2.getChildInfo().getId());
            }
        });
        double averageScoreSum = 0d;
        for (Child child : children) {
            child.computeAgeCategory();
            child.computeAverageScore();
            averageScoreSum += child.getAverageScore();
        }
        return database.getSantaBudget() / averageScoreSum;
    }

    /**
     * Shares, if possible, the gifts this child wished.
     * @param child for which the gifts to be shared to.
     * @return output information about this child
     */
    public ChildOutputInfo shareGifts(final Child child) {
        Double remainingBudget = child.getAssignedBudget();
        for (Category category : child.getChildInfo().getGiftsPreferences()) {
            Gift toReceive = Utils.getGiftByCategory(category,
                    database.getInitialData().getSantaGiftsList(), false);
            if (toReceive != null && toReceive.getPrice() <= remainingBudget
                    && toReceive.getQuantity() > 0) {
                child.receiveGift(toReceive);
                child.receiveThisRound(toReceive);
                remainingBudget -= toReceive.getPrice();
                toReceive.setQuantity(toReceive.getQuantity() - 1);
            }
        }
        if (child.getChildInfo().getElf().equals(ElvesType.YELLOW)
                && child.getReceivedThisRound().isEmpty()) {
            Category preferredCategory = child.getChildInfo().getGiftsPreferences().get(0);
            Gift toReceive = Utils.getGiftByCategory(preferredCategory,
                    database.getInitialData().getSantaGiftsList(), true);
            if (toReceive != null && toReceive.getQuantity() > 0) {
                child.receiveGift(toReceive);
                child.receiveThisRound(toReceive);
                toReceive.setQuantity(toReceive.getQuantity() - 1);
            }
        }
        ChildOutputInfo childOutputInfo = Utils.createChildOutput(child);
        child.getReceivedThisRound().clear();
        return childOutputInfo;
    }

    /**
     * Simulate the flow, based on the given strategy.
     * @param simulationStrategy - either round zero or annual round
     */
    public void simulate(final SimulationStrategy simulationStrategy) {
        simulationStrategy.simulate(this);
    }

    // Getters and setters

    /**
     * @return database
     */
    public Database getDatabase() {
        return database;
    }

    /**
     * @return children
     */
    public List<Child> getChildren() {
        return children;
    }

    /**
     * @return budgetUnit
     */
    public Double getBudgetUnit() {
        return budgetUnit;
    }

    /**
     * @param budgetUnit to be set
     */
    public void setBudgetUnit(final Double budgetUnit) {
        this.budgetUnit = budgetUnit;
    }
}
