package manage;

import lombok.Getter;

public class ManageGokcen {
 private String US036_addingto_chat_table="Insert into u201212290_onlinemasterqa.chat_table (sender_token, receiver_token, message, status, read_status, utc_date_time, created_at) " +
         "values(?,?,?,?,?,?,?);";



 private String US037_readStatus="Select * from u201212290_onlinemasterqa.chat_table\n" +
         "WHERE read_status=1;";



 private String US038_listingMessagesBetweenDates="Select id,email,message,created_at FROM contact_form_details\n" +
         "Where created_at between '2024-08-01' AND '2024-08-10';";



 private String US039_listingEmployeesCreatedinAugust= "Select distinct first_name from employee_basic_details\n" +
         "Where created_at between '2024-08-01' and '2024-09-01' AND first_name NOT LIKE '%updated%' and first_name NOT LIKE '%test%';";

 public String getUS036_addingto_chat_table() {
  return US036_addingto_chat_table;
 }
 public String getUS037_readStatus() {
  return US037_readStatus;

 }
 public String getUS038_listingMessagesBetweenDates() {
  return US038_listingMessagesBetweenDates;
 }
 public String getUS039_listingEmployeesCreatedinAugust() {
  return US039_listingEmployeesCreatedinAugust;
 }
}
