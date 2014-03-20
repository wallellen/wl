package util;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import action.ElectricDocumentAction;
import bean.User;
import DAO.UserDAO;
import junit.framework.TestCase;

public class UtilTester extends TestCase {
	public void testGetContext(){
		ApplicationCreater.getApplicationContext();
	}
	public void testTime(){
		System.out.println(this.getClass());
	}
}
