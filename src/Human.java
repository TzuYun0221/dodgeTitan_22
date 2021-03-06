import java.awt.Rectangle;
import java.awt.image.BufferedImage; //第10行
import java.io.File; //第14行
import java.io.IOException; //第16行
import javax.imageio.ImageIO; //第14行


//人類類別
public class Human {
	int x,y; //人類座標 
	BufferedImage image; //玩家圖片
	BufferedImage human_1, human_2 ,human_3; //玩家圖片3張
	
	int stepTimer = 0; //計時器
	int fresh = GamePanel.FRESH; //刷新時間
	
	final int LOWEST_Y = 250; //最低
	int jumpValue = 0; //跳躍增變量(每次移動高度)
	////低跳
	boolean jumpState1 = false; //跳躍狀態
	int jumpHeight = 130; //跳躍的高度 (暫定低跳)
	////高跳
	boolean jumpState2 = false; //跳躍狀態
	int jumpHeight2 = 250; //跳躍的高度 (暫定高跳)
	
			//float speed = 5f; (請忽略)
			//float jumpSpeed = 5f;
			//boolean isGround;
			//boolean isJump;
	
	
	
	//建構子方法
	public Human()  {
		try {
			human_1 = ImageIO.read(new File("image/human_1.png"));
			human_2 = ImageIO.read(new File("image/human_2.png"));
			human_3 = ImageIO.read(new File("image/human_3.png"));
		} catch (IOException e) {
			e.printStackTrace();
		} //讀取人類圖片 使用到I/O必須配合try catch
		x=50; //調整人類x軸
		y=LOWEST_Y; //調整人類y軸
		 
	}
	
	//方法 
		public void move() {//移動
			step(); 
			
			//low
			if (jumpState1) { //當起跳時
				if (y >= LOWEST_Y) { //如果玩家高度大於水平面就上升
					
					jumpValue=-10;
					
				}
				if (y <= LOWEST_Y - jumpHeight) {//如果玩家高度到達指定高度就下降
					
					jumpValue=10;
					jumpValue=9;//為符合掉落的時間比跳耀的時間快 再設一個跳耀增變量8
					
				}
				//每次改變玩家高度
				y+=jumpValue;
				if (y >= LOWEST_Y) {
					jumpState1 = false;
				}
			} 
			
			//height
			if (jumpState2) { //當起跳時
				if (y >= LOWEST_Y) { //如果玩家高度大於水平面就上升
					jumpValue=-15;
				}
				if (y <= LOWEST_Y - jumpHeight2) { 
					//如果玩家高度到達指定高度就下降
					jumpValue=15; //為符合掉落的時間比跳耀的時間快 再設一個跳耀增變量8
					jumpValue=8;
				}
				//每次改變玩家高度
				y+=jumpValue;
				if (y >= LOWEST_Y) {
					jumpState2 = false;
				}
			} 
		}
	
	
	
	//方法
	void step() {//踏步
		int tmp = stepTimer/100 % 3; //將當前時間切成三等份(每隔十分之一秒換一張圖)
		switch(tmp) {
		case 0:image=human_1;break; //tmp=0時 放human_1圖片
		case 1:image=human_2;break;
		case 2:image=human_3;break;
		}
		stepTimer += fresh; //計時器遞加 每刷一次加20毫秒
		
	}
	
	//方法
	public void lowJump() {//跳躍
		jumpState1 = true;
	}
	
	public void hightJump() {//二段跳躍
		jumpState2 = true;
	}
	
	
	//方法
	public Rectangle getFrontBounds() {
		return new Rectangle(x+7, y+8, 31, 38);
	}
	public Rectangle getFeetBounds() {
		return new Rectangle(x+26, y+60, 40, 19);
	}
	
	
}
