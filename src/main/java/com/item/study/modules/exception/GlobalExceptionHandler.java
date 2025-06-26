package com.item.study.modules.exception;

import com.item.study.model.result.ResultBody;
import jakarta.el.MethodNotFoundException;
import org.springframework.beans.MethodInvocationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.MethodNotAllowedException;

import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;


/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc: 全局错误处理
 */

//@RestControllerAdvice
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = AppException.class)
    public ResultBody handleCustomError(AppException e) {
        System.out.println("---> AppException");
        return ResultBody.fail(e);
    }

    @ResponseBody
    @ExceptionHandler(value = BindException.class)
    public ResultBody handleBindError(BindException e) {
        String msg = e.getMessage();
        System.out.println("---> handleBindError");
        if (e instanceof MethodArgumentNotValidException) {
            BindingResult bindingResult = e.getBindingResult();
            if (bindingResult.hasErrors()) {
                FieldError fieldError = bindingResult.getFieldError();
                if (fieldError != null) {
                    msg = fieldError.getField() + fieldError.getDefaultMessage();
                }
            }
        } else {
            BindingResult bindingResult = e.getBindingResult();
            FieldError fieldError = bindingResult.getFieldError();
            if (fieldError != null) {
                msg = fieldError.getField() + fieldError.getDefaultMessage();
            }
        }
        return ResultBody.paramFail(msg);
    }

    @ResponseBody
    @ExceptionHandler(IllegalArgumentException.class)
    public ResultBody handleArgumentException(IllegalArgumentException e) {
        System.out.println("---> IllegalArgumentException: " + e.getMessage());
        String msg = e.getMessage();
        if (msg == null || msg.isEmpty()) {
            msg = "非法参数异常，请检查您的输入。";
        }
        return ResultBody.fail(CommonError.PARAM_FAIL.getCECode(), msg);
    }

    @ResponseBody
    @ExceptionHandler(SQLException.class)
    public ResultBody handleSqlException(SQLException e) {
        System.out.println("---> SQLException: " + e.getMessage());
        String msg = e.getMessage();
        if (msg != null && msg.contains("Duplicate entry")) {
            msg = "数据重复，请检查您的输入。";
        } else if (msg != null && msg.contains("foreign key constraint fails")) {
            msg = "外键约束失败，请检查相关数据。";
        } else {
            msg = "数据库操作异常：" + msg;
        }
        return ResultBody.fail(CommonError.DB_SQL_ERROR.getCECode(), msg);
    }

    @ResponseBody
    @ExceptionHandler(SQLSyntaxErrorException.class)
    public ResultBody handleSqlError(SQLSyntaxErrorException e) {
        System.out.println("---> SQLSyntaxErrorException: " + e.getMessage());
        String msg = e.getMessage();
        if (msg != null && msg.contains("syntax error")) {
            msg = "SQL语法错误，请检查您的SQL语句。";
        } else {
            msg = "SQL语法错误：" + msg;
        }
        return ResultBody.fail(CommonError.DB_SQL_ERROR.getCECode(), msg);
    }

    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    public ResultBody handleRuntimeException(RuntimeException e) {
        String msg = e.getMessage();
        System.out.println("---> handleError");
        System.out.println(e.toString());

        if (e instanceof MethodNotAllowedException) {
            System.out.println("---> MethodNotAllowedException");
        } else if (e instanceof MethodNotFoundException) {
            System.out.println("---> MethodNotFoundException");
        } else if (e instanceof MethodInvocationException) {
            System.out.println("---> MethodInvocationException");
        } else if (e instanceof HttpMessageConversionException) {
            System.out.println("---> HttpMessageConversionException");
        } else if (e instanceof BadSqlGrammarException) {
            System.out.println("---> BadSqlGrammarException");
            msg = "SQL语法错误，请检查参数或SQL语句";
        } else if (e instanceof DataIntegrityViolationException) {
            System.out.println("---> BadSqlGrammarException");
            msg = "SQL插入错误，请检查参数";
        }
        return ResultBody.unknown(msg == null ? CommonError.UNKNOWN_ERR.getCEMsg() : msg);
    }

}
