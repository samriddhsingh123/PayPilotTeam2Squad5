package test;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Calendar;
import java.text.ParseException;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import model.Bill;
import service.BillService;

/**
 * BillTest class tests the functionality of the BillService class, ensuring
 * that bill-related operations are performed correctly.
 * 
 * @author Gaurav Gupta, Sravani
 * @date [11-08-2024]
 */
public class BillTest {

    private BillService billService;
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    Date currentDate = new Date();

    /**
     * Sets up the environment before each test.
     */
    @Before
    public void setUp() {
        billService = new BillService();
    }

    /**
     * Cleans up the environment after all tests are completed.
     */
    @AfterClass
    public static void wrapUpDatabase() {
        // Clean up logic if required
    }

    /**
     * Dummy test method to be implemented or removed.
     */
//    @Test
//    public void test() {
//        fail("Not yet implemented");
//    }

    /**
     * Test for adding a new bill.
     */
    @Test
    public void testAddNewBill() {
        File fileName = new File("attachment.pdf");
        Date specificDate = null;
        try {
            specificDate = dateFormat.parse("10-10-2023");
        } catch (ParseException e) {
            System.out.println("Please use the correct date format (dd-MM-yyyy).");
        }

        if (specificDate == null) {
            System.out.println("specificDate is null");
            return; // Exit the test if specificDate is null
        }

        Bill bill = new Bill(1, "Electricity", "Utilities", currentDate, 100.0, "Monthly", fileName, "Pay before due date", true, "Pending", 0);
        billService.addNewBill(bill);

        // Verify that one bill was added
        List<Bill> bills = billService.getBillsOverview("All", specificDate, currentDate, "Pending");
        assertEquals(1, bills.size());

        // Verify all fields/parameters that were inserted
        assertEquals("Electricity", bills.get(0).getBillName());
        assertEquals("Utilities", bills.get(0).getBillCategory());
        assertEquals(currentDate, bills.get(0).getDueDate());
        assertEquals(100.0, bills.get(0).getAmount(), 0.01);
        assertEquals("Monthly", bills.get(0).getReminderFrequency());
        assertEquals(fileName, bills.get(0).getAttachment());
        assertEquals("Pay before due date", bills.get(0).getNotes());
        assertEquals("Pending", bills.get(0).getPaymentStatus());
        assertEquals(0, bills.get(0).getOverdueDays());
    }

    /**
     * Test for retrieving bills based on specific criteria.
     */
    @Test
    public void testGetBillsOverview() {
        Bill bill1 = new Bill(1, "Electricity", "Utilities", currentDate, 100.0, "Monthly", new File("attachment.pdf"), "Pay before due date", true, "Pending", 0);
        Bill bill2 = new Bill(2, "Water", "Utilities", currentDate, 50.0, "Monthly", new File("attachment.pdf"), "Pay before due date", true, "Paid", 0);
        billService.addNewBill(bill1);
        billService.addNewBill(bill2);

        // Verify getBillsOverview
        List<Bill> bills = billService.getBillsOverview("Utilities", new Date(0), currentDate, "Pending");
        assertEquals(1, bills.size());
    }

    /**
     * Test for retrieving upcoming bills.
     */
    @Test
    public void testGetUpcomingBills() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.DECEMBER, 12);
        Date afterDate = calendar.getTime();

        Bill bill1 = new Bill(1, "Electricity", "Utilities", afterDate, 100.0, "Monthly", new File("attachment.pdf"), "Pay before due date", true, "Upcoming", 0);
        Bill bill2 = new Bill(2, "Water", "Utilities", afterDate, 50.0, "Monthly", new File("attachment.pdf"), "Pay before due date", true, "Not Paid", 0);
        billService.addNewBill(bill1);
        billService.addNewBill(bill2);

        // Verify that one bill is upcoming
        List<Bill> upcomingBills = billService.getUpcomingBills();
        assertEquals(1, upcomingBills.size());
    }

    /**
     * Test for retrieving overdue bills.
     */
    @Test
    public void testGetOverdueBills() {
        Date beforeDate = new Date(0);
        Bill bill1 = new Bill(1, "Electricity", "Utilities", beforeDate, 100.0, "Monthly", new File("attachment.pdf"), "Pay before due date", true, "Pending", 5);
        Bill bill2 = new Bill(2, "Water", "Utilities", beforeDate, 50.0, "Monthly", new File("attachment.pdf"), "Pay before due date", true, "Not Paid", 0);

        billService.addNewBill(bill1);
        billService.addNewBill(bill2);

        // Verify that one bill is overdue
        List<Bill> overdueBills = billService.getOverdueBills();
        assertEquals(1, overdueBills.size());
    }

    /**
     * Test for marking a bill as paid.
     */
    @Test
    public void testMarkBillAsPaid() {
        Bill bill = new Bill(1, "Electricity", "Utilities", currentDate, 100.0, "Monthly", new File("attachment.pdf"), "Pay before due date", true, "Pending", 5);
        billService.addNewBill(bill);
        billService.markBillAsPaid(1);

        // Verify that the bill was marked as paid
        List<Bill> bills = billService.getBillsOverview("All", new Date(0), currentDate, "Paid");
        assertEquals(1, bills.size());
        assertEquals("Paid", bills.get(0).getPaymentStatus());
        assertEquals(0, bills.get(0).getOverdueDays());
    }

    /**
     * Test for snoozing a bill.
     */
    @Test
    public void testSnoozeBill() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.DECEMBER, 12);
        Date afterDate = calendar.getTime();

        Bill bill = new Bill(1, "Electricity", "Utilities", currentDate, 100.0, "Monthly", new File("attachment.pdf"), "Pay before due date", true, "Pending", 5);
        billService.addNewBill(bill);

        // Verify that the bill was snoozed
        assertEquals(1, billService.snoozeBill(1, afterDate));
        List<Bill> bills = billService.getBillsOverview("All", currentDate, afterDate, "Pending");
        assertEquals(afterDate, bills.get(0).getDueDate());
    }

    /**
     * Test for retrieving the next bill ID.
     */
    @Test
    public void testGetNextBillId() {
        int nextBillId = billService.getNextBillId();
        assertEquals(1, nextBillId);

        Bill bill = new Bill(nextBillId, "Electricity", "Utilities", currentDate, 100.0, "Monthly", new File("attachment.pdf"), "Pay before due date", true, "Pending", 0);
        billService.addNewBill(bill);

        nextBillId = billService.getNextBillId();
        assertEquals(2, nextBillId);
    }
}
