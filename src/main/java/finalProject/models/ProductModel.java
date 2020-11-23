package finalProject.models;

public class ProductModel {
    public static String name;
    public static String price;

    public ProductModel(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

}
