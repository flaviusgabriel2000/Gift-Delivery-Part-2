package enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum AgeCategory {
    @JsonProperty("Baby")
    BABY("Baby"),

    @JsonProperty("Kid")
    KID("Kid"),

    @JsonProperty("Teen")
    TEEN("Teen"),

    @JsonProperty("Young Adult")
    YOUNG_ADULT("Young Adult");

    private final String value;

    AgeCategory(final String value) {
        this.value = value;
    }
}
