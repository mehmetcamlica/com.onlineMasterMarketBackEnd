package manage;

public class ManageEsra {

    public static final String US032_INSERT_NOTIFICATIONS_PROVIDER = "INSERT INTO u201212290_onlinemasterqa.push_notification (subject, message, user_status, provider_status, status, updated_on, created_on)\n" +
            "SELECT\n" +
            "'Promosyon Duyurusu' as subject,\n" +
            "'Müsterilerinize Ozel İndirimler Sunun' as message,\n" +
            "0 as user_status,\n" +
            "1 as provider_status,\n" +
            "1 as status, \n" +
            "now() as updated_on, \n" +
            "now() as created_on\n" +
            "from u201212290_onlinemasterqa.providers;";

    public static final String US032_DINAMIC_INSERT_NOTIFICATIONS_PROVIDER = "INSERT INTO u201212290_onlinemasterqa.push_notification (subject, message, user_status, provider_status, status, updated_on, created_on) VALUES (?, ?, ?, ?, ?, NOW(), NOW())";

    public static final String US032_DINAMIC_DELETE_NOTIFICATIONS_PROVIDER = "DELETE FROM u201212290_onlinemasterqa.push_notification\n" +
            "WHERE created_on >= NOW() - INTERVAL 1 DAY;";

    public static final String US032_DELETE_NOTIFICATIONS_PROVIDER = "DELETE FROM u201212290_onlinemasterqa.push_notification\n" +
            "WHERE subject = 'Promosyon Duyurusu' \n" +
            "AND message = 'Müsterilerinize Ozel İndirimler Sunun'\n" +
            "AND user_status = 0\n" +
            "AND provider_status = 1\n" +
            "AND status = 1\n" +
            "AND updated_on >= NOW() - INTERVAL 1 DAY\n" +
            "AND created_on >= NOW() - INTERVAL 1 DAY;";

    public static final String US033_INSERT_NOTIFICATIONS_USER = "INSERT INTO u201212290_onlinemasterqa.push_notification (subject, message, user_status, provider_status, status, updated_on, created_on)\n" +
            "VALUES (?, ?, ?, ?, ?, NOW(), NOW()); ";

    public static final String US033_UPDATE_NOTIFICATIONS_USER = "UPDATE u201212290_onlinemasterqa.push_notification\n" +
            "SET user_status = 1\n" +
            "WHERE subject = 'System Maintenance';";


    public static final String US034_SELECT_PRODUCTS = "select product_name from u201212290_onlinemasterqa.products\n" +
            "where sale_price <= price * 0.8";


    public static final String US035_SELECT_REVENUE = "SELECT provider, SUM(amount) AS total_revenue\n" +
            "FROM u201212290_onlinemasterqa.revenue\n" +
            "group by provider\n" +
            "order by total_revenue DESC\n" +
            "LIMIT 1;";

}
