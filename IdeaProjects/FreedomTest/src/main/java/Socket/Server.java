package Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Server {

	public static void main(String[] args) throws IOException{
		System.out.println("开始提供服务");
		//代表注册一个服务器socket，端口号设定为9999
		ServerSocket serverSocket = new ServerSocket(9999);
		//代表接受的一个客户端socket
		Socket socket = serverSocket.accept();
		//获取客户端的主机号
		System.out.println("主机号："+socket.getInetAddress().getLocalHost()+"已连接");
		String line = null;
		//打开socket的读写流
		BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);

        ArrayList<String> arrayList = new ArrayList<>();
		int index = 0;
		while((line = bf.readLine())!=null){
			System.out.println(line);
			if (line.equals("over")) {
				break;
			}else if (line.equals("put")){
                arrayList.add(line);
			    index++;
			    pw.println("OK");
            } else if (line.equals("get")) {
                pw.println(arrayList.get(index));
                System.out.println(arrayList.get(index));
            }else {
                System.out.println(arrayList);
            }
		}
		serverSocket.close();
		bf.close();
		pw.close();
	}

}
