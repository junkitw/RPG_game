/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * Author: <Jun Kit Wong> <jwong5>
 */
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.*;
import org.newdawn.slick.Image;
import java.util.ArrayList;
import org.newdawn.slick.geom.*;
/** Represents the entire game world.
 * (Designed to be instantiated just once for the whole game).
 */
public class World
{	
	private boolean attacks; // check if player is pressing 'A'
	private boolean talks;	// check if player is pressing 'T'
	public boolean monsterAttack = false; // check if monster is within 50 pixels
	public static final int playerXPos = 756; 
	public static final int playerYPos = 684;
	public static final int xTile = 13;	// number of tiles in width to be rendered
	public static final int yTile = 10; // number of tiles in height to be rendered
	public static final int tilewidth = 72;	// pixels
	public static final int whole_game = 6912;
	
	private float x_dir; // aggressive monster x-movement
	private float y_dir; // aggressive monster y-movement
	
	private TiledMap mapBackground;
	public Camera cam;
	public Player player;
	private int ID;	// to give an ID to the terrains 
	public String type;	// to pass to the Player and restrict movement
	private Image panelItem;
	ArrayList<ActiveMonster> Monsters = new ArrayList<ActiveMonster>();
	ArrayList<PassiveMonster> bigBats = new ArrayList<PassiveMonster>();
	ArrayList<Unit> People = new ArrayList<Unit>();
	ArrayList<Items> itemOnMap = new ArrayList<Items>();
	ArrayList<Items> Inventory = new ArrayList<Items>();

	
	/** getter for monster x-movement */
	public float getdirX(){
		return x_dir;
	}
	
	/** getter for monster y-movement */
	public float getdirY(){
		return y_dir;
	}
	
	/** getter for player's inventory to be passed to Villager to check*/
	public ArrayList<Items> getItem(){
		return Inventory;
	}
	
	/** getter for Monsters to be passed into player to check*/
	public ArrayList<ActiveMonster> getMonsters(){
		return Monsters;
	}
	
	/** Create a new World object. */
    public World()
    throws SlickException
    {	
    	mapBackground = new TiledMap("assets/map.tmx", "assets");
    	player = new Player(playerXPos, playerYPos);
    	cam = new Camera(player, RPG.screenwidth, RPG.screenheight);
    	// Villagers
    	People.add(new PrinceAldric(467,679));
    	People.add(new Elvira(738,549));
    	People.add(new Garth(756,870));
    	// Items on the map
    	itemOnMap.add(new AmuletofVitality(965, 3563));
    	itemOnMap.add(new SwordStrength(546, 6707));
    	itemOnMap.add(new TomeAgility(4791, 1253));
    	itemOnMap.add(new ElixirLife(1976, 402));
    	// Bats
    	bigBats.add(new Bats(1431,864));
    	bigBats.add(new Bats(1154,1321));
    	bigBats.add(new Bats(807,2315));
    	bigBats.add(new Bats(833,2657));
    	bigBats.add(new Bats(1090,3200));
    	bigBats.add(new Bats(676,3187));
    	bigBats.add(new Bats(836,3966));
    	bigBats.add(new Bats(653,4367));
    	bigBats.add(new Bats(1343,2731));
    	bigBats.add(new Bats(1835,3017));
    	bigBats.add(new Bats(1657,3954));
    	bigBats.add(new Bats(1054,5337));
    	bigBats.add(new Bats(801,5921));
    	bigBats.add(new Bats(560,6682));
    	bigBats.add(new Bats(1275,5696));
    	bigBats.add(new Bats(1671,5991));
    	bigBats.add(new Bats(2248,6298));
    	bigBats.add(new Bats(2952,6373));
    	bigBats.add(new Bats(3864,6695));
    	bigBats.add(new Bats(4554,6443));
    	bigBats.add(new Bats(4683,6228));
    	bigBats.add(new Bats(5312,6606));
    	bigBats.add(new Bats(5484,5946));
    	bigBats.add(new Bats(6371,5634));
    	bigBats.add(new Bats(5473,3544));
    	bigBats.add(new Bats(5944,3339));
    	bigBats.add(new Bats(6301,3414));
    	bigBats.add(new Bats(6388,1994));
    	bigBats.add(new Bats(6410,1584));
    	bigBats.add(new Bats(5314,274));
    	// Zombie
    	Monsters.add(new Zombie(681,3201));
    	Monsters.add(new Zombie(691,4360));
    	Monsters.add(new Zombie(2166,2650));
    	Monsters.add(new Zombie(2122,2725));
    	Monsters.add(new Zombie(2284,2962));
    	Monsters.add(new Zombie(2072,4515));
    	Monsters.add(new Zombie(2006,4568));
    	Monsters.add(new Zombie(2385,4629));
    	Monsters.add(new Zombie(2446,4590));
    	Monsters.add(new Zombie(2517,4532));
    	Monsters.add(new Zombie(4157,6730));
    	Monsters.add(new Zombie(4247,6620));
    	Monsters.add(new Zombie(4137,6519));
    	Monsters.add(new Zombie(4234,6449));
    	Monsters.add(new Zombie(5879,4994));
    	Monsters.add(new Zombie(5954,4928));
    	Monsters.add(new Zombie(6016,4866));
    	Monsters.add(new Zombie(5860,4277));
    	Monsters.add(new Zombie(5772,4277));
    	Monsters.add(new Zombie(5715,4277));
    	Monsters.add(new Zombie(5653,4277));
    	Monsters.add(new Zombie(5787,797));
    	Monsters.add(new Zombie(5668,720));
    	Monsters.add(new Zombie(5813,454));
    	Monsters.add(new Zombie(5236,917));
    	Monsters.add(new Zombie(5048,1062));
    	Monsters.add(new Zombie(4845,996));
    	Monsters.add(new Zombie(4496,575));
    	Monsters.add(new Zombie(3457,273));
    	Monsters.add(new Zombie(3506,779));
    	Monsters.add(new Zombie(3624,1192));
    	Monsters.add(new Zombie(2931,1396));
    	Monsters.add(new Zombie(2715,1326));
    	Monsters.add(new Zombie(2442,1374));
    	Monsters.add(new Zombie(2579,1159));
    	Monsters.add(new Zombie(2799,1269));
    	Monsters.add(new Zombie(2768,739));
    	Monsters.add(new Zombie(2099,956));
    	// Bandit
    	Monsters.add(new Bandit(1889,2581));
    	Monsters.add(new Bandit(4502,6283));
    	Monsters.add(new Bandit(5248,6581));
    	Monsters.add(new Bandit(5345,6678));
    	Monsters.add(new Bandit(5940,3412));
    	Monsters.add(new Bandit(6335,3459));
    	Monsters.add(new Bandit(6669,260));
    	Monsters.add(new Bandit(6598,339));
    	Monsters.add(new Bandit(6598,528));
    	Monsters.add(new Bandit(6435,528));
    	Monsters.add(new Bandit(6435,678));
    	Monsters.add(new Bandit(5076,1082));
    	Monsters.add(new Bandit(5191,1187));
    	Monsters.add(new Bandit(4940,1175));
    	Monsters.add(new Bandit(4760,1039));
    	Monsters.add(new Bandit(4883,889));
    	Monsters.add(new Bandit(4427,553));
    	Monsters.add(new Bandit(3559,162));
    	Monsters.add(new Bandit(3779,1553));
    	Monsters.add(new Bandit(3573,1553));
    	Monsters.add(new Bandit(3534,2464));
    	Monsters.add(new Bandit(3635,2464));
    	Monsters.add(new Bandit(3402,2861));
    	Monsters.add(new Bandit(3151,2857));
    	Monsters.add(new Bandit(3005,2997));
    	Monsters.add(new Bandit(2763,2263));
    	Monsters.add(new Bandit(2648,2263));
    	Monsters.add(new Bandit(2621,1337));
    	Monsters.add(new Bandit(2907,1270));
    	Monsters.add(new Bandit(2331,598));
    	Monsters.add(new Bandit(2987,394));
    	Monsters.add(new Bandit(1979,394));
    	Monsters.add(new Bandit(2045,693));
    	Monsters.add(new Bandit(2069,1028));
    	// Skeleton
    	Monsters.add(new Skeleton(1255,2924));
    	Monsters.add(new Skeleton(2545,4708));
    	Monsters.add(new Skeleton(4189,6585));
    	Monsters.add(new Skeleton(5720,622));
    	Monsters.add(new Skeleton(5649,767));
    	Monsters.add(new Skeleton(5291,312));
    	Monsters.add(new Skeleton(5256,852));
    	Monsters.add(new Skeleton(4790,976));
    	Monsters.add(new Skeleton(4648,401));
    	Monsters.add(new Skeleton(3628,1181));
    	Monsters.add(new Skeleton(3771,1181));
    	Monsters.add(new Skeleton(3182,2892));
    	Monsters.add(new Skeleton(3116,3033));
    	Monsters.add(new Skeleton(2803,2901));
    	Monsters.add(new Skeleton(2850,2426));
    	Monsters.add(new Skeleton(2005,1524));
    	Monsters.add(new Skeleton(2132,1427));
    	Monsters.add(new Skeleton(2242,1343));
    	Monsters.add(new Skeleton(2428,771));
    	Monsters.add(new Skeleton(2427,907));
    	Monsters.add(new Skeleton(2770,613));
    	Monsters.add(new Skeleton(2915,477));
    	Monsters.add(new Skeleton(1970,553));
    	Monsters.add(new Skeleton(2143,1048));
    	// Draelic
    	Monsters.add(new Draelic(2069,510));
    }

    /** Update the game state for a frame.
     * @param dir_x The player's movement in the x axis (-1, 0 or 1).
     * @param dir_y The player's movement in the y axis (-1, 0 or 1).
     * @param delta Time passed since last frame (milliseconds).
     * @param world The world object to passed in to the player's update method
     */
    public void update(boolean attacking, boolean interaction, double dir_x, double dir_y, int delta, World world)
    throws SlickException
    {	
    	attacks = attacking;
    	talks = interaction;
    	
    	x_dir = (float) dir_x;
    	y_dir = (float) dir_y;
    	
        /* ID and type are for terrain blocking checking whether they have 
         * the property or not. Player is updated to add the movements as well
         * as the delta for the speed. Player is then passed on to the 
         * followUnit for the camera to centralise around the player. */
    	player.update(dir_x, dir_y, delta, world, Inventory, attacks, monsterAttack);
    	for (int i = 0; i < People.size(); i++) {
    		People.get(i).update(delta, world, interaction, player, monsterAttack);
    	}
    	for (int i = 0; i < Monsters.size(); i++) {
    		if (Monsters.get(i).getUnitDistance(player) <= 50) {
    			monsterAttack = true;
    		}
    		Monsters.get(i).update(delta, world, attacking, player, monsterAttack);

    		if (Monsters.get(i).unitCurrHP <= 0) {
    			Monsters.remove(i);
    		}
    	}

    	for (int i = 0; i < bigBats.size(); i++) {
    		bigBats.get(i).update(delta, world, attacking, player, monsterAttack);
    		if (bigBats.get(i).unitCurrHP <= 0) {
    			bigBats.remove(i);
    		}
    	}

    	cam.update();
    	
    	for (int i = 0; i < itemOnMap.size(); i++) {
    		if ((itemOnMap.get(i).getItemtDistance(player)) <= 50) {
    			Inventory.add(itemOnMap.get(i));
    			/** updates the items and removes from the map when picked up */
    			itemOnMap.get(i).update(world, player);
    			itemOnMap.remove(i);
    		}
    	}
    }

    /** Render the entire screen, so it reflects the current game state.
     * @param g The Slick graphics object, used for drawing.
     */
    public void render(Graphics g)
    throws SlickException
    {

    	Color BOOM = new Color(1.0f, 1.0f, 1.0f);
    	mapBackground.render(-(cam.getX()),-(cam.getY()),cam.getMinX()/tilewidth,cam.getMinY()/tilewidth, xTile, yTile);
    	/** if player presses 'A' */
    	if (attacks == true) {
    		 g.setColor(BOOM);
    		 g.drawString("DIE!", (float)playerXPos/2 , (float)(playerYPos/2) - 110);
    		 g.drawString("KAPOW!", (float)playerXPos/2 , (float)(playerYPos/2) - 95);
    		 g.drawString("BOOM!", (float)playerXPos/2, (float)(playerYPos/2) - 80);
    	}
    	g.translate(-cam.getMinX(), -cam.getMinY());
    	player.render(g, cam);
    	for (int i=0; i<People.size(); i++) {
    		People.get(i).render(g, cam);
    		People.get(i).renderHealthBar(g, cam);
    		if ((People.get(i).getUnitDistance(player) <= 50) && (talks)) {
    			People.get(i).dialogueRender(g, cam);
    		}
    	}
    	for (int i=0; i<itemOnMap.size(); i++) {
    		itemOnMap.get(i).render(g, cam);
    	}
    	for (int i=0; i<bigBats.size(); i++) {
    		bigBats.get(i).render(g, cam);
    		bigBats.get(i).renderHealthBar(g, cam);
    	}

    	for (int i=0; i<Monsters.size(); i++) {
    		Monsters.get(i).render(g, cam);
    		Monsters.get(i).renderHealthBar(g, cam);
    	}
    	
    	g.resetTransform();
    	renderPanel(g);
    }
    public boolean detect_terrain(double x, double y) {
    	ID = mapBackground.getTileId((int)x/tilewidth, (int)y/tilewidth, 0);
    	type = mapBackground.getTileProperty(ID, "block", "0");
    	
    	if(type.equals("1")){
        	return true;
        }
        return false;
    }
    /**
     * renders the status panel at the bottom of screen
     * code given in renderpanel.txt
     * @param g
     */
    public void renderPanel(Graphics g)
    {
        // Panel colours
        Color LABEL = new Color(0.9f, 0.9f, 0.4f);          // Gold
        Color VALUE = new Color(1.0f, 1.0f, 1.0f);          // White
        Color BAR_BG = new Color(0.0f, 0.0f, 0.0f, 0.8f);   // Black, transp
        Color BAR = new Color(0.8f, 0.0f, 0.0f, 0.8f);      // Red, transp

        // Variables for layout
        String text;                // Text to display
        int text_x, text_y;         // Coordinates to draw text
        int bar_x, bar_y;           // Coordinates to draw rectangles
        int bar_width, bar_height;  // Size of rectangle to draw
        int hp_bar_width;           // Size of red (HP) rectangle
        int inv_x, inv_y;           // Coordinates to draw inventory item

        double health_percent;       // Player's health, as a percentage

        // Panel background image
        player.getPanel().draw(0, RPG.screenheight - RPG.panelheight);
        // Display the player's health
        text_x = 15;
        text_y = RPG.screenheight - RPG.panelheight + 25;
        g.setColor(LABEL);
        g.drawString("Health:", text_x, text_y);
        text = ("" + Integer.toString(player.getCURRHP()) + "/" + Integer.toString(player.getHP()));            
        bar_x = 90;
        bar_y = RPG.screenheight - RPG.panelheight + 20;
        bar_width = 90;
        bar_height = 30;
        health_percent = ((double)player.playerCurrHP/player.playermaxHP);                         
        hp_bar_width = (int) (bar_width * health_percent);
        text_x = bar_x + (bar_width - g.getFont().getWidth(text)) / 2;
        g.setColor(BAR_BG);
        g.fillRect(bar_x, bar_y, bar_width, bar_height);
        g.setColor(BAR);
        g.fillRect(bar_x, bar_y, hp_bar_width, bar_height);
        g.setColor(VALUE);
        g.drawString(text, text_x, text_y);

        // Display the player's damage and cooldown
        text_x = 200;
        g.setColor(LABEL);
        g.drawString("Damage:", text_x, text_y);
        text_x += 80;
        text = ("" + player.getCurrDam());                               
        g.setColor(VALUE);
        g.drawString(text, text_x, text_y);
        text_x += 40;
        g.setColor(LABEL);
        g.drawString("Rate:", text_x, text_y);
        text_x += 55;
        text = ("" + player.getCurrRate());                                  
        g.setColor(VALUE);
        g.drawString(text, text_x, text_y);

        // Display the player's inventory
        g.setColor(LABEL);
        g.drawString("Items:", 420, text_y);
        bar_x = 490;
        bar_y = RPG.screenheight - RPG.panelheight + 10;
        bar_width = 288;
        bar_height = bar_height + 20;
        g.setColor(BAR_BG);
        g.fillRect(bar_x, bar_y, bar_width, bar_height);

        inv_x = 490;
        inv_y = RPG.screenheight - RPG.panelheight
            + ((RPG.panelheight - 72) / 2);
        // for (each item in the player's inventory)                // TODO
        for (int i = 0; i < Inventory.size(); i++) {
        	panelItem = Inventory.get(i).itemPic;
        	panelItem.drawCentered(inv_x + (float)(70/2), inv_y + 40);
            inv_x += 72;
        }
    }

}

