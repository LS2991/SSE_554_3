import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;


public class Projectile {

	private double xPos, yPos;
	private int dX = 1;
	private static final int xSize = 5, ySize = 2;
	
	public Projectile(Rectangle2D environment, Player p) {
		
		xPos = p.getXPos() + 20;
		yPos = p.getYPos() + (p.getYSize() / 2);
		
	}
	
	public void moveLeft(Rectangle2D environment) {	
		xPos -= dX;
	}
	
	public void moveRight(Rectangle2D environment) {
		xPos += dX;
	}
	
	
	public Rectangle2D getShape() {
		return new Rectangle2D.Double(xPos, yPos, xSize, ySize);
	}
	
	public void paintProjectile(Graphics2D g2) {
		g2.fill(new Rectangle2D.Double(xPos, yPos, xSize, ySize));
	}
	
	public double getXPos() {
		return xPos;
	}
	
	public double getYPos() {
		return yPos;
	}
	
	public int getXSize() {
		return xSize;
	}
	
	public int getYSize() {
		return ySize;
	}
}
