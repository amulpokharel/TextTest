package amulp.com.texttest.Util;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

public class DateRoomConverter {

    @TypeConverter
    public static Date toDate(Long value){
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long toDate(Date value){
        return value == null ? null : value.getTime();
    }
}
