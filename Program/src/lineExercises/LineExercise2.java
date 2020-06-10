package lineExercises;
import java.awt.Color;
import java.awt.Graphics;

import Goo.Goo;
public class LineExercise2 extends Goo{
	public LineExercise2(int width, int height) {
		super(width, height);
	}
	public void draw(Graphics g) {
		g.translate(50,50);
		g.setColor(Color.BLACK);
		for(int x = 1 ; x<=4; x++) {
			for(int y = 1; y<=x; y++) {
				if(y == 3) break;
				g.drawOval(x*50, y*50, 20, 20);
			}
		}
	}
	
	public static void main(String [] args) {
		LineExercise2 f = new LineExercise2(400,400);
		f.smooth();
		f.go();
	}
}
