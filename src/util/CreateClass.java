package util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

public class CreateClass {
private static String CLASS_NAME = "CreateClassTest";
private static String CLASS_FILE ="E:\\Tomcat 6.0\\webapps\\wl\\WEB-INF\\classes\\"+CLASS_NAME + ".java";

public static void main(String args[]) throws IOException {
CreateClass mtc = new CreateClass();
mtc.createClass(test);
System.out.println("javac " + CLASS_FILE);
mtc.compileClass();
System.out.println("java " + CLASS_NAME);
mtc.runClass();}

public static void fun(String compile) throws IOException{
	CreateClass mtc = new CreateClass();
	mtc.createClass(compile);
	mtc.compileClass();
	mtc.runClass();
	
}
static String test ="public class CreateClassTest{public void test(){System.out.println(\"hello world!\");}}";
public void createClass(String compile) throws IOException {



new File(CLASS_FILE).delete();
new File(CLASS_FILE.split("/.")[0]+".class").delete();
FileWriter aWriter = new FileWriter(CLASS_FILE, true);
aWriter.write(compile);
aWriter.flush();
aWriter.close();}

public void compileClass() {
String filePath = new File(CreateClass.class.getClassLoader().getResource("").getFile()).getAbsolutePath();
 filePath="E:\\Tomcat 6.0\\webapps\\wl\\WEB-INF\\classes";
String[] source = { "-d", filePath, new String(CLASS_FILE) };

System.out.println("javac out:"+ com.sun.tools.javac.Main.compile(source));}


public void runClass() {

try {

Class params[] = {};

Object paramsObj[] = {};

Class testClass = Class.forName(CLASS_NAME);

Object iClass = testClass.newInstance();

Method thisMethod = testClass.getDeclaredMethod("test", params);

thisMethod.invoke(iClass, paramsObj);
} catch (Exception e) {
e.printStackTrace();}}}