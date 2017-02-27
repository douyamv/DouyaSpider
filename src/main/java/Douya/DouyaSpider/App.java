package douya.douyaSpider;

import java.util.ArrayList;

import douya.bean.CsdnPage;
import douya.deal.BlogList;
import douya.deal.UserList;
import douya.store.MysqlStore;
import douya.utils.PageUtils;

/**
 *  
 *
 */
public class App {
	public static void main(String[] args) {
//		String url="http://blog.csdn.net/phphot/article/list/";
//		for( int i=1; i<=320; i++)
//		{
//			String realUrl=url+i;
//			String x = PageUtils.getContent(realUrl);
//			BlogList.process(x); 
//		}
		ArrayList<String > users=MysqlStore.getAlluser();
		for( int i=0; i<users.size(); i++)
		{
			getBlogByUser(users.get(i));
		}
		int x=0;
		x++;
	/*	///craw user
		String  expert_Url="http://blog.csdn.net/peoplelist.html?channelid=0&page=";
		for( int i=1; i<=115; i++)
		{
			String realUrl=expert_Url+i;
			String x = PageUtils.getContent(realUrl);
			UserList.process(x); 
		}*/
	}
		static void getBlogByUser(String user)
		{
			String url="http://blog.csdn.net/"+user+"/article/list/";
			for( int i=1; i<=1; i++)
			{
				try {
					
				
				String realUrl=url+i;
				String x = PageUtils.getContent(realUrl);
				BlogList.process(x); 
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	
	
	
}
