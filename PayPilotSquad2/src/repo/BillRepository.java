package repo;
import model.Bill;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Date;

public class BillRepository {
    private List<Bill> bills = new ArrayList<>();
    private int nextBillId = 1;

    public void addBill(Bill bill) {
        bills.add(bill);
    }

    public List<Bill> getAllBills() {
        return new ArrayList<>(bills);
    }

    public List<Bill> getBillsOverview(String category, Date fromDate, Date toDate, String status) {
        return bills.stream()
                .filter(bill -> (category.equalsIgnoreCase("All") || bill.getBillCategory().equalsIgnoreCase(category)) &&
                        (bill.getDueDate().after(fromDate) || bill.getDueDate().equals(fromDate)) &&
                        (bill.getDueDate().before(toDate) || bill.getDueDate().equals(toDate)) &&
                        bill.getPaymentStatus().equalsIgnoreCase(status))
                .collect(Collectors.toList());
    }

    public List<Bill> getOverdueBills() {
        return bills.stream()
                .filter(bill -> "Pending".equalsIgnoreCase(bill.getPaymentStatus()) && bill.getOverdueDays() > 0)
                .collect(Collectors.toList());
    }

    public List<Bill> getUpcomingBills() {
        return bills.stream()
                .filter(bill -> "Upcoming".equalsIgnoreCase(bill.getPaymentStatus()))
                .collect(Collectors.toList());
    }

    public Bill getBillById(int billId) {
        return bills.stream()
                .filter(bill -> bill.getBillId() == billId)
                .findFirst()
                .orElse(null);
    }

    public void updateBill(Bill bill) {
        for (int i = 0; i < bills.size(); i++) {
            if (bills.get(i).getBillId() == bill.getBillId()) {
                bills.set(i, bill);
                return;
            }
        }
    }

    public int getNextBillId() {
        return nextBillId++;
    }
}
