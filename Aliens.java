import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Aliens here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Aliens extends SmoothMover
{
    private int size;

    private int stability;
    
    private boolean carryingCows = false;
    
    private GreenfootImage image1;
    private GreenfootImage image2;
    
    private final int MAX_PH_AVAILABLE = 16;
    private int phAvailable = MAX_PH_AVAILABLE;
    
    private final int TIME_FOLLOWING_TRIAL = 30;
    private int followTrialTimeRemaining = 0;
    
    public Aliens()
    {
        this(40);
    }
    
    public Aliens(int size)
    {
        super(new Vector(Greenfoot.getRandomNumber(360), 2));
    }      
    
    public Aliens(int size, Vector velocity)
    {
        super(velocity);
           }
           
    /**
     * Create an ant with a given home hill. The initial speed is zero (not moving).
     */
    public Aliens(MotherShip home)
    {
        setHomeHill(home);
        image1 = getImage();
        image2 = new GreenfootImage("abducted.png");
    }

    /**
     * Do what an ant's gotta do.
     */
    public void act()
    {
        status();
        turnAtEdge(180);
    }
      
    public void turnAtEdge(int degrees)
    {
        if (isAtEdge())
        {
            turn(degrees);
        }
    }
    
    public void turnRandomly()
    {
        int turnDegree = Greenfoot.getRandomNumber(30 * 2) - 30;
        turn(turnDegree);
    }
    
    private void checkForCows()
    {
        Cows cows = (Cows) getOneIntersectingObject(Cows.class);
        if (cows != null) 
        {
            carryingCows = true;
            setImage(image2);
        }
        
    }
    
    private boolean atHome()
    {
         if (getHomeHill() != null) 
        {
            return (Math.abs(getX() - getHomeHill().getX()) < 4) && 
                   (Math.abs(getY() - getHomeHill().getY()) < 4);
        }
         else 
        {
            return false;
        }
    }
    
    private void searchForCows()
    {
         if(followTrialTimeRemaining == 0)
        {
          if (Greenfoot.getRandomNumber(360) <= 10)
          {
             turnRandomly();
          } 
          else 
          {
             move(3);
          }
        }
        else
        {
          followTrialTimeRemaining--;
          walkAwayFromHome();         
        }
        checkForCows();
    }
    
    private void status()
    {
         if (carryingCows == true)
        {
            
            walkTowardsHome();
            if(atHome()) 
            {
                setImage(image1);
                carryingCows = false;
                
            }
        }
         else
        {
            searchForCows();
        }
    }
    
    
    
    
    public int getStability() 
    {
        return stability;
    }
    
    public void hit(int damage) 
    {
        stability = stability - damage;
        if (stability <= 0) 
        {
            breakUp();
        }
    }
    
    private void breakUp() 
    {
        Greenfoot.playSound("Explosion.wav");
        
        if (size <= 16) {
             setImage("deadrock.png");
            getWorld().removeObject(this);
        }
        else {
            int r = getVelocity().getDirection() + Greenfoot.getRandomNumber(45);
            double l = getVelocity().getLength();
            Vector speed1 = new Vector(r + 60, l * 1.2);
            Vector speed2 = new Vector(r - 60, l * 1.2);        
            Aliens a1 = new Aliens(size/2, speed1);
            Aliens a2 = new Aliens(size/2, speed2);
            getWorld().addObject(a1, getX(), getY());
            getWorld().addObject(a2, getX(), getY());        
            a1.move();
            a2.move();
        
            getWorld().removeObject(this);
        }
    }
    /*private void checkCollision()
    {
        if(getOneIntersectingObject(Pumpkin.class) != null)
        {
            Farm farm = (Farm) getWorld();
            farm.addObject(new Explosion(), getX(), getY());
            setImage("deadrock.png");
            getWorld.removeObject(this);
        }
        
    }*/
}
