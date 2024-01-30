import javax.swing.JFrame;

public class MainClass {
	
	public static void main(String args[]) {
		Page1 page1 = new Page1();
		MainJFrame mainframe = new MainJFrame();
	
		
		JFrame FirstPage = page1.getbuild();
		mainframe.loadData();
		
		
	}
	
}	
