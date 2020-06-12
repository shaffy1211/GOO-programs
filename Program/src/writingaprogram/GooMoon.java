package writingaprogram;

import Goo.Goo;
import java . awt . Color ;
import java . awt . Graphics ;

public class GooMoon extends Moon {
double deltaTheta = 0.001;
public GooMoon(int width, int height) {
	//moon starts from left edge of window, halfway up 
	super ( Math . sqrt ( height * height / 4 + width * width / 4) ,
			0.75 * Math . PI ) ;
	// call move () in order to calculate (x, y)
	move ( width , height ) ;
}

public void draw ( Graphics g ) {
g . setColor ( Color . WHITE ) ;
g . fillOval ( xpos , ypos , size , size ) ;
g . setColor ( Color . BLACK ) ;
g . fillOval ( xpos + size / 4 , ypos - size / 8 , size , size ) ;
}
public void move ( int width , int height ) {
theta = theta - deltaTheta ;
// Transform from (r, theta ) to (x, y)
double x = width / 2 + r * Math . cos ( theta ) ;
double y = height - r * Math . sin ( theta ) ;
// Calculate coordinates of top left bounding rectangle
xpos = ( int) Math . round (( x - size / 2) ) ;
ypos = ( int) Math . round ( y - size / 2) ;
}
}
