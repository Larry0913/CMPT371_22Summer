import java.io.*;
import java.net.*;

public class TCP_Client {
    public static void main(String[] args)
    {
        try {

            byte[] ipAddr = new byte[]{127, 0, 0, 1};
            InetAddress addr = InetAddress.getByAddress(ipAddr);
            Socket MySocket = new Socket(addr,10101);
            OutputStream os = MySocket.getOutputStream();
            InputStream is = MySocket.getInputStream();

            PrintWriter out = new PrintWriter(os, true);
            BufferedReader in = new BufferedReader( new InputStreamReader(is));
            long send_time = System.currentTimeMillis();
            out.println("hello");
            String T = in.readLine();
            long recv_time = System.currentTimeMillis();
            System.out.println("received message: " +T);
            System.out.println("receive time: " + recv_time);
            long RTT = recv_time - send_time;
            System.out.println("RTT in seconds: " + (double)RTT/1000);
            out.close();
            in.close();
            MySocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

