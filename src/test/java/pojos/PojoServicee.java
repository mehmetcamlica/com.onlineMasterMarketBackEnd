package pojos;




public class PojoServicee {

    private Integer shopId;
    private Integer staffId;
    private Integer duration;
    private String serviceTitle;
    private String category;
    private String subcategory;

    /**
     * No args constructor for use in serialization
     *
     */
    public PojoServicee() {
    }

    /**
     *
     * @param duration
     * @param serviceTitle
     * @param shopId
     * @param category
     * @param subcategory
     * @param staffId
     */
    public PojoServicee(Integer shopId, Integer staffId, Integer duration, String serviceTitle, String category, String subcategory) {
        super();
        this.shopId = shopId;
        this.staffId = staffId;
        this.duration = duration;
        this.serviceTitle = serviceTitle;
        this.category = category;
        this.subcategory = subcategory;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getServiceTitle() {
        return serviceTitle;
    }

    public void setServiceTitle(String serviceTitle) {
        this.serviceTitle = serviceTitle;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PojoService.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("shopId");
        sb.append('=');
        sb.append(((this.shopId == null)?"<null>":this.shopId));
        sb.append(',');
        sb.append("staffId");
        sb.append('=');
        sb.append(((this.staffId == null)?"<null>":this.staffId));
        sb.append(',');
        sb.append("duration");
        sb.append('=');
        sb.append(((this.duration == null)?"<null>":this.duration));
        sb.append(',');
        sb.append("serviceTitle");
        sb.append('=');
        sb.append(((this.serviceTitle == null)?"<null>":this.serviceTitle));
        sb.append(',');
        sb.append("category");
        sb.append('=');
        sb.append(((this.category == null)?"<null>":this.category));
        sb.append(',');
        sb.append("subcategory");
        sb.append('=');
        sb.append(((this.subcategory == null)?"<null>":this.subcategory));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}