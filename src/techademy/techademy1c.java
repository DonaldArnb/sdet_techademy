/*Comprehensive Assignment 1-c*/
/*Java Program to read the data from excel sheet, store it in a collection and print them 
Data to Excel File Using Apache POI */

package techademy;

//Import statements 
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;


import org.apache.poi.ss.usermodel.Cell; 
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Main class 
public class techademy1c { 

	// Main driver method 
	public static void main(String[] args) 
	{ 

		// Try block to check for exceptions 
		try { 

			// Reading file from the local dir 
			FileInputStream file = new FileInputStream( 
			new File("C:\\Work\\Eclipse-Workspace\\techademy\\externalData\\techademy_1.xlsx")); 

			// Create Workbook using Apache POI
			XSSFWorkbook workbook = new XSSFWorkbook(file); 

			// Get sheet from the workbook 
			XSSFSheet sheet = workbook.getSheetAt(0); 
			
			int rowcount = sheet.getLastRowNum()- sheet.getFirstRowNum();
		    for(int i=0; i<rowcount+1; i++){
		        //Create a loop to get the cell values for 1 row - iteration
		        Row row = sheet.getRow(i);
		        List<String> StudentCourses = new ArrayList<String>();
		        for(int j=0; j<row.getLastCellNum(); j++){
		            // Create an object reference of 'Cell' class
		            Cell cell = row.getCell(j);
		            // Add all the cell values of a particular row
		            StudentCourses.add(cell.getStringCellValue());
		            }
		        System.out.println(StudentCourses);
		        }
		}
			
		// Catch block to handle exceptions 
		catch (Exception e) { 
			// Display the exception
			e.printStackTrace(); 
		} 
	} 
}
