import javax.swing.JFrame;

public class Main extends JFrame {
	//Variables used throughout the Frame & Panel
	private final static String FRAME_TITLE = "Pongers";
	private final static int WINDOW_WIDTH = 1280;
	private final static int WINDOW_HEIGHT = 720;
	
	
	// main method
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Main();
			}
		});
	} // end of main method

	
	
	
	
	public Main () { //Constructor for JFrame
				
		setTitle(FRAME_TITLE);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new Panel() ); //add our JPanel to the frame
		
	}
	
	
	
}
