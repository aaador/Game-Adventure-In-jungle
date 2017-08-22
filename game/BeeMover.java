package game_code;

import java.awt.Rectangle;

public class BeeMover extends Thread {

	Shooter shooter;
	Bee bee;
	GameBoard gb;

	public BeeMover(Bee bee, GameBoard gb){
		this.gb = gb;
		this.bee = bee;
	}

	public void run(){

		while(bee.getX() > - 100){

			bee.setX(bee.getX() - 1);
			//checkCollision();		
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			gb.repaint();
		}
	}			

	public void checkCollision(){

		Rectangle shooterRect = new Rectangle(shooter.getX(), shooter.getY(), 150, 120);

		boolean isHit = false;

		//	for(int i = 0; i < bee.length; i++){

		Rectangle beeRect = new Rectangle(bee.getX(),bee.getY(),80,60);

		if(shooterRect.intersects(beeRect) == true){
			isHit = true;
			bee.setAlive(false);	

		}

		//}

		if(isHit == true)
			GameSound.bulletHitSound();

	}

}



