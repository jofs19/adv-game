package advent;
import java.util.*;

public class GameMenu {


	    public static void main(String[] args) {

	        String password;
	        String user;
	        String nameP = "";

	        Scanner in = new Scanner(System.in);
	        boolean access = true;
	        ASK:

	        do {
	            System.out.println("-------------------------------------------");
	            System.out.println("Choose username in the given list: ");
	            System.out.println("===========================================\n");
	            System.out.println("> mr.lynxions\n> jofs19\n> eaferrer0225\n");
	            System.out.println("===========================================\n");
	            System.out.println("Enter username: ");
	            user = in.nextLine();
	            if (user.contentEquals("mr.lynxions")) {
	                System.out.print("Enter password: ");
	                password = in.nextLine();
	                if (password.contentEquals("june132001")) {
	                    System.out.println();
	                    try {
	                        for (int i = 1; i <= 6; i++) {
	                            Thread.sleep(100);
	                            System.out.print("\t");

	                            System.out.print(">>\t");
	                        }
	                    } catch (Exception e) {
	                        System.out.println(e);
	                    }

	                    System.out.println();
	                    System.out.println("\nAccess granted!\n\n");
	                    nameP = "Chaotic Legend";
	                    access = false;
	                    // display.game();

	                } else {
	                    System.out.println("Wrong password!\n");
	                    continue ASK;
	                }
	            } else if (user.contentEquals("jofs19")) {
	                System.out.println("Enter password: ");

	                password = in.nextLine();
	                if (password.contentEquals("persona4")) {
	                    System.out.println();
	                    try {
	                        for (int i = 1; i <= 6; i++) {
	                            Thread.sleep(100);
	                            System.out.print("");

	                            System.out.print(">>\t");
	                        }
	                    } catch (Exception e) {
	                        System.out.println(e);
	                    }

	                    System.out.println();
	                    System.out.println("\nAccess granted!\n\n");
	                    nameP = "Heartless Angel";
	                    access = false;
	                    // display.game();

	                } else {
	                    System.out.println("Wrong password!\n");
	                    continue ASK;
	                }

	            } else if (user.contentEquals("eaferrer0225")) {
	                System.out.println("Enter password: ");

	                password = in.nextLine();
	                if (password.contentEquals("ferrerfamily25")) {
	                    System.out.println();
	                    try {
	                        for (int i = 1; i <= 6; i++) {
	                            Thread.sleep(100);
	                            System.out.print("\t");

	                            System.out.print(">>\t");
	                        }
	                    } catch (Exception e) {
	                        System.out.println(e);
	                    }

	                    System.out.println();
	                    System.out.println("\nAccess granted!\n\n");
	                    nameP = "EaFerrer0225";
	                    access = false;
	                    // display.game();

	                } else {
	                    System.out.println("Wrong password!\n");
	                    continue ASK;
	                }

	            } else {

	                System.out.println("Invalid username\n");
	                continue ASK;

	            }

	        } while (access != false);

	        StartGame display = new StartGame(nameP);
	        // display.game();

	    }

	}

	

