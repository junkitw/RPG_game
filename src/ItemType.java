import org.newdawn.slick.*;

public class ItemType extends Items {
	
	public ItemType(float x, float y) 
			throws SlickException 
			{
				super(x, y);
			}

	@Override
	
	public void update(World world, Player player) {
		player.playerCurrHP += giveHP;
		player.playermaxHP += giveHP;
		player.cooldownTimer += decreasecooldown;
		player.playerdamage += increaseDamage;
	}


}
