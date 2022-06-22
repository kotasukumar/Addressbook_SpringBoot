package com.bridelabz.AddressBook.service;

import com.bridelabz.AddressBook.dto.AddressBookDTO;
import com.bridelabz.AddressBook.exception.AddressBookExecption;
import com.bridelabz.AddressBook.model.AddressBookData;
import com.bridelabz.AddressBook.repository.AddressbookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AddressBookService implements IAddressBookService{

    @Autowired
    private AddressbookRepository addressbookRepository;

    List<AddressBookData> addressBookDataList = new ArrayList<>();

    @Override
    public List<AddressBookData> getContact() {
        return addressbookRepository.findAll();
    }

    @Override
    public AddressBookData getContactById(int id){
        return addressbookRepository.findById(id);
    }

    @Override
    public AddressBookData getContactByName(String name)throws AddressBookExecption {
        AddressBookData addressBookData = addressbookRepository.findByName(name);
        if(addressBookData != null){
            return addressBookData;
        }else {
            throw new AddressBookExecption("User not found" + name);
        }
    }

    @Override
    public AddressBookData createContact(AddressBookDTO addressBookDTO) {
        AddressBookData addressBook = AddressBookData.
                Build(0,addressBookDTO.getName(), addressBookDTO.getAddress(), addressBookDTO.getCity(), addressBookDTO.state,
                        addressBookDTO.getPinCode(), addressBookDTO.getMobileNumber(), addressBookDTO.getEmail());
        return addressbookRepository.save(addressBook);
    }

    @Override
    public List<AddressBookData> getAddresses() {
        return addressbookRepository.findAll();
    }

    @Override
    public AddressBookData updateContact(int id, AddressBookDTO addressBookDTO) {
        List<AddressBookData> dataList = this.getAddresses();
        for (AddressBookData addressBook : dataList ) {
            if(addressBook.getId() == id) {
                addressBook.setName(addressBookDTO.getName());
                addressBook.setMobileNumber(addressBookDTO.getMobileNumber());
                addressBook.setEmail(addressBookDTO.getEmail());
                addressBook.setPinCode(addressBookDTO.getPinCode());
                addressBook.setAddress(addressBookDTO.getAddress());
                addressBook.setState(addressBookDTO.getState());
                addressBook.setCity(addressBookDTO.getCity());
                return addressbookRepository.save(addressBook);
            }
        }
        return null;
    }

    @Override
    public void deleteContact(String name) {
        AddressBookData addressBookData = this.getContactByName(name);
        addressbookRepository.delete(addressBookData);
    }
}
