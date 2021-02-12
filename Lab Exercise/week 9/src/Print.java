import java.awt.*;

import javax.swing.*;

public class Print extends Canvas {

	
	public void paint(Graphics g) {
		g.drawString("Hello", 40, 40);
		this.setBackground(Color.blue);
		g.fillRect(130, 30, 100, 80);
	}
	
	public static void main(String[] args) {
		Print p = new Print();
		JFrame f = new JFrame();
		f.add(p);
		f.setSize(400, 400);
		f.setVisible(true);
    }
}