import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * Description
 * 
 * @author Piper Egan 
 * @version 
 */
public class Cows extends Actor
{
    private GreenfootImage image;
    
    private final int size = 30;
    
    public Cows()
    {
        image = new GreenfootImage(size, size);
        
    }
    
    /**
     * Act - do whatever the Cows wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(-1);
        if(isTouching(Aliens.class))
        {
          getWorld().removeObject(this);
        }
    } 
   
   
    
}