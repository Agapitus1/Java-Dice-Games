package model;


public class Dice extends Updater //model inherits from Updater
{
    private final int SIDES = 6;
    private int roll;//date is stored by the object
    
    /**
     * Constructor for objects of class Dice
     */
    public Dice()
    {
    }
    
    public void roll()//procedures that change data MUST call updateViews()
    {
       roll = (int) ((Math.random()*SIDES)+1);
       updateViews();//calls update for each observer
    }
    public int getRoll()//window calls accessor to refresh the data
    {
        return roll;
    }
}
