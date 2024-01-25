package ATM;

import java.util.ArrayList;
import java.util.List;

public class User {

    public String id;
    public String pin;
    public List<Transaction> transactions;
    public User(String id,String pin){
        this.id = id;
        this.pin = pin;

    }



    public String getId(){
        return id;
    }

    public String getPin(){
        return pin;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setPin(String pin){
        this.pin = pin;
    }


}
