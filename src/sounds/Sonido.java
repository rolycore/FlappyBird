package sounds;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Sonido {

    private static File file;
    private static String ruta;
    public static boolean terminochoque = true;
    public static boolean terminocaida = true;

    public static void saltar() {
        file = new File(".");
        ruta = file.getAbsolutePath();
        Thread hilo = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1);
                    FileInputStream fis;
                    Player player;
                    try{
                        fis = new FileInputStream(ruta + "/src/sounds/saltar.mp3");
                    }catch (FileNotFoundException e){
                        fis = new FileInputStream(ruta + "/complementos/saltar.mp3");
                    }
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    player = new Player(bis);
                    player.play();
                    stop();
                } catch (InterruptedException | JavaLayerException | FileNotFoundException e) {
                    System.out.println(" error " + e);
                }

            }
        };
        hilo.start();
    }

    public static void caida() {
        if (terminocaida){
            terminocaida = false;
            file = new File(".");
            ruta = file.getAbsolutePath();
            Thread hilo = new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(500);
                        FileInputStream fis;
                        Player player;
                        try{
                            fis = new FileInputStream(ruta + "/src/sounds/caida.mp3");
                        }catch (FileNotFoundException e){
                            fis = new FileInputStream(ruta + "/complementos/caida.mp3");
                        }
                        BufferedInputStream bis = new BufferedInputStream(fis);
                        player = new Player(bis);
                        player.play();
                        stop();
                    } catch (InterruptedException | JavaLayerException | FileNotFoundException e) {
                    }
                }
            };
            hilo.start();
        }
    }

    public static void choque() {
        if (terminochoque){
            terminochoque = false;
            file = new File(".");
            ruta = file.getAbsolutePath();
            Thread hilo = new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1);
                        FileInputStream fis;
                        Player player;
                        try{
                            fis = new FileInputStream(ruta + "/src/sounds/choque.mp3");
                        }catch(FileNotFoundException e){
                            fis = new FileInputStream(ruta + "/complementos/choque.mp3");
                        }
                        BufferedInputStream bis = new BufferedInputStream(fis);
                        player = new Player(bis);
                        player.play();
                        stop();
                    } catch (InterruptedException | JavaLayerException | FileNotFoundException e) {
                    }
                }
            };
            hilo.start();
        }
    }

    public static void puntos() {
        file = new File(".");
        ruta = file.getAbsolutePath();
        Thread hilo = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1);
                    FileInputStream fis;
                    Player player;
                    try{
                        fis = new FileInputStream(ruta + "/src/sounds/puntos.mp3");
                    } catch(FileNotFoundException e){
                        fis = new FileInputStream(ruta + "/complementos/puntos.mp3");
                    }
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    player = new Player(bis);
                    player.play();
                    stop();
                } catch (InterruptedException | JavaLayerException | FileNotFoundException e) {
                }
            }
        };
        hilo.start();
    }

}
