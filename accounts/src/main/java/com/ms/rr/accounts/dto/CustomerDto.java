package com.ms.rr.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Schema(
        name = "Customer",
        description = "Schema to hold Customer and Account information"
)
public class CustomerDto {

    @NotEmpty(message = "Name can not be empty")
    @Size(min = 5, max = 30, message = "The length of th customer name should be between 5 and 30")
    @Schema(
            description = "Name of the customer", example = "Son Goku"
    )
    private String name;

    @NotEmpty
    @Email(message = "Email address should be a valid value")
    @Schema(
            description = "Email of the customer", example = "goku@email.com"
    )
    private String email;

    @Pattern(regexp ="(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    @Schema(
            description = "Mobile Number of the customer", example = "9345432123"
    )
    private String mobileNumber;


    private AccountDto accountDto;

    public CustomerDto() {
    }

    public CustomerDto(String name, String email, String mobileNumber, AccountDto accountDto) {
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.accountDto = accountDto;
    }

    public CustomerDto(String name, String email, String mobileNumber) {
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public AccountDto getAccountDto() {
        return accountDto;
    }

    public void setAccountDto(AccountDto accountDto) {
        this.accountDto = accountDto;
    }
}
