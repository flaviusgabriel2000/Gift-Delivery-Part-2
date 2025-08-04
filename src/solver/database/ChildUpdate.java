package solver.database;

import enums.Category;
import enums.ElvesType;

import java.util.List;

public class ChildUpdate {
    /**
     * The ID of the child for the update to be applied on.
     */
    private Integer id;
    /**
     * A new nice score to be added in his/her nice score history.
     */
    private Double niceScore;
    /**
     * A new list of gifts preferences.
     */
    private List<Category> giftsPreferences;
    /**
     * Elf for this child.
     */
    private ElvesType elf;


    /**
     * For coding style
     */
    public ChildUpdate() {
    }

    // Getters and Setters

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id to be set
     */
    public void setId(final Integer id) {
        this.id = id;
    }

    /**
     * @return niceScore
     */
    public Double getNiceScore() {
        return niceScore;
    }

    /**
     * @param niceScore to be set
     */
    public void setNiceScore(final Double niceScore) {
        this.niceScore = niceScore;
    }

    /**
     * @return giftsPreferences
     */
    public List<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    /**
     * @param giftsPreferences to be set
     */
    public void setGiftsPreferences(final List<Category> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    /**
     * @return elf
     */
    public ElvesType getElf() {
        return elf;
    }

    /**
     * @param elf to be set
     */
    public void setElf(final ElvesType elf) {
        this.elf = elf;
    }
}
