package unidad05.examen2evaluacion2013_03_14.pruebas;

import unidad05.examen2evaluacion2013_03_14.*;
import java.io.File;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;

/**
 *
 * @author David López González
 */
public class ObjetoRemoto implements InterfaceRemota
{

    private PublicKey pk;

    @Override
    public void sendClavePublica(PublicKey pk) throws RemoteException
    {
        this.pk = pk;
        System.out.println(pk);
    }

    public static void main(String[] args)
    {
        System.out.println("Creando el registro de objetos remotos ....");
        Registry reg = null;
        try
        {
            reg = LocateRegistry.createRegistry(5555);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("Creando el objeto servidor e inscribiéndolo en el registro ...");
        ObjetoRemoto or = new ObjetoRemoto();
        try
        {
            reg.rebind("Claves", (InterfaceRemota) UnicastRemoteObject.exportObject(or, 0));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        while (true)
        {
            try
            {
                Thread.sleep(1000);
            } catch (InterruptedException ex)
            {
                Logger.getLogger(ObjetoRemoto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
