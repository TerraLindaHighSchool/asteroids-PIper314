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
    private int maxAliens = 3;
    
    /** Counter to show how much cows have been collected so far. */
    private CowCounter cowsCowCounter;
    
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

    /**
     * Record that we have collected another bit of cows.
     */
    public void countCows()
    {
        // if we have no cows counter yet (first time) -- create it
        if(cowsCowCounter == null) 
        {
            cowsCowCounter = new CowCounter("Cows: ");
            int x = getY();
            int y = getX() + getImage().getWidth()/2 + 8;

            getWorld().addObject(cowsCowCounter, x, y);
        }        
        cowsCowCounter.increment();
    }
}
