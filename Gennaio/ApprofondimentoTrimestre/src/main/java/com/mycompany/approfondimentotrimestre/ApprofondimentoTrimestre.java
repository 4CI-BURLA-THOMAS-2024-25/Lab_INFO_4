package com.mycompany.approfondimentotrimestre;

/**
 *
 * @author Thomas Burla
 * @version 1.0
 */
public class ApprofondimentoTrimestre {
    public static void main(String[] args) {
        Punto p1 = new Punto(5, 7);
        Punto p2 = new Punto(-4, 3);
        Punto p3 = new Punto(-1, -3);
        Punto p = new Punto(-1, 2);
        Triangolo triangolo = new Triangolo(p1, p2, p3);
        System.out.println(triangolo.puntoInterno(p));
    }
}