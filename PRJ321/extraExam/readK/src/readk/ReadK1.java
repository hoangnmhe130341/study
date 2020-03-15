/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readk;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hoangnm
 */
public class ReadK1 {

    public static void main(String[] args) {
        try (FileReader fr = new FileReader("E:\\Fpt\\Fall2019-semes4\\PRJ321\\extraExam\\readK\\src\\k.txt");
                BufferedReader bf = new BufferedReader(fr);) {

//                try (FileWriter fw = new FileWriter("E:\\Fpt\\Fall2019-semes4\\PRJ321\\extraExam\\readK\\src\\aw.txt");
//                        BufferedWriter bw = new BufferedWriter(fw);) {
////            while (true) {
//                    String str = bf.readLine().trim();
//                    if (str == null) {
//                        break;
//                    } else {
//                        if (str.startsWith("#")) {
//                            bw.write("\n"+str);
//                        } else {
//                            bw.write(" "+str);
//                        }
//                    }
//
//            }
//                } catch (Exception e) {
//            }
            int count = 1;
            while (true) {
                String str = bf.readLine();
                if(str.trim()==null){
                    break;
                }
                int index = str.indexOf("|");
                if (str.substring(index + 1).trim().isEmpty()) {
                    System.out.println(count);
                }
                count++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
