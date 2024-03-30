package main;


import javax.swing.JFrame;

public class MainFrame extends JFrame{
	
	public MainFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("joguinho");
		
		GamePanel gamePanel = new GamePanel();
		add(gamePanel);
		
		pack();
		
		setLocationRelativeTo(null);
		setVisible(true);
		
		gamePanel.startGameThread();
//		setUndecorated(true);
//		setExtendedState(JFrame.MAXIMIZED_BOTH); 
//		setLayout(null);
		

    }
	
}
