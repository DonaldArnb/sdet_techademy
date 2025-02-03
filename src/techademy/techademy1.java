/*Comprehensive Assignment 1*/
/*Java Program to read the data from excel sheet, print them directly
Data to Excel File Using Apache POI */


package techademy;

//Imports
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell; 
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Main class 
public class techademy1 { 

	// Main driver method 
	public static void main(String[] args) 
	{ 

		// Try block to check for exceptions 
		try { 

			// Read file from local directory 
			FileInputStream file = new FileInputStream( 
				new File("C:\\Work\\Eclipse-Workspace\\techademy\\externalData\\techademy_1.xlsx")); 

			// Create Workbook instance holding reference to 
			XSSFWorkbook workbook = new XSSFWorkbook(file); 

			// Get first/desired sheet from the workbook 
			XSSFSheet sheet = workbook.getSheetAt(0); 

			// Iterate through each rows one by one 
			Iterator<Row> rowIterator = sheet.iterator(); 

			// Till there is an element condition holds true 
			while (rowIterator.hasNext()) { 

				Row row = rowIterator.next(); 

				// For each row, iterate through all the 
				Iterator<Cell> cellIterator 
					= row.cellIterator(); 

				while (cellIterator.hasNext()) { 

					Cell cell = cellIterator.next(); 

					// Checking the cell type and format 
					// accordingly 
					switch (cell.getCellType()) { 
					case Cell.CELL_TYPE_STRING: 
						System.out.print( 
							cell.getStringCellValue() 
							+" "); 
						break; 
					} 
				} 

				System.out.println(""); 
			} 

			// Closing file output streams 
			file.close(); 
		} 

		// Catch block to handle exceptions 
		catch (Exception e) { 

			// Display the exception along with line number 
			// using printStackTrace() method 
			e.printStackTrace(); 
		} 
	} 
}
