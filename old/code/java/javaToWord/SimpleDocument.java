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
    // 设置上下左右四个方向的距离，可以将表格撑大
//    table.setCellMargins(20, 20, 20, 20);
    // table.set
    List<XWPFTableCell> tableCells = table.getRow(0).getTableCells();
    tableCells.get(0).setText("第一行第一列的数据");
    tableCells.get(1).setText("第一行第二列的数据");
    
    List<XWPFTableCell> tableCellsq = table.getRow(1).getTableCells();
    tableCellsq.get(0).setText("第二行第二列的数据");
    tableCellsq.get(1).setText("第二行第二列的数据");
    
    // 设置字体对齐方式
    p1.setAlignment(ParagraphAlignment.CENTER);
    p1.setVerticalAlignment(TextAlignment.TOP);
    // 第一页要使用p1所定义的属性
    XWPFRun r1 = p1.createRun();
    // 设置字体是否加粗
    r1.setBold(true);
    r1.setFontSize(20);
    // 设置使用何种字体
    r1.setFontFamily("Courier");
    // 设置上下两行之间的间距
    r1.setTextPosition(20);
    r1.setText("公司招聘会入场须知");
    
    // 设置个人信息
    XWPFParagraph p2 = doc.createParagraph();
    p2.setAlignment(ParagraphAlignment.LEFT);
    XWPFRun r2 = p2.createRun();
    r2.setTextPosition(15);
    r2.setText("姓名" + "                    " + "张三");
    r2.addCarriageReturn();
    r2.setText("性别" + "                    " + "女");
    r2.addCarriageReturn();
    r2.setText("手机号" + "               " + "12345678965");
    r2.addCarriageReturn();
    r2.setText("邮箱" + "                    " + "123@163.com");
    r2.addCarriageReturn();
    r2.setText("开始时间" + "      " + "2013-05-28 12:30");
    r2.addCarriageReturn();
    r2.setText("结束时间" + "      " + "2013-05-28 13:20");
    r2.addCarriageReturn();
    
    // 存放试题信息
    XWPFParagraph p3 = doc.createParagraph();
    p3.setWordWrap(true);
    XWPFRun r3 = p3.createRun();
    r3.setTextPosition(10);
    r3.setFontSize(15);
    r3.setText("一、选择题（共50分）");
    // 题目和选项
    XWPFParagraph p4 = doc.createParagraph();
    p4.setWordWrap(true);
    XWPFRun r4 = p4.createRun();
    r4.setTextPosition(13);
    r4.setText("    1、下面说法正确的是？（3分）");
    r4.addCarriageReturn();
    r4.setText("        A:子类如果使用父类的方法必须使用super关键字");
    r4.addCarriageReturn();
    r4.setText("        B:子类如果使用父类的方法必须使用super关键字");
    r4.addCarriageReturn();
    r4.setText("        C:子类如果使用父类的方法必须使用super关键字");
    r4.addCarriageReturn();
    r4.setText("        D:子类如果使用父类的方法必须使用super关键字");
    r4.addCarriageReturn();
    r4.setText("正确答案：ABCD");
    r4.setText("选择答案：AC");
    
    // 判断题
    XWPFParagraph p5 = doc.createParagraph();
    p5.setWordWrap(true);
    XWPFRun r5 = p5.createRun();
    r5.setTextPosition(10);
    r5.setFontSize(15);
    r5.setText("一、判断题（共50分）");
    XWPFParagraph p6 = doc.createParagraph();
    p6.setWordWrap(true);
    // 题目
    int i;
    for (i = 0; i < 5; i++) {
      XWPFRun r6 = p6.createRun();
      r6.setTextPosition(13);
      r6.setText("1、子类如果使用父类的方法必须使用super关键字(5分)");
      r6.addCarriageReturn();
      r6.setText("正确答案：对");
      r6.setText("      ");
      r6.setSubscript(VerticalAlign.BASELINE);
      r6.setText("选择答案：");
      XWPFRun r7 = p6.createRun();
      r7.setTextPosition(13);
      // 控制某一个字体颜色为红色
      if (i == 3) {
       // r7.setColor("FF0000");
      }
      r7.setText("错");
      r7.addCarriageReturn();
    }
    FileOutputStream out = new FileOutputStream("E:\\simple.docx");
    doc.write(out);
    out.close();
    System.out.println("success");
  }
}

