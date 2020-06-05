import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CowCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CowCounter extends Actor
{
    //private int value = 0;
    private String text;

    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage background;
    private int value;
    private int target;
    private String prefix;
    
    /**
     * Create a counter without a text prefix, initialized to zero.
     */
    public CowCounter()
    {
        this(new String());
    }
    
    public CowCounter(String prefix)
    {
        text = prefix;
        int imageWidth= (text.length() + 2) * 10;
        setImage(new GreenfootImage(imageWidth, 16));
        updateImage();
        
        background = getImage();  
        value = 0;
        target = 0;
        this.prefix = prefix;
        updateImage();
    }

    public void act() 
    {
        if (value < target) {
            value++;
            updateImage();
        }
        else if (value > target) {
            value--;
            updateImage();
        }
    }

    public void add(int score)
    {
        target += score;
    }

    /**
     * Return the current counter value.
     */
    public int getValue()
    {
        return target;
    }

    /**
     * Set a new counter value.  This will not animate the counter.
     */
    public void setValue(int newValue)
    {
        target = newValue;
        value = newValue;
        updateImage();
    }
    
    /**
     * Sets a text prefix that should be displayed before
     * the counter value (e.g. "Score: ").
     */
    public void setPrefix(String prefix)
    {
        this.prefix = prefix;
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

    private void updateImage()
    {
        GreenfootImage image = getImage();
        image.clear();
        image.drawString(text + value, 1, 12);
    }
}




