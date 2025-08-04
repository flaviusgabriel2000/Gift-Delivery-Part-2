package solver.database;

import java.util.List;

public final class Database {
    /**
     * The number of years for the current simulation
     */
    private Integer numberOfYears;
    /**
     * Santa's budget for the current year of simulation
     */
    private Double santaBudget;
    /**
     * Used for the simulation of round 0 and are subject to further
     * modification
     */
    private InitialData initialData;
    /**
     * List containing information about every year changes.
     */
    private List<AnnualChange> annualChanges;


    /**
     * For coding style
     */
    public Database() {
    }

    // Getters and Setters

    /**
     * @return numberOfYears
     */
    public Integer getNumberOfYears() {
        return numberOfYears;
    }

    /**
     * @param numberOfYears to be set
     */
    public void setNumberOfYears(final Integer numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    /**
     * @return santaBudget
     */
    public Double getSantaBudget() {
        return santaBudget;
    }

    /**
     * @param santaBudget to be set
     */
    public void setSantaBudget(final Double santaBudget) {
        this.santaBudget = santaBudget;
    }

    /**
     * @return initialData
     */
    public InitialData getInitialData() {
        return initialData;
    }

    /**
     * @param initialData to be set
     */
    public void setInitialData(final InitialData initialData) {
        this.initialData = initialData;
    }

    /**
     * @return annualChanges
     */
    public List<AnnualChange> getAnnualChanges() {
        return annualChanges;
    }

    /**
     * @param annualChanges to be set
     */
    public void setAnnualChanges(final List<AnnualChange> annualChanges) {
        this.annualChanges = annualChanges;
    }
}
