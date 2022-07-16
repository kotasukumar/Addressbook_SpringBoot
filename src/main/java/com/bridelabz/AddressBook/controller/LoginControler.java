package com.bridelabz.AddressBook.controller;

import com.bridelabz.AddressBook.dto.LoginDTO;
import com.bridelabz.AddressBook.dto.ReasponseDTO;
import com.bridelabz.AddressBook.repository.RegistrationRepository;
import com.bridelabz.AddressBook.service.ILogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping("/addressbook/login")
public class LoginControler {

    @Autowired
    private ILogin iLogin;

    @PostMapping
    public ResponseEntity<ReasponseDTO> checkLogin(@RequestBody LoginDTO loginDTO){
        ReasponseDTO reasponseDTO = ReasponseDTO.Build("post call success", iLogin.loginCheck(loginDTO));
        return new ResponseEntity<>(reasponseDTO, HttpStatus.OK);
    }
}
