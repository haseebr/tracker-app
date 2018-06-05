package co.haseeb.trackerapp.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
public class Alert {

    @Id
    private String id;

//    @ManyToOne
//    @JoinColumn(name = "vin")
//    private Vehicle vehicle;

    private String vin;
    private String readingId;
    private String reason;
    @Enumerated(EnumType.STRING)
    private Priority priority;
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;

//    @ManyToOne
//    @JoinColumn(name = "alert_id")
//    private Reading reading;

    public Alert() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getReadingId() {
        return readingId;
    }

    public void setReadingId(String readingId) {
        this.readingId = readingId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Alert{" +
                "id='" + id + '\'' +
                ", vin='" + vin + '\'' +
                ", reading_id='" + readingId + '\'' +
                ", reason='" + reason + '\'' +
                ", priority=" + priority +
                ", time=" + time +
                '}';
    }
}
