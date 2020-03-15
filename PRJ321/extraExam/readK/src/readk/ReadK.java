/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readk;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hoangnm
 */
public class ReadK {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //###Q
        ///???A
        List<String> listAw = new ArrayList<>();
        List<String> listQu = new ArrayList<>();
        try (FileReader fr = new FileReader("E:\\Fpt\\Fall2019-semes4\\PRJ321\\extraExam\\readK\\src\\k.txt");
                BufferedReader bf = new BufferedReader(fr);) {
            while (true) {
                String str = "";
                if ((str = bf.readLine()) != null) {
                    if (str.contains("###")) {
                        listQu.add(str.substring(2));
                    } else if (str.contains("???")) {
                        listAw.add(str.substring(3));
                    }
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (FileWriter fw = new FileWriter("E:\\Fpt\\Fall2019-semes4\\PRJ321\\extraExam\\readK\\src\\aw.txt");
                BufferedWriter bw = new BufferedWriter(fw);) {
            for (int i = 0; i < listAw.size(); i++) {
                bw.write(listQu.get(i) + " | " + listAw.get(i)+"\n");
            }
                
        } catch (Exception e) {
        }
    }

}
