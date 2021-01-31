package com.compassouol.demo.advices;

import com.compassouol.demo.dtos.ApiErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class HttpMessageNotReadableExceptionAdvices {
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
    ApiErrorDto httpMessageNotReadableExceptionAdvicesHandle(HttpMessageNotReadableException e) {
        return ApiErrorDto.builder().status(HttpStatus.UNPROCESSABLE_ENTITY).timestamp(LocalDateTime.now()).message(e.getMessage()).build();
    }
}
