package TeaCollector;

public class SupplierRecord {

    private final int id;
    private final int supplier_ID;
    private final String name;
    private final String telephone;

    public SupplierRecord(int ID, int Supplier_ID, String Name, String Telephone) {
        this.id=ID;
        this.supplier_ID=Supplier_ID;
        this.name=Name;
        this.telephone=Telephone;
    }
    public int getId() {
        return id;
    }
    public int getSupplier_ID() {
        return supplier_ID;
    }
    public String getName() {
        return name;
    }
    public String getTelephone() {
        return telephone;
    }

}
