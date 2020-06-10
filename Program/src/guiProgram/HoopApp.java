package guiProgram;
import java.awt.Graphics;

import Goo.Goo;

public class HoopApp extends Goo{
	Hoop hoop;
	
	HoopApp(int w , int h, Hoop wa){
		super(w, h);
		hoop = wa;
	}
	public void draw(Graphics g) {
		hoop.fill(g);
	}

	public static void main(String[] args) {
	//Create a hoop
		Hoop hoop = new Hoop(100,66,60,30);
		//Create a test instance and run
		HoopApp app = new HoopApp(500,300,hoop);
		app.smooth();
		app.noloop();
		app.go();
	}

}
