package com.code.test;

import java.io.FileNotFoundException;
import java.net.HttpURLConnection;
import java.net.URL;

public class FileReading {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
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
		
		
		// int freq=0,n,i,j,finfreq=0,number=0;
		// int a[]=new int[30];
//		Scanner in=new Scanner(new File("c:\\Response\\google.txt"));
//		 StringBuilder s = new StringBuilder("");
//		 while(in.hasNextLine())
//			 s.append(in.nextLine());
//		 in.close();
//		 System.out.println(s.toString());
//
//		try {
//			File f = new File("c:\\Response\\result.txt");
//			// -----------------------------------------
//			FileInputStream fio = new FileInputStream(f);
//			int i = fio.read();
//			////////////////////////////////////
//			BufferedInputStream bfis = new BufferedInputStream(fio);
//			i = bfis.read();
//			while (bfis.available() > 0)
//				;
//			//////////////////////////////////////////////
//			BufferedReader br = new BufferedReader(new FileReader(f));
//			br.readLine();
//			while (br.readLine() != null)
//				;
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

}
