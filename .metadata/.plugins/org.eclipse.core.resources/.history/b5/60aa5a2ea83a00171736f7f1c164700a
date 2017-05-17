import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class DeathPanel extends JPanel implements ActionListener {

	Main w;

	public DeathPanel(Main w) {
		super();

		setBackground(Color.WHITE);

		this.w = w;
		JButton button = new JButton("Play again!");
		button.addActionListener(this);
		add(button);
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		if (e.getActionCommand().equals("Play again!"))
			w = new Main();
		else
			w.changePanel();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		String text = "You have died.";

		Font font = new Font("Times New Roman", Font.PLAIN, 20);

		//TEXT CENTERING
		FontMetrics metrics = g.getFontMetrics(font);
		// Determine the X coordinate for the text
		int x = 0 + (getWidth() - metrics.stringWidth(text)) / 2;
		// Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
		int y = 0 + ((getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();


		g.setFont(font);

		g.setColor(new Color(0,0,0));
		g.drawString(text, x, y);
	}

}