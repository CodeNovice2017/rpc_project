import entity.Message;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author codechase <codecx@163.com>
 * Created on 2021-06-13
 */
@Slf4j
public class HelloServer {

    public void start(int port){
        try(ServerSocket serverSocket = new ServerSocket(port)){
            Socket socket;
            while((socket = serverSocket.accept()) != null){
                log.debug("client connected");
                try(ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream())){
                    Message message = (Message)objectInputStream.readObject();
                    message.setMessage("陈新真的很帅气啊!");
                    objectOutputStream.writeObject(message);
                    objectOutputStream.flush();
                }catch(IOException | ClassNotFoundException e){
                    log.error("occur exception:",e);
                }
            }
        }catch(IOException e){
            log.error("occur IOException:",e);
        }
    }

    public static void main(String[] args) {
        HelloServer helloServer = new HelloServer();
        helloServer.start(6666);
    }
}
