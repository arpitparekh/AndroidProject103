package arpitparekh.verylateandroidbatch.firebase_realtime_storage;

import java.io.Serializable;

public class Note implements Serializable {

    String title;
    String body;

    public Note(){

    }

    public Note(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "title= " + title +
                "\nbody= " + body;
    }
}
