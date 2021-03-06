package com.bridelabz.AddressBook.service;

import com.bridelabz.AddressBook.dto.AddressBookDTO;
import com.bridelabz.AddressBook.exception.AddressBookExecption;
import com.bridelabz.AddressBook.model.AddressBookData;

import java.util.List;

public interface IAddressBookService {

    List<AddressBookData> getContact();

    AddressBookData getContactByName(String name) throws AddressBookExecption;

    AddressBookData getContactById(int id);

    AddressBookData createContact(AddressBookDTO addressBookDTO);

    AddressBookData updateContact(int id, AddressBookDTO addressBookDTO);

    void deleteContact(int id);

    List<AddressBookData> getAddresses();

    List<AddressBookData> sortAddressBy(String field);
}
