import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Frame1 extends JFrame {

    Frame1(){
        this.setTitle("SnakeGame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        ImageIcon image = new ImageIcon("Hero.png");
        this.setIconImage(image.getImage());
        ImageIcon i = new ImageIcon("easy.png");
        button B1 = new button(true); 
        B1.setVisible(true);
        this.add(B1);
        button B2 = new button(5); 
        B2.setVisible(true);
        this.add(B2);
        button B3 = new button("H"); 
        B3.setVisible(true);
        this.add(B3);
        this.setLayout(new GridLayout());
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        //this.setLayout(new GridLayout());
    }
    
}
