package com.geforce.web.controller;

import com.geforce.exception.UserNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author geforce
 * @date 2017/11/8
 */

@ControllerAdvice
public class ControllerExceptionHandler {


    @ExceptionHandler(UserNotExistException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,Object> handleUserNotExistException(UserNotExistException ex){
        Map<String ,Object> result = new HashMap<>(2);
        result.put("id",ex.getId());
        result.put("message",ex.getMessage());
        return result;
    }

}
