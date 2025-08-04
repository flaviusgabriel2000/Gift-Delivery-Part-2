package solver.simulate.strategies.assignstrategy;

import enums.CityStrategyEnum;
import solver.simulate.Child;

import java.util.List;

public final class AssignStrategyFactory {

    /**
     * For coding style
     */
    private AssignStrategyFactory() {
    }

    /**
     * Assign Strategy Factory
     * @param children list
     * @param cityStrategyEnum - gifts assigning strategy type
     * @return an AssignStrategy
     */
    public static AssignStrategy createAssignStrategy(final List<Child> children,
                                                      final CityStrategyEnum cityStrategyEnum) {
        switch (cityStrategyEnum) {
            case ID: return new IDStrategy(children);
            case NICE_SCORE: return new NiceScoreStrategy(children);
            case NICE_SCORE_CITY: return new NiceScoreCityStrategy(children);
            default: throw new IllegalArgumentException("Unrecognized strategy.");
        }
    }
}
