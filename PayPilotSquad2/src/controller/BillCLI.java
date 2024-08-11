package controller;
import model.Bill;
import repo.BillRepository;

import java.util.Date;
import java.util.List;
<<<<<<< HEAD

import java.util.Date;
import java.util.List;

import model.Bill;
import repo.BillRepository;
import controller.BillController;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BillCLI {
    private static BillController billController = new BillController();
=======
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import model.ReminderSettings;



public class BillCLI {
    private static BillController billController = new BillController();
    private static ReminderController reminderController = new ReminderController();
>>>>>>> c25e5ee (Corner cases for snooze bill and paid bill added)
    private static Scanner scanner = new Scanner(System.in);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public static void main(String[] args) {
<<<<<<< HEAD
        while (true) {
=======
    	while (true) {
>>>>>>> c25e5ee (Corner cases for snooze bill and paid bill added)
            System.out.println("\nBill Management System");
            System.out.println("1. Add New Bill");
            System.out.println("2. View Bills Overview");
            System.out.println("3. View Overdue Bills");
            System.out.println("4. View Upcoming Bills");
            System.out.println("5. Snooze a Bill");
            System.out.println("6. Mark Bill as Paid");
<<<<<<< HEAD
            System.out.println("7. Exit");
=======
            System.out.println("7. Manage Reminder Settings");
            System.out.println("8. Exit");
>>>>>>> c25e5ee (Corner cases for snooze bill and paid bill added)
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addNewBill();
                    break;
                case 2:
                    viewBillsOverview();
                    break;
                case 3:
                    viewOverdueBills();
                    break;
                case 4:
                    viewUpcomingBills();
                    break;
                case 5:
                    snoozeBill();
                    break;
                case 6:
                    markBillAsPaid();
                    break;
                case 7:
<<<<<<< HEAD
=======
                    manageReminderSettings();
                    break;
                case 8:
>>>>>>> c25e5ee (Corner cases for snooze bill and paid bill added)
                    System.out.println("Exiting the application...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addNewBill() {
        System.out.println("\nAdd New Bill:");
        System.out.print("Bill Name: ");
        String billName = scanner.nextLine();

        System.out.print("Bill Category: ");
        String billCategory = scanner.nextLine();

        System.out.print("Due Date (dd-MM-yyyy): ");
        Date dueDate = null;
        try {
            dueDate = dateFormat.parse(scanner.nextLine());
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please try again.");
            return;
        }

        System.out.print("Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Reminder Frequency (Daily/Weekly/Monthly): ");
        String reminderFrequency = scanner.nextLine();

        System.out.print("Attachment (File path, optional): ");
        String filePath = scanner.nextLine();
        File attachment = filePath.isEmpty() ? null : new File(filePath);

        System.out.print("Notes (optional): ");
        String notes = scanner.nextLine();

        System.out.print("Is Recurring (true/false): ");
        boolean isRecurring = scanner.nextBoolean();
        scanner.nextLine();

        System.out.print("Payment Status (Pending/Upcoming/Paid): ");
        String paymentStatus = scanner.nextLine();

        int billId = billController.getNextBillId();
        Bill newBill = new Bill(billId, billName, billCategory, dueDate, amount, reminderFrequency, attachment, notes, isRecurring, paymentStatus, 0);
        billController.addNewBill(newBill);

        System.out.println("Bill added successfully!");
    }

    private static void viewBillsOverview() {
        System.out.println("\nView Bills Overview:");
        System.out.print("Bill Category (All, Debt Payments, House Rent, etc.): ");
        String category = scanner.nextLine();

        System.out.print("Bill Date From (dd-MM-yyyy): ");
        Date fromDate = null;
        try {
            fromDate = dateFormat.parse(scanner.nextLine());
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please try again.");
            return;
        }

        System.out.print("Bill Date To (dd-MM-yyyy): ");
        Date toDate = null;
        try {
            toDate = dateFormat.parse(scanner.nextLine());
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please try again.");
            return;
        }

        System.out.print("Bill Status (Upcoming/Pending/Paid): ");
        String status = scanner.nextLine();

        List<Bill> bills = billController.getBillsOverview(category, fromDate, toDate, status);
        displayBills(bills);
    }

    private static void viewOverdueBills() {
        System.out.println("\nView Overdue Bills:");
        List<Bill> overdueBills = billController.getOverdueBills();
<<<<<<< HEAD
        
        if (overdueBills.isEmpty()) {System.out.println("No Overdue Bills Found.");}
        else {displayBills(overdueBills);}
=======
        displayBills(overdueBills);
>>>>>>> c25e5ee (Corner cases for snooze bill and paid bill added)
    }

    private static void viewUpcomingBills() {
        System.out.println("\nView Upcoming Bills:");
        List<Bill> upcomingBills = billController.getUpcomingBills();
<<<<<<< HEAD
        
        if (upcomingBills.isEmpty()) {System.out.println("No Upcoming Bills Found.");}
        else {displayBills(upcomingBills);}
=======
        displayBills(upcomingBills);
>>>>>>> c25e5ee (Corner cases for snooze bill and paid bill added)
    }

    private static void snoozeBill() {
        System.out.println("\nSnooze a Bill:");
        System.out.print("Enter Bill ID: ");
        int billId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("New Due Date (dd-MM-yyyy): ");
        Date snoozeDate = null;
        try {
            snoozeDate = dateFormat.parse(scanner.nextLine());
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please try again.");
            return;
        }

<<<<<<< HEAD
        int a=billController.snoozeBill(billId, snoozeDate);
        if(a==0) {
        	System.out.println("No bill is there with id: "+billId);
        }
        if(a==1) System.out.println("Bill snoozed successfully!");
=======
        billController.snoozeBill(billId, snoozeDate);
        System.out.println("Bill snoozed successfully!");
>>>>>>> c25e5ee (Corner cases for snooze bill and paid bill added)
    }

    private static void markBillAsPaid() {
        System.out.println("\nMark Bill as Paid:");
        System.out.print("Enter Bill ID: ");
        int billId = scanner.nextInt();
        scanner.nextLine();

<<<<<<< HEAD
        int a=billController.markBillAsPaid(billId);
        if(a==0) {
        	System.out.println("No bill is there with id: "+billId);
        }
        if(a==1)
        	System.out.println("Bill marked as paid!");
=======
        billController.markBillAsPaid(billId);
        System.out.println("Bill marked as paid!");
>>>>>>> c25e5ee (Corner cases for snooze bill and paid bill added)
    }

    private static void displayBills(List<Bill> bills) {
        if (bills.isEmpty()) {
            System.out.println("No bills found.");
        } else {
            System.out.println("\nBill Details:");
            for (Bill bill : bills) {
                System.out.println("Bill ID: " + bill.getBillId());
                System.out.println("Bill Name: " + bill.getBillName());
                System.out.println("Category: " + bill.getBillCategory());
                System.out.println("Due Date: " + dateFormat.format(bill.getDueDate()));
                System.out.println("Amount: " + bill.getAmount());
                System.out.println("Reminder Frequency: " + bill.getReminderFrequency());
                System.out.println("Attachment: " + (bill.getAttachment() != null ? bill.getAttachment().getPath() : "None"));
                System.out.println("Notes: " + bill.getNotes());
                System.out.println("Is Recurring: " + bill.isRecurring());
                System.out.println("Payment Status: " + bill.getPaymentStatus());
                System.out.println("Overdue Days: " + bill.getOverdueDays());
                System.out.println("-------------");
            }
        }
    }
<<<<<<< HEAD
}
=======
    
    private static void manageReminderSettings() {
        System.out.println("\nManage Reminder Settings:");
        System.out.println("1. Add a New Reminder");
        System.out.println("2. Update an Existing Reminder");
        System.out.println("3. Delete a Reminder");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice) {
            case 1:
                addReminder();
                break;
            case 2:
                updateReminder();
                break;
            case 3:
                deleteReminder();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void addReminder() {
        System.out.println("\nAdd New Reminder:");

        System.out.print("Reminder Frequency (Daily/Weekly/Monthly): ");
        String reminderFrequency = scanner.nextLine();

        System.out.print("Reminder Start Date (dd-MM-yyyy): ");
        Date reminderStartDate = null;
        try {
            reminderStartDate = dateFormat.parse(scanner.nextLine());
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please try again.");
            return;
        }

        System.out.print("Custom Message: ");
        String customMessage = scanner.nextLine();

        System.out.print("Notification Preference (Email/SMS): ");
        String notificationPref = scanner.nextLine();

        // Adding the reminder through the controller
        reminderController.setReminder(0, reminderFrequency, reminderStartDate, customMessage, notificationPref);
        System.out.println("Reminder added successfully!");
    }

    private static void updateReminder() {
        System.out.println("\nUpdate Existing Reminder:");
        System.out.print("Enter Reminder ID: ");
        int reminderId = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Reminder Frequency (Daily/Weekly/Monthly): ");
        String reminderFrequency = scanner.nextLine();

        System.out.print("Reminder Start Date (dd-MM-yyyy): ");
        Date reminderStartDate = null;
        try {
            reminderStartDate = dateFormat.parse(scanner.nextLine());
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please try again.");
            return;
        }

        System.out.print("Custom Message: ");
        String customMessage = scanner.nextLine();

        System.out.print("Notification Preference (Email/SMS): ");
        String notificationPref = scanner.nextLine();

        // Updating the reminder through the controller
        reminderController.updateReminder(reminderId, reminderFrequency, reminderStartDate, customMessage, notificationPref);
        System.out.println("Reminder updated successfully!");
    }

    private static void deleteReminder() {
        System.out.println("\nDelete Reminder:");
        System.out.print("Enter Reminder ID: ");
        int reminderId = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Deleting the reminder through the controller
        reminderController.deleteReminder(reminderId);
        System.out.println("Reminder deleted successfully!");
    }


    
    
}
>>>>>>> c25e5ee (Corner cases for snooze bill and paid bill added)
