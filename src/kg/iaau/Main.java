package kg.iaau;

import java.io.*;
import java.util.Scanner;

public class Main {
    /*
    * commands
    * newfile loadfile savefile
    * move-up move-down page-up page-down head tail
    * insert-before insert-after delete replace
    * show
    * exit
    * */
    public static void main(String[] args) {
        ManagerClass mc = new ManagerClass();
        Main m = new Main();
        mc.run();
        //m.createFile("file.txt",1500000);
    }

    public void createFile(String name,int n){
        File file = new File(name);
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw,225681);
            for (int i = 1;i <= n;i++){
                String s = "{---\t\t\t\t "+i+" \t\t\t\t---}\n";
                bw.append(s);
            }
            bw.flush();
            System.out.println("finished");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void someFunction(){
        try {
            File file = new File("test.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer stringBuffer = new StringBuffer();
            String line;
            int c = 0;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
                stringBuffer.append("\n");
                c++;
            }
            fileReader.close();
            System.out.println("Contents of file:");
            System.out.println(stringBuffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

