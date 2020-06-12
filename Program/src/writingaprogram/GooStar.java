package writingaprogram;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class GooStar extends Star {
Color color;
public GooStar(int xpos, int ypos, Color color) {
	super(xpos, ypos);
	this.color = color;
}

public void twinkle(Graphics g) {
	g.setColor(color);
	int s = (int)(size/2 +(Math.random()));
	
	g.drawLine(xpos - s, ypos - s, xpos + s, ypos + s);
	g.drawLine(xpos, ypos - s, xpos, ypos + s);
	g.drawLine(xpos + s, ypos - s, xpos - s, ypos + s);
	g.drawLine(xpos - s, ypos - s, xpos + s, ypos);
}
}
