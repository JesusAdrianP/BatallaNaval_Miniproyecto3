package myProject;

import java.util.ArrayList;
import java.util.Random;

public class JugadorPc {
    private Barco barco1, barco2, barco3, barco4, barco5, barco6, barco7, barco8, barco9, barco10;
    private ArrayList<Barco> barcos;
    private Casillas[][] casillasPc;
    private Random random;


    public JugadorPc() {
        barcos = new ArrayList<>();
        barco1 = new Barco("p");
        barcos.add(barco1);
        barco2 = new Barco("s");
        barcos.add(barco2);
        barco3 = new Barco("s");
        barcos.add(barco3);
        barco4 = new Barco("d");
        barcos.add(barco4);
        barco5 = new Barco("d");
        barcos.add(barco5);
        barco6 = new Barco("d");
        barcos.add(barco6);
        barco7 = new Barco("f");
        barcos.add(barco7);
        barco8 = new Barco("f");
        barcos.add(barco8);
        barco9 = new Barco("f");
        barcos.add(barco9);
        barco10 = new Barco("f");
        barcos.add(barco10);

        random = new Random();

        casillasPc = new Casillas[10][10];
        arrayBidCasillas();
    }

    public void arrayBidCasillas(){
        for (int i=0; i < casillasPc.length; i++){
            for (int j=0; j < casillasPc.length; j++){
                casillasPc[i][j] = new Casillas(0, false);
            }
        }
    }



    /**
     * genera una coordenada aleatoria y marcaesa posicion como true para
     * recordar que ahí ya hubo un disparo, en caso de haber un disparo previo
     * realiza la instrucción de nuevo.
     */
    public void disparar(){
        int pcX, pcY;
        do {
            pcX = random.nextInt(10);
            pcY = random.nextInt(10);
            casillasPc[pcX][pcY].setDisparo(true);
        }while (casillasPc[pcX][pcY].isDisparo() != true);
    }


    public void posicionarBarcos(){
        int numBarco = 0;
        int fila = 0;

        while (numBarco < 10){

            int casillas = barcos.get(numBarco).getCasillasPorBarco();
            int columna = 0;

            switch (casillas){
                case 1: columna = random.nextInt(10);
                    break;
                case 2: columna = random.nextInt(9);
                    break;
                case 3: columna = random.nextInt(8);
                    break;
                case 4: columna = random.nextInt(7);
                    break;
            }

            /**
             * necesitamos un for que convierta el 0 del idBarco de la casilla a su identidicador
             */

            for (int vidaBarco = barcos.get(numBarco).getCasillasPorBarco();vidaBarco > 0 ; vidaBarco--){
                if (casillas==4){
                    casillasPc[fila][columna].setIdbarco(4);
                    columna++;
                }else if (casillas==3){
                    casillasPc[fila][columna].setIdbarco(3);
                    columna++;
                }else if (casillas==2){
                    casillasPc[fila][columna].setIdbarco(2);
                    columna++;
                }else{
                    casillasPc[fila][columna].setIdbarco(1);
                    columna++;
                }

            }

            fila++;
            numBarco++;

        }

    }

    /**
     * Falta el metodo para saber que se recibió un disparo y asi cambiar la imagen
     * @return
     */


    public Casillas[][] getBarcosPc() {
        return casillasPc;
    }


    public ArrayList<Barco> getBarcos() {
        return barcos;
    }

    public void mostrar(){
        for (int x=0; x < casillasPc.length; x++){
            for (int y=0; y < casillasPc[x].length; y++)
                System.out.print(" | " + casillasPc[x][y].getIdbarco()+ " | ");
            System.out.println("\n--------------------------------------------------------------");
        }
    }

    public void mostrarDisparos(){
        for (int x=0; x < casillasPc.length; x++){
            for (int y=0; y < casillasPc[x].length; y++)
                System.out.print(" | " + casillasPc[x][y].isDisparo()+ " | ");
            System.out.println("\n--------------------------------------------------------------");
        }
    }
}



