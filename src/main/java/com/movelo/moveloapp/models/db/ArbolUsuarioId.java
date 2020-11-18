package com.movelo.moveloapp.models.db;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ArbolUsuarioId implements Serializable {
    @Column(name = "book_id")
    private Integer bookId;

    @Column(name = "publisher_id")
    private Integer publisherId;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public ArbolUsuarioId(Integer bookId, Integer publisherId) {
        this.bookId = bookId;
        this.publisherId = publisherId;
    }

    public ArbolUsuarioId() {
    }

}
