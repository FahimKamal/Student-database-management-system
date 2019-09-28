/**
 * Class to take information from database and show it on jtable
 * Date : 03.09.19
 */
package Database;

/**
 *
 * @author Fahim
 */
public class User {
    private int serial;
    private String name,ID;
    
    User(int serial, String name,String ID){
        this.serial = serial;
        this.name = name;
        this.ID = ID;
    }
    public int getseial() { return serial; }    
    public String getname(){ return name; }
    public String getID(){ return ID; }
}
