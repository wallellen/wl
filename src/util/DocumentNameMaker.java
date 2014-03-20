package util;

import java.util.Date;

import bean.Document;
import bean.PersonalDocument;
import bean.UnitDocument;

public class DocumentNameMaker {
 
	private static int  count=0;
	public static synchronized int getCount() {
		count=(count+1)%ROUNT;
		return count;
	}

	public static synchronized void setCount(int count) {
		DocumentNameMaker.count = count;
	}
	public static final int ROUNT=1000;
	public static synchronized String createPersonalDocumentName(PersonalDocument document,
			String type) {
		Date date = new Date();

		String name="personal_"+type+"_"+document.getSocialInsuranceNumber()+"_"+document.getName()+"_"+date.getTime()+"_"+getCount();
		
		return name;
	}

	public static synchronized String createUnitDocumentName(UnitDocument document,
			String type) {
		Date date = new Date();
		String name="unit_"+type+"_"+document.getUnitIdentifyId()+"_"+document.getUnitName()+"_"+date.getTime()+"_"+getCount();
		
		return name;
	}

	public static synchronized String createDocumentName(Document document,
			String type) {
		Date date = new Date();

		String name=type+"_"+document.getId()+ "_"+date.getTime()+"_"+getCount();
		
		return name;
	}
}
