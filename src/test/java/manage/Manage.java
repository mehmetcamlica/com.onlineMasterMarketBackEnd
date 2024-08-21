package manage;

import lombok.Getter;

@Getter
public class Manage {

  private String US04insert_data_administrator="INSERT INTO u201212290_onlinemasterqa.administrators ( email, password, username, full_name, profile_img, role, token) \n" +
          "VALUES (?,?,?,?,?,?,?);";

  private String US04getLastUserIdAdministrator="Select user_id From u201212290_onlinemasterqa.administrators Where email=?;";
  private String US04delete_added_data_administrator="Delete From u201212290_onlinemasterqa.administrators Where user_id=?;";
  private String US5update_data_administrator="UPDATE u201212290_onlinemasterqa.administrators SET password = SHA2(?, 256) WHERE user_id = ?;";
  private String US19contact_reply_message="INSERT INTO u201212290_onlinemasterqa.contact_reply (contact_id, name, reply, created_at)\n" +
          "SELECT id AS contact_id, name, \n" +
          "       CASE\n" +
          "           WHEN message LIKE '%servis%' THEN 'Servis oluşturma hakkında size nasıl yardımcı olabiliriz?'\n" +
          "           ELSE 'Mesajınızı aldık ve en kısa sürede geri döneceğiz.'\n" +
          "       END AS reply, \n" +
          "       NOW() AS created_at\n" +
          "FROM u201212290_onlinemasterqa.contact_form_details;";

  private String US25_service_coupons_user_limit="SELECT * FROM  u201212290_onlinemasterqa.service_coupons WHERE user_limit_count >= user_limit;";

  private String US27_incomplated_data_insert_users_table="INSERT INTO u201212290_onlinemasterqa.users (mobileno, country_code, currency_code, status, usertype) VALUES (?, ?, ?,?,?);";

  public String getUS04insert_data_administrator() {
    return US04insert_data_administrator;
  }

  public String getUS04getLastUserIdAdministrator() {
    return US04getLastUserIdAdministrator;
  }

  public String getUS04delete_added_data_administrator() {
    return US04delete_added_data_administrator;
  }

  public String getUS5update_data_administrator() {
    return US5update_data_administrator;
  }

  public String getUS19contact_reply_message() {
    return US19contact_reply_message;
  }

  public String getUS25_service_coupons_user_limit() {
    return US25_service_coupons_user_limit;
  }

  public String getUS27_incomplated_data_insert_users_table() {
    return US27_incomplated_data_insert_users_table;
  }
}