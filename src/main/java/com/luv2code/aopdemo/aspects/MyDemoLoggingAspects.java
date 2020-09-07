package com.luv2code.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspects {
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDaoPackage(){}
	
	//create pointcut for getter
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	private void getter(){}
	
	//create pointcut for setter
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	private void setter(){}
	
	//create pointcut: inclued package....exclued all getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageExcludeGetterSetter(){}
	
	@Before("forDaoPackageExcludeGetterSetter()")
	public void beforeAddAccountAdvice(){
		System.out.println("\n====>Executing @Before advice on method()");
	}
	
	@Before("forDaoPackageExcludeGetterSetter()")
	public void performAPIAnalytics(){
		System.out.println("\n====>Perform API analytics");
	}
	
	@Before("forDaoPackageExcludeGetterSetter()")
	public void logToCloudAsync(){
		System.out.println("\n====>Logging to cloud in Async Fashion");
	}

}
