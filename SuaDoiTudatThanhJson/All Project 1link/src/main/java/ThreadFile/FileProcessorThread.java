package ThreadFile;

import Model.Student;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Created by dell on 10/5/2016.
 */
public class FileProcessorThread extends Thread{
    private File file;
    private ObjectInputStream objectInputStream;
    private ArrayList<Student> listStudent;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public FileProcessorThread(File file){
        this.file=file;
        listStudent = new ArrayList<Student>();
    }

    public ArrayList<Student> readFileProcessorThread(File file) throws Exception{
       try {
          objectInputStream = new ObjectInputStream(new FileInputStream(file));
          listStudent = ( ArrayList<Student> ) objectInputStream.readObject();
          objectInputStream.close();
      }catch (Exception e){
          throw e;
       }
       return listStudent;
    }

    @Override
    public void run() {

        try {
            listStudent= readFileProcessorThread(file);
        }catch (Exception e){
             e.printStackTrace();
        }
    }
}
