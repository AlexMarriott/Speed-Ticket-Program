import java.util.Scanner;

/**
 * @author Alex Marriott s4816928,
 * 30/10/2016.
 * Speeding Ticket - Upload 4 Task 1
 * The following code asks the user to input the speed limit and the speed they were going. It then compares the car speed to the speed limit and issues a ticket
 * and points depending on how much over the speed limt they were.
 */

public class GivingSpeedingTickets {
    public static void main(String[] args)  {

        //Creating Scanner and getting the user input for the variable "speedLimit"
        Scanner Speed = new Scanner(System.in);
        System.out.println("What Was The Speed Limit?");
        int speedLimit = Speed.nextInt();

        //Getting user input for the variable "carSpeed"
        System.out.println("What Was Your Speed?");
        int carSpeed = Speed.nextInt();

        //The following If statements compare the car speed to the speed limit and issue a fine and points depending how much over the speed limit the user is.
        if (carSpeed <= speedLimit){
            System.out.println("Under the speed limit - no fine.");
        }
        else if (carSpeed <= (speedLimit + 4)) {
            System.out.println("Over the speed limit – just – please be careful of your speed in future.");
        }
        else if (carSpeed <= (speedLimit + 9)) {
            System.out.println("5 miles or more over limit - fined £50");
        }
        else if (carSpeed <= (speedLimit + 14) ) {
            System.out.println("10 miles or more over limit - fined £100");
        }
        else if (carSpeed <= (speedLimit + 19 )){
            System.out.println("15 miles or more over limit - fined £150 and 3 points");
        }
        else if (carSpeed >= (speedLimit + 20 )){
            System.out.println("20 miles or more over limit - fined £1000 and disqualified");
        }
        Speed.close();
    }

}