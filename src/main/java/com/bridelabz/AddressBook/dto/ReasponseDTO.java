package com.bridelabz.AddressBook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "Build")
@NoArgsConstructor
public class ReasponseDTO {
    private String message;
    private Object contactData;
}
