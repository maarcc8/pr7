package pr7app;

import it.sauronsoftware.ftp4j.FTPAbortedException;
import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPDataTransferException;
import it.sauronsoftware.ftp4j.FTPException;
import it.sauronsoftware.ftp4j.FTPIllegalReplyException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Pr7app {

    public static void main(String[] args) throws MalformedURLException, IOException, IllegalStateException, FTPIllegalReplyException, FTPException, FileNotFoundException, FTPDataTransferException, FTPAbortedException {

        URL url = new URL("http://192.168.122.200/docs/ic10-m04-WindowsServer.pdf");
        url.openConnection();
        InputStream reader = url.openStream();
        FileOutputStream writer = new FileOutputStream("/home/maarcc/Escritorio/marc.cuadrado.pdf");
        byte[] buffer = new byte[153600];
        int bytesRead = 0;
        while ((bytesRead = reader.read(buffer)) > 0) {
            writer.write(buffer, 0, bytesRead);
            buffer = new byte[153600];
        }
        writer.close();
        reader.close();

        FTPClient client = new FTPClient();
        client.connect("srv.toca.cat");
        client.login("fulano", "Platano123");
        client.upload(new java.io.File("/home/maarcc/Escritorio/marc.cuadrado.pdf"));
        client.disconnect(true);

    }

}
