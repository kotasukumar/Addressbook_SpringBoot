package com.bridelabz.AddressBook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "Build")
@NoArgsConstructor
public class Login {
    private String userName;
    private String password;
}
