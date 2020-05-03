package cn.edu.study.aop;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/**
 * 异常处理
 */
@RestControllerAdvice
public class GlobalExecptionHandel {

    @ExceptionHandler(value = {ArithmeticException.class})
    public Object handelExecption(Exception exception){
        exception.getStackTrace();
        return "数学没学好";
    }
}
