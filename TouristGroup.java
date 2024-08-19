/**
* This class stores the attributes and behaviours of tourist groups.
*
* @author Vincent
* @version ver1.0.0
*/
public class TouristGroup
{
    private int groupSize;
    private boolean hasSelfie;
    private Selfie selfieType;

    /**
     * Default constructor which creates the object of the class TouristGroup.
     */
    public TouristGroup()
    {
        this.groupSize = 1;
        this.hasSelfie = false;
        this.selfieType = new Selfie();
    }

    /**
     * Non-default constructor which creates the object of the class
     * TouristGroup.
     * 
     * @param groupSize     Accepts the size of a tourist group as an integer.
     * @param selfieType    Accepts the selfie type as a Selfie child class
     *                      object.
     */
    public TouristGroup(int groupSize, Selfie selfieType)
    {
        this.groupSize = groupSize;
        this.hasSelfie = false;
        this.selfieType = selfieType;
    }

    /**
     * Accessor method to get the size of a tourist group.
     *
     * @return  The size of a tourist group as an integer.
     */
    public int getGroupSize()
    {
        return this.groupSize;
    }

    /**
     * Accessor method to get the status of selfie taken.
     *
     * @return  The status of selfie taken as a boolean.
     */
    public boolean getHasSelfie()
    {
        return this.hasSelfie;
    }

    /**
     * Accessor method to get the selfie type.
     *
     * @return  The selfie type as a Selfie child class object.
     */
    public Selfie getSelfieType()
    {
        return this.selfieType;
    }

    /**
     * Mutator method to set the size of a tourist group.
     *
     * @param groupSize      Accepts the size of a tourist group as an integer.
     */
    public void setGroupSize(int groupSize)
    {
        this.groupSize = groupSize;
    }

    /**
     * Mutator method to set the status of selfie taken.
     *
     * @param hasSelfie      Accepts the status of selfie taken as a boolean.                 
     */
    public void setHasSelfie(boolean hasSelfie)
    {
        this.hasSelfie = hasSelfie;
    }

    /**
     * Mutator method to set the selfie type.
     *
     * @param selfieType     Accepts the selfie type as a Selfie child class
     *                       object.
     */
    public void setSelfieType(Selfie selfieType)
    {
        this.selfieType = selfieType;
    }

    /**
     * Method to return the state of the TouristGroup object.
     *
     * @return  The state of the TouristGroup object as a String.
     */
    public String toString()
    {
        return ("Group Size: " + this.getGroupSize() + "\nGroup has Selfie: " +
            this.getHasSelfie() + "\n" + this.selfieType.toString());
    }
}
