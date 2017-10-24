import org.newdawn.slick.*;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Bandit extends ActiveMonster {
	public static final int HP = 40;
	public static final int currHP = 40;
	public static final int DAMAGE = 8;
	public static final int COOLDOWN = 200;
	
	public Bandit(float x, float y) 
	throws SlickException
	{
		super(x, y);
		setName("Bandit");
		units = new Image("assets/units/bandit.png");
		this.maxHP = HP;
		this.damageDeal = DAMAGE;
		this.cooldown = COOLDOWN;
		this.unitCurrHP = currHP;
	}
	
	
}
