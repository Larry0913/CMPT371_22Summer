import java.io.*;
import java.net.*;

public class UDP_Client
{
    public static void main(String[] args)
    {
        try {
                DatagramSocket socket = new DatagramSocket();
                String Message = "hello";
                byte[] Buffer_out=Message.getBytes();
                byte[] ipAddr = new byte[]{127, 0, 0, 1};
                InetAddress addr = InetAddress.getByAddress(ipAddr);
                DatagramPacket packet_out= new DatagramPacket(Buffer_out, Buffer_out.length, addr, 10101);

                long send_time = System.currentTimeMillis();

                socket.send(packet_out);
                byte[] Buffer_in = new byte[256];
                DatagramPacket packet_in=new DatagramPacket(Buffer_in,Buffer_in.length);
                socket.receive(packet_in);
                String Response = new String(packet_in.getData());
                long recv_time = System.currentTimeMillis();


                long RTT = recv_time - send_time;
                System.out.println("RTT in seconds: " + (double)RTT/1000);

                socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}