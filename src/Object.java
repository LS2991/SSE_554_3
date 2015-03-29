import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D.Double;


public class Object {
	
	private double xPos, yPos;
	boolean left = false;
	private int dX = 1, dY = 1;
	private static final int xSize = 15, ySize = 15;
	
	public Object(Rectangle2D environment) {
		
		xPos = + Math.random()*environment.getMaxX()+20;
		if(xPos > environment.getMaxX()/2);
		    left = true;
		yPos = environment.getMinY();
	}
	
	public void move(Rectangle2D environment) {	
		if(left == true)
		{
			xPos = xPos-dX;
			yPos = yPos+dY;
		}
		else
		{
			xPos = xPos+dX;
			yPos = yPos+dY;
		}
	}
	
	public Ellipse2D getShape() {
		return new Ellipse2D.Double(xPos, yPos, xSize, ySize);
	}
	
	public void paintObject(Graphics2D g2) {
		g2.setColor(Color.RED);
		g2.fill(new Ellipse2D.Double(xPos, yPos, xSize, ySize));
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

	public void reset(Rectangle2D environment) {
		xPos = + Math.random()*environment.getMaxX()+20;
		if(xPos > environment.getMaxX()/2);
		    left = true;
		yPos = environment.getMinY();		
	}
}
