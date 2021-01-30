package com.compassouol.demo.advices;

import com.compassouol.demo.dtos.ApiErrorDto;
import com.compassouol.demo.exceptions.CityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestControllerAdvice
public class CityNotFoundAdvice {


    @ExceptionHandler(CityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ApiErrorDto cityNotFoundAdviceHandle(CityNotFoundException c){
        return ApiErrorDto.builder().status(HttpStatus.NOT_FOUND).timestamp(LocalDateTime.now()).message(c.getMessage()).build();
    }
}
