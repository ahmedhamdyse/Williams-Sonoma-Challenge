package com.williamssonoma.challenge.williamssonomachallenge.aspect.valid;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;

/**
 * This Aspect class for validating the input parameter comes from the user that not null
 */

@Component(value = "validatorAdvice")
@Aspect
public class ValidatorAdvice {

    @Pointcut("execution(* com.williamssonoma.challenge.williamssonomachallenge.service.impl.ZipCodeValidatorImpl.*(..))")
    private void selectAll() {
        // Validator pointcut
    }

    @Before("selectAll()")
    public void beforeAdvice(JoinPoint jp) {
        Arrays.stream(jp.getArgs()).forEach(arg -> {
            if (Objects.isNull(arg))
                throw new NullPointerException("Invalid parameters for method :: " + jp.getSignature().getName());
        });
    }
}
