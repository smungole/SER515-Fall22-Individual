package product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import database.DB;

public class UserProductDB {
    private static final String USER_PRODUCT_FILE_NAME = "UserProduct.txt";

    private static final Map<String, List<String>> userProducts = new HashMap<>();

    private UserProductDB() {
    }

    public static void addProduct(String name, String product) {
        List<String> products = new ArrayList<>();
        if (userProducts.containsKey(name)) {
            products = userProducts.get(name);
            products.add(product);
        } else {
            products.add(product);
            userProducts.put(name, products);
        }
    }

    public static void loadUserProducts() throws IOException {
        DB db = DB.getInstance();
        List<String> contents = db.read(USER_PRODUCT_FILE_NAME);

        for (int i = 0; i < contents.size(); i++) {
            String[] item = contents.get(i).trim().split(":");
            addProduct(item[0], item[1]);
        }
    }

    public static void saveUserProducts() throws IOException {
        List<String> contents = new ArrayList<>();
        Set<String> users = userProducts.keySet();
        for (String user : users) {
            for (String product : userProducts.get(user)) {
                String line = String.format("%s:%s", user, product);
                contents.add(line);
            }
        }

        DB db = DB.getInstance();
        db.write(contents, USER_PRODUCT_FILE_NAME);
    }

}
