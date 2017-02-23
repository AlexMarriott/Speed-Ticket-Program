import java.io.*;
import java.util.Scanner;

/**
 * Created by alex on 19/02/2017.
 */
public class IDGenAndSearch {
    int count = 0;

    public int Search() throws FileNotFoundException {
        File myFile = new File("Drivers.txt");
        Scanner fileScan = new Scanner(myFile);
        while(fileScan.hasNext()){
            while (fileScan.hasNextLine()) {
                String nextToken = fileScan.next();
                if (nextToken.equalsIgnoreCase("ID")){
                    System.out.println(nextToken.lastIndexOf("ID"));
                    count++;
                }

                }
        }
        System.out.println(count);
        return count;

    }

    public static void main(String[] args) throws FileNotFoundException {
        IDGenAndSearch test = new IDGenAndSearch();
        test.Search();
    }
}
//http://stackoverflow.com/questions/13029922/find-specific-word-in-text-file-and-count-it
