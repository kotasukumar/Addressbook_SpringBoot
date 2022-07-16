package com.bridelabz.AddressBook.service;

import com.bridelabz.AddressBook.dto.RegistrationDTO;
import com.bridelabz.AddressBook.model.Registration;

import java.util.List;

public interface IRegistrationService {

    Registration addUser(RegistrationDTO registrationDTO);

    List<Registration> getAllUser();

    void deleteUser(int id);

    Registration updateUser(int id, RegistrationDTO registrationDTO);

    Registration getUserById(int id);
}
