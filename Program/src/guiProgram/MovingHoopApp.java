package guiProgram;
import java.awt.Graphics;

import Goo.Goo;

public class MovingHoopApp extends Goo {
	MovingHoop hoop;
	public MovingHoopApp(int w , int h, MovingHoop gh) {
		super(w,h);
		hoop = gh;
	}

	public void draw(Graphics g) {
	hoop.fill(g);	
	hoop.move(getWidth(), getHeight());
	}
	public static void main(String[] args) {
		MovingHoop hoop = new MovingHoop(100,75,60,30);
		Goo app = new MovingHoopApp(500,500, hoop);
		app.smooth();
		app.frameRate(50);
		app.go();
	}

}
