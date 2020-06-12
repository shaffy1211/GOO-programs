package writingaprogram;
import java.awt.Graphics;


public class Moon {
	int xpos, ypos, size = 40;
	double r, theta;
	
	public Moon() {
		r = 0;
		theta = 0;
	}
	
	public Moon(double r, double theta) {
		this.r = r;
		this.theta = theta;
		//code to initialize position
	}
	
	public void draw ( Graphics g ) {
		// drawing code
		System . out . println ( " moon : draw " ) ;
		}
		public void move ( int width , int height ) {
		// movement
		System . out . println ( " moon : moving " ) ;
		}

}
