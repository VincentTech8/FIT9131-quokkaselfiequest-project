/**
* This class stores the attributes and behaviours of photos.
*
* @author Vincent
* @version ver1.0.0
*/
public class Photo extends Selfie
{
    private String photoType;

    /**
     * Default constructor which creates the object of the class Photo.
     */
    public Photo()
    {
        super();
        this.photoType = "Individual";
    }

    /**
     * Non-default constructor which creates the object of the class Photo.
     * 
     * @param photoType     Accepts the type of a photo as a String.
     */
    public Photo(String photoType)
    {
        super();
        this.photoType = photoType;
        if (photoType.equals("Individual"))
        {
            setTouristPayment(1);
        }
        else if (photoType.equals("Group"))
        {
            setTouristPayment(2);
        }
    }

    /**
     * Accessor method to get the type of a photo.
     *
     * @return  The type of a photo as a String.
     */
    public String getPhotoType()
    {
        return this.photoType;
    }

    /**
     * Mutator method to set the type of a photo.
     *
     * @param photoType     Accepts the type of a photo as a String.
     */
    public void setPhotoType(String photoType)
    {
        this.photoType = photoType;
    }

    /**
     * Method to return the state of the Photo object.
     *
     * @return  The state of the Photo object as a String.
     */
    @Override
    public String toString()
    {
        return super.toString() + "\nPhoto Type: " + this.getPhotoType();
    }
}
