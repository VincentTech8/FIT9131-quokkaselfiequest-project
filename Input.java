import java.util.Scanner;

/**
* This class gets input from the users.
*
* @author Vincent
* @version ver1.0.0
*/
public final class Input
{
    /**
     * Default constructor which creates the object of the class Input.
     */
    private Input()
    {

    }

    /**
     * Method that accepts a String input from the user.
     *
     * @param displayMessage         Accepts the the message to display as a
     *                               String.
     *
     * @return                       The input of a user as a String.
     */
    public static String acceptStringInput(String displayMessage)
    {
        Scanner console = new Scanner(System.in);
        System.out.print(displayMessage);
        String input = console.nextLine();
        return input;
    }
}
