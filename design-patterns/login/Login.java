package login;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import database.DB;

/**
 * Responsible for logging the user into the application
 */
public class Login {
    private static final String BUYER_FILE_NAME = "BuyerInfo.txt";
    private static final String SELLER_FILE_NAME = "SellerInfo.txt";
    private static Map<String, String> buyers = new HashMap<>();
    private static Map<String, String> sellers = new HashMap<>();

    private Login() {
    }

    public static void loadBuyers() throws IOException {
        loadUsers(BUYER_FILE_NAME, buyers);
    }

    public static void loadSellers() throws IOException {
        loadUsers(SELLER_FILE_NAME, sellers);
    }

    private static void loadUsers(String fileName, Map<String, String> store) throws IOException {
        DB db = DB.getInstance();
        List<String> contents = db.read(fileName);
        for (int i = 0; i < contents.size(); i++) {
            String[] user = contents.get(i).trim().split(":");
            store.put(user[0], user[1]);
        }
    }

    /**
     * Verifies if the user exists in the system.
     * 
     * @param name
     * @param pass
     * @return
     */
    public static void login() {
        // TODO: return logged in user object

        String name = null;
        String pass = null;
        boolean isLoggedIn = false;
        while (!isLoggedIn) {
            name = Login.askUserName();
            pass = Login.askPassword();
            isLoggedIn = verify(name, pass);

            if (isLoggedIn) {
                System.out.println(String.format("Welcome back, %s!", name));
                break;
            } else {
                System.out.println("Invalid user name or password.\n");
            }
        }
    }

    private static String askUserName() {
        System.out.print("What is thy name? - ");
        String user = System.console().readLine();
        return user.trim();
    }

    private static String askPassword() {
        System.out.print("Your super-secret password? - ");
        char[] pass = System.console().readPassword();
        return new String(pass).trim();
    }

    private static boolean verify(String name, String pass) {
        if (buyers.containsKey(name) && buyers.get(name).equals(pass)) {
            return true;
        }
        if (sellers.containsKey(name) && sellers.get(name).equals(pass)) {
            return true;
        }
        return false;
    }
}
