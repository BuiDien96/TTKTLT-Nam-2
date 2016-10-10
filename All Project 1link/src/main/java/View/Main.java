package View;

import java.util.Scanner;

/**
 * Created by dell on 10/3/2016.
 */
public class Main {
    public static void main(String[] arg){
    ViewStudent view= new ViewStudent();
        Scanner in= new Scanner(System.in);
        int chon;
        do {
            view.mainview();
            chon= in.nextInt();
            switch (chon){
                case 1:{
                    view.Option1();
                    break;
                }
                case 2:{
                    view.Option2();
                    break;
                }
                case 3:{
                    view.Option3();
                    break;
                }
                case 4:{
                    view.Option4();
                    break;
                }
                case 5:{
                    view.Option5();
                    break;
                }
                case 6:
                    break;
                default:{
                    System.out.println("Nhap sai, moi nhap lai.");
                    break;
                }
            }

        }while (chon != 6);

    }
}
