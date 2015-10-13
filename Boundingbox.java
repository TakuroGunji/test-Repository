import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Boundingbox extends JFrame implements Runnable{
	private int x,y,vx,vy;
	public static void main(String args[]){
		new Boundingbox();
}

public Boundingbox(){
	
	//ウィンドウの設定
	setLocation(200,200);
	setSize(400,400);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	x = 50; 
	y = 60;
	vx = 3;
	vy = 4;
	new Thread(this).start();
	
	
}

public void paint(Graphics g){
	g.setColor(Color.black);//箱の色指定
	g.fillRect(0,0,400,400); //x,y,横400,縦400のbox
	g.setColor(Color.white);//箱の縁の色指定
	g.drawRect(x,y,40,40);//箱の縁を描写
	
	x += vx;
	y += vy;
	
	if(x < 2 || x > 350)
		vx = -vx;
	if(y < 20 || y > 350)
		vy = -vy;
}
public void run(){
	while(true){
		try{
			Thread.sleep(10);
		}catch(Exception e){
		}
		repaint();
	}
 }
}
