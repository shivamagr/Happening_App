package shivam.happeningapp3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBManager extends SQLiteOpenHelper{

    private static String DATABASE_NAME = "mydb.db";
    private static int DATABASE_VERSION = 1;
    private static String TABLE_NAME = "timetable";
    private static String COLUMN1_ID = "_id";
    private static String COLUMN1_DAY = "day";
    private static String COLUMN1_DATE= "date";
    private static String COLUMN1_TIME = "time";
    private static String COLUMN1_TASK = "task";

    private static String TABLE2_NAME = "profdetails";
    private static String COLUMN2_ID = "_2id";
    private static String COLUMN2_NAME = "profname";
    private static String COLUMN2_EMAIL = "profmail";
    private static String COLUMN2_LOC = "proflocation";
    private static String COLUMN2_RESEARCH = "profresearch";
    private static String COLUMN2_PHONE = "phonenumber";
    private static String COLUMN2_DISCRIPTION = "discription";


    public DBManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_NAME + "( "
                + COLUMN1_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN1_DAY + " TEXT, " + COLUMN1_DATE + " TEXT, "
                + COLUMN1_TIME + " TEXT, " + COLUMN1_TASK + " TEXT "
                + " );";
        db.execSQL(query);
        String string = " CREATE TABLE " + TABLE2_NAME + " ( "
                + COLUMN2_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN2_NAME + " TEXT, " + COLUMN2_EMAIL + " TEXT, "
                + COLUMN2_LOC + " TEXT, " + COLUMN2_RESEARCH + " TEXT, "
                + COLUMN2_PHONE + " TEXT, " + COLUMN2_DISCRIPTION  + " TEXT "
                + " );";
        db.execSQL(string);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXIST " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXIST " + TABLE2_NAME);
        onCreate(db);

    }

    public void addtimetable(mytimetable tb) {
        ContentValues values = new ContentValues();
        SQLiteDatabase db = getWritableDatabase();
        values.put(COLUMN1_DAY, tb.get_day());
        values.put(COLUMN1_DATE, tb.get_date());
        values.put(COLUMN1_TIME, tb.get_time());
        values.put(COLUMN1_TASK, tb.get_task());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public String databasetostring(){

        String dbString = "day  , date  , time,  task \n";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE 1";

        //Cursor points to a location in your results
        Cursor c = db.rawQuery(query, null);
        //Move to the first row in your results
        c.moveToFirst();

        //Position after the last row means the end of the results
        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("day")) != null) {
                dbString += c.getString(c.getColumnIndex("day"))+" , "+c.getString(c.getColumnIndex("date"))+" , "
                            + c.getString(c.getColumnIndex("time"))+" , "+c.getString(c.getColumnIndex("task"));
                dbString += "\n";
            }
            c.moveToNext();
        }
        db.close();
        return dbString;
    }

    public void deletetimetable()
    {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME + ";");
        onCreate(db);
        db.close();
    }

    public void adddisc(DetailsSyntex ds)
    {
        ContentValues values = new ContentValues();
        SQLiteDatabase db = getWritableDatabase();
        values.put(COLUMN2_NAME, ds.get_name());
        values.put(COLUMN2_EMAIL, ds.get_email());
        values.put(COLUMN2_LOC, ds.get_location());
        values.put(COLUMN2_RESEARCH, ds.get_researcharea());
        values.put(COLUMN2_PHONE, ds.get_phone());
        values.put(COLUMN2_DISCRIPTION, ds.get_discription());
        db.insert(TABLE2_NAME, null, values);
        db.close();
    }

    public String showprofdetail(String s)
    {
        String detail = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE2_NAME + " WHERE " + COLUMN2_NAME + " = \""+ s + "\"";
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("proflocation")) != null) {
                detail += c.getString(c.getColumnIndex("profmail"))+" ;\n "+c.getString(c.getColumnIndex("phonenumber"))+" ;\n "
                        + c.getString(c.getColumnIndex("proflocation"))+" \n "+c.getString(c.getColumnIndex("profresearch"))
                        + "\n" + c.getString(c.getColumnIndex("discription"));
                detail += "\n";
            }
            c.moveToNext();
        }
        db.close();
        return detail;
    }

    public String findprof(String string)
    {
        String nameofprof = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT profname FROM " + TABLE2_NAME + " WHERE " + COLUMN2_RESEARCH + " = \""+ string + "\"";
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("profname")) != null) {
                nameofprof += c.getString(c.getColumnIndex("profname"));
                nameofprof +="\n";
            }
            c.moveToNext();
        }
        db.close();
        return nameofprof;
    }

}
