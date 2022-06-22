package com.bridelabz.AddressBook.model;

import com.bridelabz.AddressBook.dto.AddressBookDTO;

public class AddressBookData {
    private String name;
    private String address;
    private String city;
    private String state;
    private long pinCode;
    private long mobileNumber;
    private String email;

    public AddressBookData(String name, AddressBookDTO addressBookDTO) {
        this.name = name;
        this.address = addressBookDTO.address;
        this.city = addressBookDTO.city;
        this.state = addressBookDTO.state;
        this.pinCode = addressBookDTO.pinCode;
        this.mobileNumber = addressBookDTO.mobileNumber;
        this.email = addressBookDTO.email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getPinCode() {
        return pinCode;
    }

    public void setPinCode(long pinCode) {
        this.pinCode = pinCode;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void updateAddressBookData(AddressBookDTO addressbookDTO) {
        this.address  = addressbookDTO.address;
        this.city = addressbookDTO.city;
        this.state = addressbookDTO.state;
        this.pinCode = addressbookDTO.pinCode;
        this.mobileNumber = addressbookDTO.mobileNumber;
        this.email = addressbookDTO.email;
    }
}
