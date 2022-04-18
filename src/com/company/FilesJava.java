package com.company;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;

public class FilesJava {

    //creating a file in java --> a file is created by passing a string which represents the name of the file
    public void createFile() throws IOException {
        File file = new File("C:\\Users\\neera\\Desktop\\testFile.txt");
        file.createNewFile();
        if(file.createNewFile()){
            //if this is executed means the file is being create
            System.out.println("File "+file.getName()+" created successfully");
        }else{
            System.out.println("File with name "+file.getName()+" already exists!!");
            //get file path
            System.out.println("File path: "+file.getPath());
            System.out.println("File absolute path: "+file.getAbsolutePath());
            System.out.println("File exists: "+file.exists());
            System.out.println("File parent: "+file.getParent());
            //free space in bytes
            System.out.println("Free space: "+file.getFreeSpace());
        }

    }


}