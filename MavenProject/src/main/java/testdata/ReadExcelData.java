package testdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	XSSFWorkbook wb;
	XSSFSheet sheet;
	public ReadExcelData(String filename,String sheetname) throws IOException
	{
		FileInputStream file =new FileInputStream(new File("C:\\Users\\priyachittu\\git\\Githubtutorial\\MavenProject\\src\\main\\java\\testdata\\"+filename+".xlsx"));
		
		wb =new XSSFWorkbook(file);
		sheet=wb.getSheet(sheetname);
	}
	public String[][] getdata() throws IOException {

		String data[][]=new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=1;i<=sheet.getLastRowNum();i++)
		{
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
			{
				data[i-1][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		return data;
	}
}
