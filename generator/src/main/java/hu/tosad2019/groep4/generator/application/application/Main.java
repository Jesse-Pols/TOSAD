package hu.tosad2019.groep4.generator.application.application;

import hu.tosad2019.groep4.generator.dataaccess.communication.ServerListener;


public class Main
{
	public static void main(String[] args) {
		ServerListener server;
		try {
			server = ServerListener.create(8000);
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
