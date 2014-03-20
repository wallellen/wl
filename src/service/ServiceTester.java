package service;

import java.io.File;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import util.ExcelExcuter;
import util.PageBean;

import bean.*;

import junit.framework.TestCase;

public class ServiceTester extends TestCase {
	private static ApplicationContext ctx= new FileSystemXmlApplicationContext
	("/WebRoot/WEB-INF/applicationContext.xml");

	public void testB() throws Exception{
		PersonalDocumentManager pdm = (PersonalDocumentManager)ctx.getBean("personalDocumentManager");
		PersonalDocument document = new PersonalDocument();
		ExcelExcuter ee = new ExcelExcuter();
		File excel= new File("D:\\360data\\重要数据\\桌面\\武侯档案\\5.xls");
		List<PersonalDocument> list=ee.readExcelForPersonalDocument(excel);
		//list=pdm.addSomeDocumentFromList(list);
		ee.writePersonalExcel(list, "D:\\360data\\重要数据\\桌面\\武侯档案\\6.xls");
	}
}




