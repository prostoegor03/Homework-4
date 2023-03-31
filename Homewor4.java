package com.mycompany.homewor4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


public class Homewor4 {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.print("Введите количество файлов для склейки: ");
        
        Scanner scan = new Scanner(System.in);
        int value = scan.nextInt();
        
        HashMap<Integer,String> save = new HashMap<>();
        int i =1;
        int len = 0;
        while(i <= value ){
            System.out.println("Введите путь к "+ i +"-ому файлу");
             Scanner scan1 = new Scanner(System.in);
             String path = scan1.next();
             save.put(i,path);
             try{
             len = len + FileUtils.lenghtOfOutput(path);
             }catch(IOException ex){
                 System.err.println("Произошла ошибка" + ex.getMessage());
             }
                     
             i++;
        }
        File file = new File(save.get(1));
        File output = new File(file.getParent()+"\\output.txt");
        try{
            output.createNewFile();
        }catch(IOException ex){
            System.out.println("Ошибка" + ex.getMessage());
        }
        
        
        FileOutputStream fos = new FileOutputStream(output);
        
        i=1;
        while(i<= value){
            try{
          fos.write(FileUtils.readBytesFromFile(save.get((i))));
            }catch(IOException ex){
                System.err.println("Ошибка" + ex.getMessage());
            }
            i++;
        }
        
    }
}
