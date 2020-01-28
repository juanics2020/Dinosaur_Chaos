package es.juanics.dinosaur_chaos;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * JavaFX App
 */
public class App extends Application {

    final short SCENE_HEIGHT = 720; //constante con el alto de la pantalla (scene)
    final short SCENE_WIDTH = 1080; //constante para el ancho de la pantalla (scene)
    final short TAMAÑO_DINO = 25; //porcentaje del tamaño del dinosaurio con respecto a la pantalla
    
    Image dinosaur1 = new Image(getClass().getResourceAsStream("/images/Idle (1).png"));
    Image dinosaur2 = new Image(getClass().getResourceAsStream("/images/Idle (2).png"));
    Image dinosaur3 = new Image(getClass().getResourceAsStream("/images/Idle (3).png"));
    Image dinosaur4 = new Image(getClass().getResourceAsStream("/images/Idle (4).png"));
    Image dinosaur5 = new Image(getClass().getResourceAsStream("/images/Idle (5).png"));
    Image dinosaur6 = new Image(getClass().getResourceAsStream("/images/Idle (6).png"));
    Image dinosaur7 = new Image(getClass().getResourceAsStream("/images/Idle (7).png"));    
    Image dinosaur8 = new Image(getClass().getResourceAsStream("/images/Idle (8).png"));
    Image dinosaur9 = new Image(getClass().getResourceAsStream("/images/Idle (9).png"));
    Image dinosaur10 = new Image(getClass().getResourceAsStream("/images/Idle (10).png"));
    
    Image dinosaur11 = new Image(getClass().getResourceAsStream("/images/Idleiz (1).png"));
    Image dinosaur12 = new Image(getClass().getResourceAsStream("/images/Idleiz (2).png"));
    Image dinosaur13 = new Image(getClass().getResourceAsStream("/images/Idleiz (3).png"));
    Image dinosaur14 = new Image(getClass().getResourceAsStream("/images/Idleiz (4).png"));
    Image dinosaur15 = new Image(getClass().getResourceAsStream("/images/Idleiz (5).png"));
    Image dinosaur16 = new Image(getClass().getResourceAsStream("/images/Idleiz (6).png"));
    Image dinosaur17 = new Image(getClass().getResourceAsStream("/images/Idleiz (7).png"));    
    Image dinosaur18 = new Image(getClass().getResourceAsStream("/images/Idleiz (8).png"));
    Image dinosaur19 = new Image(getClass().getResourceAsStream("/images/Idleiz (9).png"));
    Image dinosaur20 = new Image(getClass().getResourceAsStream("/images/Idleiz (10).png"));     
    
    ImageView dinosaurView1 = new ImageView(dinosaur1);//meter la imagen dinosaurio en view
     
    int i = 1;//para timeline imagen dinosaur
    
    short estadoDino = 0; // 0 ->idle, 1 ->walk, 2 ->run, 3 ->jump, 4 ->dead
    short direction = 1; //1 ->der, -1 ->izq, 0 ->pantalla parada
    double posicionMomView1 = 0;//Guardará la posición que tenga la pantalla el visor 1
    double posicionMomView2 = 0;//Guardará la posición que tenga la pantalla el visor 2
    
    @Override
    public void start(Stage stage) {
        //StackPane (apila una cosa encima de otra en el panel. Así que no nos sirve, porque se pisan
        // StackPane root = new StackPane();//creo un nuevo objeto de tipo StackPane llamado root
        Pane root = new Pane();
        var scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);//le digo a la escena el panel principal (root) y el tamaño de la pantalla
        // scene.setFill(Color.BLACK);//Le damos el color de fondo a la escena
        stage.setScene(scene);
        stage.setResizable(false);//Para que el usuario no pueda cambiar el tamaño de la pantalla
        stage.show();
        
        //PONER EL FONDO 1
        Image background1 = new Image(getClass().getResourceAsStream("/images/swamp.png"));//Él lo ha llamado image1
        ImageView backgroundView1 = new ImageView(background1);//Metemos la imagen de fondo en el visor
                
        backgroundView1.setX(0);//donde vamos a colocar la imagen
        backgroundView1.setY(0);
        backgroundView1.setFitHeight(SCENE_HEIGHT);//hacer que la imagen de fondo se adapte al tamño de la entana
        backgroundView1.setFitWidth(SCENE_WIDTH);
        
        
        //PONER EL FONDO 2
        //Image background2 = new Image(getClass().getResourceAsStream("/images/swamp.png"));//Él lo ha llamado image1       
        ImageView backgroundView2 = new ImageView(background1);//Metemos la imagen de fondo en el visor
                
        backgroundView2.setX(SCENE_WIDTH);//donde vamos a colocar la imagen A CONTINUACION DE LA PRIMERA
        backgroundView2.setY(0);
        backgroundView2.setFitHeight(SCENE_HEIGHT);//hacer que la imagen de fondo se adapte al tamño de la entana
        backgroundView2.setFitWidth(SCENE_WIDTH);
        
        root.getChildren().add(backgroundView1);
        root.getChildren().add(backgroundView2);
          
        
        //PONER EL DINOSAURIO
        dinosaurView1.setX((SCENE_WIDTH/2)-(TAMAÑO_DINO*4));//posición x del dinosaurio
        dinosaurView1.setY(SCENE_HEIGHT-(SCENE_HEIGHT/3));//posición y del dinosaurio
        dinosaurView1.setFitHeight ((SCENE_HEIGHT*dinosaurView1.getFitHeight())/100);//El dinosario será el 15% de la pantalla
        dinosaurView1.setFitWidth ((SCENE_WIDTH*dinosaurView1.getFitWidth())/100);         
        root.getChildren().add(dinosaurView1);
                
        //
        scene.setOnKeyPressed(new EventHandler<KeyEvent>(){//Llama al método setOnKeyPressed. Cuando detecte que se pulsa una tecla en la escena (se puede hacer que en vez que en la escena se detecte cuando pulse dentro de un campo de texto)
            public void handle(final KeyEvent keyEvent){
                posicionMomView1 = backgroundView1.getX(); // Cuando pulsemos una tecla leeremos la posición actual del visor y después moveremos la imagen
                posicionMomView2 = backgroundView2.getX(); // Cuando pulsemos una tecla leeremos la posición actual del visor y después moveremos la imagen          
                double limite = (SCENE_WIDTH/2)-(TAMAÑO_DINO*2);//Límite a donde llega el dinosaurio y comienza scroll

                switch(keyEvent.getCode()){//Según la tecla pulsada
                    case LEFT:// el dinosaurio se moverá a la izquierda
                        direction = -1; //pantalla a la izquierda
                        i = 11;//cambair contador imagen IDLE izquierda
                        if (dinosaurView1.getX()>0){
                            dinosaurView1.setX ((dinosaurView1.getX())-8);
                        }
                        break;

                    case RIGHT: //el fondo se moverá a la izquierda
                        direction = 1;//pantalla a la derecha
                         i = 1;//cambiar contador imagen IDLE
                        posicionMomView1 = posicionMomView1-8;
                        posicionMomView2 = posicionMomView2-8;
                        if (dinosaurView1.getX()>limite){
                            if (posicionMomView2>0){
                                backgroundView1.setX (posicionMomView1);
                                backgroundView2.setX (posicionMomView2);
                            }else{
                                backgroundView1.setX (0);
                                backgroundView2.setX (SCENE_WIDTH);                                
                            }
                        }else{
                            dinosaurView1.setX ((dinosaurView1.getX())+8);                               
                        }
                        break;

                    case UP:
                        direction = 0;//pantalla parada
                        System.out.println("up");
                        break;
                }

            }
        });        
        //
        //TIMELINE -IDLE
        // Game loop usando Timeline
        Timeline timeline = new Timeline(//Sirve para lo que lo que metamos aquí. Podemos utilizar varios TimeLine con diferentes velocidades para diferentes cosas
            // 0.017 ~= 60 FPS (equivalencia de segundos a Frames por Segundo)
            new KeyFrame(Duration.seconds(0.08), new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae) {//Sólo puede haber un handle en el timeline
                   //SWITCH PARA QUE LAS IMÀGENES DEL DINOSAURIO CAMBIEN
                    if (direction == 1){
                        switch (i){
                            case 1:
                                dinosaurView1.setImage(dinosaur1);//meter la imagen dinosaurio en view                           
                                break;
                            case 2:
                                dinosaurView1.setImage(dinosaur2);//meter la imagen dinosaurio en view
                                break;
                            case 3:
                                dinosaurView1.setImage(dinosaur3);//meter la imagen dinosaurio en view           
                                break;                        
                            case 4:
                                dinosaurView1.setImage(dinosaur4);//meter la imagen dinosaurio en view           
                                break;                             
                            case 5:
                                dinosaurView1.setImage(dinosaur5);//meter la imagen dinosaurio en view                               
                                break;                        
                            case 6:
                                dinosaurView1.setImage(dinosaur6);//meter la imagen dinosaurio en view                                    
                                break;                             
                            case 7:
                                dinosaurView1.setImage(dinosaur7);//meter la imagen dinosaurio en view                                    
                                break;                        
                            case 8:
                                dinosaurView1.setImage(dinosaur8);//meter la imagen dinosaurio en view                                       
                                break;                        
                            case 9:
                                dinosaurView1.setImage(dinosaur9);//meter la imagen dinosaurio en view                                                               
                                break;                        
                            case 10:
                                dinosaurView1.setImage(dinosaur10);//meter la imagen dinosaurio en view                                           
                                i = 0;
                                break;
                        }
                    }else if (direction == -1){
                        switch (i){
                            case 11:
                                dinosaurView1.setImage(dinosaur11);//meter la imagen dinosaurio en view                           
                                break;
                            case 12:
                                dinosaurView1.setImage(dinosaur12);//meter la imagen dinosaurio en view
                                break;
                            case 13:
                                dinosaurView1.setImage(dinosaur13);//meter la imagen dinosaurio en view           
                                break;                        
                            case 14:
                                dinosaurView1.setImage(dinosaur14);//meter la imagen dinosaurio en view           
                                break;                             
                            case 15:
                                dinosaurView1.setImage(dinosaur15);//meter la imagen dinosaurio en view                               
                                break;                        
                            case 16:
                                dinosaurView1.setImage(dinosaur16);//meter la imagen dinosaurio en view                                    
                                break;                             
                            case 17:
                                dinosaurView1.setImage(dinosaur17);//meter la imagen dinosaurio en view                                    
                                break;                        
                            case 18:
                                dinosaurView1.setImage(dinosaur18);//meter la imagen dinosaurio en view                                       
                                break;                        
                            case 19:
                                dinosaurView1.setImage(dinosaur19);//meter la imagen dinosaurio en view                                                               
                                break;                        
                            case 20:
                                dinosaurView1.setImage(dinosaur20);//meter la imagen dinosaurio en view                                           
                                i = 10;
                                break;
                        }                        
                    }
                    i++;
                }
            })                
        );
        timeline.setCycleCount(Timeline.INDEFINITE);//Llama al método setCycleCount (para que la animación siga indefinidamente
        timeline.play(); //Llama al método Play para echar a andar la animación
           
    }

    public static void main(String[] args) {
        launch();
    }

}