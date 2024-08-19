/**
* This class stores the attributes and behaviours of quokkas.
*
* @author Vincent
* @version ver1.0.0
*/
public class Quokka
{
    private boolean babyCounted;
    private int daysNotEaten;
    private int consecutiveDaysNotEaten;
    private int foodSupply;
    private boolean hasBaby;
    private String id;
    private boolean isAlive;
    private static int nextId = 1;

    /**
     * Default constructor which creates the object of the class Quokka.
     */
    public Quokka()
    {
        this.babyCounted = false;
        this.daysNotEaten = 0;
        this.consecutiveDaysNotEaten = 0;
        this.foodSupply = 2;
        this.hasBaby = false;
        this.id = "Q" + String.format("%03d", nextId);
        nextId++;
        this.isAlive = true;
    }

    /**
     * Non-default constructor which creates the object of the class Quokka.
     * 
     * @param hasBaby   Accepts the baby existence status of the quokka as a
     *                  boolean.
     */
    public Quokka(boolean hasBaby)
    {
        this.babyCounted = false;
        this.daysNotEaten = 0;
        this.consecutiveDaysNotEaten = 0;
        if (hasBaby == true)
        {
            this.foodSupply = 3;
        }
        else
        {
            this.foodSupply = 2;
        }
        this.hasBaby = hasBaby;
        this.id = "Q" + String.format("%03d", nextId);
        nextId++;
        this.isAlive = true;
    }

    /**
     * Method that decrements the food supply of the quokka by a given amount
     * eaten.
     *
     * @param amountEaten    Accepts the amount of food supply eaten as an
     *                       integer.
     */
    public void decrementFoodSupply(int amountEaten)
    {
        if (amountEaten > 0)
        {
            this.foodSupply -= amountEaten;
        }
    }

    /**
     * Accessor method to get the status whether a new baby has been counted.
     *
     * @return  The status whether a new baby has been counted as a boolean.
     */
    public boolean getBabyCounted()
    {
        return this.babyCounted;
    }

    /**
     * Accessor method to get the number of consecutive days quokka has not
     * eaten.
     *
     * @return  The number of consecutive days quokka has not eaten as an
     *          integer.
     */
    public int getConsecutiveDaysNotEaten()
    {
        return this.consecutiveDaysNotEaten;
    }

    /**
     * Accessor method to get the number of days quokka has not eaten.
     *
     * @return  The number of days quokka has not eaten as an integer.
     */
    public int getDaysNotEaten()
    {
        return this.daysNotEaten;
    }

    /**
     * Accessor method to get the food supply of the quokka.
     *
     * @return  The food supply of the quokka as an integer.
     */
    public int getFoodSupply()
    {
        return this.foodSupply;
    }

    /**
     * Accessor method to get the baby existence status of the quokka.
     *
     * @return  The baby existence status of the quokka as a boolean.
     */
    public boolean getHasBaby()
    {
        return this.hasBaby;
    }

    /**
     * Accessor method to get the id of the quokka.
     *
     * @return  The id of the quokka as an integer.
     */
    public String getId()
    {
        return this.id;
    }

    /**
     * Accessor method to get the alive status of the quokka.
     *
     * @return  The alive status of the quokka as a boolean.
     */
    public boolean getIsAlive()
    {
        return this.isAlive;
    }

    /**
     * Method that increments the consecutive days not eaten by 1 everytime
     * its called.
     */
    public void incrementConsecutiveDaysNotEaten()
    {
        this.consecutiveDaysNotEaten += 1;
    }

    /**
     * Method that increments the days not eaten by 1 everytime its called.
     */
    public void incrementDaysNotEaten()
    {
        this.daysNotEaten += 1;
    }

    /**
     * Method that increments the food supply of the quokka by a given tourist
     * payment.
     *
     * @param touristPayment    Accepts the amount of tourist payment as an
     *                          integer.
     */
    public void incrementFoodSupply(int touristPayment)
    {
        if (touristPayment > 0)
        {
            this.foodSupply += touristPayment;
        }
    }

    /**
     * Mutator method to set the status whether a new baby has been counted.
     *
     * @param babyCounted      Accepts the status whether a new baby has been
     *                         counted as a boolean.
     */
    public void setBabyCounted(boolean babyCounted)
    {
        if (!this.babyCounted)
        {
            this.babyCounted = babyCounted;
        }
    }

    /**
     * Mutator method to set the number of days quokka has not eaten.
     *
     * @param consecutiveDaysNotEaten    Accepts the number of consecutive days
     *                                   quokka has not eaten as an integer.
     */
    public void setConsecutiveDaysNotEaten(int consecutiveDaysNotEaten)
    {
        if (consecutiveDaysNotEaten > 0)
        {
            this.consecutiveDaysNotEaten = consecutiveDaysNotEaten;
        }
        else
        {
            this.consecutiveDaysNotEaten = 0;
        }
    }

    /**
     * Mutator method to set the number of days quokka has not eaten.
     *
     * @param daysNotEaten      Accepts the number of days quokka has not eaten
     *                          as an integer.
     */
    public void setDaysNotEaten(int daysNotEaten)
    {
        if (daysNotEaten > 0)
        {
            this.daysNotEaten = daysNotEaten;
        }
        else
        {
            this.daysNotEaten = 0;
        }
    }

    /**
     * Mutator method to set the food supply of the quokka.
     *
     * @param foodSupply    Accepts the food supply of the quokka as an 
     *                      integer.
     */
    public void setFoodSupply(int foodSupply)
    {
        if (foodSupply > 0)
        {
            this.foodSupply = foodSupply;
        }
        else
        {
            this.foodSupply = 0;
        }
    }

    /**
     * Mutator method to set the baby existence status of the quokka.
     *
     * @param hasBaby   Accepts the baby existence status of the
     *                  quokka as a boolean.
     */
    public void setHasBaby(boolean hasBaby)
    {
        if (!this.hasBaby)
        {
            this.hasBaby = hasBaby;
        }
    }

    /**
     * Mutator method to set the id of the quokka.
     *
     * @param id    Accepts the id of the quokka as a String.
     */
    public void setId(String id)
    {
        if (Validation.isOnlyInteger(id) && !id.contains("-"))
        {
            this.id = "Q" + String.format("%03d", Integer.parseInt(id));
        }
        else
        {
            this.id = "Q" + String.format("%03d", nextId);
        }
    }

    /**
     * Mutator method to set the alive status of the quokka.
     *
     * @param isAlive   Accepts the alive status of the quokka as a
     *                  boolean.
     */
    public void setIsAlive(boolean isAlive)
    {
        if (this.isAlive)
        {
            this.isAlive = isAlive;
        }
    }

    /**
     * Method to return the state of the Quokka object.
     *
     * @return  The state of the Quokka object as a String.
     */
    public String toString()
    {
        return ("Quokka Id: " + this.getId() + "\nQuokka is Alive: " + 
            this.getIsAlive() + "\nQuokka Food Supply: " + this.getFoodSupply()
            + "\nQuokka has Baby: " + this.getHasBaby() +
            "\nNumber of Days Quokka has not Eaten: " + this.getDaysNotEaten()
            + "\nNumber of Consecutive Days Quokka has not Eaten: " +
            this.getConsecutiveDaysNotEaten() + "\nBaby has been Counted: " +
            this.getBabyCounted());
    }
}
