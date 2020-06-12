package writingaprogram;
import java.awt.Graphics;

public class Star {
	int xpos, ypos, size = 2;
	
	
	public Star(int xpos, int ypos) {
		this.xpos = xpos;
		this.ypos = ypos;
	}

	public void twinkle(Graphics g) {
		System.out.println("star: twinkling");
	}
}
