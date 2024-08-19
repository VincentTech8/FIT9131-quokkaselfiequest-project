import java.util.Arrays;
import java.util.Scanner;

/**
* This class manages the simulation of the quokka selfie quest.
*
* @author Vincent
* @version ver1.0.0
*/
public class QuokkaSelfieQuest
{
    private int[] groupNumberEachDayList;
    private int quokkaNumber;

    /**
     * Default constructor which creates the object of the class
     * QuokkaSelfieQuest.
     */
    public QuokkaSelfieQuest()
    {
        this.groupNumberEachDayList = new int[30];
        this.quokkaNumber = 1;
    }

    /**
     * Non-default constructor which creates the object of the class
     * QuokkaSelfieQuest.
     * 
     * @param groupNumberEachDayList    Accepts a collection of tourist group
     *                                  numbers for 30 days simulation as an
     *                                  array.
     * @param quokkaNumber              Accepts the number of quokkas to
     *                                  simulate as an integer.
     */
    public QuokkaSelfieQuest(int[] groupNumberEachDayList, int quokkaNumber)
    {
        this.groupNumberEachDayList = groupNumberEachDayList;
        this.quokkaNumber = quokkaNumber;
    }

    /**
     * Method that calculates the quokka population sustainability factor.
     *
     * @param totalQuokkasAtStart     The total number of quokkas at the start
     *                                of a simulation as a double.
     * @param totalQuokkasAtEnd       The total number of quokkas at the end
     *                                of a simulation as a double.
     *
     * @return                        The quokka population sustainability
     *                                factor as an integer.
     */
    public double calculateQPSF(double totalQuokkasAtStart,
        double totalQuokkasAtEnd)
    {
        double result = 
            ((totalQuokkasAtEnd - totalQuokkasAtStart) / totalQuokkasAtStart);
        double roundedresult = Math.round(result * 100.0) / 100.0;
        return roundedresult;
    }

    /**
     * Method that calculates the quokka selfie quest success factor.
     *
     * @param totalQuokkaDeaths       The total quokka deaths after simulation
     *                                as a double.
     * @param totalQuokkasAtStart     The total number of quokkas at the start
     *                                of a simulation as a double.
     *
     * @return                        The quokka selfie quest success factor
     *                                as an integer.
     */
    public double calculateQSQSF(double totalQuokkaDeaths,
        double totalQuokkasAtStart)
    {
        double result = (1 - (totalQuokkaDeaths / totalQuokkasAtStart)) * 100;
        double roundedresult = Math.round(result * 100.0) / 100.0;
        return roundedresult;
    }

    /**
     * Method that displays the state of the QuokkaSelfieQuest object.
     */
    public void display()
    {
        System.out.println("Group Number Each Day List: " +
            Arrays.toString(this.groupNumberEachDayList));
        System.out.println("Quokka Number: " + this.quokkaNumber);
    }

    /**
     * Method that initiates the daily simulation of Quokka Selfie Quest.
     *
     * @param objPopulation   The Population object.
     *
     * @return                An Array of integers contains the count of
     *                        30-days simulation results such as total dead
     *                        quokkas, total alive quokkas at day 30, number
     *                        of days that has at least one dead quokka, total
     *                        new babies, and total food supplies at day 30.
     */
    public int[] displayDailySimulation(Population objPopulation)
    {
        Scanner scanner = new Scanner(System.in);
        int deadFoodSupply = 0;
        int numberOfDaysWhereQuokkasDied = 0;
        int simulationNewBabies = 0;
        int simulationDeadQuokkas = 0;
        for (int i = 1; i < 31; i++)
        {
            System.out.println("\n*** Day #" + i + " ***");
            System.out.println("    Current alive quokkas (incl babies): " +
                objPopulation.calculateAliveQuokkas());
            System.out.println("    Current total food bags: " +
                objPopulation.calculateFoodSupplies());
            System.out.println("    Sorting the quokkas based on their level" +
                " of food supply...");
            objPopulation.sortHungryQuokka();
            System.out.println("    Number of tourist groups: " +
                this.groupNumberEachDayList[i - 1]);
            System.out.println("    Initialising the tourist groups...");
            objPopulation.setUpTouristGroup(groupNumberEachDayList[(i - 1)]);
            System.out.println("    Quokkas are now offering selfies to the" +
                " tourist groups...");
            int[] selfieStatistics = objPopulation.calculateSelfieStatistics();
            int dailyFood = objPopulation.simulateQuokkaPayment();
            this.displaySelfieStatistics(selfieStatistics, dailyFood);
            int consumedFood = objPopulation.simulateQuokkaEat();
            objPopulation.simulateQuokkaDeath();
            int deadQuokkas = objPopulation.calculateDeadQuokkas();
            if (deadQuokkas > 0)
            {
                simulationDeadQuokkas += deadQuokkas;
                numberOfDaysWhereQuokkasDied += 1;
            }
            deadFoodSupply += objPopulation.calculateDeadFoodSupply();
            objPopulation.removeDeadQuokkas();
            objPopulation.simulateDailyBirth();
            int newBabies = objPopulation.calculateNewBabies();
            simulationNewBabies += newBabies;
            this.displayDailySummary(objPopulation, deadQuokkas, newBabies,
                consumedFood, deadFoodSupply);
            if (i < 30)
            {
                System.out.print("\nPress enter to continue to the next" +
                    " day...");
                scanner.nextLine();
            }
            else if (i == 30)
            {
                System.out.print("\nPress enter to continue to the final" +
                    " simulation summary...");
                scanner.nextLine();
            }
        }
        int totalQuokkasAtEnd = objPopulation.calculateAliveQuokkas();
        int totalFoodbags = (deadFoodSupply +
            objPopulation.calculateFoodSupplies());
        int[] results = { simulationDeadQuokkas, totalQuokkasAtEnd,
            numberOfDaysWhereQuokkasDied, simulationNewBabies, totalFoodbags };
        return results;
    }

    /**
     * Method that displays the daily summary of Quokka Selfie Quest.
     *
     * @param objPopulation     The Population object.
     * @param deadQuokkas       The number of dead quokkas in a day as an
     *                          integer.
     * @param newBabies         The number of new babies in a day as an
     *                          integer.
     * @param consumedFood      The number of consumed food supplies in a day
     *                          as an integer.
     * @param deadFoodSupply    The number of food supplies from dead quokkas
     *                          in a day as an integer.
     */
    public void displayDailySummary(Population objPopulation, int deadQuokkas,
        int newBabies, int consumedFood, int deadFoodSupply)
    {
        System.out.println("\nDaily Summary");
        System.out.println("=============");
        System.out.println("Live Quokkas: " +
            objPopulation.calculateAliveQuokkas());
        System.out.println("Quokkas died today: " + deadQuokkas);
        System.out.println("New baby today: " + newBabies);
        System.out.println("Consumed food bags: " + consumedFood);
        System.out.println("Current food bags: " +
            objPopulation.calculateFoodSupplies());
        System.out.println("Excess food bags from dead quokkas: " +
            deadFoodSupply);
    }

    /**
     * Method that displays the final summary of Quokka Selfie Quest.
     *
     * @param results               The results returned from the
     *                              displayDailySimulation() method in a
     *                              QuokkaSelfieQuest class as an integer
     *                              array.
     * @param totalQuokkasAtStart   The total number of quokkas at the start of
     *                              a simulation as an integer.
     */
    public void displayFinalSummary(int[] results, int totalQuokkasAtStart)
    {
        System.out.println("\nFinal Simulation Summary");
        System.out.println("========================");
        System.out.println("QSQSF: " +
            this.calculateQSQSF(results[0], totalQuokkasAtStart));
        System.out.println("QPSF: " +
            this.calculateQPSF(totalQuokkasAtStart, results[1]));
        System.out.println("Day count for dead quokkas: " + results[2]);
    }

    /**
     * Method that displays the selfie statistics of Quokka Selfie Quest each
     * day.
     *
     * @param selfieStatistics  The results returned from the
     *                          calculateSelfieStatistics() method in a
     *                          Population class as an integer array.
     * @param dailyFood         The total number of daily food earned by
     *                          quokkas in a day of a simulation as an integer.
     */
    public void displaySelfieStatistics(int[] selfieStatistics, int dailyFood)
    {
        System.out.println("\nSelfie Statistics");
        System.out.println("=================");
        if (selfieStatistics[0] > 0)
        {
            System.out.println("Individual Photo: " + selfieStatistics[0]);
        }
        if (selfieStatistics[1] > 0)
        {
            System.out.println("Group Photo: " + selfieStatistics[1]);
        }
        if (selfieStatistics[2] > 0)
        {
            System.out.println("Individual Video: " + selfieStatistics[2]);
        }
        if (selfieStatistics[3] > 0)
        {
            System.out.println("Group Video: " + selfieStatistics[3]);
        }
        if (selfieStatistics[4] > 0)
        {
            System.out.println("Individual Sketch: " + selfieStatistics[4]);
        }
        System.out.println("(Total selfies: " + selfieStatistics[5] + ")");
        System.out.println("Earned Food Bags: " + dailyFood);
    }

    /**
     * Accessor method to get the collection of tourist group numbers for 30
     * days simulation.              
     *
     * @return  The collection of tourist group numbers for 30 days simulation
     *          as an array.
     */
    public int[] getGroupNumberEachDayList()
    {
        return groupNumberEachDayList;
    }

    /**
     * Accessor method to get the number of quokkas to simulate.
     *
     * @return  The number of quokkas to simulate as an integer.
     */
    public int getQuokkaNumber()
    {
        return this.quokkaNumber;
    }

    /**
     * Method that begin the program execution.
     *
     * @param args          An array of String passed in as command line
     *                      parameters.
     */
    public static void main(String[] args)
    {
        QuokkaSelfieQuest objQuokkaSelfieQuest = new QuokkaSelfieQuest();
        objQuokkaSelfieQuest.play();
    }

    /**
     * Method that initiates the entire simulation of Quokka Selfie Quest.
     */
    public void play()
    {
        this.readGroupNumberEachDayList();
        Population objPopulation = new Population();
        System.out.println("Welcome to the Quokka Selfie Simulation.\n");
        this.requestQuokkaNumber();
        System.out.println("\nSetting up the quokka population...");
        objPopulation.setUpQuokkaPopulation(this.quokkaNumber);
        int totalQuokkasAtStart = objPopulation.calculateAliveQuokkas();
        System.out.println("    New Babies: " +
            objPopulation.calculateNewBabies());
        System.out.println("\nSimulation Started");
        int[] results = this.displayDailySimulation(objPopulation);
        this.displayFinalSummary(results, totalQuokkasAtStart);
        this.writeFinalPopulationFile(results);
        System.out.println("\nGoodbye!");
    }

    /**
     * Method that reads the tourist.txt and store the contents to the
     * groupNameEachDayList field of this class.
     */
    public void readGroupNumberEachDayList()
    {
        FileIO objFileIO = new FileIO();
        this.groupNumberEachDayList = objFileIO.readTouristFile();
    }

    /**
     * Method that requests the number of quokkas to simulate to the user.
     */
    public void requestQuokkaNumber()
    {
        boolean flag = true;
        do
        {
            String userInput = Input.acceptStringInput("How many quokkas? ");
            if (!Validation.isOnlyInteger(userInput))
            {
                System.out.println("Invalid input. Please enter a number.");
            }
            else if (!Validation.isIntegerValueWithinRange(
                Integer.parseInt(userInput), 1, 999))
            {
                System.out.println("Invalid input. Number must be between 1" +
                    "and 999");
            }
            else
            {
                flag = false;
                this.quokkaNumber = Integer.parseInt(userInput);
            }
        } while (flag);
    }

    /**
     * Mutator method to set the collection of tourist group numbers for 30
     * days simulation.
     *
     * @param groupNumberEachDayList      Accepts the collection of tourist
     *                                    group numbers for 30 days simulation
     *                                    as an array.
     */
    public void setGroupNumberEachDayList(int[] groupNumberEachDayList)
    {
        this.groupNumberEachDayList = groupNumberEachDayList;
    }

    /**
     * Mutator method to set the number of quokkas to simulate.
     *
     * @param quokkaNumber      Accepts the number of quokkas to
     *                          simulate as an integer.
     */
    public void setQuokkaNumber(int quokkaNumber)
    {
        this.quokkaNumber = quokkaNumber;
    }

    /**
     * Method that displays and writes the simulation results to the
     * populationFinal.txt.
     *
     * @param results   The results returned from the displayDailySimulation()
     *                  method in a QuokkaSelfieQuest class as an integer
     *                  array.
     */
    public void writeFinalPopulationFile(int[] results)
    {
        FileIO objFileIO = new FileIO();
        System.out.println("\nWriting summary to populationFinal.txt");
        System.out.println("    Total alive quokkas include babies: " +
            results[1]);
        System.out.println("    Total new born babies: " + results[3]);
        System.out.println("    Total dead quokkas: " + results[0]);
        System.out.println("    Total food bags: " + results[4]);
        objFileIO.writePopulationFinalFile(results[1], results[3], results[0],
            results[4]);
    }
}
