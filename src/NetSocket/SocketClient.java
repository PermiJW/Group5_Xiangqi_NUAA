package NetSocket;

import java.io.IOException;  
import java.io.InputStream;  
import java.io.OutputStream;  
import java.net.Socket;  
import java.net.SocketException;  
import java.net.UnknownHostException;  
import java.net.InetAddress;  
  
public class SocketClient extends Thread{  
  
    /** 
     * @param args 
     */
	private Socket clientSocket;
	private String ip;
	InputStream receiveData;
    OutputStream sendData;
	public SocketClient(String ipAddress) {
		clientSocket = null;
		ip = ipAddress;
		receiveData = null;
        sendData = null;
	}
	
	public void run() {
		startClient(ip);
	}
	
	public void transferPoint(int chessType,int presentPointX,int presentPointY,int afterPointX,int afterPointY) {
    	String data = Integer.toString(chessType) + " " + Integer.toString(presentPointX) + " " 
    			+ Integer.toString(presentPointY) + " " +Integer.toString(afterPointX) + " " + Integer.toString(afterPointY);
    	try {
			sendData.write(data.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public void sendDatas() {
    	String data[] ={"First","Second","Third"};
    	byte[] b = new byte[1024];
    	for(int i = 0;i < data.length;i++){
             //��������
    		 try{
    		 } catch(Exception e) {
    			 e.printStackTrace(); //��ӡ�쳣��Ϣ
    		 }
    	}
    }
	
    public void startClient(String serverIp) {
    	Socket socket = null;
        //��������IP��ַ
        //�������˶˿ں�
        int port = 1590;
        //��������
        try {
                 //��������
        		 clientSocket = new Socket(serverIp,port);
                 System.out.println("��ʼ�ͻ���");
                 //��ʼ����
                 sendData = clientSocket.getOutputStream();
                 receiveData = clientSocket.getInputStream();
                 int n;
                 byte[] b = new byte[1024];
	    	     while(true) {
	    	    	 n = receiveData.read(b);
	    	    	 if(n != 0) {
	    	    		 String rece = new String(b,0,n);
			             String reces[] = rece.split(" ");
			             int chessType = Integer.parseInt(reces[0]);
			             int presentPointX = Integer.parseInt(reces[1]);
			             int presentPointY = Integer.parseInt(reces[2]);
			             int afterPointX = Integer.parseInt(reces[3]);
			             int afterPointY = Integer.parseInt(reces[1]);
	    	    	 }
	    	    	 sleep(100);
		             //��������
		             //�����������
	    	     }
        } catch (Exception e) {
                 e.printStackTrace(); //��ӡ�쳣��Ϣ
        } finally{
            try {
                //�ر���������
            	if(socket != null) {
            		sendData.close();
                    receiveData.close();
                    socket.close();
            	} 	
            } catch (Exception e2) {}
        }
    }
}  