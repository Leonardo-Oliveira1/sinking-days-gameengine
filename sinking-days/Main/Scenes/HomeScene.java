package Scenes;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import Characters.Player;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class HomeScene extends JFrame{
	
	public HomeScene() {
		
		setTitle("joguinho");
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
		setLayout(null);
		setVisible(true);
		
        Player player = new Player();
		add(player.getPlayer());

    }
	
}
