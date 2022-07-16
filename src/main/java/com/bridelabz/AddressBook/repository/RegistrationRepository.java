package com.bridelabz.AddressBook.repository;

import com.bridelabz.AddressBook.model.AddressBookData;
import com.bridelabz.AddressBook.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, String> {
    Registration findById(int id);
}
