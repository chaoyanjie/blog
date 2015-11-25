package us.codecraft.xsoup;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class MyTest {
	
	
	
	 @Test
		public void test14() throws IOException, InterruptedException {
			String fileName="E:\\data\\data2.txt";
			new FileOperate().createFile(fileName, "数据库");
			for(int i1=1;i1<=1;i1++){
				try{
				String url = "http://www.360doc.com/content/10/0805/10/2289370_43785560.shtml";
				
//				String url = "http://db.yaozh.com/index.php?action=chufang&pre=chufang&page="+i1;
				System.out.println("get:"+url);
				Document document = Jsoup.connect(url).header("User-Agent","Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2").get();
			
				Elements result = Xsoup.select(document, "//*[@id=articlecontent]/table/tbody/tr/td/div/html()").getElements();
//	 		System.out.println(guolv(result.get(0).text()));
				 for (int i = 0; i < result.size(); i++) {
					 System.out.println(guolv(result.get(0).text()));
				}
				Thread.currentThread().sleep(3000);
				
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					continue; 
				}
			}
		
			// Document document = Jsoup.parse(htmlClass);
			// Document document = Jsoup.parse(input, "UTF-8",
			// "http://example.com/");
			
		}
	
//	 @Test
		public void test13() throws IOException, InterruptedException {
		 List<String> list=JavaFile.getUrl();
			String fileName="E:\\data\\data2.txt";
			new FileOperate().createFile(fileName, "数据库");
			for(int i1=0;i1<=list.size();i1++){
				try{
				String url = list.get(i1);
				
//				String url = "http://db.yaozh.com/index.php?action=chufang&pre=chufang&page="+i1;
				System.out.println("get:"+url);
				Document document = Jsoup.connect(url).header("User-Agent","Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2").get();
			
				Elements result = Xsoup.select(document, "//div[@style=line-height:20px;]/html()").getElements();
//				 System.out.println(result.size());
				 String  sql="INSERT INTO `tests`.`shiwu` (`name`, `bname`, `cnName`, `xing`, `wei`, `guijing`, `gx`, `shiyi`, `jj`, `td`, `ms`)VALUES(";
	 		
				 for (int i = 0; i < result.size(); i++) {
	 				
//					Elements temps = Xsoup.select(result.get(i), "/span/html()")
//							.getElements();
					 
					sql+="'"+guolv(result.get(i).text())+"',";
//					for (Element e : temps) {
//						System.out.println("http://www.byb.cn"+e.getElementsByTag("a").get(0).attr("href"));
//						System.out.println(e.getElementsByTag("a").get(0).text());
//						String ttt=guolv(e.text());
//					}
				 
//					FileOperate.appendMethodB(fileName, buf);
				}
				 sql=sql.substring(0,sql.length()-1);
				 sql+=");";
				 System.out.println(sql);
				Thread.currentThread().sleep(3000);
				
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					continue; 
				}
			}
		
			// Document document = Jsoup.parse(htmlClass);
			// Document document = Jsoup.parse(input, "UTF-8",
			// "http://example.com/");
			
		}
	
//	 @Test
		public void test12() throws IOException, InterruptedException {
			String fileName="E:\\data\\data2.txt";
			new FileOperate().createFile(fileName, "数据库");
			for(int i1=1;i1<=1;i1++){
				try{
				String url = "http://www.byb.cn/foodslist.aspx";
				
//				String url = "http://db.yaozh.com/index.php?action=chufang&pre=chufang&page="+i1;
				System.out.println("get:"+url);
				Document document = Jsoup.connect(url).header("User-Agent","Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2").get();
			
				Elements result = Xsoup.select(document, "//div[@class=part]/html()").getElements();
				
	 			for (int i = 0; i < result.size(); i++) {
					Elements temps = Xsoup.select(result.get(i), "/ul/li/html()")
							.getElements();
					 
					for (Element e : temps) {
						System.out.println("http://www.byb.cn"+e.getElementsByTag("a").get(0).attr("href"));
//						System.out.println(e.getElementsByTag("a").get(0).text());
//						String ttt=guolv(e.text());
					}
				 
//					FileOperate.appendMethodB(fileName, buf);
				}
				 
				Thread.currentThread().sleep(3000);
				
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					continue; 
				}
			}
		
			// Document document = Jsoup.parse(htmlClass);
			// Document document = Jsoup.parse(input, "UTF-8",
			// "http://example.com/");
			
		}
	
	
//	 @Test
		public void test11() throws IOException, InterruptedException {
			String fileName="E:\\data\\data1.txt";
			new FileOperate().createFile(fileName, "数据库");
			for(int i1=1;i1<=8;i1++){
				try{
				String url = "http://db.yaozh.com/index.php?action=fangji&pre=fangji&page="+i1;
				
//				String url = "http://db.yaozh.com/index.php?action=chufang&pre=chufang&page="+i1;
				System.out.println("get:"+url);
				Document document = Jsoup.connect(url).header("User-Agent","Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2").get();
			
				Elements result = Xsoup.select(document, "//div[@id=list]/table/tbody/tr/html()").getElements();
	// System.out.println(result.toString());
	 
//	 String  buf1="INSERT INTO `tests`.`shujuk` 	(`fm`, 	`cc`, 	`fl`, `zc`, 	`gy`, 	`zz`,`yf`, 	`jj`, 	`fj`, `hc`,	`ff`, 	`fz`, `wx`, 	`yj`, 	`yy`	)	VALUES	(";
//	 String o=");";
//	String [] tempStr=new String[15];	
	
//	int cc1=0;
	 			for (int i = 0; i < result.size(); i++) {
					Elements temps = Xsoup.select(result.get(i), "/td/html()")
							.getElements();
					String buf="";
					int cc=1;
					for (Element e : temps) {
						String ttt=guolv(e.text());
						buf+=ttt+"|";
						if(cc==2){
							System.out.print(ttt+",");
						}
						if(cc==3){
							System.out.println(ttt);
						}
						cc++;
//						System.err.println(cc+":"+ttt);
						 
					}
					buf+="\n";
					FileOperate.appendMethodB(fileName, buf);
				}
	 
	  
				 
				Thread.currentThread().sleep(3000);
				
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					continue; 
				}
			}
		
			// Document document = Jsoup.parse(htmlClass);
			// Document document = Jsoup.parse(input, "UTF-8",
			// "http://example.com/");
			
		}
	 
//	 @Test
	public void test1() throws IOException, InterruptedException {
		String fileName="E:\\data\\data.txt";
		new FileOperate().createFile(fileName, "数据库");
		for(int i1=1;i1<=150;i1++){
			try{
			String url = "http://db.yaozh.com/fangji/20110225/"+i1+".html";
//			String url = "http://db.yaozh.com/index.php?action=chufang&pre=chufang&page="+i1;
			System.out.println("get:"+url);
			Document document = Jsoup.connect(url).header("User-Agent","Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2").get();
		
			Elements result = Xsoup.select(document, "//div[@id=text]/div/table/tbody/tr/html()").getElements();
// System.out.println(result.toString());
 
 String  buf1="INSERT INTO `tests`.`shujuk` 	(`fm`, 	`cc`, 	`fl`, `zc`, 	`gy`, 	`zz`,`yf`, 	`jj`, 	`fj`, `hc`,	`ff`, 	`fz`, `wx`, 	`yj`, 	`yy`	)	VALUES	(";
 String o=");";
String [] tempStr=new String[15];	
int cc=1;
int cc1=0;
 			for (int i = 0; i < result.size(); i++) {
				Elements temps = Xsoup.select(result.get(i), "/td/html()")
						.getElements();
				String buf="";
				
				for (Element e : temps) {
					String ttt=guolv(e.text());
					buf+=ttt+"|";
//					System.err.println(cc+":"+ttt);
					if(cc%2==0){
						tempStr[cc1]=ttt;
						cc1++;
					}
					cc++;
				}
				buf+="\n";
				FileOperate.appendMethodB(fileName, buf);
			}
 
 for(String s:tempStr){
	 buf1+="'"+s+"',";
 }
 
 System.out.println(buf1.substring(0,buf1.length()-1)+o);
			 
			Thread.currentThread().sleep(3000);
			
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				continue; 
			}
		}
	
		// Document document = Jsoup.parse(htmlClass);
		// Document document = Jsoup.parse(input, "UTF-8",
		// "http://example.com/");
		
	}

//	@Test
	public void test2() {
		String htmls = "<html><body><table> <tr class=\"title\">   <td class=\"left\" style=\"width:100px\">药品名称</td>   <td class=\"left\" style=\" width:150px\">标准来源</td>   <td style=\"width:30px\">页码</td>   <td>处方</td>   <td style=\" width:60px;\">查看全文</td>  </tr>  <tr class=\"d\">   <td class=\"left\"><a href=\"/chufang/19700101/1.html\">生精胶囊</a></td>   <td class=\"left\">国家中成药标准汇编 内科 肾系 分册</td>   <td>1 </td>   <td class=\"left break-word\" style=\"word-break: break-all; word-wrap:break-word\">鹿茸46.4g． 枸杞子46.4g． 人参46.4g． 冬虫夏草46.4g． 菟丝子46.4g． 沙苑子46.4g． 淫羊藿46.4g． 黄精46.4g． 何首乌92.8g． 桑椹46.4g． 补骨脂46.4g． 骨碎补92.8g． 仙茅46.4g． 金樱子46.4g． 覆盆子46.4g． 杜仲46.4g． 大血藤46.4g． 马鞭草46.4g． 银杏叶92.8g．</td>   <td><a href=\"/chufang/19700101/1.html\" target=\"_blank\">查看全文</a></td>  </tr>  </table></body></html>";
		Document document = Jsoup.parse(htmls);
		// XElements els=Xsoup.select(document, "//table/html()");
		// System.out.println(Xsoup.select(document, "//table/html()").get());
		String fileName="E:\\data\\data.txt";
		new FileOperate().createFile(fileName, "数据库");
		Elements result = Xsoup.select(document, "//table/tbody/tr/html()")
				.getElements();
		for (int i = 0; i < result.size(); i++) {
			Elements temps = Xsoup.select(result.get(i), "/td/html()")
					.getElements();
			String  buf="";
			for (Element e : temps) {
				buf+=e.text()+"|";
			}
			buf+="\n";
			FileOperate.appendMethodB(fileName, buf);
		}
	}
	
	public String guolv(String content){
	 
		// 过滤文章内容中的html
		content = content.replaceAll("</?[^<]+>", "");
		// 去除字符串中的空格 回车 换行符 制表符 等
		content = content.replaceAll("\\s*|\t|\r|\n", "");
		// 去除空格
		content = content.replaceAll("&nbsp;", "");
		// 去掉其他一些字符
//		content = content.replaceAll("\\\\","");
		return content;
	}
}
