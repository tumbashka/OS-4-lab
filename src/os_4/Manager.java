package os_4;

import java.awt.Graphics;
import javax.swing.JPanel;

public class Manager extends JPanel {
	Block Memory;
	
	public Manager(Block memory) {
		Memory = memory;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Memory.Visualmemory(g, this.getWidth(), this.getHeight());
	}
}