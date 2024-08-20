package utilities.API_Utilities;

import java.util.HashMap;

public class TestData {
    HashMap<String, HashMap<String, Object>> reqBody = new HashMap<>();

    public HashMap<String, Object> blogRequestBody() {

        HashMap<String, Object> requestBody = new HashMap<>();

        requestBody.put("title", "New Blog");
        requestBody.put("category_id", 1);
        requestBody.put("summary", "Blog Summary.");
        requestBody.put("content", "Blog Content");

        return requestBody;
    }

    public HashMap<String, Object> requestBody(String folder) {

        reqBody.put("blog", blogRequestBody());
<<<<<<< HEAD
        return reqBody.get(folder);
    }
=======
        reqBody.put("coupon", couponRequestBody2());
        return reqBody.get(folder);
    }

    public HashMap<String, Object> couponRequestBody(int service_id, String coupon_name, int percentage, String start_date, int valid_days, int user_limit, String description) {

        HashMap<String, Object> requestBody = new HashMap<>();

        requestBody.put("service_id", service_id);
        requestBody.put("coupon_name", coupon_name);
        requestBody.put("percentage", percentage);
        requestBody.put("start_date", start_date);
        requestBody.put("valid_days", valid_days);
        requestBody.put("user_limit", user_limit);
        requestBody.put("description", description);

        return requestBody;

    }

    public HashMap<String, Object> couponRequestBody2(){

        HashMap<String, Object> requestBody = new HashMap<>();

        requestBody.put("service_id", 104);
        requestBody.put("coupon_name", "CPNNEW736");
        requestBody.put("percentage", 20);
        requestBody.put("start_date", "2024-07-17");
        requestBody.put("valid_days", 15);
        requestBody.put("user_limit", 10);
        requestBody.put("description", "Coupon Desc.");

        return requestBody;

    }

>>>>>>> main
}
