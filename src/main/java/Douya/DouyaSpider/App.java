package douya.douyaSpider;

import douya.bean.CsdnPage;
import douya.deal.BlogList;
import douya.utils.PageUtils;

/**
 *  
 *
 */
public class App {
	public static void main(String[] args) {
		String url="http://blog.csdn.net/phphot/article/list/";
		for( int i=1; i<=320; i++)
		{
			String realUrl=url+i;
			String x = PageUtils.getContent(realUrl);
			BlogList.process(x); 
		}

	}
}
