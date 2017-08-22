package game_code;

import java.awt.*;

public class BulletFiring extends Thread {

	GameBoard gb;
	Bee[] bee;
	Bullet bullet;


	public BulletFiring(GameBoard gb, Bee[] bee,Bullet bullet){

		this.gb = gb;
		this.bee = bee;
		this.bullet = bullet;
	}


	public void run(){

		while(bullet.getX() < 1100){

			bullet.setX(bullet.getX() + 1);
			checkCollision();
			try{
				Thread.sleep(4);
			}
			catch(Exception e){

			}
			gb.repaint();
		}

	}


	public void checkCollision(){

		Rectangle bulletRect = new Rectangle(bullet.getX(),bullet.getY(),20,13);

		boolean isHit = false;

		for(int i = 0; i < bee.length; i++){

			Rectangle beeRect = new Rectangle(bee[i].getX(),bee[i].getY(),80,60);

			if(bulletRect.intersects(beeRect) == true){
				isHit = true;
				bee[i].setAlive(false);
				break;
			}


		}

		if(isHit == true)
			GameSound.bulletHitSound();


	}


}
