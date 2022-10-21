package menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import database.DB;

public class ProductMenuDB {
    private static final String PRODUCT_FILE_NAME = "ProductInfo.txt";
    private static final String PRODUCE_KEY = "Produce";
    private static final String MEAT_KEY = "Meat";

    private static List<String> meatProducts = new ArrayList<>();

    public static List<String> getMeatProducts() {
        return meatProducts;
    }

    private static List<String> produceProducts = new ArrayList<>();

    public static List<String> getProduceProducts() {
        return produceProducts;
    }

    private ProductMenuDB() {
    }

    public static void loadProducts() throws IOException {
        DB db = DB.getInstance();
        List<String> contents = db.read(PRODUCT_FILE_NAME);

        meatProducts = new ArrayList<>();
        produceProducts = new ArrayList<>();
        for (int i = 0; i < contents.size(); i++) {
            String[] product = contents.get(i).trim().split(":");
            if (product[0].equals(PRODUCE_KEY)) {
                produceProducts.add(product[1]);
            } else if (product[0].equals(MEAT_KEY)) {
                meatProducts.add(product[1]);
            }
        }
    }

}
