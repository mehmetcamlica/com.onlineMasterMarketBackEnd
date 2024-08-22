package pojos;

import java.io.Serializable;

public class AddServicepojo implements Serializable {
	private int shop_id;
	private int staff_id;
	private int duration;
	private String service_title;
	private String category;
	private String subcategory;
	private int service_amount;
	private String about;

	public void setShopId(int shopId){
		this.shop_id = shopId;
	}

	public int getShopId(){
		return shop_id;
	}

	public void setStaffId(int staffId){
		this.staff_id = staffId;
	}

	public int getStaffId(){
		return staff_id;
	}

	public void setDuration(int duration){
		this.duration = duration;
	}

	public int getDuration(){
		return duration;
	}

	public void setServiceTitle(String serviceTitle){
		this.service_title = serviceTitle;
	}

	public String getServiceTitle(){
		return service_title;
	}

	public void setCategory(String category){
		this.category = category;
	}

	public String getCategory(){
		return category;
	}

	public void setSubcategory(String subcategory){
		this.subcategory = subcategory;
	}

	public String getSubcategory(){
		return subcategory;
	}

	public void setServiceAmount(int serviceAmount){
		this.service_amount = serviceAmount;
	}

	public int getServiceAmount(){
		return service_amount;
	}

	public void setAbout(String about){
		this.about = about;
	}

	public String getAbout(){
		return about;
	}

	@Override
 	public String toString(){
		return 
			"AddServicepojo{" + 
			"shop_id = '" + shop_id + '\'' +
			",staff_id = '" + staff_id + '\'' +
			",duration = '" + duration + '\'' + 
			",service_title = '" + service_title + '\'' +
			",category = '" + category + '\'' + 
			",subcategory = '" + subcategory + '\'' + 
			",service_amount = '" + service_amount + '\'' +
			",about = '" + about + '\'' + 
			"}";
		}

	public AddServicepojo(int shopId, int staffId, int duration, String serviceTitle, String category, String subcategory, int serviceAmount, String about) {
		this.shop_id = shopId;
		this.staff_id = staffId;
		this.duration = duration;
		this.service_title = serviceTitle;
		this.category = category;
		this.subcategory = subcategory;
		this.service_amount = serviceAmount;
		this.about = about;
	}

	public AddServicepojo() {

	}
}