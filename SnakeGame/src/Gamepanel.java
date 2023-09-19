import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;


public class Gamepanel extends JPanel implements ActionListener{

	static final int WIDTH = 600;
	static final int HEIGHT = 600;
	static final int UNIT = 20;
	static final int GAME_UNITS = (WIDTH*HEIGHT)/(UNIT*UNIT);
	static int DELAY = 120;
	final int x[] = new int[GAME_UNITS];
	final int y[] = new int[GAME_UNITS];
	int bodyParts = 5;
	int points;
	int pointX;
	int pointY;
	char direction = 'R';
	boolean running = false;
	Timer timer;
	Random random;
    button b;
	
	Gamepanel(int d){
        //this.add(label)
        DELAY = d;
		random = new Random();
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		this.setBackground(Color.white);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
        this.add(b= new button());
		startGame();
	}
	public void startGame() {
		newpoint();
		running = true;
		timer = new Timer(DELAY,this);
		timer.start();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
        draw(g);
	}
	public void draw(Graphics g) {
        if(running){
            for(int i=0; i<HEIGHT/UNIT; i++){
            g.drawLine(i*UNIT, 0, i*UNIT, HEIGHT);

            }
            for(int i=0; i<WIDTH/UNIT; i++){
                g.drawLine(0, i*UNIT, WIDTH, i*UNIT);
    
            }	
         g.setColor(Color.red);
         g.fillOval(pointX, pointY, UNIT, UNIT);	
		
         for(int i = 0; i< bodyParts;i++) {
            
            g.setColor(Color.green);
            g.fillRect(x[i], y[i], UNIT, UNIT);
            
        }
    }
    else{
        endgame(g);
    } 
	}
	public void newpoint(){
        pointX = random.nextInt((int)WIDTH/UNIT)*UNIT;
        pointY = random.nextInt((int)HEIGHT/UNIT)*UNIT;
		
	}
	public void move(){
        for(int i=bodyParts; i>0; i--){
            x[i]=x[i-1];
            y[i]=y[i-1];
            //System.out.println(x[i]+" "+ y[i]);
        }    

            if(direction=='U'){
                y[0] = y[0] - UNIT;
            }
            else if(direction=='D'){
                y[0] = y[0] + UNIT;
            }
            else if(direction=='L'){
                x[0] = x[0] - UNIT;
            }
            else if(direction=='R'){
                x[0] = x[0] + UNIT;
            }	
		
	}
	public void checkpoint() {
        if((x[0]==pointX)&&(y[0]==pointY)){
           bodyParts++;
           points++;
           newpoint();
        }
		
	}
	public void checkCollisions() {
        for(int i=bodyParts; i>0; i--){
            if(x[i]== x[0] && y[i]==y[0]){
                running=false;
                //endgame(g);
            }
        }
        if(x[0]<0){
            running= false;
        }
        if(x[0]>WIDTH){
            running= false;
        }
        if(y[0]<0){
            running= false;
        }
        if(y[0]>HEIGHT){
            running= false;
        }

        if(!running){
            timer.stop();
        }
		
		
	}
	public void endgame(Graphics g) {

        g.setFont(new Font("Courier", Font.BOLD, 50));
        g.drawString("Game Over", (WIDTH-300)/2, HEIGHT/2);
        g.drawString("Your score is: "+ points , ((WIDTH-500)/2) , (HEIGHT/2)-100);
        //Play again option to be added
        b.setBounds(220, 350, 150, 50);
        b.setVisible(true);
        
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
        if(running){
            move();
            checkpoint();
            checkCollisions();
        }
        repaint();
		
	}
	
	public class MyKeyAdapter extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if(direction != 'R') {
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(direction != 'L') {
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(direction != 'D') {
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(direction != 'U') {
                        direction = 'D';
                    }
                    break;
                }            
			
			}
		}
	}
    

