package controller;
import service.BillService;
import java.util.Date;
import java.util.List;
import model.Bill;
import service.BillService;
public class BillController {
    private BillService billService = new BillService();

    public void addNewBill(Bill bill) {
        billService.addNewBill(bill);
    }

    public List<Bill> getBillsOverview(String category, Date fromDate, Date toDate, String status) {
        return billService.getBillsOverview(category, fromDate, toDate, status);
    }

    public List<Bill> getOverdueBills() {
        return billService.getOverdueBills();
    }

    public List<Bill> getUpcomingBills() {
        return billService.getUpcomingBills();
    }

    public int snoozeBill(int billId, Date snoozeDate) {
        return billService.snoozeBill(billId, snoozeDate);
    }

    public int markBillAsPaid(int billId) {
       return billService.markBillAsPaid(billId);
    }

    public int getNextBillId() {
        return billService.getNextBillId();
    }
}
