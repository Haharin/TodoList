package dao;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity //сущность - тип класса, который может работать с базой данных
@Table(name = "Mainlist", schema = "JAVA_TASK")
public class Mainlist {
    private Long mainId;
    private Set<Addlist> addlists = null;
    private String name;
    private LocalDateTime dateTime;
    private String description;
    private Boolean importance;
    private Long period;
    private Boolean notification;

public Mainlist(){

}

    public Mainlist(Long mainId, String name,  String description, Boolean importance, Long period, Boolean notification) {
        this.mainId = mainId;
        this.name = name;
        this.description = description;
        this.importance = importance;
        this.period = period;
        this.notification = notification;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    public Long getMainId() {
        return mainId;
    }
    public void setMainId(Long mainId) {
        this.mainId = mainId;
    }

    @Column(name = "Name", length = 32, nullable = false, unique = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "DATE_TIME", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
  //@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTimeAsString")
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }


    @Column(name = "Description", length = 32, nullable = false, unique = false)
    public String getDescriotion() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "Importance", length = 32, nullable = false, unique = false)
    public Boolean getImportance() {
        return importance;
    }
    public void setImportance(Boolean importance) {
        this.importance = importance;
    }

    @Column(name = "Period", length = 32, nullable = false, unique = false)
    public Long getPeriod() {
        return period;
    }
    public void setPeriod(Long period) {
        this.period = period;
    }

    @Column(name = "Notification", length = 32, nullable = false, unique = false)
    public Boolean getNotification() {
        return notification;
    }
    public void setNotification(Boolean notification) {
        this.notification = notification;
    }
    public void setDescriotion(String descriotion) {
        this.description = descriotion;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("mainId", mainId)
                .append("addlists", addlists)
                .append("name", name)
                .append("descriotion", description)
                .append("importance", importance)
                .append("period", period)
                .append("notification", notification)
                .toString();
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "mainlist")
    public Set<Addlist> getAddlists() {
        return addlists;
    }

    public void setAddlists(Set<Addlist> addlists) {
        this.addlists = addlists;
    }
}

