package solver.simulate.strategies.assignstrategy;

import solver.simulate.Child;
import solver.simulate.Simulator;
import solver.simulate.output.AnnualChildren;
import solver.simulate.output.ChildOutputInfo;

import java.util.Comparator;
import java.util.List;

public class NiceScoreStrategy implements AssignStrategy {
    /**
     * Children list
     */
    private List<Child> children;

    /**
     * Constructor
     * @param children list
     */
    public NiceScoreStrategy(final List<Child> children) {
        this.children = children;
    }

    /**
     * Assign gifts applying the niceScore strategy.
     * @param simulator base class
     * @return AnnualChildren required for output
     */
    @Override
    public AnnualChildren assignGifts(final Simulator simulator) {
        AnnualChildren annualChildren = new AnnualChildren();

        // Sort the children list by average score
        children.sort(new Comparator<Child>() {
            @Override
            public int compare(final Child c1, final Child c2) {
                if (c1.getAverageScore().equals(c2.getAverageScore())) {
                    return c1.getChildInfo().getId().compareTo(c2.getChildInfo().getId());
                }
                return c2.getAverageScore().compareTo(c1.getAverageScore());
            }
        });

        // Apply the Nice Score Strategy
        for (Child c : this.children) {
            c.computeAssignedBudget(simulator.getBudgetUnit());
            ChildOutputInfo childOutputInfo = simulator.shareGifts(c);
            if (childOutputInfo != null) {
                annualChildren.addChild(childOutputInfo);
            }
        }

        // Sort the output children list by ID
        annualChildren.getChildren().sort(new Comparator<ChildOutputInfo>() {
            @Override
            public int compare(final ChildOutputInfo c1, final ChildOutputInfo c2) {
                return c1.getId().compareTo(c2.getId());
            }
        });
        return annualChildren;
    }
}
