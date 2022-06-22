package com.bridelabz.AddressBook.dto;

public class ReasponseDTO {
    private String message;
    private Object contactData;

    public ReasponseDTO(String message, Object contactData) {
        this.message = message;
        this.contactData = contactData;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getContactData() {
        return contactData;
    }

    public void setContactData(Object contactData) {
        this.contactData = contactData;
    }
}
