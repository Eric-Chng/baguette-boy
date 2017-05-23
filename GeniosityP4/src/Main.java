
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;


import javax.swing.JFrame;
import javax.swing.JPanel;

import processing.awt.PSurfaceAWT;

/**
 * 
 * @author David McAllister, Eric Cheng
 *
 */
public class Main {

	DrawingSurface drawing;

	private JFrame window;

	private JPanel cardPanel;
	private PSurfaceAWT.SmoothCanvas canvas;

	private DeathPanel panel1;


	public static void main(String args[]) {
		Main m = new Main();


	}

	/**
	 * Creates a new Main object
	 */
	public Main()
	{
		drawing = new DrawingSurface(this);		
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();                                                                                                         
		window = (JFrame)canvas.getFrame();

		window.setSize(600, 600);
		window.setMinimumSize(new Dimension(600,600));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.addMouseWheelListener(drawing);
		window.setResizable(true);
		window.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		drawing.sendSize(window.getWidth(), window.getHeight());

		cardPanel = new JPanel();
		CardLayout cl = new CardLayout();
		cardPanel.setLayout(cl);

		panel1 = new DeathPanel(this);    

		cardPanel.add(canvas,"1");
		cardPanel.add(panel1,"death");

		window.setLayout(new BorderLayout());

		window.add(cardPanel);
		window.revalidate();

		window.setVisible(true);
		canvas.requestFocus();

	}
	
	/**
	 * Gets the window's starting width
	 * @return Pixel width
	 */
	public int getWindowWidth() {
		return window.getWidth();
	}

	/**
	 * Gets the window's starting height
	 * @return Pixel height
	 */
	public int getWindowHeight() {
		return window.getHeight();
	}

	/**
	 * Changes the card layout panel
	 */
	public void changePanel() {
		((CardLayout)cardPanel.getLayout()).next(cardPanel);
		canvas.requestFocus();
	}
	
	/**
	 * Changes the panel to one of a specified name
	 * @param name Name of panel to change to
	 */
	public void changePanelTo(String name) {
		((CardLayout)cardPanel.getLayout()).show(cardPanel, name);
		canvas.requestFocus();
	}
	
	/**
	 * Gets the drawing surface
	 * @return DrawingSurface on which the game is drawn
	 */
	public DrawingSurface getGamePanel() {
		return drawing;
	}


}
