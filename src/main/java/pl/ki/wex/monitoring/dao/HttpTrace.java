package pl.ki.wex.monitoring.dao;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "htpp_trace")
public class HttpTrace implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "trace")
    private String trace;

    public HttpTrace() {
    }

    public HttpTrace(String trace) {
        this.trace = trace;
    }

    public HttpTrace(Integer id, String trace) {
        this.id = id;
        this.trace = trace;
    }

    public Integer getId() {
        return id;
    }

    public String getTrace() {
        return trace;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTrace(String trace) {
        this.trace = trace;
    }
}
