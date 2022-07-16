package com.bridelabz.AddressBook.service;

import com.bridelabz.AddressBook.dto.RegistrationDTO;
import com.bridelabz.AddressBook.model.Registration;
import com.bridelabz.AddressBook.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistationService implements IRegistrationService{

    @Autowired
    private RegistrationRepository registrationRepository;

    @Override
    public Registration addUser(RegistrationDTO registrationDTO) {
        Registration registration = Registration.Built(0, registrationDTO.getUserName(), registrationDTO.getEmailID(), registrationDTO.getPassword());
        return registrationRepository.save(registration);
    }

    @Override
    public List<Registration> getAllUser() {
        return registrationRepository.findAll();
    }

    @Override
    public Registration getUserById(int id){
        return registrationRepository.findById(id);
    }

    @Override
    public void deleteUser(int id) {
        registrationRepository.delete(this.getUserById(id));

    }

    @Override
    public Registration updateUser(int id, RegistrationDTO registrationDTO) {
        List<Registration> registrationList = this.getAllUser();
        for (Registration registration : registrationList){
            if (registration.getId() == id){
                registration.setUserName(registrationDTO.getUserName());
                registration.setEmailID(registrationDTO.getEmailID());
                registration.setPassword(registrationDTO.getPassword());
                return registrationRepository.save(registration);
            }
        }
        return null;
    }
}
