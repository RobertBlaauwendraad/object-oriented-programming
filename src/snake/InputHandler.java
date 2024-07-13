package snake;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * Handles controls of a snake game, where the 'a' and 'd' keys can be used to move and 's' (un)pauses the game
 */
public class InputHandler {

    private final EventHandler<KeyEvent> keyHandler;
    private final EventHandler<MouseEvent> mouseHandler;

    public InputHandler(World world) {
        Snake snake = world.getSnake();

        keyHandler = keyEvent -> {
            if (keyEvent.getCode().equals(KeyCode.S)) {
                world.setRunning(!world.isRunning());
            } else if (keyEvent.getCode().equals(KeyCode.A)) {
                snake.setDirection(snake.getDirection().rotateLeft());
            } else if (keyEvent.getCode().equals(KeyCode.D)) {
                snake.setDirection(snake.getDirection().rotateRight());
            }
            keyEvent.consume();
        };

        mouseHandler = mouseEvent -> {
            double x = mouseEvent.getX();
            double y = mouseEvent.getY();
            if (x > 0 && x < world.getSize() * SnakeGame.SCALE && y > 0 && y < world.getSize() * SnakeGame.SCALE) {
                world.getFood().moveTo((int) x / SnakeGame.SCALE, (int) y / SnakeGame.SCALE);
            }
            mouseEvent.consume();
        };
    }

    public EventHandler<KeyEvent> getKeyHandler() {
        return keyHandler;
    }

    public EventHandler<MouseEvent> getMouseHandler() {
        return mouseHandler;
    }
}
