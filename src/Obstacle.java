import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Obstacle {
	int x,y; //��ê���y�� 
	BufferedImage image; //��ê���Ϥ�
	BufferedImage colossal_titan, pure_titan; //��ê���Ϥ�2�i
	int speed; //�Ϥ��t��
	
	int score = 10;
	
	//�غc�l��k
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
	
	//��k
	public void move() {
		x -=speed;
		
	}
	
	//��k
	public Rectangle getBounds() { //�վ��˴��I������j�p
		if (image == pure_titan) {
			return new Rectangle(x, y, image.getWidth(), image.getHeight());
		} else {
			return new Rectangle(x, y, image.getWidth(), image.getHeight());
		}
	}
	
	//��k
	public int getScore() {
		int tmp = score; //���C�ӻ�ê�u��p��@���o��
		score = 0; //���C�ӻ�ê�u��p��@���o��
		return tmp;
	}
	
	
	
	
		
	

	
	
	
}
