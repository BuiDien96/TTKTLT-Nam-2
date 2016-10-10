package View;

import Controller.StudentController;
import Model.Student;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by dell on 10/3/2016.
 */
public class ViewStudent {
    private StudentController studentController= new StudentController();
    Scanner in= new Scanner(System.in);

    public  void choiceSubject(){
        System.out.println("Moi ban chon mon can tim diem: ");
        System.out.print("1. Mon Toan");
        System.out.print("2. Mon Ly");
        System.out.print("3. Mon Hoa");
    }

    public  void Seach(){
        System.out.println("Moi ban chon cach tim kiem: ");
        System.out.println("1.Tim kiem sinh vien theo tong so diem.");
        System.out.println("2.Tim kiem sinh vien theo so bao danh.");
        System.out.println("3.Tim kiem sinh vien theo ho ten.");
        System.out.println("4.Tim kiem sinh vien theo diem tung mon.");
        System.out.println("5.Thoat.");
    }

    public  static void mainview(){
        System.out.println("QUAN LY SINH VIEN");
        System.out.println("1.Nhap sinh vien.");
        System.out.println("2.Tim kiem sinh vien va truy xuat thong tin vua tim kiem ra file");
        System.out.println("3.Them, xoa, chinh sua");
        System.out.println("4.Sap xep.");
        System.out.println("5.Thong ke.");
        System.out.println("6.Thoat chuong trinh.");
    }

    public  void edit(){
        System.out.println("Moi ban chon them, chinh sua hoac xoa.");
        System.out.println("1.Them sinh vien.");
        System.out.println("2.Chinh sua sinh vien.");
        System.out.println("3.Xoa sinh vien.");
        System.out.println("4.Thoat");
    }

    public  void sort(){
        System.out.println("Moi ban chon cach sap xep.");
        System.out.println("1.Sap xep theo SBD");
        System.out.println("2.Sap xep theo tong diem.");
        System.out.println("3.Sap xep theo ten");
        System.out.println("4.Thoat");
    }

    public  void add(){
        System.out.println("Moi ban chon cach nhap:");
        System.out.println("1.Nhap tu ban phim.");
        System.out.println("2.Nhap vao file.");
        System.out.println("3.Thoat");
    }

    public void Option1(){
        ArrayList<Student> listStudent= new ArrayList<Student>();
        int chon;

        do {
            add();
            chon= in.nextInt();
            switch (chon){
                case 1: {//nhap tu ban phim
                    int n;
                    System.out.println("Nhap so hoc sinh; ");
                    n=in.nextInt();
                    for (int i = 0; i < n; i++) {
                        System.out.println("Hoc sinh thu "+(i+1));
                        Student stu= new Student();
                        stu.input();
                        listStudent.add(stu);
                    }
                    /*for (Student stu:listStudent) {
                        stu.output();
                    }*/
                    String file;
                    System.out.println("Nhap ten file");
                    in.nextLine();
                    file= in.nextLine();
                    try {
                       // studentController.WriteFile(listStudent, file);
                        studentController.WriteFileJson(listStudent,file);
                    }
                    catch (Exception e){
                        System.out.println(e.toString());
                    }
                    break;
                }
                case 2:{
                    String file;
                    System.out.println("Nhap ten file: ");
                    in.nextLine();
                    file= in.nextLine();
                    try {
                       //studentController.ReadFile(listStudent,file);
                        studentController.ReadFileJson(listStudent,file);
                    }
                    catch (Exception e){
                        System.out.println(e.toString());
                    }

                    break;
                }
                case 3:
                    break;
            }
        }while (chon != 3);
    }

    public void Option2(){
        ArrayList<Student> list= new ArrayList<Student>();
        int choice;
        do {
            Seach();
            choice=in.nextInt();
            switch (choice){
                case 1:{
                    int tong;
                    System.out.println("Enter sum seach: ");
                    tong= in.nextInt();
                    list= studentController.seachSumScore(tong);
                    for (Student stu: list) {
                        stu.output();
                    }
                    System.out.println("Ban co muon truy xuat thong tin tim kiem duoc ra file ko?\n 1. Co\n 2. Khong");
                    int chon1;
                    chon1=in.nextInt();
                    if (chon1==1) {
                        String fileName;
                        System.out.print("Nhap ten file:");
                        in.nextLine();
                        fileName = in.nextLine();
                        try {
                            //studentController.WriteFile(list,fileName);
                            studentController.WriteFileJson(list, fileName);
                        } catch (Exception ex) {
                            System.out.println(ex.toString());
                        }
                        break;
                    }
                    break;
                }
                case 2:{
                    String sbd;
                    System.out.println("Moi ban nhap sbd can tim: ");
                    in.nextLine();
                    sbd=in.nextLine();
                    list= studentController.seachID(sbd);
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).output();
                    }
                    System.out.println("Ban co muon truy xuat thong tin tim kiem duoc ra file ko?\n 1. Co\n 2. Khong");
                    int chon1;
                    chon1=in.nextInt();
                    if (chon1==1) {
                        String fileName;
                        System.out.print("Nhap ten file:");
                        fileName = in.nextLine();
                        try {
                           // studentController.WriteFile(list,fileName);
                            studentController.WriteFileJson(list, fileName);
                        } catch (Exception ex) {
                            System.out.println(ex.toString());
                        }
                    }

                    break;
                }
                case 3:{
                    String hoten;
                    System.out.println("Moi ban nhap ho ten can tim: ");
                    in.nextLine();
                    hoten=in.nextLine();
                    list= studentController.seachName(hoten);
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).output();
                    }
                    System.out.println("Ban co muon truy xuat thong tin tim kiem duoc ra file ko?\n 1. Co\n 2. Khong");
                    int chon1;
                    chon1=in.nextInt();
                    if (chon1==1) {
                        String fileName;
                        System.out.print("Nhap ten file:");
                        fileName = in.nextLine();
                        try {
                           // studentController.WriteFile(list,fileName);
                            studentController.WriteFileJson(list, fileName);
                        } catch (Exception ex) {
                            System.out.println(ex.toString());
                        }
                    }

                    break;
                }
                case 4:{
                    int mon;
                    double diemMon;
                    choiceSubject();
                    mon=in.nextInt();
                    System.out.println("Moi ban nhap diem: ");
                    diemMon= in.nextDouble();
                    list= studentController.seachScoreBySubject(diemMon, mon);

                    switch (mon){
                        case 1:
                            for (int i = 0; i < list.size(); i++) {
                                list.get(i).output();
                            }
                            break;
                        case  2:
                            for (int i = 0; i <list.size() ; i++) {
                                list.get(i).output();
                            }
                            break;
                        case 3:
                            for (int i = 0; i < list.size(); i++){
                                list.get(i).output();
                            }
                            break;
                    }
                    System.out.println("Ban co muon muon trich xuat thong tin tim kiem duoc ra file khong?");
                    System.out.println("1. Co.");
                    System.out.println("2. Khong.");
                    int choice4;
                    choice4=in.nextInt();
                    if (choice4==1){
                        String fileName;
                        fileName= in.nextLine();
                        try {
                            //studentController.WriteFile(list,fileName);
                            studentController.WriteFileJson(list, fileName);
                        }
                        catch (Exception e){
                            System.out.println(e.toString());
                        }
                    }
                    break;
                }
                case 5:
                    break;
            }
        }while (choice != 5);

    }

    public void Option3(){

    }

    public void Option4(){
        ArrayList<Student > listStudent= new ArrayList<Student>();
        int chon;
        do {
            sort();
            chon=in.nextInt();
            listStudent=studentController.Sort(chon);
//            switch (chon){
//                case 1:{
//                    listStudent=studentController.Sort(chon);
//                    break;
//                }
//                case 2:{
//                    listStudent= studentController.Sort(chon);
//                    break;
//                }
//                case 3:{
//                    listStudent= studentController.Sort(chon);
//                    break;
//                }
//                case 4:
//                    break;
//            }
            for (Student stu: listStudent) {
                stu.output();
            }
        }while (chon != 4);
    }

    public void Option5(){
        studentController.Statistic();
    }
}
