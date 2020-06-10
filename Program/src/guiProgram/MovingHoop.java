package guiProgram;

public class MovingHoop extends Hoop {
	private int xVel = 2;
	private int yVel = 4;
	public MovingHoop(int xin, int yin, int d, int t) {
		super(xin, yin, d, t);
		
	}
public void move(int width, int height) {
	int x =getX();
	int y = getY();
	
	x = x + xVel;
	y = y + yVel;
	
	int diam = getDiameter();
	if(x + diam >= width) {
		xVel *= -1;
		x = width - diam;
	}else if(x <= 0) {
		xVel *= -1;
		x = -x;
	}
	
	if(y + diam >= height) {
		yVel *= -1;
		y = height - diam;
	}else if(y<=0) {
		yVel *= -1;
		y = -y;
	}
	
	setX(x);
	setY(y);
}

}
