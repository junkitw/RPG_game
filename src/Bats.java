import org.newdawn.slick.*;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Bats extends PassiveMonster {
	public static final int HP = 40;
	public static final int currHP = 40;
	public static final int DAMAGE = 0;
	public static final int COOLDOWN = 0;
	
	
	public Bats(float x, float y) 
	throws SlickException
	{
		super(x, y);
		setName("BigBat");
		units = new Image("assets/units/dreadbat.png");
		this.maxHP = HP;
		this.damageDeal = DAMAGE;
		this.cooldown = COOLDOWN;
		this.unitCurrHP = currHP;
	}
}