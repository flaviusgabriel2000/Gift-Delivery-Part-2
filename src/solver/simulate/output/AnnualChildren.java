package solver.simulate.output;

import java.util.ArrayList;
import java.util.List;

public class AnnualChildren {
    /**
     * List of children that received gifts this year and are not Young Adults.
     */
    private List<ChildOutputInfo> children;

    /**
     * Constructor
     */
    public AnnualChildren() {
        this.children = new ArrayList<>();
    }

    /**
     * @param childOutputInfo - child to be added for this year's output.
     */
    public void addChild(final ChildOutputInfo childOutputInfo) {
        this.children.add(childOutputInfo);
    }

    // Getters and Setters

    /**
     * @return children
     */
    public List<ChildOutputInfo> getChildren() {
        return children;
    }

    /**
     * @param children to be set
     */
    public void setChildren(final List<ChildOutputInfo> children) {
        this.children = children;
    }
}
