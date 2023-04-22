package Clases;

import Interfaz.Juego;
import sounds.Sonido;

/**
 *
 * @author Fernando Huañec H
 * @email  xfer94x@gmail.com
 */

public class Movimiento_Tubos extends Thread {

    static int velocidad;
    private static int puntos;

    public Movimiento_Tubos() {
        velocidad = 7;
        puntos = 0;
        ocultarTubos();
    }

    private static synchronized void sumarPuntos() {
        int tubo1 = Juego.jTubo_arriba1.getLocation().x;
        int tubo2 = Juego.jTubo_arriba2.getLocation().x;
        if (tubo1 == 90) {
            Sonido.puntos();
            puntos = puntos + 1;
            Juego.jPuntaje.setText(puntos + "");
            if (puntos == 30 || puntos == 50 || puntos == 130 || puntos == 160 || puntos == 200 || puntos == 300) {
                velocidad = velocidad - 1;
            }
        } else if (tubo2 == 90) {
            Sonido.puntos();
            puntos = puntos + 1;
            Juego.jPuntaje.setText(puntos + "");
            if (puntos == 30 || puntos == 50 || puntos == 130 || puntos == 160 || puntos == 200 || puntos == 300) {
                velocidad = velocidad - 1;
            }
        }
    }

    @Override
    public void run() {
        int posicion1 = generarPosicionAleatoria();
        int posicion2 = generarPosicionAleatoria();
        int x1 = Juego.jTubo_arriba1.getLocation().x;
        int x2 = Juego.jTubo_arriba2.getLocation().x;
        while (true) {
            try {
                Thread.sleep(getVelocidad());
                x1--;
                x2--;
                Juego.jTubo_arriba1.setLocation(x1, posicion1);
                Juego.jTubo_abajo1.setLocation(x1, (posicion1 + 425));
                Juego.jTubo_arriba2.setLocation(x2, posicion2);
                Juego.jTubo_abajo2.setLocation(x2, (posicion2 + 425));
                if (x1 <= -51) {
                    posicion1 = generarPosicionAleatoria();
                    x1 = 425;
                }
                if (x2 <= -51) {
                    posicion2 = generarPosicionAleatoria();
                    x2 = 425;
                }
                sumarPuntos();
            } catch (InterruptedException ex) {
                System.out.println("problema al mover los tubos " + ex);
            }
        }
    }

    private void ocultarTubos() {
        Juego.jTubo_arriba1.setLocation(460, 500);
        Juego.jTubo_abajo1.setLocation(460, 1000);
        Juego.jTubo_arriba2.setLocation(700, 500);
        Juego.jTubo_abajo2.setLocation(700, 1000);
    }

    public int getVelocidad() {
        return velocidad;
    }

    private int generarPosicionAleatoria() {
        int numero = (int) (Math.random() * (0 - (-200)) + (-200));
        return numero;
    }

}
