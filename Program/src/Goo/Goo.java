package Goo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;



public abstract class Goo implements KeyListener, MouseListener,
		MouseMotionListener, WindowListener {

	private JFrame frame;
	private GooPanel gooPanel;

	private boolean loop = true;
	private boolean smooth = false;
	private boolean background = true;

	private int width, height;

	private Color backgroundColor = Color.white;

	private int frameTime = 50;

	private RenderingHints renderingHints = new RenderingHints(
			RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

	private ArrayList<GooComponent> gooComponents = new ArrayList<GooComponent>();

	/*
	 * A Panel for rendering
	 */
	class GooPanel extends JPanel {

		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g) {

			Graphics2D g2d = (Graphics2D) g;
			if (smooth)
				g2d.setRenderingHints(renderingHints);
			g2d.setColor(backgroundColor);
			if (background)
				g2d.fillRect(0, 0, this.getWidth(), this.getHeight());

			draw(g2d);

			for (GooComponent c : gooComponents) {
				c.draw(g);
			}
		}
	}

	/**
	 * Creates a default drawing frame of size 300 x 300 pxls
	 */
	public Goo() {

		this(300, 300);
	}

	/**
	 * Creates a drawing frame with user-specified height and width
	 * 
	 * @param width
	 * @param height
	 */
	public Goo(int width, int height) {

		this(width, height, false);
	}

	/**
	 * Creates a drawing frame with user-specified height and width. Goo will
	 * attempt full screen exclusive rendering if <code>tryFSE</code> is set
	 * to <code>true</code>.
	 * 
	 * @param w
	 *            width of drawing frame
	 * @param h
	 *            of drawing frame
	 * @param tryFSE
	 *            <code>true</code> for full screen exclusive.
	 */
	public Goo(int w, int h, boolean tryFSE) {

		width = w;
		height = h;

		gooPanel = new GooPanel();
		gooPanel.setPreferredSize(new Dimension(width, height));

		gooPanel.addKeyListener(this);
		gooPanel.addKeyListener(new GooKeyListener());

		GooMouseListener mouseListener = new GooMouseListener();
		gooPanel.addMouseListener(mouseListener);
		gooPanel.addMouseListener(this);
		gooPanel.addMouseMotionListener(mouseListener);
		gooPanel.addMouseMotionListener(this);

		gooPanel.setFocusable(true);

		frame = new JFrame();
		frame.setTitle("Goo");
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().add(gooPanel);

		if (tryFSE) {

			GraphicsEnvironment ge = GraphicsEnvironment
					.getLocalGraphicsEnvironment();
			GraphicsDevice gd = ge.getDefaultScreenDevice();
			if (gd.isFullScreenSupported()) {

				gooPanel.setPreferredSize(new Dimension(screenWidth(),
						screenHeight()));
				frame.setUndecorated(true);
				gd.setFullScreenWindow(frame);
			}
		}

		frame.addWindowListener(this);
		frame.pack();
	}

	/**
	 * Places the drawing frame at (x, y).
	 * 
	 * @param x
	 *            x coordinate of top left corner
	 * @param y
	 *            y coordinate of top left corner
	 */
	public void setLocation(int x, int y) {

		frame.setLocation(x, y);
	}

	/**
	 * 
	 * Call <code>go()</code> to display and start rendering.
	 */
	public void go() {

		frame.setVisible(true);
		while (loop) {

			gooPanel.repaint();

			try {
				Thread.sleep(frameTime);
			} catch (InterruptedException e) {
			}
		}
	}

	/**
	 * Override this method to provide your own drawing instructions.
	 * 
	 */
	public abstract void draw(Graphics g);

	/*
	 * Key and Mouse interface methods
	 */
	class GooKeyListener extends KeyAdapter {

		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			if ((keyCode == KeyEvent.VK_ESCAPE)
					|| (keyCode == KeyEvent.VK_END)
					|| ((keyCode == KeyEvent.VK_C || keyCode == KeyEvent.VK_Q) && e
							.isControlDown())) {
				System.exit(0);
			}
		}
	}

	/**
	 * Override to provide your own behaviour.
	 */
	public void keyPressed(KeyEvent e) {
	}

	/**
	 * Override to provide your own behaviour.
	 */
	public void keyReleased(KeyEvent e) {
	}

	/**
	 * Override to provide your own behaviour.
	 */
	public void keyTyped(KeyEvent e) {
	}

	class GooMouseListener extends MouseInputAdapter {

		public void mouseDragged(MouseEvent e) {
			for (GooComponent c : gooComponents) {
				if (c instanceof GooSlider) {
					GooEvent gae = new GooEvent(null, e.getX(), e.getY(),
							GooEvent.UNSPECIFIED);
					c.fireActionPerformed(gae);
				}
			}
		}

		public void mousePressed(MouseEvent e) {

			for (GooComponent c : gooComponents) {
				if (c instanceof GooButton) {
					GooEvent gae = new GooEvent(null, e.getX(), e.getY(),
							GooEvent.UNSPECIFIED);
					c.fireActionPerformed(gae);
				}
			}
		}
	}

	
	public void mouseMoved(MouseEvent e) {
	}

	
	public void mouseDragged(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

		public void mouseReleased(MouseEvent e) {
	}

	
	public void mouseEntered(MouseEvent e) {
	}

	
	public void mouseExited(MouseEvent e) {
	}

	
	public void mouseClicked(MouseEvent e) {
	}

	
	public void windowActivated(WindowEvent e) {
	}

	
	public void windowClosed(WindowEvent e) {

		System.exit(0);
	}

	
	public void windowClosing(WindowEvent e) {

		windowClosed(e);
	}

	
	public void windowDeactivated(WindowEvent e) {
	}

	
	public void windowDeiconified(WindowEvent e) {
	}

	
	public void windowIconified(WindowEvent e) {
	}

	
	public void windowOpened(WindowEvent e) {
	}


	public void smooth() {

		smooth = true;
	}

	
	public void noSmooth() {

		smooth = false;
	}


	public void frameRate(double framesPerSec) {

		frameTime = (int) (0.5 + 1000 / framesPerSec);
	}

	
	public double getFrameRate() {

		return 1000.0 / frameTime;
	}

	
	public void background(int gscale) {

		background(gscale, gscale, gscale);
	}

	
	public void background(int red, int green, int blue) {

		backgroundColor = new Color(red, green, blue);
	}


	public void background(Color c) {

		backgroundColor = c;
	}

	
	public void autoBackground(boolean b) {

		background = b;
	}

	
	public void noloop() {

		loop = false;
	}

	
	public void repaint() {

		gooPanel.repaint();
	}


	public Rectangle2D getStringBounds(String str) {

		if (frame.isDisplayable()) {

			Graphics2D g2d = (Graphics2D) frame.getGraphics();
			Font font = g2d.getFont();
			Rectangle2D rectangle = font.getStringBounds(str, g2d
					.getFontRenderContext());
			return rectangle;
		} else
			return null;
	}

	
	public int getWidth() {

		return gooPanel.getWidth();
	}

	
	public int getHeight() {

		return gooPanel.getHeight();
	}

	
	public void addComponent(GooComponent c) {

		gooComponents.add(c);
	}

	
	public static int screenWidth() {

		Toolkit tk = Toolkit.getDefaultToolkit();
		return tk.getScreenSize().width;
	}

	
	public static int screenHeight() {

		Toolkit tk = Toolkit.getDefaultToolkit();
		return tk.getScreenSize().height;
	}

}
