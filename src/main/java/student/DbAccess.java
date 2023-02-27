/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student;

import com.mycompany.sample.Sample;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author shanu
 */
public class DbAccess {

    static Sample s = new Sample();
    static ArrayList<String> Account = new ArrayList<>();

    void NewUser(ArrayList<String> data) {
        String col = "Accounts";
        s.InsetProfile(col, data);
    }

    public List<String> IsAUser(String name, String password) {

        String col = "Accounts";

        List<List<String>> t;

        t = s.pullOneData("Name", name, "Accounts");

        for (int i = 0; i < t.size(); i++) {
            List<String> outer = t.get(i);

//                System.out.println(outer);
            if (password.equals(outer.get(5))) {
                return outer;
            }
        }

        return null;
    }

    public void TicketStore(String data[]) {
        s.InsertTicker(data, "Tickets");
    }
    
    public void UpdateName(String adhaar,String newN){
        s.update("Phone", adhaar, "Adhaar", newN);
    }
    
    public void UpdateAdhaar(String adhaar, String newA){
        s.update("Adhaar", adhaar, "Adhaar", newA);
    }
    
    public void UpdatePhone(String adhaar, String newA){    
        s.update("Adhaar", adhaar, "Phone", newA);
    }
    
    public void UpdatePass(String adhaar, String newA){
        s.update("Adhaar", adhaar, "Password", newA);
    }

    public void ShowData(String UID) {
        List<List<String>> t = s.pullOneData("UID", UID, "Tickets");
        
        System.out.println(t);

        String colOfStr[][] = new String[t.size()][7];

//        System.out.println(t);

//        colOfStr[0] =  t.get(0).toArray();
//        colOfStr[1] =  t.get(1).toArray();

        for(int i = 0; i < t.size(); i++){
            for(int j = 0; j < t.get(i).size(); j++){
                
                colOfStr[i][j] = t.get(i).get(j);
                colOfStr[i][0] = String.valueOf(i+1);
            }
          
        }
        
        new History(colOfStr);



        

        
        
    }

    public static void main(String... a) {
//        Account.add("shanu");
//        Account.add("123");
//        Account.add("098");
//        Account.add("121");
//        Account.add("pass");
//        
//        System.out.println(Account);
//        Account.remove(0);
//        System.out.println(Account);

//        System.out.println(IsAUser("shanu","PASS"));
//        String[] add = {"malad", "dubai", "112", "1h5h51", "bus", "3"};
//        TicketStore(add);
//        ShowData("63fb047e508665a44438f74");
        
    }
}
