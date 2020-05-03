package cn.edu.study.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

/**
 * aop数据校验出错后处理
* 通知：
* 前置通知
* 返回通知
* 异常通知
* 后置通知
*
* 正常：前置通知 --> 返回通知 -->后置通知
* 异常：前置通知 --> 异常通知 -->后置通知
 *
 * */
@Aspect
@Component
public class DateVaildAspect {

    /**
     * 环绕通知（有目标方法的执行）
     *  execution表达式： 任意修饰符 cn.edu.study.controller任意路径下 以Controller结尾的类里 任意方法带 任意参数
     *                      *       cn.edu.study.controller..       *Controller. *( .. )
     */
    @Around("execution(* cn.edu.study.controller.ValidController.*(..))")
    public Object validAround(ProceedingJoinPoint point) {
        Object res= null;
        try {
            Object[] args = point.getArgs();
            for(Object arg : args){
                if(arg instanceof BindingResult){
                    BindingResult bResult = (BindingResult)arg;
                    if(bResult.getErrorCount()>0){
                        //校验出错了。。。
                        return "错误提交";
                    }
                }
            }
            //相当于method.invoke()
            res = point.proceed(point.getArgs());

        } catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }
        return res;
    }



    //获取目标方法的信息
    public Object getMethdMesg(JoinPoint joinPoint) {
        Object [] srgs = joinPoint.getArgs();
        return srgs;
    }

}
