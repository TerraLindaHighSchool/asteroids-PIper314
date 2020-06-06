import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MotherShip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MotherShip extends Actor
{
    
    private int aliens = 0;
    
    /** Total number of aliens in this hill. */
    private int maxAliens = 8;
    
    /** Counter to show how much cows have been collected so far. */
    
    
    /**
     * Constructor for ant hill with default number of aliens (40).
     */
    public MotherShip()
    {
        
    }

    /**
     * Construct an ant hill with a given number of aliens.
     */
    public MotherShip(int numberOfAliens)
    {
        maxAliens = numberOfAliens;
    }

    /**
     * Act: If there are still aliens left inside, see whether one should come out.
     */
    public void act()
    {
        if(aliens < maxAliens) 
        {
            if(Greenfoot.getRandomNumber(100) < 10) 
            {
                getWorld().addObject(new Aliens(this), getX(), getY());
                aliens++;
            }
        }
    }

    
}
