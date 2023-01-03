package menu;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.security.Key;

public class GraphicGame extends Application {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private double characterX = 0;
    private double characterY = 0;

    private double characterSpeed = 5;

    private Image characterImage;
    private ImageView characterView;

    public static void main(String[] args) {
        GraphicGame.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        characterImage = new Image("character.png");
        characterView = new ImageView(characterImage);

        Group root = new Group(characterView);
        Scene scene = new Scene(root, WIDTH, HEIGHT, Color.WHITE);

        scene.setOnKeyPressed(event -> {
            KeyCode code = event.getCode();
            if (code == KeyCode.LEFT) {
                characterX -= characterSpeed;
            } else if (code == KeyCode.RIGHT) {
                characterX += characterSpeed;
            } else if (code == KeyCode.UP) {
                characterY += characterSpeed;
            } else if (code == KeyCode.DOWN) {
                characterY -= characterSpeed;
            }
            characterView.setTranslateX(characterX);
            characterView.setTranslateY(characterY);
        });

        primaryStage.setTitle("Il Mio Gioco");
        primaryStage.setScene(scene);
        primaryStage.show();

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                characterView.setTranslateX(characterX);
                characterView.setTranslateY(characterY);
            }
        }.start();
    }
}