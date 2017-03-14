package kg.iaau;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by azire on 3/14/2017.
 */
public class ExecutiveClass {
    /*
    * commands
    * newfile loadfile savefile
    * move-up move-down page-up page-down head tail
    * insert-before insert-after delete replace
    * show
    * exit
    * */
    String fileName;
    File currentFile;
    ArrayList<String> lines;

    public void newFile(String name){
        if(fileName == null)
            return;
        currentFile = new File(fileName);
    }
    public void loadFile(String name){}
    public void saveFile(String name){}

    public String moveUp(){return "";}
    public String moveDown(){return "";}
    public String pageUp(){return "";}
    public String pageDown(){return "";}
    public String head(){return "";}
    public String tail(){return "";}

    public void insertBefore(String text){}
    public void insertAfter(String text){}
    public void replace(String text){}
    public void delete(){}

    public String show(){return "";}

}
