package guiProgram;
import java.awt.Color;
import java.awt.Graphics;


public class SolidEllipse {
	private int x,y,width, height;
	private Color color;
	
	public SolidEllipse(int x, int y, int w, int h, Color c ) {
		this.x = x;
		this.y = y;
		width = w;
		height = h;
		color = c;
	}
	
	public void fill(Graphics g) {
		g.setColor(color);
		g.fillOval(x,y,width,height);
	}
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int x) {
		this.y = y;
	}
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int w) {
		width = w;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int h) {
		height = h;
	}
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color c) {
		color = c;
	}
}
