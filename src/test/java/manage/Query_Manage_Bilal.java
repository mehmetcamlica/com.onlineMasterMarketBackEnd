package manage;

public class Query_Manage_Bilal {

    private String query_US_012 = "SELECT shop_id, COUNT(*) AS service_count FROM book_service GROUP BY shop_id ORDER BY service_count DESC LIMIT 1";
    private String query_US_014 = "SELECT gender_type, category_type, COUNT(*) AS category_count FROM categories GROUP BY gender_type, category_type";
    private String query_US_015 = "SELECT MAX(created_at) AS newest_creation_date, MIN(created_at) AS oldest_creation_date FROM categories";
    private String query_US_013 = "SELECT A.provider_id AS provider1, B.provider_id AS provider2, A.day,GREATEST (A.from_time, B.from_time) AS overlap_start,LEAST (A.to_time, B.to_time) AS overlap_end FROM(SELECT provider_id, JSON_UNQUOTE (JSON_EXTRACT(availability,'$[0].day')) AS day, JSON_UNQUOTE (JSON_EXTRACT(availability,'$[0].from_time')) AS from_time, JSON_UNQUOTE (JSON_EXTRACT(availability,'$[0].to_time')) AS to_time FROM u201212290_onlinemasterqa.business_hours) AS A JOIN(SELECT provider_id, JSON_UNQUOTE (JSON_EXTRACT(availability,'$[0].day')) AS day, JSON_UNQUOTE (JSON_EXTRACT(availability,'$[0].from_time')) AS from_time, JSON_UNQUOTE (JSON_EXTRACT(availability,'$[0].to_time')) AS to_time FROM u201212290_onlinemasterqa.business_hours) AS B ON A.day = B.day AND A.provider_id < B.provider_id WHERE GREATEST (A.from_time,B.from_time)<LEAST (A.to_time,B.to_time)";

        // ********************************** Getter  ************************************

    public String getQuery_US_012() {
        return query_US_012;
    }

    public String getQuery_US_014() {
        return query_US_014;
    }

    public String getQuery_US_015() {
        return query_US_015;
    }

    public String getQuery_US_013() {
        return query_US_013;
    }
}
