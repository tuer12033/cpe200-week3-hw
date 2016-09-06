package cpe200;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Course {

    public Course() {
        this("","","",30);
    }

    public Course(String n, String cid) {
        // implement here
        this.course_name = !n.equalsIgnoreCase("")?n:"TBA";
        this.course_id = !cid.equalsIgnoreCase("")?n:"000000";
        this.lecturer="TBA";
        this.max_students=30;
        this.no_students=0;
    }

    public Course(String n, String cid, String l) {
        // implement here
        this.course_name = !n.equalsIgnoreCase("")?n:"TBA";
        this.course_id = !cid.equalsIgnoreCase("")?n:"000000";
        this.lecturer = !l.equalsIgnoreCase("")?n:"TBA";
        this.max_students=30;
        this.no_students=0;
    }

    public Course(String n, String cid, String l, int max) {
        this.course_name = !n.equalsIgnoreCase("")?n:"TBA";
        this.course_id = isValidCourse_id(cid)?cid:"000000";
        this.lecturer = !l.equalsIgnoreCase("")?l:"TBA";
        this.max_students = (max<10)?30:max;
        this.no_students=0;
        // implement the rest here
    }

    public String getCourse_name() {
        return this.course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = !course_name.equalsIgnoreCase("")?course_name:this.course_name;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = isValidCourse_id(course_id)?course_id:this.course_id;
    }

    // implement the other get and set methods here
    public String getLecturer() {
        // implement here

        return this.lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = !lecturer.equalsIgnoreCase("")?lecturer:this.lecturer;
    }

    public int getMax_students() {
        // implement here
        return this.max_students;
    }

    public void setMax_students(int max_students) {
        // implement here
        if(max_students<10){
            max_students=30;
        }
        else{
            this.max_students=max_students;
        }
    }

    public int getNo_students() {
        // implement here
        return this.no_students;
    }

    public void setNo_students(int no_students) {
        // implement here
        if(no_students<0||no_students>max_students){
            this.no_students=0;
        }
        else{
            this.no_students=no_students;
        }
    }

    @Override
    public String toString() {
        String o = this.course_name + " ("
                + this.course_id + "), Teacher: "
                + this.lecturer + ", has ";
        if(no_students==0){
            o+="NO student, [maximum: " +this.max_students+"]";
        }
        else if(no_students==1){
            o+="ONE student, [maximum: " +this.max_students+"]";
        }
        else{
            o+=this.no_students+" students, [maximum: " +this.max_students+"]";
        }
        // implement the rest here

        return o;
    }

    private boolean isValidCourse_id(String id) {
        Pattern p = Pattern.compile(idREGEX);
        Matcher m = p.matcher(id);

        // implement the rest here

        return m.matches();
    }

    // Regular expression for the Student ID pattern
    private static final String idREGEX = "\\d{6}";

    // all private attributes
    private String course_name;
    private String course_id;
    private String lecturer;
    private int max_students;
    private int no_students;
}
