package shivam.happeningapp3;


public class DetailsSyntex {

    private int _id;
    private String _name;
    private String _email;
    private String _location;
    private String _researcharea;
    private String _phone;
    private String _discription;

    public DetailsSyntex(String _name, String _email, String _location, String _researcharea, String _phone, String _discription) {
        this._discription = _discription;
        this._email = _email;
        this._location = _location;
        this._name = _name;
        this._phone = _phone;
        this._researcharea = _researcharea;
    }

    public String get_discription() {
        return _discription;
    }

    public String get_email() {
        return _email;
    }

    public int get_id() {
        return _id;
    }

    public String get_location() {
        return _location;
    }

    public String get_name() {
        return _name;
    }

    public String get_phone() {
        return _phone;
    }

    public String get_researcharea() {
        return _researcharea;
    }

    public void set_discription(String _discription) {
        this._discription = _discription;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_location(String _location) {
        this._location = _location;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public void set_phone(String _phone) {
        this._phone = _phone;
    }

    public void set_researcharea(String _researcharea) {
        this._researcharea = _researcharea;
    }
}
