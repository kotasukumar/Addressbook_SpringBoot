package com.bridelabz.AddressBook.repository;

import com.bridelabz.AddressBook.model.AddressBookData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressbookRepository extends JpaRepository<AddressBookData, String> {
    AddressBookData findByName(String name);

    AddressBookData findById(int id);
}
