package com.ucentral.MiKasa.utilidades;

import java.io.*;

public class Archivos {
    public static boolean guardar(String archivo, Object objeto){
        try{
            ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(archivo));
            oos.writeObject(objeto);
        }catch(IOException e){
            return false;
        }
        return true;
    }
    public static Object recuperar(String archivo){
        Object objetoConsultado;
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo));
            objetoConsultado = ois.readObject();
            return objetoConsultado;
        }catch (IOException e){
            return null;
        } catch (ClassNotFoundException e){
            return null;
        }
    }
}
