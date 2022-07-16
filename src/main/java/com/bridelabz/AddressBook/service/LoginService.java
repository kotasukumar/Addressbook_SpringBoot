package com.bridelabz.AddressBook.service;

import com.bridelabz.AddressBook.dto.LoginDTO;
import com.bridelabz.AddressBook.model.Registration;
import com.bridelabz.AddressBook.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService implements ILogin{

    @Autowired
    RegistrationRepository registrationRepository;

    @Override
    public boolean loginCheck(LoginDTO loginDTO) {
        List<Registration> registrationList = registrationRepository.findAll();
        for (Registration registration : registrationList) {
            if ((registration.getUserName().equals(loginDTO.userName)) && (registration.getPassword().equals(loginDTO.getPassword()))) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
