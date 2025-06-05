package billingSystem;

public class Product {
    int id;
    String name;
    float price;
    float tax;
    public Product(int id,String name,float price,float tax)
    {
       this.id=id;
       this.name=name;
       this.price=price;
       this.tax=tax;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public float getTax() {
        return tax;
    }
}
