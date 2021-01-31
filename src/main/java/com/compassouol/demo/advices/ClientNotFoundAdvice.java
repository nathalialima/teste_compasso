package com.compassouol.demo.advices;

import com.compassouol.demo.dtos.ApiErrorDto;
import com.compassouol.demo.exceptions.ClientNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ClientNotFoundAdvice {

    @ExceptionHandler(ClientNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ApiErrorDto clientNotFoundAdviceHandle(ClientNotFoundException c) {
        return ApiErrorDto.builder().status(HttpStatus.NOT_FOUND).timestamp(LocalDateTime.now()).message(c.getMessage()).build();
    }
}
