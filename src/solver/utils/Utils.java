package solver.utils;

import common.Constants;
import enums.AgeCategory;
import enums.Category;
import solver.database.ChildUpdate;
import solver.database.Gift;
import solver.simulate.Child;
import solver.simulate.output.ChildOutputInfo;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public final class Utils {

    /**
     * For coding style
     */
    private Utils() {
    }

    /**
     * @param category of the gift to be returned
     * @param santaGiftsList - list containing Santa's gifts
     * @return the cheapest gift from this category
     */
    public static Gift getGiftByCategory(final Category category,
                                         final List<Gift> santaGiftsList,
                                         final boolean yellowElf) {
        Double minPrince = Double.MAX_VALUE;
        Map<Gift, Double> giftsMap = new HashMap<>();
        for (Gift g : santaGiftsList) {
            if (g.getCategory().equals(category)) {
                if (yellowElf && g.getPrice() < minPrince) {
                    minPrince = g.getPrice();
                } else if (g.getPrice() < minPrince && g.getQuantity() > 0) {
                    minPrince = g.getPrice();
                }
                giftsMap.put(g, g.getPrice());

            }
        }

        for (Map.Entry<Gift, Double> entry : giftsMap.entrySet()) {
            if (entry.getValue().equals(minPrince)) {
                    return entry.getKey();
            }
        }
        return null;
    }

    /**
     * Increment the age of every child after every year simulation
     * @param children list
     */
    public static void incrementAge(final List<Child> children) {
        children.forEach(c -> c.getChildInfo().setAge(c.getChildInfo().getAge() + 1));
        children.forEach(Child::computeAgeCategory);
        children.removeIf(c -> c.getAgeCategory().equals(AgeCategory.YOUNG_ADULT));
    }

    /**
     * @param children list
     * @param id of the child to be retured
     * @return the child if he/she exists in the children list
     */
    public static Child getChildIfExists(final List<Child> children, final Integer id) {
        for (Child c : children) {
            if (c.getChildInfo().getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    /**
     * @param childUpdate information
     * @param child for which the updates to be applied on
     */
    public static void updateChildInfo(final ChildUpdate childUpdate, final Child child) {
        if (childUpdate.getNiceScore() != null) {
            child.addNewNiceScore(childUpdate.getNiceScore());
        }
        ListIterator<Category> iterator = childUpdate.getGiftsPreferences().
                listIterator(childUpdate.getGiftsPreferences().size());
        while (iterator.hasPrevious()) {
            Category category = iterator.previous();
            child.getChildInfo().getGiftsPreferences().remove(category);
            child.getChildInfo().getGiftsPreferences().add(0, category);
        }
        child.getChildInfo().setElf(childUpdate.getElf());
    }

    /**
     * If this child received gifts in the current year simulation,
     * then output information will be generated.
     * @param c for which the output information to be created
     * @return output information for this child
     */
    public static ChildOutputInfo createChildOutput(final Child c) {
        if (c.getChildInfo().getAge() <= Constants.TEEN_UPPER_LIMIT) {
            return new ChildOutputInfo(c.getChildInfo().getId(),
                    c.getChildInfo().getLastName(), c.getChildInfo().getFirstName(),
                    c.getChildInfo().getCity(), c.getChildInfo().getAge(),
                    c.getChildInfo().getGiftsPreferences(), c.getAverageScore(),
                    c.getNiceScoreHistory(), c.getAssignedBudget(), c.getReceivedThisRound());
        }
        return null;
    }
}
