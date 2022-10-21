public class Product {
    private String product_name;
    private String product_type;

    public Product(String name, String type) {
        this.product_name = name;
        this.product_type = type;
    }

    public String getName() {
        return product_name;
    }

    public String getType() {
        return product_type;
    }

    public void setName(String name) {
        this.product_name = name;
    }

    public void setType(String type) {
        this.product_type = type;
    }

    public void accept(ReminderVisitor reminderVisitor) {
    }
}
