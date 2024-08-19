package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PojoService {

    /*
    {
    "shop_id": 10,
    "staff_id": 41,
    "duration":60,
    "service_title":"Test Service",
    "category": "Repairs & Maintenance",
    "subcategory":"Handyman Services",
    "service_amount": 150,
    "about":"Test Service Description New Service etc."
}
     */

    private int shop_id;
    private int staff_id;
    private int duration;
    private String service_title;
    private String category;
    private String subcategory;
    private int service_amount;
    private String about;
}