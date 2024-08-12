package model;

import java.io.File;
import java.util.Date;

/**
 * The Bill class represents a bill with details such as bill name, category, due date,
 * amount, reminder frequency, and payment status. It also includes optional details like
 * attachments, notes, and recurrence status.
 * 
 * @author [Samriddh Singh]
 * @date [11-08-2024]
 */
public class Bill {
    
    // Unique identifier for the bill
    private int billId;
    
    // Name of the bill
    private String billName;
    
    // Category of the bill (e.g., utilities, rent)
    private String billCategory;
    
    // Due date for the bill payment
    private Date dueDate;
    
    // Amount due for the bill
    private double amount;
    
    // Frequency of reminders for the bill (e.g., daily, weekly)
    private String reminderFrequency;
    
    // Attachment related to the bill (e.g., PDF, image)
    private File attachment;
    
    // Additional notes regarding the bill
    private String notes;
    
    // Indicates whether the bill is recurring
    private boolean isRecurring;
    
    // Payment status of the bill (e.g., paid, unpaid)
    private String paymentStatus;
    
    // Number of days the bill is overdue
    private int overdueDays;

    /**
     * Constructor to initialize a Bill object with the specified details.
     * 
     * @param billId            unique identifier for the bill
     * @param billName          name of the bill
     * @param billCategory      category of the bill
     * @param dueDate           due date for the bill payment
     * @param amount            amount due for the bill
     * @param reminderFrequency frequency of reminders for the bill
     * @param attachment        attachment related to the bill
     * @param notes             additional notes regarding the bill
     * @param isRecurring       indicates whether the bill is recurring
     * @param paymentStatus     payment status of the bill
     * @param overdueDays       number of days the bill is overdue
     */
    public Bill(int billId, String billName, String billCategory, Date dueDate, double amount, 
                String reminderFrequency, File attachment, String notes, boolean isRecurring, 
                String paymentStatus, int overdueDays) {
        this.billId = billId;
        this.billName = billName;
        this.billCategory = billCategory;
        this.dueDate = dueDate;
        this.amount = amount;
        this.reminderFrequency = reminderFrequency;
        this.attachment = attachment;
        this.notes = notes;
        this.isRecurring = isRecurring;
        this.paymentStatus = paymentStatus;
        this.overdueDays = overdueDays;
    }

    // Getter and Setter methods for each field

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public String getBillName() {
        return billName;
    }

    public void setBillName(String billName) {
        this.billName = billName;
    }

    public String getBillCategory() {
        return billCategory;
    }

    public void setBillCategory(String billCategory) {
        this.billCategory = billCategory;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getReminderFrequency() {
        return reminderFrequency;
    }

    public void setReminderFrequency(String reminderFrequency) {
        this.reminderFrequency = reminderFrequency;
    }

    public File getAttachment() {
        return attachment;
    }

    public void setAttachment(File attachment) {
        this.attachment = attachment;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isRecurring() {
        return isRecurring;
    }

    public void setRecurring(boolean recurring) {
        isRecurring = recurring;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public int getOverdueDays() {
        return overdueDays;
    }

    public void setOverdueDays(int overdueDays) {
        this.overdueDays = overdueDays;
    }
}
