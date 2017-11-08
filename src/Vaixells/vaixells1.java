package Vaixells;


import java.util.Random;
import java.util.Scanner;

public class vaixells1 {

    static int[] shipPosition;
    static int[][] globalVector;
    static int[] globalShoot;

    public static void main(String[] args) {

        shipPosition = random();
        //System.out.println("impriir posicions vaixell " + shipPosition[0] + "" + shipPosition[1]); //esborrar després
        globalVector = initBoard(1, 0);
        globalShoot = shoot();
        //System.out.println("imprimir primera coord usuari " + globalShoot[0]); // treure aquesta línia després
        //System.out.println("imprimir segona coord usuari " + globalShoot[1]); // treure aquesta línia després
        globalVector = shotHit();
        hint();

        int counter = 1;

        while ((shipPosition[0] != globalShoot[0]) || (shipPosition[1] != globalShoot[1])) {

            counter++;
            globalShoot = shoot();
            //System.out.println("imprimir primera coord usuari " + globalShoot[0]); // treure aquesta línia després
            //System.out.println("imprimir segona coord usuari " + globalShoot[1]); // treure aquesta línia després
            globalVector = shotHit();
            hint();
        }

        System.out.println("");
        System.out.println("Has guanyat en " + counter + " torns!");

    }

    public static int[] random() {

        Random position = new Random();
        int x = position.nextInt(5);
        int y = position.nextInt(5);

        return new int[]{x, y};

    }

    public static int[][] initBoard(int col, int row) {

        // inicialment estableix el valor -1 en tots els blocs del tauler +
        // obté la matriu i mostra el joc de taula +
        // selecciona aleatòriament 1 parell de nombres enters, que és la ubicació del vaixell

        int[][] vectorTaula = new int[5][5];

        int x = shipPosition[0];
        int y = shipPosition[1];

        System.out.println("");

        for (int i = 0; i < vectorTaula.length; i++) {

            for (int j = 0; j < vectorTaula.length; j++) {

                if (i!=x || j!=y) {

                    vectorTaula[i][j] = -1;
                    System.out.print(" ~ ");

                } else {

                    vectorTaula[x][y] = 2;
                    System.out.print(" ~ ");

                }

            }

            System.out.println("");

        }

        //System.out.println("Imprimir valor array no vaixell "+ vectorTaula[1][2]);
        //System.out.println("imprimir primera coord vaixell " + x); //TREURE AQUESTES DUES LÍNIES, MÉS ENDAVANT
        //System.out.println("imprimir segona coord vaixell " + y); //TREURE AQUESTES DUES LÍNIES, MÉS ENDAVANT

        return vectorTaula;

    }

    public static int[] shoot() { //obté una tirada (columna i fila) de l'usuari, i emmagatzema en una injecció variable []


        Scanner sc = new Scanner(System.in);
        int[] userShoot = new int[2];


        System.out.println(" ");
        System.out.println("Introdueix una filera (1-5): ");
        System.out.println("");

        userShoot[0] = sc.nextInt()-1;

        System.out.println("");
        System.out.println("Introdueix una columna (1-5): ");
        System.out.println("");

        userShoot[1] = sc.nextInt()-1;

        //System.out.println("imprimir primera coord usuari " + userShoot[0]); // treure aquesta línia després
        //System.out.println("imprimir segona coord usuari " + userShoot[1]); // treure aquesta línia després


        return userShoot;

        //obté una tirada (columna i fila) de l'usuari, i emmagatzema en una injecció variable []


    }

    public static int[][] shotHit() { //comprova si el tret ha tocat algun vaixell

        int a = globalShoot[0];
        int b = globalShoot[1];

        if (globalVector[a][b] == 2) {

            globalVector[a][b] = 1;
            System.out.println("");
            System.out.println("Acabes d'enfonsar un vaixell! Glup glup! ");
            System.out.println("");

        } else if (globalVector[a][b] == 0) {

            System.out.println("");
            System.out.println("Ja havies disparat aquí i t'he dit que no hi havia res, recordes?");
            System.out.println("");

        } else if (globalVector[a][b] == -1) {

            globalVector[a][b] = 0;
            System.out.println("");
            System.out.println("Aquí només hi ha aigua!");
            System.out.println("");

        } else if (globalVector[a][b] == 1) {

            System.out.println("");
            System.out.println("Ja havies disparat aquí i vas enfonsar un vaixell, recordes?");
            System.out.println("");

        }

        for (int i = 0; i < globalVector.length; i++) {

            for (int j = 0; j < globalVector.length; j++) {

                if (globalVector[i][j] == -1) {

                    System.out.print(" ~ ");

                } else if (globalVector[i][j] == 0) {

                    System.out.print(" * ");

                } else if (globalVector[i][j] == 1){

                    System.out.print(" x ");

                } else {

                    System.out.print(" ~ ");
                }

            }

            System.out.println(" ");

        }

        return globalVector;

    }

    public static void hint() { //diu quants vaixells es troben en aquesta fila i la columna on s'ha donat el tir

        if ((shipPosition[0] != globalShoot[0]) || (shipPosition[1] != globalShoot[1])){

            if (shipPosition[0] == globalShoot[0]) {

                System.out.println("");
                System.out.println("El vaixell es troba en aquesta filera.");
                System.out.println("");

            } else {
                System.out.println("");
                System.out.println("En aquesta filera no hi ha cap vaixell.");
                System.out.println("");

            }

            if (shipPosition[1] == globalShoot[1]) {

                System.out.println("El vaixell es troba en aquesta columna.");
                System.out.println("");

            } else {
                System.out.println("En aquesta columna no hi ha cap vaixell.");
                System.out.println("");

            }

        }
    }

}

/* PROBLEMES A SOLUCIONAR:

- 3 VAIXELLS?
- coordenada 0-0 establida amb valor 0 a l'entrada al bucle.... why?5
5

 */


