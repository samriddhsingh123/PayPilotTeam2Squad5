package test;
<<<<<<< HEAD

import static org.junit.Assert.*;

import org.junit.Test;

public class BillTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
=======
import java.util.Calendar;
import java.text.ParseException;
import static org.junit.Assert.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Bill;
import service.BillService;

public class BillTest {

	
    private BillService billService ;
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    Date currentDate = new Date();
    @Before
    public void setUp() {
        billService = new BillService();
    }
    
    
    @AfterClass
    public static void wrapUpDatabase() {
    	
    }
     
    
    // Story 2.2 BillCategory
    @Test
    public void testAddNewBill() {
    	File fileName = new File("attachment.pdf");
    	Date specificDate = null;
    	try {
    		specificDate = dateFormat.parse("10102023");
    	}
    	catch(ParseException e) {
    		System.out.println("Try correct format");
    	}
    	
    	if (specificDate == null) {
            System.out.println("specificDate is null");
            return; // Exit the test if specificDate is null
        }
    	
        Bill bill = new Bill(1, "Electricity", "Utilities", currentDate, 100.0, "Monthly", fileName, "Pay before due date", true, "Pending", 0);
        billService.addNewBill(bill);
        //One Object is added 
        List<Bill> bills = billService.getBillsOverview("All", specificDate, currentDate, "Pending");
        assertEquals(1, bills.size());
        
        //checks all the fields/parameters that were inserted
        assertEquals("Electricity", bills.get(0).getBillName());
        assertEquals("Utilities",bills.get(0).getBillCategory());
        assertEquals(currentDate,bills.get(0).getDueDate());
        assertEquals(100.0,bills.get(0).getAmount(),0.01);
        assertEquals("Monthly",bills.get(0).getReminderFrequency());
        assertEquals(fileName,bills.get(0).getAttachment());
        assertEquals("Pay before due date",bills.get(0).getNotes());
        assertEquals("Pending",bills.get(0).getPaymentStatus());
        assertEquals(0,bills.get(0).getOverdueDays());
        
    }

    @Test
    public void testGetBillsOverview() {
        Bill bill1 = new Bill(1, "Electricity", "Utilities", currentDate, 100.0, "Monthly", new File("attachment.pdf"), "Pay before due date", true, "Pending", 0);
        Bill bill2 = new Bill(2, "Water", "Utilities", currentDate, 50.0, "Monthly", new File("attachment.pdf"), "Pay before due date", true, "Paid", 0);
        billService.addNewBill(bill1);
        billService.addNewBill(bill2);
        
        //Verify getBillsOverview
        List<Bill> bills = billService.getBillsOverview("Utilities", new Date(0), currentDate, "Pending");
        assertEquals(1, bills.size());
        
    }
    
    @Test
    public void testGetUpcomingBills() {
    	Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.DECEMBER, 12);
        Date Afterdate = calendar.getTime();
        Bill bill1 = new Bill(1, "Electricity", "Utilities", Afterdate, 100.0, "Monthly", new File("attachment.pdf"), "Pay before due date", true, "Upcoming", 0);
        Bill bill2 = new Bill(2, "Water", "Utilities", Afterdate, 50.0, "Monthly", new File("attachment.pdf"), "Pay before due date", true, "Not Paid", 0);
        billService.addNewBill(bill1);
        billService.addNewBill(bill2);
        
        List<Bill> UpcomingBills = billService.getUpcomingBills();
        //Verifying the One Bill is Upcoming
        assertEquals(1, UpcomingBills.size());
       
    }
    
    @Test
    public void testGetOverdueBills() {
    	Date beforeDate = new Date(0);
        Bill bill1 = new Bill(1, "Electricity", "Utilities", beforeDate, 100.0, "Monthly", new File("attachment.pdf"), "Pay before due date", true, "Pending", 5);
        Bill bill2 = new Bill(2, "Water", "Utilities", beforeDate, 50.0, "Monthly", new File("attachment.pdf"), "Pay before due date", true, "Not Paid", 0);
        
        billService.addNewBill(bill1);
        billService.addNewBill(bill2);
        
        List<Bill> overdueBills = billService.getOverdueBills();
      //Verifying the One Bill is Overdue
        assertEquals(1,overdueBills.size());
        
    }
    
    
    // Manager bills methods

    @Test
    public void testMarkBillAsPaid() {
        Bill bill = new Bill(1, "Electricity", "Utilities", currentDate, 100.0, "Monthly", new File("attachment.pdf"), "Pay before due date", true, "Pending", 5);
        billService.addNewBill(bill);
        billService.markBillAsPaid(1);
        List<Bill> bills = billService.getBillsOverview("All", new Date(0), currentDate, "Paid");
        assertEquals(1, bills.size());
        assertEquals("Paid", bills.get(0).getPaymentStatus());
        assertEquals(0, bills.get(0).getOverdueDays());
    }

    @Test
    public void testSnoozeBill() {
    	Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.DECEMBER, 12);
        Date afterDate = calendar.getTime();
    	Bill bill = new Bill(1, "Electricity", "Utilities", currentDate, 100.0, "Monthly", new File("attachment.pdf"), "Pay before due date", true, "Pending", 5);
    	billService.addNewBill(bill);
    	assertEquals(1,billService.snoozeBill(1, afterDate));
    	List<Bill> bills = billService.getBillsOverview("All", currentDate, afterDate, "Pending");
    	assertEquals(afterDate,bills.get(0).getDueDate());    	
    }

    @Test
    public void testGetNextBillId() {
        int nextBillId = billService.getNextBillId();
        assertEquals(1, nextBillId);
        Bill bill = new Bill(nextBillId, "Electricity", "Utilities", currentDate, 100.0, "Monthly", new File("attachment.pdf"), "Pay before due date", true, "Pending", 0);
        billService.addNewBill(bill);
        nextBillId = billService.getNextBillId();
        assertEquals(2, nextBillId);
    }
>>>>>>> c25e5ee (Corner cases for snooze bill and paid bill added)

}
