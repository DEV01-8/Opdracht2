/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev01.pkg8x2;

/**
 *
 * @author Johan Bos <Johan Bos at jhnbos.nl>
 */
public class Point {
    private double EIG1;
    private double EIG2;
    private int CAT;

    public Point(double EIG1, double EIG2, int CAT) {
        this.EIG1 = EIG1;
        this.EIG2 = EIG2;
        this.CAT = CAT;
    }

    public double getEIG1() {
        return EIG1;
    }

    private void setEIG1(double EIG1) {
        this.EIG1 = EIG1;
    }

    public double getEIG2() {
        return EIG2;
    }

    private void setEIG2(double EIG2) {
        this.EIG2 = EIG2;
    }

    public int getCAT() {
        return CAT;
    }

    private void setCAT(int CAT) {
        this.CAT = CAT;
    }
    
    
}
