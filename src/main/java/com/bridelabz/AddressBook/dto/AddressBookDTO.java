package com.bridelabz.AddressBook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressBookDTO {

    @NotNull(message = "User name should not null")
    @NotBlank
    public String name;

    @NotNull(message = "address should not null")
    public String address;

    @NotNull(message = "city name should not null")
    public String city;

    @NotNull(message = "state should not null")
    public String state;

    @NotNull(message = "pin code should not null")
    public String pinCode;

    @NotNull(message = "mobile number should not null")
    public String mobileNumber;

    @NotNull(message = "User name should not null")
    public String email;
}
