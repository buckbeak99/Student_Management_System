import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {

    private ArrayList<Student> studentList = new ArrayList<Student>();
    private int totalDaysClasses =0, totalDaysClasses8 = 0,totalDaysClasses9 = 0,totalDaysClasses10 = 0, numberOfStudents = 0;
    private Double totalAverageMarks = 0.0, totalAverageMarks8 = 0.0, totalAverageMarks9 = 0.0, totalAverageMarks10 = 0.0;
    private Double totalEarnings = 0.0, totalEarnings8 = 0.0, totalEarnings9 = 0.0, totalEarnings10 = 0.0;
    public ViewStudent view = new ViewStudent();
    
    Scanner sc = new Scanner(System.in);

    //adding student in student array list
    StudentManagement(){
        Student s1 = new Student("Tonoy", 10, makesubjectslist("phy, chem "), 10, 90.0, 5.0);
        Student s2 = new Student("Nafija", 9, makesubjectslist("phy, chem"), 5, 87.0, 9.0);
        Student s3 = new Student("Michale", 8, makesubjectslist("phy, chem"), 8, 89.0, 8.0);
        Student s4 = new Student("D'costa", 8, makesubjectslist("phy, chem"), 7, 78.0, 7.0);
        Student s5 = new Student("Akhenie", 8, makesubjectslist("phy, chem"), 9, 98.0, 8.0);
        Student s6 = new Student("Riya", 8, makesubjectslist("phy, chem"), 10, 90.0, 8.0);
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);
        studentList.add(s5);
        studentList.add(s6);
       for (Student student : studentList) {
           addInfo(student);
       }

    }

    // calculating total days of classes, total earnings, totalmarks according to classes

    public void addInfo(Student student){

        totalDaysClasses += student.getTotalDaysTaught();
        totalEarnings += student.getEarnings();

        switch(student.getClasses()){

            case 8: 
                totalDaysClasses8 += student.getTotalDaysTaught();
                totalEarnings += student.getEarnings();
                break;
            case 9:
                totalDaysClasses9 += student.getTotalDaysTaught();
                totalEarnings += student.getEarnings();
                break;
            case 10:
                totalDaysClasses10 += student.getTotalDaysTaught();
                totalEarnings += student.getEarnings();
                break;
        }
        numberOfStudents++;
        totalAverageMarks += student.getAveragMarks();
    }

    // making subject list and spilting the list
    private ArrayList<String> makesubjectslist(String string) {

        String[] splited = string.split(",");
        String s = "";
        ArrayList<String> sub = new ArrayList<>();
        // for (String st : splited) {
        //     s = splited[st];
        //     if(s.length() == 0) continue;
        //     if(s.charAt(0) == ' ') s = s.substring(1, s.length() - 1);
        //     if(s.charAt(s.length()-1) == ' ') s = s.substring(1, s.length() - 2); 
        //     sub.add(s);
        // }
        for(int i =0; i<splited.length;i++){
            s = splited[i];
            if(s.length() == 0) continue;
            if(s.charAt(0) == ' ') s = s.substring(1, s.length() - 1);
            if(s.charAt(s.length()-1) == ' ') s = s.substring(1, s.length() - 2); 
            sub.add(s);
        }
        return sub;
    }

    // method to add a student
    public void addStudent(){

        System.out.println(" In which class you want to add student? Class 8/9/10, choose one of them ! ");
        int clss = sc.nextInt();
        

        System.out.println("Enter Student Name: ");
        String name = sc.next();
        //sc.next();

        System.out.println("Enter the subject s/he reads? multiple values allowed( please use comma for separting the subjects) : ");
        String s = sc.next();
        ArrayList<String>sub = makesubjectslist(s);
        //sc.next();

        System.out.println("Enter average marks of that student( please use fractional type value e.g. 8.0/8.8) : ");
        Double averageMarks = sc.nextDouble();
        //sc.next();

        System.out.println("How many days you have taught that student? ");
        int totalDaysTaught = sc.nextInt();
        //sc.next();

        System.out.println("Total Earnings( please use fractional type value e.g. 8.0/8.8)? : ");
        Double totalEarnings = sc.nextDouble();
        //sc.next();

        Student newStd = new Student(name, clss, sub, totalDaysTaught, averageMarks, totalEarnings);
        studentList.add(newStd);
        addInfo(newStd);

    }

    // method to delete a student
    public void deleteStudent(){
        System.out.println("Enter the student name you want to delete from the list: ");
        System.out.println("--> Student Name: ");
        String nmToDel = sc.next();

        Student stdDel = searchStudent(nmToDel);
        if(stdDel != null){
            studentList.remove(stdDel);
            System.out.println(nmToDel + " is deleted from the list. \n");
        }
        
    }

    // method to delete the list
    public void deleteAll(){
        studentList.clear();
    }

    // search method to find a student from the list
    private Student searchStudent(String nameDelete) {
        for (Student student : studentList) {
            if(student.getName().equals(nameDelete)){
                return student;
            }
        }
         System.out.printf("Student with name " + nameDelete + " not found \n");
         return null;
    }

    public void showAll(){
        view.showDetails(studentList);
    }

    // show every information of the class
    public void showInfo(){

        System.out.println("======================================================================================== \n");

        System.out.println("Number of Student: " + numberOfStudents);

        System.out.println("Number of Total Days of All Classes: "+ totalDaysClasses);
        System.out.println("Number of Total Days of All Classes of 8: "+ totalDaysClasses8);
        System.out.println("Number of Total Days of All Classes of 9: "+ totalDaysClasses9);
        System.out.println("Number of Total Days of All Classes of 10: "+ totalDaysClasses10);

        System.out.println("Number of Total Earnings: "+ totalEarnings);
        System.out.println("Number of Total Earnings of Class 8: "+ totalEarnings8);
        System.out.println("Number of Total Earnings of Class 9: "+ totalEarnings9);
        System.out.println("Number of Total Earnings of Class 10: "+ totalEarnings10);

        System.out.println("Average Marks of All Students: " + totalAverageMarks/numberOfStudents);

        System.out.println("========================================================================================"); 

    }

    // method to show classes
    public void showClass(int classes){

        ArrayList<Student> tmpList = new ArrayList<>();
        for(int i=0;i<studentList.size(); i++){
            Student ss = studentList.get(i);
            if(ss.getClasses() == classes){
                tmpList.add(ss);
            }
        }
        view.showDetails(tmpList);

    }

    //method to show students
    public void showStudents(String name){
        Student newStu = searchStudent(name);
        if(newStu == null) return;
        ArrayList<Student> tmpList =  new ArrayList<Student>();
        tmpList.add(newStu);
        view.showDetails(tmpList);
    }

    // method to edit student
    public void editStudent(String name, int option, Double value){
        Student newStu = searchStudent(name);
        if(newStu == null) return;
        if(option == 1){
            newStu.setAverageMarks(value);
        }
        else if(option ==2){
            newStu.setTotalDaysTaught((int)Math.round(value));
        }
        else if(option == 3){
            newStu.setTotalEarnings(value);
        }
        System.out.println("Value Updated Successfully ! \n");
    }

}
