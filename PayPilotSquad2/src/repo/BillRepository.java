package repo;

import model.Bill;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Date;

/**
 * The BillRepository class is responsible for managing bills, including adding,
 * retrieving, updating, and filtering bills based on different criteria.
 * 
 * Author: [Samriddh Singh, Sharvari Thakare]
 * Date: [11-08-2024]
 */
public class BillRepository {

    // List to store all the bills
    private List<Bill> bills = new ArrayList<>();
    
    // ID to be assigned to the next bill
    private int nextBillId = 1;

    /**
     * Adds a new bill to the repository.
     * 
     * @param bill The Bill object to be added.
     */
    public void addBill(Bill bill) {
        bills.add(bill);
    }

    /**
     * Retrieves all bills in the repository.
     * 
     * @return A list of all Bill objects.
     */
    public List<Bill> getAllBills() {
        return new ArrayList<>(bills);
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
        return bills.stream()
                .filter(bill -> (category.equalsIgnoreCase("All") || bill.getBillCategory().equalsIgnoreCase(category)) &&
                        (bill.getDueDate().after(fromDate) || bill.getDueDate().equals(fromDate)) &&
                        (bill.getDueDate().before(toDate) || bill.getDueDate().equals(toDate)) &&
                        bill.getPaymentStatus().equalsIgnoreCase(status))
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a list of overdue bills (bills with due dates before today and not fully paid).
     * 
     * @return A list of overdue Bill objects.
     */
    public List<Bill> getOverdueBills() {
        Date today = new Date();
        return bills.stream()
                .filter(bill -> bill.getDueDate().before(today) && 
                        (bill.getPaymentStatus().equalsIgnoreCase("Not Paid") || bill.getPaymentStatus().equalsIgnoreCase("Partially Paid")))
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a list of upcoming bills (bills with due dates on or after today and not fully paid).
     * 
     * @return A list of upcoming Bill objects.
     */
    public List<Bill> getUpcomingBills() {
        Date today = new Date();
        return bills.stream()
                .filter(bill -> (bill.getDueDate().equals(today) || bill.getDueDate().after(today)) && 
                        (bill.getPaymentStatus().equalsIgnoreCase("Not Paid") || bill.getPaymentStatus().equalsIgnoreCase("Partially Paid")))
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a bill by its ID.
     * 
     * @param billId The ID of the bill to retrieve.
     * @return The Bill object with the specified ID, or null if not found.
     */
    public Bill getBillById(int billId) {
        return bills.stream()
                .filter(bill -> bill.getBillId() == billId)
                .findFirst()
                .orElse(null);
    }

    /**
     * Updates an existing bill in the repository.
     * 
     * @param bill The Bill object with updated details.
     */
    public void updateBill(Bill bill) {
        for (int i = 0; i < bills.size(); i++) {
            if (bills.get(i).getBillId() == bill.getBillId()) {
                bills.set(i, bill);
                return;
            }
        }
    }

    /**
     * Generates and returns the next available bill ID.
     * 
     * @return The next available bill ID.
     */
    public int getNextBillId() {
        return nextBillId++;
    }
}
