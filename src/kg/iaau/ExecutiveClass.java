package kg.iaau;

import java.io.*;
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
    int index;

    public ExecutiveClass() {
        newFile();
    }

    public void newFile(){
        lines = new ArrayList<>();
        index = 0;
    }
    public void loadFile(String name){
        try {
            currentFile = new File(name);
            FileReader fr = new FileReader(currentFile);
            BufferedReader bf = new BufferedReader(fr);
            String line;
            lines = new ArrayList<>();
            while ((line = bf.readLine())!= null){
                lines.add(line);
            }
            index = 0;
            fr.close();
        }catch (Exception ex){
            System.out.println("Couldn't load file.\nPlease try again.");
        }
    }
    public void saveFile(String name){
        try {
            File newFile = new File(name);
            FileWriter fw = new FileWriter(newFile);
            BufferedWriter bw = new BufferedWriter(fw);
            for (String s : lines){
                bw.write(s+"\n");
            }
            fw.close();
        }catch (Exception ex){
            System.out.println("Couldn't save file.\nPlease try again.");
        }
    }

    public void moveUp(){
        if(index > 0){
            index--;
        }
    }
    public void moveDown(){
        if(index < lines.size()-1){
            index++;
        }
    }
    public void pageUp(){
        if(index > 20){
            index -= 20;
        }else {
            index = 0;
        }
    }
    public void pageDown(){
        if(index < lines.size()-21){
            index += 20;
        }else{
            index = lines.size()-1;
        }
    }
    public void head(){
        index = 0;
    }
    public void tail(){
        index = lines.size()-1;
    }

    public void insertBefore(String text){
        lines.add(index,text);
    }
    public void insertAfter(String text){
        lines.add(++index,text);
    }
    public void replace(String text){
        lines.set(index,text);
    }
    public void delete(){
        lines.remove(index);
    }
    public void show(){
        System.out.println(printLines());
    }

    private String printLines(){
        String text = "";
        if(index < 5){
            for(int i = 0;i < index+6;i++){
                text += (i+1)+"\t\t\t"+lines.get(i)+"\n";
            }
        }else
        if(index >= lines.size() - 6){
            for(int i = index-5; i < lines.size();i++){
                text += (i+1)+"\t\t\t"+lines.get(i)+"\n";
            }
        }else {
            for(int i = index-6; i < index+5;i++){
                text += (i+1)+"\t\t\t"+lines.get(i)+"\n";
            }
        }
        text += "\nCurrent line => "+(index+1);
        return text;
    }

    public boolean isFileLoaded(){
        return lines != null;
    }
}
