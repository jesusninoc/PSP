package unidad03.ejercicios.ejercicio02b;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author David López González
 */
public class ClienteHora
{
    /*
    Construir un servidor en Java que ofrezca dos servicios. Por un lado, actuará como un servidor echo para
    clientes que soliciten este servicio en el puerto 9998; por otro lado, devolverá la hora del sistema a los clientes
    que soliciten la hora a través del puerto 9999.
    */
    Socket s;
    InetSocketAddress dir;
    ObjectOutputStream os;
    ObjectInputStream is;

    public ClienteHora() throws IOException
    {
        s = new Socket();
        dir = new InetSocketAddress("127.0.0.1", 9999);
        s.connect(dir);
        System.out.println(s.getPort());
        System.out.println(s.getInetAddress().getHostName());
        os = new ObjectOutputStream(s.getOutputStream());
        is = new ObjectInputStream(s.getInputStream());
        String text = null;
        Scanner teclado = new Scanner(System.in);

        do
        {
            text = teclado.nextLine();
            os.writeUTF(text);
            System.out.println(is.readUTF()+" REsponde el server");
        } while (!text.equalsIgnoreCase("Bye"));
    }

    public static void main(String[] args) throws IOException
    {
        ClienteHora c = new ClienteHora();

    }
}
