import javax.swing.*;

public class button extends JButton {

     button(){
        
         //this.setLocation(300, 300);
         this.addActionListener(e ->new Frame1());
         this.setText("PLAY AGAIN");
         this.setVisible(false);
     } 

     button(boolean b){
        
        //this.setLocation(300, 300);
        this.addActionListener(e ->new Gameframe(150));
        this.setText("Start Game - Easy");
        this.setVisible(false);
        
    } 
     
     button(int medium){
        
        //this.setLocation(300, 300);
        this.addActionListener(e ->new Gameframe(100));
        this.setText("Start Game - Medium");
        this.setVisible(false);
    }

    button(String hard){
        
        //this.setLocation(300, 300);
        this.addActionListener(e ->new Gameframe(50));
        this.setText("Start Game - Hard");
        this.setVisible(false);
    }
    
}