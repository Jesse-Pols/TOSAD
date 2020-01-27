package hu.tosad2019.groep4.generator.application.application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TempGenerator implements Runnable {

	private static TempGenerator INSTANCE = new TempGenerator();
	
	private Thread t;

	
	private TempGenerator() {}
	
	public static TempGenerator getInstance() {
		return TempGenerator.INSTANCE;
	}
	
	public void startGeneration() {
		System.out.println("Starting generator");
		this.t = new Thread(this, "generator");
		this.t.start();
	}
	public boolean getIsRunning() { return this.t!=null && this.t.isAlive(); }



	@Override
	public void run() {
	}
}
