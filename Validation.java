/**
* This class validates the condition in the selection statement.
*
* @author Vincent
* @version ver1.0.0
*/
public final class Validation
{
    /**
     * Default constructor which creates the object of the class Validation.
     */
    private Validation()
    {
        
    }

    /**
     * Method that validates whether an integer is within a given range.
     *
     * @return  The result of the validation as a boolean.
     */
    public static boolean isIntegerValueWithinRange(int input, int lowerBound,
        int upperBound)
    {
        if (input >= lowerBound && input <= upperBound)
        {
            return true;
        }
        return false;
    }

    /**
     * Method that validates whether the String object only contains an integer
     * value.
     *
     * @return  The result of the validation as a boolean.
     */
    public static boolean isOnlyInteger(String input)
    {
        try
        {
            Integer.parseInt(input);
            return true;
        } 
        catch (NumberFormatException e)
        {
            return false;
        }
    }
}
