package student;
import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.lang.reflect.Array;
public class Student
{
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc =new Scanner(System.in);
        Student st =new Student();
        String studentList[][] = new String[3][5];
        System.out.println("Please enter 3 students");
        studentList = st.addBulkStudent();
        System.out.println("Students entered success");
        Address ad = new Address(studentList);
        studentList = ad.addBulkAddress(studentList);
        System.out.println("Students address entered success");
        for(int i = 0; i<6; i++) {
            System.out.println("Please enter option number from below options"+ "\n" + "1. Add new Student"+ "\n"+ "2. Show the names of all Students"+ "\n" + "3. Get student by Id"+ "\n" + "4. Get student by number"+ "\n" + "5. Get student by email address"+ "\n" +"6. Show all the details of a student by Id");
            int flag = sc.nextInt();
            if (flag == 1) {
                String[][] student_List = st.addStudent(studentList);
                studentList = ad.addStudentAddress(student_List);
            } else if (flag == 2) {
                st.showAllStudentName(studentList);
            } else if (flag == 3) {
                System.out.println("Enter the id number");
                int _id = sc.nextInt();
                st.getStudentById(studentList, _id);
            } else if (flag == 4) {
                System.out.println("Enter the mobile number");
                long number = sc.nextLong();
                st.getStudentByMobileNumber(studentList, number);
            } else if (flag == 5) {
                System.out.println("Enter the email address");
                String email = br.readLine();
                st.getStudentByEmail(studentList, email);
            } else if (flag == 6) {
                System.out.println("Enter the id number");
                int _id = sc.nextInt();
                ad.showStudentDetailsById(studentList, _id);
            }
        }


    }


    public String[][] addBulkStudent(){
        String studentArray[][] =new String [3][5];
        Scanner sc = new Scanner (System.in);
        for(int i= 0 ;i<studentArray.length; i++){
            int j = 0;
            System.out.println("Enter Student ID");
            studentArray[i][j++] = sc.nextLine();
            System.out.println("Enter Student First Name");
            studentArray[i][j++] = sc.nextLine();
            System.out.println("Enter Student Last Name");
            studentArray[i][j++] = sc.nextLine();
            System.out.println("Enter Student Email Address");
            studentArray[i][j++] = sc.nextLine();
            System.out.println("Enter Student Mobile Number");
            studentArray[i][j++] = sc.nextLine();
        }
        return studentArray;
    }

    public String[][] addStudent(String [][] studentList){

        Scanner sc = new Scanner (System.in);
        System.out.println("Enter number of new enlisted students");
        //int n = sc.nextInt();
        String student_list [][] = new String [studentList.length+1][studentList[0].length];
        for(int i = 0; i<studentList.length; i++)
        {
            for(int j = 0; j<studentList[0].length; j++)
            {
                student_list[i][j] = studentList[i][j];
            }
        }
            int i = studentList.length;;
            int j = 0;
            System.out.println("Enter Student ID");
            student_list[i][j++] = sc.nextLine();
            System.out.println("Enter Student First Name");
            student_list[i][j++] = sc.nextLine();
            System.out.println("Enter Student Last Name");
            student_list[i][j++] = sc.nextLine();
            System.out.println("Enter Student Email Address");
            student_list[i][j++] = sc.nextLine();
            System.out.println("Enter Student Mobile Number");
            student_list[i][j++] = sc.nextLine();

        return student_list;
    }

    public void getStudentById(String [][] studentlist, int id)
    {
        for(int i = 0; i<studentlist.length; i++)
        {
            int result = Integer.parseInt(studentlist[i][0]);
            if(result==id)
            {
                System.out.println(studentlist[i][1]+" "+studentlist[i][2]);
                break;
            }
        }
    }

    public void getStudentByMobileNumber(String [][] studentlist, long mobileNumber)
    {
        for(int i = 0; i<studentlist.length; i++)
        {
            long result = Long.parseLong(studentlist[i][4]);
            if(result==mobileNumber)
            {
                System.out.println(studentlist[i][1]+" "+studentlist[i][2]);
                break;
            }
        }


    }

    public void showAllStudentName(String [][] studentlist)
    {
        for(int i=0; i<studentlist.length;i++)
        {
            System.out.println(studentlist[i][1]+" "+studentlist[i][2]);
        }
    }

    public void getStudentByEmail(String [][] studentlist, String email)
    {
        for(int i = 0; i<studentlist.length; i++)
        {
            String result = (studentlist[i][3]);
            if(result.equals(email))
            {
                System.out.println(studentlist[i][1]+" "+studentlist[i][2]);
                break;
            }
        }
    }

}



class Address extends Student{
    String [][] student_array;

    Address(String [][] studentlist)
    {
        student_array  = new String [studentlist.length][studentlist[0].length+4];

    }

    public String[][] addBulkAddress(String [][] studentlist)
    {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i<studentlist.length; i++)
        {
            for(int j = 0; j<studentlist[0].length; j++)
            {
                student_array[i][j] = studentlist[i][j];
            }
        }

        for(int i = 0; i<studentlist.length; i++)
        {
            int j = studentlist[0].length;
            System.out.println("Enter road number");
            student_array[i][j++] = sc.nextLine();
            System.out.println("Enter area name");
            student_array[i][j++] = sc.nextLine();
            System.out.println("Enter city name");
            student_array[i][j++] = sc.nextLine();
            System.out.println("Enter country name");
            student_array[i][j++] = sc.nextLine();

        }
        return student_array;

    }

    public void showStudentDetailsById(String [][] studentlist, int id)
    {
        for(int i = 0; i<studentlist.length; i++)
        {
            int result = Integer.parseInt(studentlist[i][0]);
            if(result==id)
            {
                System.out.println("ID:"+studentlist[i][0]+ "\n"+ "First Name:" +studentlist[i][1]+ "\n"+ "Last Name:" +studentlist[i][2]+ "\n"+ "Email Address:" +studentlist[i][3]+ "\n"+ "Mobile No:" +studentlist[i][4]+ "\n"+ "Road No:" +studentlist[i][5]+ "\n"+ "Area Name:" +studentlist[i][6]+ "\n"+ "City Name:" +studentlist[i][7]+ "\n"+ "Country Name:" +studentlist[i][8]);
                break;
            }
        }

    }

    public String [][] addStudentAddress(String[][] studentlist)
    {
        student_array  = new String [studentlist.length][studentlist[0].length];
        for(int i = 0; i<studentlist.length; i++)
        {
            for(int j = 0; j<studentlist[0].length; j++)
            {
                student_array[i][j] = studentlist[i][j];
            }
        }

            Scanner sc = new Scanner(System.in);
            int i = studentlist.length-1;
            int j = studentlist[0].length - 4;
            System.out.println("Enter road number");
            student_array[i][j++] = sc.nextLine();
            System.out.println("Enter area name");
            student_array[i][j++] = sc.nextLine();
            System.out.println("Enter city name");
            student_array[i][j++] = sc.nextLine();
            System.out.println("Enter country name");
            student_array[i][j++] = sc.nextLine();


        return student_array;
    }



}