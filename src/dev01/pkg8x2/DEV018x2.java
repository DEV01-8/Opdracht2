/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev01.pkg8x2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import processing.core.PApplet;

/**
 *
 * @author Johan Bos
 */
public class DEV018x2 extends PApplet {

    public static ArrayList CAT = new ArrayList();
    public static ArrayList EIG1 = new ArrayList();
    public static ArrayList EIG2 = new ArrayList();
    
    public void Convert(double eig1, double eig2) {
        try{
        float pointA = map((float)eig1, 0, 70, 25, 580);
        float pointB = map((float)eig2, 1400, 0, 30, 525);
        //Create point on map with x and y
        fill(0, 0, 0);
        ellipse(pointA, pointB, 6, 6);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void ReadText() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Johan Bos\\Desktop\\scatterplot.txt"));
            String line;

            br.readLine(); // this will read the first line
            String line1=null;
            DecimalFormat decimalFormat = new DecimalFormat("#");
                    
            CAT.clear();
            EIG1.clear();
            EIG2.clear();
            
            while ((line1 = br.readLine()) != null) {
                String[] columns = line1.split("\t");
                CAT.add(columns[0]);
                EIG1.add(decimalFormat.parse(columns[1]).doubleValue());
                EIG2.add(decimalFormat.parse(columns[2]).doubleValue());
            }
            
            System.out.println("EIG1[0]: " + EIG1.get(0));
            System.out.println("EIG2[0]: " + EIG2.get(0));
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void settings() {
        size(600, 600);
    }

    @Override
    public void setup() {
        //Set Title
        surface.setTitle("Scatterplot");
    }

    @Override
    public void draw() {
        DecimalFormat decimalFormat = new DecimalFormat("#");

        fill(0, 0, 0);
        line(25, 525, 580, 525);   //x-axis
        line(25, 30, 25, 525);      //y-axis
        text("EIG1", 550, 565);     //x-axis text
        text("EIG2", 25, 20);       //y-axis text
        
        // points x-axis
        int x = 25;
        for (int i = 0; i < 8; i++) {
            ellipse(x, 525, 4, 4);
            x = x + 78;
        }
        
        // points y-axis
        int y = 35;
        for (int i = 0; i < 15; i++) {
            ellipse(25, y, 4, 4);
            y = y + 35;
        }
        
        //numbers points y-axis
        int xt = 0;
        int yt = 35;
        int v = 1400;
        for (int i = 0; i < 15; i++) {
            text(decimalFormat.format(v), xt, yt);
            yt = yt + 35;
            v = v - 100;
        }
        
        //numbers points x-axis
        int xs = 25;
        int ys = 545;
        int vs = 0;
        for (int i = 0; i < 8; i++) {
            text(decimalFormat.format(vs), xs, ys);
            xs = xs + 78;
            vs = vs + 10;
        }
        
        
        try{
        
        for (int i = 0; i < EIG1.size(); i++) {
            Convert((double)EIG1.get(i), (double)EIG2.get(i));
        }
        } catch(Exception e){
          e.printStackTrace();
      }
    }

    public static void main(String[] args) {
        PApplet.main(new String[]{DEV018x2.class.getName()});
        ReadText();        
    }
}
