package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
	static String[][] str;
	
	public static String[][] readExcel(){
		
		try {
		Calendar calendar=Calendar.getInstance();
		SimpleDateFormat sdf=new SimpleDateFormat("ddMMyy");
		Date date=calendar.getTime();
		String currentDate=sdf.format(date);
		String path=System.getProperty("user.dir")+File.separator+"ExcelData"+File.separator+"ExcelFile.xlsx";
		List<List> outerList=new ArrayList<>();
		int rowIndex=0,colIndex=0;
		File file=new File(path);
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("FirstSheet");
		Iterator<Row> rowIterator=sheet.rowIterator();
		while(rowIterator.hasNext()) {
			Row row=rowIterator.next();
			List<String> innerList=new ArrayList<>();
			Iterator<Cell> cellIterator=row.cellIterator();
			while(cellIterator.hasNext()) {
				Cell cell=cellIterator.next();
				if(rowIndex!=0&&colIndex!=0) {
					if(cell.getCellType()==CellType.STRING) {
						innerList.add(cell.getStringCellValue());
					}
					
				}
				colIndex++;
			}
			rowIndex++;
			colIndex=0;
			if(!innerList.isEmpty()) {
				outerList.add(innerList);
			}
			
			int rowSize=outerList.size();
			int colSize=outerList.get(0).size();
			str=new String[rowSize][colSize];
			
			for(int i=0;i<rowSize;i++) {
				str[i]=(String[]) outerList.get(i).toArray(new String[0]);
			}
			
		}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return str;
			
		
	}
	

}
