/**
 * Created by majo on 6/24/16.
 */

import java.util.HashMap;
import java.util.ArrayList;

public class App {

    private static final String PATH = "/Users/majo/Documents/Ad-Juster Sample/ad_juster_data.db";
    private static ArrayList<HashMap<String, String>> users;

    public static ReadDB dbfetch;

    public static void main(String[] args) {
        if (dbfetch == null) {
            dbfetch = new ReadDB();
            users = dbfetch.makeQuery(PATH);
            users.remove(0);
        }
        System.out.println(getNameWithHigherThanXClicks(users, 200000));
        //System.out.println(getNameStartingWithSubstring(dbfetch.users, "shitty"));
        //System.out.println(getNameWithCPMHigherThanXDollars(dbfetch.users, 41.00));
    }

    /*public static void makeQuery(String path) {
        dbfetch = new ReadDB();
        users = dbfetch.makeQuery(path);
    }*/

    public static ArrayList<String> getNameWithHigherThanXClicks(ArrayList<HashMap<String, String>> users, int clickThreshold) {
        System.out.println("getNameWithHigherThanXClicks invoked");
        ArrayList<String> names = new ArrayList<String>();
        for(int index = 0; index < users.size(); ++index) {
            if(clickThreshold < Integer.parseInt(users.get(index).get("clicks"))) {
                names.add(users.get(index).get("name"));
            }
        }
        return names;
    }

    public ArrayList<String> getNameStartingWithSubstring(ArrayList<HashMap<String, String>> users, String substring) {
        ArrayList<String> names = new ArrayList<String>();
        for(int index = 0; index < users.size(); ++index) {
            String name = users.get(index).get("name");
            if(name.toLowerCase().contains(substring.toLowerCase())) {
                names.add(name);
            }
        }
        return names;
    }

    public ArrayList<String> getNameWithCPMHigherThanXDollars(ArrayList<HashMap<String, String>> users, double dollarThreshold) {
        ArrayList<String> names = new ArrayList<String>();
        for(int index = 0; index < users.size(); ++index) {
            String cpm = users.get(index).get("cpm").replace("$","");
            Double dollarAmount = Double.parseDouble(cpm);
            if(dollarThreshold < dollarAmount) {
                names.add(users.get(index).get("name"));
            }
        }
        return names;
    }
}