package models;

public class ProductModel {
    public static String name;
    public static String price;

    public static void setName(String name) {
        ProductModel.name = name;
    }

    public static void setPrice(String price) {
        ProductModel.price = price;
    }

    public static String getName() {
        return name;
    }

    public static String getPrice() {
        return price;
    }

}
