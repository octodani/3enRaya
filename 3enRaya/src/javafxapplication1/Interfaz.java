/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;


import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *Esta clase gestiona la parte gráfica de la aplicación
 * @author Daniel
 */
public class Interfaz extends Application {
    Image pathFondo = new Image("Images/fondo.jpg");
    ImageView fondo = new ImageView(pathFondo);

    Image pathO = new Image("Images/o.png");
    ImageView o = new ImageView(pathO);

    Image pathX = new Image("Images/x.png");
    ImageView x = new ImageView(pathX);

    Image pathEquipo = new Image("Images/escogerEquipo.png");
    ImageView equipo = new ImageView(pathEquipo);

    Image pathHasGanado = new Image("Images/hasGanado.png");
    ImageView hasGanado = new ImageView(pathHasGanado);

    Image pathHasPerdido = new Image("Images/hasPerdido.png");
    ImageView hasPerdido = new ImageView(pathHasPerdido);

    Image pathEmpate = new Image("Images/empate.png");
    ImageView empate = new ImageView(pathEmpate);

    Image pathOtraPartida = new Image("Images/otraPartida.png", 0, 100, true, false);
    ImageView otraPartida = new ImageView(pathOtraPartida);

    Image pathSalir = new Image("Images/salir.png", 0, 100, true, false);
    ImageView salir = new ImageView(pathSalir);
    
    Image pathTablero = new Image("Images/tablerovacio.png", 600, 0, true, false);
    ImageView tablero = new ImageView (pathTablero);
    
    GridPane gridTablero = null;
    
    Rectangle casillaO = new Rectangle(pathOtraPartida.getWidth(), pathOtraPartida.getHeight(), Color.rgb(100, 100, 100, 0));
    Rectangle casillaX = new Rectangle(pathSalir.getWidth(), pathSalir.getHeight(), Color.rgb(100, 100, 100, 0));
        
    Rectangle casilla00 = new Rectangle(pathTablero.getWidth() / 3 - 15, pathTablero.getHeight() / 3 - 10, Color.rgb(100, 100, 100, 0));
    Rectangle casilla01 = new Rectangle(pathTablero.getWidth() / 3 - 15, pathTablero.getHeight() / 3 - 10, Color.rgb(100, 100, 100, 0));
    Rectangle casilla02 = new Rectangle(pathTablero.getWidth() / 3 - 15, pathTablero.getHeight() / 3 + 20, Color.rgb(100, 100, 100, 0));
    Rectangle casilla10 = new Rectangle(pathTablero.getWidth() / 3 - 15, pathTablero.getHeight() / 3 - 10, Color.rgb(100, 100, 100, 0));
    Rectangle casilla11 = new Rectangle(pathTablero.getWidth() / 3 - 15, pathTablero.getHeight() / 3 - 10, Color.rgb(100, 100, 100, 0));
    Rectangle casilla12 = new Rectangle(pathTablero.getWidth() / 3 - 15, pathTablero.getHeight() / 3 + 20, Color.rgb(100, 100, 100, 0));
    Rectangle casilla20 = new Rectangle(pathTablero.getWidth() / 3 + 30, pathTablero.getHeight() / 3 - 10, Color.rgb(100, 100, 100, 0));
    Rectangle casilla21 = new Rectangle(pathTablero.getWidth() / 3 + 30, pathTablero.getHeight() / 3 - 10, Color.rgb(100, 100, 100, 0));
    Rectangle casilla22 = new Rectangle(pathTablero.getWidth() / 3 + 30, pathTablero.getHeight() / 3 + 20, Color.rgb(100, 100, 100, 0));
    
    Rectangle casillaOtraPartida = new Rectangle(pathOtraPartida.getWidth(), pathOtraPartida.getHeight(), Color.rgb(100, 100, 100, 0));
    Rectangle casillaSalir = new Rectangle(pathSalir.getWidth(), pathSalir.getHeight(), Color.rgb(100, 100, 100, 0));
    
    TresEnRaya ter  = new TresEnRaya();
    
    InnerShadow sombra = new InnerShadow(7, 3, 5, Color.BLACK);
    DropShadow sombraClara = new DropShadow(7, 3, 5, Color.GREY);
    
    HBox contenedorEquipo = null;
    VBox contenedorSeleccionarEquipo = null;
    HBox finalPartida = null;
    VBox contenedorFinalPartida = null;
    
    StackPane botonO = null;
    StackPane botonX = null;
    
    StackPane root = null;
    StackPane pantalla = null;
    StackPane botonOtraPartida = null;
    StackPane botonSalir = null;
    
    Scene seleccionEquipo = null;
    
    @Override
    public void start(Stage primaryStage) {
        botonO = new StackPane();
        botonX = new StackPane();
        botonO.getChildren().addAll(casillaO, o);
        botonX.getChildren().addAll(casillaX, x);
        
        contenedorEquipo = new HBox();
        contenedorEquipo.setSpacing(240);
        contenedorEquipo.setAlignment(Pos.CENTER);
        contenedorEquipo.getChildren().addAll(botonO, botonX);
        
        contenedorSeleccionarEquipo = new VBox();
        contenedorSeleccionarEquipo.setSpacing(80);
        contenedorSeleccionarEquipo.setAlignment(Pos.CENTER);
        contenedorSeleccionarEquipo.getChildren().addAll(equipo, contenedorEquipo);
        
        finalPartida = new HBox();
        finalPartida.setSpacing(100);
        
        contenedorFinalPartida = new VBox();
        contenedorFinalPartida.setSpacing(180);
        
        root = new StackPane();
        pantalla = new StackPane();
        pantalla.getChildren().add(contenedorSeleccionarEquipo);
        root.getChildren().addAll(fondo, pantalla);
        
        botonOtraPartida = new StackPane();
        botonSalir = new StackPane();
        botonOtraPartida.getChildren().addAll(casillaOtraPartida, otraPartida);
        botonSalir.getChildren().addAll(casillaSalir, salir);
        finalPartida.setAlignment(Pos.CENTER);
        finalPartida.getChildren().addAll(botonOtraPartida, botonSalir);
        
        seleccionEquipo = new Scene(root);
        
        primaryStage.setMaximized(true);
        primaryStage.setTitle("3 en raya");
        primaryStage.setResizable(false);
        primaryStage.setScene(seleccionEquipo);
        primaryStage.sizeToScene();
        primaryStage.show();
        
        botonO.setOnMouseEntered((MouseEvent) -> {
            o.setEffect(sombra);
        });
        
        botonO.setOnMouseExited((MouseEvent) -> {
            o.setEffect(null);
        });
        
        botonO.setOnMouseClicked((MouseEvent) -> {
            TresEnRaya.setEquipoJugador(0);
            TresEnRaya.setEquipoCPU();
            crearPartida();
        });
        
        botonX.setOnMouseEntered((MouseEvent) -> {
            x.setEffect(sombra);
        });
        
        botonX.setOnMouseExited((MouseEvent) -> {
            x.setEffect(null);
        });
        
        botonX.setOnMouseClicked((MouseEvent) -> {
            TresEnRaya.setEquipoJugador(1);
            TresEnRaya.setEquipoCPU();
            crearPartida();
        });
        
        botonOtraPartida.setOnMouseClicked((event) -> {
            crearPartida();
        });
        
        botonOtraPartida.setOnMouseEntered((MouseEvent) -> {
            otraPartida.setEffect(sombraClara);
        });
        
        botonOtraPartida.setOnMouseExited((MouseEvent) -> {
            otraPartida.setEffect(null);
        });
        
        botonSalir.setOnMouseClicked((event) -> {
            System.exit(0);
        });
        
        botonSalir.setOnMouseEntered((MouseEvent) -> {
            salir.setEffect(sombraClara);
        });
        
        botonSalir.setOnMouseExited((MouseEvent) -> {
            salir.setEffect(null);
        });
        
        /**
         * Inserta en la casilla 00 la ficha del equipo del jugador
         */
        casilla00.setOnMouseClicked((MouseEvent) -> {
            if (ter.getContador() < 9 && ter.getGanador() == 3) { // Evalúa si se han producido más de 9 movimientos y si todavía no hay ningún ganador
                ter.setTablero(0, 0, ter.getEquipoJugador()); // Inserta en el tablero el movimiento del jugador
                ImageView fichaJugador = asignarFichaJugador(pathO, pathX); // Se crea un objeto con la ficha para el jugador
                ImageView fichaCPU = asignarFichaCPU(pathO, pathX); // Se crea un objeto con la ficha de la CPU
                gridTablero.add(fichaJugador, 0, 0); // Se añade la imagen correspondiente al movimiento del jugador
                GridPane.setHalignment(fichaJugador, HPos.CENTER); // Posiciona la imagen de la ficha en el centro horizontalmente
                GridPane.setValignment(fichaJugador, VPos.CENTER); // Posiciona la imagen de la ficha en el centro vertical
                evaluarVictoria(); // Se comprueba si algún jugador ha ganado
                ter.setEsTurno(false); // Se cambia el turno del jugador
                if (ter.getContador() < 9 && ter.getGanador() == 3) { // Se evalúa de nuevo si se han producido más de 9 movimientos y si todavía no hay ningún ganador
                    int[] posicion = ter.turnoCPU(); // Se genera el movimiento de la CPU y se inserta en el tablero
                    gridTablero.add(fichaCPU, posicion[1], posicion[0]); // Se añade la imagen correspondiente al movimiento de la CPU
                    GridPane.setHalignment(fichaCPU, HPos.CENTER); // Posiciona la imagen de la ficha en el centro horizontalmente
                    GridPane.setValignment(fichaCPU, VPos.CENTER); // Posiciona la imagen de la ficha en el centro verticalmente
                    evaluarVictoria(); // Se evalúa de nuevo si algún jugador ha ganado
                    ter.setEsTurno(true); // Se vuelve a cambiar el turno del jugador
                }
            } else {
                desactivarCasillas(); // Si hay más de 9 movimientos o algún jugador ha ganado se desactivan las casillas
            }
        });
        
        casilla01.setOnMouseClicked((MouseEvent) -> {
            if (ter.getContador() < 9 && ter.getGanador() == 3) {
                ter.setTablero(0, 1, ter.getEquipoJugador());
                ImageView fichaJugador = asignarFichaJugador(pathO, pathX);
                ImageView fichaCPU = asignarFichaCPU(pathO, pathX);
                gridTablero.add(fichaJugador, 0, 1);
                GridPane.setHalignment(fichaJugador, HPos.CENTER);
                GridPane.setValignment(fichaJugador, VPos.CENTER);
                evaluarVictoria();
                ter.setEsTurno(false);
                if (ter.getContador() < 9 && ter.getGanador() == 3) {
                    int[] posicion = ter.turnoCPU();
                    gridTablero.add(fichaCPU, posicion[1], posicion[0]);
                    GridPane.setHalignment(fichaCPU, HPos.CENTER);
                    GridPane.setValignment(fichaCPU, VPos.CENTER);
                    evaluarVictoria();
                    ter.setEsTurno(true);
                }
            } else {
                desactivarCasillas();
            }
        });
                
        casilla02.setOnMouseClicked((MouseEvent) -> {
            if (ter.getContador() < 9 && ter.getGanador() == 3) {
                ter.setTablero(0, 2, ter.getEquipoJugador());
                ImageView fichaJugador = asignarFichaJugador(pathO, pathX);
                ImageView fichaCPU = asignarFichaCPU(pathO, pathX);
                gridTablero.add(fichaJugador, 0, 2);
                GridPane.setHalignment(fichaJugador, HPos.CENTER);
                GridPane.setValignment(fichaJugador, VPos.CENTER);
                evaluarVictoria();
                ter.setEsTurno(false);
                if (ter.getContador() < 9 && ter.getGanador() == 3) {
                    int[] posicion = ter.turnoCPU();
                    gridTablero.add(fichaCPU, posicion[1], posicion[0]);
                    GridPane.setHalignment(fichaCPU, HPos.CENTER);
                    GridPane.setValignment(fichaCPU, VPos.CENTER);
                    evaluarVictoria();
                    ter.setEsTurno(true);
                }
            } else {
                desactivarCasillas();
            }
        });
        
        casilla10.setOnMouseClicked((MouseEvent) -> {
            if (ter.getContador() < 9 && ter.getGanador() == 3) {
                ter.setTablero(1, 0, ter.getEquipoJugador());
                ImageView fichaJugador = asignarFichaJugador(pathO, pathX);
                ImageView fichaCPU = asignarFichaCPU(pathO, pathX);
                gridTablero.add(fichaJugador, 1, 0);
                GridPane.setHalignment(fichaJugador, HPos.CENTER);
                GridPane.setValignment(fichaJugador, VPos.CENTER);
                evaluarVictoria();
                ter.setEsTurno(false);
                if (ter.getContador() < 9 && ter.getGanador() == 3) {
                    int[] posicion = ter.turnoCPU();
                    gridTablero.add(fichaCPU, posicion[1], posicion[0]);
                    GridPane.setHalignment(fichaCPU, HPos.CENTER);
                    GridPane.setValignment(fichaCPU, VPos.CENTER);
                    evaluarVictoria();
                    ter.setEsTurno(true);
                }
            } else {
                desactivarCasillas();
            }
        });
        
        casilla11.setOnMouseClicked((MouseEvent) -> {
            if (ter.getContador() < 9 && ter.getGanador() == 3) {
                ter.setTablero(1, 1, ter.getEquipoJugador());
                ImageView fichaJugador = asignarFichaJugador(pathO, pathX);
                ImageView fichaCPU = asignarFichaCPU(pathO, pathX);
                gridTablero.add(fichaJugador, 1, 1);
                GridPane.setHalignment(fichaJugador, HPos.CENTER);
                GridPane.setValignment(fichaJugador, VPos.CENTER);
                evaluarVictoria();
                ter.setEsTurno(false);
                if (ter.getContador() < 9 && ter.getGanador() == 3) {
                    int[] posicion = ter.turnoCPU();
                    gridTablero.add(fichaCPU, posicion[1], posicion[0]);
                    GridPane.setHalignment(fichaCPU, HPos.CENTER);
                    GridPane.setValignment(fichaCPU, VPos.CENTER);
                    evaluarVictoria();
                    ter.setEsTurno(true);
                }
            } else {
                desactivarCasillas();
            }
        });
        
        casilla12.setOnMouseClicked((MouseEvent) -> {
            if (ter.getContador() < 9 && ter.getGanador() == 3) {
                ter.setTablero(1, 2, ter.getEquipoJugador());
                ImageView fichaJugador = asignarFichaJugador(pathO, pathX);
                ImageView fichaCPU = asignarFichaCPU(pathO, pathX);
                gridTablero.add(fichaJugador, 1, 2);
                GridPane.setHalignment(fichaJugador, HPos.CENTER);
                GridPane.setValignment(fichaJugador, VPos.CENTER);
                evaluarVictoria();
                ter.setEsTurno(false);
                if (ter.getContador() < 9 && ter.getGanador() == 3) {
                    int[] posicion = ter.turnoCPU();
                    gridTablero.add(fichaCPU, posicion[1], posicion[0]);
                    GridPane.setHalignment(fichaCPU, HPos.CENTER);
                    GridPane.setValignment(fichaCPU, VPos.CENTER);
                    evaluarVictoria();
                    ter.setEsTurno(true);
                }
            } else {
                desactivarCasillas();
            }
        });
        
        casilla20.setOnMouseClicked((MouseEvent) -> {
            if (ter.getContador() < 9 && ter.getGanador() == 3) {
                ter.setTablero(2, 0, ter.getEquipoJugador());
                ImageView fichaJugador = asignarFichaJugador(pathO, pathX);
                ImageView fichaCPU = asignarFichaCPU(pathO, pathX);
                gridTablero.add(fichaJugador, 2, 0);
                GridPane.setHalignment(fichaJugador, HPos.CENTER);
                GridPane.setValignment(fichaJugador, VPos.CENTER);
                evaluarVictoria();
                ter.setEsTurno(false);
                if (ter.getContador() < 9 && ter.getGanador() == 3) {
                    int[] posicion = ter.turnoCPU();
                    gridTablero.add(fichaCPU, posicion[1], posicion[0]);
                    GridPane.setHalignment(fichaCPU, HPos.CENTER);
                    GridPane.setValignment(fichaCPU, VPos.CENTER);
                    evaluarVictoria();
                    ter.setEsTurno(true);
                }
            } else {
                desactivarCasillas();
            }
        });
        
        casilla21.setOnMouseClicked((MouseEvent) -> {
            if (ter.getContador() < 9 && ter.getGanador() == 3) {
                ter.setTablero(2, 1, ter.getEquipoJugador());
                ImageView fichaJugador = asignarFichaJugador(pathO, pathX);
                ImageView fichaCPU = asignarFichaCPU(pathO, pathX);
                gridTablero.add(fichaJugador, 2, 1);
                GridPane.setHalignment(fichaJugador, HPos.CENTER);
                GridPane.setValignment(fichaJugador, VPos.CENTER);
                evaluarVictoria();
                ter.setEsTurno(false);
                if (ter.getContador() < 9 && ter.getGanador() == 3) {
                    int[] posicion = ter.turnoCPU();
                    gridTablero.add(fichaCPU, posicion[1], posicion[0]);
                    GridPane.setHalignment(fichaCPU, HPos.CENTER);
                    GridPane.setValignment(fichaCPU, VPos.CENTER);
                    evaluarVictoria();
                    ter.setEsTurno(true);
                }
            } else {
                desactivarCasillas();
            }
        });
        
        casilla22.setOnMouseClicked((MouseEvent) -> {
            if (ter.getContador() < 9 && ter.getGanador() == 3) {
                ter.setTablero(2, 2, ter.getEquipoJugador());
                ImageView fichaJugador = asignarFichaJugador(pathO, pathX);
                ImageView fichaCPU = asignarFichaCPU(pathO, pathX);
                gridTablero.add(fichaJugador, 2, 2);
                GridPane.setHalignment(fichaJugador, HPos.CENTER);
                GridPane.setValignment(fichaJugador, VPos.CENTER);
                evaluarVictoria();
                ter.setEsTurno(false);
                if (ter.getContador() < 9 && ter.getGanador() == 3) {
                    int[] posicion = ter.turnoCPU();
                    gridTablero.add(fichaCPU, posicion[1], posicion[0]);
                    GridPane.setHalignment(fichaCPU, HPos.CENTER);
                    GridPane.setValignment(fichaCPU, VPos.CENTER);
                    evaluarVictoria();
                    ter.setEsTurno(true);
                }
            } else {
                desactivarCasillas();
            }
        });
        
    }
    
    /**
     * Asigna al jugador la imagen correspondiente de su elección de ficha
     * @param fichaO Ficha círculo
     * @param fichaX Ficha cruz
     * @return imagen de la ficha elegida
     */
    public ImageView asignarFichaJugador(Image fichaO, Image fichaX) {
        ImageView fichaJugador = null;
        if (TresEnRaya.getEquipoJugador() == 0) {
            fichaJugador = new ImageView(fichaO);
        } else if (TresEnRaya.getEquipoJugador() == 1) {
            fichaJugador = new ImageView(fichaX);
        }
        fichaJugador.setFitHeight(100);
        fichaJugador.setFitWidth(150);
        return fichaJugador;
    }
    
    /**
     * Asigna a la CPU la imagen correspondiente de su ficha
     * @param fichaO Ficha círculo
     * @param fichaX Ficha cruz
     * @return imagen de la ficha elegida
     */
    public ImageView asignarFichaCPU(Image fichaO, Image fichaX) {
        ImageView fichaCPU = null;
        if (TresEnRaya.getEquipoCPU()== 0) {
            fichaCPU = new ImageView(fichaO);
        } else if (TresEnRaya.getEquipoCPU() == 1) {
            fichaCPU = new ImageView(fichaX);
        }
        fichaCPU.setFitHeight(100);
        fichaCPU.setFitWidth(150);
        return fichaCPU;
    }
    
    /**
     * Genera una nueva partida
     */
    public void crearPartida() {
        pantalla.getChildren().clear();
        ter = new TresEnRaya();
        ter.setContador(0);
        tablero.setOpacity(1);
        gridTablero = new GridPane();
        gridTablero.setGridLinesVisible(false);
        gridTablero.setAlignment(Pos.CENTER);
        gridTablero.add(casilla00, 0, 0);
        gridTablero.add(casilla01, 0, 1);
        gridTablero.add(casilla02, 0, 2);
        gridTablero.add(casilla10, 1, 0);
        gridTablero.add(casilla11, 1, 1);
        gridTablero.add(casilla12, 1, 2);
        gridTablero.add(casilla20, 2, 0);
        gridTablero.add(casilla21, 2, 1);
        gridTablero.add(casilla22, 2, 2);
        pantalla.getChildren().addAll(tablero, gridTablero);
    }
    
    /**
     * Visualiza cuál de los dos jugadores ha ganado la partida y muestra los
     * botones para jugar una nueva partida o salir del juego
     */
    public void evaluarVictoria() {
        ter.identificarGanador();
        if (ter.getGanador() == 1) {
            contenedorFinalPartida.getChildren().clear();
            contenedorFinalPartida.getChildren().addAll(hasGanado, finalPartida);
            contenedorFinalPartida.setAlignment(Pos.BOTTOM_CENTER);
            pantalla.getChildren().add(contenedorFinalPartida);
            tablero.setOpacity(0.3);
            gridTablero.setOpacity(0.3);
        } else if (ter.getGanador() == 0) {
            contenedorFinalPartida.getChildren().clear();
            contenedorFinalPartida.getChildren().addAll(hasPerdido, finalPartida);
            contenedorFinalPartida.setAlignment(Pos.BOTTOM_CENTER);
            pantalla.getChildren().add(contenedorFinalPartida);
            tablero.setOpacity(0.3);
            gridTablero.setOpacity(0.3);
        } else if (ter.getGanador() == -1) {
            contenedorFinalPartida.getChildren().clear();
            contenedorFinalPartida.getChildren().addAll(empate, finalPartida);
            contenedorFinalPartida.setAlignment(Pos.BOTTOM_CENTER);
            pantalla.getChildren().add(contenedorFinalPartida);
            tablero.setOpacity(0.3);
            gridTablero.setOpacity(0.3);
        }
    }
    
    /**
     * Desactiva las casillas cuando finaliza el juego
     */
    public void desactivarCasillas() {
        casilla00.setVisible(false);
        casilla01.setVisible(false);
        casilla02.setVisible(false);
        casilla10.setVisible(false);
        casilla11.setVisible(false);
        casilla12.setVisible(false);
        casilla20.setVisible(false);
        casilla21.setVisible(false);
        casilla22.setVisible(false);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
        
    }
    
}
