package cn.ivan.spider.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 页面帮助类
 * 
 * @author Hades
 *
 */
public class PageUtils {
	static Logger logger = LoggerFactory.getLogger(PageUtils.class);

	/**
	 * 根据url获取页面内容
	 * 
	 * @param url
	 * @return
	 */
	public static String getContent(String url) {
		HttpClientBuilder builder = HttpClients.custom();
		// 创建一个链接
		/*
		 * 设置代理,注意：代理ip和端口在这不能写死。因为代理可能会随时失效，我们需要有一个代理IP库,代理ip库使用redis中list列表实现
		 * 可以把这些代理信息保存到redis的list列表中，存储格式为ip:port
		 * 使用的时候就从list中取一个，取出来之后使用：分割出来ip和端口即可。
		 */
		String proxy_ip = "110.73.3.225";
		int proxy_port = 8000;
		HttpHost proxy = new HttpHost(proxy_ip, proxy_port);
		// 表示获取httpclient对象
		CloseableHttpClient client = builder/* .setProxy(proxy ) */.build();
		HttpGet request = new HttpGet(url);
		// 設置httpGet的头部參數信息
		request.setHeader("Accept", "Accept text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		request.setHeader("Accept-Charset", "GB2312,utf-8;q=0.7,*;q=0.7");
		request.setHeader("Accept-Encoding", "gzip, deflate");
		request.setHeader("Accept-Language", "zh-cn,zh;q=0.5");
		request.setHeader("Connection", "keep-alive");
		request.setHeader("Cookie", "__utma=226521935.73826752.1323672782.1325068020.1328770420.6;");
		//request.setHeader("Host", "www.csdn.com");
		request.setHeader("refer",
				"http://www.baidu.com/s?tn=monline_5_dg&bs=httpclient4+MultiThreadedHttpConnectionManager");
		request.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:6.0.2) Gecko/20100101 Firefox/6.0.2");
		String content = null;
		try {
			long start_time = System.currentTimeMillis();
			CloseableHttpResponse response = client.execute(request);
			HttpEntity entity = response.getEntity();
			content = EntityUtils.toString(entity);

			// logger.info("当前线程id:{},页面下载成功,url:{},消耗时间：{}",Thread.currentThread().getId(),url,System.currentTimeMillis()-start_time);
		} catch (HttpHostConnectException e) {
			// logger.error("代理ip失效，ip:{},port:{}",proxy_ip,proxy_port);
		} catch (Exception e) {
			// logger.error("页面下载失败,url:{}",url);
		}

		return content;
	}
}
