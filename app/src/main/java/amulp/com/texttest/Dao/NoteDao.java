package amulp.com.texttest.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import amulp.com.texttest.Models.Note;
import amulp.com.texttest.Util.Constants;

import java.util.List;

@Dao
public interface NoteDao {
    @Query("SELECT * FROM " + Constants.TABLE_NAME_NOTE)
    List<Note> getNote();

    @Insert
    long insertNote(Note note);

    @Update
    void updateNote(Note repos);

    @Delete
    void deleteNote(Note note);

    @Delete
    void deleteNotes(Note... note);
}
