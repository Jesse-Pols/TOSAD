package hu.tosad2019.groep4.designer.presentation;

public class WindowManager implements WindowManagerFacade {

	private static WindowManager INSTANCE = new WindowManager();
	private MainWindow mainWindow = new MainWindow();
	private AddRuleWindow addRuleWindow = new AddRuleWindow();
	
	private WindowManager() {}
	
	public static WindowManager getInstance() {
		return WindowManager.INSTANCE; 
	}
	
	public void openMainWindow() {
		this.mainWindow.create();
	}
	public void openAddRuleWindow() {
		this.addRuleWindow.create();
	}
}
