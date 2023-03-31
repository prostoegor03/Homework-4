/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.homewor4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileUtils {
    
    public static byte[] readBytesFromFile(String path) throws FileNotFoundException, IOException{
        File file = new File(path);
        if(file.exists()){
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[fis.available()];
            fis.read(data);
            fis.close();
            return data;
        }else
            return new byte[0];
        }
    public static int lenghtOfOutput(String path) throws FileNotFoundException, IOException{
        int len = 0;
         File file = new File(path);
        if(file.exists()){
        FileInputStream fis = new FileInputStream(file);  
        len =fis.available();
        }else{
            System.err.println("По указанному пути файл не обнаружен");
        }
        return len;
    }
    
    
}
