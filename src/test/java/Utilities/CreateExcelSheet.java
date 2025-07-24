package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class CreateExcelSheet {
	
	public static void excelWrite() {
		try {
			Calendar calendar=Calendar.getInstance();
			SimpleDateFormat sdf=new SimpleDateFormat("ddMMyy");
			Date date=calendar.getTime();
			String currentDate=sdf.format(date);
			String path=System.getProperty("user.dir")+File.separator+"ExcelData";
			File file=new File(path);
			if(!file.exists()) {
				file.mkdirs();
			}
			String excelFilePath=System.getProperty("user.dir")+File.separator+"ExcelData"+File.separator+"ExcelFile.xlsx";
			File excelFile=new File(excelFilePath);
			XSSFWorkbook workbook;
			XSSFSheet sheet;
			if(excelFile.exists()) {
			FileInputStream fis=new FileInputStream(excelFile);
			 workbook=new XSSFWorkbook(fis);
			}
			else {
				workbook =new XSSFWorkbook();
			}
			 sheet=workbook.createSheet("FirstSheet");
			for(int i=1;i<3;i++) {
				Row row=sheet.createRow(i);
				for(int j=1;j<3;j++) {
					Cell cell=row.createCell(i);
					cell.setCellValue("UserName");
				}
			}
			
			FileOutputStream fos=new FileOutputStream(excelFile);
			workbook.write(fos);
			
			workbook.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
