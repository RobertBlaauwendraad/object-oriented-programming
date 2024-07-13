package snake;

import java.util.LinkedList;
import java.util.List;

/**
 * Snake consists of segments, where this head segment keeps track of the other body segments
 */
public class Snake extends Segment {

    public interface SnakeSegmentListener {
        void onNewSegment(Segment segment);
    }

    private Direction direction = Direction.RIGHT;

    private final World world;

    private final List<Segment> body = new LinkedList<>();

    private final List<SnakeSegmentListener> listeners = new LinkedList<>();

    public Snake(int x, int y, World world) {
        super(x, y);
        this.world = world;
    }

    public void move() {
        int newX = getX() + direction.getDX();
        int newY = getY() + direction.getDY();

        int worldSize = world.getSize();
        if (newX >= worldSize || newX < 0 || newY >= worldSize || newY < 0) {
            world.endGame();
        }

        Food food = world.getFood();
        if (newX == food.getX() && newY == food.getY()) {
            Segment segment = new Segment(getX() - direction.getDX(), getY() - direction.getDY());
            body.add(segment);
            for (SnakeSegmentListener listener : listeners) {
                listener.onNewSegment(segment);
            }
            world.setScore(world.getScore() + 1);
            world.moveFoodRandomly();
        }
        int nextX = getX();
        int nextY = getY();
        for (Segment segment: body) {
            int currentX = segment.getX();
            int currentY = segment.getY();
            if (newX == nextX && newY == nextY) {
                world.endGame();
            }
            segment.setPosition(nextX, nextY);
            nextX = currentX;
            nextY = currentY;
        }

        this.setPosition(newX, newY);
    }

    public void addListener(SnakeSegmentListener listener) {
        listeners.add(listener);
    }

    public void setDirection(Direction newDirection) {
        direction = newDirection;
    }

    public boolean isAt(int x, int y) {
        for (Segment segment : body) {
            if (segment.getX() == x && segment.getY() == y) {
                return true;
            }
        }

        return false;
    }

    public Direction getDirection() {
        return direction;
    }
}
