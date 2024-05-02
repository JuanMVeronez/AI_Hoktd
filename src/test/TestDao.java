package test;

import dao.InputInstance;
import entity.Table;

public class TestDao {
	
	public static void main(String[] args) {
		Table t = InputInstance.getInstance("files/inst01.in");
		System.err.println(t);
	}

}
