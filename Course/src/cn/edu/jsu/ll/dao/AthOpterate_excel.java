package cn.edu.jsu.ll.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Vector;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AthOpterate_excel {
	public static void main(String[] agrs) {
		Vector<Vector> vec=new UserMatch().getSelectAll("select * from Athlete");
    	File file =new File("D:"+File.separator+"java"+File.separator+"b.xlsx");
    	 Workbook workbook=new XSSFWorkbook();//��������������
		  Sheet sheet = workbook.createSheet("test1");//��������������
		  for(int i=0;i<vec.size();i++){
			  Row row = sheet.createRow(i);// �����ж����±��0��ʼ
			  for(int j=0;j<vec.get(i).size();j++){
				    Cell cell = row.createCell(j);//������Ԫ�񣬴�0��ʼ
				    cell.setCellValue(vec.get(i).get(j)+"");//��Ԫ����������
			  }
		  }
		  
		 FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			workbook.write(fos);//������д�뵽ָ����excel�ĵ�
		  fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//�������������
		  
	}
	
}