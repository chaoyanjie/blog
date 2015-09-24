package com.poi.util;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.rtf.RtfWriter2;

/**
 * ����word�ĵ� ����: 1,�����ĵ� 2,����һ����д�� 3,���ĵ� 4,���ĵ���д������ 5,�ر��ĵ�
 */
public class WordDemo {

	public WordDemo() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {  
 // ����word�ĵ�,������ֽ�ŵĴ�С
   Document document = new Document(PageSize.A4); 
   try {  
    RtfWriter2.getInstance(document,
 new FileOutputStream("E:/word.doc"));  
 
    document.open();  
     
   //���ú�ͬͷ  
     
   Paragraph ph = new Paragraph();  
   Font f  = new Font();  
     
   Paragraph p = new Paragraph("���ں�ͬ", 
 new Font(Font.NORMAL, 18, Font.BOLDITALIC, new Color(0, 0, 0)) );  
    p.setAlignment(1);  
    document.add(p);  
    ph.setFont(f);  
  
    // ������������  
    // BaseFont bfFont =  
    // BaseFont.createFont("STSongStd-Light",
  // "UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);  
    // Font chinaFont = new Font();  
    /*  
     * ���������еı��  
     */ 
    Table table = new Table(4);  
    document.add(new Paragraph("���ɱ��"));  
    table.setBorderWidth(1);  
    table.setBorderColor(Color.BLACK);  
    table.setPadding(0);  
    table.setSpacing(0);  
      
    /*  
     * ��ӱ�ͷ��Ԫ��  
     */ 
    Cell cell = new Cell("��ͷ");//��Ԫ��  
    cell.setHeader(true);  
    cell.setColspan(3);//���ñ��Ϊ����  
    cell.setRowspan(3);//���ñ��Ϊ����  
    table.addCell(cell);  
    table.endHeaders();// ��ͷ����  
 
    // ��������  
    cell = new Cell("Example cell 2");  
    cell.setRowspan(2);//��ǰ��Ԫ��ռ����,������  
    table.addCell(cell);  
    table.addCell("1,1");  
    table.addCell("1,2");  
    table.addCell("1,3");  
    table.addCell("1,4");  
    table.addCell("1,5");  
    table.addCell(new Paragraph("��java���ɵı��1"));  
    table.addCell(new Paragraph("��java���ɵı��2"));  
    table.addCell(new Paragraph("��java���ɵı��3"));  
    table.addCell(new Paragraph("��java���ɵı��4"));  
    document.add(new Paragraph("��java����word�ļ�"));  
    document.add(table);  
    document.close();  
   } catch (FileNotFoundException e) {  
    e.printStackTrace();  
   } catch (DocumentException e) {  
    e.printStackTrace();  
   } catch (IOException e) {  
    e.printStackTrace();  
   }  
  }
}