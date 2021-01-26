package cn.sxt.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

//�ɻ���Ϸ��������




public class MyGameFrame extends JFrame {
	
	Image planeImg = GameUtil.getImage("images/plane.png"); //�ɻ�ͼƬ
	Image bg = GameUtil.getImage("images/bg.jpg");    //����ͼƬ
	
	Plane plane = new Plane(planeImg,50,150);
	Plane plane2 = new Plane(planeImg,80,50);
	Plane plane3 = new Plane(planeImg,20,80);
	
	@Override
	public void paint(Graphics g) {  //�Զ������á�g�൱��һֻ����
    
		
		g.drawImage(bg,0,0,null);  //����ͼƬ
		plane.drawSelf(g);  //���ɻ�
		plane2.drawSelf(g);  //���ɻ�
		plane3.drawSelf(g);  //���ɻ�
	}
	
//���̰߳������Ƿ������ػ�����
	class PaintThread extends Thread {
		
		public void run() {
			while(true) {
			//	System.out.println("�����ػ�һ�Σ�");
				repaint();  //�ػ�����
				try {
					Thread.sleep(40);    //40����
				} catch (InterruptedException e) {
					e.printStackTrace();
				}   
			}
		}
	}
	
	
	
	
	/*
	   ��ʼ������
	
	 */
	public  void launchFrame() {
		this.setTitle("���������ˣ�˧��");
		this.setVisible(true);
		this.setSize(500,500);  //���ڴ�С
		this.setLocation(100,100);  //����λ��
		
		//�رմ��ڼ���������
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		new PaintThread().start();  //�����ػ����ڵ��߳�
		
		
		
	}
	
	public static void main(String[] args){
		MyGameFrame f = new MyGameFrame();
		f.launchFrame();
	}
	
}
