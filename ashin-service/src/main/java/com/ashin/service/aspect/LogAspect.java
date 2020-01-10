package com.ashin.service.aspect;


import com.ashin.model.entity.SysLog;
import com.ashin.model.mapper.SysLogMapper;
import com.ashin.service.annotation.LogAnnotation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 日志切面 = 切点+通知
 * @Author:debug (SteadyJack)
 * @Link: weixin-> debug0868 qq-> 1948831260
 * @Date: 2019/11/7 15:18
 **/
@Aspect
@Component
public class LogAspect {

    private static final Logger log= LoggerFactory.getLogger(LogAspect.class);

    @Autowired
    private SysLogMapper sysLogMapper;

    @Autowired
    private ObjectMapper objectMapper;


    //定义切点:发生的时机 - 即一旦加了这个注解，将触发某些事情
    @Pointcut("@annotation(com.ashin.service.annotation.LogAnnotation)")
    public void logPointCut(){}

    //定义通知：环绕通知 - 执行核心任务之前 + 执行完核心任务之后 该做的事情
    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        long start=System.currentTimeMillis();

        //TODO:执行核心任务
        Object object=joinPoint.proceed();

        long time=System.currentTimeMillis()-start;

        saveLog(joinPoint,time);
        return object;
    }

    //TODO:保存操作日志
    private void saveLog(ProceedingJoinPoint point,Long time) throws Exception{
        log.info("开始触发-保存操作日志");

        MethodSignature signature= (MethodSignature) point.getSignature();
        Method method=signature.getMethod();

        SysLog entity=new SysLog();

        //TODO:获取请求操作的描述信息
        LogAnnotation annotation=method.getAnnotation(LogAnnotation.class);
        if (annotation!=null){
            entity.setOperation(annotation.value());
        }

        //TODO:获取操作方法名
        String className=point.getTarget().getClass().getName();
        String methodName=signature.getName();
        entity.setMethod(className + "." + methodName + "()");

        //TODO:获取请求参数
        Object[] args=point.getArgs();
        entity.setParams(objectMapper.writeValueAsString(args[0]));

        //TODO:获取剩余参数
        entity.setTime(time);
        entity.setCreateDate(DateTime.now().toDate());
        entity.setUsername("debug");
        entity.setIp("localhost");


        sysLogMapper.insertSelective(entity);
    }
}





































