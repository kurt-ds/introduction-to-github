package com.mycompany.ticketingsystem;

import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
import java.lang.NumberFormatException;

public class TicketingSystem {
    static HashMap<String, String> map = new HashMap<>();     
    static Queue<String[]> database = new LinkedList<>();
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        
//        String[] input1 = {"123", "Kurt", "Programming", "1"};
//        String[] input2 = {"234", "Allen", "Loan", "2"};
//        String[] input3 = {"345", "Dave", "Basketball", "3"};
//        String[] input4 = {"456", "Lester", "Instagram", "1"};
//        String[] input5 = {"567", "Therese", "Marcelo", "2"};
//        String[] input6 = {"678", "Kian", "Creencia", "3"};
//        String[] input7 = {"789", "Kurt", "Villena", "1"};
//        String[] input8 = {"890", "Pete", "Fuentespina", "2"};
//        database.add(input1);
//        database.add(input2);
//        database.add(input3);
//        database.add(input4);
//        database.add(input5);
//        database.add(input6);
//        database.add(input7);
//        database.add(input8);
        
        map.put("1", "High");
        map.put("2", "Medium");
        map.put("3", "Low");
        
        boolean isOver = false;
        
        while(!isOver) {
            System.out.println("[1] Create a ticket");
            System.out.println("[2] Close a ticket");
            System.out.println("[3] Display open tickets");
            System.out.println("[4] Exit");
            System.out.print("Enter command: ");
            String in = sc.next();  
            if (in.equals("4")) isOver = true;
            else if (in.equals("1")){
                createTicket();
            } else if (in.equals("2")) {
                closeTicket();
            } else if (in.equals("3")) {
                displayTicket();
            } else {
                System.out.println("Invalid Input");
            }
        }
        
        System.out.println("Exiting the program!");
    }
    
    static void createTicket() {
        boolean isOver = false;
        String command;
        sc.nextLine();
        while (!isOver) {
            String[] input = new String[4];

            System.out.print("Enter ticket number: ");
            String ticket = sc.nextLine();
            input[0] = ticket;
            
            if(!isNumber(ticket)) {
                System.out.println("Ticket should be a number!");
                System.out.println("Creating ticket cancelled");
                continue;
            }
            
            if (!validateTicketNumber(ticket)) {
                System.out.println("Ticket has already been identified");
                System.out.println("Creating ticket cancelled");
                continue;
            }

            System.out.print("Enter customer name: ");
            String name = sc.nextLine();
            input[1] = name;
            
            if (name.equals("")) {
                System.out.println("Name should not be empty!");
                System.out.println("Creating ticket cancelled");
                continue;
            }

            
            
            System.out.print("Enter ticket details: ");
            input[2] = sc.nextLine();
            
            if (input[2].equals("")) {
                System.out.println("Ticket Details should not be empty!");
                System.out.println("Creating ticket cancelled");
                continue;
            }
            

            System.out.print("Enter severity (1 - High, 2 - Medium, 3 - Low): ");
            input[3] = sc.nextLine();
            if (!input[3].equals("1") && !input[3].equals("2") && !input[3].equals("3")) {
                System.out.println("Severity should only be 1, 2 or 3.");
                System.out.println("Creating ticket cancelled");
                continue;
            }
            
          
            database.offer(input);
            
            System.out.print("Do you want to create another ticket [Y/N]?: ");
            command = sc.next();
            
            if (command.equals("N") || command.equals("n")) {
                isOver = true;
            } else if (command.equals("Y") || command.equals("y")) {
                sc.nextLine();
                continue;
            } else {
                System.out.println("Invalid input!");
                isOver = true;
            }
        }
    }
    
    static void closeTicket() {
        if (database.isEmpty()) {
            System.out.println("The database is empty!");
            return;
        }
        sc.nextLine();
        System.out.print("Enter ticket number: ");
        String ticketNo = sc.nextLine();
        String[] base = database.peek();
            if (base[0].equals(ticketNo)) {
                System.out.println("Here are the information of this ticket: ");
                System.out.println("Ticket " + base[0] + " was raised by customer " + base[1] + " about \"" + base[2] +  "\". This ticket has " + base[3] + " - " + map.get(base[3]) + " Severity level.");
                System.out.print("Do you want to close this ticket [Y/N]?:");
                String sure = sc.next();
                if (sure.equals("N")){
                    System.out.println("Closing ticket cancelled!");
                    displayRemainingTicket();
                    return;
                } else if (sure.equals("Y")) {
                    database.remove();
                    displayRemainingTicket();
                    return;
                } else {
                    System.out.println("Invalid Input!");
                    displayRemainingTicket();
                    return;
                }
            } else {
                if (!validateTicketNumber(ticketNo)) {
                    System.out.println("The front of the queue is not the given ticket number!");
                    return;
                } else {
                    System.out.println("Ticket Not Found");
                    return;
                }
            }
    }
    
    static void displayTicket() {
        if (database.isEmpty()) {
            System.out.println("The database is empty!");
            return;
        }
        System.out.println("Below are the remaining open tickets:");
        for(String[] base: database) {
            System.out.println("Ticket " + base[0] + " was raised by customer " + base[1] + " about \"" + base[2] +  "\". This ticket has " + base[3] + " - " + map.get(base[3]) + " Severity level.");
        }
    }
    
    static void displayRemainingTicket() {
        if (database.isEmpty()) {
            System.out.println("The database is empty!");
            return;
        }
        System.out.println("The remaining open tickets are:");
        for(String[] base: database) {
            System.out.println(base[0]);
        }
    }
    
    static boolean validateTicketNumber(String ticket) {
        for(String[] base: database) {
            if (base[0].equals(ticket)) return false;
        }
        return true;
    }
    
    static boolean isNumber(String s) {
        try {
            int sum = Integer.parseInt(s);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
