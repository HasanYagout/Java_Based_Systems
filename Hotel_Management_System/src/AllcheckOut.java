/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MAMON ALMASWRI
 */
public class AllcheckOut {

  
   
    
    
    String Name;
    int Phone_number;
    String Email;
    String checkindate;
    String checkoutdate;
    int Price;
    
    
    public  AllcheckOut(){
        
          super();
    }
    
     public AllcheckOut(String Name, int Phone_number, String Email, String checkindate, String checkoutdate, int Price) {
        this.Name = Name;
        this.Phone_number = Phone_number;
        this.Email = Email;
        this.checkindate = checkindate;
        this.checkoutdate = checkoutdate;
        this.Price = Price;
    }
      public void setName(String Name) {
        this.Name = Name;
    }

    public void setPhone_number(int Phone_number) {
        this.Phone_number = Phone_number;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setCheckindate(String checkindate) {
        this.checkindate = checkindate;
    }

    public void setCheckoutdate(String checkoutdate) {
        this.checkoutdate = checkoutdate;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public String getName() {
        return Name;
    }

    public int getPhone_number() {
        return Phone_number;
    }

    public String getEmail() {
        return Email;
    }

    public String getCheckindate() {
        return checkindate;
    }

    public String getCheckoutdate() {
        return checkoutdate;
    }

    public int getPrice() {
        return Price;
    }

}
