package unidad01;


import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author David López González
 */
public class RuntimeProcess
{

    public static void main(String[] args)
    {
        if (args.length <= 0)
        {
            System.err.println("Se necesita un programa a ejecutar");
            System.exit(-1);
        }

        Runtime runtime = Runtime.getRuntime();
        try
        {
            Process process = runtime.exec(args);
            process.destroy();
        } catch (IOException ex)
        {
            System.err.println("Excepción de E/S!!");
            System.exit(-1);
        }
    }
}
