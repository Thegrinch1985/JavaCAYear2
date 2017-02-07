/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import java.util.Calendar;
import java.util.Scanner;
import javaca.*;

/**
 *
 * @author Howie
 *
 */
public class Menu {

    static JPAService jpas = new JPAService();
//Displays Console Based User Interface

    public static void displayMenu() {

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("****************************************");
            System.out.println("Welcome To ITT Airline Service");
            System.out.println("Press 1 to View Plane Operators");
            System.out.println("Press 2 to Check Routes");
            System.out.println("Press 3 to Check Tickets");
            System.out.println("Press 4 to Check Passengers");
            System.out.println("Press 5 to get a price of a journey ");
            System.out.println("Press 6 to Quit");
            System.out.println("****************************************");
//Gives User Choice To view Datbase
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    jpas.displayPlaneOperators();
                    break;
                case 2:
                    jpas.displayPlaneRoutes();
                    break;
                case 3:

                    jpas.displayTickets();
                    break;
                case 4:
                    //Gives User Choice to view, Add, Updateand Remove from Database
                    System.out.println("*****************");
                    System.out.println("Press 1 to View Passenger Details");
                    System.out.println("Press 2 to add Passenger");
                    System.out.println("Press 3 to Update Passenger");
                    System.out.println("Press 4 to Remove Passenger");
                    System.out.println("Press 6 to go back to Menu");

                    int choice1 = input.nextInt();
                    input.nextLine();

                    switch (choice1) {

                        case 1:
                            jpas.displayPassengers();
                            break;

                        case 2:
                            //jpas.displayPassengers();

                            System.out.println("Please Enter the name of the Passenger you wish to add");
                            String nameAdd = input.nextLine();
                            System.out.println("Please enter Passenger Month In Numerice Form");
                            int month = input.nextInt();
                            System.out.println("Please enter Day Year they were born");
                            int day = input.nextInt();
                            System.out.println("Please enter Passenger Year they were born");
                            int year = input.nextInt();
                            Calendar dobAdd = Calendar.getInstance();
                            dobAdd.set(month, day, year);
                            jpas.addPassenger(nameAdd, dobAdd);
                            System.out.println("Passegger Added To DatabASE..........");

                            //jpas.displayPassengers();
                            break;
                        case 3:
                            System.out.println("Please Enter the id of the Passeneger you wish to update  ");
                            int id = input.nextInt();
                            System.out.println("Please enter the Passengers new name");
                            input.nextLine();
                            String name = input.nextLine();
                            jpas.updatePassenger(id, name);
                            System.out.println("Passenger Updated");
                            //jpas.displayPassengers();
                            break;
                        case 4:
                            System.out.println("Please Enter the id of the Passeneger you wish to delete");
                            int idDelete = input.nextInt();
                            input.nextLine();
                            //System.err.println("FIX THIS ");
                            jpas.deletePassenger(idDelete);
                            jpas.displayPassengers();
                            // System.out.println("Entity Removed.......");

                            //jpas.deletePassenger(choice1);
                            break;
                        case 5:
                            displayMenu();
                            break;

                    }
                    break;
                case 5:
                    System.out.println("Please Choose A Route You Wish To Purchase");
                    jpas.displayPlaneRoutes();
                    System.out.println("Press 1 To fly  Cork-Ibiza ");
                    System.out.println("Press 2 to fly Dublin-Thailand ");
                    System.out.println("Press 3 to fly  Dublin - Barcelona");
                    int choice2 = input.nextInt();
                    input.nextLine();

                    switch (choice2) {
                        case 1:
                            System.out.println("You have chosen Cork-Ibiza ");
                            
                            int num = 1;
                            if (num == 1) {
                                String a = "R861";
                                //jpas.getCost(a);
                                System.out.println("Please input the amount of passengers you wish to price for ");
                                int num1 = input.nextInt();
                                System.out.println("Price is : " +(jpas.getCost(a) * num1));
                            }

                           
                            displayMenu();
                            break;
                        case 2:
                              System.out.println("You have chosen Dublin-Thailand ");
                            
                            int num1 = 2;
                            if (num1 == 2) {
                                String a = "R149";
                                //jpas.getCost(a);
                                System.out.println("Please input the amount of passengers you wish to price for ");
                                int num2 = input.nextInt();
                                System.out.println("Price is : " +(jpas.getCost(a) * num2));
                            }
                             displayMenu();

                            break;
                        case 3:
                                 System.out.println("You have chosen Dublin-Thailand ");
                            
                            int num3 = 3;
                            if (num3 == 3) {
                                String a = "R012";
                                //jpas.getCost(a);
                                System.out.println("Please input the amount of passengers you wish to price for ");
                                int num33 = input.nextInt();
                                System.out.println("Price is : " +(jpas.getCost(a) * num33));
                            }
                             displayMenu();

                            break;

                    }

                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Entry ");
                    break;

            }

        }

    }

}
