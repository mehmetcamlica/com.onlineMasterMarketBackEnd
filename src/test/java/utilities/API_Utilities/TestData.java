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
        return reqBody.get(folder);
    }
}
