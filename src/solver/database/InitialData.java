package solver.database;

import java.util.List;

public class InitialData {
    /**
     * An initial list of children.
     */
    private List<ChildInfo> children;
    /**
     * An initial list of Santa gifts.
     */
    private List<Gift> santaGiftsList;


    public InitialData() {
    }

    // Getters and Setters

    /**
     * @return children
     */
    public List<ChildInfo> getChildren() {
        return children;
    }

    /**
     * @param children to be set
     */
    public void setChildren(final List<ChildInfo> children) {
        this.children = children;
    }

    /**
     * @return santaGiftsList
     */
    public List<Gift> getSantaGiftsList() {
        return santaGiftsList;
    }

    /**
     * @param santaGiftsList to be set
     */
    public void setSantaGiftsList(final List<Gift> santaGiftsList) {
        this.santaGiftsList = santaGiftsList;
    }
}
