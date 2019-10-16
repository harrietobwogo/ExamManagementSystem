package model.examsmodule;

import javax.persistence.*;

/**
 * Created by Harriet on 10/8/2019.
 */
@Entity
@Table(name = "tbl_endpoint_urls")
public class EndPointUrls {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated
    private EndPoint endPoint;
    private String url;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public EndPoint getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(EndPoint endPoint) {
        this.endPoint = endPoint;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

