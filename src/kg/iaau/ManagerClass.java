package kg.iaau;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by azire on 3/14/2017.
 */
public class ManagerClass {
    private ExecutiveClass ec = new ExecutiveClass();
    private ArrayList<String> fileMC;   //file manipulation commands
    private ArrayList<String> lineMC;   //line manipulation commands
    private ArrayList<String> listAC;   //line altering commands
    private ArrayList<String> otherC;   //other commands

    ManagerClass(){
        fileMC = new ArrayList<>();
        lineMC = new ArrayList<>();
        listAC = new ArrayList<>();
        otherC = new ArrayList<>();

        fileMC.add("newfile");
        fileMC.add("loadfile");
        fileMC.add("savefile");

        lineMC.add("move-up");
        lineMC.add("move-down");
        lineMC.add("page-up");
        lineMC.add("page-down");
        lineMC.add("head");
        lineMC.add("tail");

        listAC.add("insert-before");
        listAC.add("insert-after");
        listAC.add("delete");
        listAC.add("replace");

        otherC.add("show");
        otherC.add("exit");
    }
    void run(){
        while (true){
            Scanner in = new Scanner(System.in);
            String command = in.next();
            if(command.equals("exit"))
                break;
            if(!command.equals("newfile") && !ec.isFileLoaded()){
                System.out.println("Please, load file first");
                continue;
            }
            switch (command){
                case "newfile":
                case "page-up":
                case "page-down":
                case "move-up":
                case "move-down":
                case "show":
                case "delete":
                case "head":
                case "tail":
                case "help":
                    singleCommand(command);
                    break;
                case "loadfile":
                case "savefile":
                case "insert-after":
                case "insert-before":
                case "replace":
                    argumentCommand(command);
                    break;
                default:
                    System.out.println("Invalid command : "+command);
            }
        }
    }
    private void singleCommand(String command){
        switch (command){
            case "newfile":
                ec.newFile();
                break;
            case "page-up":
                ec.pageUp();
                break;
            case "page-down":
                ec.pageDown();
                break;
            case "move-up":
                ec.moveUp();
                break;
            case "move-down":
                ec.moveDown();
                break;
            case "show":
                ec.show();
                break;
            case "delete":
                ec.delete();
                break;
            case "head":
                ec.head();
                break;
            case "tail":
                ec.tail();
                break;
        }
    }
    private void argumentCommand(String command){
        Scanner in = new Scanner(System.in);
        System.out.printf(" ->\t");
        String line = in.nextLine();
        switch (command){
            case "loadfile":
                ec.loadFile(line);
                break;
            case "savefile":
                ec.saveFile(line);
                break;
            case "insert-after":
                ec.insertAfter(line);
                break;
            case "insert-before":
                ec.insertBefore(line);
                break;
            case "replace":
                ec.replace(line);
                break;
        }
    }
}
