/**
 * Created by Наташа on 30.03.2017.
 */
package dao;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.Set;

@Entity //сущность - тип класса, который может работать с базой данных
@Table(name = "Addlist", schema = "JAVA_TASK")
public class Addlist {
    private Long addId;
    private Mainlist mainlist;
    private Long mainlistId;
    private String addName;
    private String addDescription;

    public Addlist() {
    }
    public Addlist(Long addId, Mainlist mainlist, String addName, String addDescription) {
        this.addId = addId;
        this.mainlist = mainlist;
        this.addName = addName;
        this.addDescription = addDescription;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    public Long getAddId() {
        return addId;
    }

    public void setAddId(Long addId) {
        this.addId = addId;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MAIN_ID", nullable = false)
    public Mainlist getMainlist() {
        return mainlist;
    }

    public void setMainlist(Mainlist mainlist) {this.mainlist = mainlist;}

    @Transient
    public Long getMainlistId() {
        return mainlistId;
    }

    public void setMainlistId(Long mainlist) {
        this.mainlistId =mainlist;
    }

    @Column(name = "ADD_NAME", length = 32, nullable = false, unique = false)
    public String getAddName() {
        return addName;
    }

    public void setAddName(String addName) {
        this.addName = addName;
    }

    @Column(name = "DESCRIPTION", length = 32, nullable = false, unique = false)
    public String getAddDescription() {
        return addDescription;
    }

    public void setAddDescription(String addDescription) {
        this.addDescription = addDescription;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("addId", addId)
                .append("addName", addName)
                .append("addDescription", addDescription)
                .toString();
    }

}