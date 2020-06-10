package guiProgram;
import java.awt.Color;
import java.awt.Graphics;

public class Hoop {
	private SolidEllipse outer,inner;
	
	public Hoop(int x, int y, int outerDiameter, int innerDiameter) {
		outer = new SolidEllipse(x,y, outerDiameter,outerDiameter, Color.BLACK);
		int thickness = (outerDiameter - innerDiameter)/2;
		inner = new SolidEllipse(x + thickness, y+ thickness, innerDiameter, innerDiameter,Color.WHITE);
	}
	
	public void fill(Graphics g) {
		outer.fill(g);	
		inner.fill(g);
	}
	
	public int getX() {
		return outer.getX();
	}
	
	public void setX(int x) {
		int thickness = getThickness();
		outer.setY(x);
		inner.setY(x+ thickness);
	}
	public int getY() {
		return outer.getY();
	}
	
	public void setY(int y) {
		int thickness = getThickness();
		outer.setX(y);
		inner.setY(y + thickness);
	}
	
	public int getDiameter() {
		return outer.getHeight();
	}
	public int getThickness() {
		return inner.getX() - outer.getX();
	}

}
