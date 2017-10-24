import org.newdawn.slick.*;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Draelic extends ActiveMonster {
	public static final int HP = 140;
	public static final int currHP = 140;
	public static final int DAMAGE = 30;
	public static final int COOLDOWN = 400;

	
	public Draelic(float x, float y) 
	throws SlickException
	{
		super(x, y);
		setName("Draelic");
		units = new Image("assets/units/necromancer.png");
		super.maxHP = HP;
		super.damageDeal = DAMAGE;
		super.cooldown = COOLDOWN;
		super.unitCurrHP = currHP;
	}
	
	
}