package com.compassouol.demo.advices;

import com.compassouol.demo.dtos.ApiErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestControllerAdvice
public class FieldsExceptionsAdvices {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value= HttpStatus.UNPROCESSABLE_ENTITY)
    ApiErrorDto fieldsExceptionsAdvicesHandle(MethodArgumentNotValidException m){
        StringBuilder message = new StringBuilder("");
        m.getBindingResult().getFieldErrors().forEach( fieldError ->
                message.append(fieldError.getField()).append(" : ").append(fieldError.getDefaultMessage()).append(" | "));
        return ApiErrorDto.builder().status(HttpStatus.UNPROCESSABLE_ENTITY).timestamp(LocalDateTime.now()).message(message.toString()).build();
    }
}
