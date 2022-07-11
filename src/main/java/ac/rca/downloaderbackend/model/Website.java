package ac.rca.downloaderbackend.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.UUID;

@Entity
@Table(name="website")
public class Website {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private UUID id;

    @Column(name="website_name")
    private String websiteName;

    @Column(name="download_start_date_time")
    private String downloadStartTime;


    @Column(name="download_end_date_time")
    private String downloadEndTime;

    @Column(name="total_elapsed_time")
    private String elapsedTime;

    @Column(name="total_download_kilobytes")
    private int totalKilobytes;

    @OneToMany
    @JoinColumn(name = "website_id")
    ArrayList<Links> links;

    public Website() {
    }

    public Website(String websiteName, String downloadStartTime, String downloadEndTime, String elapsedTime, int totalKilobytes) {
        this.websiteName = websiteName;
        this.downloadStartTime = downloadStartTime;
        this.downloadEndTime = downloadEndTime;
        this.elapsedTime = elapsedTime;
        this.totalKilobytes = totalKilobytes;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getWebsiteName() {
        return websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    public String getDownloadStartTime() {
        return downloadStartTime;
    }

    public void setDownloadStartTime(String downloadStartTime) {
        this.downloadStartTime = downloadStartTime;
    }

    public String getDownloadEndTime() {
        return downloadEndTime;
    }

    public void setDownloadEndTime(String downloadEndTime) {
        this.downloadEndTime = downloadEndTime;
    }

    public String getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(String elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public int getTotalKilobytes() {
        return totalKilobytes;
    }

    public void setTotalKilobytes(int totalKilobytes) {
        this.totalKilobytes = totalKilobytes;
    }
}
