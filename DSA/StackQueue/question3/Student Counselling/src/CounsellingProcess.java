import java.util.*;
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;
import java.util.Iterator;  

import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  

public class CounsellingProcess {
	public void getAllocatedProgram(File collegeInfo, File studentInfo){
		try {
			FileInputStream finCollegeInfo = new FileInputStream(collegeInfo);
			FileInputStream finStudentInfo = new FileInputStream(studentInfo);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
