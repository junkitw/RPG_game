import org.newdawn.slick.*;
import java.math.*;
import java.util.Random;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.*;


public abstract class PassiveMonster extends Unit {
	double real_time; // real time movement
	double new_x, new_y;
	private double algoX, algoY;
	float nextmoveX;
	float nextmoveY;
	private double speed = 0.2;
	
	public PassiveMonster(float x, float y)  
			{
				super(x,y);
			}
		
	@Override
	public void update(int delta, World world, boolean attacked, Player player, boolean combat) {
		
		
		
		float[] a = {-1, 0, 1};
		Random r = new Random();
		
		real_time += (int)delta;
		
		/** moves every 3 seconds */
		if (real_time >= 3 * deltaVal){ 
			nextmoveX = a[(r.nextInt(a.length))];
			nextmoveY = a[(r.nextInt(a.length))];
			real_time = 0;
		}
		
		new_x = unit.x + nextmoveX * delta * speed;
		new_y = unit.y + nextmoveY * delta * speed;
		algoX = Math.abs(new_x - player.playerVector.x);
        algoY = Math.abs(new_y - player.playerVector.y);
		/** tries tp run away from player */
        if ((attacked) && (getUnitDistance(player) <= 150)) {
           	new_x += (algoX/(getUnitDistance(player)) * speed * delta);
           			
           	new_y += (algoY/(getUnitDistance(player)) * speed * delta);
            		
		}
		
        double x_sign = Math.signum(nextmoveX);
        double y_sign = Math.signum(nextmoveY);
        double playerdealt = Math.random();
        if ((attacked) && (getUnitDistance(player) <= 50)) {
			if (player.getCurrRate() <= 0) {
				this.unitCurrHP -= (playerdealt*player.getCurrDam());
				player.cooldownTimer = player.playercool;
				}
	    	}
        
        /** terrain blocking and so it doesn't go out of map */
        if (world.detect_terrain(new_x + x_sign * World.tilewidth/2 , unit.y + World.tilewidth/2 ) == false
                && world.detect_terrain(new_x + x_sign * World.tilewidth/2 , unit.y - World.tilewidth/2) == false) {
        	unit.x = (float)new_x;

        }
        if (world.detect_terrain(unit.x + World.tilewidth/2, new_y + y_sign * World.tilewidth/2 ) == false 
                && world.detect_terrain(unit.x - World.tilewidth/2 , new_y + y_sign * World.tilewidth/2 ) == false){
        	unit.y = (float)new_y;
        }
        unit.x = unit.x - World.tilewidth < 0 ? 0 + World.tilewidth : unit.x;
		unit.y = unit.y - World.tilewidth < 0 ? 0 + World.tilewidth : unit.y;
		unit.x = unit.x + World.tilewidth > World.whole_game ? World.whole_game - World.tilewidth : unit.x;
		unit.y = unit.y + World.tilewidth > World.whole_game ? World.whole_game - World.tilewidth : unit.y;
		
		}
	public double getunitcurrhp() {
		return unitCurrHP;
	}
}
