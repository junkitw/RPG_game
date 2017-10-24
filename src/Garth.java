import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Garth extends Villagers {
	public static final int HP = 1;
	public static final int currHP = 1;
	public static final int DAMAGE = 0;
	public static final int COOLDOWN = 0;
	
	public Garth(float x, float y) 
	throws SlickException
	{
		super(x, y);
		setName("Garth");
		units = new Image("assets/units/peasant.png");
		super.maxHP = HP;
		super.damageDeal = DAMAGE;
		super.cooldown = COOLDOWN;
		super.unitCurrHP = currHP;
	}
public void update(int delta, World world, boolean interaction, Player player) {
		
		ArrayList<Items> Inventory2 = world.getItem();
		ArrayList<String> toSay = new ArrayList<String>();
		
		if(interaction) {
			if (Inventory2.size() == 0) {
				this.text = "Come back when you have something for me.";
			}
			for(int i = 0; i<Inventory2.size();i++) {
				if (Inventory2.get(i).itemName == "SwordofStrength") {
					toSay.add(i, "Find the Sword of Strength - cross the bridge to the east, then head south.");
				}
				else if (Inventory2.get(i).itemName == "TomeofAgility") {
					toSay.add(i, "Find the Tome of Agility, in the Land of Shadows.");
				}
				else if (Inventory2.get(i).itemName == "AmuletofVitality") {
					toSay.add(i, "Find the Amulet of Vitality, across the river to the west.");
				}
			}
			for (int i = 0; i<Inventory2.size(); i++) {
				if(Inventory2.get(i).itemName == "SwordofStrength") {
					toSay.remove(i);
				}
				else if(Inventory2.get(i).itemName == "AmuletofVitality") {
					toSay.remove(i);
				}
				else if(Inventory2.get(i).itemName == "TomeofAgility") {
					toSay.remove(i);
				}
				
			}
			if (Inventory2.size() == 4) {
				this.text = "You have found all the treasure I know of.";
			}
			for(int i = 0; i < toSay.size();i++) {
					this.text = toSay.get(i);
			}
	}
}
		
}