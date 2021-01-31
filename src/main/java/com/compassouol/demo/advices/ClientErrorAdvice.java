package com.compassouol.demo.advices;

import com.compassouol.demo.dtos.ApiErrorDto;
import com.compassouol.demo.exceptions.ClientException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice
public class ClientErrorAdvice {

    @ResponseBody
    @ExceptionHandler(ClientException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ApiErrorDto clientErrorAdviceHandle(ClientException c) {
        return ApiErrorDto.builder().status(HttpStatus.BAD_REQUEST).timestamp(LocalDateTime.now()).message(c.getMessage()).build();
    }

}
