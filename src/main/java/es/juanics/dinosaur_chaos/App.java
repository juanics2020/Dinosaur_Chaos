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
    //final short TAMAÑO_DINO = 25; //porcentaje del tamaño del dinosaurio con respecto a la pantalla
    
//IDLE
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

    //Idle dejamos la carga de imágenes aquí porque es automático en TimeLine

//WALK
    //Image dinosaurWd1 = new Image(getClass().getResourceAsStream("/images/Walk (1).png"));
    //Image dinosaurWd2 = new Image(getClass().getResourceAsStream("/images/Walk (2).png"));
    //Image dinosaurWd3 = new Image(getClass().getResourceAsStream("/images/Walk (3).png"));
    //Image dinosaurWd4 = new Image(getClass().getResourceAsStream("/images/Walk (4).png"));
    //Image dinosaurWd5 = new Image(getClass().getResourceAsStream("/images/Walk (5).png"));
    //Image dinosaurWd6 = new Image(getClass().getResourceAsStream("/images/Walk (6).png"));
    //Image dinosaurWd7 = new Image(getClass().getResourceAsStream("/images/Walk (7).png"));    
    //Image dinosaurWd8 = new Image(getClass().getResourceAsStream("/images/Walk (8).png"));
    //Image dinosaurWd9 = new Image(getClass().getResourceAsStream("/images/Walk (9).png"));
    //Image dinosaurWd10 = new Image(getClass().getResourceAsStream("/images/Walk (10).png"));

    Image[] dinosaurWd = new Image[10];    
    
    //Image dinosaurWi1 = new Image(getClass().getResourceAsStream("/images/Walkiz (1).png"));
    //Image dinosaurWi2 = new Image(getClass().getResourceAsStream("/images/Walkiz (2).png"));
    //Image dinosaurWi3 = new Image(getClass().getResourceAsStream("/images/Walkiz (3).png"));
    //Image dinosaurWi4 = new Image(getClass().getResourceAsStream("/images/Walkiz (4).png"));
    //Image dinosaurWi5 = new Image(getClass().getResourceAsStream("/images/Walkiz (5).png"));
    //Image dinosaurWi6 = new Image(getClass().getResourceAsStream("/images/Walkiz (6).png"));
    //Image dinosaurWi7 = new Image(getClass().getResourceAsStream("/images/Walkiz (7).png"));    
    //Image dinosaurWi8 = new Image(getClass().getResourceAsStream("/images/Walkiz (8).png"));
    //Image dinosaurWi9 = new Image(getClass().getResourceAsStream("/images/Walkiz (9).png"));
    //Image dinosaurWi10 = new Image(getClass().getResourceAsStream("/images/Walkiz (10).png"));

    Image[] dinosaurWi = new Image[10];

//RUN
    //Image dinosaurRd1 = new Image(getClass().getResourceAsStream("/images/Run (1).png"));
    //Image dinosaurRd2 = new Image(getClass().getResourceAsStream("/images/Run (2).png"));
    //Image dinosaurRd3 = new Image(getClass().getResourceAsStream("/images/Run (3).png"));
    //Image dinosaurRd4 = new Image(getClass().getResourceAsStream("/images/Run (4).png"));
    //Image dinosaurRd5 = new Image(getClass().getResourceAsStream("/images/Run (5).png"));
    //Image dinosaurRd6 = new Image(getClass().getResourceAsStream("/images/Run (6).png"));
    //Image dinosaurRd7 = new Image(getClass().getResourceAsStream("/images/Run (7).png"));    
    //Image dinosaurRd8 = new Image(getClass().getResourceAsStream("/images/Run (8).png"));

    Image[] dinosaurRd = new Image[8];   
    
    //Image dinosaurRi1 = new Image(getClass().getResourceAsStream("/images/Runiz (1).png"));
    //Image dinosaurRi2 = new Image(getClass().getResourceAsStream("/images/Runiz (2).png"));
    //Image dinosaurRi3 = new Image(getClass().getResourceAsStream("/images/Runiz (3).png"));
    //Image dinosaurRi4 = new Image(getClass().getResourceAsStream("/images/Runiz (4).png"));
    //Image dinosaurRi5 = new Image(getClass().getResourceAsStream("/images/Runiz (5).png"));
    //Image dinosaurRi6 = new Image(getClass().getResourceAsStream("/images/Runiz (6).png"));
    //Image dinosaurRi7 = new Image(getClass().getResourceAsStream("/images/Runiz (7).png"));    
    //Image dinosaurRi8 = new Image(getClass().getResourceAsStream("/images/Runiz (8).png"));

    Image[] dinosaurRi = new Image[8];
    
//JUMP
    //Image dinosaurJd1 = new Image(getClass().getResourceAsStream("/images/Jump (1).png"));
    //Image dinosaurJd2 = new Image(getClass().getResourceAsStream("/images/Jump (2).png"));
    //Image dinosaurJd3 = new Image(getClass().getResourceAsStream("/images/Jump (3).png"));
    //Image dinosaurJd4 = new Image(getClass().getResourceAsStream("/images/Jump (4).png"));
    //Image dinosaurJd5 = new Image(getClass().getResourceAsStream("/images/Jump (5).png"));
    //Image dinosaurJd6 = new Image(getClass().getResourceAsStream("/images/Jump (6).png"));
    //Image dinosaurJd7 = new Image(getClass().getResourceAsStream("/images/Jump (7).png"));    
    //Image dinosaurJd8 = new Image(getClass().getResourceAsStream("/images/Jump (8).png"));
    //Image dinosaurJd9 = new Image(getClass().getResourceAsStream("/images/Jump (9).png"));
    //Image dinosaurJd10 = new Image(getClass().getResourceAsStream("/images/Jump (10).png"));
    //Image dinosaurJd11 = new Image(getClass().getResourceAsStream("/images/Jump (11).png"));
    //Image dinosaurJd12 = new Image(getClass().getResourceAsStream("/images/Jump (12).png"));
    
    Image[] dinosaurJd = new Image[12];
    
    //Image dinosaurJi1 = new Image(getClass().getResourceAsStream("/images/Jumpiz (1).png"));
    //Image dinosaurJi2 = new Image(getClass().getResourceAsStream("/images/Jumpiz (2).png"));
    //Image dinosaurJi3 = new Image(getClass().getResourceAsStream("/images/Jumpiz (3).png"));
    //Image dinosaurJi4 = new Image(getClass().getResourceAsStream("/images/Jumpiz (4).png"));
    //Image dinosaurJi5 = new Image(getClass().getResourceAsStream("/images/Jumpiz (5).png"));
    //Image dinosaurJi6 = new Image(getClass().getResourceAsStream("/images/Jumpiz (6).png"));
    //Image dinosaurJi7 = new Image(getClass().getResourceAsStream("/images/Jumpiz (7).png"));    
    //Image dinosaurJi8 = new Image(getClass().getResourceAsStream("/images/Jumpiz (8).png"));
    //Image dinosaurJi9 = new Image(getClass().getResourceAsStream("/images/Jumpiz (9).png"));
    //Image dinosaurJi10 = new Image(getClass().getResourceAsStream("/images/Jumpiz (10).png"));
    //Image dinosaurJi11 = new Image(getClass().getResourceAsStream("/images/Jumpiz (11).png"));
    //Image dinosaurJi12 = new Image(getClass().getResourceAsStream("/images/Jumpiz (12).png"));
    
    Image[] dinosaurJi = new Image[12];
    
//DEAD
    //Image dinosaurDd1 = new Image(getClass().getResourceAsStream("/images/Dead (1).png"));
    //Image dinosaurDd2 = new Image(getClass().getResourceAsStream("/images/Dead (2).png"));
    //Image dinosaurDd3 = new Image(getClass().getResourceAsStream("/images/Dead (3).png"));
    //Image dinosaurDd4 = new Image(getClass().getResourceAsStream("/images/Dead (4).png"));
    //Image dinosaurDd5 = new Image(getClass().getResourceAsStream("/images/Dead (5).png"));
    //Image dinosaurDd6 = new Image(getClass().getResourceAsStream("/images/Dead (6).png"));
    //Image dinosaurDd7 = new Image(getClass().getResourceAsStream("/images/Dead (7).png"));    
    //Image dinosaurDd8 = new Image(getClass().getResourceAsStream("/images/Dead (8).png"));

    Image[] dinosaurDd = new Image[8];
        
    //Image dinosaurDi1 = new Image(getClass().getResourceAsStream("/images/Deadiz (1).png"));
    //Image dinosaurDi2 = new Image(getClass().getResourceAsStream("/images/Deadiz (2).png"));
    //Image dinosaurDi3 = new Image(getClass().getResourceAsStream("/images/Deadiz (3).png"));
    //Image dinosaurDi4 = new Image(getClass().getResourceAsStream("/images/Deadiz (4).png"));
    //Image dinosaurDi5 = new Image(getClass().getResourceAsStream("/images/Deadiz (5).png"));
    //Image dinosaurDi6 = new Image(getClass().getResourceAsStream("/images/Deadiz (6).png"));
    //Image dinosaurDi7 = new Image(getClass().getResourceAsStream("/images/Deadiz (7).png"));    
    //Image dinosaurDi8 = new Image(getClass().getResourceAsStream("/images/Deadiz (8).png"));

    Image[] dinosaurDi = new Image[8];

    
 //---   
    ImageView dinosaurView1 = new ImageView(dinosaur1);//meter la imagen dinosaurio en view
 //---    



    int i = 1;//para timeline imagen dinosaur
    
    short estadoDino = 0; // 0 ->idle, 1 ->walk, 2 ->run, 3 ->jump, 4 ->dead
    short direction = 1; //1 ->der, -1 ->izq, 0 ->pantalla parada
    double posicionMomView1 = 0;//Guardará la posición que tenga la pantalla el visor 1
    double posicionMomView2 = 0;//Guardará la posición que tenga la pantalla el visor 2
    double dinoDeSobra = dinosaur1.getWidth()/3;//Imagen que sobra por los laterales cuando gira el dino (habrá que sumar o restar cuando gira)
    int contPasos = 0;//Para que cuente los pasos, que cambie la imagen   
    
    @Override
    public void start(Stage stage) {
        //CARGA DE IMÁGENES USANDO UN VECTOR (ARRAY) UNIDIMENSIONAL
        for (int c=0; c<10; c++){
            dinosaurWd[c] = new Image(getClass().getResourceAsStream("/images/Walk ("+(c+1)+").png"));
        }
        for (int c=0; c<10; c++){
            dinosaurWi[c] = new Image(getClass().getResourceAsStream("/images/Walkiz ("+(c+1)+").png"));
        } 
        for (int c=0; c<8; c++){
            dinosaurRd[c] = new Image(getClass().getResourceAsStream("/images/Run ("+(c+1)+").png"));
        }        
        for (int c=0; c<8; c++){
            dinosaurRi[c] = new Image(getClass().getResourceAsStream("/images/Runiz ("+(c+1)+").png"));
        }        
        for (int c=0; c<12; c++){
            dinosaurJd[c] = new Image(getClass().getResourceAsStream("/images/Jump ("+(c+1)+").png"));
        }       
        for (int c=0; c<12; c++){
            dinosaurJi[c] = new Image(getClass().getResourceAsStream("/images/Jumpiz ("+(c+1)+").png"));
        }        
        for (int c=0; c<8; c++){
            dinosaurDd[c] = new Image(getClass().getResourceAsStream("/images/Dead ("+(c+1)+").png"));
        }
        for (int c=0; c<8; c++){
            dinosaurDi[c] = new Image(getClass().getResourceAsStream("/images/Deadiz ("+(c+1)+").png"));
        } 
        
        
        //dinosaurDi[1] = new Image(getClass().getResourceAsStream("/images/Deadiz (2).png"));
        //dinosaurDi[2] = new Image(getClass().getResourceAsStream("/images/Deadiz (3).png"));

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
        dinosaurView1.setX((SCENE_WIDTH/2)-dinosaurView1.getFitWidth());//posición x del dinosaurio
        dinosaurView1.setY(SCENE_HEIGHT-(SCENE_HEIGHT/4));//posición y del dinosaurio
        //dinosaurView1.setFitHeight ((SCENE_HEIGHT*TAMAÑO_DINO)/100);//El dinosario será el 15% de la pantalla
        //dinosaurView1.setFitWidth ((SCENE_WIDTH*TAMAÑO_DINO)/100);         
        root.getChildren().add(dinosaurView1);
                
        //
        scene.setOnKeyPressed(new EventHandler<KeyEvent>(){//Llama al método setOnKeyPressed. Cuando detecte que se pulsa una tecla en la escena (se puede hacer que en vez que en la escena se detecte cuando pulse dentro de un campo de texto)
            public void handle(final KeyEvent keyEvent){
                posicionMomView1 = backgroundView1.getX(); // Cuando pulsemos una tecla leeremos la posición actual del visor y después moveremos la imagen
                posicionMomView2 = backgroundView2.getX(); // Cuando pulsemos una tecla leeremos la posición actual del visor y después moveremos la imagen          
                double limite = ((SCENE_WIDTH/2)-dinosaurView1.getFitWidth());//Límite a donde llega el dinosaurio y comienza scroll
               
                switch(keyEvent.getCode()){//Según la tecla pulsada
                    case LEFT:// el dinosaurio se moverá a la izquierda
                        if (direction == 1){//hay que cambiar dirección
                            dinosaurView1.setX(dinosaurView1.getX()-dinoDeSobra);//cuando cambia la dirección hay que mover el dinosaruio el trozo de imagen que le sobra para que caiga encima
                            direction = -1; //pantalla a la izquierda
                            contPasos = 0;//Cuando cambie de dirección los pasos a 0
                        }
                        if(contPasos<=5){//Si los pasos son menos de 5 ANDARÁ, si son más correrá
                            dinosaurView1.setImage(dinosaurWi[contPasos]);  
                        }else{//Si es mayor de 5 correrá
                            dinosaurView1.setImage(dinosaurRi[contPasos]);
                        }
                        
                        i = 11;//cambair contador imagen IDLE izquierda
                        if (dinosaurView1.getX()>(dinoDeSobra*-1)){// para que no pase del lado izquierdo (como la imagen es larga tiene que salir un poco por la izquierda
                            dinosaurView1.setX ((dinosaurView1.getX())-8);
                        }
                        contPasos++;
                        break;

                    case RIGHT: //el fondo se moverá a la izquierda
                        if (direction == -1){//hay que cambiar dirección
                            dinosaurView1.setX(dinosaurView1.getX()+dinoDeSobra);//cuando cambia la dirección hay que mover el dinosaruio el trozo de imagen que le sobra para que caiga encima
                            direction = 1; //pantalla a la izquierda
                            contPasos = 0;// cuando cambie de dirección los pasos a 0
                        }
                        if(contPasos<=5){//Si los pasos son menos de 5 ANDARÁ, si son más correrá
                            dinosaurView1.setImage(dinosaurWd[contPasos]);                              
                        }else{//Si es mayor de 5 correrá
                            dinosaurView1.setImage(dinosaurRd[contPasos]);
                        }
                        posicionMomView1 = posicionMomView1-8;
                        posicionMomView2 = posicionMomView2-8;                        

                        direction = 1;//pantalla a la derecha
                        i = 1;//cambiar contador imagen IDLE
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
                        contPasos++;
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