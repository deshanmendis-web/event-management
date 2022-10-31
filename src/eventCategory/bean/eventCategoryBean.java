package eventCategory.bean;

public class eventCategoryBean {

    private int categoryid;
    private String catagory_name;
    private String catagory_desc;

    public String getCatagory_name() {
        return catagory_name;
    }

    public void setCatagory_name(String catagory_name) {
        this.catagory_name = catagory_name;
    }

    public String getCatagory_desc() {
        return catagory_desc;
    }

    public void setCatagory_desc(String catagory_desc) {
        this.catagory_desc = catagory_desc;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }
}
