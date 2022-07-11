package ac.rca.downloaderbackend.model;


import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="link")
public class Links {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "website_id", insertable = false, updatable = false)
    private Website website;
    @Column(name="link_name")
    private String linkName;

    @Column(name="total_elapsed_time")
    private String elapsedTime;

    @Column(name="total_download_kilobytes")
    private String totalKilobytes;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getlinkName() {
        return linkName;
    }

    public void setlinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(String elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public String getTotalKilobytes() {
        return totalKilobytes;
    }

    public void setTotalKilobytes(String totalKilobytes) {
        this.totalKilobytes = totalKilobytes;
    }
}
