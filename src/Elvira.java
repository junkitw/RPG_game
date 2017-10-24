import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Elvira extends Villagers {
	public static final int HP = 1;
	public static final int currHP = 1;
	public static final int DAMAGE = 0;
	public static final int COOLDOWN = 0;
	
	public Elvira(float x, float y) 
	throws SlickException
	{
		super(x, y);
		setName("Elvira");
		units = new Image("assets/units/shaman.png");
		super.maxHP = HP;
		super.damageDeal = DAMAGE;
		super.cooldown = COOLDOWN;
		super.unitCurrHP = currHP;
	}
	public void update(int delta, World world, boolean interaction, Player player) {
		if(interaction) {
			if (player.getCURRHP() < player.getHP()) {
				player.playerCurrHP = player.playermaxHP;
				this.text = "You're looking much healthier now.";
			}
			else {
				this.text = "Return to me if you ever need healing.";
			}
		}
	}
	
}