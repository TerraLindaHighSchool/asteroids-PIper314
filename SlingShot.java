import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cannon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SlingShot extends SmoothMover
{
    private static final int gunReloadTime = 25;

    private int reloadDelayCount;
    private Vector velocity;
    
    private GreenfootImage cannon = new GreenfootImage("rocket.png");    
    private GreenfootImage rocketWithThrust = new GreenfootImage("rocketWithThrust.png");
    private int x = getRotation();
    
    /**
     * Initialise this rocket.
     */
    public SlingShot()
    {
        reloadDelayCount = 5;
        addToVelocity(new Vector(125, .5));
        addToVelocity(new Vector(10, 0.2));
    }
    
    /**
     * Act - do whatever the Cannon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkKeys();
        reloadDelayCount++;
    }    
    
    private void checkKeys() 
    {
        if (Greenfoot.isKeyDown("space")) 
        {
            fire();
        }
        
        if (Greenfoot.isKeyDown("left")) 
        {
            turn(-2);
        }
        
        if (Greenfoot.isKeyDown("right")) 
        {
            turn(2);
        }
        ignite(Greenfoot.isKeyDown("space"));
    }
    
    private void fire() 
    {
        if (reloadDelayCount >= gunReloadTime) 
        {
            Pumpkin pumpkin = new Pumpkin (getVelocity(), getRotation());
            getWorld().addObject (pumpkin, getX(), getY());
            pumpkin.move ();
            reloadDelayCount = 0;
        }
    }
    
    private void ignite(boolean boosterOn)
    {
        if(boosterOn = true)
        {
          if(Greenfoot.isKeyDown("space"))
              {
                setImage("rocketWithThrust.png");
              }
          if(!Greenfoot.isKeyDown("space"))
              {
                setImage("rocket.png");
              } 
        }
    }
}
