//package com.code.test;
//
//import java.io.BufferedReader;
//import java.io.DataInputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.Calendar;
//import java.util.GregorianCalendar;
//
//import org.apache.pdfbox.cos.COSDocument;
//import org.apache.pdfbox.io.RandomAccessFile;
//import org.apache.pdfbox.pdfparser.PDFParser;
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.text.PDFTextStripper;
//
//public class ThreadRunnable implements Runnable {
//	public ThreadRunnable() {
//	}
//
//	public void run() {
//		System.out.println("Thread " + Thread.currentThread().getName() + " is running");
//	}
//
//	public static void main(String[] args) throws InterruptedException {
//		 Thread t = new Thread(new ThreadRunnable());
//		 t.start();
//
//		// try {
//		// dump();
//		// SocketAddress sa = new InetSocketAddress("104.196.226.83", 80);
//		// Proxy proxy = new Proxy(Type.HTTP, sa);
//		// URL url = new URL("http://www.google.com/");
//		// URLConnection uc = url.openConnection(proxy);
//		// InputStream is = uc.getInputStream();
//		// BufferedReader in = new BufferedReader(new InputStreamReader(is));
//		// String inputLine;
//		// while ((inputLine = in.readLine()) != null) {
//		// System.out.println(inputLine);
//		// }
//		// in.close();
//		//
//		// } catch (Exception e) {
//		// e.printStackTrace();
//		// }
////		read2();
//
//			for(int i = 0; i < 10; i ++) {
//				Thread.sleep(700);
//				Calendar fromTime = Calendar.getInstance();
//				fromTime.add(Calendar.DAY_OF_MONTH, -1); // window of today and fromTime
//
//				Calendar thatday = new GregorianCalendar(fromTime.get(Calendar.YEAR),
//						fromTime.get(Calendar.MONTH),
//						fromTime.get(Calendar.DAY_OF_MONTH));
//
//				System.out.println(thatday.getTimeInMillis());
//			}
//	}
//
//	public static void dump() {
//		try {
//			DataInputStream di = null;
//			FileOutputStream fo = null;
//			byte[] b = new byte[1];
//
//			// PROXY
//			System.setProperty("http.proxyHost", "104.196.226.83");
//			System.setProperty("http.proxyPort", "80");
//
//			URL u = new URL("https://www.paypal.com");
//			HttpURLConnection con = (HttpURLConnection) u.openConnection();
//			//
//			// it's not the greatest idea to use a sun.misc.* class
//			// Sun strongly advises not to use them since they can
//			// change or go away in a future release so beware.
//			//
//			sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
//			// String encodedUserPwd =
//			// encoder.encode("mydomain\\MYUSER:MYPASSWORD".getBytes());
//			// con.setRequestProperty
//			// ("Proxy-Authorization", "Basic " + encodedUserPwd);
//			// PROXY ----------
//
//			di = new DataInputStream(con.getInputStream());
//			while (-1 != di.read(b, 0, 1)) {
//				System.out.print(new String(b));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static void crawlURL() {
//		try {
//
//			File f = new File("D:\\abc.pdf");
//
//			// byte[] buf = new byte[8192];
//
//			InputStream is = new FileInputStream(f);
//
//			// int c = 0;
//			//
//			// while ((c = is.read(buf, 0, buf.length)) > 0) {
//			// oos.write(buf, 0, c);
//			// oos.flush();
//			// }
//			//
//			// oos.close();
//			// System.out.println("stop");
//			// is.close();
//
//			BufferedReader br = new BufferedReader(new InputStreamReader(is));
//			String output;
//			System.out.println("Reading from File:\n");
//			while ((output = br.readLine()) != null) {
//				System.out.println(output);
//			}
//			br.close();
//
//			is.close();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static void read2() {
//		try {
//			PDFTextStripper pdfStripper = null;
//			PDDocument pdDoc = null;
//			COSDocument cosDoc = null;
//
//			File file = new File("D:\\abc.pdf");
//			PDFParser parser = new PDFParser(new RandomAccessFile(file, "r")); // update for PDFBox V 2.0
//
//			parser.parse();
//			cosDoc = parser.getDocument();
//			pdfStripper = new PDFTextStripper();
//			pdDoc = new PDDocument(cosDoc);
//			pdDoc.getNumberOfPages();
//			pdfStripper.setStartPage(1);
//			pdfStripper.setEndPage(10);
//
//			// reading text from page 1 to 10
//			// if you want to get text from full pdf file use this code
//			// pdfStripper.setEndPage(pdDoc.getNumberOfPages());
//
//			String Text = pdfStripper.getText(pdDoc);
//			System.out.println(Text);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static void read() {
//		// PDDocument pd;
//		// BufferedWriter wr;
//		try {
//
//			// Loading an existing document
//			File file = new File("D:\\abc.pdf");
//			PDDocument document = PDDocument.load(file);
//
//			// Instantiate PDFTextStripper class
//			PDFTextStripper pdfStripper = new PDFTextStripper();
//
//			// Retrieving text from PDF document
//			String text = pdfStripper.getText(document);
//			System.out.println(text);
//
//			// Closing the document
//			document.close();
//
//			// File input = new File("D:\\abc.pdf"); // The PDF file from where you would like to extract
//			// File output = new File("D:\\SampleText.txt"); // The text file where you are going to store the extracted data
//			// pd = PDDocument.load(input);
//			// System.out.println(pd.getNumberOfPages());
//			// System.out.println(pd.isEncrypted());
//			// pd.save("CopyOfInvoice.pdf"); // Creates a copy called "CopyOfInvoice.pdf"
//			// PDFTextStripper stripper = new PDFTextStripper();
//			// wr = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output)));
//			// stripper.getPageStart().readwriteText(pd, wr);
//			// if (pd != null) {
//			// pd.close();
//			// }
//			// // I use close() to flush the stream.
//			// wr.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//}
