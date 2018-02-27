
package TeaCollector;

public class DailyRecorda {
    
    private int recordID;
    private int supplierID;
    private String date;
    private int totalAmount;
    private int cutAmount;
    private int finalAmount;
    
    public DailyRecorda(int RecordID,int SupplierID, String Date, int TotalAmount, int CutAmount, int FinalAmount) {
        this.recordID = RecordID;
        this.supplierID = SupplierID;
        this.date = Date;
        this.totalAmount = TotalAmount;
        this.cutAmount = CutAmount;
        this.finalAmount = FinalAmount;
    }

    public int getSupplierID() {
        return supplierID;
    }
    
    public String getDate() {
        return date;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    
    public int getCutAmount() {
        return cutAmount;
    }

    
    public int getFinalAmount() {
        return finalAmount;
    }   
    
    
    public int getRecordID() {
        return recordID;
    }
    
}
