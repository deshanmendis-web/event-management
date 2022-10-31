package event.bean;

import java.sql.Date;

public class eventBean {

    private String event_name;
    private String venue;
    private Date event_date;
    private Boolean isactive;
    private int catagoryid;

    public String getEventName() {
        return event_name;
    }

    public void setEventName(String event_name) {
        this.event_name = event_name;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public Date getEventDate() {
        return event_date;
    }

    public void setEventDate(Date event_date) {
        this.event_date = event_date;
    }

    public Boolean getIsActive() {
        return isactive;
    }

    public void setIsActive(Boolean isactive) {
        this.isactive = isactive;
    }

    public int getCatagoryId() {
        return catagoryid;
    }

    public void setCatagoryId(int catagoryid) {
        this.catagoryid = catagoryid;
    }
}
