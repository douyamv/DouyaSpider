package douya.douyaSpider;

import java.util.ArrayList;

import douya.store.MysqlStore;

public class CrawThread extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		ArrayList<String> users = MysqlStore.getAlluser();

		for (int i = 0; i < users.size(); i++) {
			App.getBlogByUser(users.get(i));
		}
	}
}
