package unpad.aftismo.model;

public class BookResult {
    private long book_id;
    private int book_status;
    private float book_price;
    private String book_tutor, book_address, book_by, book_tutorloc, book_date, book_time, user_phone, tutor_phone;

    public BookResult() {
    }

    public String getBook_tutorloc() {
        return book_tutorloc;
    }

    public void setBook_tutorloc(String book_tutorloc) {
        this.book_tutorloc = book_tutorloc;
    }

    public BookResult(long book_id, int book_status, float book_price, String book_tutor, String book_address, String book_by, String book_tutorloc, String book_date, String book_time, String user_phone, String tutor_phone) {

        this.book_id = book_id;
        this.book_status = book_status;
        this.book_price = book_price;
        this.book_tutor = book_tutor;
        this.book_address = book_address;
        this.book_by = book_by;
        this.book_tutorloc = book_tutorloc;
        this.book_date = book_date;
        this.book_time = book_time;
        this.user_phone = user_phone;
        this.tutor_phone = tutor_phone;
    }

    public String getTutor_phone() {
        return tutor_phone;
    }

    public void setTutor_phone(String tutor_phone) {
        this.tutor_phone = tutor_phone;
    }

    public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }

    public int getBook_status() {
        return book_status;
    }

    public void setBook_status(int book_status) {
        this.book_status = book_status;
    }

    public float getBook_price() {
        return book_price;
    }

    public void setBook_price(float book_price) {
        this.book_price = book_price;
    }

    public String getBook_tutor() {
        return book_tutor;
    }

    public void setBook_tutor(String book_tutor) {
        this.book_tutor = book_tutor;
    }

    public String getBook_address() {
        return book_address;
    }

    public void setBook_address(String book_address) {
        this.book_address = book_address;
    }

    public String getBook_by() {
        return book_by;
    }

    public void setBook_by(String book_by) {
        this.book_by = book_by;
    }

    public String getBook_date() {
        return book_date;
    }

    public void setBook_date(String book_date) {
        this.book_date = book_date;
    }

    public String getBook_time() {
        return book_time;
    }

    public void setBook_time(String book_time) {
        this.book_time = book_time;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }
}
