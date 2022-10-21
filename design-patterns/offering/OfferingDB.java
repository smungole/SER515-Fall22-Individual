package offering;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import database.DB;

/**
 * Handles common database operations for buy and sell orders.
 */
public class OfferingDB {
    private static final String OFFERING_FILE_NAME = "UserProduct.txt";
    private static List<Offering> offerings = new ArrayList<>();

    public static List<Offering> getOfferings() {
        return offerings;
    }

    private OfferingDB() {
    }

    public static void loadOfferings() throws IOException {
        DB db = DB.getInstance();
        List<String> contents = db.read(OFFERING_FILE_NAME);

        offerings = new ArrayList<>();
        for (int i = 0; i < contents.size(); i++) {
            String[] data = contents.get(i).trim().split(":");
            Offering offering = new Offering(
                    data[0],
                    data[1],
                    Integer.parseInt(data[2]),
                    Double.parseDouble(data[3]),
                    Long.parseLong(data[4]));
            offerings.add(offering);
        }
    }

    public static void saveOfferings() throws IOException {
        List<String> contents = new ArrayList<>();
        for (Offering offering : offerings) {
            contents.add(offering.toString());
        }

        DB db = DB.getInstance();
        db.write(contents, OFFERING_FILE_NAME);
    }

}
