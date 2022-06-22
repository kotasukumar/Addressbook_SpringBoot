package com.bridelabz.AddressBook.controller;

import com.bridelabz.AddressBook.dto.AddressBookDTO;
import com.bridelabz.AddressBook.dto.ReasponseDTO;
import com.bridelabz.AddressBook.model.AddressBookData;
import com.bridelabz.AddressBook.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private IAddressBookService iAddressBookService;

    @RequestMapping(value = {"", "/", "/home"})
    public ResponseEntity<ReasponseDTO> getContacts(){
        List<AddressBookData> addressBookData = iAddressBookService.getContact();
        ReasponseDTO reasponseDTO = new ReasponseDTO("Get call success", addressBookData);
        return new ResponseEntity<ReasponseDTO>(reasponseDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/get/{name}")
    public ResponseEntity<ReasponseDTO> getContactByName(@PathVariable("name") String name){
        AddressBookData addressBookData = iAddressBookService.getContactByName(name);
        ReasponseDTO reasponseDTO = new ReasponseDTO("Get function success", addressBookData);
        return new ResponseEntity<ReasponseDTO>(reasponseDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/create/{name}")
    public ResponseEntity<ReasponseDTO> createContact(@PathVariable("name")String name, @RequestBody @Valid AddressBookDTO addressBookDTO){
        AddressBookData addressBookData = iAddressBookService.createContact(name, addressBookDTO);
        ReasponseDTO reasponseDTO = new ReasponseDTO("Created successfully", addressBookData);
        return new ResponseEntity<ReasponseDTO>(reasponseDTO, HttpStatus.OK);
    }

    @PutMapping("/put/{name}")
    public ResponseEntity<ReasponseDTO> updateContact(@PathVariable("name") String name, @RequestBody @Valid AddressBookDTO addressBookDTO){
        AddressBookData addressBookData = iAddressBookService.updateContact(name, addressBookDTO);
        ReasponseDTO reasponseDTO  = new ReasponseDTO("Updated successfully", addressBookData);
        return new ResponseEntity<ReasponseDTO>(reasponseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<ReasponseDTO> deleteContact(@PathVariable("name")String name){
        iAddressBookService.deleteContact(name);
        ReasponseDTO reasponseDTO = new ReasponseDTO("deleted successfully", name);
        return new ResponseEntity<ReasponseDTO>(reasponseDTO, HttpStatus.OK);
    }
}
