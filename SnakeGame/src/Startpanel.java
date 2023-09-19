import javax.swing.JFrame;
import java.awt.*;

public class Startpanel extends JFrame{

    button b;

    Startpanel(){
        this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		this.setBackground(Color.white);
		this.setFocusable(true);
        this.add(b= new button());
        this.add(new Gamepanel());
    }
    
}
