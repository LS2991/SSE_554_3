import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;


public class EnvironmentFrame extends JFrame {

	public GameComponent comp;
	
	public EnvironmentFrame() {
		comp = new GameComponent();
		comp.setFocusable(true);
		setFocusable(true);
		
		InputMap im = comp.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
		ActionMap am = comp.getActionMap();
		
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), "W");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), "S");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "Space");
		
		am.put("W", new MovementAction("W"));
		am.put("S", new MovementAction("S"));
		am.put("Space", new MovementAction("Space"));
		
		
		add(comp, BorderLayout.CENTER);
		setPreferredSize(comp.getPreferedSize());
		JPanel buttonPanel = new JPanel();
		
		addButton(buttonPanel, "Start", new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addPlayer();
			}
		});
		
		add(buttonPanel, BorderLayout.SOUTH);
		
		pack();
	}
	
	public void addButton(Container c, String title, ActionListener listener) {
		JButton button = new JButton(title);
		c.add(button);
		button.addActionListener(listener);
	}
	
	public void addPlayer() {
		Player player = new Player(comp.getBounds());
//		comp.addPlayer(player);
//		comp.paint(comp.getGraphics());
		Runnable r = new PlayerRunnable(comp, player);
		Thread t = new Thread(r);
		t.start();
	}
	
	public void addProjectile() {
		comp.addProjectile();
		comp.paint(comp.getGraphics());
	}
	
	public GameComponent getComponent() {
		return comp;
	}

}
