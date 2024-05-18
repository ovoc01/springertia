package com.noar.inert.js.core;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import com.noar.inert.js.annotation.InertiaRender;

import java.lang.reflect.Method;

@Component
@Aspect
public class InertiaRendererAspect {
    Logger logger = org.slf4j.LoggerFactory.getLogger(InertiaRendererAspect.class);
    @Pointcut("@annotation(com.noar.inert.js.annotation.InertiaRender)")
    public void renderInertiaView() {
    }

    @Around("renderInertiaView()")
    public Object renderInertiaView(ProceedingJoinPoint joinPoint) throws Throwable {
        
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        
        InertiaRender inertiaRender = method.getAnnotation(InertiaRender.class);
        
        Object props = joinPoint.proceed();
        if(props == null){
            logger.warn("InertiaRender with {} method returned null props.",inertiaRender.view());

            return Inertia.render(inertiaRender.view());
        }else{
            
            return Inertia.render(inertiaRender.view(), Inertia.Props.with(props));
        }
    }
}
