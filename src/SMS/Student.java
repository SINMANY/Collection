package SMS;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Student {
        int id;
        String name;
        String gender;
        int age;
        String classroom;
        float score;
        Student(){}
        Student(int id, String name, String gender,int age, String classroom, float score){
            this.id = id;
            this.name = name;
            this.gender = gender;
            this.age = age;
            this.classroom = classroom;
            this.score = score;
        }

        void output(){
            System.out.println("\t"+id+"\t\t"+name+"\t\t"+gender+"\t\t"+age+"\t\t"+classroom+"\t\t\t"+score);
        }
        void input(Scanner input){
            boolean isInvalid = false;
            boolean isInvalidAge = false;
            boolean isInvalidScore = false;
            do{
                String strId;
                System.out.print("Enter ID : ");
                try {
                    strId = input.next();
                    id = Integer.parseInt(strId);
                    isInvalid = true;
                }catch (Exception exception){
                    System.out.println("Invalid id format..! Number required..!");
                }
            }while (!isInvalid);
            input.nextLine();
            System.out.print("Enter name : ");
            name = input.nextLine();
            System.out.print("Enter gender : ");
            gender = input.nextLine();
            do{
                String strAge;
                System.out.print("Enter your age : ");
                try {
                    strAge = input.next();
                    age = Integer.parseInt(strAge);
                    isInvalidAge = true;
                }catch (Exception exception){
                    System.out.println("Invalid age format..! Number required..!");
                }
            }while (!isInvalidAge);
            input.nextLine();
            System.out.print("Enter classroom : ");
            classroom = input.nextLine();
            do{
                String strScore;
                System.out.print("Enter score : ");
                try {
                    strScore = input.next();
                    score = Integer.parseInt(strScore);
                    isInvalidScore = true;
                }catch (Exception exception){
                    System.out.println("Invalid score format..! Number required..!");
                }
            }while (!isInvalidScore);
        }

    public int isIdUpdated(ArrayList<Student> students, int id) {
        if(students.size()>0){
            for(int i=0; i<students.size(); i++){
                if(id == students.get(i).id){
                    return i;
                }
            }
        }
        return -1;
    }
    void updateStudent(Scanner input){
        boolean isInvalidAge = false;
        boolean isInvalidScore = false;
        input.nextLine();
        System.out.print("Enter name : ");
        name = input.nextLine();
        System.out.print("Enter gender : ");
        gender = input.nextLine();
        do{
            String strAge;
            System.out.print("Enter your age : ");
            try {
                strAge = input.next();
                age = Integer.parseInt(strAge);
                isInvalidAge = true;
            }catch (Exception exception){
                System.out.println("Invalid age format..! Number required..!");
            }
        }while (!isInvalidAge);
        input.nextLine();
        System.out.print("Enter classroom : ");
        classroom = input.nextLine();
        do{
            String strScore;
            System.out.print("Enter score : ");
            try {
                strScore = input.next();
                score = Integer.parseInt(strScore);
                isInvalidScore = true;
            }catch (Exception exception){
                System.out.println("Invalid score format..! Number required..!");
            }
        }while (!isInvalidScore);
    }
}

