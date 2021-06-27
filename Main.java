import java.util.Scanner;

class takeInput{
    public static void main(String arg[]){

        StudentManagement studentManagement = new StudentManagement();

        boolean operation = true;
        boolean cont = true;
        Scanner sc = new Scanner(System.in);
        while(cont){
        System.out.println("\n                             Welcome to Student Management System                     \n ");
        System.out.println("========================================================================================");
        
        System.out.println(" Enter the following Commands: ");

        System.out.println(" 1. add : Add a student");
        System.out.println(" 2. delete : Delete a student");
        System.out.println(" 3. edit : Edit the student list");
        System.out.println(" 4. Show : Show overall info ");
        System.out.println(" 0. stop : To stop the process");
        
        System.out.println("========================================================================================");
        int input = sc.nextInt();
        //String nm = sc.nextLine();
        //String[] splited = input.split("\\s+");
        switch (input) {
            case 1:
                studentManagement.addStudent();
                System.out.println("Student added successfully!\n");
                break;
            case 2:
                studentManagement.deleteStudent();
                break;
            case 3:
                System.out.println("Enter Student Name: ");
                String name = sc.next();
                System.out.println("Which things you want to edit? ");
                System.out.println("1. Average Marks");
                System.out.println("2. No of Days Taught");
                System.out.println("3. Earnings");
                int vlu = sc.nextInt();
                System.out.println("Give the Updated Value: ");
                Double value = sc.nextDouble();
                studentManagement.editStudent(name, vlu, value);
                break;
            case 4:
                System.out.println("Choose the following option");
                System.out.println("1. Show all ");
                System.out.println("2. Show according to classes");
                System.out.println("3. Show student info only by student name ");
                System.out.println("4. Show overall info");
                int op = sc.nextInt();
                if(op == 1) studentManagement.showAll();
                else if(op==2){
                    System.out.println("Enter Class: ");
                    int cls = sc.nextInt();
                    studentManagement.showClass(cls);
                }
                else if(op==3){
                    System.out.println("Enter Student Name: ");
                    String nm = sc.next();
                    studentManagement.showStudents(nm);
                }
                else if(op==4) studentManagement.showInfo();

                break;
            case 0:
                sc.close();
                operation = false;
                cont = false;
                break;
            default:
                break;
        }}
        
    }
 
}