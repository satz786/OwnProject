package utilsPack;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Readexcel {
	
	
	@SuppressWarnings("resource")
	public static String[][] ReadExcelData(String File) throws IOException
	{
		XSSFWorkbook book = new XSSFWorkbook("./Testdata/"+File);
		XSSFSheet sheet = book.getSheetAt(0);
		int Rowcount = sheet.getLastRowNum();
		System.out.println(Rowcount);
		int colcount = sheet.getRow(0).getLastCellNum();
		System.out.println(colcount);
		
		String data[][] = new String[Rowcount][colcount];
		
		for(int i = 1 ; i<=Rowcount ; i++)
		{
			for(int j=0; j<colcount ; j++)
			{
				String stringCellValue = sheet.getRow(i).getCell(j).getStringCellValue();
				data[i-1][j] = stringCellValue;
				System.out.println(stringCellValue);
			}
			
		}
		
		return data;
		
		
	}
	
	
}
