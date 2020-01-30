package hu.tosad2019.groep4.designer.presentation.ui;

public class WindowManager implements WindowManagerFacade {

	private static WindowManager instance;
	private MainWindow mainWindow = new MainWindow();
	private AddRuleWindow addRuleWindow = new AddRuleWindow();
	
	private WindowManager() {}

	public static WindowManager getInstance() {

		if (WindowManager.instance == null) {
			instance = new WindowManager();
		}

		return instance;
	}
	
	public void openMainWindow() {
		if(this.mainWindow.isActive()) return;
		this.mainWindow.create();
	}
	public void openAddRuleWindow() {
		if(this.addRuleWindow.isActive()) return;
		this.addRuleWindow.create();
	}
	public void closeAddRuleWindow() {
		this.addRuleWindow.close();
		this.addRuleWindow = new AddRuleWindow();
	}
	public void closeall() {
		if(this.addRuleWindow.isActive()) {
			this.closeAddRuleWindow();
		}
	}
}
