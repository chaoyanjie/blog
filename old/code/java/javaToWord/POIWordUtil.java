package com.poi.util;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Table;
import org.apache.poi.hwpf.usermodel.TableCell;
import org.apache.poi.hwpf.usermodel.TableIterator;
import org.apache.poi.hwpf.usermodel.TableRow;

public class POIWordUtil {

    public static void main(String[] args) throws Exception {
        Map<String, Text> replaces = new HashMap<String, Text>();

        replaces.put("${username}", Text.str("rongzhi_li"));
        replaces.put("${password}", Text.str("1123456"));
        replaces.put("${author}", Text.str("lee"));

        poiWordTableReplace("t1.doc", "t2.doc", replaces);
    }

    public static void poiWordTableReplace(String sourceFile, String newFile,
            Map<String, Text> replaces) throws Exception {
        FileInputStream in = new FileInputStream(sourceFile);
        HWPFDocument hwpf = new HWPFDocument(in);
        Range range = hwpf.getRange();// �õ��ĵ��Ķ�ȡ��Χ
        TableIterator it = new TableIterator(range);
        // �����ĵ��еı��
        while (it.hasNext()) {
            Table tb = (Table) it.next();
            // �����У�Ĭ�ϴ�0��ʼ
            for (int i = 0; i < tb.numRows(); i++) {
                TableRow tr = tb.getRow(i);
                // �����У�Ĭ�ϴ�0��ʼ
                for (int j = 0; j < tr.numCells(); j++) {
                    TableCell td = tr.getCell(j);// ȡ�õ�Ԫ��
                    // ȡ�õ�Ԫ�������
                    for (int k = 0; k < td.numParagraphs(); k++) {
                        Paragraph para = td.getParagraph(k);

                        String s = para.text();
                        final String old = s;
                        for (String key : replaces.keySet()) {
                            if (s.contains(key)) {
                                s = s.replace(key, replaces.get(key).getText());
                            }
                        }
                        if (!old.equals(s)) {// �б仯
                            para.replaceText(old, s);
                            s = para.text();
                            System.out.println("old:" + old + "->" + "s:" + s);
                        }

                    } // end for
                } // end for
            } // end for
        } // end while

        FileOutputStream out = new FileOutputStream(newFile);
        hwpf.write(out);

        out.flush();
        out.close();

    }
}
