
package TeaCollector;

public class AdvanceRecord {
    private final int adv_id;
    private final int supplierID;
    private final int amount;
    private final int paid;
    private final int status;
    private final String startMonth;
    private final int time_month;
    private final String added_by;
    private final String added_on;
    
    public AdvanceRecord(int ID, int SupID, int Amount, int Paid, int Status, String StartMonth, int Time_Month, String Added_by, String Added_on){
        
        this.added_by = Added_by;
        this.added_on = Added_on;
        this.adv_id = ID;
        this.amount = Amount;
        this.paid = Paid;
        this.startMonth = StartMonth;
        this.status = Status;
        this.supplierID = SupID;
        this.time_month = Time_Month;
    }

    public int getAdv_id() {
        return adv_id;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public int getAmount() {
        return amount;
    }

    public int getPaid() {
        return paid;
    }

    public int getStatus() {
        return status;
    }

    public String getStartMonth() {
        return startMonth;
    }

    public int getTime_month() {
        return time_month;
    }

    public String getAdded_by() {
        return added_by;
    }
    
    public String getAdded_on() {
        return added_on;
    }
    
}
