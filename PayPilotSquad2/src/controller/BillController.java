package controller;

import service.BillService;
import java.util.Date;
import java.util.List;
import model.Bill;

/**
 * BillController class acts as the intermediary between the view and the service layer.
 * It handles client requests, processes them, and communicates with the BillService to perform operations.
 *
 * Authors: [Sharvari Thakare, Samriddh Singh]
 * Date: [11-08-2024]
 */
public class BillController {

    // Instance of BillService to handle the business logic
    private BillService billService = new BillService();

    /**
     * Adds a new bill to the system.
     * 
     * @param bill The Bill object to be added.
     */
    public void addNewBill(Bill bill) {
        billService.addNewBill(bill);
    }

    /**
     * Retrieves a list of bills based on the provided filters.
     *
     * @param category The category of the bills to be retrieved.
     * @param fromDate The start date for the filter.
     * @param toDate The end date for the filter.
     * @param status The status of the bills to be retrieved.
     * @return A list of bills that match the provided filters.
     */
    public List<Bill> getBillsOverview(String category, Date fromDate, Date toDate, String status) {
        return billService.getBillsOverview(category, fromDate, toDate, status);
    }

    /**
     * Retrieves a list of overdue bills.
     * 
     * @return A list of overdue bills.
     */
    public List<Bill> getOverdueBills() {
        return billService.getOverdueBills();
    }

    /**
     * Retrieves a list of upcoming bills.
     * 
     * @return A list of upcoming bills.
     */
    public List<Bill> getUpcomingBills() {
        return billService.getUpcomingBills();
    }

    /**
     * Snoozes a bill to a later date.
     *
     * @param billId The ID of the bill to be snoozed.
     * @param snoozeDate The new date to which the bill is snoozed.
     * @return The result of the snooze operation (typically 1 for success, 0 for failure).
     */
    public int snoozeBill(int billId, Date snoozeDate) {
        return billService.snoozeBill(billId, snoozeDate);
    }

    /**
     * Marks a bill as paid.
     *
     * @param billId The ID of the bill to be marked as paid.
     * @return The result of the operation (typically 1 for success, 0 for failure).
     */
    public int markBillAsPaid(int billId) {
        return billService.markBillAsPaid(billId);
    }

    /**
     * Retrieves the next available bill ID.
     * 
     * @return The next available bill ID.
     */
    public int getNextBillId() {
        return billService.getNextBillId();
    }
}
