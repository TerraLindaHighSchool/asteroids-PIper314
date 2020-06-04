import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Farm extends World
{
    private Counter scoreCounter;
    private int startAliens = 5;
    
    public static final int SIZE = 640;

    /**
     * Create a new world. It will be initialised with a few ant hills
     * and cows sources
     */
    public Farm()
    {
        super(900, 900, 1); 
        prepare();
        
        
        scoreCounter = new Counter("Cows Left:");
        addObject(scoreCounter, 835, 20);
        
        Explosion.initializeImages();
        setPaintOrder(Aliens.class, MotherShip.class);
        prepare();
    }
    
    public void act()
    {
        if(getObjects(Cows.class).size() == 0)
        {
            Greenfoot.stop();
        }
    }
    
    public void updateScore(int subtractFromScore)
    {
        scoreCounter.add(subtractFromScore);
    }
    
   
    public void gameOver() 
    {
        int currentScore = scoreCounter.getValue();

        int x = getWidth() /2;
        int y = getHeight() /2;

        addObject(new ScoreBoard(currentScore),x ,y);    
    }
    
    private void prepare()
    {

        CowCounter cowCounter = new CowCounter();
        addObject(cowCounter,466,19);

        Cows cows = new Cows();
        addObject(cows,94,524);
        Cows cows2 = new Cows();
        addObject(cows2,790,512);
        Cows cows3 = new Cows();
        addObject(cows3,730,765);
        Cows cows4 = new Cows();
        addObject(cows4,357,612);
        Cows cows5 = new Cows();
        addObject(cows5,59,751);

        Cows cows6 = new Cows();
        addObject(cows6,540,460);
        Cannon cannon = new Cannon();
        addObject(cannon,465,876);
        MotherShip motherShip = new MotherShip();
        addObject(motherShip,461,90);
    }
}
