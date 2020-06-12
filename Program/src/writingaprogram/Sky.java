package writingaprogram;

import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

import Goo.Goo;

public class Sky extends Goo {
	private Star [] stars ;
	private Moon moon ;
	private Color color ;
	public Sky ( int numStars ) {
	super (500 , 500) ;
	stars = new Star [ numStars ];
	Random random = new Random (2008) ;
	color = Color . black ;
	int width = getWidth () , height = getHeight () ;
	for (int i = 0; i < stars . length ; i ++) {
		int randwidth = random.nextInt(width);
		int randheight = random.nextInt(height);
	stars [ i ] = new Star(randwidth , randheight ) ;
	}
	moon = new Moon () ;
	}
	public void draw ( Graphics g ) {
	background ( color ) ;
	for ( Star star : stars ) {
	star . twinkle(g) ;
	}
	moon . draw ( g ) ;
	moon . move ( getWidth () , getHeight () ) ;
	}
	public static void main ( String [] args ) {
	Sky sky = new Sky (100) ;
	sky . smooth () ;
	sky . go () ;
	}

}
