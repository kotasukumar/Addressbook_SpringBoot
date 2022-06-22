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
        ReasponseDTO reasponseDTO = ReasponseDTO.Build("Get call success", addressBookData);
        return new ResponseEntity<ReasponseDTO>(reasponseDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<ReasponseDTO> getContactByName(@PathVariable("id") int id){
        AddressBookData addressBookData = iAddressBookService.getContactById(id);
        ReasponseDTO reasponseDTO = ReasponseDTO.Build("Get function success", addressBookData);
        return new ResponseEntity<ReasponseDTO>(reasponseDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<ReasponseDTO> createContact(@RequestBody @Valid AddressBookDTO addressBookDTO){
        AddressBookData addressBookData = iAddressBookService.createContact(addressBookDTO);
        ReasponseDTO reasponseDTO = ReasponseDTO.Build("Created successfully", addressBookData);
        return new ResponseEntity<ReasponseDTO>(reasponseDTO, HttpStatus.OK);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<ReasponseDTO> updateContact(@PathVariable("id") int id, @RequestBody @Valid AddressBookDTO addressBookDTO){
        AddressBookData addressBookData = iAddressBookService.updateContact(id, addressBookDTO);
        ReasponseDTO reasponseDTO  = ReasponseDTO.Build("Updated successfully", addressBookData);
        return new ResponseEntity<ReasponseDTO>(reasponseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<ReasponseDTO> deleteContact(@PathVariable("name")String name){
        iAddressBookService.deleteContact(name);
        ReasponseDTO reasponseDTO = ReasponseDTO.Build("deleted successfully", name);
        return new ResponseEntity<ReasponseDTO>(reasponseDTO, HttpStatus.OK);
    }
}
