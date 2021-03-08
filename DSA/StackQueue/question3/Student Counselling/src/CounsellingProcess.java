import java.util.*;
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Iterator;  

import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  

public class CounsellingProcess {
	public void getAllocatedProgram(File collegeInfo, File studentInfo){
		try {
			FileInputStream finCollegeInfo = new FileInputStream(collegeInfo);
			FileInputStream finStudentInfo = new FileInputStream(studentInfo);
			Map<String,Integer> courseCap = new HashMap<String,Integer>();
			XSSFWorkbook wbCollegeInfo = new XSSFWorkbook(finCollegeInfo);
			XSSFWorkbook wbStudentInfo = new XSSFWorkbook(finStudentInfo);
			XSSFSheet collegeInfoSheet = wbCollegeInfo.getSheetAt(0);
			XSSFSheet studentInfoSheet = wbStudentInfo.getSheetAt(0);
			Iterator<Row> itrCollege = collegeInfoSheet.iterator();
			Iterator<Row> itrStudent = studentInfoSheet.iterator();
			Queue<Student> student = new LinkedList<Student>();
			while(itrCollege.hasNext()){
				Row row = itrCollege.next();
				Iterator<Cell> itrCell = row.cellIterator();
				while(itrCell.hasNext()){
					Cell cell = itrCell.next();
					String course = cell.getStringCellValue();
					cell = itrCell.next();
					int capacity = (int) cell.getNumericCellValue();
					courseCap.put(course, capacity);
				}
			}
			while(itrStudent.hasNext()){
				Row row = itrStudent.next();
				Iterator<Cell> itrCell = row.cellIterator();
				while(itrCell.hasNext()){
					Cell cell = itrCell.next();
					String studentName = cell.getStringCellValue();
					String studentProgram[] = new String[5];
					for(int i = 0 ; i < 5 ; i++){
						cell = itrCell.next();
						studentProgram[i] = cell.getStringCellValue();
					}
					Student newStudent = new Student(studentName, studentProgram);
					student.add(newStudent);
				}
			}
			List<Admission> admission = new ArrayList<Admission>();
			while(!student.isEmpty()){
				Student top = student.peek();
				for(int j = 0 ; j < 5 ; j++){
					if(courseCap.get(top.getProgram(j)) > 0){
						courseCap.put(top.getProgram(j),courseCap.
								get(top.getProgram(j))-1);
						admission.add(new Admission(top.getName(), top.getProgram(j)));
						break;
					}
				}
				student.poll();
			}
			XSSFWorkbook wbAdmittedStudent = new XSSFWorkbook();
			XSSFSheet admittedStudentSheet = wbAdmittedStudent
										     .createSheet("Admitted Student");
			int rowCount = -1;
			for(int i = 0 ; i < admission.size() ; i++){
				Row row = admittedStudentSheet.createRow(++rowCount);
				Cell name = row.createCell(0);
				name.setCellValue(admission.get(i).getStudentName());
				Cell course = row.createCell(1);
				course.setCellValue(admission.get(i).getStudentCourse());
			}
			FileOutputStream ostream = new FileOutputStream("Admit.xlsx");
			wbAdmittedStudent.write(ostream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
