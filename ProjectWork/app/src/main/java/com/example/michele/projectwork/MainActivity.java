package com.example.michele.projectwork;


import android.app.Activity;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        run();
    }

    public void run() {

        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";


        try {
            InputStream inputStream = getResources().openRawResource(getResources().getIdentifier("dati",
                    "raw", getPackageName()));
            br = new BufferedReader(new InputStreamReader(inputStream));
            int count=0;

            while ((line = br.readLine()) != null ) {

                String[] address = line.split(";");
                count=address.length;


                System.out.println(address[0]);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Done");
    }



}