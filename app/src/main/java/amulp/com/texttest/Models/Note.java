package amulp.com.texttest.Models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import amulp.com.texttest.Util.Constants;

import java.io.Serializable;
import java.util.Date;

@Entity(tableName = Constants.TABLE_NAME_NOTE)
public class Note implements Serializable{

    @PrimaryKey(autoGenerate = true)
    private long noteId;

    @ColumnInfo(name = "note_content")
    private String content;

    private String title;

    private Date date;

    @Ignore
    public Note(){}

    public Note(String content, String title){
        this.content = content;
        this.title = title;
        this.date = new Date(System.currentTimeMillis());
    }

    public long getNoteId(){
        return noteId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setNoteId(long noteId) {
        this.noteId = noteId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Note)) return false;

        Note note = (Note) o;

        if (noteId != note.getNoteId()) return false;
        return title != null ? title.equals(note.getTitle()) :                  note.getTitle() == null;
    }



    @Override
    public int hashCode() {
        int result = (int)noteId;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Note{" +
                "note_id=" + noteId +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                ", date=" + date +
                '}';
    }
}
