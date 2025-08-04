package solver.simulate.strategies.simulationstrategy;

import solver.simulate.Simulator;

public interface SimulationStrategy {
    /**
     * The flow simulation method to be implemented.
     * @param simulator base class
     */
    void simulate(Simulator simulator);
}
