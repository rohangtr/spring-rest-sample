package com.springapp.aop.logging;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggingAspect {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Pointcut("within(com.springapp.rest.controller..*)")
	public void loggingPointCut(){
		
	}
	
	@Around("loggingPointCut()")
	public Object empArroungAdvice(ProceedingJoinPoint pjp){
		
		log.info("Info From {},{}({})", pjp.getSignature().getDeclaringType(),
				pjp.getSignature().getName(), Arrays.toString(pjp.getArgs()));
		
		Object result = null;
		try{		
			result = pjp.proceed();
		}
		catch (Throwable e) {
			log.error("Error occured. Reason {}",e.getCause());
		}
		log.info("Returned Value :: {}", result);
		return result;
	}

}
