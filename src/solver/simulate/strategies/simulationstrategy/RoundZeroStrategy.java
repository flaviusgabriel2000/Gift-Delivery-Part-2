package solver.simulate.strategies.simulationstrategy;

import solver.simulate.Child;
import solver.simulate.Simulator;
import solver.simulate.output.AnnualChildren;
import solver.simulate.output.ChildOutputInfo;
import solver.simulate.output.Output;

public class RoundZeroStrategy implements SimulationStrategy {
    /**
     * Class for writing to output.
     */
    private Output output;

    public RoundZeroStrategy(final Output output) {
        this.output = output;
    }

    /**
     * Simulates round zero.
     * @param simulator base class
     */
    @Override
    public void simulate(final Simulator simulator) {
        simulator.setBudgetUnit(simulator.computeBudgetUnit());
        AnnualChildren annualChildren = new AnnualChildren();

        for (Child c : simulator.getChildren()) {
            c.computeAssignedBudget(simulator.getBudgetUnit());
            ChildOutputInfo childOutputInfo = simulator.shareGifts(c);
            if (childOutputInfo != null) {
                annualChildren.addChild(childOutputInfo);
            }
        }
        output.getAnnualChildren().add(annualChildren);
    }
}
