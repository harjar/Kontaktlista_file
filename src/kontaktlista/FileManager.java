/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontaktlista;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author jarhar
 */
public class FileManager {

    public void saveToFile(ArrayList<Kontakt> kon) {
        try {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream("kontaker.ser");
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(kon);

            out.close();
            file.close();
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Kontakt> readFromFile() {
        ArrayList<Kontakt> lista = null;
        try {
            // Reading the object from a file
            FileInputStream file = new FileInputStream("kontaker.ser");
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            lista = (ArrayList<Kontakt>) in.readObject();

            in.close();
            file.close();

        } catch (IOException ex) {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }
        return lista;
    }
}
