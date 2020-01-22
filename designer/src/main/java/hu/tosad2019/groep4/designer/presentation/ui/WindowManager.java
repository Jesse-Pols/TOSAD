package hu.tosad2019.groep4.designer.presentation.ui;

public class WindowManager implements WindowManagerFacade {

	private static WindowManager INSTANCE = new WindowManager();
	private MainWindow mainWindow = new MainWindow();
	private AddRuleWindow addRuleWindow = new AddRuleWindow();
	
	private WindowManager() {}
	
	public static WindowManager getInstance() {
		return WindowManager.INSTANCE; 
	}
	
	public void openMainWindow() {
		if(this.mainWindow.isActive()) return;
		this.mainWindow.create();
	}
	public void openAddRuleWindow() {
		if(this.addRuleWindow.isActive()) return;
		this.addRuleWindow.create();
	}
	public void closeall() {
		if(this.addRuleWindow.isActive()) {
			this.addRuleWindow.close();
			this.addRuleWindow = new AddRuleWindow();
		}
	}
}
