
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hoangnm
 */
public class NewClass {
    public static void main(String[] args) throws UnsupportedFlavorException, IOException {
        Clipboard c=Toolkit.getDefaultToolkit().getSystemClipboard();
        System.out.println(c.getData(DataFlavor.stringFlavor));
    }
}
