package simpleObjects;

import java . awt . Color ; // B
import java . awt . Graphics ;


public class SimpleDrop {
	
	int xpos , ypos , xvel , yvel , size ; // C
	public SimpleDrop ( int x , int y , int vx , int vy , int sz ) { // D
	xpos = x ;
	ypos = y ;
	xvel = vx ;
	yvel = vy ;
	size = sz ;
	}
	public void move ( int width , int height ) { // E
	xpos = xpos + xvel ;
	ypos = ypos + yvel ;
	}
	public void draw ( Graphics g ) { // F
	g . setColor ( Color . GRAY ) ;
	g . fillOval ( xpos , ypos , size , size ) ;
	}

}
