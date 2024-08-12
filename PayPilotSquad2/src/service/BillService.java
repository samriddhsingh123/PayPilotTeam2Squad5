package service;

import model.Bill;
import repo.BillRepository;
import java.util.Date;
import java.util.List;

/**
 * The BillService class provides business logic for managing bills,
 * including adding new bills, retrieving bills, snoozing bills, and marking bills as paid.
 * 
 * Author: [Sharvari Thakare, Samriddh Singh]
 * Date: [11-08-2024]
 */
public class BillService {

    // Instance of BillRepository to handle data operations
    private BillRepository billRepository = new BillRepository();

    /**
     * Adds a new bill to the repository.
     * 
     * @param bill The Bill object to be added.
     */
    public void addNewBill(Bill bill) {
        billRepository.addBill(bill);
    }

    /**
     * Retrieves an overview of bills filtered by category, date range, and status.
     * 
     * @param category The category of bills to filter by (use "All" for no category filtering).
     * @param fromDate The start date of the range to filter by.
     * @param toDate The end date of the range to filter by.
     * @param status The payment status to filter by.
     * @return A list of Bill objects that match the filter criteria.
     */
    public List<Bill> getBillsOverview(String category, Date fromDate, Date toDate, String status) {
        return billRepository.getBillsOverview(category, fromDate, toDate, status);
    }

    /**
     * Retrieves a list of overdue bills (bills with due dates before today and not fully paid).
     * 
     * @return A list of overdue Bill objects.
     */
    public List<Bill> getOverdueBills() {
        return billRepository.getOverdueBills();
    }

    /**
     * Retrieves a list of upcoming bills (bills with due dates on or after today and not fully paid).
     * 
     * @return A list of upcoming Bill objects.
     */
    public List<Bill> getUpcomingBills() {
        return billRepository.getUpcomingBills();
    }

    /**
     * Snoozes a bill by updating its due date to a new date.
     * 
     * @param billId The ID of the bill to snooze.
     * @param newDueDate The new due date to set.
     * @return 1 if the operation was successful, 0 if the bill was not found.
     */
    public int snoozeBill(int billId, Date newDueDate) {
        Bill bill = billRepository.getBillById(billId);
        if (bill != null) {
            bill.setDueDate(newDueDate);
            billRepository.updateBill(bill);
            return 1;
        }
        return 0;
    }

    /**
     * Marks a bill as paid and updates its payment status.
     * 
     * @param billId The ID of the bill to mark as paid.
     * @return 1 if the operation was successful, 0 if the bill was not found.
     */
    public int markBillAsPaid(int billId) {
        Bill bill = billRepository.getBillById(billId);
        if (bill != null) {
            bill.setPaymentStatus("Paid");
            bill.setOverdueDays(0);
            billRepository.updateBill(bill);
            return 1;
        }
        return 0;
    }

    /**
     * Retrieves the next available bill ID.
     * 
     * @return The next available bill ID.
     */
    public int getNextBillId() {
        return billRepository.getNextBillId();
    }
}
