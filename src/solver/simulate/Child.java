package solver.simulate;

import common.Constants;
import enums.AgeCategory;
import enums.ElvesType;
import solver.database.ChildInfo;
import solver.database.Gift;

import java.util.ArrayList;
import java.util.List;

public final class Child {
    /**
     * Information about this child.
     */
    private ChildInfo childInfo;
    /**
     * The age category of this child.
     */
    private AgeCategory ageCategory;
    /**
     * This child's nice scores received throughout the simulation.
     */
    private List<Double> niceScoreHistory;
    /**
     * The average score of this child.
     */
    private Double averageScore;
    /**
     * This child's assigned budget for the current year.
     */
    private Double assignedBudget;
    /**
     * A list with all the gifts this child received throughout the
     * whole simulation.
     */
    private List<Gift> receivedGifts;
    /**
     * A list with the gifts this child received in the current round.
     */
    private List<Gift> receivedThisRound;
    /**
     * Nice score bonus for this child.
     */
    private Double niceScoreBonus;

    // Create Child using Builder design pattern
    public static class Builder {
        private ChildInfo childInfo;
        private List<Double> niceScoreHistory;
        private List<Gift> receivedGifts;
        private final List<Gift> receivedThisRound;
        private Double niceScoreBonus;

        public Builder(final ChildInfo childInfo) {
            this.childInfo = childInfo;
            this.niceScoreHistory = new ArrayList<>();
            this.niceScoreHistory.add(this.childInfo.getNiceScore());
            this.receivedGifts = new ArrayList<>();
            this.receivedThisRound = new ArrayList<>();
        }

        /**
         * Nice score bonus implementation using Builder design pattern
         * @param pNiceScoreBonus for this child
         * @return Builder
         */
        public Builder niceScoreBonus(final Double pNiceScoreBonus) {
            this.niceScoreBonus = pNiceScoreBonus;
            return this;
        }

        /**
         * Create a new Child using Builder design pattern
         * @return Child
         */
        public Child build() {
            return new Child(this);
        }
    }

    /**
     * @param builder static class
     */
    private Child(final Builder builder) {
        this.childInfo = builder.childInfo;
        this.niceScoreHistory = builder.niceScoreHistory;
        this.receivedGifts = builder.receivedGifts;
        this.receivedThisRound = builder.receivedThisRound;
        this.niceScoreBonus = builder.niceScoreBonus;
    }


    /**
     * Method for determining this child's age category.
     */
    public void computeAgeCategory() {
        if (this.childInfo.getAge() < Constants.KID_LOWER_LIMIT) {
            this.ageCategory = AgeCategory.BABY;
        } else if (this.childInfo.getAge() >= Constants.KID_LOWER_LIMIT
                && this.childInfo.getAge() < Constants.TEEN_LOWER_LIMIT) {
            this.ageCategory = AgeCategory.KID;
        } else if (this.childInfo.getAge() >= Constants.TEEN_LOWER_LIMIT
                && this.childInfo.getAge() <= Constants.TEEN_UPPER_LIMIT) {
            this.ageCategory = AgeCategory.TEEN;
        } else if (this.childInfo.getAge() > Constants.TEEN_UPPER_LIMIT) {
            this.ageCategory = AgeCategory.YOUNG_ADULT;
        }
    }

    /**
     * @param niceScore received this round.
     */
    public void addNewNiceScore(final Double niceScore) {
        this.niceScoreHistory.add(niceScore);
    }

    /**
     * Method for computing this child's average score.
     */
    public void computeAverageScore() {
        if (ageCategory.equals(AgeCategory.BABY)) {
            this.averageScore = Constants.BABY_AVERAGE_SCORE;
        } else if (ageCategory.equals(AgeCategory.KID)) {
            double sum = 0;
            for (Double niceScore : niceScoreHistory) {
                sum += niceScore;
            }
            this.averageScore = sum / niceScoreHistory.size();
        } else if (ageCategory.equals(AgeCategory.TEEN)) {
            double sum = 0;
            int index = 1;
            int indexSum = 0;
            for (Double niceScore : niceScoreHistory) {
                sum += niceScore * index;
                indexSum += index;
                index++;
            }
            this.averageScore = sum / indexSum;
        } else if (ageCategory.equals(AgeCategory.YOUNG_ADULT)) {
            this.averageScore = 0d;
        }
        this.averageScore += this.averageScore * this.niceScoreBonus / Constants.DEN;
        if (this.averageScore > Constants.MAX_AVERAGE_SCORE) {
            this.averageScore = Constants.MAX_AVERAGE_SCORE;
        }
    }

    /**
     * @param budgetUnit for the current year.
     */
    public void computeAssignedBudget(final Double budgetUnit) {
        this.assignedBudget = this.averageScore * budgetUnit;
        if (this.childInfo.getElf().equals(ElvesType.BLACK)) {
            this.assignedBudget = this.assignedBudget
                    - this.assignedBudget * Constants.NUM / Constants.DEN;
        } else if (this.getChildInfo().getElf().equals(ElvesType.PINK)) {
            this.assignedBudget = this.assignedBudget
                    + this.assignedBudget * Constants.NUM / Constants.DEN;
        }
    }

    // Getters and Setters

    /**
     * @param gift to be received.
     */
    public void receiveGift(final Gift gift) {
        this.receivedGifts.add(gift);
    }

    /**
     * @param gift to be received this round.
     */
    public void receiveThisRound(final Gift gift) {
        this.receivedThisRound.add(gift);
    }

    /**
     * @return childInfo
     */
    public ChildInfo getChildInfo() {
        return childInfo;
    }

    /**
     * @return ageCategory
     */
    public AgeCategory getAgeCategory() {
        return ageCategory;
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

    /**
     * @return receivedThisRound
     */
    public List<Gift> getReceivedThisRound() {
        return receivedThisRound;
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
}
