package com.mycompany.approfondimentotrimestre;

/**
 *
 * @author Thomas Burla
 * @version 1.0
 */
public class ApprofondimentoTrimestre {
    public static void main(String[] args) {
        Punto p1 = new Punto(-5, -6);
        Punto p2 = new Punto(6, 1);
        Punto p3 = new Punto(3, 3);
        Punto p = new Punto(1, -1);
        Triangolo triangolo = new Triangolo(p1, p2, p3);
        System.out.println(triangolo.puntoInterno(p));
    }
}
