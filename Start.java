import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Start here.
 * 
 * @author (Piper Egan) 
 * @version (6/1/20
 */
public class Start extends World
{

    public Start()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        //GreenfootImage start = new GreenfootImage("");
        //start.scale(900,900);
        //setBackground(start);
        prepare();
    }

    public void act()
    {
        if(Greenfoot.isKeyDown("enter"))
        {
            Greenfoot.setWorld(new Rules());
            //Greenfoot.playSound("");
        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}
