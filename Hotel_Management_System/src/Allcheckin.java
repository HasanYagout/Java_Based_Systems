/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MAMON ALMASWRI
 */
public class Allcheckin {

     int id;
    String name;
    String address;
    String Id_Proof;
    int Phone_number;
    String Nationality;
    String Gander;
    String Room_type;
    String Bed_type;
    int Price;
    String Check_in_date;
   
    String Email;
    String Activation;
    String Room_number;
    
    
    
     public Allcheckin (){

        super();
    }
    
    
     public Allcheckin(/*int id,*/ String name, String address, String Id_Proof, int Phone_number, String Nationality, String Gander, String Room_type, String Bed_type, int Price, String Check_in_date, String Email, String Activation, String Room_number) {
        //this.id = id;
        this.name = name;
        this.address = address;
        this.Id_Proof = Id_Proof;
        this.Phone_number = Phone_number;
        this.Nationality = Nationality;
        this.Gander = Gander;
        this.Room_type = Room_type;
        this.Bed_type = Bed_type;
        this.Price = Price;
        this.Check_in_date = Check_in_date;
        this.Email = Email;
        this.Activation = Activation;
        this.Room_number = Room_number;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setId_Proof(String Id_Proof) {
        this.Id_Proof = Id_Proof;
    }

    public void setPhone_number(int Phone_number) {
        this.Phone_number = Phone_number;
    }

    public void setNationality(String Nationality) {
        this.Nationality = Nationality;
    }

    public void setGander(String Gander) {
        this.Gander = Gander;
    }

    public void setRoom_type(String Room_type) {
        this.Room_type = Room_type;
    }

    public void setBed_type(String Bed_type) {
        this.Bed_type = Bed_type;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public void setCheck_in_date(String Check_in_date) {
        this.Check_in_date = Check_in_date;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setActivation(String Activation) {
        this.Activation = Activation;
    }

    public void setRoom_number(String Room_number) {
        this.Room_number = Room_number;
    }
    

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getId_Proof() {
        return Id_Proof;
    }

    public int getPhone_number() {
        return Phone_number;
    }

    public String getNationality() {
        return Nationality;
    }

    public String getGander() {
        return Gander;
    }

    public String getRoom_type() {
        return Room_type;
    }

    public String getBed_type() {
        return Bed_type;
    }

    public int getPrice() {
        return Price;
    }

    public String getCheck_in_date() {
        return Check_in_date;
    }

    public String getEmail() {
        return Email;
    }

    public String getActivation() {
        return Activation;
    }

    public String getRoom_number() {
        return Room_number;
    }

   
    
    
}
