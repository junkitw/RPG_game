import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Skeleton extends ActiveMonster {
	public static final int HP = 100;
	public static final int currHP = 100;
	public static final int DAMAGE = 16;
	public static final int COOLDOWN = 500;

	
	public Skeleton(float x, float y) 
	throws SlickException
	{
		super(x, y);
		setName("Skeleton");
		units = new Image("assets/units/skeleton.png");
		super.maxHP = HP;
		super.damageDeal = DAMAGE;
		super.cooldown = COOLDOWN;
		super.unitCurrHP = currHP;
	}
	
	
}
