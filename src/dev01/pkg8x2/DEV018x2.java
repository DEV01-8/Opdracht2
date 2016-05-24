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

    public void Convert(double eig1, double eig2, int cat) {
        try {
            float pointA = map((float) eig1, 0, 70, 25, 600);
            float pointB = map((float) eig2, 1800, 0, 30, 665);
            
            switch(cat){
                case 1:
                    fill(0, 255, 0); //green
                    break;
                case 2:
                    fill(0, 0, 255); //blue
                    break;
                case 3:
                    fill(255, 255, 0); //yellow
                    break;
                case 4:
                    fill(255, 0, 0); //red
                    break;
                default:
                    fill(0, 0, 0);
                    break;
            }
            //Create point on map with x and y
            ellipse(pointA, pointB, 6, 6);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void ReadText() {
        try {
            //Read text file
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Johan Bos\\Desktop\\scatterplot.txt"));
            String line;

            br.readLine(); // This will read the first line
            String line1 = null;    //Skip first line
            DecimalFormat decimalFormat = new DecimalFormat("#");

            //Clear Arraylists for correct order
            CAT.clear();
            EIG1.clear();
            EIG2.clear();

            while ((line1 = br.readLine()) != null) {
                String[] columns = line1.split("\t");
                CAT.add(decimalFormat.parse(columns[0]).intValue());
                EIG1.add(decimalFormat.parse(columns[1]).doubleValue());
                EIG2.add(decimalFormat.parse(columns[2]).doubleValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void settings() {
        size(650, 760);
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
        line(25, 665, 600, 665);   //x-axis
        line(25, 30, 25, 665);      //y-axis
        text("EIG1", 550, 695);     //x-axis text
        text("EIG2", 25, 20);       //y-axis text

        // points x-axis
        int x = 25;
        for (int i = 0; i < 8; i++) {
            ellipse(x, 665, 4, 4);
            x = x + 78;
        }

        // points y-axis
        int y = 35;
        for (int i = 0; i < 19; i++) {
            ellipse(25, y, 4, 4);
            y = y + 35;
        }

        //numbers points y-axis
        int xt = 0;
        int yt = 37;
        int v = 1800;
        for (int i = 0; i < 19; i++) {
            text(decimalFormat.format(v), xt, yt);
            yt = yt + 35;
            v = v - 100;
        }

        //numbers points x-axis
        int xs = 25;
        int ys = 680;
        int vs = 0;
        for (int i = 0; i < 8; i++) {
            text(decimalFormat.format(vs), xs, ys);
            xs = xs + 78;
            vs = vs + 10;
        }

        //Insert points to create scatter
        try {
            for (int i = 0; i < EIG1.size(); i++) {
                Convert((double) EIG1.get(i), (double) EIG2.get(i), (int) CAT.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //Legenda

        fill(0, 255, 0); //green
        ellipse(550, 400, 10, 10);
        fill(0, 0, 0);
        text("CAT = 1", 565, 404);

        fill(0, 0, 255); //blue
        ellipse(550, 425, 10, 10);
        fill(0, 0, 0);
        text("CAT = 2", 565, 429);

        fill(255, 255, 0); //yellow
        ellipse(550, 450, 10, 10);
        fill(0, 0, 0);
        text("CAT = 3", 565, 454);

        fill(255, 0, 0); //red
        ellipse(550, 475, 10, 10);
        fill(0, 0, 0);
        text("CAT = 4", 565, 479);
        
    }

    public static void main(String[] args) {
        PApplet.main(new String[]{DEV018x2.class.getName()});
        ReadText();
    }
}
