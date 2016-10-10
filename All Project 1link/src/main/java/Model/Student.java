package Model;

import java.io.Serializable;
import java.util.Scanner;

/**
 * Created by dell on 10/2/2016.
 */
public class Student implements Serializable{
    private String name;
    private String id;
    private String address;
    private boolean gender;
    private double score1;
    private double score2;
    private double score3;

    public Student(){}

    public Student(String name, String id, String address, boolean gender, double score1, double score2, double score3){
        this.name=name;
        this.id= id;
        this.address= address;
        this.gender= gender;
        this.score1=score1;
        this.score2=score2;
        this.score3=score3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public double getScore1() {
        return score1;
    }

    public void setScore1(double score1) {
        this.score1 = score1;
    }

    public double getScore2() {
        return score2;
    }

    public void setScore2(double score2) {
        this.score2 = score2;
    }

    public double getScore3() {
        return score3;
    }

    public void setScore3(double score3) {
        this.score3 = score3;
    }

    public void input(){
        Scanner in= new Scanner(System.in);
        System.out.println("Enter Name: ");
        setName(in.nextLine());
        System.out.println("Enter ID: ");
        setId(in.nextLine());
        System.out.println("Enter Adress: ");
        setAddress(in.nextLine());
        System.out.println("Enter gender: 0. Nam  1.Nu");
        int gt;
        do {
            System.out.println("Choice gender: ");
            gt= in.nextInt();
            if (gt != 0 && gt != 1){
                System.out.println("Choice again!");
            }
            else {
                setGender( gt==0 ? true : false);
            }
        }while (gt != 0 && gt != 1);
        do {
            System.out.println("Enter score1: ");
            setScore1(in.nextDouble());
        }while (score1 < 0 || score1 > 10);
        do {
            System.out.println("Enter score2: ");
            setScore2(in.nextDouble());
        }while (score2 < 0 || score2 > 10);
        do {
            System.out.println("Enter score3: ");
            setScore3(in.nextDouble());
        }while (score3 < 0 || score3 > 10);
    }

    public static String standardized(String str){
        str= str.trim();//xoa khoang trang dau va khoang trang cuoi
        str= str.replaceAll("\\s+", " ");//cat bo cac khoang trang thua o giua cau
        String temp[]= str.split(" ");//tach xau thanh cac mang tu
        str="";
        for (int i=0; i < temp.length; i++){
            str+= String.valueOf(temp[i].charAt(0)).toUpperCase()+temp[i].substring(1);//viet hoc ky tu dau tien o moi tu
            // va noi cac ky tu con lai
            if ( i < temp.length-1 ){
                str += " ";
            }
        }
        return  str;
    }

    public  void output(){
        System.out.println("Name: "+getName());
        System.out.println("ID: "+getId());
        System.out.println("Adress: "+getAddress());
        System.out.println("Gender: "+(isGender() ? "Nam" : "Nu"));
        System.out.println("Score1: "+getScore1());
        System.out.println("Score2: "+getScore2());
        System.out.println("Score3: "+getScore3());
    }

    public String reverseName(){//dao nguoc ten de dung so sanh ten
        String[] name= getName().split(" ");//tach ten ra theo mot mang ko co dau cach
        String nameReverse="";
        for (int i = name.length-1; i>=0 ; i--) {
            nameReverse += name[i];// dao nguoc lai ten
        }
        return nameReverse;
    }


}
