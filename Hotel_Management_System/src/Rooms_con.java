public class Rooms_con {
    int room_number,price;
    String room_type, bed_type,status;

    public int getRoom_number() {
        return room_number;
    }

    public void setRoom_number(int room_number) {
        this.room_number = room_number;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public String getBed_type() {
        return bed_type;
    }

    public void setBed_type(String bed_type) {
        this.bed_type = bed_type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Rooms_con(int room_number,String room_type , String bed_type,int price, String status) {
        this.room_number = room_number;
        this.price = price;
        this.room_type = room_type;
        this.bed_type = bed_type;
        this.status = status;
    }


}
