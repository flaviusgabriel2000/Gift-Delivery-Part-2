package solver.database;

import enums.Category;
import enums.Cities;
import enums.ElvesType;

import java.util.List;

public class ChildInfo {
    /**
     * This child's ID.
     */
    private Integer id;
    /**
     * This child's last name.
     */
    private String lastName;
    /**
     * This child's first name.
     */
    private String firstName;
    /**
     * This child's age.
     */
    private Integer age;
    /**
     * This child's city.
     */
    private Cities city;
    /**
     * This child's first nice score.
     */
    private Double niceScore;
    /**
     * List with this child's gifts preferences.
     */
    private List<Category> giftsPreferences;
    /**
     * Nice score bonus for this child.
     */
    private Double niceScoreBonus;
    /**
     * Elf for this child.
     */
    private ElvesType elf;

    /**
     * For coding style
     */
    public ChildInfo() {
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
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName to be set
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName to be set
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age to be set
     */
    public void setAge(final Integer age) {
        this.age = age;
    }

    /**
     * @return city
     */
    public Cities getCity() {
        return city;
    }

    /**
     * @param city to be set
     */
    public void setCity(final Cities city) {
        this.city = city;
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
     * @return niceScoreBonus
     */
    public Double getNiceScoreBonus() {
        return niceScoreBonus;
    }

    /**
     * @param niceScoreBonus to be set
     */
    public void setNiceScoreBonus(final Double niceScoreBonus) {
        this.niceScoreBonus = niceScoreBonus;
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
