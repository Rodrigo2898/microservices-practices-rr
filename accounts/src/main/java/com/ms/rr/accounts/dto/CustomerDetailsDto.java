package com.ms.rr.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name = "CustomerDetails",
        description = "Schema to hold Customer, Account, Cards and Loans information"
)
public class CustomerDetailsDto {

    @Schema(
            description = "Name of the customer", example = "Eazy Bytes"
    )
    @NotEmpty(message = "Name can not be a null or empty")
    @Size(min = 5, max = 30, message = "The length of the customer name should be between 5 and 30")
    private String name;

    @Schema(
            description = "Email address of the customer", example = "tutor@eazybytes.com"
    )
    @NotEmpty(message = "Email address can not be a null or empty")
    @Email(message = "Email address should be a valid value")
    private String email;

    @Schema(
            description = "Mobile Number of the customer", example = "9345432123"
    )
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @Schema(
            description = "Account details of the Customer"
    )
    private AccountDto accountsDto;

    @Schema(
            description = "Loans details of the Customer"
    )
    private LoansDto loansDto;

    @Schema(
            description = "Cards details of the Customer"
    )
    private CardsDto cardsDto;

    public @NotEmpty(message = "Name can not be a null or empty") @Size(min = 5, max = 30, message = "The length of the customer name should be between 5 and 30") String getName() {
        return name;
    }

    public void setName(@NotEmpty(message = "Name can not be a null or empty") @Size(min = 5, max = 30, message = "The length of the customer name should be between 5 and 30") String name) {
        this.name = name;
    }

    public @NotEmpty(message = "Email address can not be a null or empty") @Email(message = "Email address should be a valid value") String getEmail() {
        return email;
    }

    public void setEmail(@NotEmpty(message = "Email address can not be a null or empty") @Email(message = "Email address should be a valid value") String email) {
        this.email = email;
    }

    public @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits") String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(@Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits") String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public AccountDto getAccountsDto() {
        return accountsDto;
    }

    public void setAccountsDto(AccountDto accountsDto) {
        this.accountsDto = accountsDto;
    }

    public LoansDto getLoansDto() {
        return loansDto;
    }

    public void setLoansDto(LoansDto loansDto) {
        this.loansDto = loansDto;
    }

    public CardsDto getCardsDto() {
        return cardsDto;
    }

    public void setCardsDto(CardsDto cardsDto) {
        this.cardsDto = cardsDto;
    }
}