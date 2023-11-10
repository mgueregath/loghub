/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.domain.mailing.entity;

import java.util.Date;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class Email {

    private long id;
    private String to;
    private String subject;
    private String content;
    private Date date;
    private String name;
    private Boolean sent;

    public Email() {
    }

    public Email(String to, String subject, String content, String name) {
        this.to = to;
        this.subject = subject;
        this.content = content;
        this.date = new Date();
        this.name = name;
        this.sent = true;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the to
     */
    public String getTo() {
        return to;
    }

    /**
     * @param to the to to set
     */
    public void setTo(String to) {
        this.to = to;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the sent
     */
    public Boolean getSent() {
        return sent;
    }

    /**
     * @param sent the sent to set
     */
    public void setSent(Boolean sent) {
        this.sent = sent;
    }
}
