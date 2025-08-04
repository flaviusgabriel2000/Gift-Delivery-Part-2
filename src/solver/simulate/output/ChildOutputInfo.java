package solver.simulate.output;

import enums.Category;
import enums.Cities;
import solver.database.Gift;

import java.util.ArrayList;
import java.util.List;

public class ChildOutputInfo {
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
     * This child's city.
     */
    private Cities city;
    /**
     * This child's age.
     */
    private Integer age;
    /**
     * List with this child's gifts preferences.
     */
    private List<Category> giftsPreferences;
    /**
     * This child's average score.
     */
    private Double averageScore;
    /**
     * This child's nice scores received throughout the simulation.
     */
    private List<Double> niceScoreHistory;
    /**
     * This child's assigned budget for the current year.
     */
    private Double assignedBudget;
    /**
     * A list with the gifts this child received in the current round.
     */
    private List<Gift> receivedGifts;

    public ChildOutputInfo(final Integer id, final String lastName, final String firstName,
                           final Cities city, final Integer age,
                           final List<Category> giftsPreferences, final Double averageScore,
                           final List<Double> niceScoreHistory, final Double assignedBudget,
                           final List<Gift> receivedGifts) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.city = city;
        this.age = age;
        this.giftsPreferences = new ArrayList<>(giftsPreferences);
        this.averageScore = averageScore;
        this.niceScoreHistory = new ArrayList<>(niceScoreHistory);
        this.assignedBudget = assignedBudget;
        this.receivedGifts = new ArrayList<>(receivedGifts);
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
     * @return averageScore
     */
    public Double getAverageScore() {
        return averageScore;
    }

    /**
     * @param averageScore to be set
     */
    public void setAverageScore(final Double averageScore) {
        this.averageScore = averageScore;
    }

    /**
     * @return niceScoreHistory
     */
    public List<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    /**
     * @param niceScoreHistory to be set
     */
    public void setNiceScoreHistory(final List<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }

    /**
     * @return assignedBudget
     */
    public Double getAssignedBudget() {
        return assignedBudget;
    }

    /**
     * @param assignedBudget to be set
     */
    public void setAssignedBudget(final Double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    /**
     * @return receivedGifts
     */
    public List<Gift> getReceivedGifts() {
        return receivedGifts;
    }

    /**
     * @param receivedGifts to be set
     */
    public void setReceivedGifts(final List<Gift> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }
}
