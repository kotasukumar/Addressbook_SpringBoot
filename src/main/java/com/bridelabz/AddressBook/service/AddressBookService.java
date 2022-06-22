package com.bridelabz.AddressBook.service;

import com.bridelabz.AddressBook.dto.AddressBookDTO;
import com.bridelabz.AddressBook.model.AddressBookData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService{

    List<AddressBookData> addressBookDataList = new ArrayList<>();

    @Override
    public List<AddressBookData> getContact() {
        return addressBookDataList;
    }

    @Override
    public AddressBookData getContactByName(String name) {
        for (AddressBookData addressBookData : addressBookDataList) {
            if (addressBookData.getName().equals(name)){
                return addressBookData;
            }
        }
        return null;
    }

    @Override
    public AddressBookData createContact(String name, AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = new AddressBookData(name, addressBookDTO);
        addressBookDataList.add(addressBookData);
        return addressBookData;
    }

    @Override
    public AddressBookData updateContact(String name, AddressBookDTO addressBookDTO) {
        for (AddressBookData addressBookData : addressBookDataList) {
            if (addressBookData.getName().equals(name)){
                addressBookData.setAddress(addressBookDTO.address);
                addressBookData.setCity(addressBookDTO.city);
                addressBookData.setState(addressBookDTO.state);
                addressBookData.setPinCode(addressBookDTO.pinCode);
                addressBookData.setMobileNumber(addressBookDTO.mobileNumber);
                addressBookData.setEmail(addressBookDTO.email);
                return addressBookData;
            }
        }
        return null;
    }

    @Override
    public void deleteContact(String name) {
        AddressBookData addressBookData = this.getContactByName(name);
        addressBookDataList.remove(addressBookData);
    }
}
