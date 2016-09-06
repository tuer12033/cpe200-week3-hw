package cpe200;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

    public Student() {
        this.Name = "John Doe";
        this.Student_id = "560610000";
        this.year = 1990;
        this.Active=false;
        // implement here
    }
    public Student(String name ,String id,int year,boolean Active){
        this.Name = !name.equalsIgnoreCase("")?name:"John Doe";
        this.Student_id = isValidStudent_id(id)?id:"560610000";
        this.year = (year<1989)?1990:year;
        this.Active=Active;
    }
    // implement all missing constructors here
    public String getName(){
        return this.Name;
    }
    public String getStudent_id(){
        return this.Student_id;
    }
    public int getYearOfBirth(){
        return this.year;
    }
    public boolean isActive(){
        return this.Active;
    }
    // implement all get and set methods here
    public void setName(String name){
        this.Name=!name.equalsIgnoreCase("")?name:this.Name;

    }
    public void setStudent_id(String id){
        this.Student_id= isValidStudent_id(id)?id:this.Student_id;
    }
    public void setYearOfBirth(int year){
        if(year>1989){
            this.year=1990;
        }

    }
    @Override
    public String toString() {
        String o = Name+" "+"("+Student_id+")"+" was born in "+year+" is an ";
        if(isActive()==true){
            o+="ACTIVE";
        }
        else{
            o+="INACTIVE";
        }
        o+= " student.";

        return o;
    }

    private boolean isValidStudent_id(String id) {
        Pattern p = Pattern.compile(idREGEX);
        Matcher m = p.matcher(id);
        return m.matches();
    }

    private boolean isValidYOB(int yob) {
        return true;
    }

    private static final String idREGEX = "5[6-9]061[0-2][0-9]{3}";

    // declare your attributes here
    private String Name;
    private String Student_id;
    private int year;
    private boolean Active;
}
