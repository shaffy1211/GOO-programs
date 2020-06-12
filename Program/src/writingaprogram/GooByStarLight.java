package writingaprogram;

import Goo.Goo;

import java . awt . Color ;
import java . awt . Graphics ;
import java . util . Random ;


public class GooByStarLight extends Goo {
	Star [] stars ;
	GooMoon moon ;
	public GooByStarLight ( int numStars ) {
	super (500 , 500 , true ) ;
	stars = new Star [ numStars ];
	Random random = new Random (2008) ;
	int width = getWidth () , height = getHeight () ;
	for (int i = 0; i < stars . length ; i ++) {
	Color color = new Color ( random . nextInt (256) , random . nextInt
	(256) ,
	random . nextInt (256) ) ;
	stars [ i ] = new GooStar ( random . nextInt ( width ) , random
	. nextInt ( height ) , color ) ;
	}
	moon = new GooMoon ( width , height ) ;
	}
	public void draw ( Graphics g ) {
	background (0) ;
	for ( Star star : stars ) {
	star . twinkle ( g ) ;
	}
	moon . draw ( g ) ;
	moon . move ( getWidth () , getHeight () ) ;
	}

}
