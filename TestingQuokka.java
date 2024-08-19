/**
* This class manages testing of Quokka class.
*
* @author Vincent
* @version ver1.0.0
*/
public class TestingQuokka
{
    /**
     * Default constructor which creates the object of the class TestingQuokka.
     */
    public TestingQuokka()
    {

    }

    /**
     * Method that begin the program execution.
     *
     * @param args          An array of String passed in as command line
     *                      parameters.
     */
    public static void main(String[] args)
    {
        TestingQuokka objTestingQuokka = new TestingQuokka();
        // Default constructor testing
        objTestingQuokka.testDefault();
        // Non-default constructor testing
        System.out.println("");
        objTestingQuokka.testNonDefault();
        // getBabyCounted() testing
        System.out.println("");
        objTestingQuokka.testGetBabyCounted();
        // getConsecutiveDaysNotEaten() testing
        System.out.println("");
        objTestingQuokka.testGetConsecutiveDaysNotEaten();
        // getDaysNotEaten() testing
        System.out.println("");
        objTestingQuokka.testGetDaysNotEaten();
        // getFoodSupply() testing
        System.out.println("");
        objTestingQuokka.testGetFoodSupply();
        // getHasBaby() testing
        System.out.println("");
        objTestingQuokka.testGetHasBaby();
        // getId() testing
        System.out.println("");
        objTestingQuokka.testGetId();
        // getIsAlive() testing
        System.out.println("");
        objTestingQuokka.testGetIsAlive();
        // setBabyCounted() testing
        System.out.println("");
        objTestingQuokka.testSetBabyCounted();
        // setConsecutiveDaysNotEaten() testing
        System.out.println("");
        objTestingQuokka.testSetConsecutiveDaysNotEaten();
        // setDaysNotEaten() testing
        System.out.println("");
        objTestingQuokka.testSetDaysNotEaten();
        // setFoodSupply() testing
        System.out.println("");
        objTestingQuokka.testSetFoodSupply();
        // setHasBaby() testing
        System.out.println("");
        objTestingQuokka.testSetHasBaby();
        // setId() testing
        System.out.println("");
        objTestingQuokka.testSetId();
        // setIsAlive() testing
        System.out.println("");
        objTestingQuokka.testSetIsAlive();
        // decrementFoodSupply() testing
        System.out.println("");
        objTestingQuokka.testDecrementFoodSupply();
        // incrementConsecutiveDaysNotEaten() testing
        System.out.println("");
        objTestingQuokka.testIncrementConsecutiveDaysNotEaten();
        // incrementDaysNotEaten() testing
        System.out.println("");
        objTestingQuokka.testIncrementDaysNotEaten();
        // incrementFoodSupply() testing
        System.out.println("");
        objTestingQuokka.testIncrementFoodSupply();
        // toString() testing
        System.out.println("");
        objTestingQuokka.testToString();
    }

    /**
     * Method that tests decrementFoodSupply() method of a Quokka class.
     */
    public void testDecrementFoodSupply()
    {
        Quokka objQuokka1 = new Quokka();
        objQuokka1.decrementFoodSupply(2);
        System.out.println("Test decrementFoodSupply() with valid values.");
        System.out.println("foodSupply: " + objQuokka1.getFoodSupply());
        System.out.println("");
        Quokka objQuokka2 = new Quokka();
        objQuokka1.decrementFoodSupply(-1);
        System.out.println("Test decrementFoodSupply() with invalid values.");
        System.out.println("foodSupply: " + objQuokka2.getFoodSupply());
    }

    /**
     * Method that tests default constructor of a Quokka class.
     */
    public void testDefault()
    {
        Quokka objQuokka = new Quokka();
        System.out.println(objQuokka.toString());
    }

    /**
     * Method that tests getBabyCounted() method of a Quokka class.
     */
    public void testGetBabyCounted()
    {
        Quokka objQuokka = new Quokka();
        System.out.println("Test getBabyCounted().");
        System.out.println("babyCounted: " + objQuokka.getBabyCounted());
    }

    /**
     * Method that tests getConsecutiveDaysNotEaten() method of a Quokka class.
     */
    public void testGetConsecutiveDaysNotEaten()
    {
        Quokka objQuokka = new Quokka();
        System.out.println("Test getConsecutiveDaysNotEaten().");
        System.out.println("consecutiveDaysNotEaten: " +
            objQuokka.getConsecutiveDaysNotEaten());
    }

    /**
     * Method that tests getDaysNotEaten() method of a Quokka class.
     */
    public void testGetDaysNotEaten()
    {
        Quokka objQuokka = new Quokka();
        System.out.println("Test getDaysNotEaten().");
        System.out.println("daysNotEaten: " + objQuokka.getDaysNotEaten());
    }

    /**
     * Method that tests getFoodSupply() method of a Quokka class.
     */
    public void testGetFoodSupply()
    {
        Quokka objQuokka = new Quokka();
        System.out.println("Test getFoodSupply().");
        System.out.println("foodSupply: " + objQuokka.getFoodSupply());
    }

    /**
     * Method that tests getHasBaby() method of a Quokka class.
     */
    public void testGetHasBaby()
    {
        Quokka objQuokka = new Quokka();
        System.out.println("Test getHasBaby().");
        System.out.println("hasBaby: " + objQuokka.getHasBaby());
    }

    /**
     * Method that tests getId() method of a Quokka class.
     */
    public void testGetId()
    {
        Quokka objQuokka = new Quokka();
        System.out.println("Test getId().");
        System.out.println("Id: " + objQuokka.getId());
    }

    /**
     * Method that tests getIsAlive() method of a Quokka class.
     */
    public void testGetIsAlive()
    {
        Quokka objQuokka = new Quokka();
        System.out.println("Test getIsAlive().");
        System.out.println("isAlive: " + objQuokka.getIsAlive());
    }

    /**
     * Method that tests incrementConsecutiveDaysNotEaten() method of a Quokka
     * class.
     */
    public void testIncrementConsecutiveDaysNotEaten()
    {
        Quokka objQuokka = new Quokka();
        objQuokka.incrementConsecutiveDaysNotEaten();
        System.out.println("Test incrementConsecutiveDaysNotEaten().");
        System.out.println("consecutiveDaysNotEaten: " +
            objQuokka.getConsecutiveDaysNotEaten());
    }

    /**
     * Method that tests incrementDaysNotEaten() method of a Quokka class.
     */
    public void testIncrementDaysNotEaten()
    {
        Quokka objQuokka = new Quokka();
        objQuokka.incrementDaysNotEaten();
        System.out.println("Test incrementDaysNotEaten().");
        System.out.println("daysNotEaten: " + objQuokka.getDaysNotEaten());
    }

    /**
     * Method that tests incrementFoodSupply() method of a Quokka class.
     */
    public void testIncrementFoodSupply()
    {
        Quokka objQuokka1 = new Quokka();
        objQuokka1.incrementFoodSupply(1);
        System.out.println("Test incrementFoodSupply() with valid values.");
        System.out.println("foodSupply: " + objQuokka1.getFoodSupply());
        System.out.println("");
        Quokka objQuokka2 = new Quokka();
        objQuokka1.incrementFoodSupply(-1);
        System.out.println("Test incrementFoodSupply() with invalid values.");
        System.out.println("foodSupply: " + objQuokka2.getFoodSupply());
    }

    /**
     * Method that tests non-default constructor of a Quokka class.
     */
    public void testNonDefault()
    {
        Quokka objQuokka1 = new Quokka(true);
        System.out.println(objQuokka1.toString());
        System.out.println("");
        Quokka objQuokka2 = new Quokka(false);
        System.out.println(objQuokka2.toString());
    }

    /**
     * Method that tests setBabyCounted() method of a Quokka class.
     */
    public void testSetBabyCounted()
    {
        Quokka objQuokka1 = new Quokka();
        objQuokka1.setBabyCounted(true);
        System.out.println("Test setBabyCounted() with valid values.");
        System.out.println("babyCounted: " + objQuokka1.getBabyCounted());
        System.out.println("");
        Quokka objQuokka2 = new Quokka();
        objQuokka2.setBabyCounted(true);
        objQuokka2.setBabyCounted(false);
        System.out.println("Test setBabyCounted() with invalid values.");
        System.out.println("babyCounted: " + objQuokka2.getBabyCounted());
    }

    /**
     * Method that tests setConsecutiveDaysNotEaten() method of a Quokka class.
     */
    public void testSetConsecutiveDaysNotEaten()
    {
        Quokka objQuokka1 = new Quokka();
        objQuokka1.setConsecutiveDaysNotEaten(0);
        System.out.println("Test setConsecutiveDaysNotEaten() with valid" +
            " values.");
        System.out.println("consecutiveDaysNotEaten: " +
            objQuokka1.getConsecutiveDaysNotEaten());
        System.out.println("");
        Quokka objQuokka2 = new Quokka();
        objQuokka2.setConsecutiveDaysNotEaten(-1);
        System.out.println("Test setConsecutiveDaysNotEaten() with invalid" +
            " values.");
        System.out.println("consecutiveDaysNotEaten: " +
            objQuokka2.getConsecutiveDaysNotEaten());
    }

    /**
     * Method that tests setDaysNotEaten() method of a Quokka class.
     */
    public void testSetDaysNotEaten()
    {
        Quokka objQuokka1 = new Quokka();
        objQuokka1.setDaysNotEaten(0);
        System.out.println("Test setDaysNotEaten() with valid values.");
        System.out.println("daysNotEaten: " + objQuokka1.getDaysNotEaten());
        System.out.println("");
        Quokka objQuokka2 = new Quokka();
        objQuokka2.setDaysNotEaten(-1);
        System.out.println("Test setDaysNotEaten() with invalid values.");
        System.out.println("daysNotEaten: " + objQuokka2.getDaysNotEaten());
    }

    /**
     * Method that tests setFoodSupply() method of a Quokka class.
     */
    public void testSetFoodSupply()
    {
        Quokka objQuokka1 = new Quokka();
        objQuokka1.setFoodSupply(0);
        System.out.println("Test setFoodSupply() with valid values.");
        System.out.println("foodSupply: " + objQuokka1.getFoodSupply());
        System.out.println("");
        Quokka objQuokka2 = new Quokka();
        objQuokka2.setFoodSupply(-1);
        System.out.println("Test setFoodSupply() with invalid values.");
        System.out.println("foodSupply: " + objQuokka2.getFoodSupply());
    }

    /**
     * Method that tests setHasBaby() method of a Quokka class.
     */
    public void testSetHasBaby()
    {
        Quokka objQuokka1 = new Quokka();
        objQuokka1.setHasBaby(true);
        System.out.println("Test setHasBaby() with valid values.");
        System.out.println("hasBaby: " + objQuokka1.getHasBaby());
        System.out.println("");
        Quokka objQuokka2 = new Quokka();
        objQuokka2.setHasBaby(true);
        objQuokka2.setHasBaby(false);
        System.out.println("Test setHasBaby() with invalid values.");
        System.out.println("hasBaby: " + objQuokka2.getHasBaby());
    }

    /**
     * Method that tests setId() method of a Quokka class.
     */
    public void testSetId()
    {
        Quokka objQuokka1 = new Quokka();
        objQuokka1.setId("1");
        System.out.println("Test setId() with valid values.");
        System.out.println("id: " + objQuokka1.getId());
        System.out.println("");
        Quokka objQuokka2 = new Quokka();
        objQuokka2.setId("-1");
        System.out.println("Test setId() with invalid values.");
        System.out.println("id: " + objQuokka2.getId());
    }

    /**
     * Method that tests setIsAlive() method of a Quokka class.
     */
    public void testSetIsAlive()
    {
        Quokka objQuokka1 = new Quokka();
        objQuokka1.setIsAlive(false);
        System.out.println("Test setIsAlive() with valid values.");
        System.out.println("isAlive: " + objQuokka1.getIsAlive());
        System.out.println("");
        Quokka objQuokka2 = new Quokka();
        objQuokka2.setIsAlive(false);
        objQuokka2.setIsAlive(true);
        System.out.println("Test setIsAlive() with invalid values.");
        System.out.println("isAlive: " + objQuokka2.getIsAlive());
    }

    /**
     * Method that tests toString() method of a Quokka class.
     */
    public void testToString()
    {
        Quokka objQuokka1 = new Quokka();
        System.out.println("Test toString().");
        System.out.println(objQuokka1.toString());
    }
}
