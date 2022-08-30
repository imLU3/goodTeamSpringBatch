package com.batch.goodTeam.tasklet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.batch.goodTeam.entity.MyUser;
import com.batch.goodTeam.repository.UserRepository;

@Component
public class WorkBookTasklet  implements Tasklet{

	@Autowired
	private UserRepository userRepos;

	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	static String[] HEADERs = { "id", "name", "dept", "salary" };
	static String SHEET = "EMP";

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		try {
			File myFile = new File("C:\\Develop/EMP.xlsx");
			FileInputStream fis = new FileInputStream(myFile);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
				XSSFSheet sheet = workbook.getSheetAt(0);
				
				// Get iterator to all the rows in current sheet
				Iterator<Row> rows = sheet.iterator();
				
				List<MyUser> emps = new ArrayList<MyUser>();
				int rowNumber = 0;
				while (rows.hasNext()) {
					Row currentRow = rows.next();
					// skip header
					if (rowNumber == 0) {
						rowNumber++;
						continue;
					}
					Iterator<Cell> cellsInRow = currentRow.iterator();
					MyUser emp = new MyUser();
					int cellIdx = 0;
					while (cellsInRow.hasNext()) {
						Cell currentCell = cellsInRow.next();
						switch (cellIdx) {
						case 0:
							emp.setId((int) Math.round(currentCell.getNumericCellValue()));
							break;
						case 1:
							emp.setName(currentCell.getStringCellValue());
							break;
						case 2:
							emp.setDept(String.valueOf(currentCell.getNumericCellValue()));
							break;
						case 3:
							emp.setSalary((int) Math.round(currentCell.getNumericCellValue()));
							break;
						default:
							break;
						}
						cellIdx++;
					}
					emps.add(emp);
				}
				workbook.close();
//				userRepos.saveAll(emps);
				System.err.println(emps);
				System.err.println("name " + emps.get(0).getName());
			} catch (IOException e) {
				throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
			}
		return RepeatStatus.FINISHED;
	}
}
