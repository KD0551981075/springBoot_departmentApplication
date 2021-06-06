package com.springBoot.application.error;

import com.springBoot.application.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class DepartmentResponseEntityException extends ResponseEntityExceptionHandler
{
    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorMessage> departmentIDNotFoundException(DepartmentNotFoundException exception, WebRequest status)
    {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());

        return  ResponseEntity.status(HttpStatus.ACCEPTED).body(errorMessage);


    }


}
