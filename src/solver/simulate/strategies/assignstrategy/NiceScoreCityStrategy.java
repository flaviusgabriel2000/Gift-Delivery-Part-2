package solver.simulate.strategies.assignstrategy;

import enums.Cities;
import solver.simulate.Child;
import solver.simulate.Simulator;
import solver.simulate.output.AnnualChildren;
import solver.simulate.output.ChildOutputInfo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NiceScoreCityStrategy implements AssignStrategy {
    /**
     * Children list
     */
    private List<Child> children;

    /**
     * Constructor
     * @param children list
     */
    public NiceScoreCityStrategy(final List<Child> children) {
        this.children = children;
    }

    /**
     * Assign gifts applying the niceScoreCity strategy.
     * @param simulator base class
     * @return AnnualChildren required for output
     */
    @Override
    public AnnualChildren assignGifts(final Simulator simulator) {
        AnnualChildren annualChildren = new AnnualChildren();
        Map<Cities, Double> unsortedCitiesMap = new HashMap<>();
        int count;

        for (Child c : children) {
            if (!unsortedCitiesMap.containsKey(c.getChildInfo().getCity())) {
               unsortedCitiesMap.put(c.getChildInfo().getCity(), 0d);
            }
        }

        // An unsorted map of <City, averageScore> pairs
        for (Map.Entry<Cities, Double> entry : unsortedCitiesMap.entrySet()) {
            count = 0;
            for (Child c : children) {
                if (c.getChildInfo().getCity().equals(entry.getKey())) {
                    entry.setValue(entry.getValue() + c.getAverageScore());
                    count++;
                }
            }
            if (count > 0) {
                entry.setValue(entry.getValue() / count);
            }
        }

        // The sorted list obtained from the map created above
        ArrayList<Map.Entry<Cities, Double>> citiesList
                = new ArrayList<>(unsortedCitiesMap.entrySet());
        citiesList.sort(new Comparator<Map.Entry<Cities, Double>>() {
            @Override
            public int compare(final Map.Entry<Cities, Double> c1,
                               final Map.Entry<Cities, Double> c2) {

                if (c1.getValue().equals(c2.getValue())) {
                    return c1.getKey().toString().compareToIgnoreCase(c2.getKey().toString());
                }
                return c2.getValue().compareTo(c1.getValue());
            }
        });

        // Apply the Nice Score City Strategy
        for (Map.Entry<Cities, Double> cityEntry : citiesList) {
            for (Child c : children) {
                if (c.getChildInfo().getCity().equals(cityEntry.getKey())) {
                    c.computeAssignedBudget(simulator.getBudgetUnit());
                    ChildOutputInfo childOutputInfo = simulator.shareGifts(c);
                    if (childOutputInfo != null) {
                        annualChildren.addChild(childOutputInfo);
                    }
                }
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
