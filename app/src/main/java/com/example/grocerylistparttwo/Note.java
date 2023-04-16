package com.example.grocerylistparttwo;

import java.io.Serializable;

public class Note implements Serializable {

    public String note, notice;
    public Boolean important;

    public Note(String note, String notice, Boolean important) {
        this.note = note;
        this.notice = notice;
        this.important = important;
    }

    public String getNote() {
        return note;
    }

    public String getNotice() {
        return notice;
    }

}
