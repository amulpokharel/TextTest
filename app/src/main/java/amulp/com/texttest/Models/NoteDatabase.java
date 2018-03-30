package amulp.com.texttest.Models;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import amulp.com.texttest.Dao.NoteDao;
import amulp.com.texttest.Util.Constants;
import amulp.com.texttest.Util.DateRoomConverter;

@Database(entities = {Note.class}, version = 1)
@TypeConverters({DateRoomConverter.class})
public abstract class NoteDatabase extends RoomDatabase{

    public abstract NoteDao getNoteDao();

    private static NoteDatabase noteDB;

    public static NoteDatabase getInstance(Context context){
        if (noteDB == null){
            noteDB = buildDatabaseInstance(context);
        }

        return noteDB;
    }

    private static NoteDatabase buildDatabaseInstance(Context context){
        return Room.databaseBuilder(context, NoteDatabase.class, Constants.DB_NAME).allowMainThreadQueries().build();
    }

    public void cleanUp(){
        noteDB = null;
    }
}
