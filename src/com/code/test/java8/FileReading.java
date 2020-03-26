package com.code.test.java8;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class FileReading {

    public static boolean isResponsive(String url) {
        boolean opr = false;
        try {
            HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
            con.setRequestMethod("HEAD");
            System.out.println(con.getResponseCode() == HttpURLConnection.HTTP_OK);
        } catch (Exception e) {
            opr = false;
        }
        return opr;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String[] hostList = {"http://www.google.com", "https://slashdot.org/",
                "http://www.example.co"};

        for (int i = 0; i < hostList.length; i++) {
            isResponsive(hostList[i]);
        }

        File f = new File("inputdata.txt");
        f.isFile();
        Scanner in = new Scanner(f);
        StringBuilder s = new StringBuilder("");
        while (in.hasNextLine())
            s.append(in.nextLine());
        in.close();
        System.out.println(s.toString());

        try {
            // -----------------------------------------
            FileInputStream fio = new FileInputStream(f);
            int i = fio.read();
            ////////////////////////////////////
            BufferedInputStream bfis = new BufferedInputStream(fio);
            while (bfis.available() > 0){
				bfis.read(new byte[100]);
            }
            //////////////////////////////////////////////
			// This one is better in performance
            BufferedReader br = new BufferedReader(new FileReader(f));
            br.readLine();
            while (br.readLine() != null)
                ;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
