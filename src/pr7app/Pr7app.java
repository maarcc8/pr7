/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr7app;

/**
 *
 * @author ivan
 */
public class Pr7app {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        URL url = new URL("http://192.168.122.200/docs/ic10-m04-WindowsServer.pdf");
        url.openConnection();
        InputStream reader = url.openStream();
        FileOutputStream writer = new FileOutputStream("maarcc");
        byte[] buffer = new byte[153600];
        int bytesRead = 0;
        while ((bytesRead = reader.read(buffer)) > 0) {
            writer.write(buffer, 0, bytesRead);
            buffer = new byte[153600];
        }
        writer.close();
        reader.close();

        FTPClient client = new FTPClient();
        client.connect("ftp.host.com");
        client.login("carlo", "mypassword");
        client.upload(new java.io.File("localFile.ext"));
        client.disconnect(true);

    }

}
