package com.bridelabz.AddressBook.service;

import com.bridelabz.AddressBook.dto.LoginDTO;

public interface ILogin {
    boolean loginCheck(LoginDTO loginDTO);
}
