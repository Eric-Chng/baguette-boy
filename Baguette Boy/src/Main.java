
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;


import javax.swing.JFrame;
import javax.swing.JPanel;

import processing.awt.PSurfaceAWT;

public class Main {

	DrawingSurface drawing;

	private JFrame window;

	private JPanel cardPanel;
	private PSurfaceAWT.SmoothCanvas canvas;

	private DeathPanel panel1;


	public static void main(String args[]) {
		Main m = new Main();


	}

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


	public void changePanel() {
		((CardLayout)cardPanel.getLayout()).next(cardPanel);
		canvas.requestFocus();
	}
	
	public void changePanelTo(String name) {
		((CardLayout)cardPanel.getLayout()).show(cardPanel, name);
		canvas.requestFocus();
	}


}
