package shivam.happeningapp3;


public class mytimetable {

    private int _id;
    private String _day;
    private String _date;
    private String _time;
    private String _task;

    public mytimetable(String _day, String _date, String _time, String _task) {
        this._day = _day;
        this._date = _date;
        this._task = _task;
        this._time = _time;
    }

    public void set_date(String _date) {
        this._date = _date;
    }

    public void set_day(String _day) {
        this._day = _day;
    }

    public void set_time(String _time) {
        this._time = _time;
    }

    public void set_task(String _task) {
        this._task = _task;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_date() {
        return _date;
    }

    public String get_day() {
        return _day;
    }

    public int get_id() {
        return _id;
    }

    public String get_task() {
        return _task;
    }

    public String get_time() {
        return _time;
    }
}
