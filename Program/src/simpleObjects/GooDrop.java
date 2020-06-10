package simpleObjects;
import java . awt . Graphics ;

import Goo.Goo;

public class GooDrop extends Goo {
	SimpleDrop drop ;
	public GooDrop ( int width , int height ) { // C
	super ( width , height ) ;
	int xpos = width / 2;
	int ypos = 0;
	int xvel = 0;
	int yvel = 1;
	int size = 10;
	drop = new SimpleDrop ( xpos , ypos , xvel , yvel , size ) ;
	}
	public void draw ( Graphics g ) { // D
	drop . move ( getWidth () , getHeight () ) ;
	drop.draw(g);
}
	
}
