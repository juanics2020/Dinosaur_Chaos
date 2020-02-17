//CAMBIAR A dinosaur_chaos para el de CLASE***********y dinosaurchaos para la CASA


package es.juanics.dinosaur_chaos;

import java.util.Random;
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
import javafx.scene.control.ProgressBar;
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
    final int dinosaurioY = SCENE_HEIGHT - (SCENE_HEIGHT / 4);
    final short TEXT_SIZE = 24;
    final int healthBotInicial = 800;

//ORB DEL BOT
    Image orb = new Image(getClass().getResourceAsStream("/images/Orb_05_copy.png"));
    Image orb2 = new Image(getClass().getResourceAsStream("/images/Orb_06_copy.png")); 

//COIN
    Image coinImage = new Image(getClass().getResourceAsStream("/images/coinImage.png"));

//HEART
    Image heartImage = new Image(getClass().getResourceAsStream("/images/heart.png"));
    Image heartBlack = new Image(getClass().getResourceAsStream("/images/heartBlack.png"));

//SHOOT
    Image dinosaurSd = new Image(getClass().getResourceAsStream("/images/Shoot (1).png"));
    Image dinosaurSi = new Image(getClass().getResourceAsStream("/images/Shootiz (1).png"));

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

    Image[] dinosaurWd = new Image[10];

    Image[] dinosaurWi = new Image[10];

    Image[] dinosaurRd = new Image[8];

    Image[] dinosaurRi = new Image[8];

    Image[] dinosaurJd = new Image[15];

    Image[] dinosaurJi = new Image[15];

    Image[] dinosaurDd = new Image[8];

    Image[] dinosaurDi = new Image[8];
    //---   
    ImageView dinosaurView1 = new ImageView(dinosaur1);//meter la imagen dinosaurio en view
    //--- 
    Image[] botIz = new Image[20];
    Image[] botDer = new Image[20];
    Image[] botRunIz = new Image[16];
    Image[] botRunDer = new Image[16];
    Image botHitIz = new Image(getClass().getResourceAsStream("/images/bot_hit_iz.png"));
    Image botHitDer = new Image(getClass().getResourceAsStream("/images/bot_hit_der.png"));
    Image botShootDer = new Image(getClass().getResourceAsStream("/images/bot_shoot_der.png"));
    Image botShootIz = new Image(getClass().getResourceAsStream("/images/bot_shoot_iz.png"));

    
    final int limite = (int) ((SCENE_WIDTH - (SCENE_WIDTH / 3)) - dinosaurView1.getFitWidth());//Límite a donde llega el dinosaurio y comienza scroll
    final double dinoDeSobra = dinosaur1.getWidth() / 3;//Imagen que sobra por los laterales cuando gira el dino (habrá que sumar o restar cuando gira)
    final int espacioDisparoBot = (int) (SCENE_WIDTH - botShootDer.getWidth());//espacio entre la orb y la pantalla por la izquierda
       
    int i = 1;//para timeline imagen dinosaur IDLE
    int iBi = 1;//para tmeline imagen Bot IDLE
    int iBr = 1;//para timeline imagen Bot RUN

    short direction = 1; //1 ->der, -1 ->izq, 0 ->pantalla parada
    short directionB = -1;//El bot comienza mirando a la izquierda
    double posicionMomView1 = 0;//Guardará la posición que tenga la pantalla el visor 1
    double posicionMomView2 = 0;//Guardará la posición que tenga la pantalla el visor 2
    boolean viewsInMovement = false;//Detectará cuando se mueve el fondo en vez de el dinosaurio
    int contPasos = 0;//Para que cuente los pasos, que cambie la imagen   
    int contJump = 0;//contador para Timeline2 del salto
    double Xactual = 0;
    double Yactual = 0;
    int healthBot = healthBotInicial;//Vida del Bot
    int direcBall = 1; //la dirección a la que irá la bola (porque la dirección del dinosaurio puede cambiar mientras que la bola está en movimiento
    int score = 0; //guardará los puntos que el dinosaurio obtenga matando monstruos
    int health = 2000; //Un corazón vale 200 puntos (tiene 10)
    int coins = 0; //guardará las monedas que el dinosario vaya cogiendo (hasta tres por pantalla)
    int coinProvisional = 0;//guardará las monedas de 10 en 10
    int deadPasos = 1; //contar pasos en Dead  
    boolean dentroJump = false;//Para detectar si está dentro del salto y que no se pise con otro salto
    boolean rPressed = false;//comprobrar si la derecha está pulsada
    boolean lPressed = false;//comprobrar si la izquierda está pulsada  
    boolean vivo = true; //variable para que el teclado no haga nada si está muerto
    Timeline timelineTHANKS_NAME;
    Timeline timelineLEVEL1;
    Timeline timelineLEVEL2;
    Timeline timelineIdle;
    Timeline timelineBotIdle;
    Timeline timelineJump;
    Timeline timelineRunRight;
    Timeline timelineRunLeft;
    Timeline timelineBotRun;
    Timeline timelineDead;
    Timeline timelineShoot;
    Timeline timelineCoins;
    Timeline timelineBotShooting;
    Timeline timelinePlaying;
    TextInputDialog dialog = new TextInputDialog("Enter your name");
    ImageView backgroundView1;
    ImageView backgroundView2;
    ImageView backgroundViewBot;
    ImageView thanksView;
    ImageView level1View;
    ImageView level2View;
    ImageView winView;
    Group groupD;
    Group groupBot;
    Group groupOrb;
    Circle circleBall;
    Group groupM;
    Group groupMiz;
    Group coin1;
    Group coin2;
    Group coin3;
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
    ImageView coinViewScore;
    ImageView coinView1;
    ImageView coinView2;
    ImageView coinView3;
    Text textHealth;
    HBox paneScores;
    VBox paneContinuar;
    VBox paneThanks;
    VBox paneLevel1;
    VBox paneLevel2;
    VBox paneWin;
    HBox paneGeneralName;
    int posXCoin1 = 0;
    int posYCoin1 = 0;
    int posXCoin2 = 0;
    int posYCoin2 = 0;
    int posXCoin3 = 0;
    int posYCoin3 = 0;
    Rectangle rectDino;
    Circle coinBall1;
    Circle coinBall2;
    Circle coinBall3;
    Text textCoin;
    int nivel = 1;//**********NIVEL
    ImageView botView1;
    Rectangle rectBot;
    ImageView orbView1;
    Circle orbCircle;
    short conBotShoot = 0;//para timeline BOT SHOOTING (si es la primera vuelta)
    short contCambios =0;
    Rectangle rectBackground;
    Text textTitleHealthBot;
    ProgressBar pbBotHealth;
    
    
    @Override
    public void start(Stage stage) {

        //CARGA DE IMÁGENES USANDO UN VECTOR (ARRAY) UNIDIMENSIONAL
        for (int c = 0; c < 10; c++) {
            dinosaurWd[c] = new Image(getClass().getResourceAsStream("/images/Walk (" + (c + 1) + ").png"));
        }
        for (int c = 0; c < 10; c++) {
            dinosaurWi[c] = new Image(getClass().getResourceAsStream("/images/Walkiz (" + (c + 1) + ").png"));
        }
        for (int c = 0; c < 8; c++) {
            dinosaurRd[c] = new Image(getClass().getResourceAsStream("/images/Run (" + (c + 1) + ").png"));
        }
        for (int c = 0; c < 8; c++) {
            dinosaurRi[c] = new Image(getClass().getResourceAsStream("/images/Runiz (" + (c + 1) + ").png"));
        }
        for (int c = 0; c < 15; c++) {
            dinosaurJd[c] = new Image(getClass().getResourceAsStream("/images/Jump (" + (c + 1) + ").png"));
        }
        for (int c = 0; c < 15; c++) {
            dinosaurJi[c] = new Image(getClass().getResourceAsStream("/images/Jumpiz (" + (c + 1) + ").png"));
        }
        for (int c = 0; c < 8; c++) {
            dinosaurDd[c] = new Image(getClass().getResourceAsStream("/images/Dead (" + (c + 1) + ").png"));
        }
        for (int c = 0; c < 8; c++) {
            dinosaurDi[c] = new Image(getClass().getResourceAsStream("/images/Deadiz (" + (c + 1) + ").png"));
        }

        //IMÁGENES DEL BOT
        for (int c = 0; c < 20; c++) {
            botIz[c] = new Image(getClass().getResourceAsStream("/images/bot_idle_iz (" + (c + 1) + ").png"));
        }
        for (int c = 0; c < 20; c++) {
            botDer[c] = new Image(getClass().getResourceAsStream("/images/bot_idle_der (" + (c + 1) + ").png"));
        }
        for (int c = 0; c < 16; c++) {
            botRunIz[c] = new Image(getClass().getResourceAsStream("/images/bot_run_iz (" + (c + 1) + ").png"));
        }
        for (int c = 0; c < 16; c++) {
            botRunDer[c] = new Image(getClass().getResourceAsStream("/images/bot_run_der (" + (c + 1) + ").png"));
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
        Image background1 = new Image(getClass().getResourceAsStream("/images/swamp.png"));//imagen del visor
        backgroundView1 = new ImageView(background1);//Metemos la imagen de fondo en el visor

        backgroundView1.setX(0);//donde vamos a colocar la imagen
        backgroundView1.setY(0);
        backgroundView1.setFitHeight(SCENE_HEIGHT);//hacer que la imagen de fondo se adapte al tamaño de la ventana
        backgroundView1.setFitWidth(SCENE_WIDTH);

        //PONER EL FONDO 2      
        backgroundView2 = new ImageView(background1);//Metemos la imagen de fondo en el visor con misma imagen que el anterior

        backgroundView2.setX(SCENE_WIDTH);//donde vamos a colocar la imagen A CONTINUACION DE LA PRIMERA
        backgroundView2.setY(0);
        backgroundView2.setFitHeight(SCENE_HEIGHT);//hacer que la imagen de fondo se adapte al tamño de la entana
        backgroundView2.setFitWidth(SCENE_WIDTH);

        root.getChildren().add(backgroundView1);
        root.getChildren().add(backgroundView2);

        //PONER FONDO PARA LUCHA CON BOT
        Image background3 = new Image(getClass().getResourceAsStream("/images/Space-Background-9-preview.jpg"));//imagen del visor
        backgroundViewBot = new ImageView(background3);
        backgroundViewBot.setY(0);
        backgroundViewBot.setFitHeight(SCENE_HEIGHT);//hacer que la imagen de fondo se adapte al tamaño de la ventana
        backgroundViewBot.setFitWidth(SCENE_WIDTH);
        backgroundViewBot.setVisible(false);
        
        root.getChildren().add(backgroundViewBot);
           
        
        //PONER EL DINOSAURIO
        //GRUPO IMAGEN DINOSAURIO + RECTANGULO
        groupD = new Group();
        // El dinosaurio mide 170 pixeles (ancho) x 118 pixeles (alto)
        dinosaurView1.setX(0);//posición x del dinosaurio
        dinosaurView1.setY(0);//posición y del dinosaurio
        //PONER RECTÁNGULO DETRÁS DEL DINOSAURIO
        rectDino = new Rectangle();
        //Métodos del objeto RECTÁNGULO
        rectDino.setWidth(dinosaur1.getWidth() / 3);
        rectDino.setHeight(dinosaur1.getHeight() - 35);
        rectDino.setX(0 + (rectDino.getWidth() / 2));
        rectDino.setY(0 + (35 / 2));//posicón del rectángulo a la altura del dinosaurio (-15 porque a la imagen del dinosaurio le sobra un poco por abajo)
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

        root.getChildren().add(circleBall);//Hay que añadir la bola al StackPane(panel llamado root). Los objtos que contiene el panel son los Children.

        //AÑADIR GRUPO DE FORMAS PARA HACER ENEMIGO
        groupM = new Group();
        //RECTÁGULO
        Rectangle rectM = new Rectangle();
        //Métodos del objeto RECTÁNGULO
        rectM.setWidth(dinosaur1.getWidth() / 3);
        rectM.setHeight(rectM.getWidth() + (rectM.getWidth() / 2));
        rectM.setX(0);
        rectM.setY(0);
        rectM.setArcWidth(20);
        rectM.setArcHeight(20);
        rectM.setFill(Color.BLACK);
        rectM.setStroke(Color.RED);//Contorno
        rectM.setStrokeWidth(3);
        //CÍRCULO
        Circle headM = new Circle();
        //Llamamos a MÉTODOS del objeto circleBall
        headM.setRadius((rectM.getWidth() / 2));
        headM.setCenterX(rectM.getX() + headM.getRadius());
        headM.setCenterY(rectM.getY() - (headM.getRadius()));
        headM.setFill(Color.BLACK);
        headM.setStroke(Color.RED);
        headM.setStrokeWidth(3);
        //CÍRCULO OJO DERECHO
        Circle eyeRM = new Circle();
        eyeRM.setRadius(headM.getRadius() / 4);
        eyeRM.setCenterX(headM.getCenterX() - eyeRM.getRadius());
        eyeRM.setCenterY(headM.getCenterY());
        eyeRM.setFill(Color.RED);
        eyeRM.setStroke(Color.BLACK);
        //LÍNEA CEJA DERECHA
        Line browRM = new Line();
        browRM.setStartX(eyeRM.getCenterX() - ((eyeRM.getRadius() * 10) / 10));
        browRM.setStartY(eyeRM.getCenterY() - ((eyeRM.getRadius() * 2) / 10));
        browRM.setEndX(eyeRM.getCenterX() + ((eyeRM.getRadius() * 8) / 10));
        browRM.setEndY(eyeRM.getCenterY() - ((eyeRM.getRadius() * 14) / 10));
        browRM.setStroke(Color.RED);
        browRM.setStrokeWidth(3);

        groupM.getChildren().add(rectM);
        groupM.getChildren().add(headM);
        groupM.getChildren().add(eyeRM);
        groupM.getChildren().add(browRM);

        root.getChildren().add(groupM);

        groupM.setLayoutX(SCENE_WIDTH);
        groupM.setLayoutY(groupD.getLayoutY() + (dinosaur1.getHeight() - (rectM.getHeight() + headM.getRadius())) + 15);//Para que salga a la altura del dinosaurio (le sobra 15 por abajo)

        //AÑADIR GRUPO DE FORMAS PARA HACER ENEMIGO A LA IZQUIERDA
        groupMiz = new Group();
        //RECTÁGULO
        Rectangle rectMiz = new Rectangle();
        //Métodos del objeto RECTÁNGULO
        rectMiz.setWidth(dinosaur1.getWidth() / 3);
        rectMiz.setHeight(rectMiz.getWidth() + (rectMiz.getWidth() / 2));
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
        headMiz.setRadius((rectMiz.getWidth() / 2));
        headMiz.setCenterX(rectMiz.getX() + headMiz.getRadius());
        headMiz.setCenterY(rectMiz.getY() - (headMiz.getRadius()));
        headMiz.setFill(Color.BLACK);
        headMiz.setStroke(Color.RED);
        headMiz.setStrokeWidth(3);
        //CÍRCULO OJO IZQUIERDA
        Circle eyeRMiz = new Circle();
        eyeRMiz.setRadius(headMiz.getRadius() / 4);
        eyeRMiz.setCenterX(headMiz.getCenterX() + eyeRMiz.getRadius());
        eyeRMiz.setCenterY(headMiz.getCenterY());
        eyeRMiz.setFill(Color.RED);
        eyeRMiz.setStroke(Color.BLACK);
        //LÍNEA CEJA IZQUIERDA
        Line browRMiz = new Line();
        browRMiz.setStartX(eyeRMiz.getCenterX() + ((eyeRMiz.getRadius() * 10) / 10));
        browRMiz.setStartY(eyeRMiz.getCenterY() - ((eyeRMiz.getRadius() * 2) / 10));
        browRMiz.setEndX(eyeRMiz.getCenterX() - ((eyeRMiz.getRadius() * 8) / 10));
        browRMiz.setEndY(eyeRMiz.getCenterY() - ((eyeRMiz.getRadius() * 14) / 10));
        browRMiz.setStroke(Color.RED);
        browRMiz.setStrokeWidth(3);

        groupMiz.getChildren().add(rectMiz);
        groupMiz.getChildren().add(headMiz);
        groupMiz.getChildren().add(eyeRMiz);
        groupMiz.getChildren().add(browRMiz);

        root.getChildren().add(groupMiz);

        groupMiz.setLayoutX(-rectMiz.getWidth());
        groupMiz.setLayoutY(groupD.getLayoutY() + (dinosaur1.getHeight() - (rectM.getHeight() + headM.getRadius())) + 15);

        //PONER BOT ENEMIGO        
        groupBot = new Group();
        // El dinosaurio mide 170 pixeles (ancho) x 118 pixeles (alto)
        botView1 = new ImageView(botIz[0]);
        groupBot.setLayoutX(-200);
        groupBot.setLayoutY(dinosaurioY - (botIz[0].getHeight() - dinosaur1.getHeight()));

        rectBot = new Rectangle();
        //Métodos del objeto RECTÁNGULO
        rectBot.setWidth(botIz[0].getWidth());
        rectBot.setHeight(botIz[0].getHeight());
        rectBot.setX(0);
        rectBot.setY(0);//posicion 0 dentro del grupo
        rectBot.setArcWidth(20);
        rectBot.setArcHeight(20);
        rectBot.setVisible(false);

        groupBot.getChildren().add(botView1);
        groupBot.getChildren().add(rectBot);
        root.getChildren().add(groupBot);

        //GRUPO PARA LA ORB DEL BOT
        groupOrb = new Group();
        orbView1 = new ImageView(orb);

        orbCircle = new Circle();
        orbCircle.setRadius(20);
        double difCirOrb = (orb.getWidth() - 5) - (orbCircle.getRadius() * 2);
        orbCircle.setFill(Color.RED);
        orbCircle.setCenterX(groupOrb.getLayoutX() + (orbCircle.getRadius() + difCirOrb));
        orbCircle.setCenterY(groupOrb.getLayoutY() + (orbCircle.getRadius() + difCirOrb));
        orbCircle.setVisible(false);
        groupOrb.setLayoutX(-300);
        groupOrb.setLayoutY(groupBot.getLayoutY() + (botShootDer.getHeight() / 2));

        groupOrb.getChildren().add(orbView1);
        groupOrb.getChildren().add(orbCircle);
        root.getChildren().add(groupOrb);

        /////LAYOUTS PARA MOSTRAR PUNTUACIONES/////
        //*****************************************
        //Layout principal
        paneScores = new HBox();
        paneScores.setTranslateY(20);
        paneScores.setMinWidth(SCENE_WIDTH);//ocupará el ancho de la pantalla con fondo azul
        paneScores.setMinHeight(60);
        paneScores.setAlignment(Pos.CENTER);
        paneScores.setSpacing(40);//espacio entre celda y celda
        paneScores.setStyle("-fx-background-color: #336699;");

        root.getChildren().add(paneScores);

        //Layout para las monedas
        HBox paneCoin = new HBox();
        paneCoin.setSpacing(10);
        paneCoin.setTranslateY(15);
        paneScores.getChildren().add(paneCoin);

        //Layout para puntuación actual
        HBox paneCurrentScore = new HBox();
        paneCurrentScore.setSpacing(10);
        paneCurrentScore.setTranslateY(15);
        paneScores.getChildren().add(paneCurrentScore);

        //Layout para la vida
        HBox paneLife = new HBox();
        paneLife.setSpacing(10);
        paneLife.setTranslateY(15);
        paneScores.getChildren().add(paneLife);

        //Layout para corazones
        HBox paneHearts = new HBox();
        paneHearts.setSpacing(10);
        paneHearts.setTranslateY(15);
        paneScores.getChildren().add(paneHearts);

        //Dibujo de la moneda
        coinViewScore = new ImageView(coinImage);//moneda que aparece al lado de la puntuación
        //Texto de etiqueta para las monedas
        textCoin = new Text(String.valueOf(coins));
        textCoin.setFont(Font.font("Arial Black", TEXT_SIZE));
        textCoin.setFill(Color.YELLOW);

        //Texto de etiqueta para la puntuación
        Text textTitleScore = new Text("Score:");
        textTitleScore.setFont(Font.font("Arial Black", TEXT_SIZE));
        textTitleScore.setFill(Color.YELLOW);
        //Texto para la puntuación
        Text textScore = new Text(String.valueOf(score));
        textScore.setFont(Font.font("Arial Black", TEXT_SIZE));
        textScore.setFill(Color.YELLOW);

        //Texto de etiqueta para la vida
        Text textTitleHealth = new Text("Health:");
        textTitleHealth.setFont(Font.font("Arial Black", TEXT_SIZE));
        textTitleHealth.setFill(Color.YELLOW);
        //Texto para la puntuación máxima
        textHealth = new Text(String.valueOf(health));
        textHealth.setFont(Font.font("Arial Black", TEXT_SIZE));
        textHealth.setFill(Color.YELLOW);

        //PONER LOS CORAZONES
        //*********************
        heartView1 = new ImageView(heartImage); // El corazón mide 31 * 31 pixeles
        heartView1.setX(SCENE_WIDTH - (SCENE_WIDTH / 3));//donde vamos a colocar la imagen A CONTINUACION DE LA PRIMERA
        heartView1.setY(40);

        heartView2 = new ImageView(heartImage); // El corazón mide 31 * 31 pixeles
        heartView2.setX(SCENE_WIDTH - ((SCENE_WIDTH / 3) - 31));//donde vamos a colocar la imagen A CONTINUACION DE LA PRIMERA
        heartView2.setY(40);

        heartView3 = new ImageView(heartImage); // El corazón mide 31 * 31 pixeles
        heartView3.setX(SCENE_WIDTH - ((SCENE_WIDTH / 3) - (31 + 31)));//donde vamos a colocar la imagen A CONTINUACION DE LA PRIMERA
        heartView3.setY(40);

        heartView4 = new ImageView(heartImage); // El corazón mide 31 * 31 pixeles
        heartView4.setX(SCENE_WIDTH - ((SCENE_WIDTH / 3) - (31 + 31 + 31)));//donde vamos a colocar la imagen A CONTINUACION DE LA PRIMERA
        heartView4.setY(40);

        heartView5 = new ImageView(heartImage); // El corazón mide 31 * 31 pixeles
        heartView5.setX(SCENE_WIDTH - ((SCENE_WIDTH / 3) - (31 + 31 + 31 + 31)));//donde vamos a colocar la imagen A CONTINUACION DE LA PRIMERA
        heartView5.setY(40);

        heartView6 = new ImageView(heartImage); // El corazón mide 31 * 31 pixeles
        heartView6.setX(SCENE_WIDTH - ((SCENE_WIDTH / 3) - (31 + 31 + 31 + 31 + 31)));//donde vamos a colocar la imagen A CONTINUACION DE LA PRIMERA
        heartView6.setY(40);

        heartView7 = new ImageView(heartImage); // El corazón mide 31 * 31 pixeles
        heartView7.setX(SCENE_WIDTH - ((SCENE_WIDTH / 3) - (31 + 31 + 31 + 31 + 31 + 31)));//donde vamos a colocar la imagen A CONTINUACION DE LA PRIMERA
        heartView7.setY(40);

        heartView8 = new ImageView(heartImage); // El corazón mide 31 * 31 pixeles
        heartView8.setX(SCENE_WIDTH - ((SCENE_WIDTH / 3) - (31 + 31 + 31 + 31 + 31 + 31 + 31)));//donde vamos a colocar la imagen A CONTINUACION DE LA PRIMERA
        heartView8.setY(40);

        heartView9 = new ImageView(heartImage); // El corazón mide 31 * 31 pixeles
        heartView9.setX(SCENE_WIDTH - ((SCENE_WIDTH / 3) - (31 + 31 + 31 + 31 + 31 + 31 + 31 + 31)));//donde vamos a colocar la imagen A CONTINUACION DE LA PRIMERA
        heartView9.setY(40);

        heartView10 = new ImageView(heartImage); // El corazón mide 31 * 31 pixeles
        heartView10.setX(SCENE_WIDTH - ((SCENE_WIDTH / 3) - (31 + 31 + 31 + 31 + 31 + 31 + 31 + 31 + 31)));//donde vamos a colocar la imagen A CONTINUACION DE LA PRIMERA
        heartView10.setY(40);

        //Añadir los textos e imágenes a los layouts reservados para ellos
        //********************************************************************
        paneCoin.getChildren().add(coinViewScore);//añado la moneda al primer panel (HBox)
        paneCoin.getChildren().add(textCoin);//añado el texto de la moneda al primer panel (HBox)
        paneCurrentScore.getChildren().add(textTitleScore);//añado el título de la puntuación al segundo panel (HBox)
        paneCurrentScore.getChildren().add(textScore);//añado la puntuación al segundo panel  (HBox)
        paneLife.getChildren().add(textTitleHealth);//añado el título de la vida al tercer panel (HBox)
        paneLife.getChildren().add(textHealth);//añado la vida al tercer panel (HBox)   
        paneHearts.getChildren().add(heartView1);
        paneHearts.getChildren().add(heartView2);
        paneHearts.getChildren().add(heartView3);
        paneHearts.getChildren().add(heartView4);
        paneHearts.getChildren().add(heartView5);
        paneHearts.getChildren().add(heartView6);
        paneHearts.getChildren().add(heartView7);
        paneHearts.getChildren().add(heartView8);
        paneHearts.getChildren().add(heartView9);
        paneHearts.getChildren().add(heartView10);

        //PONER LAS 3 MONEDAS QUE SALDRÁN ALEATORIAS
        //******************************************
        //GRUPO IMÁGENES DE MONEDAS + CÍRCULO
        //--------MONEDA 1
        coin1 = new Group();
        coinView1 = new ImageView(coinImage);//Tres monedas que aparecerán aleatoriamente

        coinBall1 = new Circle(); //Creamos una variable llamada circleBall(nuevo objeto -> new) de tipo Círculo(clase Círculo)
        //Llamamos a MÉTODOS del objeto coinBall
        coinBall1.setCenterX(coinView1.getX() + (coinImage.getWidth() / 2));
        coinBall1.setCenterY(coinView1.getY() + (coinImage.getHeight() / 2));
        coinBall1.setRadius(coinImage.getWidth() / 2);//El radio es la mitad de lo que mide la imagen
        coinBall1.setFill(Color.BLACK);

        coin1.getChildren().add(coinBall1);
        coin1.getChildren().add(coinView1);
        coin1.setLayoutX(0);
        coin1.setLayoutY(0);
        root.getChildren().add(coin1);
        coin1.setVisible(false);

        //--------MONEDA 2
        coin2 = new Group();
        coinView2 = new ImageView(coinImage);//Tres monedas que aparecerán aleatoriamente

        coinBall2 = new Circle(); //Creamos una variable llamada circleBall(nuevo objeto -> new) de tipo Círculo(clase Círculo)
        //Llamamos a MÉTODOS del objeto coinBall
        coinBall2.setCenterX(coinView2.getX() + (coinImage.getWidth() / 2));
        coinBall2.setCenterY(coinView2.getY() + (coinImage.getHeight() / 2));
        coinBall2.setRadius(coinImage.getWidth() / 2);//El radio es la mitad de lo que mide la imagen
        coinBall2.setFill(Color.BLACK);

        coin2.getChildren().add(coinBall2);
        coin2.getChildren().add(coinView2);
        coin2.setLayoutX(0);
        coin2.setLayoutY(0);
        root.getChildren().add(coin2);
        coin2.setVisible(false);

        //--------MONEDA 3
        coin3 = new Group();
        coinView3 = new ImageView(coinImage);//Tres monedas que aparecerán aleatoriamente

        coinBall3 = new Circle(); //Creamos una variable llamada circleBall(nuevo objeto -> new) de tipo Círculo(clase Círculo)
        //Llamamos a MÉTODOS del objeto coinBall
        coinBall3.setCenterX(coinView3.getX() + (coinImage.getWidth() / 2));
        coinBall3.setCenterY(coinView3.getY() + (coinImage.getHeight() / 2));
        coinBall3.setRadius(coinImage.getWidth() / 2);//El radio es la mitad de lo que mide la imagen
        coinBall3.setFill(Color.BLACK);

        coin3.getChildren().add(coinBall3);
        coin3.getChildren().add(coinView3);
        coin3.setLayoutX(0);
        coin3.setLayoutY(0);
        root.getChildren().add(coin3);
        coin3.setVisible(false);        
        
        //Layout principal PARA NOMBRE
        paneGeneralName = new HBox();
        paneGeneralName.setTranslateY(80);
        paneGeneralName.setTranslateX(100);
        paneGeneralName.setMinWidth(SCENE_WIDTH);
        paneGeneralName.setAlignment(Pos.CENTER_LEFT);
        paneGeneralName.setSpacing(40);
        root.getChildren().add(paneGeneralName);
        //Layout para NOMBRE
        HBox paneName = new HBox();
        paneName.setSpacing(10);
        //Layout para NOMBRE BOT
        textTitleHealthBot = new Text("BOT:");
        textTitleHealthBot.setFont(Font.font("Eras Bold ITC", TEXT_SIZE + 10));
        textTitleHealthBot.setFill(Color.RED);
        textTitleHealthBot.setVisible(false);
        //PROGRESS BAR PARA VIDA BOT
        pbBotHealth = new ProgressBar();
        //El progreso de la barra es un doble. Si vamos dividiendo la vida actual con la que tenía al principio sale el formato necesario (0.5)-->50%,(1.0)-->100%,...
        pbBotHealth.setProgress((double)healthBot/healthBotInicial);
        pbBotHealth.setPrefSize(300.0, 20.0);
        pbBotHealth.setVisible(false);
        
        paneGeneralName.getChildren().add(paneName);
        paneGeneralName.getChildren().add(textTitleHealthBot);
        paneGeneralName.getChildren().add(pbBotHealth);
        
                     
        //AÑADIR UN PANEL PAR MOSTRAR IMAGENES DE THANKS
        paneThanks = new VBox();              
        //PONER VISOR THANKS TO
        Image imageThanks =new Image(getClass().getResourceAsStream("/images/THANKS.png"));//imagen del visor
        thanksView = new ImageView(imageThanks);
        thanksView.setY(0);
        thanksView.setFitHeight(SCENE_HEIGHT);//hacer que la imagen de fondo se adapte al tamaño de la ventana
        thanksView.setFitWidth(SCENE_WIDTH);
        thanksView.setVisible(true);
        paneThanks.getChildren().add(thanksView);        
        
        //AÑADIR UN PANEL PAR MOSTRAR IMAGENES DE LEVEL1
        paneLevel1 = new VBox();        
        //PONER VISOR PARA LEVEL 1
        Image imageLevel1 = new Image(getClass().getResourceAsStream("/images/LEVEL1.png"));//imagen del visor
        level1View = new ImageView(imageLevel1);
        level1View.setY(0);
        level1View.setFitHeight(SCENE_HEIGHT);//hacer que la imagen de fondo se adapte al tamaño de la ventana
        level1View.setFitWidth(SCENE_WIDTH);
        level1View.setVisible(false);
        paneLevel1.getChildren().add(level1View); 
        
        //AÑADIR UN PANEL PAR MOSTRAR IMAGENES DE LEVEL2
        paneLevel2 = new VBox();       
        //PONER VISOR PARA LEVEL 2
        Image imageLevel2 = new Image(getClass().getResourceAsStream("/images/LEVEL2.png"));//imagen del visor
        level2View = new ImageView(imageLevel2);
        level2View.setY(0);
        level2View.setFitHeight(SCENE_HEIGHT);//hacer que la imagen de fondo se adapte al tamaño de la ventana
        level2View.setFitWidth(SCENE_WIDTH);
        level2View.setVisible(false);
        paneLevel2.getChildren().add(level2View);  
        
        //AÑADIR UN PANEL PAR MOSTRAR IMAGENES DE WIN
        paneWin = new VBox();        
        //PONER VISOR PARA YOU WIN
        Image imageWin = new Image(getClass().getResourceAsStream("/images/YOU_WIN.png"));//imagen del visor
        winView = new ImageView(imageWin);
        winView.setY(0);
        winView.setFitHeight(SCENE_HEIGHT);//hacer que la imagen de fondo se adapte al tamaño de la ventana
        winView.setFitWidth(SCENE_WIDTH);
        winView.setVisible(false);
        paneWin.getChildren().add(winView); 
         
        root.getChildren().add(paneThanks);        
        root.getChildren().add(paneLevel1);
        root.getChildren().add(paneLevel2);        
        root.getChildren().add(paneWin);       
        
        
        //PONER RECTÁNGULO NEGRO PARA QUE SALGA DERÁ DEL DIÁLOGO
        rectBackground = new Rectangle();
        rectBackground.setWidth(SCENE_WIDTH);
        rectBackground.setHeight(SCENE_HEIGHT);
        rectBackground.setX(0);
        rectBackground.setY(0);//posicion 0 dentro del grupo
        rectBackground.setVisible(true);
        root.getChildren().add(rectBackground);       
        
        //DIÁLOGO PARA PEDIR NOMBRE
        dialog.setTitle("Name");
        //dialog.setHeaderText("Enter your name:");
        dialog.headerTextProperty().setValue(null);//PARA QUITAR EL HEADER QUE APARECE POR DEFECTO
        dialog.setContentText("Name:");
        dialog.showAndWait();
        String nameDino = dialog.getResult();
        Text nombre = new Text(nameDino);
        nombre.setFont(Font.font("Eras Bold ITC", TEXT_SIZE + 10));
        nombre.setFill(Color.BLUE);
        paneName.getChildren().add(nombre);

      
        //Layout principal para VBOX (MENSAJE CONTINUAR)
        //**********************
        paneContinuar = new VBox();
        paneContinuar.setTranslateY(100);
        paneContinuar.setMinWidth(SCENE_WIDTH / 2);
        paneContinuar.setTranslateX((SCENE_WIDTH - (SCENE_WIDTH / 2)) / 2);
        paneContinuar.setMinHeight(SCENE_HEIGHT / 2);
        paneContinuar.setAlignment(Pos.CENTER);
        paneContinuar.setSpacing(100);
        paneContinuar.setStyle("-fx-background-color: #336699;");
        root.getChildren().add(paneContinuar);
        //Texto de etiqueta para la continuar
        Text textTitleCon = new Text("¿Do you want to continue?");
        textTitleCon.setFont(Font.font("Arial Black", TEXT_SIZE));
        textTitleCon.setFill(Color.BLACK);
        paneContinuar.getChildren().add(textTitleCon);
 
        
        //AÑADIR LOS DOS BOTONES HORIZONTALES EN UN HBOX(DENTRO DEL VBOX)
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

      
        //TODOS LOS TIMELINE EMPIEZAN PARADOS. SE VAN ACTIVANDO SEGÚN SE JUEGA        
        
        //ALERTA DIÁLOGO PARA SEGUIR JUGANDO UNA VEZ QUE MUERE ---https://code.makery.ch/blog/javafx-dialogs-official/
////**********************************************************************************************************************************************


       //TIMELINE -THANKS AND NAME DIALOG
        // Game loop usando Timeline
        timelineTHANKS_NAME = new Timeline(//Sirve para lo que lo que metamos aquí. Podemos utilizar varios TimeLine con diferentes velocidades para diferentes cosas
                // 0.017 ~= 60 FPS (equivalencia de segundos a Frames por Segundo)
                new KeyFrame(Duration.seconds(0.8), new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent ae) {//Sólo puede haber un handle en el timeline
                     
                        rectBackground.setVisible(false);                        
                        contCambios++;
                        if(contCambios==10){
                            thanksView.setVisible(false);
                            level1View.setVisible(true);
                            contCambios=0;
                            timelineLEVEL1.play();
                        }                        
                    }
                })
        );
        timelineTHANKS_NAME.setCycleCount(10);//Llama al método setCycleCount (para que la animación siga indefinidamente
        timelineTHANKS_NAME.play();


       //TIMELINE -LEVEL1
        // Game loop usando Timeline
        timelineLEVEL1 = new Timeline(//Sirve para lo que lo que metamos aquí. Podemos utilizar varios TimeLine con diferentes velocidades para diferentes cosas
                // 0.017 ~= 60 FPS (equivalencia de segundos a Frames por Segundo)
                new KeyFrame(Duration.seconds(0.4), new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent ae) {//Sólo puede haber un handle en el timeline
                     
                        contCambios++;
                        if(contCambios==10){
                            level1View.setVisible(false);
                            contCambios=0;
                            timelineIdle.play();
                            timelineCoins.play();
                            timelinePlaying.play();
                            System.out.println("NIVEL 1");
                        }                       
                    }
                })
        );
        timelineLEVEL1.setCycleCount(10);//Llama al método setCycleCount (para que la animación siga indefinidamente
        
        
       //TIMELINE -LEVEL2
        // Game loop usando Timeline
        timelineLEVEL2 = new Timeline(//Sirve para lo que lo que metamos aquí. Podemos utilizar varios TimeLine con diferentes velocidades para diferentes cosas
                // 0.017 ~= 60 FPS (equivalencia de segundos a Frames por Segundo)
                new KeyFrame(Duration.seconds(0.4), new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent ae) {//Sólo puede haber un handle en el timeline
                     
                        contCambios++;
                        if(contCambios==10){
                            level2View.setVisible(false);
                            contCambios=0;
                            timelineIdle.play();
                            timelineCoins.play();
                            timelinePlaying.play();
                            timelineBotIdle.play();
                        }                       
                    }
                })
        );
        timelineLEVEL2.setCycleCount(10);//Llama al método setCycleCount (para que la animación siga indefinidamente


        //TIMELINE -IDLE
        // Game loop usando Timeline
        timelineIdle = new Timeline(//Sirve para lo que lo que metamos aquí. Podemos utilizar varios TimeLine con diferentes velocidades para diferentes cosas
                // 0.017 ~= 60 FPS (equivalencia de segundos a Frames por Segundo)
                new KeyFrame(Duration.seconds(0.08), new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent ae) {//Sólo puede haber un handle en el timeline
                        if (vivo) {
                            //SWITCH PARA QUE LAS IMÀGENES DEL DINOSAURIO CAMBIEN
                            if (direction == 1) {
                                switch (i) {
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
                            } else if (direction == -1) {
                                switch (i) {
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
                    }
                })
        );
        timelineIdle.setCycleCount(Timeline.INDEFINITE);//Llama al método setCycleCount (para que la animación siga indefinidamente
        //timelineIdle.play(); //Llama al método Play para echar a andar la animación

        //TIMELINE -BOT IDLE
        // Game loop usando Timeline
        timelineBotIdle = new Timeline(//Sirve para lo que lo que metamos aquí. Podemos utilizar varios TimeLine con diferentes velocidades para diferentes cosas
                // 0.017 ~= 60 FPS (equivalencia de segundos a Frames por Segundo)
                new KeyFrame(Duration.seconds(0.09), new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent ae) {//Sólo puede haber un handle en el timeline

                        //PARA QUE LAS IMÀGENES DEL BOT CAMBIEN
                        if (directionB == 1) {
                            botView1.setImage(botDer[iBi]);//meter la imagen del Bot en view                                                                  
                        } else if (directionB == -1) {
                            botView1.setImage(botIz[iBi]);//meter la imagen del Bot en view                                                                                              
                        }

                        iBi++;
                        if (iBi == 20) {
                            iBi = 1;
                        }
                    }
                })
        );
        timelineBotIdle.setCycleCount(Timeline.INDEFINITE);//Llama al método setCycleCount (para que la animación siga indefinidamente

        //TIMELINE -BOT RUN
        // Game loop usando Timeline
        timelineBotRun = new Timeline(//Sirve para lo que lo que metamos aquí. Podemos utilizar varios TimeLine con diferentes velocidades para diferentes cosas
                // 0.017 ~= 60 FPS (equivalencia de segundos a Frames por Segundo)
                new KeyFrame(Duration.seconds(0.09), new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent ae) {//Sólo puede haber un handle en el timeline

                        //PARA QUE LAS IMÀGENES DEL BOT CAMBIEN
                        if (directionB == 1) {
                            botView1.setImage(botRunDer[iBr]);//meter la imagen del Bot en view                                                                  
                        } else if (directionB == -1) {
                            botView1.setImage(botRunIz[iBr]);//meter la imagen del Bot en view                                                                                              
                        }

                        iBr++;
                        if (iBr == 16) {
                            iBr = 1;
                        }
                    }
                })
        );
        timelineBotRun.setCycleCount(Timeline.INDEFINITE);//Llama al método setCycleCount (para que la animación siga indefinidamente        

        //TIMELINE -JUMP
        // Game loop usando Timeline
        timelineJump = new Timeline(//Sirve para lo que lo que metamos aquí. Podemos utilizar varios TimeLine con diferentes velocidades para diferentes cosas
                // 0.017 ~= 60 FPS (equivalencia de segundos a Frames por Segundo)
                new KeyFrame(Duration.seconds(0.08), new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent ae) {//Sólo puede haber un handle en el timeline
                        
                        dentroJump = true;

                        Xactual = groupD.getLayoutX();
                        Yactual = groupD.getLayoutY();

                        //************************** 280/7=40 -----280 diferencia desde la altura la posición inicial del dino (540) hasta la y más alta en el salto (260)
                        if (contJump < 15) {
                            if (direction == -1) {//salto a la izq

                                if (contJump < 7) { //El salto va hacia arriba (primera parte)                                   
                                    groupD.setLayoutY(Yactual - 40);
                                } else { //Cuando llega a la mitad el salto va hacia abajo
                                    groupD.setLayoutY(Yactual + 40);
                                }
                                dinosaurView1.setImage(dinosaurJi[contJump]);
                                // para que no pase del lado izquierdo (como la imagen es larga tiene que salir un poco por la izquierda
                                if (groupD.getLayoutX() > (dinoDeSobra * -1)) {
                                    groupD.setLayoutX(Xactual - 20);
                                }

                            } else {//salto a la der
                                if (contJump < 7) { //El salto va hacia arriba (primera parte)
                                    groupD.setLayoutY(Yactual - 40);
                                } else { //Cuando llega a la mitad el salto va hacia abajo
                                    groupD.setLayoutY(Yactual + 40);
                                }
                                dinosaurView1.setImage(dinosaurJd[contJump]);
                                groupD.setLayoutX(Xactual + 20);
                                //Si pasa del límite de la mitad de la pantalla, el dinosaurio se moverá a la izquierda hasta llegar al límite
                                if (groupD.getLayoutX() > limite) {                                  
                                    groupD.setLayoutX(limite);
                                    posicionMomView1 -= 10;
                                    posicionMomView2 -= 10;
                                    if (nivel != 2) {
                                        if (posicionMomView2 > 0) { //Si la posición del visor de fondo 2 es mayor de 0, quiere decir que el fondo no se sale de la pantalla
                                            backgroundView1.setX(posicionMomView1);
                                            backgroundView2.setX(posicionMomView2);
                                        } else { //Si la posición del visor de fondo 2 es menor de 0 quiere decir que volvemos a poner los dos visores de fondo en sus posiciones iniciales para volver a empezar
                                            backgroundView1.setX(0);
                                            backgroundView2.setX(SCENE_WIDTH);
                                        }
                                    }
                                }

                            }
                        }

                        //SOLO PARA BOT EN EL SALTO. Para que cambie dirección si lo salta                  
                        if (groupBot.getLayoutX() > groupD.getLayoutX()) {
                            directionB = -1;
                        } else {
                            directionB = 1;
                        }

                        contJump++;
                        
                        if (contJump == 14) {//Cuando el TIMELINE del JUMP llegue a 14 vuevo a activar el TIMELNE del IDLE
                            dentroJump = false;
                            timelineIdle.play(); //Una vez que termine la animación del salto vuelvo a activar el IDLE
                            if (rPressed) {//si la flecha a la derecha está pulsada cuando termine el salto seguirá corriendo
                                timelineRunRight.play();
                            } else if (lPressed) {//si la flecha a la izquierda está pulsada cuando termine el salto seguirá corriendo
                                timelineRunLeft.play();
                            }                                
                        }
                        choquemonedas();

                    }
                })
        );
        timelineJump.setCycleCount(14);//Llama al método setCycleCount (para que la animación HAGA 14 VUELTAS)
        //No tiene play porque empieza parado y lo arranco cuando me haga falta

        //TIMELINE - DEAD
        // Game loop usando Timeline
        timelineDead = new Timeline(//Sirve para lo que lo que metamos aquí. Podemos utilizar varios TimeLine con diferentes velocidades para diferentes cosas
                // 0.017 ~= 60 FPS (equivalencia de segundos a Frames por Segundo)
                new KeyFrame(Duration.seconds(0.1), new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent ae) {//Sólo puede haber un handle en el timeline

                        groupM.setLayoutX(SCENE_WIDTH);
                        groupMiz.setLayoutX(-rectMiz.getWidth());

                        if (direction == -1) {
                            dinosaurView1.setImage(dinosaurDi[deadPasos]);
                        } else {
                            dinosaurView1.setImage(dinosaurDd[deadPasos]);
                        }
                        deadPasos++;

                        if (deadPasos == 8) {
                            System.out.println("CONTINUAR");
                            //Mostrar VBox
                            panelInvisible();
                            botonYes.setOnAction((ActionEvent e) -> {//SI PULSAMOS EL BOTÓN SÍ
                                nivel = 1;
                                backgroundViewBot.setVisible(false);
                                timelineBotIdle.stop();
                                timelineBotRun.stop();
                                continuar();
                                score = 0;
                                coins=0;
                                panelVisible();//muetro el panel principal
                                pbBotHealth.setProgress((double)healthBot/healthBotInicial);
                                textTitleHealthBot.setVisible(false);
                                pbBotHealth.setVisible(false);
                                textHealth.setText(String.valueOf(health));
                                textScore.setText(String.valueOf(score));
                                textCoin.setText(String.valueOf(coins));
                                groupD.setLayoutX(limite);
                                groupD.setLayoutY(dinosaurioY);
                                timelineDead.stop();
                                timelineCoins.play();
                                timelineShoot.play();
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
        //No tiene play porque empieza parado y lo arranco cuando me haga falta

        //TIMELINE - RUN RIGHT
        // Game loop usando Timeline
        timelineRunRight = new Timeline(//Sirve para lo que lo que metamos aquí. Podemos utilizar varios TimeLine con diferentes velocidades para diferentes cosas
                // 0.017 ~= 60 FPS (equivalencia de segundos a Frames por Segundo)
                new KeyFrame(Duration.seconds(0.08), new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent ae) {//Sólo puede haber un handle en el timeline

                        posicionMomView1 = backgroundView1.getX(); // Cuando pulsemos una tecla leeremos la posición actual del visor del fondo 1 y después moveremos la imagen
                        posicionMomView2 = backgroundView2.getX(); // Cuando pulsemos una tecla leeremos la posición actual del visor del fondo 2 y después moveremos la imagen

                        if (direction == -1) {//Si el dinosaurio estba mirando a la izquierda antes de pulsar la flecha a la derecha cambiaremos el sentido a la derecha
                            groupD.setLayoutX(groupD.getLayoutX() + dinoDeSobra);//al girar el dinosaurio hay que quitarle la parte que le sobra a la imagen
                            rectDino.setX(dinosaurView1.getX() + (dinoDeSobra - 15));//posicionamos el rectángulo detrás del dinosaurio
                            direction = 1; //sentido en el que corre a la derecha
                        }
                        direction = 1;//pantalla a la derecha
                        i = 1;//cambiar contador imagen IDLE
                        posicionMomView1 -= 10;//posiciones qu se moverán los visores
                        posicionMomView2 -= 10;
                        //Si la x del dinosaurio pasa del límite por la derecha, moveremos sólo los dos visores de fondo
                        if (groupD.getLayoutX() > limite) {
                            if (nivel != 2) {
                                viewsInMovement = true;//se moverá el fondo en lugar del dinosaurio
                                if (posicionMomView2 > 0) { //Si la posición del visor de fondo 2 es mayor de 0, quiere decir que el fondo no se sale de la pantalla
                                    backgroundView1.setX(posicionMomView1);
                                    backgroundView2.setX(posicionMomView2);
                                } else { //Si la posición del visor de fondo 2 es menor de 0 quiere decir que volvemos a poner los dos visores de fondo en sus posiciones iniciales para volver a empezar
                                    backgroundView1.setX(0);
                                    backgroundView2.setX(SCENE_WIDTH);
                                }
                            }
                            if (contPasos >= (7)) {//Cuando muestra las 8 imágenes de correr se vuelve a poner a 0
                                contPasos = 0;
                            } else {//si no ha llegado a las 8 imágenes, se incrementa
                                contPasos++;
                            }
                            dinosaurView1.setImage(dinosaurRd[(contPasos)]);  //muestra la imagendel dinosaurio corriendo que toca                          
                        } else { //Si la x del dinosaurio no pasa del límite por la derecha moveremos el dinosaurio
                            if (contPasos >= (7)) {//Cuando muestra las 8 imágenes de correr se vuelve a poner a 0
                                contPasos = 0;
                            } else {//si no ha llegado a las 8 imágenes, se incrementa
                                contPasos++;
                            }
                            groupD.setLayoutX(groupD.getLayoutX() + 10);
                            dinosaurView1.setImage(dinosaurRd[(contPasos)]);
                        }
                        choquemonedas();
                    }
                })
        );
        timelineRunRight.setCycleCount(Timeline.INDEFINITE);//Llama al método setCycleCount (para que la animación HAGA 14 VUELTAS)
        //No tiene play porque empieza parado y lo arranco cuando me haga falta

        //TIMELINE - RUN LEFT
        // Game loop usando Timeline       
        timelineRunLeft = new Timeline(//Sirve para lo que lo que metamos aquí. Podemos utilizar varios TimeLine con diferentes velocidades para diferentes cosas
                // 0.017 ~= 60 FPS (equivalencia de segundos a Frames por Segundo)
                new KeyFrame(Duration.seconds(0.08), new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent ae) {//Sólo puede haber un handle en el timeline        
                        if (direction == 1) {
                            //dinosaurView1.setX(dinosaurView1.getX()-dinoDeSobra);
                            groupD.setLayoutX(groupD.getLayoutX() - dinoDeSobra);
                            rectDino.setX((dinosaurView1.getX() + (dinoDeSobra + 15)));
                            direction = -1; //pantalla a la izquierda
                        }
                        i = 11;//cambair contador imagen IDLE izquierda
                        // para que no pase del lado izquierdo (como la imagen es larga tiene que salir un poco por la izquierda
                        if (groupD.getLayoutX() > (dinoDeSobra * -1)) {
                            if (contPasos >= (7)) {//Cuando muestra las 8 imágenes de correr se vuelve a poner a 0
                                contPasos = 0;
                            } else {//si no ha llegado a las 8 imágenes, se incrementa
                                contPasos++;
                            }
                            groupD.setLayoutX(groupD.getLayoutX() - 10);
                            dinosaurView1.setImage(dinosaurRi[(contPasos)]);
                        }
                        choquemonedas();
                    }
                })
        );
        timelineRunLeft.setCycleCount(Timeline.INDEFINITE);//Llama al método setCycleCount (para que la animación HAGA 14 VUELTAS)                            
        //No tiene play porque empieza parado y lo arranco cuando me haga falta

        //TIMELINE -SHOOT
        // Game loop usando Timeline
        timelineShoot = new Timeline(//Sirve para lo que lo que metamos aquí. Podemos utilizar varios TimeLine con diferentes velocidades para diferentes cosas
                // 0.017 ~= 60 FPS (equivalencia de segundos a Frames por Segundo)
                new KeyFrame(Duration.seconds(0.08), new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent ae) {//Sólo puede haber un handle en el timeline
                        //LA BOLA SALDRÁ DE LA PANTALLA Y SI CHOCA CON UN ENEMIGO DESAPARECE
                        //timelineIdle.play();

                        if (direcBall == -1) {//Si la bola tiene que ir a la izquierda
                            if (nivel == 1) {
                                circleBall.setCenterX(circleBall.getCenterX() - 15);
                            } else if (nivel == 2) {
                                circleBall.setCenterX(circleBall.getCenterX() - 20);
                            }
                        } else if (direcBall == 1) {//si la bola tiene que ir a la derecha
                            if (nivel == 1) {
                                circleBall.setCenterX(circleBall.getCenterX() + 15);
                            } else if (nivel == 2) {
                                circleBall.setCenterX(circleBall.getCenterX() + 20);
                            }
                        }

                        if (nivel == 1) {
                            circleBall.setRadius(10);
                            Shape circleBallrectM = Shape.intersect(circleBall, rectM);//Creamos una variable de la clase Shape para guardar la intersección
                            boolean colisionVaciaM = circleBallrectM.getBoundsInLocal().isEmpty();
                            if (!colisionVaciaM) {//LA BOLA DEL DINOSAURIO LE HA DADO AL MONSTRUO Y EL MONSTRUO DERECHO DESAPARECE
                                groupM.setLayoutX(SCENE_WIDTH);//si choca el monstruo vuelve a la salida
                                circleBall.setCenterX(-300);//si choca la bola vuelve a posicionarse fuera de la pantalla
                                direcBall = 0;
                                score += 20;
                                textScore.setText(String.valueOf(score));
                            }
                            Shape circleBallrectMiz = Shape.intersect(circleBall, rectMiz);//Creamos una variable de la clase Shape para guardar la intersección
                            boolean colisionVaciaMiz = circleBallrectMiz.getBoundsInLocal().isEmpty();
                            if (!colisionVaciaMiz) {//LA BOLA DEL DINOSAURIO LE HA DADO AL MONSTRUO Y EL MONSTRUO IZQUIERDO DESAPARECE
                                groupMiz.setLayoutX(-rectMiz.getWidth());//si choca el monstruo vuelve a la salida
                                circleBall.setCenterX(-300);//si choca la bola vuelve a posicionarse fuera de la pantalla
                                direcBall = 0;
                                score += 20;
                                textScore.setText(String.valueOf(score));
                            }
                            if (score == 200) {
                                System.out.println("NIVEL 2");
                                nivel++;
                                continuar();
                                backgroundViewBot.setVisible(true);
                                circleBall.setCenterX(-300);//la bola vuelve a posicionarse fuera de la pantalla
                                direcBall=0;
                                groupM.setLayoutX(-80);//ocultamos los dos monstruos
                                groupMiz.setLayoutX(-80);
                                groupBot.setLayoutX(SCENE_WIDTH - botIz[0].getWidth());
                                groupBot.setLayoutY(dinosaurioY - (botIz[0].getHeight() - dinosaur1.getHeight()));
                                level2View.setVisible(true);
                                textTitleHealthBot.setVisible(true);
                                pbBotHealth.setVisible(true);
                                timelineIdle.stop();
                                timelineCoins.stop();
                                timelinePlaying.stop();
                                timelineLEVEL2.play();                                
                            }

                        } else {//SI ES NIVEL 2
                            circleBall.setRadius(20);
                            Shape circleBallrectBot = Shape.intersect(circleBall, rectBot);//Creamos una variable de la clase Shape para guardar la intersección
                            boolean colisionVaciaBotS = circleBallrectBot.getBoundsInLocal().isEmpty();
                            if (!colisionVaciaBotS) {//LA BOLA DEL DINOSAURIO LE HA DADO AL BOT
                                healthBot -= 20;//le quita vida al bot
                                pbBotHealth.setProgress((double)healthBot/healthBotInicial);
                                circleBall.setCenterX(-300);//si choca la bola vuelve a posicionarse fuera de la pantalla
                                direcBall = 0;
                                score += 20;
                                textScore.setText(String.valueOf(score));
                                if (healthBot <= 0) {//HA GANADO EL JUEGO
                                    System.out.println("HAS GANADO ");
                                    timelineBotRun.stop();
                                    timelineBotIdle.stop();
                                    timelineJump.stop();
                                    timelineIdle.stop();
                                    timelineRunRight.stop();
                                    timelineRunLeft.stop();
                                    timelineDead.stop();
                                    timelinePlaying.stop();
                                    timelineShoot.stop();
                                    winView.setVisible(true);//Muestro la imagen de you win
                                    paneScores.toFront();//traigo los marcadores al frente para que no se queden detrás de la imagen
                                    paneGeneralName.toFront();//traigo los nombres para que no se queden detrás de la imagen
                                }
                            }
                        }
                    }
                })
        );
        timelineShoot.setCycleCount(Timeline.INDEFINITE);//Llama al método setCycleCount (La animación seguirá hasta que la bola salga de la pantalla)
        //No tiene play porque empieza parado y lo arranco cuando me haga falta

        //TIMELINE -COINS
        // Game loop usando Timeline
        timelineCoins = new Timeline(//Sirve para lo que lo que metamos aquí. Podemos utilizar varios TimeLine con diferentes velocidades para diferentes cosas
                // 0.017 ~= 60 FPS (equivalencia de segundos a Frames por Segundo)
                new KeyFrame(Duration.seconds(0.017), new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent ae) {//Sólo puede haber un handle en el timeline

                        //APARECERÁN LAS MONEDAS ALEATORIAMENTE EN LA PANTALLA Y SI EL DINOSAURIO LAS COGE SUBE EL MARCADOR
                        //LAS MONEDAS DEBEN ESTAR AL ALCANCE DEL DINOSAURIO
                        // Le voy a pasar los límites para hacer los cálculos y me devuelve la posición en forma de double
                        //System.out.println("RX: "+posicionesAleatoriasX());
                        // LÍMITE DESDE EL SUELO HASTA LA PARTE MÁS ALTA DEL SALTO (el alcance del salto es desde donde se encuentra el dinosaurio + 280 del salto) 
                        //System.out.println("RY "+posicionesAleatoriasY());                    
                        //PONGO LAS MONEDAS EN LAS POSICIONES ALEATORIAS
                        if (!coin1.visibleProperty().getValue() && !coin2.visibleProperty().getValue() && !coin3.visibleProperty().getValue()) {
                            posXCoin1 = posicionesAleatoriasX();
                            posYCoin1 = posicionesAleatoriasY();
                            coin1.setLayoutX(posXCoin1);
                            coin1.setLayoutY(posYCoin1);
                            coin1.setVisible(true);

                            posXCoin2 = posicionesAleatoriasX();
                            posYCoin2 = posicionesAleatoriasY();
                            coin2.setLayoutX(posXCoin2);
                            coin2.setLayoutY(posYCoin2);
                            coin2.setVisible(true);

                            posXCoin3 = posicionesAleatoriasX();
                            posYCoin3 = posicionesAleatoriasY();
                            coin3.setLayoutX(posXCoin3);
                            coin3.setLayoutY(posYCoin3);
                            coin3.setVisible(true);
                        }
                    }
                })
        );
        timelineCoins.setCycleCount(Timeline.INDEFINITE);//Llama al método setCycleCount (La animación seguirá hasta que la bola salga de la pantalla)
        //timelineCoins.play();

        //TIMELINE - PLAYING*************************************OJO<<<<<<-----------------------------
        // Game loop usando Timeline
        timelinePlaying = new Timeline(//Sirve para lo que lo que metamos aquí. Podemos utilizar varios TimeLine con diferentes velocidades para diferentes cosas
                // 0.017 ~= 60 FPS (equivalencia de segundos a Frames por Segundo)
                new KeyFrame(Duration.seconds(0.017), new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent ae) {//Sólo puede haber un handle en el timeline   

                        if (nivel == 1) {//MONSTRUOS********
                            //VARIABLES PARA COLISION
                            Shape dinoMonstruo = Shape.intersect(rectDino, rectM);//Creamos una variable de la clase Shape para guardar la intersección de la colisión entre dinosaurio y monstruo
                            boolean colisionDMVacia = dinoMonstruo.getBoundsInLocal().isEmpty();//Si la intersección está vacía es que no han chocado
                            Shape dinoMonstruoiz = Shape.intersect(rectDino, rectMiz);//Si colisiona con el monstruo de la izquierda
                            boolean colisionDMizVacia = dinoMonstruoiz.getBoundsInLocal().isEmpty();

                            //MOVIMIENTO DE MONSTRUOS
                            if (groupM.getLayoutX() > 0) {//El monstruo está a la derecha y va hacia la izquierda
                                if (!viewsInMovement) {//Si no se mueve el fondo el monstruo de la derecha correra. Si se mueve el fondo correra a la velocidad del fondo (8)
                                    groupM.setLayoutX(groupM.getLayoutX() - 1);
                                } else {//si se mueve el fondo correrá también
                                    groupM.setLayoutX(groupM.getLayoutX() - 1);
                                }
                            } else {//si se pasa por la izquierda vuelve al comienzo
                                groupM.setLayoutX(SCENE_WIDTH);
                            }
                            if (groupMiz.getLayoutX() < SCENE_WIDTH) {//El monstruo está a la izquierda y va a la derecha (debe llegar también al cacho de sobra del dino, si no no choca)
                                if (!viewsInMovement) {//Si no se mueve el fondo el monstruo de la izquierda correra. Si se mueve correrá a la velocidad del fondo (8-1)
                                    groupMiz.setLayoutX(groupMiz.getLayoutX() + 1);
                                } else {//Si se mueve el fondo y está en pantalla
                                    if (groupMiz.getLayoutX() > (-rectMiz.getWidth() - 15)) {
                                        groupMiz.setLayoutX(groupMiz.getLayoutX() - 1);
                                    }
                                }
                            } else {//Si se pasa por la derecha vuelve al comienzo
                                groupMiz.setLayoutX(-(rectMiz.getWidth() + 15));
                            }

                            //DETECTA COLISIONES
                            if (!colisionDMVacia) {
                                health -= 200;
                                groupM.setLayoutX(SCENE_WIDTH);
                                textHealth.setText(String.valueOf(health));
                            }

                            if (!colisionDMizVacia) {
                                health -= 200;
                                groupMiz.setLayoutX(-rectMiz.getWidth());
                                textHealth.setText(String.valueOf(health));
                            }
                            ////////////////    
                        } else if (nivel == 2) {//BOT*****

                            //RANGO VIDA BOT:
                            //800 a 760->timelineBotIdle***
                            //760 a 600->timelineBotShooting***
                            //600 a 300->timelineBotRun***
                            //300 a 100->timelineBotShooting***
                            //100 a 0->timelineBotRun***
                            if (healthBot <= 760 && healthBot > 600) {
                                timelineBotIdle.stop();
                                if (directionB == 1) {
                                    botView1.setImage(botShootDer);
                                } else {
                                    botView1.setImage(botShootIz);
                                }
                                timelineBotShooting.play();

                            } else if ((healthBot <= 600 && healthBot > 300) || (healthBot <= 100 && healthBot > 0)) {//Si la vida del Bot llega a 500 correrá a por el dino
                                timelineBotShooting.stop();//Para el shooting del bot para comenzar a correr
                                groupOrb.setLayoutX(-300);//la orb del bot desaparece de la pantalla                    
                                if (groupBot.getLayoutX() > groupD.getLayoutX()) {//Si el bot está a la derecha del dino
                                    directionB = -1;
                                    groupBot.setLayoutX(groupBot.getLayoutX() - 2);
                                } else {//Si el bot está a la izquierda del dino
                                    directionB = 1;
                                    groupBot.setLayoutX(groupBot.getLayoutX() + 2);
                                }
                                timelineBotIdle.stop();
                                timelineBotRun.play();

                                //DETECTAR COLISIÓN CON BOT
                                Shape dinoBot = Shape.intersect(rectDino, rectBot);//Creamos una variable de la clase Shape para guardar la intersección de la colisión entre dinosaurio y monstruo
                                boolean colisionDBVacia = dinoBot.getBoundsInLocal().isEmpty();//Si la intersección está vacía es que no han chocado
                                if (!colisionDBVacia) {
                                    timelineBotRun.stop();
                                    if (directionB == 1) {
                                        botView1.setImage(botHitDer);
                                    } else {
                                        botView1.setImage(botHitIz);
                                    }
                                    health -= 5;
                                    textHealth.setText(String.valueOf(health));
                                } else {
                                    timelineBotRun.play();
                                }

                            } else if (healthBot <= 300 && healthBot > 100) {
                                //VUELVE A LA POSICIÓN INICIAL DISPARANDO OTRA VEZ
                                if (groupBot.getLayoutX() < (SCENE_WIDTH - botIz[0].getWidth())) {//Si su posición es menor que la posición inicial
                                    directionB = 1;//Se gira a la derecha
                                    timelineBotRun.play();
                                    groupBot.setLayoutX(groupBot.getLayoutX() + 2);
                                } else if (groupBot.getLayoutX() == (SCENE_WIDTH - botIz[0].getWidth())) {//Cuando llega a la posición inicial
                                    directionB = -1;
                                    timelineBotRun.stop();
                                    if (directionB == 1) {
                                        botView1.setImage(botShootDer);
                                    } else {
                                        botView1.setImage(botShootIz);
                                    }
                                    timelineBotShooting.play();
                                }
                            }
                        }
                        dañoDino();
                    }
                })
        );
        timelinePlaying.setCycleCount(Timeline.INDEFINITE);//Llama al método setCycleCount (para que la animación siga indefinidamente
        //timelinePlaying.play(); //Llama al método Play para echar a andar la animación    

        //TIMELINE - BOT SHOOTING-----------------------------
        // Game loop usando Timeline
        timelineBotShooting = new Timeline(//Sirve para lo que lo que metamos aquí. Podemos utilizar varios TimeLine con diferentes velocidades para diferentes cosas
                // 0.017 ~= 60 FPS (equivalencia de segundos a Frames por Segundo)
                new KeyFrame(Duration.seconds(0.004), new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent ae) {//Sólo puede haber un handle en el timeline   
                        conBotShoot++;
                                               
                        if (conBotShoot > 0) {
                            if (groupOrb.getLayoutX() > -(orbCircle.getRadius() * 2)) {//Si la bola no ha salido por la izquierda de la pantalla
                                groupOrb.setLayoutX(groupOrb.getLayoutX() - 1);
                            } else {
                                conBotShoot = 0;
                                groupOrb.setLayoutX(groupBot.getLayoutX() - (botShootDer.getWidth() / 2));
                                groupOrb.setLayoutY(groupBot.getLayoutY() + (botShootDer.getHeight() / 2));
                                orbView1.setImage(orb);
                            }
                            
                            if((groupOrb.getLayoutX()-groupD.getLayoutX())<150){//Si la obr del bot se acerca al dino cambiará la imagen a la orb2
                                orbView1.setImage(orb2);
                            }
                            if(groupD.getLayoutX()>groupOrb.getLayoutX()){
                                orbView1.setImage(orb);
                            }
                                                    
                            //DETECTA COLISIONES
                            Shape dinoOrb = Shape.intersect(rectDino, orbCircle);//Si colisiona con el monstruo de la izquierda
                            boolean colisionDOrbVacia = dinoOrb.getBoundsInLocal().isEmpty();
                            if (!colisionDOrbVacia) {
                                health -= 20;
                                textHealth.setText(String.valueOf(health));
                                groupOrb.setLayoutX(groupBot.getLayoutX() - (botShootDer.getWidth() / 2));
                                orbView1.setImage(orb);                                
                            }                                                       
                        }
                        dañoDino();
                    }
                })
        );
        timelineBotShooting.setCycleCount(espacioDisparoBot);//Llama al método setCycleCount dará tantos pasos como espacio hay entre el bot (inicio orb) y izquierda de la escena
        //timelineBotShooting.play(); //Llama al método Play para echar a andar la animación          

        //CUANDO LAS TECLAS SON PULSADAS
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {//Llama al método setOnKeyPressed. Cuando detecte que se pulsa una tecla en la escena (se puede hacer que en vez que en la escena se detecte cuando pulse dentro de un campo de texto)
            public void handle(final KeyEvent keyEvent) {
                if (vivo) {
                    timelineIdle.stop();//PARA EL TIMELINE IDLE PARA QUE NO INTERFIERA CON LA PULSACIÓN DE TECLAS
                    posicionMomView1 = backgroundView1.getX(); // Cuando pulsemos una tecla leeremos la posición actual del visor del fondo 1 y después moveremos la imagen
                    posicionMomView2 = backgroundView2.getX(); // Cuando pulsemos una tecla leeremos la posición actual del visor del fondo 2 y después moveremos la imagen          

                    switch (keyEvent.getCode()) {//Según la tecla pulsada
                        case LEFT:// el dinosaurio se moverá a la izquierda
                            lPressed = true;
                            viewsInMovement = false;//si va a la izquierda el fondo deja de moverse 
                            timelineRunLeft.play();
                            choquemonedas();
                            break;

                        case RIGHT: //el fondo se moverá a la izquierda
                            rPressed = true;//Para saber si la tecla a la derecha está pulsada
                            timelineRunRight.play();
                            choquemonedas();
                            break;

                        case UP:
                            timelineRunRight.stop();//antes de saltar paramos la animación de correr a derecha e izquierda
                            timelineRunLeft.stop();
                            if (!dentroJump) {//Solo saltará si no es un salto encima de otro
                                groupD.setLayoutY(dinosaurioY);
                                contJump = 0;//para que pueda mostrar los dinosaurios en timeline
                                timelineJump.play();
                            }

                            break;

                        case SPACE://Cuando se pulse espacio disparará una bola
                            if (rPressed) {//si la flecha a la derecha está pulsada cuando termine el salto seguirá corriendo
                                timelineRunRight.stop();
                            } else if (lPressed) {//si la flecha a la izquierda está pulsada cuando termine el salto seguirá corriendo
                                timelineRunLeft.stop();
                            } 
                            
                            direcBall = direction;//lo igualo al empezar a disparar porque el dinosaurio y la bola puede tomar direcciones diferentes una vez disparada
                            if (direcBall == -1) {//Si está mirando a la izquierda
                                dinosaurView1.setImage(dinosaurSi);
                                // le sumamos lo que sobra de imagen del dinosaurio(por un lado) menos el radio de la bola
                                circleBall.setCenterX(groupD.getLayoutX() + (dinoDeSobra - circleBall.getRadius()));
                            } else {//Si está mirando a la derecha
                                dinosaurView1.setImage(dinosaurSd);
                                // le sumaremos lo que sobra de imagen del dinosaurio (por los dos lados ya que va hacia la derecha) más radio de la bola más la anchura de la imagen del dinosaurio
                                circleBall.setCenterX(groupD.getLayoutX() + dinosaurView1.getFitWidth() + (dinoDeSobra * 2) + circleBall.getRadius());
                            }
                            //circleBall.setCenterY(dinosaurView1.getY()+59);//Altura a la mitad del alto del dinosaurio
                            circleBall.setCenterY(groupD.getLayoutY() + 59);
                            timelineShoot.play(); //Llama al método Play para echar a andar la animación
                            if ((direcBall == -1) && (circleBall.getCenterX() < (-circleBall.getRadius()))) {
                                timelineShoot.stop();
                            } else if ((direcBall == 1) && (circleBall.getCenterX() > (SCENE_WIDTH + circleBall.getRadius()))) {
                                timelineShoot.stop();
                            }
                            timelineIdle.play();
                            break;
                    }
                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {//Llama al método setOnKeyPressed. Cuando detecte que se pulsa una tecla en la escena (se puede hacer que en vez que en la escena se detecte cuando pulse dentro de un campo de texto)
            public void handle(final KeyEvent keyEvent) {
                if (keyEvent.getCode() != keyEvent.getCode().UP) { //ACTIVARÁ EL TIMELINE DE IDLE SIEMPRE QUE NO SE SUELTE LA TECLA UP
                    timelineIdle.play(); //Llama al método Play para echar a andar la animación
                }
                if (keyEvent.getCode() == keyEvent.getCode().RIGHT) { //ACTIVARÁ EL TIMELINE DE RUNRIGHT SIEMPRE QUE NO SE SUELTE LA TECLA UP
                    timelineRunRight.stop();
                    rPressed = false;//si se suelta la tecla a la derecha, cuando haga el salto se parará
                } else if (keyEvent.getCode() == keyEvent.getCode().LEFT) { //ACTIVARÁ EL TIMELINE DE RUNLEFT SIEMPRE QUE NO SE SUELTE LA TECLA UP
                    timelineRunLeft.stop();
                    lPressed = false;//si se suelta la tecla a la izquierda, cuando haga el salto se parará
                }
            }
        });
    }

    //MÉTODOS PROPIOS*****************************
    private void panelInvisible() {
        paneContinuar.setVisible(true);
    }

    private void panelVisible() {
        backgroundView1.setVisible(true);
        backgroundView2.setVisible(true);
        backgroundViewBot.setVisible(false);
        paneContinuar.setVisible(false);
        paneScores.setVisible(true);
        groupD.setVisible(true);
        groupM.setVisible(true);
        groupMiz.setVisible(true);
        circleBall.setVisible(true);
        coin1.setVisible(true);
        coin2.setVisible(true);
        coin3.setVisible(true);
        paneGeneralName.setVisible(true);
        coin1.setVisible(false);
        coin2.setVisible(false);
        coin3.setVisible(false);
    }

    private void continuar() {
        health = 2000;
        healthBot = 800; 
        pbBotHealth.setProgress((double)healthBot/healthBotInicial);
        textTitleHealthBot.setVisible(false);
        pbBotHealth.setVisible(false);
        //coins = 0;
        coinProvisional=0;
        direction = 1;
        directionB = -1;
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
        groupBot.setLayoutX(-300);
        botView1.setImage(botIz[0]);
        groupOrb.setLayoutX(-300);
        coin1.setLayoutX(-40);
        coin1.setLayoutY(0);
        coin2.setLayoutX(-40);
        coin2.setLayoutY(0);
        coin3.setLayoutX(-40);
        coin3.setLayoutY(0);
        vivo = true;
        i = 1;
        iBi = 1;
        iBr = 1;
        posicionMomView1 = 0;
        posicionMomView2 = 0;
        viewsInMovement = false;
        contPasos = 0;
        contJump = 0;
        Xactual = 0;
        Yactual = 0;
        direcBall = 1;
        deadPasos = 1;   
        conBotShoot = 0; 
        orbView1.setImage(orb);
        contCambios=0;
    }

    private void dañoDino(){
        //DETECTA EL DAÑO                   
        if (health >= 1800 && health < 2000) {
            heartView10.setImage(heartBlack);
        } else if (health >= 1600 && health < 1800) {
            heartView9.setImage(heartBlack);
        } else if (health >= 1400 && health < 1600) {
            heartView8.setImage(heartBlack);
        } else if (health >= 1200 && health < 1400) {
            heartView7.setImage(heartBlack);
        } else if (health >= 1000 && health < 1200) {
            heartView6.setImage(heartBlack);
        } else if (health >= 800 && health < 1000) {
            heartView5.setImage(heartBlack);
        } else if (health >= 600 && health < 800) {
            heartView4.setImage(heartBlack);
        } else if (health >= 400 && health < 600) {
            heartView3.setImage(heartBlack);
        } else if (health >= 200 && health < 400) {
            heartView2.setImage(heartBlack);
        } else if (health >= 1 && health < 200 ) {
            heartView2.setImage(heartBlack);
        } else if (health <= 0) {//SI MUERE***********
            vivo = false;
            heartView1.setImage(heartBlack);
            deadPasos = 1;
            timelineIdle.stop();
            timelineRunRight.stop();
            if (contJump == 14) {//que haya terminadoel salto antes de morir
                timelineJump.stop();
            }
            timelinePlaying.stop();
            timelineCoins.stop();
            timelineDead.play(); //Llama al método Play para echar a andar la animación
            System.out.println("HAS MUERTO :(");
        }
    }
    
    
    
    private void terminar(){
        System.exit(0);
    }

    private int posicionesAleatoriasX(){
        Random randomX = new Random();
        int rX = randomX.nextInt(limite);
        return rX;
    }

    private int posicionesAleatoriasY(){
        Random randomY = new Random();
        int alturaMaxima = dinosaurioY - 260; //El salto son 280(7 pasos de 40), altura a donde llega el salto (260***) HACIA ARRIBA SE RESTA (un poco menos para que no salga al limite por arriba
        //dinosaurioY+dinosaur1.height= 540+118=658 (no podremos pasarnos de (658***) HACIA ABAJO SE SUMA
        //Para que siempre esté en ese rango, se le pondrá de límite al Random (398***)(el suelo - la máxima altura del salto) y a esto se le sumará la altura máxima del salto HACIA ARRIBA RESTA
        int alturaSuelo = (int) (dinosaurioY + (dinosaur1.getHeight() - 20));//altura del suelo (658***) Posición Y del dinosaurio + altura del dinosaurio 
        int alSmasAlM = alturaSuelo - alturaMaxima;
        int rY = (int) (randomY.nextInt(alSmasAlM) + alturaMaxima);
        return rY;
    }

    private void choquemonedas(){
        //DETECTA COLISIÓN DEL DINOSAURIO CON LAS MONEDAS
        Shape dinoCoin1 = Shape.intersect(rectDino, coinBall1);//Creamos una variable de la clase Shape para guardar la intersección de la colisión entre dinosaurio y la moneda1
        boolean colisionDC1Vacia = dinoCoin1.getBoundsInLocal().isEmpty();
        if (!colisionDC1Vacia) {//MONEDA 1 HA COLISIONADO
            coin1.setLayoutX(0);
            coin1.setLayoutY(0);
            coins++;//MARCADOR GENERAL
            coinProvisional++;//CONTADOR MONEDAS DE 10 EN 10 PARA RECUPERAR VIDA
            textCoin.setText(String.valueOf(coins));
            coin1.setVisible(false);
        }

        Shape dinoCoin2 = Shape.intersect(rectDino, coinBall2);//Creamos una variable de la clase Shape para guardar la intersección de la colisión entre dinosaurio y la moneda1
        boolean colisionDC2Vacia = dinoCoin2.getBoundsInLocal().isEmpty();
        if (!colisionDC2Vacia) {//MONEDA 2 HA COLISIONADO
            coin2.setLayoutX(0);
            coin2.setLayoutY(0);
            coins++;
            coinProvisional++;//CONTADOR MONEDAS DE 10 EN 10 PARA RECUPERAR VIDA
            textCoin.setText(String.valueOf(coins));
            coin2.setVisible(false);
        }

        Shape dinoCoin3 = Shape.intersect(rectDino, coinBall3);//Creamos una variable de la clase Shape para guardar la intersección de la colisión entre dinosaurio y la moneda1
        boolean colisionDC3Vacia = dinoCoin3.getBoundsInLocal().isEmpty();
        if (!colisionDC3Vacia) {//MONEDA 3 HA COLISIONADO
            coin3.setLayoutX(0);
            coin3.setLayoutY(0);
            coins++;
            coinProvisional++;//CONTADOR MONEDAS DE 10 EN 10 PARA RECUPERAR VIDA
            textCoin.setText(String.valueOf(coins));
            coin3.setVisible(false);
        }
        if (coinProvisional == 10) {//SI COGE 10 MONEDAS SE LE SUMA UNA VIDA
            if (health < 2000) {//SI LA VIDA ES MENOR DE 2000 LE SUBIRÁ 200
                switch (health) {//Según la tecla pulsada
                    case 1800:// se restaurará el corazón 10
                        health += 200;
                        heartView10.setImage(heartImage);
                        textHealth.setText(String.valueOf(health));
                        break;
                    case 1600:// se restaurará el corazón 10
                        health += 200;
                        heartView9.setImage(heartImage);
                        textHealth.setText(String.valueOf(health));
                        break;
                    case 1400:// se restaurará el corazón 10
                        health += 200;
                        heartView8.setImage(heartImage);
                        textHealth.setText(String.valueOf(health));
                        break;
                    case 1200:// se restaurará el corazón 10
                        health += 200;
                        heartView7.setImage(heartImage);
                        textHealth.setText(String.valueOf(health));
                        break;
                    case 1000:// se restaurará el corazón 10
                        health += 200;
                        heartView6.setImage(heartImage);
                        textHealth.setText(String.valueOf(health));
                        break;
                    case 800:// se restaurará el corazón 10
                        health += 200;
                        heartView5.setImage(heartImage);
                        textHealth.setText(String.valueOf(health));
                        break;
                    case 600:// se restaurará el corazón 10
                        health += 200;
                        heartView4.setImage(heartImage);
                        textHealth.setText(String.valueOf(health));
                        break;
                    case 400:// se restaurará el corazón 10
                        health += 200;
                        heartView3.setImage(heartImage);
                        textHealth.setText(String.valueOf(health));
                        break;
                    case 200:// se restaurará el corazón 10
                        health += 200;
                        heartView2.setImage(heartImage);
                        textHealth.setText(String.valueOf(health));
                        break;
                }
            }
            coinProvisional = 0;
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
