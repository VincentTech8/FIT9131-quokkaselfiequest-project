/**
* This class stores the attributes and behaviours of videos.
*
* @author Vincent
* @version ver1.0.0
*/
public class Video extends Selfie
{
    private int videoLength;
    private String videoType;

    /**
     * Default constructor which creates the object of the class Video.
     */
    public Video()
    {
        super();
        this.videoLength = 1;
        this.videoType = "Individual";
    }

    /**
     * Non-default constructor which creates the object of the class Video.
     * 
     * @param videoLength       Accepts the length of a video as an integer.
     * @param videoType         Accepts the type of a video as an String.
     */
    public Video(int videoLength, String videoType)
    {
        super();
        this.videoLength = videoLength;
        this.videoType = videoType;
        if (videoType.equals("Individual"))
        {
            setTouristPayment(this.calculateIndividualPayment(videoLength));
        }
        else if (videoType.equals("Group"))
        {
            setTouristPayment(this.calculateGroupPayment(videoLength));
        }
    }

    /**
     * Method that calculates the group video payment.
     *
     * @param videoLength   Accepts the length of a group video as an integer.
     *
     * @return              The payment amount in terms of food bags as an
     *                      integer.
     */
    public int calculateGroupPayment(int videoLength)
    {
        if (Validation.isIntegerValueWithinRange(videoLength, 1, 20))
        {
            return 2;
        }
        else if (Validation.isIntegerValueWithinRange(videoLength, 21, 40))
        {
            return 4;
        }
        else if (Validation.isIntegerValueWithinRange(videoLength, 41, 60))
        {
            return 6;
        }
        return 0;
    }

    /**
     * Method that calculates the individual video payment.
     *
     * @param videoLength   Accepts the length of a individual video as an
     *                      integer.
     *
     * @return              The payment amount in terms of food bags as an
     *                      integer.
     */
    public int calculateIndividualPayment(int videoLength)
    {
        if (Validation.isIntegerValueWithinRange(videoLength, 1, 20))
        {
            return 1;
        }
        else if (Validation.isIntegerValueWithinRange(videoLength, 21, 40))
        {
            return 2;
        }
        else if (Validation.isIntegerValueWithinRange(videoLength, 41, 60))
        {
            return 3;
        }
        return 0;
    }

    /**
     * Accessor method to get the length of a video.
     *
     * @return  The length of a video as an integer.
     */
    public int getVideoLength()
    {
        return this.videoLength;
    }

    /**
     * Accessor method to get the type of a video.
     *
     * @return  The type of a video as a String.
     */
    public String getVideoType()
    {
        return this.videoType;
    }

    /**
     * Mutator method to set the length of a video.
     *
     * @param videoLength   Accepts the length of a video as an integer.                  
     */
    public void setVideoLength(int videoLength)
    {
        this.videoLength = videoLength;
    }

    /**
     * Mutator method to set the type of a video.
     *
     * @param videoType   Accepts the type of a video as a String.                    
     */
    public void setVideoType(String videoType)
    {
        this.videoType = videoType;
    }

    /**
     * Method to return the state of the Video object.
     *
     * @return  The state of the Video object as a String.
     */
    @Override
    public String toString()
    {
        return (super.toString() + "\nVideo Length: " + this.getVideoLength() +
            "\nVideo Type: " + this.getVideoType());
    }
}
