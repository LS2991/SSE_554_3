import java.awt.Graphics2D;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;


public class MovementAction extends AbstractAction {
	
	private String cmd;
	private boolean upFlag = false, downFlag = false, shootFlag = false;
	
	public MovementAction(String cmd) {
		this.cmd = cmd;
	}
	
	public void actionPerformed(ActionEvent e) {
		GameComponent comp = (GameComponent) e.getSource();
				
		Player p = comp.getPlayer();
		Projectile projectile;
		
		if(cmd.equalsIgnoreCase("W") && p != null) {
			int prevX = (int) p.getXPos();
			int prevY = (int) p.getYPos();
			
			p.moveUp(comp.getBounds());
			comp.repaint(prevX, prevY, p.getXSize(), p.getYSize());
			comp.repaint((int) p.getXPos(), (int) p.getYPos(), p.getXSize(), p.getYSize());
			//comp.paint(comp.getGraphics());
		}
		else if(cmd.equalsIgnoreCase("S") && p != null) {
			int prevX = (int) p.getXPos();
			int prevY = (int) p.getYPos();
			
			p.moveDown(comp.getBounds());
			comp.repaint(prevX, prevY, p.getXSize(), p.getYSize());
			comp.repaint((int) p.getXPos(), (int) p.getYPos(), p.getXSize(), p.getYSize());
			//comp.paint(comp.getGraphics());
		}
		
		else if(cmd.equalsIgnoreCase("Space") && p != null) {
//			comp.addProjectile();
//			comp.paint(comp.getGraphics());
//			projectile = comp.getProjectile();
//			System.out.println(p.getXPos() + "  " + projectile.getXPos());
			
			Runnable r = new ProjectileRunnable(comp, p);
			Thread t = new Thread(r);
			t.start();
			
//			while(projectile.getXPos() + projectile.getXSize() != comp.getBounds().getMaxX()) {
//				try {
//					int prevX = (int) projectile.getXPos();
//					int prevY = (int) projectile.getYPos();
//					
//					projectile.moveRight(comp.getBounds());
////					comp.repaint(prevX, prevY, projectile.getXSize(), projectile.getYSize());
////					comp.repaint((int) projectile.getXPos(), (int) projectile.getYPos(), projectile.getXSize(), projectile.getYSize());
//					//comp.repaint();
//					comp.paint(comp.getGraphics());
//					Thread.sleep(10);
//				} catch (InterruptedException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				} finally {
//					
//				}
				
//			}
		}
			
	}

}
