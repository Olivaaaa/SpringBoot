package com.example.globalexception.web;

import com.example.globalexception.exception.ErrorMessage;
import com.example.globalexception.exception.MineException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionController {

    public static final String DEFAULT_ERROR_VIEW = "error";

    //捕捉自定义异常，返回json信息
    @ExceptionHandler(value = MineException.class)
    @ResponseBody
    public ErrorMessage<Object> ErrorHandler(HttpServletRequest request, MineException e) throws Exception {
        ErrorMessage<Object> error = new ErrorMessage<>();
        error.setCode(404);
        error.setMessage("Not Found Exception");
        error.setUrl(request.getRequestURL().toString());
        error.setData("");
        return error;
    }

    @ExceptionHandler(value = ArithmeticException.class)
    @ResponseBody
    public ErrorMessage<Object> ErrorHandler(HttpServletRequest request, ArithmeticException e) throws Exception {
        ErrorMessage<Object> error = new ErrorMessage<>();
        error.setCode(405);
        error.setMessage("方法不被允许");
        error.setUrl(request.getRequestURL().toString());
        error.setData(e);
        return error;

    }

    @ExceptionHandler(value = Exception.class)
    public ModelAndView ErrorHandler(HttpServletRequest request, Exception e) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        ErrorMessage<Exception> error = new ErrorMessage<>();
        error.setCode(400);
        error.setMessage("系统异常");
        error.setUrl(request.getRequestURI());
        error.setData(e);
        modelAndView.addObject(error);
        modelAndView.setViewName(DEFAULT_ERROR_VIEW);
        return modelAndView;


    }
}
