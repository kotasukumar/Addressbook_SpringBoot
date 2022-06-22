package com.bridelabz.AddressBook.exception;

import com.bridelabz.AddressBook.dto.ReasponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExecptionHadler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ReasponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
        List<String> errMesg = errorList.stream().map(objectError -> objectError.getDefaultMessage()).collect(Collectors.toList());
        ReasponseDTO responseDTO = ReasponseDTO.Build("Exception While processing REST Request", errMesg);
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AddressBookExecption.class)
    public ResponseEntity<ReasponseDTO> handleMethodAddressbookException(AddressBookExecption exception){
        ReasponseDTO responseDTO = ReasponseDTO.Build("Exception While processing REST Request",exception.getMessage());
        return new ResponseEntity<>(responseDTO,HttpStatus.BAD_REQUEST);
    }
}
