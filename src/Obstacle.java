import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Obstacle {
	int x,y; //障礙物座標 
	BufferedImage image; //障礙物圖片
	BufferedImage colossal_titan, pure_titan; //障礙物圖片3張
	int speed;
	
	int score = 10;
	
	//建構子方法
	public Obstacle() {
		try {
			colossal_titan = ImageIO.read(new File("image/colossal_titan.png"));
			pure_titan = ImageIO.read(new File("image/pure_titan.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Random r_obj = new Random();
		int temp = r_obj.nextInt(2); //0-1
		if (temp == 0) {
			image = colossal_titan;
		}
		else {
			image = pure_titan;
		}
		
		speed = BackgroundImage.speed;
		x = 800;
		y = 245;
		
	}
	
	//方法
	public void move() {
		x -=speed;
		
	}
	
	//方法
	public Rectangle getBounds() {
		if (image == pure_titan) {
			return new Rectangle(x+10, y-10, image.getWidth()-15, image.getHeight()+10);
		} else {
			return new Rectangle(x+6, y-80, image.getWidth()-6, image.getHeight()+80);
		}
	}
	
	//方法
	public int getScore() {
		int tmp = score; //讓每個障礙只能計算一次得分
		score = 0; //讓每個障礙只能計算一次得分
		return tmp;
	}
	
	
	
	
		
	

	
	
	
}
