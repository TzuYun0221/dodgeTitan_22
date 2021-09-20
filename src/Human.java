import java.awt.Rectangle;
import java.awt.image.BufferedImage; //��10��
import java.io.File; //��14��
import java.io.IOException; //��16��
import javax.imageio.ImageIO; //��14��


//�H�����O
public class Human {
	int x,y; //�H���y�� 
	BufferedImage image; //���a�Ϥ�
	BufferedImage human_1, human_2 ,human_3; //���a�Ϥ�3�i
	
	int stepTimer = 0; //�p�ɾ�
	int fresh = GamePanel.FRESH; //��s�ɶ�
	
	final int LOWEST_Y = 250; //�̧C
	int jumpValue = 0; //���D�W�ܶq(�C�����ʰ���)
	////�C��
	boolean jumpState1 = false; //���D���A
	int jumpHeight = 130; //���D������ (�ȩw�C��)
	////����
	boolean jumpState2 = false; //���D���A
	int jumpHeight2 = 200; //���D������ (�ȩw����)
	
			//float speed = 5f; (�Щ���)
			//float jumpSpeed = 5f;
			//boolean isGround;
			//boolean isJump;
	
	
	
	//�غc�l��k
	public Human()  {
		try {
			human_1 = ImageIO.read(new File("image/human_1.png"));
			human_2 = ImageIO.read(new File("image/human_2.png"));
			human_3 = ImageIO.read(new File("image/human_3.png"));
		} catch (IOException e) {
			e.printStackTrace();
		} //Ū���H���Ϥ� �ϥΨ�I/O�����t�Xtry catch
		x=50; //�վ�H��x�b
		y=LOWEST_Y; //�վ�H��y�b
		 
	}
	
	//��k 
		public void move() {//����
			step(); 
			
			//low
			if (jumpState1) { //��_����
				if (y >= LOWEST_Y) { //�p�G���a���פj��������N�W��
					
					jumpValue=-10;
					
				}
				if (y <= LOWEST_Y - jumpHeight) {//�p�G���a���ר�F���w���״N�U��
					
					jumpValue=10;
					jumpValue=8;//���ŦX�������ɶ����ģ���ɶ��� �A�]�@�Ӹ�ģ�W�ܶq8
					
				}
				//�C�����ܪ��a����
				y+=jumpValue;
				if (y >= LOWEST_Y) {
					jumpState1 = false;
				}
			} 
			
			//height
			if (jumpState2) { //��_����
				if (y >= LOWEST_Y) { //�p�G���a���פj��������N�W��
					jumpValue=-15;
				}
				if (y <= LOWEST_Y - jumpHeight2) { 
					//�p�G���a���ר�F���w���״N�U��
					jumpValue=15; //���ŦX�������ɶ����ģ���ɶ��� �A�]�@�Ӹ�ģ�W�ܶq8
					jumpValue=8;
				}
				//�C�����ܪ��a����
				y+=jumpValue;
				if (y >= LOWEST_Y) {
					jumpState2 = false;
				}
			} 
		}
	
	
	
	//��k
	void step() {//��B
		int tmp = stepTimer/100 % 3; //�N��e�ɶ������T����(�C�j�Q�����@���@�i��)
		switch(tmp) {
		case 0:image=human_1;break; //tmp=0�� ��human_1�Ϥ�
		case 1:image=human_2;break;
		case 2:image=human_3;break;
		}
		stepTimer += fresh; //�p�ɾ����[ �C��@���[20�@��
		
	}
	
	//��k
	public void lowJump() {//���D
		jumpState1 = true;
	}
	
	public void hightJump() {//�G�q���D
		jumpState2 = true;
	}
	
	
	//��k
	public Rectangle getFrontBounds() {
		return new Rectangle(x+7, y+8, 31, 38);
	}
	public Rectangle getFeetBounds() {
		return new Rectangle(x+26, y+60, 40, 19);
	}
	
	
}
