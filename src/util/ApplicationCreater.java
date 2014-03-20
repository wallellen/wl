package util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ApplicationCreater implements ApplicationContextAware{
	private static ApplicationContext context;
	private ApplicationCreater(){
		
	}
	public static ApplicationContext getApplicationContext(){
		return context;
	}
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		// TODO Auto-generated method stub
		context=arg0;
		
	}
}
