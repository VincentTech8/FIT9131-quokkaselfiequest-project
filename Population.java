import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
* This class stores the attributes and behaviours of populations.
*
* @author Vincent
* @version ver1.0.0
*/
public class Population
{
    private ArrayList<Quokka> quokkas;
    private TouristGroup[] touristGroups;

    /**
     * Default constructor which creates the object of the class Population.
     */
    public Population()
    {
        this.quokkas = new ArrayList<Quokka>();
        this.touristGroups = new TouristGroup[0];
    }

    /**
     * Non-default constructor which creates the object of the class
     * Population.
     * 
     * @param quokkas           Accepts a collection of quokkas as an
     *                          ArrayList.
     * @param touristGroups     Accepts a collection of tourist groups as
     *                          an array.
     */
    public Population(ArrayList<Quokka> quokkas,
        TouristGroup[] touristGroups)
    {
        this.quokkas = quokkas;
        this.touristGroups = touristGroups;
    }

    /**
     * Method that calculates the alive quokkas in an ArrayList collection.
     *
     * @return  The number of alive quokkas as an integer.
     */
    public int calculateAliveQuokkas()
    {
        int counter = this.quokkas.size();
        for (Quokka quokka : this.quokkas)
        {
            if (quokka.getHasBaby())
            {
                counter += 1;
            }
        }
        return counter;
    }

    /**
     * Method that calculates the food supplies of the dead quokkas in an
     * ArrayList collection.
     *
     * @return  The number of food supplies of the dead quokkas as an integer.
     */
    public int calculateDeadFoodSupply()
    {
        int counter = 0;
        for (Quokka quokka : this.quokkas)
        {
            if (!quokka.getIsAlive())
            {
                counter += quokka.getFoodSupply();
            }
        }
        return counter;
    }

    /**
     * Method that calculates the dead quokkas in an array collection.
     *
     * @return  The number of dead quokkas as an integer.
     */
    public int calculateDeadQuokkas()
    {
        int counter = 0;
        for (Quokka quokka : this.quokkas)
        {
            if (!quokka.getIsAlive())
            {
                if (quokka.getHasBaby())
                {
                    counter += 2;
                }
                else if (!quokka.getHasBaby())
                {
                    counter += 1;
                }
            }
        }
        return counter;
    }

    /**
     * Method that calculates the food supplies of the quokkas in an ArrayList
     * collection.
     *
     * @return  The number of food supplies of the quokkas as an integer.
     */
    public int calculateFoodSupplies()
    {
        int counter = 0;
        for (Quokka quokka : this.quokkas)
        {
            counter += quokka.getFoodSupply();
        }
        return counter;
    }

    /**
     * Method that calculates the new quokka babies in one simulation day.
     *
     * @return  The number of new babies in one simulation day as an integer.
     */
    public int calculateNewBabies()
    {
        int counter = 0;
        for (Quokka quokka: this.quokkas)
        {
            if (quokka.getHasBaby() && !quokka.getBabyCounted())
            {
                quokka.setBabyCounted(true);
                counter += 1;
            }
        }
        return counter;
    }

    /**
     * Method that calculates the selfie statistics.
     *
     * @return  The calculated selfie statistics as an integer array.
     */
    public int[] calculateSelfieStatistics()
    {
        int individualPhoto = 0;
        int groupPhoto = 0;
        int individualVideo = 0;
        int groupVideo = 0;
        int individualSketch = 0;
        for (TouristGroup group : this.touristGroups)
        {
            if (group.getSelfieType() instanceof Photo)
            {
                if (group.getGroupSize() == 1)
                {
                    individualPhoto += 1;
                }
                else if (group.getGroupSize() > 1)
                {
                    groupPhoto += 1;
                }
            }
            else if (group.getSelfieType() instanceof Video)
            {
                if (group.getGroupSize() == 1)
                {
                    individualVideo += 1;
                }
                else if (group.getGroupSize() > 1)
                {
                    groupVideo += 1;
                }
            }
            else if (group.getSelfieType() instanceof Sketch)
            {
                individualSketch += 1;
            }
        }
        int totalSelfie = (individualPhoto + groupPhoto + individualVideo +
            groupVideo + individualSketch);
        int[] selfieStatistics = { individualPhoto, groupPhoto,
            individualVideo, groupVideo, individualSketch, totalSelfie };
        return selfieStatistics;
    }

    /**
     * Method that categorizes the group size of a tourist group.
     *
     * @param groupSize     The group size of a tourist group as an integer.
     *
     * @return              The categorized result based on the tourist group
     *                      size as a String.
     */
    public String categorizeGroupSize(int groupSize)
    {
        if (groupSize == 1)
        {
            return "Individual";
        }
        else
        {
            return "Group";
        }
    }

    /**
     * Method that determines the group size of a tourist group.
     *
     * @return  The group size of a tourist group as an integer.
     */
    public int determineGroupSize()
    {
        RandomNumberGenerator objRNG = new RandomNumberGenerator();
        int outcome = objRNG.generateRandomNumberInteger(1, 100);
        if (Validation.isIntegerValueWithinRange(outcome, 1, 30))
        {
            return 1;
        }
        else if (Validation.isIntegerValueWithinRange(outcome, 31, 60))
        {
            return 2;
        }
        else if (Validation.isIntegerValueWithinRange(outcome, 61, 70))
        {
            return 3;
        }
        else if (Validation.isIntegerValueWithinRange(outcome, 71, 80))
        {
            return 4;
        }
        else if (Validation.isIntegerValueWithinRange(outcome, 81, 90))
        {
            return 5;
        }
        else
        {
            return 6;
        }
    }

    /**
     * Method that determines the selfie type of a tourist group.
     *
     * @return  The selfie type of a tourist group as a Selfie object.
     */
    public Selfie determineSelfieType()
    {
        RandomNumberGenerator objRNG = new RandomNumberGenerator();
        int outcome = objRNG.generateRandomNumberInteger(1, 100);
        if (Validation.isIntegerValueWithinRange(outcome, 1, 60))
        {
            return new Photo();
        }
        else if (Validation.isIntegerValueWithinRange(outcome, 61, 95))
        {
            return new Video();
        }
        else
        {
            return new Sketch();
        }
    }

    /**
     * Method that determines the sketch pose length.
     *
     * @return  The sketch pose length as an integer.
     */
    public int determineSketchLength()
    {
        RandomNumberGenerator objRNG = new RandomNumberGenerator();
        int outcome = objRNG.generateRandomNumberInteger(1, 2);
        if (outcome == 1)
        {
            return 5;
        }
        else
        {
            return 10;
        }
    }

    /**
     * Method that displays the state of the Population object.
     */
    public void display()
    {
        for (int i = 0; i < this.quokkas.size(); i++)
        {
            if (this.quokkas.get(i) != null)
            {
                System.out.println(this.quokkas.get(i).toString());
                System.out.println();
            }
        }
        for (int i = 0; i < this.touristGroups.length; i++)
        {
            if (this.touristGroups[i] != null)
            {
                System.out.println(this.touristGroups[i].toString());
                System.out.println();
            }
        }
    }

    /**
     * Accessor method to get the collection of quokkas.
     *
     * @return  The collection of quokkas as an ArrayList.
     */
    public ArrayList<Quokka> getQuokkas()
    {
        return this.quokkas;
    }

    /**
     * Accessor method to get the collection of tourist groups.
     *
     * @return  The collection of tourist groups as an array.
     */
    public TouristGroup[] getTouristGroups()
    {
        return this.touristGroups;
    }

    /**
     * Method that removes the dead quokkas from the ArrayList collection.
     */
    public void removeDeadQuokkas()
    {
        Iterator<Quokka> it = this.quokkas.iterator();
        while (it.hasNext())
        {
            Quokka quokka = it.next();
            if (!quokka.getIsAlive())
            {
                it.remove();
            }
        } 
    }

    /**
     * Mutator method to set the collection of quokkas.
     *
     * @param quokkas      Accepts the collection of quokkas as an ArrayList.
     */
    public void setQuokkas(ArrayList<Quokka> quokkas)
    {
        this.quokkas = quokkas;
    }

    /**
     * Mutator method to set the collection of tourist groups.
     *
     * @param touristGroups      Accepts the collection of tourist groups as an
     *                           array.
     */
    public void setTouristGroups(TouristGroup[] touristGroups)
    {
        this.touristGroups = touristGroups;
    }

    /**
     * Method that sets up the quokka population.
     *
     * @param quokkaNumber    Accepts the number of quokkas as an integer.
     */
    public void setUpQuokkaPopulation(int quokkaNumber)
    {
        RandomNumberGenerator objRNG = new RandomNumberGenerator();
        for (int i = 0; i < quokkaNumber; i++)
        {
            int babyOutcome = objRNG.generateRandomNumberInteger(1, 100);
            if (Validation.isIntegerValueWithinRange(babyOutcome, 1, 20))
            {
                Quokka newQuokka = new Quokka(true);
                this.quokkas.add(newQuokka);
            }
            else
            {
                Quokka newQuokka = new Quokka(false);
                this.quokkas.add(newQuokka);
            }
        }
    }

    /**
     * Method that sets up the tourist group population.
     *
     * @param groupNumber    Accepts the number of tourist groups as an
     *                       integer.
     */
    public void setUpTouristGroup(int groupNumber)
    {
        TouristGroup[] tempGroups = new TouristGroup[groupNumber];
        for (int i = 0; i < tempGroups.length; i++)
        {
            int tempGroupSize = this.determineGroupSize();
            Selfie tempSelfie = this.determineSelfieType();
            while (tempGroupSize > 1 && (tempSelfie instanceof Sketch))
            {
                tempGroupSize = this.determineGroupSize();
                tempSelfie = this.determineSelfieType();
            }
            String groupSizeType = this.categorizeGroupSize(tempGroupSize);
            if (tempSelfie instanceof Photo)
            {
                Photo objPhoto = new Photo(groupSizeType);
                TouristGroup group = new TouristGroup(tempGroupSize, objPhoto);
                tempGroups[i] = group;
            }
            else if (tempSelfie instanceof Video)
            {
                RandomNumberGenerator objRNG = new RandomNumberGenerator();
                int outcome = objRNG.generateRandomNumberInteger(1, 60);
                Video objVideo = new Video(outcome, groupSizeType);
                TouristGroup group = new TouristGroup(tempGroupSize, objVideo);
                tempGroups[i] = group;
            }
            else if (tempSelfie instanceof Sketch)
            {
                Sketch objSketch = new Sketch(this.determineSketchLength());
                TouristGroup group = new TouristGroup(tempGroupSize, 
                    objSketch);
                tempGroups[i] = group;
            }
        }
        this.setTouristGroups(tempGroups);
    }

    /**
     * Method that simulates the daily birth of a quokka during simulation.
     */
    public void simulateDailyBirth()
    {
        for (Quokka quokka : this.quokkas)
        {
            RandomNumberGenerator objRNG = new RandomNumberGenerator();
            int outcome = objRNG.generateRandomNumberInteger(1, 100);
            if (Validation.isIntegerValueWithinRange(outcome, 1, 5))
            {
                quokka.setHasBaby(true);
            }
        }
    }

    /**
     * Method that simulates the death of quokkas during simulation.
     */
    public void simulateQuokkaDeath()
    {
        for (Quokka quokka : this.quokkas)
        {
            if (quokka.getConsecutiveDaysNotEaten() == 2)
            {
                quokka.setIsAlive(false);
            }
            else if (quokka.getDaysNotEaten() == 5)
            {
                quokka.setIsAlive(false);
            }
        }
    }

    /**
     * Method that simulates the eating process of quokkas during simulation.
     *
     * @return  The total consumed food bags each day during simulation as an
     *          integer.
     */
    public int simulateQuokkaEat()
    {
        int counter = 0;
        for (Quokka quokka : this.quokkas)
        {
            if (quokka.getHasBaby() && quokka.getFoodSupply() > 2)
            {
                quokka.decrementFoodSupply(3);
                quokka.setConsecutiveDaysNotEaten(0);
                counter += 3;
            }
            else if (!quokka.getHasBaby() && quokka.getFoodSupply() > 1)
            {
                quokka.decrementFoodSupply(2);
                quokka.setConsecutiveDaysNotEaten(0);
                counter += 2;
            }
            else if (quokka.getHasBaby() && quokka.getFoodSupply() < 3)
            {
                quokka.incrementDaysNotEaten();
                quokka.incrementConsecutiveDaysNotEaten();
            }
            else if (!quokka.getHasBaby() && quokka.getFoodSupply() < 2)
            {
                quokka.incrementDaysNotEaten();
                quokka.incrementConsecutiveDaysNotEaten();
            }
        }
        return counter;
    }

    /**
     * Method that simulates the payment process of quokkas after taking selfie
     * during simulation.
     *
     * @return  The total food bags earned by quokkas each day during
     *          simulation.
     */
    public int simulateQuokkaPayment()
    {
        int earnedFoodCounter = 0;
        for (int i = 0; i < touristGroups.length; i++)
        {
            if (quokkas.get(i % quokkas.size()).getHasBaby() == true)
            {
                int food = 
                    (touristGroups[i].getSelfieType().getTouristPayment() * 2);
                quokkas.get(i % quokkas.size()).incrementFoodSupply(food);
                earnedFoodCounter += food;
                touristGroups[i].setHasSelfie(false);
            }
            else if (quokkas.get(i % quokkas.size()).getHasBaby() == false)
            {
                int food = 
                    touristGroups[i].getSelfieType().getTouristPayment();
                quokkas.get(i % quokkas.size()).incrementFoodSupply(food);
                earnedFoodCounter += food;
                touristGroups[i].setHasSelfie(false);
            }
        }
        return earnedFoodCounter;
    }

    /**
     * Method that sorts the collection of quokkas in a Population object from
     * lowest food supply to highest food supply.
     */
    public void sortHungryQuokka()
    {
        // Bubble Sort algorithm
        for (int i = 0; i < this.quokkas.size(); i++)
        {
            for (int j = i + 1; j < this.quokkas.size(); j++)
            {
                Quokka temp = this.quokkas.get(i);
                if (this.quokkas.get(j).getFoodSupply() < 
                    this.quokkas.get(i).getFoodSupply())
                {
                    temp = this.quokkas.get(i);
                    this.quokkas.set(i, this.quokkas.get(j));
                    this.quokkas.set(j, temp);
                }
            }
        }
    }
}
