import java.util.Scanner;
/**
 * Game class is responsible for displaying menu, accepting user responses,
 * and performing the requested operations.
 * It will make one Player object and one LuckyGuessGenerator object.
 *
 * @author   Mira Kim
 * @version  1.0 (2017.09.08)
 */
public class Game
{
    private Player player;
    private LuckyGuessGenerator generator;

    /**
     * Default constructor to create a game with one Player object 
     * and one LuckyGuessGenerator object.
     */
    public Game()
    {
        player = new Player();
        generator = new LuckyGuessGenerator();
    }
    
    /**
     * Non default constructor to create objects with the parameters.
     */
    public Game(String name, String prize, int worth, int spent, int maxNumber)
    {
        player = new Player(name, prize, worth, spent);
        generator = new LuckyGuessGenerator(maxNumber);
    }

    /**
     * This is switch statement to move to each menu option 
     * depends on the user input.
     */
    public void chooseMenu(String option)
    {
        switch (option)
        {
            case "1": 
                      setUpPlayer(); 
                      break;
            case "2":
                      guessPrize(); 
                      break;
            case "3":
                      displayCurrentRecords(); 
                      break;
            case "4":
                      displayGameHelp();
                      break;
            case "5":
                      exits(); 
                      break;
            default: 
                      System.out.println("Invalid option. Choose between 1-5.");
                      break;
        }
    }
    
    /**
     * This method shows the records of current user so far,
     * what prize user won and how much money user spent is.
     */
    public void displayCurrentRecords()
    {
        nameCheck();
        System.out.println("Player " + player.getName());
        System.out.println("Prizes: " + player.getPrize());
        System.out.println("Total worth of prizes is $" + player.getWorth());
        System.out.println("Total spending is $" + player.getSpending());
    }
    
    /**
     * This shows the guide for the game play and rules.
     */
    public void displayGameHelp()
    {
        System.out.println("======================================================");
        System.out.println("This is simple Lucky Vending Machine Game.");
        System.out.println("Menu 1 is to start new game by setting up new player.");
        System.out.println("Be aware that all the prizes and spending will be '0'.");
        System.out.println("Menu 2 is to play a game. You have to guess");
        System.out.println("the same number with the machine generated.");
        System.out.println("Whenever you're correct each prize will be recorded.");
        System.out.println("if the number is wrong, you'll lose money.");
        System.out.println("------------------------------------------------------");
        System.out.println("    1    |  win Pen (worth $10)  or cost $1");
        System.out.println("    2    |  win Book (worth $20)  or cost $2");
        System.out.println("    3    |  win DVD (worth $30)  or cost $3");
        System.out.println("    4    |  win Mouse (worth $40)  or cost $4");
        System.out.println("    5    |  win Keyboard (worth $50)  or cost $5");
        System.out.println("------------------------------------------------------");
        System.out.println("You can check the current record anytime in Menu 3.");
        System.out.println("Menu 5 is for game exit.");
    }
    
    /**
     * Display a menu without performing any action.
     */
    public void displayMenu()
    {
        System.out.println();
        System.out.println("Welcome to the Lucky Vending Machine");
        System.out.println("====================================");
        System.out.println("(1) Set Up New Player");
        System.out.println("(2) Guess A Prize");
        System.out.println("(3) What Have I Won So Far?");
        System.out.println("(4) Display Game Help");
        System.out.println("(5) Exit Game");
        System.out.println("Choose an option: ");
        System.out.println();
    }
    
    /**
     * Game stops running and finishes.
     */
    public void exits()
    {
        System.out.println("Thanks, bye");
        System.exit(0);
    }
    
    /**
     * This method is responsible for the game playing. 
     * User must input the valid number from 1 to 5.
     * If it is the same number with the generated number by machine,
     * the user win the prize. 
     * If the number is different, the spending will be added instead.
     */
    public void guessPrize()
    {
        nameCheck();
        System.out.println("Guess the lucky number between 1-5");
        System.out.println();
        Scanner console = new Scanner(System.in);
        String guessNumber = console.nextLine();
        while (!validNumberRange(guessNumber))
        {
            System.out.println("It's not a valid number. Choose between 1-5.");
            guessNumber = console.nextLine();
        }
        System.out.println("Your choice is " + guessNumber);
        LuckyGuessGenerator generator = new LuckyGuessGenerator(5);
        int randomNumber = generator.generateRandomNumber();
        System.out.println("My number is " + randomNumber);
        int guessNumberToInteger = Integer.parseInt(guessNumber);
        if (randomNumber == guessNumberToInteger)
            showPrize(guessNumber);
        else
        {
            System.out.println("Sorry, you're wrong. Please try again.");
            player.loseMoney(guessNumberToInteger);       
        }
    }
    
    /**
     * Check name if the user has been set up when menu 2 or 3 was selected.
     */
    public void nameCheck()
    {
        if (!validName())
        {
            System.out.println("Player has not been set up!");
            start();
        }
    }
    
    /**
     * Set up new player with the initial values of prize, worth, spent money.
     * It also replaces the current player to the new player.
     * When the player name is empty, it sends an error message.
     */
    public void setUpPlayer()
    {
        player = new Player();
        Scanner console = new Scanner(System.in);
        while (!validName())
        {
            System.out.println("Enter your name");
            player.setName(console.nextLine());
            if (!validName())
               System.out.println("Name must not be blank");
        }
        System.out.println("Hello, " + player.getName());
    }
    
    public void printMessage(String prize, int worth)
    {
        player.addPrize(prize);
        player.addWorth(worth);
        System.out.println("Congratulations! You have won a " + prize + ","); 
        System.out.println("worth " + worth + ".");
    }
    
    /**
     * This switch statement is for adding prize with worth and showing 
     * the result, in case of the user guess the same number with the machine.
     */
    public void showPrize(String guessNumber)
    {
        switch (guessNumber)
        {
            case "1": 
                      printMessage("Pen", 10);
                      break;
            case "2":
                      printMessage("Book", 20);
                      break;
            case "3":
                      printMessage("DVD", 30);
                      break;
            case "4":
                      printMessage("Mouse", 40);
                      break;
            case "5": 
                      printMessage("Keyboard", 50);
                      break;  
            default:
                      System.out.println("Invalid number");
        }
    }
    
    /**
     * Start a game. The menu is displayed until 'Exit' menu is chosen.
     * It checks if the user input is valid.
     */
    public void start()
    {
        String option = "0";
        while (option.charAt(0) != 5)
        {
            displayMenu();
            Scanner console = new Scanner(System.in);
            option = console.nextLine();
            if (validNumberRange(option))    
                chooseMenu(option);
            else
                System.out.println("Invalid option. Choose between 1-5.");
        }
    }
    
    /**
     * Return boolean value to check if the name is blank.
     */
    public boolean validName()
    {
        if (player.getName().trim().length() == 0)
            return false;
        else
            return true;
    }
    
    /**
     * Verify user input valid number between 1-5.
     */
    public boolean validNumberRange(String number)
    {
        if (number.isEmpty())
        return false;
        int position = 0;
        while (position < number.length())
        {
            char thisCharacter = number.charAt(position);
            if (thisCharacter < '1' || thisCharacter > '5')
                return false;
            position++;
        }
        return true;
    }
}