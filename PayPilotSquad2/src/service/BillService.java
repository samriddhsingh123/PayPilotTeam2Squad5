package service;
import model.Bill;
import repo.BillRepository;

import java.util.Date;
import java.util.List;

import java.util.Date;
import java.util.List;

public class BillService {
    private BillRepository billRepository = new BillRepository();

    public void addNewBill(Bill bill) {
        billRepository.addBill(bill);
    }

    public List<Bill> getBillsOverview(String category, Date fromDate, Date toDate, String status) {
        return billRepository.getBillsOverview(category, fromDate, toDate, status);
    }

    public List<Bill> getOverdueBills() {
        return billRepository.getOverdueBills();
    }

    public List<Bill> getUpcomingBills() {
        return billRepository.getUpcomingBills();
    }

    public int snoozeBill(int billId, Date newDueDate) {
        Bill bill = billRepository.getBillById(billId);
        if (bill != null) {
            bill.setDueDate(newDueDate);
            billRepository.updateBill(bill);
            return 1;
        }
        return 0;
    }

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

    public int getNextBillId() {
        return billRepository.getNextBillId();
    }
}
