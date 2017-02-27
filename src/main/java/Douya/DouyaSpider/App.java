package douya.douyaSpider;

import douya.utils.PageUtils;

/**
 *  
 *
 */
public class App {
	public static void main(String[] args) {
		String x = PageUtils.getContent("http://blog.csdn.net/jackfrued");
		System.out.println(x);

	}
}
