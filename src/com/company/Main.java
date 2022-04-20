package com.company;
import java.util.*;
import java.io.File;
import java.io.*;
import java.io.FileNotFoundException;
class MyClass  {
    public static void main(String[] args) throws FileNotFoundException {
        String s = "";
        String k = "";
        String j= "";
        String p= "";
        int zu=0;
        Scanner in = new Scanner(new File("C:\\rico\\ru.txt"));
        PrintWriter out = new PrintWriter("C:\\rico\\1234.txt");
        while(in.hasNext()) {
            s += in.nextLine() + "\r\n";
        }
        k=s.replaceAll("//", "\n//");
        for(int i=0;i<k.length();i++){
            if((k.charAt(i)=='/') && (k.charAt(i+1)=='/')){
                zu=1;
            }
            if((zu==1) && (k.charAt(i)=='\n')){
                zu=0;
            }
            if(zu==0) {
                j = j + k.charAt(i);
            }
        }
        for(int i=0;i<j.length();i++){
            if((j.charAt(i)=='/') && (j.charAt(i+1)=='*')){
                zu=1;
            }
            if((zu==1) && (j.charAt(i)=='*') && (j.charAt(i+1)=='/')){
                zu=0;
                i=i+2;
            }
            if(zu==0) {
                p = p + j.charAt(i);
            }
        }
        out.println(p);
        out.close();
        in.close();
    }
}