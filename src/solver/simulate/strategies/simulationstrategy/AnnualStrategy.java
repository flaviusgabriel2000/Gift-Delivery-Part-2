package solver.simulate.strategies.simulationstrategy;

import common.Constants;
import enums.CityStrategyEnum;
import solver.database.AnnualChange;
import solver.database.ChildInfo;
import solver.database.ChildUpdate;
import solver.database.Database;
import solver.database.Gift;
import solver.simulate.Child;
import solver.simulate.Simulator;
import solver.simulate.strategies.assignstrategy.AssignStrategyFactory;
import solver.simulate.output.Output;
import solver.utils.Utils;

public class AnnualStrategy implements SimulationStrategy {
    /**
     * Class for writing to output.
     */
    private Output output;
    /**
     * Certain updates for the current year.
     */
    private AnnualChange annualChange;
    /**
     * Class containing information parsed from the JSON input files.
     */
    private Database database;
    private CityStrategyEnum cityStrategyEnum;

    public AnnualStrategy(final Output output, final AnnualChange annualChange,
                          final Database database, final CityStrategyEnum cityStrategyEnum) {
        this.output = output;
        this.annualChange = annualChange;
        this.database = database;
        this.cityStrategyEnum = cityStrategyEnum;
    }


    /**
     * Simulates the current year.
     * @param simulator base class
     */
    @Override
    public void simulate(final Simulator simulator) {
        Utils.incrementAge(simulator.getChildren());

        // Add new children if any
        for (ChildInfo newChild : annualChange.getNewChildren()) {
            if (newChild.getAge() <= Constants.TEEN_UPPER_LIMIT) {
                simulator.getChildren().add(new Child.Builder(newChild)
                        .niceScoreBonus(newChild.getNiceScoreBonus())
                        .build());
            }
        }

        // Update children info if any
        for (ChildUpdate childUpdate : annualChange.getChildrenUpdates()) {
            Child child = Utils.getChildIfExists(simulator.getChildren(), childUpdate.getId());
            if (child != null) {
                Utils.updateChildInfo(childUpdate, child);
            }
        }

        // Add new gifts if any
        for (Gift newGift : annualChange.getNewGifts()) {
            if (!database.getInitialData().getSantaGiftsList().contains(newGift)) {
                database.getInitialData().getSantaGiftsList().add(newGift);
            } else {
                for (Gift g : database.getInitialData().getSantaGiftsList()) {
                    if (g.getProductName().equals(newGift.getProductName())) {
                        g.setQuantity(newGift.getQuantity());
                    }
                }
            }
        }
        database.setSantaBudget(annualChange.getNewSantaBudget());
        simulator.setBudgetUnit(simulator.computeBudgetUnit());

        // Apply the gifts assigning strategy and prepare the output
        output.getAnnualChildren().add(AssignStrategyFactory
                .createAssignStrategy(simulator.getChildren(),
                        cityStrategyEnum).assignGifts(simulator));
    }
}
