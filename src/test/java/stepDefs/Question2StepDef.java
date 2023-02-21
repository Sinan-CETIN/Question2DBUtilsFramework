package stepDefs;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import utils.DBUtils;

import java.util.List;
import java.util.Map;

public class Question2StepDef {
    private static int count = 0;


    @Given("{string} {string} \"{double} should match the DB query resultset")
    public void should_match_the_db_query_resultset(String monthname, String fullname, Double amount) {

        String query = "SELECT TO_CHAR(payment_date, 'Month') AS monthname ,  CONCAT(s.first_name,' ',s.last_name) AS fullname,\n" +
                "SUM(amount) AS total_amount\n" +
                "FROM payment p \n" +
                "INNER JOIN staff s ON s.staff_id = p.staff_id\n" +
                "GROUP BY EXTRACT(MONTH FROM payment_date), p.staff_id, TO_CHAR(payment_date, 'Month'),CONCAT(s.first_name,' ',s.last_name)\n" +
                "ORDER BY EXTRACT(MONTH FROM payment_date), p.staff_id;\n";

        List<Map<String, Object>> queryResultMapList = DBUtils.getQueryResultMap(query);
        Map<String, Object> rowValues = queryResultMapList.get(count++);
        Assert.assertEquals(rowValues.get("monthname").toString().trim(), monthname);
        Assert.assertEquals(rowValues.get("fullname").toString().trim(), fullname);
        Assert.assertTrue(rowValues.get("total_amount").toString().contains(amount + ""));

    }
}
