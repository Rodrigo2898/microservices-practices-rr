package com.ms.rr.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Schema(name = "Cards",
        description = "Schema to hold Card information"
)
public class CardsDto {

    @NotEmpty(message = "Mobile Number can not be a null or empty")
    @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile Number must be 10 digits")
    @Schema(
            description = "Mobile Number of Customer", example = "4354437687"
    )
    private String mobileNumber;

    @NotEmpty(message = "Card Number can not be a null or empty")
    @Pattern(regexp="(^$|[0-9]{12})",message = "CardNumber must be 12 digits")
    @Schema(
            description = "Card Number of the customer", example = "100646930341"
    )
    private String cardNumber;

    @NotEmpty(message = "CardType can not be a null or empty")
    @Schema(
            description = "Type of the card", example = "Credit Card"
    )
    private String cardType;

    @Positive(message = "Total card limit should be greater than zero")
    @Schema(
            description = "Total amount limit available against a card", example = "100000"
    )
    private int totalLimit;

    @PositiveOrZero(message = "Total amount used should be equal or greater than zero")
    @Schema(
            description = "Total amount used by a Customer", example = "1000"
    )
    private int amountUsed;

    @PositiveOrZero(message = "Total available amount should be equal or greater than zero")
    @Schema(
            description = "Total available amount against a card", example = "90000"
    )
    private int availableAmount;

    public CardsDto() {
    }

    public CardsDto(String mobileNumber, String cardNumber, String cardType, int totalLimit, int amountUsed, int availableAmount) {
        this.mobileNumber = mobileNumber;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.totalLimit = totalLimit;
        this.amountUsed = amountUsed;
        this.availableAmount = availableAmount;
    }

    public @NotEmpty(message = "Mobile Number can not be a null or empty") @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Number must be 10 digits") String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(@NotEmpty(message = "Mobile Number can not be a null or empty") @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Number must be 10 digits") String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public @NotEmpty(message = "Card Number can not be a null or empty") @Pattern(regexp = "(^$|[0-9]{12})", message = "CardNumber must be 12 digits") String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(@NotEmpty(message = "Card Number can not be a null or empty") @Pattern(regexp = "(^$|[0-9]{12})", message = "CardNumber must be 12 digits") String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public @NotEmpty(message = "CardType can not be a null or empty") String getCardType() {
        return cardType;
    }

    public void setCardType(@NotEmpty(message = "CardType can not be a null or empty") String cardType) {
        this.cardType = cardType;
    }

    @Positive(message = "Total card limit should be greater than zero")
    public int getTotalLimit() {
        return totalLimit;
    }

    public void setTotalLimit(@Positive(message = "Total card limit should be greater than zero") int totalLimit) {
        this.totalLimit = totalLimit;
    }

    @PositiveOrZero(message = "Total amount used should be equal or greater than zero")
    public int getAmountUsed() {
        return amountUsed;
    }

    public void setAmountUsed(@PositiveOrZero(message = "Total amount used should be equal or greater than zero") int amountUsed) {
        this.amountUsed = amountUsed;
    }

    @PositiveOrZero(message = "Total available amount should be equal or greater than zero")
    public int getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(@PositiveOrZero(message = "Total available amount should be equal or greater than zero") int availableAmount) {
        this.availableAmount = availableAmount;
    }
}