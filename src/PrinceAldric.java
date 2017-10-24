import org.newdawn.slick.*;
import java.util.ArrayList;
public class PrinceAldric extends Villagers {
	public static final int HP = 1;
	public static final int currHP = 1;
	public static final int DAMAGE = 0;
	public static final int COOLDOWN = 0;

	
	public PrinceAldric(float x, float y) 
	throws SlickException
	{
		super(x, y);
		setName("Prince");
		units = new Image("assets/units/prince.png");
		this.maxHP = HP; 
		this.damageDeal = DAMAGE;
		this.cooldown = COOLDOWN;
		this.unitCurrHP = currHP;
	}
	
	public void update(int delta, World world, boolean interaction, Player player) {
		
		ArrayList<Items> Inventory2 = world.getItem();
		
		if(interaction) {
			if(Inventory2.size() == 0) {
				this.text = "Please seek out the Elixir of Life to cure the king.";
			}
			
			for(int i=0; i<Inventory2.size(); i++) {
				if (Inventory2.get(i).itemName == "ElixirofLife") {
					this.text = "The elixir! My father is cured! Thank you!";
				}
				else {
					this.text = "Please seek out the Elixir of Life to cure the king.";	
				}
				
			}
		}
	}
}
