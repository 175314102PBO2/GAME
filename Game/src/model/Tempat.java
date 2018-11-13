/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user only
 */
public class Tempat {

    private int tinggi; // tinggi tempat Game
    private int lebar;  // lebar tempat Game
    private ArrayList<Sel> daftarSel; // daftar sel
    private String isi; // isi file konfigurasi
    public static int batasKanan;
    public static int batasBawah;
    private ArrayList<Sel> isiTempat = new ArrayList<Sel>();

    public Tempat() {
        daftarSel = new ArrayList<Sel>();
    }

    /**
     * Fungsi pembaca file konfigurasi. Hasil pembacaan file akan disimpan di
     * atribut 'isi'.
     *
     * @param file
     */
    public void bacaFileKonfigurasi(File file) {
        try {

            String HasilBaca = "";
            int dataInt = 0;
            FileInputStream fis = new FileInputStream(file);
            int baris = 0;

            while ((dataInt = fis.read()) != -1) {
                if ((char) dataInt == '\n') {
                    for (int i = 0; i < HasilBaca.length(); i++) {
                        Sel sel = new Sel();
                        sel.setNilai(HasilBaca.charAt(i));
                        sel.setPosisiX(baris);
                        sel.setPosisiY(i);
                        isiTempat.add(sel);
                    }
                    tinggi++;
                    baris++;
                    HasilBaca = "";
                } else {
                    HasilBaca = HasilBaca + (char) dataInt;
                    lebar++;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tempat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Tempat.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Fungsi penambah daftar sel.
     *
     * @param sel
     */
    public void tambahSel(Sel sel) {
        daftarSel.add(sel);
    }

    /**
     * @return the tinggi
     */
    public int getTinggi() {
        return tinggi;
    }

    /**
     * @param tinggi the tinggi to set
     */
    public void setTinggi(int tinggi) {
        this.tinggi = tinggi;
    }

    /**
     * @return the lebar
     */
    public int getLebar() {
        return lebar;
    }

    /**
     * @param lebar the lebar to set
     */
    public void setLebar(int lebar) {
        this.lebar = lebar;
    }

    /**
     * @return the daftarSel
     */
    public ArrayList<Sel> getDaftarSel() {
        return daftarSel;
    }

    /**
     * @param daftarSel the daftarSel to set
     */
    public void setDaftarSel(ArrayList<Sel> daftarSel) {
        this.daftarSel = daftarSel;
    }

    /**
     * @return the isi
     */
    public String getIsi() {
        return isi;
    }

    /**
     * @param isi the isi to set
     */
    public void setIsi(String isi) {
        this.isi = isi;
    }
}
