// à lancer dans un autre workspace avant le client

package viewConsole;
import java.net.*;
import java.io.*;


public class Server {
   public static void main(String[] args) throws IOException{
	 int test = 1;
	 int str2;
	 ServerSocket ss = new ServerSocket(4997);
	 Socket s = ss.accept();
	 
	 System.out.println("client connected");
	 
	 InputStreamReader in = new InputStreamReader(s.getInputStream());
	 BufferedReader bf = new BufferedReader(in);
	 
	 String str = bf.readLine();
	 System.out.println("client said: "+str);
	 str2 = Integer.parseInt(str);
	 
	 PrintWriter pr = new PrintWriter(s.getOutputStream());
	 if (str2 == test) {
         pr.println("yes");
	     pr.flush();}
	 else {
		 pr.println("no");
		 pr.flush();
	 }
}
}
