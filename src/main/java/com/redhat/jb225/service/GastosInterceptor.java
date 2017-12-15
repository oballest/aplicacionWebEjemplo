package com.redhat.jb225.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import com.redhat.jb225.anotatios.Intercepted;

@Intercepted @Interceptor
public class GastosInterceptor {
	
	private static final DateFormat DATE_FORMAT = SimpleDateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
	
	@AroundInvoke
	public Object interceptOperation(InvocationContext context) throws Exception{
		Object retu = context.proceed();
		
		for (Object parameter : context.getParameters()) {
			System.out.print("LOGGER: ");
			System.out.print(DATE_FORMAT.format(new Date()));
			System.out.print(" : ");
			System.out.print(" (");
			System.out.print(parameter.getClass().getSimpleName());
			System.out.print(") ");
			System.out.println(parameter);
		}
		return retu;
	}

}
