/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication3;

/**
 *
 * @author macuser
 */

/*Steve Anderson
 * Lab Assignment Chapter 7
 * Program 7.19
 * 4.10.16
 * This program lets a user pick a seat in either First Class or Economy for an
 * airline reservation.
 */
import java.util.Scanner;
public class Airline {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //initialize boolean array to hold seat data
        boolean[] plane = new boolean[10];

        //variables to control loops and user choice
        int flag = 0;
        int another;

        Scanner input2 = new Scanner(System.in);
        System.out.print("Do you want to book another seat? Enter 0 for yes or -1 to quit: ");
        another = input2.nextInt();
        
        while (another != -1){

            //this loop lets user make choices until ready to exit program
            Scanner input = new Scanner(System.in);
            System.out.print("Enter choice 1 for First class, 2 for Economy: ");
            int choice = input.nextInt();

            //monitor feedback
            //System.out.printf("You have chosen %d%n", choice);
            

            //calls method depending on user choice of economy or first class
            if (choice == 1)
                flag = firstArray(plane);
            else
                flag = economyArray(plane);

            //both methods return a sentinel variable to indicate if a section is full
            //First class is full
            if (flag == 1){
                Scanner input3 = new Scanner(System.in);
                System.out.print("That section is full. Is it acceptable to book in Economy? Enter 1 for yes, 2 for no: ");
                int alt = input3.nextInt();

                //user chooses other section or not
                if (alt == 1)
                    economyArray(plane);
                else
                    System.out.println("Next flight leaves in 3 hours.");
            }

            //Economy is full
            if (flag == 2){
                Scanner input4 = new Scanner(System.in);
                System.out.print("That section is full. Would you like to try First Class? Enter 1 for yes, 2 for no: ");
                int alt1 = input4.nextInt();

                if (alt1 == 1)
                    firstArray(plane);
                else System.out.println("Next flight leaves in 3 hours.");
            }
            //I left this in the code to monitor the status of each section.
        //display plane[]
            int counter = 0;
            int seat = 1;
            System.out.printf("%s%10s%10s%n", "Array Index", "Seat #", "Value");
            for (boolean row : plane){
            
                System.out.printf("%d%20d%10b%n", counter, seat, row);
                    counter++;
                    seat++;}
            
            Scanner input3 = new Scanner(System.in);
            System.out.print("Do you want to book another seat? Enter 0 for yes or -1 to quit: ");
            another = input3.nextInt();
        }
   

    }

    public static int firstArray(boolean[] a)
        {//this method selects the next available seat in First Class

            int full = 0;
            int seat;
            for (int cnt = 0; cnt < (a.length/2); cnt++)
            {//loop

                if (a[cnt] == false)
                {//if
                    a[cnt] = true;
                    seat = cnt + 1;

                    //verifies the seat reservation and section
                    System.out.println("*******Boarding Pass***********");
                    System.out.println("You are booked in First Class");
                    System.out.printf("%s%d%n", "Seat: ", seat);
                    break;
                }
                // If all the seats are full, method returns a flag to user
                if (a[4] == true){
                    System.out.println("First Class is full");
                    full = 1;
                    break;
                    
                }
            }//close loop
            
            return full;
        }//close method firstArray

    public static int economyArray(boolean[] a)
        {//this method selects the next available seat in Economy Class
            int full = 0;
            int seat;
            for (int cnt = 5; cnt < a.length; cnt++)
            {//loop

                if (a[cnt] == false)
                {//if
                    a[cnt] = true;
                    seat = cnt + 1;
                    
                    //verifies the seat reservation and section
                    System.out.println("*******Boarding Pass***********");
                    System.out.println("You are booked in Economy Class");
                    System.out.printf("%s%d%n", "Seat: ", seat);
                    break;
                }
                // If all the seats are full, method returns a flag to user

                if (a[9] == true){
                    System.out.println("Economy is full");
                    full = 2;
                    break;
                }
            }//close loop
            
            return full;
        }//close method economyArray

    // TODO code application logic here
    

}//end Airline.java
