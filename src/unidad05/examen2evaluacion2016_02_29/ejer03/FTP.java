package unidad05.examen2evaluacion2016_02_29.ejer03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import static unidad05.UtilsSeguridad.Hexadecimal;
import unidad05.ejercicios.Ejer03;

/**
 *
 * @author David López González
 */
public class FTP extends javax.swing.JFrame
{

    private FTPClient cliente;

    private String servFTP;
    private String usuario;
    private String clave;
    private DefaultTableModel modelo;

    private int fila;
    private int columna;

    private String rutaFichero;
    private String rutaMD5;
    private String MD5;

    //para pruebas
    private FileInputStream in;
    private byte[] buffer;
    private PrivateKey clavePrivada;

    public FTP() throws NoSuchAlgorithmException
    {
        initComponents();
        cliente = new FTPClient();

        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
        SecureRandom numero = SecureRandom.getInstance("SHA1PRNG");
        keyGen.initialize(1024, numero);

        //Creación de las claves, tenemos la pareja en par
        KeyPair parClaves = keyGen.generateKeyPair();
        clavePrivada = parClaves.getPrivate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfDireccion = new javax.swing.JTextField();
        jtfUser = new javax.swing.JTextField();
        jtfPass = new javax.swing.JPasswordField();
        btnConectar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbFicheros = new javax.swing.JTable();
        btnSubirArchivo = new javax.swing.JButton();
        btnDesconectar = new javax.swing.JButton();
        btnDescargar = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        btnDescargarMd5 = new javax.swing.JButton();
        btnFirmar = new javax.swing.JButton();
        btnComprobarMd5 = new javax.swing.JButton();
        btnSeleccionarFichero = new javax.swing.JButton();
        btnSeleccionarMD5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosing(java.awt.event.WindowEvent evt)
            {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Dirección");

        jLabel2.setText("Usuario");

        jLabel3.setText("Passwd");

        jtfDireccion.setText("matrix");

        jtfUser.setText("dam2");

        btnConectar.setText("Conectar");
        btnConectar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnConectarActionPerformed(evt);
            }
        });

        jtbFicheros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String []
            {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtbFicheros.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jtbFicherosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbFicheros);

        btnSubirArchivo.setText("Subir Archivo");
        btnSubirArchivo.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSubirArchivoActionPerformed(evt);
            }
        });

        btnDesconectar.setText("Desconectar");
        btnDesconectar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnDesconectarActionPerformed(evt);
            }
        });

        btnDescargar.setText("Descargar");
        btnDescargar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnDescargarActionPerformed(evt);
            }
        });

        jButton5.setText("Ir a ");
        jButton5.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Subir un directorio");
        jButton6.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton6ActionPerformed(evt);
            }
        });

        btnDescargarMd5.setText("Descargar md5");
        btnDescargarMd5.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnDescargarMd5ActionPerformed(evt);
            }
        });

        btnFirmar.setText("Firmar");
        btnFirmar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnFirmarActionPerformed(evt);
            }
        });

        btnComprobarMd5.setText("Comprobar md5");
        btnComprobarMd5.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnComprobarMd5ActionPerformed(evt);
            }
        });

        btnSeleccionarFichero.setText("Selecionar archivo");
        btnSeleccionarFichero.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSeleccionarFicheroActionPerformed(evt);
            }
        });

        btnSeleccionarMD5.setText("Selecionar MD5");
        btnSeleccionarMD5.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSeleccionarMD5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(jtfUser)
                            .addComponent(jtfPass))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnConectar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDesconectar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnComprobarMd5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnFirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnDescargarMd5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSeleccionarMD5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnDescargar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSeleccionarFichero)))
                                .addGap(105, 105, 105)
                                .addComponent(btnSubirArchivo)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDesconectar)
                    .addComponent(btnConectar)
                    .addComponent(btnSubirArchivo)
                    .addComponent(btnDescargar)
                    .addComponent(btnSeleccionarFichero))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDescargarMd5)
                    .addComponent(btnSeleccionarMD5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(btnFirmar)
                    .addComponent(btnComprobarMd5))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConectarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnConectarActionPerformed
    {//GEN-HEADEREND:event_btnConectarActionPerformed
        conectar();
    }//GEN-LAST:event_btnConectarActionPerformed

    private void btnSubirArchivoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSubirArchivoActionPerformed
    {//GEN-HEADEREND:event_btnSubirArchivoActionPerformed
        final JFileChooser fc = new JFileChooser();

        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
        {
            try
            {
                File file = fc.getSelectedFile();
                FileInputStream in = new FileInputStream(file.toPath().toString());
                String nombreFichero = JOptionPane.showInputDialog(null, "Nombre del fichero");
                if (nombreFichero.equals(""))
                {
                    System.out.println(file.toPath().toString());
                }
                cliente.storeFile(nombreFichero, in);
                actualizarJTable();
            } catch (FileNotFoundException ex)
            {
                Logger.getLogger(Ejer03.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex)
            {
                Logger.getLogger(Ejer03.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btnSubirArchivoActionPerformed

    private void btnDesconectarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnDesconectarActionPerformed
    {//GEN-HEADEREND:event_btnDesconectarActionPerformed
        try
        {
            cliente.disconnect();
        } catch (IOException ex)
        {
            Logger.getLogger(FTP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDesconectarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowClosing
    {//GEN-HEADEREND:event_formWindowClosing
        try
        {
            cliente.disconnect();
        } catch (IOException ex)
        {
            Logger.getLogger(FTP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void btnDescargarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnDescargarActionPerformed
    {//GEN-HEADEREND:event_btnDescargarActionPerformed
        descargar();
    }//GEN-LAST:event_btnDescargarActionPerformed

    private void jtbFicherosMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jtbFicherosMouseClicked
    {//GEN-HEADEREND:event_jtbFicherosMouseClicked
        fila = jtbFicheros.rowAtPoint(evt.getPoint());
        columna = jtbFicheros.columnAtPoint(evt.getPoint());
        if ((fila > -1) && (columna > -1))
        {
            System.out.println(modelo.getValueAt(fila, columna));
        }
    }//GEN-LAST:event_jtbFicherosMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton5ActionPerformed
    {//GEN-HEADEREND:event_jButton5ActionPerformed
        try
        {
            String fichero_carpeta = (String) modelo.getValueAt(fila, 0);
            cliente.changeWorkingDirectory(fichero_carpeta);

            actualizarJTable();
        } catch (IOException ex)
        {
            Logger.getLogger(FTP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton6ActionPerformed
    {//GEN-HEADEREND:event_jButton6ActionPerformed
        try
        {
            cliente.changeToParentDirectory();
            actualizarJTable();
        } catch (IOException ex)
        {
            Logger.getLogger(FTP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnDescargarMd5ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnDescargarMd5ActionPerformed
    {//GEN-HEADEREND:event_btnDescargarMd5ActionPerformed
        descargarMd5();
        System.out.println(rutaMD5 + " MD5");
    }//GEN-LAST:event_btnDescargarMd5ActionPerformed

    private void btnComprobarMd5ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnComprobarMd5ActionPerformed
    {//GEN-HEADEREND:event_btnComprobarMd5ActionPerformed
        try
        {
            obtenerMD5();
            boolean correcto = comprobarMD5(MD5);
            if (correcto)
            {
                JOptionPane.showMessageDialog(null, "El MD5 es correcto");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "El MD5 no es correcto");
            }
        } catch (IOException ex)
        {
            Logger.getLogger(FTP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex)
        {
            Logger.getLogger(FTP.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnComprobarMd5ActionPerformed

    private void btnSeleccionarFicheroActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSeleccionarFicheroActionPerformed
    {//GEN-HEADEREND:event_btnSeleccionarFicheroActionPerformed
        final JFileChooser fc = new JFileChooser();

        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
        {
            try
            {
                File file = fc.getSelectedFile();
                rutaFichero = file.toPath().toString();
            } catch (Exception ex)
            {
                Logger.getLogger(FTP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSeleccionarFicheroActionPerformed

    private void btnSeleccionarMD5ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSeleccionarMD5ActionPerformed
    {//GEN-HEADEREND:event_btnSeleccionarMD5ActionPerformed
        final JFileChooser fc = new JFileChooser();
        String cadena = null;
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
        {

            FileReader f = null;
            try
            {
                File file = fc.getSelectedFile();
                f = new FileReader(file);
                rutaMD5 = file.getAbsolutePath();
                BufferedReader b = new BufferedReader(f);
                //leemos linea
                cadena = b.readLine();
                // nos aseguramos de obtener el md5 (debe de ser el primero)
                MD5 = (cadena.split(" "))[0];
            } catch (FileNotFoundException ex)
            {
                Logger.getLogger(FTP.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex)
            {
                Logger.getLogger(FTP.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
            {
                try
                {
                    f.close();
                } catch (IOException ex)
                {
                    Logger.getLogger(FTP.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnSeleccionarMD5ActionPerformed

    private void btnFirmarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnFirmarActionPerformed
    {//GEN-HEADEREND:event_btnFirmarActionPerformed
        byte[] resultadoFirmar;

        try
        {
            resultadoFirmar = firmar(clavePrivada, rutaFichero);
            FileOutputStream fos=new FileOutputStream("/home/wizord/ficheroFirmado");
            fos.write(resultadoFirmar);
        } catch (Exception e){
            JOptionPane.showConfirmDialog(null, "selecione el fichero");
        }
    }//GEN-LAST:event_btnFirmarActionPerformed
    String Hexadecimal(byte[] resumen)
    {
        String hex = "";
        for (int i = 0; i < resumen.length; i++)
        {
            String h = Integer.toHexString(resumen[i] & 0xFF);
            if (h.length() == 1)
            {
                hex += "0";
            }
            hex += h;
        }
        return hex.toUpperCase();
    }

    public byte[] firmar(PrivateKey privateKey, String fichero) throws InvalidKeyException, SignatureException, NoSuchAlgorithmException, FileNotFoundException, IOException
    {
        FileInputStream in = new FileInputStream(fichero);
        byte[] buffer = new byte[in.available()];
        in.read(buffer);
        in.close();
        /// versión más corta
        //Firma con clave privada,necesitamos la signature, decimos el algoritmo
        Signature signaturePrivada = Signature.getInstance("SHA1withDSA");
        //cargamos la privada
        signaturePrivada.initSign(privateKey);
        //actualizamos, podemos pasar cualquier cosa
        signaturePrivada.update(buffer);

        //una vez actualizado aplicamos sing, nos devuelve la firma
        byte[] firma = signaturePrivada.sign();
        return firma;
    }

    public boolean comprobarMD5(String md5) throws FileNotFoundException, IOException, NoSuchAlgorithmException
    {
        FileInputStream in = new FileInputStream(rutaFichero);
        byte[] buffer = new byte[in.available()];
        in.read(buffer);
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(buffer);
        byte[] resume = md.digest();

        return md5.equalsIgnoreCase(Hexadecimal(resume));
    }

    private void obtenerMD5() throws FileNotFoundException
    {
        File file = new File(rutaMD5);
        FileReader f = new FileReader(file);
        try
        {
            BufferedReader b = new BufferedReader(f);
            //leemos linea
            MD5 = b.readLine();
            // nos aseguramos de obtener el md5 (debe de ser el primero)
            MD5 = (MD5.split(" "))[0];
        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(FTP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(FTP.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            try
            {
                f.close();
            } catch (IOException ex)
            {
                Logger.getLogger(FTP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void descargar()
    {
        FileOutputStream fos = null;
        final JFileChooser fc = new JFileChooser();
        if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION)
        {
            try
            {
                String fichero_carpeta = (String) modelo.getValueAt(fila, 0);
                // fc.showSaveDialog(this);
                File file = fc.getSelectedFile();
                System.out.println(file + " Ruta de fichero descargado");
                rutaFichero = file.getAbsolutePath();
                fos = new FileOutputStream(file);
                System.out.println(cliente.retrieveFile(fichero_carpeta, fos));

            } catch (FileNotFoundException ex)
            {
                Logger.getLogger(FTP.class.getName()).log(Level.SEVERE, null, ex);

            } catch (IOException ex)
            {
                Logger.getLogger(FTP.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
            {
                try
                {
                    fos.close();
                } catch (IOException ex)
                {
                    Logger.getLogger(FTP.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void descargarMd5()
    {
        FileOutputStream fos = null;
        final JFileChooser fc = new JFileChooser();
        if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION)
        {
            try
            {
                String fichero_carpeta = (String) modelo.getValueAt(fila, 0);

                // fc.showSaveDialog(this);
                File file = fc.getSelectedFile();
                System.out.println(file);
                rutaMD5 = file.getAbsolutePath();
                fos = new FileOutputStream(file);
                System.out.println(cliente.retrieveFile(fichero_carpeta, fos));

            } catch (FileNotFoundException ex)
            {
                Logger.getLogger(FTP.class.getName()).log(Level.SEVERE, null, ex);

            } catch (IOException ex)
            {
                Logger.getLogger(FTP.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
            {
                try
                {
                    fos.close();

                } catch (IOException ex)
                {
                    Logger.getLogger(FTP.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void conectar()
    {
        usuario = jtfUser.getText();
        clave = jtfPass.getText();
        clave = "2damAlquerias";
        servFTP = jtfDireccion.getText();
        /* if(!jtfPass.getText().equals(""))
            clave=jtfPass.getText();*/

        try
        {
            cliente.setPassiveNatWorkaround(false);
            cliente.connect(servFTP, 21);
            boolean login = cliente.login(usuario, clave);
            if (login)
            {
                System.out.println("Conexión ok");
            }
            else
            {
                System.out.println("Login incorrecto");
                cliente.disconnect();
                System.exit(1);
            }
            System.out.println("Directorio actual: " + cliente.printWorkingDirectory());
            cliente.changeWorkingDirectory("debian");
            actualizarJTable();

        } catch (IOException ex)
        {
            Logger.getLogger(FTP.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizarJTable() throws IOException
    {
        //jtable
        modelo = new DefaultTableModel();
        jtbFicheros.setModel(modelo);
        modelo.setColumnCount(0);
        modelo.addColumn("Nombre");
        modelo.addColumn("info");
        modelo.addColumn("Tipo");
        FTPFile[] files = cliente.listFiles();
        System.out.println("Número de ficheros: " + files.length);
        String tipos[] =
        {
            "Fichero", "Directorio", "Enlace"
        };

        for (int i = 0; i < files.length; i++)
        {
            System.out.println("\t" + files[i].getName()
                    + "\t=>" + tipos[files[i].getType()]);
        }
        Object[] fila = new Object[3];
        for (int i = 0; i < files.length; i++)
        {
            fila[0] = files[i].getName();
            fila[1] = files[i].toString();
            fila[2] = tipos[files[i].getType()];
            modelo.addRow(fila);
        }
    }

    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(FTP.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(FTP.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(FTP.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(FTP.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    new FTP().setVisible(true);
                } catch (NoSuchAlgorithmException ex)
                {
                    Logger.getLogger(FTP.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComprobarMd5;
    private javax.swing.JButton btnConectar;
    private javax.swing.JButton btnDescargar;
    private javax.swing.JButton btnDescargarMd5;
    private javax.swing.JButton btnDesconectar;
    private javax.swing.JButton btnFirmar;
    private javax.swing.JButton btnSeleccionarFichero;
    private javax.swing.JButton btnSeleccionarMD5;
    private javax.swing.JButton btnSubirArchivo;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtbFicheros;
    private javax.swing.JTextField jtfDireccion;
    private javax.swing.JPasswordField jtfPass;
    private javax.swing.JTextField jtfUser;
    // End of variables declaration//GEN-END:variables
}
