package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders 
{
  @DataProvider(name ="LoginData")
  public String [][] getdataforlogin() throws IOException 
  {
	  String excelfilepath = ".\\testData\\logindata.xlsx";
	  ExcelUtilities excel = new ExcelUtilities(excelfilepath);
	  int rows=excel.getRowCount("Sheet1");
	  int cols = excel.getCellCount("Sheet1", 1);
	  
	  String logindata[][] = new String [rows][cols];
	  
	  for(int r=1;r<=rows;r++)
	  {
		  for(int c=0;c<cols;c++)
		  {
			  logindata[r-1][c]=excel.getCellData("Sheet1", r, c);
		  }
	  }
	  return logindata;
	  
  }
  
  
  @DataProvider(name = "Contactdata")
  public String [][] getdataforcontact() throws IOException
  {
	  String contactexcelpath = ".\\testData\\contactdata.xlsx";
	  ExcelUtilities excel = new ExcelUtilities(contactexcelpath);
	  int rows=excel.getRowCount("Sheet1");
	  int cols=excel.getCellCount("Sheet1", 1);
	  
	  String contactdata [][]= new String [rows][cols];
	  
	  for(int r=1;r<=rows;r++)
	  {
		  for(int c=0;c<cols;c++)
		  {
			  contactdata[r-1][c]=excel.getCellData("Sheet1", r, c);
		  }
	  }
	  
	  return contactdata;
  }
  
  
}
