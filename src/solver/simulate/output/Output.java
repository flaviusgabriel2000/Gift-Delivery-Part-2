package solver.simulate.output;

import java.util.ArrayList;
import java.util.List;

public final class Output {
    /**
     * The instance of this Singleton class
     */
    private static Output instance = null;
    /**
     * A numberOfYears + 1 list, each element containing a list of children
     * who received gifts for the respective year.
     */
    private List<AnnualChildren> annualChildren;


    private Output() {
        this.annualChildren = new ArrayList<>();
    }

    /**
     * @return the only instance of this class
     */
    public static Output getInstance() {
        if (instance == null) {
            instance = new Output();
        }
        return instance;
    }


    /**
     * Clears the children list for every year of the simulation.
     */
    public void clearAnnualChildren() {
        this.annualChildren.clear();
    }

    // Getters and Setters

    /**
     * @return annualChildren
     */
    public List<AnnualChildren> getAnnualChildren() {
        return annualChildren;
    }

    /**
     * @param annualChildren to be set
     */
    public void setAnnualChildren(final List<AnnualChildren> annualChildren) {
        this.annualChildren = annualChildren;
    }
}
