package douya.deal;

import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;

import douya.bean.CsdnPage;
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
				System.out.println(s);
				MysqlStore.insert(s, s, s);
				int x=0;
				x++;
		//		data.addUrl(goodsUrl);
			}
		} catch (XPatherException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	 
			
	}
	 
}
