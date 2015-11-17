package unidad02.ejercicios.hoja3.puente2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David López González
 */
public class CochesSur implements Runnable
{
    int nCoches;
    MonitorPuente monitor;

    public CochesSur(int nCoches, MonitorPuente monitor)
    {
        this.nCoches = nCoches;
        this.monitor = monitor;
    }
    
    @Override
    public void run()
    {
        try
        {
            monitor.entrarCocheDelSur();
            Thread.sleep((long) (Math.random() * 3000));//tiempo en recorrer el puente
            monitor.salirCocheSur();
        } catch (InterruptedException ex)
        {
            Logger.getLogger(CochesSur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
