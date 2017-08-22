package game_code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GameBoard extends JPanel implements KeyListener {

	private static final long serialVersionUID = 3864575493189354872L;	
	private Shooter background1 = new Shooter (0,0,"images//bg3.png");
	private Shooter background2 = new Shooter (1000,0,"images//bg3.png");
	
	Shooter shooter;
    Bee[] bee = new Bee [6];  
    BeeKing [] beekings = new BeeKing [5];
    Bullet[] bullets = new Bullet[100];
	int bulletCount = 0;
	static int score = 0;
	
	
	    public GameBoard(){
		super();	
		super.addKeyListener(this);
		super.setFocusable(true);
		shooter = new Shooter(0,255,"images//shooter1.png");	
		
		int xBee = 880, yBee = 23;
		for(int i = 0; i < bee.length; i++)
		{
		bee[i] = new Bee(xBee,yBee,"images//Bee1.png",true);
		yBee = yBee + 80;
		
		}
		for(int i = 0; i < bullets.length; i++){			
		bullets[i] = new Bullet(-100,-316,"images//BulletShooter.png");
			
		}
	 
		for(int i = 0; i < bee.length; i++){
			BeeMover bm = new BeeMover(bee[i],this);
			bm.start();
		}
		
		}
		
	    

	
	    public void paint(Graphics g){
		
		//ImageIcon bgIcon = new ImageIcon("images//bg3.png");
		//g.drawImage(bgIcon.getImage(),0,0,null);
	    	background1.draw(g);
	    	background2.draw(g);
	    	this.scrollBackground();
	    	
		
		shooter.draw(g);
		
		for(int i = 0; i < bee.length; i++){
			if(bee[i].isAlive() == true)
				bee[i].draw(g);
		}
	    
		bullets[bulletCount].draw(g);
		
		for(int i = 0; i < bullets.length; i++){
		 bullets[i].draw(g);
		}
		
		
		Font f = new Font("Serif", Font.BOLD, 24);
		g.setColor(Color.BLACK);
		g.drawString("SCORE : " + score, 450,600);
		g.setFont(f);
	    }
	    public void scrollBackground()
	    {
	    	if(background1.getX() > -1000)
	    	{
	    		background1.setX(background1.getX()-1);
	    	}
	    	else{
	    		background1.setX(1000);
	    	}
	    	if(background2.getX() > -1000)
	    	{
	    		background2.setX(background2.getX()-1);
	    	}
	    	else{
	    		background2.setX(1000);
	    	}
	    	try{
	    		Thread.sleep(8);
	    		
	    	}
	    	catch(Exception e)
	    	{
	    		
	    	}
	    	super.repaint();
	    }
	    
	    public void keyPressed(KeyEvent e) {
			
			if(e.getKeyCode() == KeyEvent.VK_LEFT){
				
				if(shooter.getX() > 0)
					shooter.setX(shooter.getX() - 7);
			}
			
			else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
				
				if(shooter.getX() < 760)
					shooter.setX(shooter.getX() + 7);
				}
               
			else if(e.getKeyCode() == KeyEvent.VK_UP){
				
				if(shooter.getY() > 7)
					shooter.setY(shooter.getY() - 7);
				}
              else if(e.getKeyCode() == KeyEvent.VK_DOWN){
				
				if(shooter.getY() < 440)
					shooter.setY(shooter.getY() + 7);
				}
			
              else if(e.getKeyCode() == KeyEvent.VK_SPACE){
            	  
      			bullets[bulletCount].setX(shooter.getX()+ 100);
      			bullets[bulletCount].setY(shooter.getY()+ 61);
      			
      			BulletFiring fire = new BulletFiring(this,bee,bullets[bulletCount]);
      			fire.start();
      			
      			bulletCount++;
      			
      			if(bulletCount == 100)
      				bulletCount = 0;
      					
      			
      		} 
				
			super.repaint();
			
		}
	    
	    
	    public void keyReleased(KeyEvent e) {
		
			
		}

		public void keyTyped(KeyEvent e) {
			
			
		}
}


