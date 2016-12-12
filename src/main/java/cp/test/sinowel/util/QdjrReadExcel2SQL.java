package cp.test.sinowel.util;

import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 读取excel文件内容转换为sql语句
 * @author jhc
 *
 */
public class QdjrReadExcel2SQL {

	private static final String SUCCESS = "SUCCESS";
	private static String SQLTemple = "INSERT INTO direct_coin_other_list(activity_code,mobile,other_time,create_time,create_date,type,status)VALUES('QDJR_161017','[MOBILE]','[OTHER_TIME]',NOW(),DATE_FORMAT(NOW(),'%Y-%m-%d'),1,0);";
	
	public static void main(String[] args) {
//		test();
//		createSQL("C:/Users/jhc/Desktop/SSH/task/qdjr-t-161101.xlsx ","C:/Users/jhc/Desktop/SSH/task/qdjr-t-161101.txt");
		String sourceFullName = "C:/Users/jhc/Desktop/SSH/qdjr/乾道金融第三方模拟数据（每日激活数据）-11.1-raw.xlsx";
		String outPutFile = FilenameUtils.getFullPath(sourceFullName)+File.separator+FilenameUtils.getBaseName(sourceFullName)+".txt";
		createSQL(sourceFullName,outPutFile);
	}
	
	@SuppressWarnings("deprecation")
	public static void createSQL(String fileName, String outPutFile) {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		SimpleDateFormat sourcefmt = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		int dataLine = 1;
		DecimalFormat decimalFormat = new DecimalFormat("#.#");
		
		File outPutfile = new File(outPutFile);
		
	    try {
	        //同时支持Excel 2003、2007
	        File excelFile = new File(fileName); //创建文件对象  
	        FileInputStream is = new FileInputStream(excelFile); //文件流 
	        Workbook workbook = WorkbookFactory.create(is); //这种方式 Excel 2003/2007/2010 都是可以处理的  
	        int sheetCount = workbook.getNumberOfSheets();  //Sheet的数量 
	        System.out.printf("sheetCount: %d\n\r", sheetCount);
	        //遍历每个Sheet
	        for (int s = 0; s < sheetCount; s++) {
	            Sheet sheet = workbook.getSheetAt(s);  
	            int rowCount = sheet.getPhysicalNumberOfRows(); //获取总行数 
	            System.out.printf("rowCount: %d\n\r", rowCount);
	            //遍历每一行
	            for (int r = 0; r < rowCount; r++) {
	            	String rowSQL = new String(SQLTemple);
	                Row row = sheet.getRow(r);  
	                int cellCount = row.getPhysicalNumberOfCells(); //获取总列数
//	                System.out.printf("cellCount: %d\n\r", cellCount);
	                //遍历每一列 
	                for (int c = 0; c < cellCount; c++) {
	                    Cell cell = row.getCell(c);
	                    if(null == cell) {
	                    	System.out.println("null");
	                    	continue;
	                    }
	                    int cellType = cell.getCellType();  
	                    String cellValue = null;  
	                    switch(cellType) {
	                        case Cell.CELL_TYPE_STRING: //文本  
	                            cellValue = cell.getStringCellValue();  
	                            break;
	                        case Cell.CELL_TYPE_NUMERIC: //数字、日期  
	                            if(DateUtil.isCellDateFormatted(cell)) {  
//	                                cellValue = fmt.format(cell.getDateCellValue()); //日期型
	                                double d = cell.getNumericCellValue();
	                                Date date = HSSFDateUtil.getJavaDate(d);
	                                cellValue = fmt.format(date);
	                            }  
	                            else {
//	                                cellValue = String.valueOf(cell.getNumericCellValue()); //数字 
	                                cellValue = decimalFormat.format((cell.getNumericCellValue()));
	                            }  
	                            break;
	                        case Cell.CELL_TYPE_BOOLEAN: //布尔型  
	                            cellValue = String.valueOf(cell.getBooleanCellValue());  
	                            break;  
	                        case Cell.CELL_TYPE_BLANK: //空白  
	                            cellValue = cell.getStringCellValue();  
	                            break;  
	                        case Cell.CELL_TYPE_ERROR: //错误  
	                            cellValue = "错误";  
	                            break;  
	                        case Cell.CELL_TYPE_FORMULA: //公式  
	                            cellValue = "错误";  
	                            break;  
	                        default:  
	                            cellValue = "错误";  
	                    }  
	                    System.out.print(cellValue + "    ");
	                    
	                    //
	                    if(r >= dataLine) {
	                    	if(c == 1) { // mobile
	                    		rowSQL = rowSQL.replace("[MOBILE]", cellValue);
	                    	} else if(c == 2) { // other_time
	                    		try{
	                    			cellValue = fmt.format(sourcefmt.parse(cellValue));
	                    		} catch(Exception e) {
	                    
	                    		}
	                    		rowSQL = rowSQL.replace("[OTHER_TIME]", cellValue);
	                    	}
	                    }
	                }
//	                System.out.println();
	                if(r >= dataLine) {
	                	System.out.println(rowSQL);
	                	List<String> list = new ArrayList<String>();
	                	list.add(rowSQL);
//	                	FileUtils.write(outPutfile, rowSQL, "UTF-8", true);
	                	FileUtils.writeLines(outPutfile, "UTF-8", list, true);
	                }
	            }  
	        }  
	        System.out.println("处理完成，输出文件：" + outPutFile);
	    }  
	    catch (Exception e) {
	        e.printStackTrace();  
	    }  
	  
	}
	
	@SuppressWarnings("deprecation")
	public static String test() {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		DecimalFormat decimalFormat = new DecimalFormat("#.#");
	    try {  
	        //同时支持Excel 2003、2007  
	        File excelFile = new File("C:/Users/jhc/Desktop/SSH/task/qdjr-t-161101.xlsx"); //创建文件对象  
	        FileInputStream is = new FileInputStream(excelFile); //文件流 
	        Workbook workbook = WorkbookFactory.create(is); //这种方式 Excel 2003/2007/2010 都是可以处理的  
	        int sheetCount = workbook.getNumberOfSheets();  //Sheet的数量 
	        System.out.printf("sheetCount: %d\n\r", sheetCount);
	        //遍历每个Sheet  
	        for (int s = 0; s < sheetCount; s++) {
	            Sheet sheet = workbook.getSheetAt(s);  
	            int rowCount = sheet.getPhysicalNumberOfRows(); //获取总行数 
	            System.out.printf("rowCount: %d\n\r", rowCount);
	            //遍历每一行  
	            for (int r = 0; r < rowCount; r++) {  
	                Row row = sheet.getRow(r);  
	                int cellCount = row.getPhysicalNumberOfCells(); //获取总列数
	                System.out.printf("cellCount: %d\n\r", cellCount);
	                //遍历每一列  
	                for (int c = 0; c < cellCount; c++) {  
	                    Cell cell = row.getCell(c);
	                    int cellType = cell.getCellType();  
	                    String cellValue = null;  
	                    switch(cellType) {  
	                        case Cell.CELL_TYPE_STRING: //文本  
	                            cellValue = cell.getStringCellValue();  
	                            break;  
	                        case Cell.CELL_TYPE_NUMERIC: //数字、日期  
	                            if(DateUtil.isCellDateFormatted(cell)) {  
//	                                cellValue = fmt.format(cell.getDateCellValue()); //日期型
	                                double d = cell.getNumericCellValue();
	                                Date date = HSSFDateUtil.getJavaDate(d);
	                                cellValue = fmt.format(date);
	                            }  
	                            else {
//	                                cellValue = String.valueOf(cell.getNumericCellValue()); //数字 
	                                cellValue = decimalFormat.format((cell.getNumericCellValue()));
	                            }  
	                            break;
	                        case Cell.CELL_TYPE_BOOLEAN: //布尔型  
	                            cellValue = String.valueOf(cell.getBooleanCellValue());  
	                            break;  
	                        case Cell.CELL_TYPE_BLANK: //空白  
	                            cellValue = cell.getStringCellValue();  
	                            break;  
	                        case Cell.CELL_TYPE_ERROR: //错误  
	                            cellValue = "错误";  
	                            break;  
	                        case Cell.CELL_TYPE_FORMULA: //公式  
	                            cellValue = "错误";  
	                            break;  
	                        default:  
	                            cellValue = "错误";  
	                    }  
	                    System.out.print(cellValue + "    ");  
	                }  
	                System.out.println();  
	            }  
	        }  
	  
	    }  
	    catch (Exception e) {  
	        e.printStackTrace();  
	    }  
	  
	    return SUCCESS;  
	}
}
