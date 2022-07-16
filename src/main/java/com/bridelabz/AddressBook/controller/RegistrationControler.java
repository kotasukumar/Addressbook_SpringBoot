package com.bridelabz.AddressBook.controller;

import com.bridelabz.AddressBook.dto.ReasponseDTO;
import com.bridelabz.AddressBook.dto.RegistrationDTO;
import com.bridelabz.AddressBook.repository.RegistrationRepository;
import com.bridelabz.AddressBook.service.IRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping("/registration")
public class RegistrationControler {

    @Autowired
    IRegistrationService iRegistrationService;

    @GetMapping("/getallusers")
    public ResponseEntity<ReasponseDTO> getALlUsers(){
        ReasponseDTO reasponseDTO = ReasponseDTO.Build("Get call is success", iRegistrationService.getAllUser());
        return new ResponseEntity<>(reasponseDTO, HttpStatus.OK);
    }

    @PostMapping("/adduser")
    public ResponseEntity<ReasponseDTO> addUser(@RequestBody RegistrationDTO registrationDTO){
        ReasponseDTO reasponseDTO = ReasponseDTO.Build("Post call success", iRegistrationService.addUser(registrationDTO));
        return new ResponseEntity<>(reasponseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ReasponseDTO> updateUser(@PathVariable ("id") int id, @RequestBody RegistrationDTO registrationDTO){
        ReasponseDTO reasponseDTO = ReasponseDTO.Build("put method success", iRegistrationService.updateUser(id, registrationDTO));
        return new ResponseEntity<>(reasponseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/deleteuser/{id}")
    public ResponseEntity<ReasponseDTO>deleteUser(@PathVariable ("id") int id){
        iRegistrationService.deleteUser(id);
        ReasponseDTO reasponseDTO = ReasponseDTO.Build("Delete method success", "Deleted user id is:"  + id);
        return new ResponseEntity<>(reasponseDTO, HttpStatus.OK);
    }

    @GetMapping("/getuserbyid/{id}")
    public ResponseEntity<ReasponseDTO> getUserById(@PathVariable ("id") int id){
        ReasponseDTO reasponseDTO = ReasponseDTO.Build("Get call by id success", iRegistrationService.getUserById(id));
        return new ResponseEntity<>(reasponseDTO, HttpStatus.OK);
    }
}
