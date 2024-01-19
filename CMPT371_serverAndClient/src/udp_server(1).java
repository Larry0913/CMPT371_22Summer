import java.io.* ;
import java.net.*;

public class udp_server {
    public static void main(String[] args)
    {
        try {
            DatagramSocket socket = new DatagramSocket(10101);
            byte[] Buffer_in = new byte[256];
            DatagramPacket packet_in = new DatagramPacket(Buffer_in,Buffer_in.length);

            while(true)
            {
                socket.receive(packet_in);
                String IncomingData = new String(packet_in.getData());

                System.out.println("received msg: " + IncomingData);
                if(IncomingData.charAt(0) == 'h')
                {
                    System.out.println("udp server received hello ");
                    String reply_msg = "back at you";
                    byte[] Buffer_out = reply_msg.getBytes();
                    InetAddress Add = packet_in.getAddress();
                    int P = packet_in.getPort();
                    DatagramPacket packet_out = new DatagramPacket(Buffer_out,Buffer_out.length,Add,P);
                    socket.send(packet_out);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
