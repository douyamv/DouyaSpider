package douya.douyaSpider;

import java.util.ArrayList;

import douya.bean.CsdnPage;
import douya.deal.BlogList;
import douya.deal.UserList;
import douya.store.MysqlStore;
import douya.utils.PageUtils;
import douya.utils.RedisUtils;

/**
 *  
 *
 */
public class App {
	public static int NUMBER=0;
	public static RedisUtils redis=new RedisUtils();
	public static void main(String[] args) {
		// String url="http://blog.csdn.net/phphot/article/list/";
		// for( int i=1; i<=320; i++)
		// {
		// String realUrl=url+i;
		// String x = PageUtils.getContent(realUrl);
		// BlogList.process(x);
		// }
		
		
		for( int i=0; i<20; i++)
		{
				 Thread t=new CrawThread();
				 t.start();
		}
		
		/*
		 * ///craw user String
		 * expert_Url="http://blog.csdn.net/peoplelist.html?channelid=0&page=";
		 * for( int i=1; i<=115; i++) { String realUrl=expert_Url+i; String x =
		 * PageUtils.getContent(realUrl); UserList.process(x); }
		 */
	}

	public static void getBlogByUser(String user) {
		int allPage = 1;
		String url = "http://blog.csdn.net/" + user + "/article/list/";
		try {

			String testpage = PageUtils.getContent(url + 1);
			allPage = BlogList.getAllPage(testpage);

		} catch (Exception e) {
			// TODO: handle exception
		}
		for (int i = 1; i <= allPage; i++) {
			try {

				String realUrl = url + i;
				String x = PageUtils.getContent(realUrl);
				BlogList.process(x);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
