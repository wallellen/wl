package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import bean.Document;
import bean.PersonalDocument;
import bean.UnitDocument;
public class ExcelExcuter {
	public static final String NEW_EXCEL_POST="xlsx";
	public static final String OLD_EXCEL_POST="xls";
	public static final String DUCUMENT_TITLE_1="卷内文件目录";
	public static final String DUCUMENT_TITLE_2="归档文件目录";
	private static LinkedHashMap<String,String>cellNameToPersonalDocument=new LinkedHashMap<String,String>();
	static{
		cellNameToPersonalDocument.put("姓名", "Name");
		cellNameToPersonalDocument.put("个人编码", "SocialInsuranceNumber");
		cellNameToPersonalDocument.put("单位名称", null);
		cellNameToPersonalDocument.put("单位编码", null);
		cellNameToPersonalDocument.put("身份证号", "IdentifyCardId");
		cellNameToPersonalDocument.put("所属辖区", "Zone");
	}
	private static LinkedHashMap<String,String>cellNameToUnitDocument=new LinkedHashMap<String,String>();
	static{
		cellNameToUnitDocument.put("单位名称", "UnitName");
		cellNameToUnitDocument.put("单位编码", "UnitIdentifyId");
		cellNameToUnitDocument.put("所属辖区", "Zone");
	}
	private static LinkedHashMap<String,String>personalPropertyToColumMap=new LinkedHashMap<String,String>();
	static{
		personalPropertyToColumMap.put("Name", "姓名");
		personalPropertyToColumMap.put("SocialInsuranceNumber", "个人编码");
		personalPropertyToColumMap.put("IdentifyCardId", "身份证号");
		personalPropertyToColumMap.put("Zone", "所属辖区");
	}
	
	private static LinkedHashMap<String,String>documentPropertyToColumMap1=new LinkedHashMap<String,String>();
	static{
		documentPropertyToColumMap1.put("SequenceNumber", "顺\r\n序\r\n号");
		documentPropertyToColumMap1.put("FileNumber", "文号");
		documentPropertyToColumMap1.put("Author", "责任者");
		documentPropertyToColumMap1.put("Title", "题名");
		documentPropertyToColumMap1.put("Time", "日期");
		documentPropertyToColumMap1.put("PageNumber", "页\r\n号");
		documentPropertyToColumMap1.put("Comments", "备\r\n注");
	}
	private static LinkedHashMap<String,String>documentPropertyToColumMap2=new LinkedHashMap<String,String>();
	static{
		documentPropertyToColumMap2.put("PackageNumber", "件\r\n号");
		documentPropertyToColumMap2.put("Author", "责任者");
		documentPropertyToColumMap2.put("FileNumber", "文号");
		documentPropertyToColumMap2.put("Title", "题名");
		documentPropertyToColumMap2.put("Time", "日期");
		documentPropertyToColumMap2.put("PageNumber", "页\r\n数");
		documentPropertyToColumMap2.put("Comments", "备\r\n注");
	}
	
	private static LinkedHashMap<String,String>documentPropertyToColumMap4zijin=new LinkedHashMap<String,String>();
	static{
		documentPropertyToColumMap4zijin.put("SequenceNumber", "序号");
		documentPropertyToColumMap4zijin.put("FileNumber", "文号");
		documentPropertyToColumMap4zijin.put("Author", "责任者");
		documentPropertyToColumMap4zijin.put("Title", "题名");
		documentPropertyToColumMap4zijin.put("Time", "日期");
		documentPropertyToColumMap4zijin.put("PageNumber", "页数");
		documentPropertyToColumMap4zijin.put("Comments", "备注");
		documentPropertyToColumMap4zijin.put("DirLevel", "目录级别");
		documentPropertyToColumMap4zijin.put("TotalFileLevel", "全文级别");
		documentPropertyToColumMap4zijin.put("PackageNumber", "件号");
	}
	private static LinkedHashMap<String,String>unitPropertyToColumMap=new LinkedHashMap<String,String>();
	static{
		unitPropertyToColumMap.put("UnitName", "单位名称");
		unitPropertyToColumMap.put("UnitIdentifyId", "单位编码");
		unitPropertyToColumMap.put("Zone", "所属辖区");

	}
	public List<UnitDocument> readExcelForUnitDocument(File excel) throws Exception{
		//System.out.print(excel.getName());
		String names[]=excel.getName().split("\\.");
		Workbook wb;
		if(names[1].equals(NEW_EXCEL_POST)){
			wb=this.readNewExcel(excel);
		}
		else{
			wb=this.readOldExcel(excel);
		}
		List<UnitDocument> documents=new ArrayList<UnitDocument>();
		travelWholeBookForUnitDocument(wb,documents);
		return documents;
		
	}
	
	public List<Document> readExcelForDocument(File excel) throws Exception{
		//System.out.print(excel.getName());
		String names[]=excel.getName().split("\\.");
		Workbook wb;
		if(names[1].equals(NEW_EXCEL_POST)){
			wb=this.readNewExcel(excel);
		}
		else{
			wb=this.readOldExcel(excel);
		}
		List<Document> documents=new ArrayList<Document>();
		travelWholeBookForDocument(wb,documents);
		return documents;
		
	}
	
	
	private void travelWholeBookForUnitDocument(Workbook wb,
			List<UnitDocument> documents) {
		Sheet sheet=wb.getSheetAt(0);
		UnitDocument document=null;
		for(int i=1;i<=sheet.getLastRowNum();i++){
			Row row=sheet.getRow(i);
			if(row!=null){
				document=excuteCellsInthisRowForUnitDocument(row);
			}
			if(document!=null){
				if(document.getUnitIdentifyId()!=null){
					if(document.getTime()==null){
						document.setTime(UnitDocument.DEFAULT_TIME);
					}	
					documents.add(document);
				}
				
				document=null;
			}
			
		}
	/*	for(UnitDocument currentDocument:documents){
			System.out.println(currentDocument.getUnitName()+"   "+currentDocument.getUnitIdentifyId()+"   "+currentDocument.getTime());
		}*/
	}

	private void travelWholeBookForDocument(Workbook wb,
			List<Document> documents) {
		Sheet sheet=wb.getSheetAt(0);
		Document document=null;
		for(int i=1;i<=sheet.getLastRowNum();i++){
			Row row=sheet.getRow(i);
			if(row!=null){
				document=excuteCellsInthisRowForDocument(row);
			}
			if(document!=null){
				if(document.getArchive()!=null){
					if(document.getTime()==null){
						document.setTime(UnitDocument.DEFAULT_TIME);
					}	
					documents.add(document);
				}
				
				document=null;
			}
			
		}
	/*	for(UnitDocument currentDocument:documents){
			System.out.println(currentDocument.getUnitName()+"   "+currentDocument.getUnitIdentifyId()+"   "+currentDocument.getTime());
		}*/
	}

	private UnitDocument excuteCellsInthisRowForUnitDocument(Row row) {
		// TODO Auto-generated method stub
		UnitDocument document = new UnitDocument();
		for(int j=0;j<=row.getLastCellNum();j++){
			Cell cell=row.getCell(j);
			document=excuteThisCellForUnitDocument(cell,document);
		}
		return document;
		
	}
	
	private Document excuteCellsInthisRowForDocument(Row row) {
		// TODO Auto-generated method stub
		Document document = new Document();
		for(int j=0;j<=row.getLastCellNum();j++){
			Cell cell=row.getCell(j);
			document=excuteThisCellForDocument(cell,document);
		}
		return document;
		
	}


	private UnitDocument excuteThisCellForUnitDocument(Cell cell, UnitDocument document) {
		// TODO Auto-generated method stub
		try{
		if(cell!=null){
			Cell flagcell=cell.getSheet().getRow(0).getCell(cell.getColumnIndex());
			String objectProperty=cellNameToUnitDocument.get(flagcell.toString());
			if(objectProperty!=null){
			String methodName="set"+objectProperty;
			Object args[]=new Object[1];
			args[0]=cell.toString();
			ReflectionUtil.invokeMethod(document, methodName, args);
			}
		}}
		catch(Exception e){
			//do somethings
		}
		return document;
	}
	
	private Document excuteThisCellForDocument(Cell cell, Document document) {
		// TODO Auto-generated method stub
		try{
		if(cell!=null){
			Cell flagcell=cell.getSheet().getRow(0).getCell(cell.getColumnIndex());
			String objectProperty=cellNameToUnitDocument.get(flagcell.toString());
			if(objectProperty!=null){
			String methodName="set"+objectProperty;
			Object args[]=new Object[1];
			args[0]=cell.toString();
			ReflectionUtil.invokeMethod(document, methodName, args);
			}
		}}
		catch(Exception e){
			//do somethings
		}
		return document;
	}
	


	public List<PersonalDocument> readExcelForPersonalDocument(File excel) throws Exception{
		//System.out.print(excel.getName());
		String names[]=excel.getName().split("\\.");
		Workbook wb;
		if(names[1].equals(NEW_EXCEL_POST)){
			wb=this.readNewExcel(excel);
		}
		else{
			wb=this.readOldExcel(excel);
		}
		List<PersonalDocument> documents=new ArrayList<PersonalDocument>();
		travelWholeBookForPersonalDocument(wb,documents);
		return documents;
		
	}

	private void travelWholeBookForPersonalDocument(Workbook wb,List<PersonalDocument>documents) throws Exception {
		Sheet sheet=wb.getSheetAt(0);
		PersonalDocument document=null; 
		for(int i=1;i<=sheet.getLastRowNum();i++){
			Row row=sheet.getRow(i);
			if(row!=null){
				document=excuteCellsInthisRowForPersonalDocument(row);
				if(document!=null&&document.getSocialInsuranceNumber()!=null){
					if(document.getTime()==null){
						document.setTime(PersonalDocument.DEFAULT_TIME);
					}
					documents.add(document);
					document=null;
				}
			}
		}
		for(PersonalDocument currentDocument:documents){
			System.out.println(currentDocument.getName()+"   "+currentDocument.getSocialInsuranceNumber()+"   "+currentDocument.getTime());
		}
	}

	private PersonalDocument excuteCellsInthisRowForPersonalDocument(Row row) throws Exception {
		PersonalDocument document = new PersonalDocument();
		for(int j=0;j<=row.getLastCellNum();j++){
			Cell cell=row.getCell(j);
			document=excuteThisCellForPersonalDocument(cell,document);
		}	
		return document;
	}

	private PersonalDocument excuteThisCellForPersonalDocument(Cell cell,PersonalDocument document) throws Exception {
		if(cell!=null){
			Cell flagcell=cell.getSheet().getRow(0).getCell(cell.getColumnIndex());
			String objectProperty=cellNameToPersonalDocument.get(flagcell.toString());
			if(objectProperty!=null){
			String methodName="set"+objectProperty;
			Object args[]=new Object[1];
			args[0]=cell.toString();
			ReflectionUtil.invokeMethod(document, methodName, args);
			}
		}
		return document;
	}
	
	private Workbook readNewExcel(File excel) throws IOException{
        FileInputStream is = new FileInputStream(excel);  
        Workbook  wbs = new XSSFWorkbook(is);  
        return wbs;
	}
	
	private Workbook readOldExcel(File excel) throws IOException{
        FileInputStream is = new FileInputStream(excel);  
        Workbook  wbs = new HSSFWorkbook(is);  
        return wbs;
		
	}
	
	public void writePersonalExcel(List<PersonalDocument>documents,String outputExcelURL) throws Exception{
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet();		
		HSSFCellStyle style = createCellStyle(wb); 	
		LinkedHashMap<String,Integer> columPoints=new LinkedHashMap<String,Integer>();
		columPoints=createSheetHead(sheet, style,personalPropertyToColumMap);
		for(int i=0;i<documents.size();i++){
			PersonalDocument document =documents.get(i);
			HSSFRow row = sheet.createRow((int) i + 1);
			addPersonalDocumentIntoTheRow(document,row,columPoints,personalPropertyToColumMap);			
		}
		FileOutputStream fout = new FileOutputStream(outputExcelURL);
		wb.write(fout);
		fout.close();
	}
	
	
	public void writeUnitDocumentExcel(List<UnitDocument>documents,String outputExcelURL) throws Exception{
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet();		
		HSSFCellStyle style = createCellStyle(wb); 	
		LinkedHashMap<String,Integer> columPoints=new LinkedHashMap<String,Integer>();
		columPoints=createSheetHead(sheet, style,unitPropertyToColumMap);
		for(int i=0;i<documents.size();i++){
			UnitDocument document =documents.get(i);
			HSSFRow row = sheet.createRow((int) i + 1);
			addUnitDocumentIntoTheRow(document,row,columPoints,unitPropertyToColumMap);			
		}
		FileOutputStream fout = new FileOutputStream(outputExcelURL);
		wb.write(fout);
		fout.close();
	}


	private void addUnitDocumentIntoTheRow(UnitDocument document, HSSFRow row,
			LinkedHashMap<String, Integer> columPoints,
			LinkedHashMap<String, String> map) throws Exception {
		// TODO Auto-generated method stub
		HSSFCell cell;
		int count=0;
		for(String key : map.keySet()){
			String colum=map.get(key);
			String mathodName="get"+key;
			Object args[]=new Object[0];
			Object result=null;
			String value;
			if((result=ReflectionUtil.invokeMethod(document, mathodName, args))!=null){
				value=result.toString();
				cell=row.createCell(columPoints.get(colum));
				cell.setCellValue(value);
			}	
		}				
	}


	private void addPersonalDocumentIntoTheRow(PersonalDocument document,
			HSSFRow row, LinkedHashMap<String, Integer> columPoints,LinkedHashMap<String,String>map) throws Exception {
		// TODO Auto-generated method stub
		HSSFCell cell;
		int count=0;
		for(String key : map.keySet()){
			String colum=map.get(key);
			String mathodName="get"+key;
			Object args[]=new Object[0];
			Object result=null;
			String value;
			if((result=ReflectionUtil.invokeMethod(document, mathodName, args))!=null){
				value=result.toString();
				cell=row.createCell(columPoints.get(colum));
				cell.setCellValue(value);
			}	
		}		
	}
	public void writeDocumentExcel(List<Document>documents,String outputExcelURL,String type) throws Exception{
		if(type.equals("archive")){
			HSSFWorkbook wb = new HSSFWorkbook();
			
			HSSFSheet sheet = wb.createSheet();	
			wb.setRepeatingRowsAndColumns(0, -1, -1, 0, 2);
			createSheetStyle(sheet);
			HSSFCellStyle headStyle = createHeadStyle(wb);
			HSSFCellStyle titleStyle = createTitleStyle(wb);
			HSSFCellStyle style = createCellStyle(wb); 
			HSSFCellStyle titleStyle2 = createSecondTitleStyle(wb);
			createSheetTitle(sheet,titleStyle,titleStyle2,documents.get(0).getArchive().getArchiveNumber(),DUCUMENT_TITLE_1);
			LinkedHashMap<String,Integer> columPoints=new LinkedHashMap<String,Integer>();
			columPoints=createSheetHead(sheet, headStyle,documentPropertyToColumMap1);
			Integer totalPage = 0;
			for(int i=0;i<documents.size();i++){
				Document document =documents.get(i);
				HSSFRow row = sheet.createRow((int) i + 3);
				row.setHeightInPoints(40);//内容单元格的高度
				totalPage = addDocumentIntoTheRowWithTotalPage(document,row,columPoints,documentPropertyToColumMap1,style,totalPage);			
			}
			FileOutputStream fout = new FileOutputStream(outputExcelURL);
			wb.write(fout);
			fout.close();
		}else if(type.equals("package")){
			HSSFWorkbook wb = new HSSFWorkbook();
			
			HSSFSheet sheet = wb.createSheet();	
			wb.setRepeatingRowsAndColumns(0, -1, -1, 0, 2);
			createSheetStyle(sheet);
			HSSFCellStyle headStyle = createHeadStyle(wb);
			HSSFCellStyle titleStyle = createTitleStyle(wb);
			HSSFCellStyle style = createCellStyle(wb); 
			HSSFCellStyle titleStyle2 = createSecondTitleStyle(wb);
			createSheetTitle(sheet,titleStyle,titleStyle2,documents.get(0).getArchive().getArchiveNumber(),DUCUMENT_TITLE_2);
			LinkedHashMap<String,Integer> columPoints=new LinkedHashMap<String,Integer>();
			columPoints=createSheetHead(sheet, headStyle,documentPropertyToColumMap2);
			for(int i=0;i<documents.size();i++){
				Document document =documents.get(i);
				HSSFRow row = sheet.createRow((int) i + 3);
				row.setHeightInPoints(40);
				addDocumentIntoTheRow(document,row,columPoints,documentPropertyToColumMap2,style);			
			}
			FileOutputStream fout = new FileOutputStream(outputExcelURL);
			wb.write(fout);
			fout.close();
		}else if(type.equals("zijin")){
			HSSFWorkbook wb = new HSSFWorkbook();
			
			HSSFSheet sheet = wb.createSheet();	
			/*wb.setRepeatingRowsAndColumns(0, -1, -1, 0, 2);
			createSheetStyle(sheet);
			HSSFCellStyle headStyle = createHeadStyle(wb);
			HSSFCellStyle titleStyle = createTitleStyle(wb);
			HSSFCellStyle style = createCellStyle(wb); 
			HSSFCellStyle titleStyle2 = createSecondTitleStyle(wb);
			createSheetTitle(sheet,titleStyle,titleStyle2,documents.get(0).getArchive().getArchiveNumber(),DUCUMENT_TITLE_2);*/
			HSSFCellStyle style = wb.createCellStyle();
			LinkedHashMap<String,Integer> columPoints=new LinkedHashMap<String,Integer>();
			
			//HSSFRow row = sheet.createRow(2);
			
			//HSSFCell cell;
			int count=0;
			//LinkedHashMap<String,Integer> columPoints=new LinkedHashMap<String,Integer>();
			for(String value:documentPropertyToColumMap4zijin.values()){
				/*cell=row.createCell(count);
				cell.setCellValue(value);
				cell.setCellStyle(style);*/
				columPoints.put(value, count);
				count++;
				
			}
			
			//columPoints=createSheetHead(sheet, headStyle,documentPropertyToColumMap2);
			for(int i=0;i<documents.size();i++){
				Document document =documents.get(i);
				HSSFRow row = sheet.createRow((int) i);
				//row.setHeightInPoints(40);
				addDocumentIntoTheRow4zijin(document,row,columPoints,documentPropertyToColumMap4zijin,style);			
			}
			FileOutputStream fout = new FileOutputStream(outputExcelURL);
			wb.write(fout);
			fout.close();
		}
	}
	private void addDocumentIntoTheRow(Document document,
			HSSFRow row, LinkedHashMap<String, Integer> columPoints,LinkedHashMap<String,String>map, HSSFCellStyle style) throws Exception {
		// TODO Auto-generated method stub
		HSSFCell cell;
		//int count=0;
		for(String key : map.keySet()){
			String colum=map.get(key);
			String mathodName="get"+key;
			Object args[]=new Object[0];
			Object result=null;
			String value;
			if((result=ReflectionUtil.invokeMethod(document, mathodName, args))!=null){
				value=result.toString();
				cell=row.createCell(columPoints.get(colum));
				cell.setCellStyle(style);
				cell.setCellValue(value);
				
			}else{
				cell=row.createCell(columPoints.get(colum));
				cell.setCellStyle(style);
				cell.setCellValue("");
			}
		}
			
	}
	private void addDocumentIntoTheRow4zijin(Document document,
			HSSFRow row, LinkedHashMap<String, Integer> columPoints,LinkedHashMap<String,String>map, HSSFCellStyle style) throws Exception {
		// TODO Auto-generated method stub
		HSSFCell cell;
		//int count=0;
		for(String key : map.keySet()){
			String colum=map.get(key);
			String mathodName="get"+key;
			Object args[]=new Object[0];
			Object result=null;
			String value;
			if((result=ReflectionUtil.invokeMethod(document, mathodName, args))!=null){
				if(key.equals("Time")){
					value=result.toString();
					SimpleDateFormat sdf1  =   new  SimpleDateFormat("yyyyMMdd");
					Date date = sdf1.parse(value);
					SimpleDateFormat sdf2  =   new  SimpleDateFormat("yyyy.MM.dd");
					value = sdf2.format(date);
					cell=row.createCell(columPoints.get(colum));
					cell.setCellStyle(style);
					cell.setCellValue(value);
				}else{
					value=result.toString();
					cell=row.createCell(columPoints.get(colum));
					cell.setCellStyle(style);
					cell.setCellValue(value);
				}
				
				
			}else{
				cell=row.createCell(columPoints.get(colum));
				cell.setCellStyle(style);
				cell.setCellValue("");
			}
		}
			
	}
	private int addDocumentIntoTheRowWithTotalPage(Document document,
			HSSFRow row, LinkedHashMap<String, Integer> columPoints,LinkedHashMap<String,String>map, HSSFCellStyle style,Integer totalPage) throws Exception {
		// TODO Auto-generated method stub
		HSSFCell cell;
		//int count=0;
		for(String key : map.keySet()){
			String colum=map.get(key);
			String mathodName="get"+key;
			Object args[]=new Object[0];
			Object result=null;
			String value;
			int page;
			if((result=ReflectionUtil.invokeMethod(document, mathodName, args))!=null){
				if(key.equals("PageNumber")){
					value = result.toString();
					page = Integer.parseInt(value);
					totalPage += page;
					cell=row.createCell(columPoints.get(colum));
					cell.setCellStyle(style);
					cell.setCellValue(totalPage);
					
				}else{
					value=result.toString();
					cell=row.createCell(columPoints.get(colum));
					cell.setCellStyle(style);
					cell.setCellValue(value);
					
				}
			}
			
		}	
		return totalPage;
	}


	private HSSFCellStyle createCellStyle(HSSFWorkbook wb) {
		HSSFCellStyle style = wb.createCellStyle();
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP);
		style.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
	    style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
	    style.setBorderRight(HSSFCellStyle.BORDER_THIN);
	    style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setWrapText(true);
		return style;
	}
	/**
	 * 设置每一列的宽度
	 * @param sheet
	 */
	private void createSheetStyle(HSSFSheet sheet){
		sheet.setColumnWidth(0, 7*256);
		sheet.setColumnWidth(1, 10*256);
		sheet.setColumnWidth(2, 10*256);
		sheet.setColumnWidth(3, 36*256);
		sheet.setColumnWidth(4, 12*256);
		sheet.setColumnWidth(5, 5*256);
		sheet.setColumnWidth(6, 9*256);
		sheet.setDisplayGridlines(true);
	}


	private LinkedHashMap<String,Integer> createSheetHead(HSSFSheet sheet, HSSFCellStyle style,LinkedHashMap<String,String> map) {
		HSSFRow row = sheet.createRow(2);
		row.setHeight((short)1000);
		
		HSSFCell cell;
		int count=0;
		LinkedHashMap<String,Integer> columPoints=new LinkedHashMap<String,Integer>();
		for(String value:map.values()){
			cell=row.createCell(count);
			cell.setCellValue(value);
			cell.setCellStyle(style);
			columPoints.put(value, count);
			count++;
			
		}
		return columPoints;
	}
	
	private HSSFCellStyle createHeadStyle(HSSFWorkbook wb){
		HSSFCellStyle style = wb.createCellStyle();
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setWrapText(true);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
	    style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
	    style.setBorderRight(HSSFCellStyle.BORDER_THIN);
	    style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		return style;
	}
	private HSSFCellStyle createTitleStyle(HSSFWorkbook wb){
		HSSFCellStyle style = wb.createCellStyle();
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		
		style.setWrapText(true);
		
		HSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short)20);
		font.setFontName("楷体");
		style.setFont(font);
		return style;
	}
	
	private HSSFCellStyle createSecondTitleStyle(HSSFWorkbook wb){
		HSSFCellStyle style = wb.createCellStyle();
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		style.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		style.setBorderBottom(HSSFCellStyle.BORDER_NONE);
	    style.setBorderLeft(HSSFCellStyle.BORDER_NONE);
	    style.setBorderRight(HSSFCellStyle.BORDER_NONE);
	    style.setBorderTop(HSSFCellStyle.BORDER_NONE);
		style.setWrapText(true);
		
		HSSFFont font = wb.createFont();
		//font.setFontHeightInPoints((short)20);
		font.setFontName("楷体");
		style.setFont(font);
		return style;
	}
	private void createSheetTitle(HSSFSheet sheet,HSSFCellStyle style1,HSSFCellStyle style2,String documentNumber,String title){
		HSSFRow row = sheet.createRow(0);
		row.setHeightInPoints(30);
		HSSFCell cell1 = row.createCell(0);
		cell1.setCellValue(title);
		cell1.setCellStyle(style1);
		
		sheet.addMergedRegion(new CellRangeAddress(0,(short)0,0,(short)6));
		row = sheet.createRow(1);
		
		HSSFCell[] cell = new HSSFCell[7];
		
		for(int i = 0;i < 7;i++){
			cell[i] = row.createCell(i);
			
			cell[i].setCellStyle(style2);
		}
		HSSFHeader header = sheet.getHeader();
		header.setRight("第   " + HSSFHeader.page() + " 页");
		
		cell[0].setCellValue("档号");
		cell[1].setCellValue(documentNumber);
		//cell[5].setCellValue("第" + header.page() + "页");
		
		sheet.addMergedRegion(new CellRangeAddress(1,1,1,4));
	//	sheet.addMergedRegion(new CellRangeAddress(1,1,5,6));
	
	}

}
