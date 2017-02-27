package Douya.DouyaSpider;

import cn.ivan.spider.utils.PageUtils;

public class Main {
	public static void main(String[] args) {
		String x=PageUtils.getContent("http://blog.csdn.net/jackfrued");
		System.out.println(x);
		
		
		
	}
}
