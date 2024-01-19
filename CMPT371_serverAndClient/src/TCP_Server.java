import java.io.*;
import java.net.*;

public class TCP_Server {
    public static void main(String[] args)
    {
        try {
            ServerSocket server = new ServerSocket(10101);
            while(true) {
                Socket client = server.accept();
                OutputStream os = client.getOutputStream();
                InputStream is = client.getInputStream();
                PrintWriter out = new PrintWriter(os, true);
                BufferedReader in = new BufferedReader( new InputStreamReader(is));
                if(in.readLine().charAt(0) == 'h'){
                    System.out.println("TCP received");
                    String reply_msg = "back at you";
                    out.println(reply_msg);
                }
                out.close();
                in.close();
                client.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
