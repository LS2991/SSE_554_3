import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;


public class GameComponent extends JPanel{
	
	private static final int defaultWidth = 600;
	private static final int defaultHeight = 600;
	private ArrayList<Player> players = new ArrayList();
	private Player player;
	private Projectile projectile;
	private ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	private Object object;
	private ArrayList<Object> objects = new ArrayList<Object>();

	
	public void addPlayer(Player p) {
		player = p;
	}
	
	public void addProjectile() {
		projectiles.add(new Projectile(getBounds(), player));
	}
	
	public void addProjectile(Projectile projectile) {
		projectiles.add(projectile);
	}
	
	public void addObject(Object obj)
	{
		objects.add(obj);
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
//		for(Player p : players) {
//			g2.fill(p.getShape());
//		}
		if(player != null)
			player.paintPlayer(g2);
		
		if(!objects.isEmpty())
			for(Object obj : objects)
				obj.paintObject(g2);
				
		if(!projectiles.isEmpty()) { 
			for(Projectile projectile : projectiles)
				projectile.paintProjectile(g2);
		}
	}
	
	public Dimension getPreferedSize() {
		return new Dimension(defaultWidth, defaultHeight);
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public Projectile getProjectile() {
		return projectile;
	}
	
	public ArrayList<Projectile> getProjectiles() {
		return projectiles;
	}
	
	public ArrayList<Object> getObjects() 
	{
		return objects;
	}
}
