
public class PlayerRunnable implements Runnable{
	private Player player;
	private GameComponent comp;
	
	public PlayerRunnable(GameComponent comp, Player player) {
		this.player = player;
		this.comp = comp;
	}

	public void run() {
		comp.addPlayer(player);
		comp.paint(comp.getGraphics());
	}
	
}
