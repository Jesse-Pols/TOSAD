package hu.tosad2019.groep4.generator.dataaccess.communication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TempGenerator implements Runnable {

	private static TempGenerator INSTANCE = new TempGenerator();
	
	private Thread t;
	private List<String> steps = new ArrayList<String>();
	
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
	public List<String> getSteps() { return Collections.unmodifiableList(this.steps); }
	private void addStep(String message) {
		this.steps.add(message);
	}
	
	private void classsleep(long ms){
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {}
	}
	private void sleepRandomTime() {
		this.classsleep(Math.round(Math.random() * 5 * 1000 + 500));
	}
	
	@Override
	public void run() {
		System.out.println("generation started");
		this.addStep("generation started");
		this.sleepRandomTime();
		this.addStep("Step 1");
		System.out.println("1");
		this.sleepRandomTime();
		this.addStep("Step 2");
		System.out.println("2");
		this.sleepRandomTime();
		this.addStep("Step 3");
		System.out.println("3");
		this.sleepRandomTime();
		this.addStep("Step 4");
		System.out.println("4");
		this.sleepRandomTime();
		this.addStep("Step 5");
		System.out.println("5");
		this.sleepRandomTime();
		this.addStep("generation finished");
		System.out.println("generation finished");
	}
}
