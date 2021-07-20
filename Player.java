
/**
 * Player object remembers the current player's name, what prizes the player 
 * has won and the total worth, how much the player has spent.
 * All the records of the current player will be stored in this class.
 *
 * @author   Mira Kim
 * @version  1.0 (2017.09.08)
 */
public class Player
{
    private String name;
    private String prizes;
    private int worth;
    private int spending;

    /**
     * Default constructor to set up a player without specific values.
     */
    public Player()
    {
        name = "";
        prizes = "no prizes";
        worth = 0;
        spending = 0;
    }
    
    /**
     * Non default constructor to set up a player with the specific values.
     */
    public Player(String aName, String aPrize, int prizeWorth, int initialCost)
    {
        name = aName;
        prizes = aPrize;
        worth = prizeWorth;
        spending = initialCost;
    }

    /**
     * This method is to add new prize to the current prize list.
     */
    public void addPrize(String anotherPrize)
    {
        if (prizes.equals("no prizes"))
            prizes = anotherPrize;
        else
            prizes = prizes + ", " + anotherPrize;
    }
    
    /**
     * Add the additional worth of prize to the total worth.
     */
    public void addWorth(int prizeWorth)
    {
        worth = worth + prizeWorth;
    }
    
    /**
     * Return the player's name.
     */
    public String getName()
    {
        // put your code here
        return name;
    }
    
    /**
     * Return the value about what prizes the player has won.
     */
    public String getPrize()
    {
        return prizes;
    }
    
    /**
     * Return how much money the player spent.
     */
    public int getSpending()
    {
        return spending;
    }
    
    /**
     * Return the total worth the player has won.
     */
    public int getWorth()
    {
        return worth;
    }
    
    /**
     * Set the player's name with the parameter.
     */
    public void setName(String newName)
    {
        name = newName;
    }
    
    /**
     * Set prizes with the parameter.
     */
    public void setPrize(String newPrize)
    {
        prizes = newPrize;
    }
    
    /**
     * Set the spending value with the parameter.
     */
    public void setSpending(int spendingMoney)
    {
        spending = spendingMoney;
    }
    
    /**
     * Set the total prize worth the player has won with the parameter.
     */
    public void setWorth(int newWorth)
    {
        worth = newWorth;
    }
    
    /**
     * This method is to add additional spending for the player.
     */
    public void loseMoney(int cost)
    {
        spending = spending + cost;
    }
}
