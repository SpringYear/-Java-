package cn.sxt.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

//飞机游戏的主窗口




public class MyGameFrame extends JFrame {
	
	Image planeImg = GameUtil.getImage("images/plane.png"); //飞机图片
	Image bg = GameUtil.getImage("images/bg.jpg");    //背景图片
	
	Plane plane = new Plane(planeImg,50,150);
	Plane plane2 = new Plane(planeImg,80,50);
	Plane plane3 = new Plane(planeImg,20,80);
	
	@Override
	public void paint(Graphics g) {  //自动被调用。g相当于一只画笔
    
		
		g.drawImage(bg,0,0,null);  //放置图片
		plane.drawSelf(g);  //画飞机
		plane2.drawSelf(g);  //画飞机
		plane3.drawSelf(g);  //画飞机
	}
	
//此线程帮助我们反复的重画窗口
	class PaintThread extends Thread {
		
		public void run() {
			while(true) {
			//	System.out.println("窗口重画一次！");
				repaint();  //重画窗口
				try {
					Thread.sleep(40);    //40毫秒
				} catch (InterruptedException e) {
					e.printStackTrace();
				}   
			}
		}
	}
	
	
	
	
	/*
	   初始化窗口
	
	 */
	public  void launchFrame() {
		this.setTitle("程序制作人：帅哥");
		this.setVisible(true);
		this.setSize(500,500);  //窗口大小
		this.setLocation(100,100);  //窗口位置
		
		//关闭窗口即结束程序
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		new PaintThread().start();  //启动重画窗口的线程
		
		
		
	}
	
	public static void main(String[] args){
		MyGameFrame f = new MyGameFrame();
		f.launchFrame();
	}
	
}
