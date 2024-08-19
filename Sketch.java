/**
* This class stores the attributes and behaviours of sketches.
*
* @author Vincent
* @version ver1.0.0
*/
public class Sketch extends Selfie
{
    private int poseLength;

    /**
     * Default constructor which creates the object of the class Sketch.
     */
    public Sketch()
    {
        super();
        this.poseLength = 5;
    }

    /**
     * Non-default constructor which creates the object of the class Sketch.
     * 
     * @param poseLength        Accepts the length of a sketch pose as an
     *                          integer.
     */
    public Sketch(int poseLength)
    {
        super();
        this.poseLength = poseLength;
        if (poseLength == 5)
        {
            setTouristPayment(6);
        }
        else if (poseLength == 10)
        {
            setTouristPayment(10);
        }
    }

    /**
     * Accessor method to get the length of a sketch pose.
     *
     * @return  The length of a sketch pose as an integer.
     */
    public int getPoseLength()
    {
        return this.poseLength;
    }

    /**
     * Mutator method to set the length of a sketch pose.
     *
     * @param poseLength    Accepts the length of a sketch pose as an
     *                      integer.         
     */
    public void setPoseLength(int poseLength)
    {
        this.poseLength = poseLength;
    }

    /**
     * Method to return the state of the Sketch object.
     *
     * @return  The state of the Sketch object as a String.
     */
    @Override
    public String toString()
    {
        return (super.toString() + "\nSketch Pose Length: " +
            this.getPoseLength());
    }
}
