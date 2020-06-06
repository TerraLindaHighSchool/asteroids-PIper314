import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Farm extends World
{
    
    GreenfootSound music;
    private Counter scoreCounter;
    public static final int SIZE = 640;
    private int frameCount;
    /**
     * Create a new world. It will be initialised with a few ant hills
     * and cows sources
     */
    public Farm()
    {
        super(1000, 900, 1); 
        
        scoreCounter = new Counter("Aliens Destroyed: ");
        addObject(scoreCounter, 99, 880);
       
        Explosion.initializeImages();
        setPaintOrder(Aliens.class, MotherShip.class);
        music = new GreenfootSound("abducted.mp3");
        prepare();
    }
    
    public void updateScore(int addToScore)
    {
        scoreCounter.add(addToScore);
    }
    
    private void prepare()
    {
        SlingShot slingshot = new SlingShot();
        addObject(slingshot,465,876);
        MotherShip motherShip = new MotherShip();
        addObject(motherShip,458,65);
        
        music.playLoop();
    }
    
    public void act()
    {
        spawnObjects();
        frameCount++;

        if(frameCount == 1000)
        {
            frameCount = 0;
        }
    }
    
    public int getFrameCount()
    {
        return frameCount;
    }
    
    public void spawnObjects()
    {
        switch (frameCount)
        {
            case 150:
                addObject(new Cows(), 964, 634);
                break;
            case 400:
                addObject(new Cows(), 964, 634);
                break;
            case 600:
                addObject(new Cows(), 964, 634);
                break;
            case 800:
                addObject(new Cows(), 964, 634);
                break;
            case 100:
                addObject(new Cows(), 964, 634);
                break;
            case 200:
                addObject(new Cows(), 964, 634);
                break;
            case 450:
                addObject(new Cows(), 964, 634);
                break;
            case 650:
                addObject(new Cows(), 964, 634);
                break;
            case 850:
                addObject(new Cows(), 964, 634);
                break;
            case 250:
                addObject(new Cows(), 964, 634);
                break;
            case 350:
                addObject(new Cows(), 964, 634);
                break;
            case 750:
                addObject(new Cows(), 964, 634);
                break;
            case 890:
                addObject(new Cows(), 964, 634);
                break;
            case 980:
                addObject(new Cows(), 964, 634);
                break;
            case 230:
                addObject(new Cows(), 964, 634);
                break;
            default: 
                break;
            
        }
    }
}
