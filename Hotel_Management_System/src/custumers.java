
public class custumers {

    String Fname;
    String Faddresss;
    String id_Proof;
    int Phone_number;
    String Nationality;
    String Gander;
    String Room_type;
    String Bed_type;
    String Price;
    String checkindate;
    String checkoutdate;
    String Email;

    public custumers(){

        super();
    }

    public custumers(String Fname,String Faddresss,String id_Proof, int Phone_number,String Nationality, String Gander, String Room_type, String Bed_type, String Price, String checkindate, String checkoutdate, String Email) {
        super();
        this.Fname = Fname;
        this.Faddresss = Faddresss;
        this.id_Proof = id_Proof;
        this.Phone_number = Phone_number;
        this.Nationality = Nationality;
        this.Gander = Gander;
        this.Room_type = Room_type;
        this.Bed_type = Bed_type;
        this.Price = Price;
        this.checkindate = checkindate;
        this.checkoutdate = checkoutdate;
        this.Email = Email;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public String getFaddresss() {
        return Faddresss;
    }

    public void setFaddresss(String Faddresss) {
        this.Faddresss = Faddresss;
    }

    public String getId_Proof() {
        return id_Proof;
    }

    public void setId_Proof(String id_Proof) {
        this.id_Proof = id_Proof;
    }

    public int getPhone_number() {
        return Phone_number;
    }

    public void setPhone_number(int Phone_number) {
        this.Phone_number = Phone_number;
    }

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String Nationality) {
        this.Nationality = Nationality;
    }

    public String getGander() {
        return Gander;
    }

    public void setGander(String Gander) {
        this.Gander = Gander;
    }

    public String getRoom_type() {
        return Room_type;
    }

    public void setRoom_type(String Room_type) {
        this.Room_type = Room_type;
    }

    public String getBed_type() {
        return Bed_type;
    }

    public void setBed_type(String Bed_type) {
        this.Bed_type = Bed_type;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public String getCheckindate() {
        return checkindate;
    }

    public void setCheckindate(String checkindate) {
        this.checkindate = checkindate;
    }

    public String getCheckoutdate() {
        return checkoutdate;
    }

    public void setCheckoutdate(String checkoutdate) {
        this.checkoutdate = checkoutdate;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

}
