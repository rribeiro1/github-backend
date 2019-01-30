package com.vanhack.github.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Repo {

    @Id
    private Long id;

    @Column
    private String url;

    protected Repo() {}

    private Repo(Long id, String url) {
        this.id = id;
        this.url = url;
    }

    public static Repo of(Long id, String url) {
        return new Repo(id, url);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
