import javax.swing.JFrame; //�~�ӵ��� ��5��
import java.awt.Container; //�~�Ӯe�� ��12��
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*; 
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;

//�D�������O
public class MainFrame extends JFrame implements ActionListener{
	GamePanel p; //�ŧiGamePanel���O �a�ip�ܼ�(�}�l�N���O��m����)
	JMenuBar mb = new JMenuBar();  //�U�Ԧ����
	JMenuItem Begin,rule;  
	
	//�غc�l��k
	public MainFrame() {
		
		super("dodge titan!!"); //���骺���D
		
		  
		//�إߤU�Ԧ����
		//JMenu start = new JMenu("�C��(O)");
		JMenu directions = new JMenu("����(L)");
		
		// �[�J"�C��"�ﶵ
		//start.setMnemonic(KeyEvent.VK_O);
		//start.add(Begin = new JMenuItem("�C���}�l(S)", KeyEvent.VK_S));
				
		//�[�J"����"�ﶵ
		directions.setMnemonic(KeyEvent.VK_L);
		directions.add(rule = new JMenuItem("�W�h(R)", KeyEvent.VK_R));
		rule.addActionListener(this);
		
		// �[�J��ť
		//Begin.addActionListener(this);
		
		
		//�[�J�U�Ԧ����
		setJMenuBar(mb);
		//mb.add(start);
		mb.add(directions);
		 
		
		//////////////////////////////
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//��������
		p = new GamePanel(); //�Ы�p����
		Container c = getContentPane(); 
		//�ŧiContainer���O �Ы�c����(�HgetContentPane��k������骺�D�e��)
		
		c.add(p); //��C�����O(p)�K�[��D�e����
		addKeyListener( p );; //�K�[��L�ƥ��ť
		///////////////////////////////
		
	}
	
	//�D�{��
	public static void main(String[] args) {
		MainFrame frame = new MainFrame(); //�ŧiMainFrame���O �Ы�frame���骫��
		frame.setBounds(340, 150, 820, 365
				); //�]�w����j�p365
		frame.setVisible(true);
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == rule)
		{
			JOptionPane.showOptionDialog(null, "���U��V��[UP]�Ӹ��״��q���H"+"\n"+"����V��[RIGHT]�ϥX�G�q���Ӹ��׶W�j�����H",
					null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
		}
	}

	
	
	//���s�}�l
	public void restart() {
		Container c = getContentPane(); 
		c.removeAll(); //�R���Ҧ��ե�
		//�ХD�e�� >> �йC�����O >> �C�����O���D�e�� >>�K�[��L��ť
		GamePanel np = new GamePanel();
		c.add(np);
		addKeyListener(np);
		
		c.validate(); //���s���Үe���դ�
	}
}
