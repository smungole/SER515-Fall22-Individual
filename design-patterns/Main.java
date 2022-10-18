import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        DB db = DB.getInstance();

        System.out.println("Buyers & Sellers -");
        List<String> users = db.read("BuyerInfo.txt");
        users.addAll(db.read("SellerInfo.txt"));

        db.write(users, "UserInfo.txt");
        System.out.println(db.read("UserInfo.txt"));
    }
}