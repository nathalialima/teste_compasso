package com.compassouol.demo.advices;

import com.compassouol.demo.dtos.ApiErrorDto;
import com.compassouol.demo.exceptions.CityException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice
public class CityErrorAdvice {

    @ResponseBody
    @ExceptionHandler(CityException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ApiErrorDto cityErrorAdviceHandle(CityException c) {
        return ApiErrorDto.builder().status(HttpStatus.BAD_REQUEST).timestamp(LocalDateTime.now()).message(c.getMessage()).build();
    }

}
