package SMS;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void pressAnyKey(){
        Scanner input = new Scanner(System.in);
        System.out.println("Press Enter to continue...!");
        input.nextLine();
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        int option = 0;
        do{
            System.out.println("===================== Student Management System ======================");
            System.out.println("1. Insert student to system ");
            System.out.println("2. Edit student information ");
            System.out.println("3. Search student information ");
            System.out.println("4. Delete student information ");
            System.out.println("5. Show student information ");
            System.out.println("6. Exit the program");
            System.out.println("------------------------------");
            System.out.print(">>> Choose your option : ");
            try {
                option = input.nextInt();
            }catch (Exception exception){
                input.nextLine();
                option = 0;
                System.out.println("Invalid input..!");
            }
            switch (option){
                case 1 -> {
                    System.out.println("========================== Insert student to system =========================");
                    Student newStudent = new Student();
                    newStudent.input(input);
                    students.add(newStudent);
                    System.out.println("Successfully added..!");
                }
                case 2 -> {
                    int updatedID;
                    System.out.println("========================== Edit student information =======================");
                    if(students.size()==0){
                        System.out.println("There is no student in the system..!");
                    }else {
                        System.out.print("Enter student ID to edit : ");
                        updatedID = input.nextInt();
                        int updateStudentIndex = new Student().isIdUpdated(students,updatedID);
                        if(updateStudentIndex>=0){
                            students.get(updateStudentIndex).updateStudent(input);
                            System.out.println("Successfully update information of student..!");
                        }else {
                            System.out.println(updatedID+" does not exist..! Please check again..!");
                        }
                    }
                }
                case 3 -> {
                    System.out.println("========================= Search student information ======================");
                    int searchOption = 0;
                    boolean isExit = true;
                    do{
                        System.out.println("1. Search student by id ");
                        System.out.println("2. Search student by name ");
                        System.out.println("3. Search student by gender ");
                        System.out.println("4. Search student by class name ");
                        System.out.println("5. Exit..");
                        System.out.print(">>> Choose your option : ");
                        try {
                            searchOption = input.nextInt();
                        }catch (Exception exception){
                            input.nextLine();
                            searchOption = 0;
                            System.out.println("Invalid input..! Number is required..!");
                        }
                        switch (searchOption){
                            case 1 -> {
                                int searchId;
                                boolean isWorkerExist = false;
                                System.out.print("Enter id to search : ");
                                searchId = input.nextInt();
                                for(int i=0; i<students.size(); i++){
                                    if(searchId==students.get(i).id){
                                        isWorkerExist = true;
                                        System.out.println("----------------------------------------------------------------------------------");
                                        students.get(i).output();
                                        System.out.println("----------------------------------------------------------------------------------");
                                    }
                                }
                                if(!isWorkerExist){
                                    System.out.println("Student id "+ searchId +" does not have in the system..!");
                                }
                            }
                            case 2 -> {
                                String searchStudentName;
                               System.out.print(" Enter student name to search : ");
                                input.nextLine();
                                searchStudentName = input.nextLine();
                                boolean searchNameValid = false;
                                System.out.println("----------------------------------------------------------------------------------");
                                for (int i = 0; i < students.size(); i++) {
                                    if (students.get(i).name.equalsIgnoreCase(searchStudentName)) {
                                        students.get(i).output();
                                        searchNameValid = true;
                                    }
                                }
                                if(!searchNameValid){
                                    System.out.println("This student name doesn't exist in the system...!");
                                }
                                System.out.println("----------------------------------------------------------------------------------");
                            }
                            case 3 -> {
                                String searchByGender;
                                System.out.print("Enter gender to search : ");
                                input.nextLine();
                                searchByGender = input.nextLine();
                                boolean searchGenderValid = false;
                                System.out.println("----------------------------------------------------------------------------------");
                                for (Student student : students) {
                                    if (student.gender.equalsIgnoreCase(searchByGender)) {
                                        student.output();
                                        searchGenderValid = true;
                                    }
                                }
                                if(!searchGenderValid){
                                    System.out.println("Does not have student as girls..!");
                                }
                                System.out.println("----------------------------------------------------------------------------------");
                            }
                            case 4 -> {
                                String searchByClassName;
                                boolean searchClassNameValid = false;
                                System.out.print("Enter class name to search : ");
                                input.nextLine();
                                searchByClassName = input.nextLine();
                                System.out.println("----------------------------------------------------------------------------------");
                                for (Student student : students) {
                                    if (student.classroom.equalsIgnoreCase(searchByClassName)) {
                                        student.output();
                                        searchClassNameValid = true;
                                    }
                                }
                                if(!searchClassNameValid){
                                    System.out.println("Class is not found..!");
                                }
                                System.out.println("----------------------------------------------------------------------------------");
                            }
                        }
                        if(searchOption!=5){
                            pressAnyKey();
                        }
                    }while (searchOption!=5);
                }
                case 4 -> {
                    int deleteId;
                    System.out.println("========================== Delete student information =======================");
                    if(students.size()==0){
                        System.out.println("There is no student in the system...!");
                    }else {
                        System.out.print("Enter student ID to delete : ");
                        deleteId = input.nextInt();
                        int deletedStudentId = new Student().isIdUpdated(students,deleteId);
                        if(deletedStudentId>=0){
                            // delete
                            students.remove(deletedStudentId);
                            System.out.println("Remove student successfully...!");
                        }else {
                            System.out.println(deleteId+" does not exist in the list...!");
                        }
                    }
                }
                case 5 -> {
                    System.out.println("============================= Show worker information ============================");
                    System.out.println("\tId\t\t\tName\t\tGender\t\tAge\t\tClassroom\t\tScore");
                    System.out.println("----------------------------------------------------------------------------------");
                    for (Student student : students){
                        student.output();
                    }
                    System.out.println("----------------------------------------------------------------------------------");
                }
                case 6 -> {
                    System.out.println("Exit the program");
                }
            }
            pressAnyKey();
        }while (option!=6);
    }
}
