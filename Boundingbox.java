import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

class Bbox{
	
	private int x,y,vx,vy;
	private int cr,cg,cb;
	
	public Bbox(){
		x = Boundingbox.getRnd(50,320); 
		y = Boundingbox.getRnd(50,320); 
		vx = Boundingbox.getRnd(1,5);
		vy = Boundingbox.getRnd(1,5);
		cr = Boundingbox.getRnd(0,250);
		cg = Boundingbox.getRnd(0,250);
		cb = Boundingbox.getRnd(0,250);
	}
	public void move(){
		x += vx; 
		y += vy;
		
		if(x < 2 || x > 350)
			vx = (int)(Boundingbox.getRnd(1,3) * -vx);
		if(y < 20 || y > 350)
			vy = (int)(Boundingbox.getRnd(1,3) * -vy);
	}
	public void draw(Graphics g){
		g.setColor(new Color(cr,cg,cb));//箱の縁の色指定
		g.fillRect(x,y,40,40);//箱の縁を描写
	}
}

public class Boundingbox extends JFrame implements Runnable{
	private Bbox box[];
	
	//ランダム関数
	public static int getRnd(int min,int max){
		return (int)((Math.random())*(max - min) + min);
	}
	
	public static void main(String args[]){
		new Boundingbox();
	}
		
	public Boundingbox(){
		box = new Bbox[20];
		for(int i=0;i < 20;i++){
			box[i] = new Bbox();
		}
	
	//ウィンドウの設定
	setLocation(200,200);
	setSize(400,400);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	
	new Thread(this).start();
	
	}

	public void paint(Graphics g){
		
	g.setColor(Color.black);//箱の色指定
	g.fillRect(0,0,400,400); //x,y,横400,縦400のbox
	
		for(int i = 0;i < 20;i++){
			box[i].move();
			box[i].draw(g);
		}
	
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