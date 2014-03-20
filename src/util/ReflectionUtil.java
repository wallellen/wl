package util;

import java.lang.reflect.Method;

public class ReflectionUtil {
	public static Object invokeMethod(Object methodObject, String methodName,
			Object[] args) throws Exception {
		Class ownerClass = methodObject.getClass();
		Class[] argsClass = new Class[args.length];
		for (int i = 0, j = args.length; i < j; i++) {
			argsClass[i] = args[i].getClass();
		}
		
		Object obj;
		try {
			Method method = ownerClass.getMethod(methodName, argsClass);
			obj = method.invoke(methodObject, args);
			
		} catch (Exception e) {
			// TODO: handle exception
			obj = null;
		}
		
		return obj;
	}

}
