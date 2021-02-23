package com.etimokhov.clients.controller;


import com.etimokhov.clients.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = NotFoundException.class)
    public String notFoundErrorHandler(HttpServletRequest req, Exception e, Model model) {
        model.addAttribute("errorMessage", "404. Запрашиваемая страница или объект не существует.");
        return "error";
    }
}
