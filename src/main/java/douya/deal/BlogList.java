package douya.deal;

import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;

import douya.bean.CsdnPage;
import douya.douyaSpider.App;
import douya.store.MysqlStore;
import douya.utils.HtmlUtils;

 

public class BlogList {
	public static void process(String data) {
		CsdnPage csdn=new CsdnPage();
		// TODO Auto-generated method stub
		HtmlCleaner htmlCleaner = new HtmlCleaner();
		// 相当于htmlcleaner对页面进行处理
		TagNode rootNode = htmlCleaner.clean(data );
	 
		//String next_url = HtmlUtils.getAttributeByAttr(rootNode, "//*[@id=\"J_topPage\"]/a[2]", "href");
		String next_url = HtmlUtils.getAttributeByAttr(rootNode, "//*[@class=\"article_title\"][1]", "html");
		Object[] evaluateXPath;
		try {
			evaluateXPath = rootNode.evaluateXPath("//*[@class=\"article_title\"]");
		
			for (Object object : evaluateXPath) {
				TagNode tagNode = (TagNode)object;
				CharSequence goodsUrl =  tagNode.getText();
				String s=goodsUrl.toString();
				s=s.trim().replace("\r\n", "").replace(" ", "");
				System.out.println(App.NUMBER++ +s);
				// MysqlStore.insert(s, s, s);
				App.redis.add("x"+s, s);
				int x=0;
				x++;
		//		data.addUrl(goodsUrl);
			}
		} catch (XPatherException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	 
			
	}

	public static int getAllPage(String x) {
		// TODO Auto-generated method stub
		int allPage=1;
		try {
		HtmlCleaner htmlCleaner = new HtmlCleaner();
		// 相当于htmlcleaner对页面进行处理
		TagNode rootNode = htmlCleaner.clean(x );
	 
		//String next_url = HtmlUtils.getAttributeByAttr(rootNode, "//*[@id=\"J_topPage\"]/a[2]", "href");
		String next_url = HtmlUtils.getAttributeByAttr(rootNode, "//*[@class=\"article_title\"][1]", "html");
		 
	 
		Object[] evaluateXPath;
		
	
			evaluateXPath = rootNode.evaluateXPath("//*[@id=\"papelist\"]");
		if(evaluateXPath==null)
			allPage=1;
		else{
			TagNode tagNode = (TagNode)evaluateXPath[0];
			evaluateXPath = tagNode.evaluateXPath("//a[last()]"); //获取最后一个标签的地址
			tagNode= (TagNode)evaluateXPath[0];
			String lasturl = HtmlUtils.getAttributeByAttr(tagNode, ".", "href");
			String lastN=lasturl.substring(lasturl.lastIndexOf("/")+1);
			allPage=Integer.parseInt(lastN);
					
			 
		}
		}
		catch(Exception e)
		{
			allPage=1;
		}
	 
		return allPage;
		
	}
	 
}
