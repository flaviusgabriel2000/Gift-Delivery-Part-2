package solver.simulate.strategies.assignstrategy;

import solver.simulate.Child;
import solver.simulate.Simulator;
import solver.simulate.output.AnnualChildren;
import solver.simulate.output.ChildOutputInfo;

import java.util.List;

public class IDStrategy implements AssignStrategy {
    /**
     * Children list
     */
    private List<Child> children;

    /**
     * Constructor
     * @param children list
     */
    public IDStrategy(final List<Child> children) {
        this.children = children;
    }

    /**
     * Assign gifts applying the ID strategy.
     * @param simulator base class
     * @return AnnualChildren required for output
     */
    @Override
    public AnnualChildren assignGifts(final Simulator simulator) {
        AnnualChildren annualChildren = new AnnualChildren();

        // Apply the ID Strategy
        for (Child c : this.children) {
            c.computeAssignedBudget(simulator.getBudgetUnit());
            ChildOutputInfo childOutputInfo = simulator.shareGifts(c);
            if (childOutputInfo != null) {
                annualChildren.addChild(childOutputInfo);
            }
        }

        return annualChildren;
    }


}
