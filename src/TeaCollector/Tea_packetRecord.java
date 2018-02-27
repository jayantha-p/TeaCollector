
package TeaCollector;

public class Tea_packetRecord {
    private final int id;
    private final String name;
    private final Double price;
    private final String valid_from;
    private final String added_by;
    private final String added_on;
    private final String added_at;
    
    public Tea_packetRecord(int ID, String Name, Double Price, String Valid_from, String Added_by, String Added_on, String Added_at){
        this.id=ID;
        this.name=Name;
        this.price=Price;
        this.valid_from=Valid_from;
        this.added_by=Added_by;
        this.added_on=Added_on;
        this.added_at=Added_at;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @return the valid_from
     */
    public String getValid_from() {
        return valid_from;
    }

    /**
     * @return the added_by
     */
    public String getAdded_by() {
        return added_by;
    }

    /**
     * @return the added_on
     */
    public String getAdded_on() {
        return added_on;
    }

    /**
     * @return the added_at
     */
    public String getAdded_at() {
        return added_at;
    }
}
