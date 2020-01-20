package es.juanics.dinosaur_chaos;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    
    Image dinosaur = new Image(getClass().getResourceAsStream("/images/Idle (1).png"));
    ImageView dinosaurView1 = new ImageView(dinosaur);//meter la imagen dinosaurio en view
    int i = 1;//para timeline imagen dinosaur
    
    
    
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
        
        //PONER EL FONDO
        Image background1 = new Image(getClass().getResourceAsStream("/images/swamp.png"));//Él lo ha llamado image1
        ImageView backgroundView1 = new ImageView(background1);//Metemos la imagen de fondo en el visor
                
        backgroundView1.setX(0);//donde vamos a colocar la imagen
        backgroundView1.setY(0);
        backgroundView1.setFitHeight(SCENE_HEIGHT);//hacer que la imagen de fondo se adapte al tamño de la entana
        backgroundView1.setFitWidth(SCENE_WIDTH);
        
        root.getChildren().add(backgroundView1);
          
        //PONER EL DINOSAURIO
        dinosaurView1.setX(0);//posición x del dinosaurio
        dinosaurView1.setY(SCENE_HEIGHT-(SCENE_HEIGHT/3));//posición y del dinosaurio
        dinosaurView1.setFitHeight ((SCENE_HEIGHT*TAMAÑO_DINO)/100);//El dinosario será el 15% de la pantalla
        dinosaurView1.setFitWidth ((SCENE_WIDTH*TAMAÑO_DINO)/100);         
        root.getChildren().add(dinosaurView1);
        
        // Game loop usando Timeline
        Timeline timeline = new Timeline(//Sirve para lo que lo que metamos aquí. Podemos utilizar varios TimeLine con diferentes velocidades para diferentes cosas
            // 0.017 ~= 60 FPS (equivalencia de segundos a Frames por Segundo)
            new KeyFrame(Duration.seconds(0.017), new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae) {//Sólo puede haber un handle en el timeline
                    //idle();//la imagen del dinosaurio irá cambiando
                     if (i<=10){//Hasta que la i no llegue a 10 irá cambiando el dinosaurio
                        dinosaurView1.setImage("/images/Idle ("+(String.valueOf(i))+").png");
                        i++;
                    }else {//cuando la i llegue a 11, la volvemos a poner a 1
                        i=1;    
                    }
                }
            })                
        );
        
           
    }

    public static void main(String[] args) {
        launch();
    }

}