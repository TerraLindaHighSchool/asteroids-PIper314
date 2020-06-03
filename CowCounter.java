import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CowCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CowCounter extends Actor
{
    private int value = 0;
    private String text;

    /**
     * Create a counter without a text prefix, initialized to zero.
     */
    public CowCounter()
    {
        this("");
    }

    /**
     * Create a counter with a given text prefix, initialized to zero.
     */
    public CowCounter(String prefix)
    {
        text = prefix;
        int imageWidth= (text.length() + 2) * 10;
        setImage(new GreenfootImage(imageWidth, 16));
        updateImage();
    }

    /**
     * Increment the counter value by one.
     */
    public void increment()
    {
        value++;
        updateImage();
    }

    /**
     * Show the current text and count on this actor's image.
     */
    private void updateImage()
    {
        GreenfootImage image = getImage();
        image.clear();
        image.drawString(text + value, 1, 12);
    }
}
