import java.util.Scanner;

class takeInput{
    public static void main(String arg[]){

        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();

        System.out.println(" add : Add a student");
        System.out.println(" delete : Delete a student");
        System.out.println(" edit : Edit the student list");
        System.out.println(" list : Show All student list individually ");
        System.out.println(" show : Show overall info");

    }
}