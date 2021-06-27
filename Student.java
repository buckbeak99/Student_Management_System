import java.util.ArrayList;

public class Student {
    
    private ArrayList<String> subjects;
    private int classes;
    private String name;
    private int totalDaysTaught;
    private Double averageMarks, totalEarnings;

    Student(String name, int classes, ArrayList<String>subjects, int totalDaysTaught, Double averageMarks, Double totalEarnings){

        this.name = name;
        this.classes = classes;
        this.subjects = subjects;
        this.totalDaysTaught = totalDaysTaught;
        this.averageMarks = averageMarks;
        this. totalEarnings = totalEarnings;

    }

    Student(){
        name = "";
        classes = 10;
        subjects = new ArrayList<>();
        totalDaysTaught = 0;
        averageMarks = 0.0;
        totalEarnings = 0.0;
    }

    //getter setter method for name instance

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    //getter setter method for number of classes

    public int getClasses() {
        return classes;
    }

    public void setClasses(int classes) {
        this.classes = classes;
    }

    //getter setter method for subject list

    public ArrayList<String> getSubjects(){
        return subjects;
    }

    public void setSubjects(ArrayList<String>subjects){
        this.subjects = subjects;
    }

    //getter setter methods for Total Number of Days taught

    public int getTotalDaysTaught(){
        return totalDaysTaught;
    }
    public void setTotalDaysTaught(int totalDaysTaught){
        this.totalDaysTaught = totalDaysTaught;
    }

    //getter setter methods for Average Marks they get

    public Double getAveragMarks(){
        return averageMarks;
    }
    public void setAverageMarks(Double averageMarks){
        this.averageMarks = averageMarks;
    }

    // getter setter methods for Total Earnings

    public Double getEarnings(){
        return totalEarnings;
    }

    public void setTotalEarnings(Double totalEarnings){
        this.totalEarnings = totalEarnings;
    }

    // Format String Syntax
    public void showStudent(){
        System.out.format("%-18s%-15s%-15s%-20s%-15s%-15s\n" , name, classes, subjects.toString(), averageMarks, totalDaysTaught, totalEarnings);
    }
}


