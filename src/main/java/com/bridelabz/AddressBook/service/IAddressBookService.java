package com.bridelabz.AddressBook.service;

import com.bridelabz.AddressBook.dto.AddressBookDTO;
import com.bridelabz.AddressBook.model.AddressBookData;

import java.util.List;
import java.util.Optional;

public interface IAddressBookService {

    List<AddressBookData> getContact();

    AddressBookData getContactByName(String name);

    AddressBookData createContact(String name, AddressBookDTO addressBookDTO);

    AddressBookData updateContact(String name, AddressBookDTO addressBookDTO);

    void deleteContact(String name);
}
