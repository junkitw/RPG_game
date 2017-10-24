import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Zombie extends ActiveMonster {
	public static final int HP = 60;
	public static final int currHP = 60;
	public static final int DAMAGE = 10;
	public static final int COOLDOWN = 800;
	
	public Zombie(float x, float y) 
	throws SlickException
	{
		super(x, y);
		setName("Zombie");
		units = new Image("assets/units/zombie.png");
		super.maxHP = HP;
		super.damageDeal = DAMAGE;
		super.cooldown = COOLDOWN;
		super.unitCurrHP = currHP;
	}
	
	
}
