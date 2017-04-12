package com.demo;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * @author LocInt
 */
@Entity(name = "news")
public class News implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Date created;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public News(String subject, String content, LocalDate created) {
        this.subject = subject;
        this.content = content;
        this.created = java.sql.Date.valueOf(created);
    }

    public News(Long id, String subject, String content, LocalDate created) {
        this.id = id;
        this.subject = subject;
        this.content = content;
        this.created = java.sql.Date.valueOf(created);
    }

    public News() {

    }


}
