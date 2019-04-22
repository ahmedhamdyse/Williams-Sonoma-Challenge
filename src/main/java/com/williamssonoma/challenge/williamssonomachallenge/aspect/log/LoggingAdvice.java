package com.williamssonoma.challenge.williamssonomachallenge.aspect.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;

/**
 * <p>
 * This Aspect class for logging the the status of the methods when starts and ends
 * As well as logging the reason if there is no output
 * </p>
 */

@Component(value = "loggingAdvice")
@Aspect
public class LoggingAdvice {

    @Pointcut("execution(* com.williamssonoma.challenge.williamssonomachallenge.service.impl.*.*(..))")
    private void selectAll() {
        // Logging Pointcut
    }

    @Before("selectAll()")
    public void beforeAdvice(JoinPoint jp) {
        LoggerFactory.getLogger(jp.getClass().getName()).info("{} started !!!", jp.getSignature().getName());
    }

    @After("selectAll()")
    public void afterAdvice(JoinPoint jp) {
        LoggerFactory.getLogger(jp.getClass().getName()).info("{} ended !!!", jp.getSignature().getName());
    }

    @Pointcut("execution(* com.williamssonoma.challenge.williamssonomachallenge.service.impl.ZipCodeProcessorImpl.*(..))")
    private void selectZipCodeProcessor() {
        // Logging Pointcut
    }

    @Before("selectZipCodeProcessor()")
    public void beforeZipCodeProcessorAdvice(JoinPoint jp) {
        Arrays.stream(jp.getArgs()).forEach(arg -> {
            if (Objects.isNull(arg))
                LoggerFactory.getLogger(jp.getClass().getName()).info("All given zip code ranges filtered out :: Please check their patterns and ranges !!");
        });
    }
}