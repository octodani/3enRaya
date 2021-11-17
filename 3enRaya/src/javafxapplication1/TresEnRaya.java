/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.util.Random;

/**
 * Esta clase gestiona la lógica de la aplicación
 * @author Daniel
 */
public class TresEnRaya {
    
    private int contador = 0;
    private int ganador = 3;
    private static int equipoJugador = -1;
    private static int equipoCPU = -1;
    private boolean esTurno = true;
    
    private int [][] tablero = {
        {-1, -1, -1},
        {-1, -1, -1},
        {-1, -1, -1}
    };

    public static int getEquipoJugador() {
        return equipoJugador;
    }

    public static void setEquipoJugador(int equipoJugador) {
        TresEnRaya.equipoJugador = equipoJugador;
    }

    public static int getEquipoCPU() {
        return equipoCPU;
    }
    
    /**
     * Asigna el equipo de la CPU al equipo que no elija el jugador
     */
    public static void setEquipoCPU() {
        if(equipoJugador == 0) {
            equipoCPU = 1;
        } else if (equipoJugador == 1) {
            equipoCPU = 0;
        }
    }

    public boolean esTurno() {
        return esTurno;
    }

    public void setEsTurno(boolean esTurno) {
        this.esTurno = esTurno;
    }

    public int[][] getTablero() {
        return tablero;
    }
    
    /**
     * Registra un movimiento en el tablero
     * @param j fila en la que se realiza el movimiento
     * @param i columna en la que se realiza el movimiento
     * @param equipo equipo que ha realizado el movimiento
     */
    public void setTablero(int j, int i, int equipo) {
        tablero[i][j] = equipo;
        contador++;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public int getGanador() {
        return ganador;
    }

    public void setGanador(int ganador) {
        this.ganador = ganador;
    }
    
    static Random rndR = new Random();
    static Random rndC = new Random();
    
    /**
     * Realiza un movimiento aleatorio por parte de la CPU
     * @return la posición del tablero en la que se ha realizado el movimiento
     */
    public int[] turnoCPU() {
        int[] posicion = new int[2];
        int i = rndR.nextInt(3);
        int j = rndC.nextInt(3);
        posicion[0] = i;
        posicion[1] = j;

        while (tablero[i][j] != -1) {
            i = rndR.nextInt(3);
            j = rndC.nextInt(3);
            posicion[0] = i;
            posicion[1] = j;
        }
        tablero[i][j] = equipoCPU;
        contador++;
        return posicion;
    }
    
    /**
     * Comprueba si se ha conseguido 3 en raya
     * @return true o false según si se ha producido o no el 3 en raya
     */
    public boolean estaAlineado() {
        boolean raya = false;
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero [i][2] && tablero[i][0] != -1) {
                raya = true;
                break;
            } else if (tablero[0][i] == tablero[1][i] && tablero[1][i] == tablero [2][i] && tablero[0][i] != -1) {
                raya = true;
                break;
            } else if (tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero [2][2] && tablero[0][0] != -1) {
                raya = true;
                break;
            } else if (tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero [2][0] && tablero[0][2] != -1) {
                raya = true;
                break;
            }
        }
        return raya;
    }
    
    /**
     * Identifica qué jugador ha conseguido el 3 en raya o si se ha llegado a
     * un empate
     */
    public void identificarGanador() {
        if (estaAlineado() && esTurno == true) {
            ganador = 1;
        } else if (estaAlineado() && esTurno == false) {
            ganador = 0;
        } else if (!estaAlineado() && contador >= 9) {
            ganador = -1;
        }
    }
    
}
