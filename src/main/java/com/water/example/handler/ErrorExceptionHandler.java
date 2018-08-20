package com.water.example.handler;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice
public class ErrorExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView processExeption(RuntimeException exception){
        ModelAndView view = new ModelAndView("error/500");
        exception.printStackTrace();
        view.addObject("exceptionMessage",exception.getMessage());
        return view;
    }


    @ExceptionHandler({ Exception.class })
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView processException(Exception exception) {

        ModelAndView modelAndView = new ModelAndView("error/500");
        modelAndView.addObject("localizedMessage", exception.getLocalizedMessage())
                .addObject("exceptionMessage", exception.getMessage())
                .addObject("stackTrace", exception.getStackTrace());
        return modelAndView;
    }
}
