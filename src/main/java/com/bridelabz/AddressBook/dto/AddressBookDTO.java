package com.bridelabz.AddressBook.dto;

public class AddressBookDTO {
    public String address;
    public String city;
    public String state;
    public long pinCode;
    public long mobileNumber;
    public String email;

    public AddressBookDTO(String address, String city, String state, long pinCode, long mobileNumber, String email) {
        this.address = address;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }
}
