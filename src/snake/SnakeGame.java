package snake;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * A JavaFX Pane that displays the snake game represented by the given world
 */
public class SnakeGame extends Pane {

    public static final int SCALE = 16;

    public SnakeGame(World world) {
        setPrefSize(world.getSize() * SCALE, world.getSize() * SCALE);

        Snake snake = world.getSnake();
        Rectangle head = new Rectangle(snake.getX() * SCALE, snake.getY() * SCALE, 10, 10);
        head.setFill(Color.RED);
        snake.getXProperty().addListener((ov, ow, nw) -> head.setX((int) nw * SCALE));
        snake.getYProperty().addListener((ov, ow, nw) -> head.setY((int) nw * SCALE));

        Food food = world.getFood();
        Circle foodShape = new Circle(food.getX() * SCALE + 5, food.getY() * SCALE + 5, 5, Color.BLUE);
        food.getXProperty().addListener((ov, ow, nw) -> foodShape.setCenterX(((int) nw * SCALE)  + 5));
        food.getYProperty().addListener((ov, ow, nw) -> foodShape.setCenterY(((int) nw * SCALE)  + 5));

        this.getChildren().addAll(head, foodShape);
        snake.addListener(new SegmentListener(this));
    }

    private static class SegmentListener implements Snake.SnakeSegmentListener{
        private final SnakeGame snakeGame;
        public SegmentListener(SnakeGame snakeGame) {
            this.snakeGame = snakeGame;
        }

        @Override
        public void onNewSegment(Segment segment) {
            Rectangle bodySegment = new Rectangle(segment.getX() * SCALE, segment.getY() * SCALE, 10, 10);
            bodySegment.setFill(Color.GREEN);
            segment.getXProperty().addListener((ov, ow, nw) -> bodySegment.setX((int) nw * SCALE));
            segment.getYProperty().addListener((ov, ow, nw) -> bodySegment.setY((int) nw * SCALE));
            snakeGame.getChildren().add(bodySegment);
        }
    }

    public static Pane createUserInterface(World world) {
        VBox ui = new VBox();

        Label scoreText = new Label();
        Label runningText = new Label("Press 's' to start");

        world.getRunningProperty().addListener((ov, ow, nw) -> {
            if (world.isRunning()) {
               runningText.setText("Running");
            } else {
                runningText.setText("Paused");
            }
        });
        world.getScoreProperty().addListener((ov, ow, nw) -> scoreText.setText(nw + " point(s)"));

        ui.getChildren().addAll(scoreText, runningText);

        return ui;
    }
}
