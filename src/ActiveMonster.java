import org.newdawn.slick.SlickException;

public class ActiveMonster extends Unit {
	private float speed = 0.25f; // movement rate of monster
	public ActiveMonster(float x, float y) 
			throws SlickException 
			{
				super(x, y);
			}

	@Override
	/** @param real time delta
	 * @param world object
	 * @param check if player is attacking
	 * @param player object
	 * @param combat check if monster is within range with player to attack
	 * 
	 */
	public void update(int delta, World world, boolean attacked, Player player, boolean combat) {
		if(unit.distance(player.getPlayerPos()) <= 150){
			float new_x = unit.x;
			float new_y = unit.y;
			float algoX = new_x - player.playerVector.x;
	        float algoY = new_y - player.playerVector.y;
	        
			if ((cooldownTimer > 0)) {
				cooldownTimer -= delta/2;
			}
			
	        new_x -=  algoX/unit.distance(player.getPlayerPos()) * speed * delta;
	           			
	        new_y -= algoY/unit.distance(player.getPlayerPos()) * speed * delta;
	
	        double x_sign = Math.signum(world.getdirX());
	        double y_sign = Math.signum(world.getdirY());
	        double playerdealt = Math.random(); // generates random factor
	        if ((attacked) && (getUnitDistance(player) <= 50)) {
				if (player.getCurrRate() <= 0) {
					/** when player attacks monster HP goes down */
					this.unitCurrHP -= (playerdealt*player.getCurrDam());
					player.cooldownTimer = player.playercool;
					}
		    	}
	        
	        if (world.detect_terrain(new_x + x_sign * World.tilewidth/2 , unit.y + World.tilewidth/2 ) == false
	                && world.detect_terrain(new_x + x_sign * World.tilewidth/2 , unit.y - World.tilewidth/2) == false) {
	        	unit.x = (float)new_x;

	        }
	        if (world.detect_terrain(unit.x + World.tilewidth/2, new_y + y_sign * World.tilewidth/2 ) == false 
	                && world.detect_terrain(unit.x - World.tilewidth/2 , new_y + y_sign * World.tilewidth/2 ) == false){
	        	unit.y = (float)new_y;
	        }
			}
		}
		
		
	}
	


