package com.poi.util;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.TextAlignment;
import org.apache.poi.xwpf.usermodel.VerticalAlign;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;

public class SimpleDocument {
  
  /**
   * sd
   */
  public static void main(String[] args) throws Exception {
    XWPFDocument doc = new XWPFDocument();
    XWPFParagraph p1 = doc.createParagraph();
    
    XWPFTable table = doc.createTable(11, 2);
    // �������������ĸ�����ľ��룬���Խ����Ŵ�
//    table.setCellMargins(20, 20, 20, 20);
    // table.set
    List<XWPFTableCell> tableCells = table.getRow(0).getTableCells();
    tableCells.get(0).setText("��һ�е�һ�е�����");
    tableCells.get(1).setText("��һ�еڶ��е�����");
    
    List<XWPFTableCell> tableCellsq = table.getRow(1).getTableCells();
    tableCellsq.get(0).setText("�ڶ��еڶ��е�����");
    tableCellsq.get(1).setText("�ڶ��еڶ��е�����");
    
    // ����������뷽ʽ
    p1.setAlignment(ParagraphAlignment.CENTER);
    p1.setVerticalAlignment(TextAlignment.TOP);
    // ��һҳҪʹ��p1�����������
    XWPFRun r1 = p1.createRun();
    // ���������Ƿ�Ӵ�
    r1.setBold(true);
    r1.setFontSize(20);
    // ����ʹ�ú�������
    r1.setFontFamily("Courier");
    // ������������֮��ļ��
    r1.setTextPosition(20);
    r1.setText("��˾��Ƹ���볡��֪");
    
    // ���ø�����Ϣ
    XWPFParagraph p2 = doc.createParagraph();
    p2.setAlignment(ParagraphAlignment.LEFT);
    XWPFRun r2 = p2.createRun();
    r2.setTextPosition(15);
    r2.setText("����" + "                    " + "����");
    r2.addCarriageReturn();
    r2.setText("�Ա�" + "                    " + "Ů");
    r2.addCarriageReturn();
    r2.setText("�ֻ���" + "               " + "12345678965");
    r2.addCarriageReturn();
    r2.setText("����" + "                    " + "123@163.com");
    r2.addCarriageReturn();
    r2.setText("��ʼʱ��" + "      " + "2013-05-28 12:30");
    r2.addCarriageReturn();
    r2.setText("����ʱ��" + "      " + "2013-05-28 13:20");
    r2.addCarriageReturn();
    
    // ���������Ϣ
    XWPFParagraph p3 = doc.createParagraph();
    p3.setWordWrap(true);
    XWPFRun r3 = p3.createRun();
    r3.setTextPosition(10);
    r3.setFontSize(15);
    r3.setText("һ��ѡ���⣨��50�֣�");
    // ��Ŀ��ѡ��
    XWPFParagraph p4 = doc.createParagraph();
    p4.setWordWrap(true);
    XWPFRun r4 = p4.createRun();
    r4.setTextPosition(13);
    r4.setText("    1������˵����ȷ���ǣ���3�֣�");
    r4.addCarriageReturn();
    r4.setText("        A:�������ʹ�ø���ķ�������ʹ��super�ؼ���");
    r4.addCarriageReturn();
    r4.setText("        B:�������ʹ�ø���ķ�������ʹ��super�ؼ���");
    r4.addCarriageReturn();
    r4.setText("        C:�������ʹ�ø���ķ�������ʹ��super�ؼ���");
    r4.addCarriageReturn();
    r4.setText("        D:�������ʹ�ø���ķ�������ʹ��super�ؼ���");
    r4.addCarriageReturn();
    r4.setText("��ȷ�𰸣�ABCD");
    r4.setText("ѡ��𰸣�AC");
    
    // �ж���
    XWPFParagraph p5 = doc.createParagraph();
    p5.setWordWrap(true);
    XWPFRun r5 = p5.createRun();
    r5.setTextPosition(10);
    r5.setFontSize(15);
    r5.setText("һ���ж��⣨��50�֣�");
    XWPFParagraph p6 = doc.createParagraph();
    p6.setWordWrap(true);
    // ��Ŀ
    int i;
    for (i = 0; i < 5; i++) {
      XWPFRun r6 = p6.createRun();
      r6.setTextPosition(13);
      r6.setText("1���������ʹ�ø���ķ�������ʹ��super�ؼ���(5��)");
      r6.addCarriageReturn();
      r6.setText("��ȷ�𰸣���");
      r6.setText("      ");
      r6.setSubscript(VerticalAlign.BASELINE);
      r6.setText("ѡ��𰸣�");
      XWPFRun r7 = p6.createRun();
      r7.setTextPosition(13);
      // ����ĳһ��������ɫΪ��ɫ
      if (i == 3) {
       // r7.setColor("FF0000");
      }
      r7.setText("��");
      r7.addCarriageReturn();
    }
    FileOutputStream out = new FileOutputStream("E:\\simple.docx");
    doc.write(out);
    out.close();
    System.out.println("success");
  }
}

