//CAMBIAR A dinosaur_chaos para el de CLASE***********y dinosaurchaos para la CASA


//*********************COSAS A ARREGLAR:
//CUANDO SE PULSAN DOS TECLAS A LA VEZ SE VUELVE LOCO ej: drecha e izquierda o derecha y espacio
//CUANDO MUERE EL TECLADO SIGUE ACTIVO
//NO MUESTRA MENSAJE DE ALERTA PARA SEGUIR JUGANDO (UNA VEZ MUERE)****(ALERTA SE MUESTRA EN timelineDead)





package es.juanics.dinosaur_chaos;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * JavaFX App
 */
public class App extends Application {

    final short SCENE_HEIGHT = 720; //constante con el alto de la pantalla (scene)
    final short SCENE_WIDTH = 1080; //constante para el ancho de la pantalla (scene)
    final int dinosaurioY = SCENE_HEIGHT-(SCENE_HEIGHT/4);
    final short TEXT_SIZE = 24;

//HEART
    Image heartImage = new Image (getClass().getResourceAsStream("/images/heart.png"));
    Image heartBlack = new Image (getClass().getResourceAsStream("/images/heartBlack.png"));

    
//SHOOT
    Image dinosaurSd = new Image (getClass().getResourceAsStream("/images/Shoot (1).png"));
    Image dinosaurSi = new Image (getClass().getResourceAsStream("/images/Shootiz (1).png"));   
    
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
    //Image dinosaurJd13 = new Image(getClass().getResourceAsStream("/images/Jump (13).png"));
    //Image dinosaurJd14 = new Image(getClass().getResourceAsStream("/images/Jump (14).png"));
    //Image dinosaurJd15 = new Image(getClass().getResourceAsStream("/images/Jump (15).png"));
    
    Image[] dinosaurJd = new Image[15];
    
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
    //Image dinosaurJi13 = new Image(getClass().getResourceAsStream("/images/Jumpiz (13).png"));
    //Image dinosaurJi14 = new Image(getClass().getResourceAsStream("/images/Jumpiz (14).png"));
    //Image dinosaurJi15 = new Image(getClass().getResourceAsStream("/images/Jumpiz (15).png"));
    
    Image[] dinosaurJi = new Image[15];
    
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
    
    short direction = 1; //1 ->der, -1 ->izq, 0 ->pantalla parada
    double posicionMomView1 = 0;//Guardará la posición que tenga la pantalla el visor 1
    double posicionMomView2 = 0;//Guardará la posición que tenga la pantalla el visor 2
    boolean viewsInMovement = false;//Detectará cuando se mueve el fondo en vez de el dinosaurio
    double dinoDeSobra = dinosaur1.getWidth()/3;//Imagen que sobra por los laterales cuando gira el dino (habrá que sumar o restar cuando gira)
    int contPasos = 0;//Para que cuente los pasos, que cambie la imagen   
    int contJump=0;//contador para Timeline2 del salto
    double Xactual = 0;
    double Yactual = 0;
    double limite = ((SCENE_WIDTH-(SCENE_WIDTH/3))-dinosaurView1.getFitWidth());//Límite a donde llega el dinosaurio y comienza scroll
    int vidaDino = 2000;
    int direcBall = 1; //la dirección a la que irá la bola (porque la dirección del dinosaurio puede cambiar mientras que la bola está en movimiento
    int score = 0;
    int health= 2000; //Un corazón vale 200 puntos (tiene 10)
    int deadPasos = 1; //contar pasos en Dead  
    boolean dentroJump = false;//Para detectar si está dentro del salto y que no se pise con otro salto
    boolean rPressed = false;//comprobrar si la derecha está pulsada
    boolean lPressed = false;//comprobrar si la izquierda está pulsada    
    Timeline timelineIdle;
    Timeline timelineJump;
    Timeline timelineRunRight;
    Timeline timelineRunLeft;
    Timeline timelineDead;
    Timeline timelineShoot;
    Timeline timelinePlaying;
    TextInputDialog dialog = new TextInputDialog("Nombre");
    String varTextButton ="";
    ImageView backgroundView1;
    ImageView backgroundView2;
    Group groupD;
    Circle circleBall;
    Group groupM;
    Group groupMiz;
    ImageView heartView1;
    ImageView heartView2;
    ImageView heartView3;
    ImageView heartView4;
    ImageView heartView5;
    ImageView heartView6;
    ImageView heartView7;
    ImageView heartView8;
    ImageView heartView9;
    ImageView heartView10;
    HBox paneScores;
    VBox paneContinuar;
    HBox paneGeneralName;
    
    
    
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
        for (int c=0; c<15; c++){
            dinosaurJd[c] = new Image(getClass().getResourceAsStream("/images/Jump ("+(c+1)+").png"));
        }       
        for (int c=0; c<15; c++){
            dinosaurJi[c] = new Image(getClass().getResourceAsStream("/images/Jumpiz ("+(c+1)+").png"));
        }        
        for (int c=0; c<8; c++){
            dinosaurDd[c] = new Image(getClass().getResourceAsStream("/images/Dead ("+(c+1)+").png"));
        }
        for (int c=0; c<8; c++){
            dinosaurDi[c] = new Image(getClass().getResourceAsStream("/images/Deadiz ("+(c+1)+").png"));
        } 
        
              
        
        //StackPane (apila una cosa encima de otra en el panel. Así que no nos sirve, porque se pisan
        // StackPane root = new StackPane();//creo un nuevo objeto de tipo StackPane llamado root
        Pane root = new Pane();
        var scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);//le digo a la escena el panel principal (root) y el tamaño de la pantalla
        // scene.setFill(Color.BLACK);//Le damos el color de fondo a la escena
        stage.setScene(scene);
        stage.setResizable(false);//Para que el usuario no pueda cambiar el tamaño de la pantalla
        stage.setTitle("DINOSAUR CHAOS");
        stage.show();
        
        
        //PONER EL FONDO 1
        Image background1 = new Image(getClass().getResourceAsStream("/images/swamp.png"));//Él lo ha llamado image1
        backgroundView1 = new ImageView(background1);//Metemos la imagen de fondo en el visor
                
        backgroundView1.setX(0);//donde vamos a colocar la imagen
        backgroundView1.setY(0);
        backgroundView1.setFitHeight(SCENE_HEIGHT);//hacer que la imagen de fondo se adapte al tamño de la entana
        backgroundView1.setFitWidth(SCENE_WIDTH);
        
        
        //PONER EL FONDO 2
        //Image background2 = new Image(getClass().getResourceAsStream("/images/swamp.png"));//Él lo ha llamado image1       
        backgroundView2 = new ImageView(background1);//Metemos la imagen de fondo en el visor
                
        backgroundView2.setX(SCENE_WIDTH);//donde vamos a colocar la imagen A CONTINUACION DE LA PRIMERA
        backgroundView2.setY(0);
        backgroundView2.setFitHeight(SCENE_HEIGHT);//hacer que la imagen de fondo se adapte al tamño de la entana
        backgroundView2.setFitWidth(SCENE_WIDTH);
                       
        root.getChildren().add(backgroundView1);
        root.getChildren().add(backgroundView2);
           
        
        //PONER EL DINOSAURIO
        //GRUPO IMAGEN DINOSAURIO + RECTANGULO
        groupD = new Group();
        // El dinosaurio mide 170 pixeles (ancho) x 118 pixeles (alto)
        dinosaurView1.setX(0);//posición x del dinosaurio
        dinosaurView1.setY(0);//posición y del dinosaurio
        //PONER RECTÁNGULO DETRÁS DEL DINOSAURIO
        Rectangle rectDino= new Rectangle();
        //Métodos del objeto RECTÁNGULO
        rectDino.setWidth(dinosaur1.getWidth()/3);
        rectDino.setHeight(dinosaur1.getHeight()-35);
        rectDino.setX(0+(rectDino.getWidth()/2));
        rectDino.setY(0+(35/2));//posicón del rectángulo a la altura del dinosaurio (-15 porque a la imagen del dinosaurio le sobra un poco por abajo)
        rectDino.setArcWidth(20);
        rectDino.setArcHeight(20);
        rectDino.setVisible(false);
        
        groupD.getChildren().add(rectDino);
        groupD.getChildren().add(dinosaurView1);
        root.getChildren().add(groupD);
        groupD.setLayoutX(limite);
        groupD.setLayoutY(dinosaurioY);
 
        
        //PONER LA BOLA QUE TIRA EL DINOSAURIO
        //new Circle() => Crear un objeto de la clase Circle
        circleBall = new Circle(); //Creamos una variable llamada circleBall(nuevo objeto -> new) de tipo Círculo(clase Círculo)
        //Llamamos a MÉTODOS del objeto circleBall
        circleBall.setCenterX(-300);
        circleBall.setCenterY(60);
        circleBall.setRadius(10);
        circleBall.setFill(Color.YELLOW);
        //circleBall.setOpacity(0);//Con la Opacidad en 0 está transparente. Con la opacidad en 100 se ve normal
        
        root.getChildren().add(circleBall);//Hay que añadir la bola al StackPane(panel llamado root). Los objtos que contiene el panel son los Children.
 
        
        //AÑADIR GRUPO DE FORMAS PARA HACER ENEMIGO
        groupM = new Group();
        //RECTÁGULO
        Rectangle rectM= new Rectangle();
        //Métodos del objeto RECTÁNGULO
        rectM.setWidth(dinosaur1.getWidth()/3);
        rectM.setHeight(rectM.getWidth()+(rectM.getWidth()/2));
        rectM.setX(0);
        rectM.setY(0);//posicón del rectángulo a la altura del dinosaurio (-15 porque a la imagen del dinosaurio le sobra un poco por abajo)
        rectM.setArcWidth(20);
        rectM.setArcHeight(20);
        rectM.setFill(Color.BLACK);
        rectM.setStroke(Color.RED);//Contorno
        rectM.setStrokeWidth(3); 
        //CÍRCULO
        Circle headM = new Circle();
        //Llamamos a MÉTODOS del objeto circleBall
        headM.setRadius((rectM.getWidth()/2));
        headM.setCenterX(rectM.getX()+headM.getRadius());
        headM.setCenterY(rectM.getY()-(headM.getRadius()));
        headM.setFill(Color.BLACK);        
        headM.setStroke(Color.RED);
        headM.setStrokeWidth(3); 
        //CÍRCULO OJO DERECHO
        Circle eyeRM = new Circle();
        eyeRM.setRadius(headM.getRadius()/4);
        eyeRM.setCenterX(headM.getCenterX()-eyeRM.getRadius());
        eyeRM.setCenterY(headM.getCenterY());
        eyeRM.setFill(Color.RED);        
        eyeRM.setStroke(Color.BLACK);
         //LÍNEA CEJA DERECHA
        Line browRM = new Line();
        browRM.setStartX(eyeRM.getCenterX()-((eyeRM.getRadius()*10)/10));
        browRM.setStartY(eyeRM.getCenterY()-((eyeRM.getRadius()*2)/10));
        browRM.setEndX(eyeRM.getCenterX()+((eyeRM.getRadius()*8)/10));
        browRM.setEndY(eyeRM.getCenterY()-((eyeRM.getRadius()*14)/10));
        browRM.setStroke(Color.RED);
        browRM.setStrokeWidth(3);         
              
        groupM.getChildren().add(rectM);
        groupM.getChildren().add(headM);
        groupM.getChildren().add(eyeRM); 
        groupM.getChildren().add(browRM);
        
        root.getChildren().add(groupM);
        
        groupM.setLayoutX(SCENE_WIDTH);
        groupM.setLayoutY(groupD.getLayoutY()+(dinosaur1.getHeight()-(rectM.getHeight()+headM.getRadius()))+15);//Para que salga a la altura del dinosaurio (le sobra 15 por abajo)

        
        
        
        //AÑADIR GRUPO DE FORMAS PARA HACER ENEMIGO A LA IZQUIERDA
        groupMiz = new Group();
        //RECTÁGULO
        Rectangle rectMiz= new Rectangle();
        //Métodos del objeto RECTÁNGULO
        rectMiz.setWidth(dinosaur1.getWidth()/3);
        rectMiz.setHeight(rectMiz.getWidth()+(rectMiz.getWidth()/2));
        rectMiz.setX(0);
        rectMiz.setY(0);//posicón del rectángulo a la altura del dinosaurio (-15 porque a la imagen del dinosaurio le sobra un poco por abajo)
        rectMiz.setArcWidth(20);
        rectMiz.setArcHeight(20);
        rectMiz.setFill(Color.BLACK);
        rectMiz.setStroke(Color.RED);//Contorno
        rectMiz.setStrokeWidth(3); 
        //CÍRCULO
        Circle headMiz = new Circle();
        //Llamamos a MÉTODOS del objeto circleBall
        headMiz.setRadius((rectMiz.getWidth()/2));
        headMiz.setCenterX(rectMiz.getX()+headMiz.getRadius());
        headMiz.setCenterY(rectMiz.getY()-(headMiz.getRadius()));
        headMiz.setFill(Color.BLACK);        
        headMiz.setStroke(Color.RED);
        headMiz.setStrokeWidth(3); 
        //CÍRCULO OJO DERECHO
        Circle eyeRMiz = new Circle();
        eyeRMiz.setRadius(headMiz.getRadius()/4);
        eyeRMiz.setCenterX(headMiz.getCenterX()+eyeRMiz.getRadius());//+(eyeRM.getRadius()));
        eyeRMiz.setCenterY(headMiz.getCenterY());//+(eyeRM.getRadius()));
        eyeRMiz.setFill(Color.RED);        
        eyeRMiz.setStroke(Color.BLACK);
         //LÍNEA CEJA DERECHA
        Line browRMiz = new Line();
        browRMiz.setStartX(eyeRMiz.getCenterX()+((eyeRMiz.getRadius()*10)/10));//(eyeRM.getCenterX()-((eyeRM.getRadius()*10)/10))
        browRMiz.setStartY(eyeRMiz.getCenterY()-((eyeRMiz.getRadius()*2)/10));//(eyeRM.getCenterY()-((eyeRM.getRadius()*2)/10))
        browRMiz.setEndX(eyeRMiz.getCenterX()-((eyeRMiz.getRadius()*8)/10));//(eyeRM.getCenterX()+((eyeRM.getRadius()*8)/10))
        browRMiz.setEndY(eyeRMiz.getCenterY()-((eyeRMiz.getRadius()*14)/10));//(eyeRM.getCenterY()-((eyeRM.getRadius()*14)/10))
        browRMiz.setStroke(Color.RED);
        browRMiz.setStrokeWidth(3);         
              
        groupMiz.getChildren().add(rectMiz);
        groupMiz.getChildren().add(headMiz);
        groupMiz.getChildren().add(eyeRMiz); 
        groupMiz.getChildren().add(browRMiz);
        
        root.getChildren().add(groupMiz);
        
        groupMiz.setLayoutX(-rectMiz.getWidth());
        groupMiz.setLayoutY(groupD.getLayoutY()+(dinosaur1.getHeight()-(rectM.getHeight()+headM.getRadius()))+15);//(((groupD.getLayoutY()+rectMiz.getHeight())-(rectMiz.getHeight()-dinosaurView1.getFitHeight())-15));//(groupD.getLayoutY()+(dinosaur1.getHeight()-(rectM.getHeight()+headM.getRadius()))+15)
        
       
        
        //PONER LOS CORAZONES
        //*********************
        heartView1 = new ImageView (heartImage); // El corazón mide 31 * 31 pixeles
        heartView1.setX(SCENE_WIDTH-(SCENE_WIDTH/3));//donde vamos a colocar la imagen A CONTINUACION DE LA PRIMERA
        heartView1.setY(40);       
        
        heartView2 = new ImageView (heartImage); // El corazón mide 31 * 31 pixeles
        heartView2.setX(SCENE_WIDTH-((SCENE_WIDTH/3)-31));//donde vamos a colocar la imagen A CONTINUACION DE LA PRIMERA
        heartView2.setY(40); 
        
        heartView3 = new ImageView (heartImage); // El corazón mide 31 * 31 pixeles
        heartView3.setX(SCENE_WIDTH-((SCENE_WIDTH/3)-(31+31)));//donde vamos a colocar la imagen A CONTINUACION DE LA PRIMERA
        heartView3.setY(40); 
        
        heartView4 = new ImageView (heartImage); // El corazón mide 31 * 31 pixeles
        heartView4.setX(SCENE_WIDTH-((SCENE_WIDTH/3)-(31+31+31)));//donde vamos a colocar la imagen A CONTINUACION DE LA PRIMERA
        heartView4.setY(40); 
        
        heartView5 = new ImageView (heartImage); // El corazón mide 31 * 31 pixeles
        heartView5.setX(SCENE_WIDTH-((SCENE_WIDTH/3)-(31+31+31+31)));//donde vamos a colocar la imagen A CONTINUACION DE LA PRIMERA
        heartView5.setY(40);        

        heartView6 = new ImageView (heartImage); // El corazón mide 31 * 31 pixeles
        heartView6.setX(SCENE_WIDTH-((SCENE_WIDTH/3)-(31+31+31+31+31)));//donde vamos a colocar la imagen A CONTINUACION DE LA PRIMERA
        heartView6.setY(40); 
        
        heartView7 = new ImageView (heartImage); // El corazón mide 31 * 31 pixeles
        heartView7.setX(SCENE_WIDTH-((SCENE_WIDTH/3)-(31+31+31+31+31+31)));//donde vamos a colocar la imagen A CONTINUACION DE LA PRIMERA
        heartView7.setY(40); 
        
        heartView8 = new ImageView (heartImage); // El corazón mide 31 * 31 pixeles
        heartView8.setX(SCENE_WIDTH-((SCENE_WIDTH/3)-(31+31+31+31+31+31+31)));//donde vamos a colocar la imagen A CONTINUACION DE LA PRIMERA
        heartView8.setY(40); 
        
        heartView9 = new ImageView (heartImage); // El corazón mide 31 * 31 pixeles
        heartView9.setX(SCENE_WIDTH-((SCENE_WIDTH/3)-(31+31+31+31+31+31+31+31)));//donde vamos a colocar la imagen A CONTINUACION DE LA PRIMERA
        heartView9.setY(40);        

        heartView10 = new ImageView (heartImage); // El corazón mide 31 * 31 pixeles
        heartView10.setX(SCENE_WIDTH-((SCENE_WIDTH/3)-(31+31+31+31+31+31+31+31+31)));//donde vamos a colocar la imagen A CONTINUACION DE LA PRIMERA
        heartView10.setY(40);              
        
        root.getChildren().add(heartView1);        
        root.getChildren().add(heartView2);
        root.getChildren().add(heartView3);
        root.getChildren().add(heartView4);        
        root.getChildren().add(heartView5);
        root.getChildren().add(heartView6);
        root.getChildren().add(heartView7);
        root.getChildren().add(heartView8);        
        root.getChildren().add(heartView9);
        root.getChildren().add(heartView10);
        
        
        /////LAYOUTS PARA MOSTRAR PUNTUACIONES/////
        //*****************************************
        //Layout principal
        paneScores = new HBox();
        paneScores.setTranslateY(40);
        paneScores.setMinWidth(SCENE_WIDTH);
        paneScores.setAlignment(Pos.CENTER);
        paneScores.setSpacing(100);
        root.getChildren().add(paneScores);
        
        //Layout para puntuación actual
        HBox paneCurrentScore = new HBox();
        paneCurrentScore.setSpacing(10);
        paneScores.getChildren().add(paneCurrentScore);
        
        //Layout para la vida
        HBox paneLife = new HBox();
        paneLife.setSpacing (10);
        paneScores.getChildren().add(paneLife);
        
        
        //Layout principal PARA NOMBRE
        paneGeneralName = new HBox();
        paneGeneralName.setTranslateY(80);
        paneGeneralName.setTranslateX(-48);
        paneGeneralName.setMinWidth(SCENE_WIDTH);
        paneGeneralName.setAlignment(Pos.CENTER_RIGHT);
        paneGeneralName.setSpacing(100);
        //paneGeneralName.setLayoutY(80);
        root.getChildren().add(paneGeneralName);       
        //Layout para NOMBRE
        HBox paneName = new HBox();
        paneName.setSpacing(10);
        paneGeneralName.getChildren().add(paneName);
        
        
        //Texto de etiqueta para la puntuación
        Text textTitleScore = new Text("Score:");
        textTitleScore.setFont(Font.font(TEXT_SIZE));
        textTitleScore.setFill(Color.YELLOW);
        //Texto para la puntuación
        Text textScore = new Text(String.valueOf(score));
        textScore.setFont(Font.font(TEXT_SIZE));
        textScore.setFill(Color.YELLOW);
        //Texto de etiqueta para la vida
        Text textTitleHealth = new Text("Health:");
        textTitleHealth.setFont(Font.font(TEXT_SIZE));
        textTitleHealth.setFill(Color.YELLOW);
        //Texto para la puntuación máxima
        Text textHealth = new Text(String.valueOf(health));
        textHealth.setFont(Font.font(TEXT_SIZE));
        textHealth.setFill(Color.YELLOW);
        
        //Añadir los textos a los layouts reservados para ellos
        paneCurrentScore.getChildren().add(textTitleScore);//caja de texto 1, puntuación actual
        paneCurrentScore.getChildren().add(textScore);//texto dentro de la caja de texto 1, puntuación actual
        paneLife.getChildren().add(textTitleHealth);//caja de texto 2, puntuación máxima
        paneLife.getChildren().add(textHealth);//texto dentro de la caja de texto 2, puntuación máxima    
                
        //DIÁLOGO PARA PEDIR NOMBRE
        dialog.setTitle("NAME");
        dialog.setHeaderText("Enter your name:");
        dialog.setContentText("Name:");
        dialog.showAndWait();
        String nameDino = dialog.getResult();
        Text nombre = new Text(nameDino);
        nombre.setFont(Font.font("Eras Bold ITC", TEXT_SIZE));
        nombre.setFill(Color.BLUE);        
        paneName.getChildren().add(nombre);
        
        
        //Layout principal para VBOX (MENSAJE CONTINUAR)
        //**********************
        paneContinuar = new VBox();
        paneContinuar.setTranslateY(100);
        paneContinuar.setMinWidth(SCENE_WIDTH);
        paneContinuar.setAlignment(Pos.CENTER);
        paneContinuar.setSpacing(100);
        root.getChildren().add(paneContinuar);
        //Texto de etiqueta para la continuar
        Text textTitleCon = new Text("¿Do you want to continue?");
        textTitleCon.setFont(Font.font(TEXT_SIZE));
        textTitleCon.setFill(Color.BLACK);
        paneContinuar.getChildren().add(textTitleCon);

        //AÑADIR LOS DON BOTONES HORIZONTALES EN UN HBOX(DENTRO DEL VBOX)
        HBox paneBotones = new HBox();
        paneBotones.setAlignment(Pos.CENTER);
        paneBotones.setSpacing(20);
        //DOS BOTONES
        ButtonBar buttonBar = new ButtonBar();
        Button botonYes = new Button();
        ButtonBar.setButtonData(botonYes, ButtonData.YES);
        botonYes.setText("YES");
        //botonYes.getOnMouseClicked();
        // Create the ButtonBar instance
        Button botonNO = new Button();
        ButtonBar.setButtonData(botonNO, ButtonData.NO);
        botonNO.setText("NO");
        buttonBar.getButtons().addAll(botonYes, botonNO);
        //paneBotones.getChildren().add(botonYes);
        //paneBotones.getChildren().add(botonNO);
        paneBotones.getChildren().add(buttonBar);
        paneContinuar.getChildren().add(paneBotones);
        paneContinuar.setVisible(false);
        
        
        
        
        //ALETRA DIÁLOGO PARA SEGUIR JUGANDO UNA VEZ QUE MUERE ---https://code.makery.ch/blog/javafx-dialogs-official/
        //MOSTRAR EL MENSAJE EN EL TIMELINE DEAD SOLO SI HA TERMINADO LA ANIMACIÓN (EN EJ pasodead=8)
//        alertGameOver.setTitle("GAME OVER");
//        alertGameOver.setHeaderText("You died");
//        alertGameOver.setContentText("Do you want to continue?");
//        alertGameOver.showAndWait();
//        continueAlert = alertGameOver.getResult();
//        System.out.println("ALERTA------------ "+continueAlert);
//        if(continueAlert == ButtonType.OK){//SI EL USUARIO QUIERE SEGUIR JUGANDO SE REINICIA
//            timelineDead.stop();
//            health=2000;
//            textHealth.setText(String.valueOf(health)); 
//        }else{
//            System.out.println("String!!!!!"+continueAlert);
//            stage.close();
//        }


//**********************************************************************************************************************************************

        
        //TIMELINE -IDLE
        // Game loop usando Timeline
        timelineIdle = new Timeline(//Sirve para lo que lo que metamos aquí. Podemos utilizar varios TimeLine con diferentes velocidades para diferentes cosas
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
        timelineIdle.setCycleCount(Timeline.INDEFINITE);//Llama al método setCycleCount (para que la animación siga indefinidamente
        timelineIdle.play(); //Llama al método Play para echar a andar la animación

        
        //TIMELINE -JUMP
        // Game loop usando Timeline
        timelineJump = new Timeline(//Sirve para lo que lo que metamos aquí. Podemos utilizar varios TimeLine con diferentes velocidades para diferentes cosas
            // 0.017 ~= 60 FPS (equivalencia de segundos a Frames por Segundo)
            new KeyFrame(Duration.seconds(0.08), new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae) {//Sólo puede haber un handle en el timeline

                    dentroJump = true;
                    //Xactual = dinosaurView1.getX();
                    //Yactual = dinosaurView1.getY();
                    Xactual = groupD.getLayoutX();
                    Yactual = groupD.getLayoutY(); 

                    //************************** 280/7=40 -----280 diferencia desde la altura la posición inicial del dino (540) hasta la y más alta en el salto (260)
                    if (contJump<15){
                        if (direction==-1){//salto a la izq

                            if (contJump<7){ //El salto va hacia arriba (primera parte)
                                //dinosaurView1.setY(Yactual-40);
                                groupD.setLayoutY(Yactual-40);
                            }else{ //Cuando llega a la mitad el salto va hacia abajo
                                //dinosaurView1.setY(Yactual+40);
                                groupD.setLayoutY(Yactual+40);
                            }
                            dinosaurView1.setImage(dinosaurJi[contJump]);
                            //if (dinosaurView1.getX()>(dinoDeSobra*-1)){// para que no pase del lado izquierdo (como la imagen es larga tiene que salir un poco por la izquierda
                            if (groupD.getLayoutX()>(dinoDeSobra*-1)){
                                //dinosaurView1.setX(Xactual-20);
                                groupD.setLayoutX(Xactual-20);
                            }

                        }else{//salto a la der
                            if (contJump<7){ //El salto va hacia arriba (primera parte)
                                //dinosaurView1.setY(Yactual-40);
                                groupD.setLayoutY(Yactual-40);
                            }else{ //Cuando llega a la mitad el salto va hacia abajo
                                //dinosaurView1.setY(Yactual+40);
                                groupD.setLayoutY(Yactual+40);
                            }
                            dinosaurView1.setImage(dinosaurJd[contJump]);
                            //dinosaurView1.setX(Xactual+20);
                            groupD.setLayoutX(Xactual+20);
                            //if (dinosaurView1.getX()>limite){//Si pasa del límite de la mitad de la pantalla, el dinosaurio se moverá a la izquierda hasta llegar al límite
                            if (groupD.getLayoutX()>limite){
                                //dinosaurView1.setX(limite);
                                groupD.setLayoutX(limite);
                                posicionMomView1 = posicionMomView1-10;
                                posicionMomView2 = posicionMomView2-10;
                                if (posicionMomView2>0){ //Si la posición del visor de fondo 2 es mayor de 0, quiere decir que el fondo no se sale de la pantalla
                                    backgroundView1.setX (posicionMomView1);
                                    backgroundView2.setX (posicionMomView2);
                                }else{ //Si la posición del visor de fondo 2 es menor de 0 quiere decir que volvemos a poner los dos visores de fondo en sus posiciones iniciales para volver a empezar
                                    backgroundView1.setX (0);
                                    backgroundView2.setX (SCENE_WIDTH);                                
                                }                                                                                                                                                 
                            }

                        }
                    }
                    contJump++;                           
                    //System.out.println("------------------------------------");
                    if (contJump == 14){//Cuando el TIMELINE del JUMP llegue a 14 vuevo a activar el TIMELNE del IDLE
                        dentroJump=false;
                        timelineIdle.play(); //Una vez que termine la animación del salto vuelvo a activar el IDLE
                        if (rPressed){//si la flecha a la derecha está pulsada cuando termine el salto seguirá corriendo
                            timelineRunRight.play();
                        }else if(lPressed){
                            timelineRunLeft.play();
                        }
                    }

                }
            })

        );
        timelineJump.setCycleCount(14);//Llama al método setCycleCount (para que la animación HAGA 14 VUELTAS)

        
        
        //TIMELINE - DEAD
        // Game loop usando Timeline
        timelineDead = new Timeline(//Sirve para lo que lo que metamos aquí. Podemos utilizar varios TimeLine con diferentes velocidades para diferentes cosas
            // 0.017 ~= 60 FPS (equivalencia de segundos a Frames por Segundo)
            new KeyFrame(Duration.seconds(0.1), new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae) {//Sólo puede haber un handle en el timeline

                    groupM.setLayoutX(SCENE_WIDTH);
                    groupMiz.setLayoutX(-rectMiz.getWidth());

                    if (direction == -1){
                        dinosaurView1.setImage(dinosaurDi[deadPasos]);
                    }else{
                        dinosaurView1.setImage(dinosaurDd[deadPasos]);                        
                    }
                    deadPasos++;
                    if (deadPasos==8){
                        System.out.println("CONTINUAR");
                        //Mostrar VBox
                        panelInvisible();
                        botonYes.setOnAction((ActionEvent e) -> {//SI PULSAMOS EL BOTÓN SÍ
                            continuar();
                            panelVisible();//muetro el panel principal
                            textHealth.setText(String.valueOf(health));
                            textScore.setText(String.valueOf(score));
                            timelineDead.stop();
                            timelineIdle.play();
                            timelinePlaying.play();
                        });
                        botonNO.setOnAction((ActionEvent e) -> {
                            terminar();
                        });
                    }
                    
                }
            })
        );
        timelineDead.setCycleCount(7);//Llama al método setCycleCount (para que la animación HAGA 8 VUELTAS)                        
        
        
        //TIMELINE - RUN RIGHT
        // Game loop usando Timeline
        timelineRunRight = new Timeline(//Sirve para lo que lo que metamos aquí. Podemos utilizar varios TimeLine con diferentes velocidades para diferentes cosas
        // 0.017 ~= 60 FPS (equivalencia de segundos a Frames por Segundo)
            new KeyFrame(Duration.seconds(0.08), new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae) {//Sólo puede haber un handle en el timeline

                    posicionMomView1 = backgroundView1.getX(); // Cuando pulsemos una tecla leeremos la posición actual del visor del fondo 1 y después moveremos la imagen
                    posicionMomView2 = backgroundView2.getX(); // Cuando pulsemos una tecla leeremos la posición actual del visor del fondo 2 y después moveremos la imagen
                    
                    if (direction == -1){//Si el dinosaurio estba mirando a la izquierda antes de pulsar la flecha a la derecha cambiaremos el sentido a la derecha
                        groupD.setLayoutX(groupD.getLayoutX()+dinoDeSobra);//al girar el dinosaurio hay que quitarle la parte que le sobra a la imagen
                        rectDino.setX(dinosaurView1.getX()+(dinoDeSobra-15));//posicionamos el rectángulo detrás del dinosaurio
                        direction = 1; //sentido en el que corre a la derecha
                    }
                    direction = 1;//pantalla a la derecha
                    i = 1;//cambiar contador imagen IDLE
                    posicionMomView1 = posicionMomView1-10;//posiciones qu se moverán los visores
                    posicionMomView2 = posicionMomView2-10;
                    //Si la x del dinosaurio pasa del límite por la derecha, moveremos sólo los dos visores de fondo
                    if (groupD.getLayoutX()>limite){
                        viewsInMovement=true;//se moverá el fondo en lugar del dinosaurio
                        if (posicionMomView2>0){ //Si la posición del visor de fondo 2 es mayor de 0, quiere decir que el fondo no se sale de la pantalla
                            backgroundView1.setX (posicionMomView1);
                            backgroundView2.setX (posicionMomView2);
                        }else{ //Si la posición del visor de fondo 2 es menor de 0 quiere decir que volvemos a poner los dos visores de fondo en sus posiciones iniciales para volver a empezar
                            backgroundView1.setX (0);
                            backgroundView2.setX (SCENE_WIDTH);                                
                        }
                        if (contPasos>=(7)){//Cuando muestra las 8 imágenes de correr se vuelve a poner a 0
                            contPasos=0;
                        }else{//si no ha llegado a las 8 imágenes, se incrementa
                            contPasos++;                               
                        }
                        dinosaurView1.setImage(dinosaurRd[(contPasos)]);  //muestra la imagendel dinosaurio corriendo que toca                          
                    }else{ //Si la x del dinosaurio no pasa del límite por la derecha moveremos el dinosaurio
                        if (contPasos>=(7)){//Cuando muestra las 8 imágenes de correr se vuelve a poner a 0
                            contPasos=0;
                        }else{//si no ha llegado a las 8 imágenes, se incrementa
                            contPasos++;                               
                        }                        
                        groupD.setLayoutX(groupD.getLayoutX()+10);
                        dinosaurView1.setImage(dinosaurRd[(contPasos)]);
                    }                   
                }
            })
        );
        timelineRunRight.setCycleCount(Timeline.INDEFINITE);//Llama al método setCycleCount (para que la animación HAGA 14 VUELTAS)

        
        //TIMELINE - RUN RIGHT
        // Game loop usando Timeline       
        timelineRunLeft = new Timeline(//Sirve para lo que lo que metamos aquí. Podemos utilizar varios TimeLine con diferentes velocidades para diferentes cosas
        // 0.017 ~= 60 FPS (equivalencia de segundos a Frames por Segundo)
            new KeyFrame(Duration.seconds(0.08), new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae) {//Sólo puede haber un handle en el timeline        
                    if (direction == 1){
                        //dinosaurView1.setX(dinosaurView1.getX()-dinoDeSobra);
                        groupD.setLayoutX(groupD.getLayoutX()-dinoDeSobra);
                        rectDino.setX((dinosaurView1.getX()+(dinoDeSobra+15)));
                        direction = -1; //pantalla a la izquierda
                    }
                    i = 11;//cambair contador imagen IDLE izquierda
                    // para que no pase del lado izquierdo (como la imagen es larga tiene que salir un poco por la izquierda
                    if (groupD.getLayoutX()>(dinoDeSobra*-1)){
                        if (contPasos>=(7)){//Cuando muestra las 8 imágenes de correr se vuelve a poner a 0
                            contPasos=0;
                        }else{//si no ha llegado a las 8 imágenes, se incrementa
                            contPasos++;                               
                        }
                        groupD.setLayoutX(groupD.getLayoutX()-10);
                        dinosaurView1.setImage(dinosaurRi[(contPasos)]);
                    }                                   
                }
            })
        );
        timelineRunLeft.setCycleCount(Timeline.INDEFINITE);//Llama al método setCycleCount (para que la animación HAGA 14 VUELTAS)                            
        
        
        //TIMELINE -SHOOT
        // Game loop usando Timeline
        timelineShoot = new Timeline(//Sirve para lo que lo que metamos aquí. Podemos utilizar varios TimeLine con diferentes velocidades para diferentes cosas
            // 0.017 ~= 60 FPS (equivalencia de segundos a Frames por Segundo)
            new KeyFrame(Duration.seconds(0.08), new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae) {//Sólo puede haber un handle en el timeline
                   //LA BOLA SALDRÁ DE LA PANTALLA Y SI CHOCA CON UN ENEMIGO DESAPARECE
                    if (direcBall == -1){//Si está mirando a la izquierda
                        circleBall.setCenterX(circleBall.getCenterX()-10);
                    }else if (direcBall == 1){
                        circleBall.setCenterX(circleBall.getCenterX()+10);    
                    }
                    Shape circleBallrectM = Shape.intersect(circleBall,rectM);//Creamos una variable de la clase Shape para guardar la intersección
                    boolean colisionVaciaM = circleBallrectM.getBoundsInLocal().isEmpty();
                    if (colisionVaciaM==false){//LA BOLA DEL DINOSAURIO LE HA DADO AL MONSTRUO Y EL MONSTRUO DERECHO DESAPARECE
                        groupM.setLayoutX(SCENE_WIDTH);//si choca el monstruo vuelve a la salida
                        circleBall.setCenterX(-300);//si choca la bola vuelve a posicionarse fuera de la pantalla
                        direcBall=0;
                        score = score+20;
                        textScore.setText(String.valueOf(score));                                        
                    }
                    Shape circleBallrectMiz = Shape.intersect(circleBall,rectMiz);//Creamos una variable de la clase Shape para guardar la intersección
                    boolean colisionVaciaMiz = circleBallrectMiz.getBoundsInLocal().isEmpty();
                    if (colisionVaciaMiz==false){//LA BOLA DEL DINOSAURIO LE HA DADO AL MONSTRUO Y EL MONSTRUO IZQUIERDO DESAPARECE
                        groupMiz.setLayoutX(-rectMiz.getWidth());//si choca el monstruo vuelve a la salida
                        circleBall.setCenterX(-300);//si choca la bola vuelve a posicionarse fuera de la pantalla
                        direcBall=0;
                        score = score+20;
                        textScore.setText(String.valueOf(score));                                        
                    }
                }
            })                
        );
        timelineShoot.setCycleCount(Timeline.INDEFINITE);//Llama al método setCycleCount (La animación seguirá hasta que la bola salga de la pantalla)
        

        //TIMELINE - PLAYING*************************************OJO<<<<<<-----------------------------
        // Game loop usando Timeline
        timelinePlaying = new Timeline(//Sirve para lo que lo que metamos aquí. Podemos utilizar varios TimeLine con diferentes velocidades para diferentes cosas
            // 0.017 ~= 60 FPS (equivalencia de segundos a Frames por Segundo)
            new KeyFrame(Duration.seconds(0.017), new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae) {//Sólo puede haber un handle en el timeline   
                                                          
                    //VARIABLES PARA COLISION
                    Shape dinoMonstruo = Shape.intersect(rectDino,rectM);//Creamos una variable de la clase Shape para guardar la intersección de la colisión entre dinosaurio y monstruo
                    boolean colisionDMVacia = dinoMonstruo.getBoundsInLocal().isEmpty();//Si la intersección está vacía es que no han chocado
                    Shape dinoMonstruoiz = Shape.intersect(rectDino,rectMiz);//Si colisiona con el monstruo de la izquierda
                    boolean colisionDMizVacia = dinoMonstruoiz.getBoundsInLocal().isEmpty();
                   
                    //MOVIMIENTO DE MONSTRUOS
                    if (groupM.getLayoutX() > 0){//El monstruo está a la derecha y va hacia la izquierda
                        if (viewsInMovement==false){//Si no se mueve el fondo el monstruo de la derecha correra. Si se mueve el fondo correra a la velocidad del fondo (8)
                            groupM.setLayoutX(groupM.getLayoutX()-1);
                        }else{//si se mueve el fondo correrá también
                            groupM.setLayoutX(groupM.getLayoutX()-1);
                        }
                    }else{//si se pasa por la izquierda vuelve al comienzo
                        groupM.setLayoutX(SCENE_WIDTH);
                    }
                    if(groupMiz.getLayoutX() < SCENE_WIDTH){//El monstruo está a la izquierda y va a la derecha (debe llegar también al cacho de sobra del dino, si no no choca)
                        if(viewsInMovement==false){//Si no se mueve el fondo el monstruo de la izquierda correra. Si se mueve correrá a la velocidad del fondo (8-1)
                            groupMiz.setLayoutX(groupMiz.getLayoutX()+1);
                        }else{//Si se mueve el fondo y está en pantalla
                            if(groupMiz.getLayoutX()>(-rectMiz.getWidth()-15)){    
                                groupMiz.setLayoutX(groupMiz.getLayoutX()-1);
                            }
                        }
                    }else{//Si se pasa por la derecha vuelve al comienzo
                        groupMiz.setLayoutX(-(rectMiz.getWidth()+15));    
                    }
                    
                    //DETECTA COLISIONES
                    if (colisionDMVacia==false){
                        health=health-200;
                        groupM.setLayoutX(SCENE_WIDTH);
                        textHealth.setText(String.valueOf(health));                                                
                    }
                    
                    if (colisionDMizVacia==false){
                        health=health-200;
                        groupMiz.setLayoutX(-rectMiz.getWidth());
                        textHealth.setText(String.valueOf(health));                       
                    }
                    
                    //DETECTA EL DAÑO                   
                    if (health==1800){
                        heartView10.setImage(heartBlack);
                    }else if (health==1600){
                        heartView9.setImage(heartBlack);
                    }else if (health==1400){
                        heartView8.setImage(heartBlack);
                    }else if (health==1200){
                        heartView7.setImage(heartBlack);
                    }else if (health==1000){
                        heartView6.setImage(heartBlack);
                    }else if (health==800){
                        heartView5.setImage(heartBlack);
                    }else if (health==600){
                        heartView4.setImage(heartBlack);
                    }else if (health==400){
                        heartView3.setImage(heartBlack);
                    }else if (health==200){
                        heartView2.setImage(heartBlack);
                    }else if (health == 0){
                        heartView1.setImage(heartBlack);
                        deadPasos = 1;                      
                        timelineIdle.stop();
                        timelineRunRight.stop();
                        if (contJump == 14){//que haya terminadoel salto antes de morir
                            timelineJump.stop();
                        }
                        timelinePlaying.stop();
                        timelineDead.play(); //Llama al método Play para echar a andar la animación

                    }                                                                      
                }
            })                
        );
        timelinePlaying.setCycleCount(Timeline.INDEFINITE);//Llama al método setCycleCount (para que la animación siga indefinidamente
        timelinePlaying.play(); //Llama al método Play para echar a andar la animación    

        
        //CUANDO LAS TECLAS SON PULSADAS
        scene.setOnKeyPressed(new EventHandler<KeyEvent>(){//Llama al método setOnKeyPressed. Cuando detecte que se pulsa una tecla en la escena (se puede hacer que en vez que en la escena se detecte cuando pulse dentro de un campo de texto)
            public void handle(final KeyEvent keyEvent){
                timelineIdle.stop();//PARA EL TIMELINE IDLE PARA QUE NO INTERFIERA CON LA PULSACIÓN DE TECLAS
                posicionMomView1 = backgroundView1.getX(); // Cuando pulsemos una tecla leeremos la posición actual del visor del fondo 1 y después moveremos la imagen
                posicionMomView2 = backgroundView2.getX(); // Cuando pulsemos una tecla leeremos la posición actual del visor del fondo 2 y después moveremos la imagen          
               
              
                switch(keyEvent.getCode()){//Según la tecla pulsada
                    case LEFT:// el dinosaurio se moverá a la izquierda
                        lPressed=true;
                        viewsInMovement=false;//si va a la izquierda el fondo deja de moverse 
                        timelineRunLeft.play();
                        break;

                    case RIGHT: //el fondo se moverá a la izquierda
                        rPressed=true;//Para saber si la tecla a la derecha está pulsada
                        timelineRunRight.play();                      
                        break;

                    case UP:
                        timelineRunRight.stop();//antes de saltar paramos la animación de correr a derecha e izquierda
                        timelineRunLeft.stop();
                        if(dentroJump==false){//Solo saltará si no es un salto encima de otro
                            groupD.setLayoutY(dinosaurioY);
                            contJump=0;//para que pueda mostrar los dinosaurios en timeline
                            timelineJump.play();
                        }
                        break;
                    

                    case SPACE://Cuando se pulse espacio disparará una bola
                        direcBall = direction;//lo igualo al empezar a disparar porque el dinosaurio y la bola puede tomar direcciones diferentes una vez disparada
                        if (direcBall == -1){//Si está mirando a la izquierda
                            dinosaurView1.setImage(dinosaurSi);
                            // le sumamos lo que sobra de imagen del dinosaurio(por un lado) menos el radio de la bola
                            circleBall.setCenterX(groupD.getLayoutX()+(dinoDeSobra-circleBall.getRadius()));
                        }else{//Si está mirando a la derecha
                            dinosaurView1.setImage(dinosaurSd);
                            // le sumaremos lo que sobra de imagen del dinosaurio (por los dos lados ya que va hacia la derecha) más radio de la bola más la anchura de la imagen del dinosaurio
                            circleBall.setCenterX(groupD.getLayoutX()+dinosaurView1.getFitWidth()+(dinoDeSobra*2)+circleBall.getRadius());
                        }
                        //circleBall.setCenterY(dinosaurView1.getY()+59);//Altura a la mitad del alto del dinosaurio
                        circleBall.setCenterY(groupD.getLayoutY()+59);
                        timelineShoot.play(); //Llama al método Play para echar a andar la animación
                        if ((direcBall == -1) && (circleBall.getCenterX() < (-circleBall.getRadius()))){
                            timelineShoot.stop();
                        }else if ((direcBall == 1) && (circleBall.getCenterX() > (SCENE_WIDTH + circleBall.getRadius()))){
                            timelineShoot.stop();
                        } 
                        break;
                }
            }
        }); 
               
        scene.setOnKeyReleased(new EventHandler<KeyEvent>(){//Llama al método setOnKeyPressed. Cuando detecte que se pulsa una tecla en la escena (se puede hacer que en vez que en la escena se detecte cuando pulse dentro de un campo de texto)
            public void handle(final KeyEvent keyEvent){
                if (keyEvent.getCode() != keyEvent.getCode().UP){ //ACTIVARÁ EL TIMELINE DE IDLE SIEMPRE QUE NO SE SUELTE LA TECLA UP
                    timelineIdle.play(); //Llama al método Play para echar a andar la animación
                }
                if (keyEvent.getCode() == keyEvent.getCode().RIGHT){ //ACTIVARÁ EL TIMELINE DE IDLE SIEMPRE QUE NO SE SUELTE LA TECLA UP
                    timelineRunRight.stop();
                    rPressed=false;//si se suelta la tecla a la derecha, cuando haga el salto se parará
                }else if (keyEvent.getCode() == keyEvent.getCode().LEFT){ //ACTIVARÁ EL TIMELINE DE IDLE SIEMPRE QUE NO SE SUELTE LA TECLA UP
                    timelineRunLeft.stop();
                    lPressed=false;//si se suelta la tecla a la derecha, cuando haga el salto se parará
                }
            }          
        });
    }
    
    private void panelInvisible(){
        backgroundView1.setVisible(false);
        backgroundView2.setVisible(false);
        paneContinuar.setVisible(true);
        paneScores.setVisible(false);
        groupD.setVisible(false);
        groupM.setVisible(false);
        groupMiz.setVisible(false);
        circleBall.setVisible(false);
        heartView1.setVisible(false);
        heartView2.setVisible(false);
        heartView3.setVisible(false);
        heartView4.setVisible(false);
        heartView5.setVisible(false);
        heartView6.setVisible(false);
        heartView7.setVisible(false);
        heartView8.setVisible(false);
        heartView9.setVisible(false);
        heartView10.setVisible(false);
        paneGeneralName.setVisible(false);
    }
    
    private void panelVisible(){
        backgroundView1.setVisible(true);
        backgroundView2.setVisible(true);
        paneContinuar.setVisible(false);
        paneScores.setVisible(true);
        groupD.setVisible(true);
        groupM.setVisible(true);
        groupMiz.setVisible(true);
        circleBall.setVisible(true);
        heartView1.setVisible(true);
        heartView2.setVisible(true);
        heartView3.setVisible(true);
        heartView4.setVisible(true);
        heartView5.setVisible(true);
        heartView6.setVisible(true);
        heartView7.setVisible(true);
        heartView8.setVisible(true);
        heartView9.setVisible(true);
        heartView10.setVisible(true);
        paneGeneralName.setVisible(true);
    }
    
    private void continuar(){
        health = 2000;
        score = 0;
        heartView1.setImage(heartImage);
        heartView2.setImage(heartImage);
        heartView3.setImage(heartImage);
        heartView4.setImage(heartImage);
        heartView5.setImage(heartImage);
        heartView6.setImage(heartImage);
        heartView7.setImage(heartImage);
        heartView8.setImage(heartImage);
        heartView9.setImage(heartImage);
        heartView10.setImage(heartImage);
        dinosaurView1.setImage(dinosaur1);
        groupD.setLayoutX(limite);
        groupD.setLayoutY(dinosaurioY);
        groupD.setLayoutX(limite);
    }
  
    private void terminar(){
        System.exit(0);
    }
    
    public static void main(String[] args) {
        launch();
    }

}