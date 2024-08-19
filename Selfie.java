/**
* This class stores the attributes and behaviours of selfies.
*
* @author Vincent
* @version ver1.0.0
*/
public class Selfie
{
    private int touristPayment;

    /**
     * Default constructor which creates the object of the class Selfie.
     */
    public Selfie()
    {
        this.touristPayment = 0;
    }

    /**
     * Non-default constructor which creates the object of the class Selfie.
     * 
     * @param touristPayment    Accepts the amount of tourist payment as
     *                          an integer.
     */
    public Selfie(int touristPayment)
    {
        this.touristPayment = touristPayment;
    }

    /**
     * Accessor method to get the amount of tourist payment.
     *
     * @return  The amount of tourist payment as an integer.
     */
    public int getTouristPayment()
    {
        return this.touristPayment;
    }

    /**
     * Mutator method to set the amount of tourist payment.
     *
     * @param touristPayment    Accepts the amount of tourist payment as an
     *                          integer.
     */
    public void setTouristPayment(int touristPayment)
    {
        this.touristPayment = touristPayment;
    }

    /**
     * Method to return the state of the Selfie object.
     *
     * @return  The state of the Selfie object as a String.
     */
    public String toString()
    {
        return "Tourist Payment Amount: " + this.getTouristPayment();
    }
}
