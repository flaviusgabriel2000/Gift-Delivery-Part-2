package solver.database;

import com.fasterxml.jackson.annotation.JsonProperty;
import enums.Category;

public class Gift {
    /**
     * Name of the gift.
     */
    private String productName;
    /**
     * Price of the gift.
     */
    private Double price;
    /**
     * Category of the gift.
     */
    private Category category;
    /**
     * Quantity of this gift.
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer quantity;

    /**
     * For coding style
     */
    public Gift() {
    }

    // Getters and Setters

    /**
     * @return productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName to be set
     */
    public void setProductName(final String productName) {
        this.productName = productName;
    }

    /**
     * @return price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price to be set
     */
    public void setPrice(final Double price) {
        this.price = price;
    }

    /**
     * @return category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * @param category to be set
     */
    public void setCategory(final Category category) {
        this.category = category;
    }

    /**
     * @return quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity to be set
     */
    public void setQuantity(final Integer quantity) {
        this.quantity = quantity;
    }
}
