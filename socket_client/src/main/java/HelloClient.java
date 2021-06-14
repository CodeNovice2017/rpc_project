import entity.Message;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author codechase <codecx@163.com>
 * Created on 2021-06-14
 */
@Slf4j
public class HelloClient {

    public Object send(Message message, String host, int port) {
        try (Socket socket = new Socket(host, port)) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(message);
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            return objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            log.error("occur exception:", e);
        }
        return null;
    }

    public static void main(String[] args) {
        HelloClient helloClient = new HelloClient();
        for (int i = 0; i < 10; i++) {
            Message message = (Message) helloClient.send(new Message("陈新帅吗?"), "127.0.0.1", 6666);
            System.out.println("client receive message:" + message.getMessage());
        }
    }
}
