package com.springapp.aop.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggingAspect {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Pointcut("within(com.springapp.rest..*)")
	public void loggingPointCut(){
		
	}
	
	@Around("loggingPointCut")
	public Object empArroungAdvice(ProceedingJoinPoint proceedingJointPointCut){
		log.info("Info From {},{}()", proceedingJointPointCut.getSignature().getDeclaringType(),proceedingJointPointCut.getSignature().getDeclaringTypeName());
		
		Object result = null;
		try{
			
			result = proceedingJointPointCut.proceed();
			
		}
		catch (Throwable e) {
			log.error("Error occured. Reason {}",e.getCause());
		}
		return result;
	}

}
