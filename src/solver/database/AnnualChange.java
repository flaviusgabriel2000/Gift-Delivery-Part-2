package solver.database;

import enums.CityStrategyEnum;

import java.util.List;

public class AnnualChange {
    /**
     * Newly allocated santa budget for the current year.
     */
    private Double newSantaBudget;
    /**
     * A list of new gifts for the current year.
     */
    private List<Gift> newGifts;
    /**
     * A list of new children for the current year.
     */
    private List<ChildInfo> newChildren;
    /**
     * Updates for some children.
     */
    private List<ChildUpdate> childrenUpdates;
    /**
     * Gifts assigning strategy
     */
    private CityStrategyEnum strategy;

    /**
     * For coding style
     */
    public AnnualChange() {
    }

    // Getters and Setters

    /**
     * @return newSantaBudget
     */
    public Double getNewSantaBudget() {
        return newSantaBudget;
    }

    /**
     * @param newSantaBudget to be set
     */
    public void setNewSantaBudget(final Double newSantaBudget) {
        this.newSantaBudget = newSantaBudget;
    }

    /**
     * @return newGifts
     */
    public List<Gift> getNewGifts() {
        return newGifts;
    }

    /**
     * @param newGifts to be set
     */
    public void setNewGifts(final List<Gift> newGifts) {
        this.newGifts = newGifts;
    }

    /**
     * @return newChildren
     */
    public List<ChildInfo> getNewChildren() {
        return newChildren;
    }

    /**
     * @param newChildren to be set
     */
    public void setNewChildren(final List<ChildInfo> newChildren) {
        this.newChildren = newChildren;
    }

    /**
     * @return childrenUpdates
     */
    public List<ChildUpdate> getChildrenUpdates() {
        return childrenUpdates;
    }

    /**
     * @param childrenUpdates to be set
     */
    public void setChildrenUpdates(final List<ChildUpdate> childrenUpdates) {
        this.childrenUpdates = childrenUpdates;
    }

    /**
     * @return strategy
     */
    public CityStrategyEnum getStrategy() {
        return strategy;
    }

    /**
     * @param strategy to be set
     */
    public void setStrategy(final CityStrategyEnum strategy) {
        this.strategy = strategy;
    }
}
