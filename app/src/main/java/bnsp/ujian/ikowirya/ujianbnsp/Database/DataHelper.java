package bnsp.ujian.ikowirya.ujianbnsp.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "BIOADATA";
    private static final int DATABASE_VERSION = 1;

    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE biodata(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "NAMA VARCHAR(20), NOMOR VARCHAR(12), " +
                "TANGGAL_LAHIR VARCHAR(10),ALAMAT TEXT, JENIS_KELAMIN VARCHAR(20))";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
