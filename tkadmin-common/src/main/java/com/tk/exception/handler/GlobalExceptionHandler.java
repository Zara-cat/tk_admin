package com.tk.exception.handler;

import com.tk.utils.enums.ExecutionState;
import com.tk.utils.response.Responder;
import com.tk.utils.response.ResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Objects;
import java.util.Set;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : GlobalExceptionHandler
 * @description : [全局异常处理]
 * @createTime : [2021/12/14 13:19]
 * @updateUser : [Zara-cat]
 * @updateTime : [2021/12/14 13:19]
 * @updateRemark : [描述说明本次修改内容]
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    /**
     * 拦截表单参数校验
     * 处理Get请求中 使用@Valid 验证路径中请求实体校验失败后抛出的异常
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler({BindException.class})
    public ResultDTO<Object> bindException(BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        log.info("数据验证异常：{}", bindingResult.getFieldError().getDefaultMessage());
        return Responder.failure(4001,Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
    }

    /**
     * 拦截JSON参数校验
     * 处理请求参数格式错误 @RequestBody上validate失败后抛出的异常是MethodArgumentNotValidException异常
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultDTO<Object> bindException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        log.info("数据验证异常：{}", bindingResult.getFieldError().getDefaultMessage());
        return Responder.failure(4002,Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
    }

    /**
     * 处理请求参数格式错误 @RequestParam上validate失败后抛出的异常是javax.validation.ConstraintViolationException
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResultDTO<Object> ConstraintViolationExceptionHandler(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        ConstraintViolation<?> violation = violations.iterator().next();
        String message = violation.getMessage();
        log.info("数据验证异常：{}", message);
        return Responder.failure(4003,message);
    }

    /**
     * 参数格式错误
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResultDTO<Object> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        log.error("错误信息{}", e.getLocalizedMessage());
        return Responder.failure(ExecutionState.REQ_FORMAT_ERROR);
    }

    /**
     * 参数格式错误
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResultDTO<Object> httpMessageNotReadable(HttpMessageNotReadableException e) {
        log.error("错误信息:{}", e.getLocalizedMessage());
        return Responder.failure(ExecutionState.REQ_FORMAT_ERROR);
    }

    /**
     * 请求方式不支持
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResultDTO<Object> httpReqMethodNotSupported(HttpRequestMethodNotSupportedException e) {
        log.error("错误信息:{}", e.getLocalizedMessage());
        return Responder.failure(ExecutionState.REQ_METHOD_NOT_SUPPORT);
    }

    /**
     * 通用异常
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(Exception.class)
    public ResultDTO<Object> exception(Exception e) {
        e.printStackTrace();
        return Responder.failure(ExecutionState.SYSTEM_UNKNOWN_EXCEPTION);
    }
}
