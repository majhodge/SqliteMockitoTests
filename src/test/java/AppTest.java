import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

/**
 * Created by majo on 6/27/16.
 */
public class AppTest {


    ArrayList<String> mockSubstringResult;
    ArrayList<String> mockCPMResult;

    private static ArrayList<HashMap<String, String>> queryResult;

    @Before
    public void createEnvironment() {
        //appObj = new App();

        // setup parameters for unit testing
        HashMap<String,String> user1 = new HashMap<String, String>();
        user1.put("id", "1");
        user1.put("name", "Mrs. Doubtfire");
        user1.put("startdate", "2016-03-01,");
        user1.put("cpm", "$10.00");
        user1.put("clicks", "100");
        user1.put("views", "500");

        HashMap<String,String> user2 = new HashMap<String, String>();
        user2.put("id", "2");
        user2.put("name", "Nick Saben");
        user2.put("startdate", "2016-03-01,");
        user2.put("cpm", "$20.00");
        user2.put("clicks", "200");
        user2.put("views", "400");

        HashMap<String,String> user3 = new HashMap<String, String>();
        user3.put("id", "3");
        user3.put("name", "Jim Harbaugh");
        user3.put("startdate", "2016-03-01,");
        user3.put("cpm", "$30.00");
        user3.put("clicks", "300");
        user3.put("views", "300");

        HashMap<String,String> user4 = new HashMap<String, String>();
        user4.put("id", "4");
        user4.put("name", "Robert Kraft");
        user4.put("startdate", "2016-03-01,");
        user4.put("cpm", "$40.00");
        user4.put("clicks", "400");
        user4.put("views", "200");

        HashMap<String,String> user5 = new HashMap<String, String>();
        user5.put("id", "5");
        user5.put("name", "Michael Phelps");
        user5.put("startdate", "2016-03-01,");
        user5.put("cpm", "$50.00");
        user5.put("clicks", "500");
        user5.put("views", "100");

        queryResult = new ArrayList<HashMap<String, String>>();
        queryResult.add(user1);
        queryResult.add(user2);
        queryResult.add(user3);
        queryResult.add(user4);
        queryResult.add(user5);


        mockSubstringResult = new ArrayList<String>();
        mockSubstringResult.add("Nick Saben");

        mockCPMResult = new ArrayList<String>();
        mockCPMResult.add("Robert Kraft");
        mockCPMResult.add("Michael Phelps");
    }

    @Test
    public void testGetNameWithHigherThanXClicks() throws Exception {
        App appObj = new App();
        ReadDB queryObj = mock(ReadDB.class);
        ReadDB mockQueryObj = spy(queryObj);
        doReturn(queryResult).when(mockQueryObj).makeQuery("hello");
        //when(queryObj.makeQuery("mockString")).thenReturn(queryResult);

        //setup list for mock referencing
        ArrayList<String> mockClickResult = new ArrayList<String>();
        mockClickResult.add("Jim Harbaugh");
        mockClickResult.add("Robert Kraft");
        mockClickResult.add("Michael Phelps");

        assertEquals(mockClickResult, appObj.getNameWithHigherThanXClicks(queryObj.makeQuery("mockString"), 200));
    }

    /*@Test
    public void getNameStartingWithSubstring() throws Exception {

        queryObj = mock(ReadDB.class);
        when(queryObj.makeQuery("mockString")).thenReturn(queryResult);

        queryResult = queryObj.makeQuery("/Users/majo/Documents/Ad-Juster Sample/ad_juster_data.db");
        assertEquals(mockSubstringResult, appObj.getNameStartingWithSubstring(queryResult, "ben"));
    }

    @Test
    public void getNameWithCPMHigherThanXDollars() throws Exception {

        queryObj = mock(ReadDB.class);
        when(queryObj.makeQuery("mockString")).thenReturn(queryResult);

        queryResult = queryObj.makeQuery("/Users/majo/Documents/Ad-Juster Sample/ad_juster_data.db");
        assertEquals(mockCPMResult, appObj.getNameWithCPMHigherThanXDollars(queryResult, 39.00));
    }*/

}