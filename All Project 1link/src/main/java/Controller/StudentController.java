package Controller;

import Model.Student;
import Model.StudentModel;

import java.util.ArrayList;

/**
 * Created by dell on 10/3/2016.
 */
public class StudentController {
    private StudentModel studentModel;
    private Student student;

    public StudentController(){
        studentModel= new StudentModel();
        student= new Student();
    }

    public ArrayList<Student> seachID(String id){
        return studentModel.seachID(id);
    }

    public ArrayList<Student> seachName(String name){
        return studentModel.seachName(name);
    }

    public ArrayList<Student> seachScoreBySubject(double score, int choice){
        return studentModel.seachScoreBySubject(score, choice);
    }

    public ArrayList<Student> seachSumScore(double sum){
        return studentModel.seachSumScore(sum);
    }

    public ArrayList<Student> Sort(int choice){
        return studentModel.Sort(choice);
    }

    public void  Statistic(){
        studentModel.Statistic();
    }

    public boolean WriteFile(ArrayList<Student> listStudent, String fileName) throws Exception{
        return studentModel.WriteFile(listStudent,fileName);
    }

    public ArrayList<Student> ReadFile(ArrayList<Student> listStudent,String fileName) throws Exception{
        return studentModel.ReadFile(fileName);
    }

    public ArrayList<Student> editStudent(String id){
        return studentModel.editStudent(id);
    }

    public ArrayList<Student> deleteStudent(String id){
        return studentModel.deleteStudent(id);
    }

    public ArrayList<Student> ReadFileJson(ArrayList<Student> listStudent, String fileName) throws Exception{
        return studentModel.ReadFileJson(fileName);
    }

    public boolean WriteFileJson(ArrayList<Student> listStudent, String fileName) throws Exception{
        return studentModel.WriteFileJson(listStudent,fileName);
    }


}
