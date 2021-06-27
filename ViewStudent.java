import java.util.ArrayList;

public class ViewStudent {

    public void showDetails(ArrayList<Student>studentList){
        if(studentList.isEmpty()){
            System.out.println("No Student found. \n");
            return;
        }else{
        System.out.println("---------------------------------------------------------------------------------");
        System.out.printf("%-18s%-15s%-15s%-20s%-15s%-15s\n" , "Student", "Class" , "Subject", "Average", "No. of days", "Total" );   
        System.out.printf("%-18s%-15s%-15s%-20s%-15s%-15s\n" , "Name", "" , "List", "Marks", "taught", "earnings"); 
        System.out.println();
        for(Student student: studentList){
            student.showStudent();
        }
        System.out.println("---------------------------------------------------------------------------------");
    }
    }
    
}
