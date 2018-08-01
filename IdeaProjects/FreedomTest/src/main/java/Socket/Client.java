package Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		Runnable runnable = ()->{
            try{
                Socket socket = new Socket("127.0.0.1",9999);
                System.out.println("客户端编号："+(int)(Math.random()*100));
                BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
                BufferedReader bf1 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println("你已连接上服务器，请开始交互");
                while(true){
                    String line = bf.readLine();
                    pw.println(line);

                    System.out.println(bf1.readLine());
                    if (line.equals("over")) {
                        break;
                    }

                }
                bf.close();
                pw.close();
                bf1.close();
                socket.close();
            }catch (IOException e){
                e.printStackTrace();
            }

        };

        new Thread(runnable).start();
	}
}
