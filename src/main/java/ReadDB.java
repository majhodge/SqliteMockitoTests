/**
 * Created by majo on 6/24/16.
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ReadDB {

    public ReadDB () {

    }

    public static ArrayList<HashMap<String, String>> makeQuery(String path) {
        System.out.println("ReadDB.makeQuery() invoked");

        ArrayList<HashMap<String, String>> users = new ArrayList<HashMap<String, String>>();
        Connection connection = null;
        Statement stmt = null;
        ResultSet result = null;

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:"+ path);

            stmt = connection.createStatement();
            result = stmt.executeQuery("SELECT * FROM data");

            while(result.next()) {
                HashMap<String, String> userdata = new HashMap<String, String>();
                userdata.put("id", result.getString("id"));
                userdata.put("name", result.getString("name"));
                userdata.put("startdate", result.getString("startdate"));
                userdata.put("cpm", result.getString("cpm"));
                userdata.put("clicks", result.getString("totalclicks"));
                userdata.put("views", result.getString("totalviews"));

                //System.out.println(userdata);

                users.add(userdata);
            }
            stmt.close();
            connection.close();

        } catch(Exception e) {
            System.out.println("AN EXCEPTION OCCURRED");
            e.printStackTrace();
        }
        return users;
    }
}
