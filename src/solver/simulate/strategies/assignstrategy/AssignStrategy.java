package solver.simulate.strategies.assignstrategy;

import solver.simulate.Simulator;
import solver.simulate.output.AnnualChildren;

public interface AssignStrategy {
    /**
     * Gifts assigning method to be implemented.
     * @param simulator base class
     * @return annualChildren required for output
     */
    AnnualChildren assignGifts(Simulator simulator);
}
