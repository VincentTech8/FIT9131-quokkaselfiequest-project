import java.io.*;
import java.util.*;

/**
* This class provides methods to read and write text files.
*
* @author Vincent
* @version ver1.0.0
*/
public class FileIO
{
    public static final String FILE_NAME_READ = "tourist.txt";
    public static final String FILE_NAME_WRITE = "populationFinal.txt";

    /**
     * Default constructor which creates the object of the class FileIO.
     */
    public FileIO()
    {

    }

    /**
     * Method that parses each line in the tourist.txt file.
     *
     * @param line  Each line in the tourist.txt file.
     *
     * @return      The list of 30 integers as an Array.
     */
    public int[] parseTouristLine(String line)
    {
        if (line == null)
        {
            return null;
        }
        line = line.trim();
        String[] items = line.split(",");
        int[] touristGroupNumberEachDayList = new int[30];
        for (int i = 0; i < items.length; i++)
        {
            try
            {
                touristGroupNumberEachDayList[i] = Integer.parseInt(items[i]);
            }
            catch (NumberFormatException e)
            {
                System.out.println("Error parsing integer at index " 
                    + i + ": " + items[i]);
            }
        }
        return touristGroupNumberEachDayList;
    }

    /**
     * Method that reads the tourist.txt file.
     *
     * @return  The list of 30 integers as an array.
     */
    public int[] readTouristFile()
    {
        int[] touristGroupNumberEachDayList = new int[30];
        Scanner scanner = null;
        try
        {
            FileReader reader = new FileReader(FILE_NAME_READ);
            scanner = new Scanner(reader);
            while (scanner.hasNext())
            {
                String line = scanner.nextLine();
                touristGroupNumberEachDayList = this.parseTouristLine(line);
            }
        }
        catch (IOException e)
        {
            System.out.println("Failed to read file: " + e);
        }
        finally
        {
            if (scanner != null)
            {
                scanner.close();
            }
        }
        return touristGroupNumberEachDayList;
    }

    /**
     * Method that writes the populationFinal.txt file.
     *
     * @param aliveQuokkaWithBabies     Total number of quokkas that are still
     *                                  alive including babies at the end of 
     *                                  the 30-days simulation as an integer.
     * @param newBornBabies             The summary of total new born babies
     *                                  during the 30-days simulation as an
     *                                  integer.
     * @param deadQuokkas               The summary of total dead quokkas
     *                                  including babies during the 30-days
     *                                  simulation as an integer.
     * @param totalFoodBags             The total current food supply at the
     *                                  end of the 30-days simulation as an
     *                                  integer.
     */
    public void writePopulationFinalFile(int aliveQuokkaWithBabies, 
        int newBornBabies, int deadQuokkas, int totalFoodBags)
    {
        PrintWriter writer = null;
        try
        {
            writer = new PrintWriter(FILE_NAME_WRITE);
            String line = aliveQuokkaWithBabies + "," + newBornBabies 
                + "," + deadQuokkas + "," + totalFoodBags;
            writer.println(line);
        }
        catch (IOException e)
        {
            System.out.println("Failed to write file: " + e);
        }
        finally
        {
            if (writer != null)
            {
                writer.close();
            }
        }
    }
}
