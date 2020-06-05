import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pumpkin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pumpkin extends SmoothMover
{
    private static final int damage = 10;
   
    private int life = 40;
    private static final int pointsToAdd = 1;
   
    public Pumpkin()
    {
    }
    
    /**
     * Create a bullet with given speed and direction of movement.
     */
    public Pumpkin(Vector speed, int rotation)
    {
        super(speed);
        setRotation(rotation);
        addToVelocity(new Vector(rotation, 15));
        //Greenfoot.playSound("EnergyGun.wav");
    }
    
    public void act()
    {
        if(life <= 0) {
            getWorld().removeObject(this);
        } 
        else {
            life--;
            move();
            checkAliensHit();
        }
    }
    
    private void checkAliensHit()
    {
        Aliens aliens = (Aliens) getOneIntersectingObject(Aliens.class);
        if (aliens != null)
        {
           ((Farm) getWorld()).updateScore(pointsToAdd);
           getWorld().removeObject(this);
           aliens.hit(damage);
        }
    }
}
