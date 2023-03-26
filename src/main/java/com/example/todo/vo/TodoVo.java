package com.example.todo.vo;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="todo")
public class TodoVo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seq;
    private String content;
    @Column(columnDefinition="DATETIME default CURRENT_TIMESTAMP")
    private LocalDateTime date;
    private boolean done;

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @PrePersist
    public void prePersist() {
        this.date = LocalDateTime.now();
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "TodoVo{" +
                "seq=" + seq +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", done=" + done +
                '}';
    }
}
