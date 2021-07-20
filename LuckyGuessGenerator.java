
/**
 * This class generates a number between 1-5.
 * It it used by the game class to generate random number of machine
 * to be guessed by the player.
 *
 * @author   Mira Kim
 * @version  1.0 (2017.09.08)
 */
public class LuckyGuessGenerator
{
    private int maximumRandomNumber;

    /**
     * Default constructor without specific initial value.
     */
    public LuckyGuessGenerator()
    {
        maximumRandomNumber = 0;
    }
    
    /**
     * Non default constructor to assign specific number 
     * as a maximum random number.
     */
    public LuckyGuessGenerator(int newNumber)
    {
        maximumRandomNumber = newNumber;
    }

    /**
     * Generate and return a random number between 1 and the 
     * maximum number, inclusive.
     */
    public int generateRandomNumber()
    {
        return 1 + (int)(Math.random() * maximumRandomNumber);
    }
    
    /**
     * Return the maximunRandomNumber.
     */
    public int getMaximumRandomNumber()
    {
        return maximumRandomNumber;
    }
    
    /**
     * Display the randomNumber.
     */
    public void printRandomNumber()
    {
        System.out.println(generateRandomNumber());
    }
    
    /**
     * Set the maximum range of random numbers.
     */
    public void setTheMaximumNumber(int maximumNumber)
    {
        maximumRandomNumber = maximumNumber;
    }
}
