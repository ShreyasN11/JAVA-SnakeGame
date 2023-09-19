import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Gameframe extends JFrame {

    Gameframe(int delay){
        //this.add(new Startpanel());
        this.add(new Gamepanel(delay));
        this.setTitle("SnakeGame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        ImageIcon image = new ImageIcon("Hero.png");
        this.setIconImage(image.getImage());

    }
    
}
