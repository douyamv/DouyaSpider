package douya.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsdnPage {
	public String title;
	public String url;
	public String content;
	public Map<String,String> values =new HashMap<String, String>();
	public List<String> urls = new ArrayList<String>();//保存页面中解析出来的url
}
