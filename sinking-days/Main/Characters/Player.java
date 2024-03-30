package Characters;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Player implements ActionListener {

    private int x = 100;
    private int y = 100;
    private JLabel player;
    
    private int speed = 5;
    private int width;
    private int height;
    
    private boolean wPressed = false;
    private boolean aPressed = false;
    private boolean sPressed = false;
    private boolean dPressed = false;

    private ImageIcon playerImage_standby = new ImageIcon(getClass().getResource("char_standby.png"));
    private ImageIcon playerImage_left = new ImageIcon(getClass().getResource("char_leftpos.png"));
    private ImageIcon playerImage_right = new ImageIcon(getClass().getResource("char_rightpos.png"));
    private ImageIcon playerImage_top = new ImageIcon(getClass().getResource("char_toppos.png"));

    private ImageIcon playerGif_walking_left = new ImageIcon(getClass().getResource("char_walking_left.gif"));
    private ImageIcon playerGif_walking_right = new ImageIcon(getClass().getResource("char_walking_right.gif"));
    private ImageIcon playerGif_walking_down = new ImageIcon(getClass().getResource("char_walking_down.gif"));
    private ImageIcon playerGif_walking_top = new ImageIcon(getClass().getResource("char_walking_top.gif"));

    public Player() {
        player = new JLabel(playerImage_standby);

        width = playerImage_standby.getIconWidth();
        height = playerImage_standby.getIconHeight();

        player.setBounds(x, y, width, height);
        addMovimento();
    }

    public JLabel getPlayer() {
        return player;
    }

    public void addMovimento() {
        player.setFocusable(true);
        player.requestFocusInWindow();

        player.addKeyListener(new KeyAdapter() {
        	
            public void keyPressed(KeyEvent e) {
                int code = e.getKeyCode();
                
                if (code == KeyEvent.VK_W) wPressed = true;
                if (code == KeyEvent.VK_A) aPressed = true;
                if (code == KeyEvent.VK_S) sPressed = true;
                if (code == KeyEvent.VK_D) dPressed = true;
            }

            public void keyReleased(KeyEvent e) {
                int code = e.getKeyCode();
                if (code == KeyEvent.VK_W) {
                    wPressed = false;
                    player.setIcon(playerImage_top);
                }
                if (code == KeyEvent.VK_A) {
                    aPressed = false;
                    player.setIcon(playerImage_left);
                }
                if (code == KeyEvent.VK_S) {
                    sPressed = false;
                    player.setIcon(playerImage_standby);
                }
                if (code == KeyEvent.VK_D) {
                    dPressed = false;
                    player.setIcon(playerImage_right);
                }
            }
        });

        new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (wPressed && aPressed) movePlayer(-speed, -speed);
                else if (wPressed && dPressed) movePlayer(speed, -speed);
                else if (sPressed && aPressed) movePlayer(-speed, speed);
                else if (sPressed && dPressed) movePlayer(speed, speed);
                else if (wPressed) movePlayer(0, -speed);
                else if (aPressed) movePlayer(-speed, 0);
                else if (sPressed) movePlayer(0, speed);
                else if (dPressed) movePlayer(speed, 0);
            }
        }).start();
    }

    public void movePlayer(int dx, int dy) {
        x = checkFrameLimitsAxisX(x + dx);
        y = checkFrameLimitsAxisY(y + dy);
        
        player.setBounds(x, y, width, height);
        
        playerAnimationMoving(dx, dy);
    }
    
    private int checkFrameLimitsAxisX(int X) {
        if (X < 0) {
            X = 0;
        } else if (X > player.getParent().getWidth() - width) {
            X = player.getParent().getWidth() - width;
        }
        
        return X;
    }
    
    private int checkFrameLimitsAxisY(int Y) {
        if (Y < 0) {
            Y = 0;
        } else if (Y > player.getParent().getHeight() - height) {
            Y = player.getParent().getHeight() - height;
        }
        
        return Y;
    }

    private void playerAnimationMoving(int dx, int dy) {
        if(dx < 0) {
        	player.setIcon(playerGif_walking_left);
        } else if(dx > 0){
        	player.setIcon(playerGif_walking_right);
        }
        
        if(dy < 0 && dx == 0) {
        	player.setIcon(playerGif_walking_top);
        } else if (dy > 0 && dx == 0) {
        	player.setIcon(playerGif_walking_down);
        }
    }
    
	public void actionPerformed(ActionEvent e) {}

}
