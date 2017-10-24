import org.newdawn.slick.*;

public class Villagers extends Unit{
	protected int chatTime;
	
	public Villagers(float x, float y) 
	throws SlickException 
	{
		super(x,y);
	}

	@Override
	public void update(int delta, World world, boolean interaction, Player player, boolean combat) {
		/** when player presses 'T' */
		if (interaction) {
			this.chat = delta;
		}
	}
	
}
