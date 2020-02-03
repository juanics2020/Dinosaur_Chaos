//PEGAR LAS IMÁGENES 13,14 y 15 EN JUMP IZ Y JUMP normal
//CAMBIAR A dinosaur_chaos para el de CLASE***********y dinosaurchaos para la CASA


//*********************COSAS A ARREGLAR:
//Cuando va corriendo y salta se para aunque siga pulsada la ->
//Cuando se hace un salto cuando ya está saltando se va hacia abajo el dinosaurio
//Cuando se deja pulsado el espacio tira muchas bolas y se vuelve loco
//Debería poder inicializar los TIMELINE arriba para usarlos en el START y poder pararlos cuando convenga ya que si los paro abajo me dice que no están inicializados todavía
// ---> quitar health=health-200; en el SWITCH case RIGHT (SÓLO ERA PARA VER SI HACÍA LA ANIMACIÓN DE DEAD


package es.juanics.dinosaur_chaos;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
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
    
    //short estadoDino = 0; // 0 ->idle, 1 ->walk, 2 ->run, 3 ->jump, 4 ->dead
    short direction = 1; //1 ->der, -1 ->izq, 0 ->pantalla parada
    double posicionMomView1 = 0;//Guardará la posición que tenga la pantalla el visor 1
    double posicionMomView2 = 0;//Guardará la posición que tenga la pantalla el visor 2
    double dinoDeSobra = dinosaur1.getWidth()/3;//Imagen que sobra por los laterales cuando gira el dino (habrá que sumar o restar cuando gira)
    int contPasos = 0;//Para que cuente los pasos, que cambie la imagen   
    int contJump=0;//contador para Timeline2 del salto
    double Xactual = 0;
    double Yactual = 0;
    double limite = ((SCENE_WIDTH/2)-dinosaurView1.getFitWidth());//Límite a donde llega el dinosaurio y comienza scroll
    int vidaDino = 2000;
    double distBall = 0; //guardará la distancia que debe recorrer la bola hasta salir de la escena (por la izquierda o la derecha)
    int direcBall = 1; //la dirección a la que irá la bola (porque la dirección del dinosaurio puede cambiar mientras que la bola está en movimiento
    int score = 0;
    int health= 2000; //Un corazón vale 200 puntos (tiene 10)
    int deadPasos = 1;   
    boolean desapareceGroupM = false;//Cuando el dinosaurio le de al monstruo, el monstruo tiene que desaparecer

    
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
        //GRUPO IMAGEN DINOSAURIO + RECTANGULO
        Group groupD = new Group();
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
        
        groupD.getChildren().add(rectDino);
        groupD.getChildren().add(dinosaurView1);
        root.getChildren().add(groupD);
        groupD.setLayoutX(limite);
        groupD.setLayoutY(dinosaurioY);
 
        
        //PONER LA BOLA QUE TIRA EL DINOSAURIO
        //new Circle() => Crear un objeto de la clase Circle
        Circle circleBall = new Circle(); //Creamos una variable llamada circleBall(nuevo objeto -> new) de tipo Círculo(clase Círculo)
        //Llamamos a MÉTODOS del objeto circleBall
        circleBall.setCenterX(-30);
        circleBall.setCenterY(60);
        circleBall.setRadius(10);
        circleBall.setFill(Color.YELLOW);
        //circleBall.setOpacity(0);//Con la Opacidad en 0 está transparente. Con la opacidad en 100 se ve normal
        
        root.getChildren().add(circleBall);//Hay que añadir la bola al StackPane(panel llamado root). Los objtos que contiene el panel son los Children.
 
        
        //AÑADIR GRUPO DE FORMAS PARA HACER ENEMIGO
        Group groupM = new Group();
        //RECTÁGULO
        Rectangle rectM= new Rectangle();
        //Métodos del objeto RECTÁNGULO
        rectM.setWidth(SCENE_WIDTH/18);
        rectM.setHeight(SCENE_HEIGHT/6);
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
        eyeRM.setCenterX(headM.getCenterX()-eyeRM.getRadius());//+(eyeRM.getRadius()));
        eyeRM.setCenterY(headM.getCenterY());//+(eyeRM.getRadius()));
        eyeRM.setFill(Color.RED);        
        eyeRM.setStroke(Color.BLACK);
         //LÍNEA CEJA DERECHA
        Line browRM = new Line();
        browRM.setStartX(eyeRM.getCenterX()-10);
        browRM.setStartY(eyeRM.getCenterY()-2);
        browRM.setEndX(eyeRM.getCenterX()+8);
        browRM.setEndY(eyeRM.getCenterY()-14);
        browRM.setStroke(Color.RED);
        browRM.setStrokeWidth(3);         
              
        groupM.getChildren().add(rectM);
        groupM.getChildren().add(headM);
        groupM.getChildren().add(eyeRM); 
        groupM.getChildren().add(browRM);
        
        root.getChildren().add(groupM);
        
        groupM.setLayoutX(groupD.getLayoutX()+300);
        groupM.setLayoutY(((groupD.getLayoutY()+rectM.getHeight())-(rectM.getHeight()-dinosaurView1.getFitHeight())-15));
        

        
        
        //PONER LOS CORAZONES
        //*********************
        ImageView heartView1 = new ImageView (heartImage); // El corazón mide 31 * 31 pixeles
        heartView1.setX(SCENE_WIDTH-(SCENE_WIDTH/3));//donde vamos a colocar la imagen A CONTINUACION DE LA PRIMERA
        heartView1.setY(20);       
        
        ImageView heartView2 = new ImageView (heartImage); // El corazón mide 31 * 31 pixeles
        heartView2.setX(SCENE_WIDTH-((SCENE_WIDTH/3)-31));//donde vamos a colocar la imagen A CONTINUACION DE LA PRIMERA
        heartView2.setY(20); 
        
        ImageView heartView3 = new ImageView (heartImage); // El corazón mide 31 * 31 pixeles
        heartView3.setX(SCENE_WIDTH-((SCENE_WIDTH/3)-(31+31)));//donde vamos a colocar la imagen A CONTINUACION DE LA PRIMERA
        heartView3.setY(20); 
        
        ImageView heartView4 = new ImageView (heartImage); // El corazón mide 31 * 31 pixeles
        heartView4.setX(SCENE_WIDTH-((SCENE_WIDTH/3)-(31+31+31)));//donde vamos a colocar la imagen A CONTINUACION DE LA PRIMERA
        heartView4.setY(20); 
        
        ImageView heartView5 = new ImageView (heartImage); // El corazón mide 31 * 31 pixeles
        heartView5.setX(SCENE_WIDTH-((SCENE_WIDTH/3)-(31+31+31+31)));//donde vamos a colocar la imagen A CONTINUACION DE LA PRIMERA
        heartView5.setY(20);        

        ImageView heartView6 = new ImageView (heartImage); // El corazón mide 31 * 31 pixeles
        heartView6.setX(SCENE_WIDTH-((SCENE_WIDTH/3)-(31+31+31+31+31)));//donde vamos a colocar la imagen A CONTINUACION DE LA PRIMERA
        heartView6.setY(20); 
        
        ImageView heartView7 = new ImageView (heartImage); // El corazón mide 31 * 31 pixeles
        heartView7.setX(SCENE_WIDTH-((SCENE_WIDTH/3)-(31+31+31+31+31+31)));//donde vamos a colocar la imagen A CONTINUACION DE LA PRIMERA
        heartView7.setY(20); 
        
        ImageView heartView8 = new ImageView (heartImage); // El corazón mide 31 * 31 pixeles
        heartView8.setX(SCENE_WIDTH-((SCENE_WIDTH/3)-(31+31+31+31+31+31+31)));//donde vamos a colocar la imagen A CONTINUACION DE LA PRIMERA
        heartView8.setY(20); 
        
        ImageView heartView9 = new ImageView (heartImage); // El corazón mide 31 * 31 pixeles
        heartView9.setX(SCENE_WIDTH-((SCENE_WIDTH/3)-(31+31+31+31+31+31+31+31)));//donde vamos a colocar la imagen A CONTINUACION DE LA PRIMERA
        heartView9.setY(20);        

        ImageView heartView10 = new ImageView (heartImage); // El corazón mide 31 * 31 pixeles
        heartView10.setX(SCENE_WIDTH-((SCENE_WIDTH/3)-(31+31+31+31+31+31+31+31+31)));//donde vamos a colocar la imagen A CONTINUACION DE LA PRIMERA
        heartView10.setY(20);              
        
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
        
        
        //LAYOUTS PARA MOSTRAR PUNTUACIONES
        //*********************************
        //Layout principal
        HBox paneScores = new HBox();
        paneScores.setTranslateY(20);
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
        
        //Texto de etiqueta para la puntuación
        Text textTitleScore = new Text("Score:");
        textTitleScore.setFont(Font.font(TEXT_SIZE));
        textTitleScore.setFill(Color.WHITE);
        //Texto para la puntuación
        Text textScore = new Text(String.valueOf(score));
        textScore.setFont(Font.font(TEXT_SIZE));
        textScore.setFill(Color.WHITE);
        //Texto de etiqueta para la vida
        Text textTitleHealth = new Text("Health:");
        textTitleHealth.setFont(Font.font(TEXT_SIZE));
        textTitleHealth.setFill(Color.WHITE);
        //Texto para la puntuación máxima
        Text textHealth = new Text(String.valueOf(health));
        textHealth.setFont(Font.font(TEXT_SIZE));
        textHealth.setFill(Color.WHITE);
        
        //Añadir los textos a los layouts reservados para ellos
        paneCurrentScore.getChildren().add(textTitleScore);//caja de texto 1, puntuación actual
        paneCurrentScore.getChildren().add(textScore);//texto dentro de la caja de texto 1, puntuación actual
        paneLife.getChildren().add(textTitleHealth);//caja de texto 2, puntuación máxima
        paneLife.getChildren().add(textHealth);//texto dentro de la caja de texto 2, puntuación máxima    
        
        



//**********************************************************************************************************************************************

        
        //TIMELINE -IDLE
        // Game loop usando Timeline
        Timeline timelineIdle = new Timeline(//Sirve para lo que lo que metamos aquí. Podemos utilizar varios TimeLine con diferentes velocidades para diferentes cosas
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

        
        //TIMELINE - PLAYING*************************************OJO<<<<<<-----------------------------
        // Game loop usando Timeline
        Timeline timelinePlaying = new Timeline(//Sirve para lo que lo que metamos aquí. Podemos utilizar varios TimeLine con diferentes velocidades para diferentes cosas
            // 0.017 ~= 60 FPS (equivalencia de segundos a Frames por Segundo)
            new KeyFrame(Duration.seconds(0.017), new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae) {//Sólo puede haber un handle en el timeline   
                    
                    if (desapareceGroupM==false){
                        if (groupM.getLayoutX() > groupD.getLayoutX()){
                            groupM.setLayoutX(groupM.getLayoutX()-1);
                        }else if(groupM.getLayoutX() < groupD.getLayoutX()){
                            groupM.setLayoutX(groupM.getLayoutX()+1);                       
                        }else{
                            health=health-200;
                            groupM.setLayoutX(limite+300);
                        }
                    }
                    
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
                        timelineIdle.stop();
                        deadPasos = 1;
                        //TIMELINE - DEAD
                        // Game loop usando Timeline
                        Timeline timelineDead = new Timeline(//Sirve para lo que lo que metamos aquí. Podemos utilizar varios TimeLine con diferentes velocidades para diferentes cosas
                            // 0.017 ~= 60 FPS (equivalencia de segundos a Frames por Segundo)
                            new KeyFrame(Duration.seconds(0.1), new EventHandler<ActionEvent>() {
                                public void handle(ActionEvent ae) {//Sólo puede haber un handle en el timeline
                                   //SWITCH PARA QUE LAS IMÀGENES DEL DINOSAURIO CAMBIEN

                                    if (direction == -1){
                                        dinosaurView1.setImage(dinosaurDi[deadPasos]);
                                    }else{
                                        dinosaurView1.setImage(dinosaurDd[deadPasos]);                        
                                    }
                                    deadPasos++;
                                }
                            })

                        );
                        timelineDead.setCycleCount(8);//Llama al método setCycleCount (para que la animación HAGA 14 VUELTAS)
                        timelineDead.play(); //Llama al método Play para echar a andar la animación                          
                    }                                    
                                   
                }
            })                
        );
        timelinePlaying.setCycleCount(Timeline.INDEFINITE);//Llama al método setCycleCount (para que la animación siga indefinidamente
        timelinePlaying.play(); //Llama al método Play para echar a andar la animación    
       
        //
        scene.setOnKeyPressed(new EventHandler<KeyEvent>(){//Llama al método setOnKeyPressed. Cuando detecte que se pulsa una tecla en la escena (se puede hacer que en vez que en la escena se detecte cuando pulse dentro de un campo de texto)
            public void handle(final KeyEvent keyEvent){
                timelineIdle.stop();//PARA EL TIMELINE IDLE PARA QUE NO INTERFIERA CON LA PULSACIÓN DE TECLAS
                posicionMomView1 = backgroundView1.getX(); // Cuando pulsemos una tecla leeremos la posición actual del visor del fondo 1 y después moveremos la imagen
                posicionMomView2 = backgroundView2.getX(); // Cuando pulsemos una tecla leeremos la posición actual del visor del fondo 2 y después moveremos la imagen          

               
              
                switch(keyEvent.getCode()){//Según la tecla pulsada
                    case LEFT:// el dinosaurio se moverá a la izquierda
                        if (direction == 1){
                            //dinosaurView1.setX(dinosaurView1.getX()-dinoDeSobra);
                            groupD.setLayoutX(groupD.getLayoutX()-dinoDeSobra);
                            rectDino.setX((dinosaurView1.getX()+(dinoDeSobra+15)));
                            direction = -1; //pantalla a la izquierda
                        }
                        i = 11;//cambair contador imagen IDLE izquierda
                        //if (dinosaurView1.getX()>(dinoDeSobra*-1)){// para que no pase del lado izquierdo (como la imagen es larga tiene que salir un poco por la izquierda
                        if (groupD.getLayoutX()>(dinoDeSobra*-1)){
                            if (contPasos>=(7*3)){//Cuando muestra las 8 imágenes de correr se vuelve a poner a 0
                                contPasos=0;
                            }else{//si no ha llegado a las 8 imágenes, se incrementa
                                contPasos++;                               
                            }
                            //dinosaurView1.setX ((dinosaurView1.getX())-8);
                            groupD.setLayoutX(groupD.getLayoutX()-8);
                            dinosaurView1.setImage(dinosaurRi[(contPasos/3)]);
                        }                       
                        break;

                    case RIGHT: //el fondo se moverá a la izquierda
                        if (direction == -1){
                            //dinosaurView1.setX(dinosaurView1.getX()+dinoDeSobra);
                            groupD.setLayoutX(groupD.getLayoutX()+dinoDeSobra);
                            rectDino.setX(dinosaurView1.getX()+(dinoDeSobra-15));//rectDino.getWidth()+(dinoDeSobra+15))
                            direction = 1; //pantalla a la izquierda
                        }

                        direction = 1;//pantalla a la derecha
                        i = 1;//cambiar contador imagen IDLE
                        posicionMomView1 = posicionMomView1-8;
                        posicionMomView2 = posicionMomView2-8;
                        //if (dinosaurView1.getX()>limite){ //Si la x del dinosaurio pasa del límite por la derecha, moveremos sólo los dos visores de fondo
                        if (groupD.getLayoutX()>limite){
                            if (posicionMomView2>0){ //Si la posición del visor de fondo 2 es mayor de 0, quiere decir que el fondo no se sale de la pantalla
                                backgroundView1.setX (posicionMomView1);
                                backgroundView2.setX (posicionMomView2);
                            }else{ //Si la posición del visor de fondo 2 es menor de 0 quiere decir que volvemos a poner los dos visores de fondo en sus posiciones iniciales para volver a empezar
                                backgroundView1.setX (0);
                                backgroundView2.setX (SCENE_WIDTH);                                
                            }
                            if (contPasos>=(7*3)){//Cuando muestra las 8 imágenes de correr se vuelve a poner a 0
                                contPasos=0;
                            }else{//si no ha llegado a las 8 imágenes, se incrementa
                                contPasos++;                               
                            }

                            dinosaurView1.setImage(dinosaurRd[(contPasos/3)]);                            
                        }else{ //Si la x del dinosaurio no pasa del límite por la derecha moveremos el dinosaurio
                            if (contPasos>=(7*3)){//Cuando muestra las 8 imágenes de correr se vuelve a poner a 0
                                contPasos=0;
                            }else{//si no ha llegado a las 8 imágenes, se incrementa
                                contPasos++;                               
                            }
                            //dinosaurView1.setX ((dinosaurView1.getX())+8);
                            groupD.setLayoutX(groupD.getLayoutX()+8);
                            dinosaurView1.setImage(dinosaurRd[(contPasos/3)]);
                        }
                         
                        break;

                    case UP:
                        //dinosaurView1.setY(dinosaurioY);
                        groupD.setLayoutY(dinosaurioY);
                        contJump=0;//para que pueda mostrar los dinosaurios en timeline
                        //TIMELINE -JUMP
                        // Game loop usando Timeline
                        Timeline timelineJump = new Timeline(//Sirve para lo que lo que metamos aquí. Podemos utilizar varios TimeLine con diferentes velocidades para diferentes cosas
                            // 0.017 ~= 60 FPS (equivalencia de segundos a Frames por Segundo)
                            new KeyFrame(Duration.seconds(0.14), new EventHandler<ActionEvent>() {
                                public void handle(ActionEvent ae) {//Sólo puede haber un handle en el timeline
                                    
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
                                                posicionMomView1 = posicionMomView1-30;
                                                posicionMomView2 = posicionMomView2-30;
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
                                        timelineIdle.play(); //Una vez que termine la animación del salto vuelvo a activar el IDLE
                                    }
                                    
                                }
                            })
       
                        );
                      
                        timelineJump.setCycleCount(14);//Llama al método setCycleCount (para que la animación HAGA 14 VUELTAS)
                        timelineJump.play(); //Llama al método Play para echar a andar la animación
                        break;
                    

                    case SPACE://Cuando se pulse espacio disparará una bola
                        direcBall = direction;
                        if (direcBall == -1){//Si está mirando a la izquierda
                            dinosaurView1.setImage(dinosaurSi);
                            //circleBall.setCenterX(dinosaurView1.getX()+(dinoDeSobra-circleBall.getRadius()));// le sumamos lo que sobra de imagen del dinosaurio(por un lado) menos el radio de la bola
                            circleBall.setCenterX(groupD.getLayoutX()+(dinoDeSobra-circleBall.getRadius()));
                            distBall = circleBall.getCenterX(); // desde 0 (pantalla por la izquierda hasta posición de la bola
                        }else{//Si está mirando a la derecha
                            dinosaurView1.setImage(dinosaurSd);
                            //circleBall.setCenterX(dinosaurView1.getX()+dinosaurView1.getFitWidth()+(dinoDeSobra*2)+circleBall.getRadius());// le sumaremos lo que sobra de imagen del dinosaurio (por los dos lados ya que va hacia la derecha) más radio de la bola más la anchura de la imagen del dinosaurio
                            circleBall.setCenterX(groupD.getLayoutX()+dinosaurView1.getFitWidth()+(dinoDeSobra*2)+circleBall.getRadius());
                            distBall = SCENE_WIDTH-circleBall.getCenterX(); // desdee la parte derecha de la pantalla hasta la posición de la bola
                        }
                        //circleBall.setCenterY(dinosaurView1.getY()+59);//Altura a la mitad del alto del dinosaurio
                        circleBall.setCenterY(groupD.getLayoutX()+59);
                        
                        //TIMELINE -SHOOT
                        // Game loop usando Timeline
                        Timeline timelineShoot = new Timeline(//Sirve para lo que lo que metamos aquí. Podemos utilizar varios TimeLine con diferentes velocidades para diferentes cosas
                            // 0.017 ~= 60 FPS (equivalencia de segundos a Frames por Segundo)
                            new KeyFrame(Duration.seconds(0.08), new EventHandler<ActionEvent>() {
                                public void handle(ActionEvent ae) {//Sólo puede haber un handle en el timeline
                                   //LA BOLA SALDRÁ DE LA PANTALLA Y SI CHOCA CON UN ENEMIGO LA OPACIDAD SERÁ 0 PARA QUE DESAPAREZCA
                                    if (direcBall == -1){//Si está mirando a la izquierda
                                        circleBall.setCenterX(circleBall.getCenterX()-30);
                                    }else{
                                        circleBall.setCenterX(circleBall.getCenterX()+30);    
                                    }
                                    Shape circleBallrectM = Shape.intersect(circleBall,rectM);//Creamos una variable de la clase Shape para guardar la intersección
                                    boolean colisionVacia = circleBallrectM.getBoundsInLocal().isEmpty();
                                    if (colisionVacia==false){//LA BOLA DEL DINOSAURIO LE HA DADO AL MONSTRUO
                                        groupM.setVisible(false);
                                        desapareceGroupM = true;
                                        score = score+20;
                                        textScore.setText(String.valueOf(score));                                        
                                    }
                                }
                            })                
                        );
                        timelineShoot.setCycleCount((int)distBall);//Llama al método setCycleCount (La animación seguirá hasta que la bola salga de la pantalla)
                        timelineShoot.play(); //Llama al método Play para echar a andar la animación
                                                                     
                        break;
                }
            }
        }); 
               
        scene.setOnKeyReleased(new EventHandler<KeyEvent>(){//Llama al método setOnKeyPressed. Cuando detecte que se pulsa una tecla en la escena (se puede hacer que en vez que en la escena se detecte cuando pulse dentro de un campo de texto)
            public void handle(final KeyEvent keyEvent){
                if (keyEvent.getCode() != keyEvent.getCode().UP){ //ACTIVARÁ EL TIMELINE DE IDLE SIEMPRE QUE NO SE SUELTE LA TECLA UP
                    timelineIdle.play(); //Llama al método Play para echar a andar la animación
                }
            }          
        });
    
       
        
    }

    public static void main(String[] args) {
        launch();
    }

}