import static org.junit.Assert.*;

import javax.swing.JFrame;

import org.junit.Test;


public class GameUnitTest {

//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
	
	@Test
	public void addPlayerTest() {
		JFrame frame = new EnvironmentFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setFocusable(true);
		frame.setVisible(true);
		
		GameComponent comp = ((EnvironmentFrame) frame).getGameComponent();
		
		Player player = new Player(comp.getBounds());
//		comp.addPlayer(player);
//		comp.paint(comp.getGraphics());
		Runnable r = new PlayerRunnable(comp, player);
		Thread t = new Thread(r);
		t.start();
		
		Player p= ((PlayerRunnable) r).getPlayer();
		assertTrue(p != null);
	}
	
	@Test
	public void addObjectTest() {
		JFrame frame = new EnvironmentFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setFocusable(true);
		frame.setVisible(true);
		
		GameComponent comp = ((EnvironmentFrame) frame).getGameComponent();
		
		for(int i = 0; i < 5; i++)
		{
			Runnable r = new ObjectRunnable(comp);
			Thread t = new Thread(r);
			t.start();
			
			Object obj = ((ObjectRunnable) r).getObject();
			assertTrue(obj != null);
		}
	}
	
	

}
