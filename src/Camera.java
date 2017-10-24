/* SWEN20003 Object Oriented Software Development
 * RPG Game Engine
 * Author: <Your name> <Your login>
 */

import org.newdawn.slick.SlickException;

/** Represents the camera that controls our viewpoint.
 */
public class Camera
{

    /** The unit this camera is following */
    private Player unitFollow;
    
    /** The width and height of the screen */
    /** Screen width, in pixels. */
    public final int screenwidth;
    /** Screen height, in pixels. */
    public final int screenheight;

    
    /** The camera's position in the world, in x and y coordinates. */
    private int xPos;
    private int yPos;
    
    
    /** Referring to the x coordinate. */
    public int getxPos() {
    	return this.xPos;
    }

    /** Referring to the y coordinate. */
    public int getyPos() {
    	return this.yPos;
    }

    /** Create a new Camera object. 
     * @param player		Player object to be passed in to this Camera object.
     * @param screenwidth	Resolution of screen of 800 wide. 
     * @param screenheight	Resolution of screen of 600 height.
     */
    public Camera(Player player, int screenwidth, int screenheight)
    {   

    	this.screenwidth = screenwidth;
    	this.screenheight = screenheight;
    	this.unitFollow = player;
    	xPos = (int)unitFollow.playerVector.x;  // camera to follow player's x-coordinate
    	yPos = (int)unitFollow.playerVector.y;  // camera to follow player's y-coordinate
    }

    /** Update the game camera to recentre it's viewpoint around the player 
     */
    public void update()
    throws SlickException
    {
    	followUnit(unitFollow);
    	
    }
    
    /** Returns the minimum x value on screen 
     */
    public int getMinX(){
    	// x-coordinate of tile in top left corner 
    	// divide by tilewidth to be in terms of tiles and NOT pixels
    	return (xPos - (screenwidth/2));	
    }
    
    
    /** Returns the minimum y value on screen 
     */
    public int getMinY(){
    	// y-coordinate of tile in top left corner 
    	return (yPos - (screenheight/2));
    }
    
    /** The offset value for x to be rendered in the map. */
    public int getX() {
    	return (xPos-(screenwidth/2)) % World.tilewidth;
    }
    
    /** The offset value for y to be rendered in the map. */
    public int getY() {
    	return (yPos-(screenheight/2)) % World.tilewidth;
    }

    /** Tells the camera to follow a given unit. 
     * @param unit	The player unit for the camera to follow according to its x and y coordinates.
     * @throws SlickException
     */
    public void followUnit(Object unit)
    throws SlickException
    {
    	xPos = (int)((Player)unit).playerVector.x;
    	yPos = (int)((Player)unit).playerVector.y;
    }
    
}