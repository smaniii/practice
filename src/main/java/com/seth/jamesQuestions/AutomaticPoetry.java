package com.seth.jamesQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AutomaticPoetry {
    public void automaticPoetry(){
        Scanner input = new Scanner(System.in);
        int j = Integer.valueOf(input.nextLine());
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < (j*2); i++) {
            stringList.add(input.nextLine());
        }
        boolean even = true;
        String string1 = "";
        String string2 = "";
        String string3 = "";
        String string4 = "";
        String string5 = "";
        for (String s: stringList) {
            StringBuilder stringBuilder1 = new StringBuilder();
            StringBuilder stringBuilder2 = new StringBuilder();
            StringBuilder stringBuilder3 = new StringBuilder();
            StringBuilder stringBuilder4 = new StringBuilder();
            if(even){
                int  i = 0;
                while (s.charAt(i) != "<".charAt(0)){
                    stringBuilder1.append(s.charAt(i));
                    i++;
                }
                string1 = stringBuilder1.toString();
                i++;
                while (s.charAt(i) != ">".charAt(0)){
                    stringBuilder2.append(s.charAt(i));
                    i++;
                }
                string2 = stringBuilder2.toString();
                i++;
                while (s.charAt(i) != "<".charAt(0)){
                    stringBuilder3.append(s.charAt(i));
                    i++;
                }
                string3 = stringBuilder3.toString();
                i++;
                while (s.charAt(i) != ">".charAt(0)){
                    stringBuilder4.append(s.charAt(i));
                    i++;
                }
                string4 = stringBuilder4.toString();
                i++;
                string5 = s.substring(i);
                even = false;
                String evenString = string1 + string2 + string3 + string4 + string5;
                System.out.println(evenString);
            }
            else {
                String replaceDots = string4 + string3 + string2 + string5;
                String oddString = s.replace("...", replaceDots);
                System.out.println(oddString);
                even = true;
            }
        }
    }
}
