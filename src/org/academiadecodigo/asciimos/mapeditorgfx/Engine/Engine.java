package org.academiadecodigo.asciimos.mapeditorgfx.Engine;

import org.academiadecodigo.asciimos.mapeditorgfx.Cube.Cube;
import org.academiadecodigo.asciimos.mapeditorgfx.Cube.Direction;
import org.academiadecodigo.asciimos.mapeditorgfx.IO;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class Engine implements KeyboardHandler {

    private Grid grid;
    private Cube cube;

    public Engine(int size, int dimension) {
        grid = new Grid(size, dimension);
        cube = new Cube(10, 10, dimension);
    }

    public void init() {
        grid.drawGrid();
        cube.fill();
        initKeyboard();
    }

    private void checkRectangle() {
        grid.toggleSquare(cube.getX(), cube.getY());
    }

    private void save() {
        String data = grid.toString();
        IO.save(data, "saves/game.data");
    }

    private void load() {
        String data = IO.load("saves/game.data");
        grid.load(data);
    }

    private void initKeyboard() {
        // init keyboard
        Keyboard keyboard = new Keyboard(this);
        KeyboardEvent eventSpace = new KeyboardEvent();
        KeyboardEvent eventS = new KeyboardEvent();
        KeyboardEvent eventL = new KeyboardEvent();

        KeyboardEvent eventRight = new KeyboardEvent();
        KeyboardEvent eventLeft = new KeyboardEvent();
        KeyboardEvent eventDown = new KeyboardEvent();
        KeyboardEvent eventUP = new KeyboardEvent();

        // init event
        eventSpace.setKey(KeyboardEvent.KEY_SPACE);
        eventSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventSpace);

        eventS.setKey(KeyboardEvent.KEY_S);
        eventS.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventS);

        eventL.setKey(KeyboardEvent.KEY_L);
        eventL.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventL);

        /* MOVE EVENTS */

        eventRight.setKey(KeyboardEvent.KEY_RIGHT);
        eventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventRight);

        eventLeft.setKey(KeyboardEvent.KEY_LEFT);
        eventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventLeft);

        eventDown.setKey(KeyboardEvent.KEY_DOWN);
        eventDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventDown);

        eventUP.setKey(KeyboardEvent.KEY_UP);
        eventUP.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventUP);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_SPACE:
                checkRectangle();
                break;
            case KeyboardEvent.KEY_S:
                save();
                break;
            case KeyboardEvent.KEY_L:
                load();
                break;
            case KeyboardEvent.KEY_RIGHT:
                if (cube.getX() + cube.getDimension() > grid.getWidth()) {
                    return;
                }
                cube.move(Direction.RIGHT);
                break;
            case KeyboardEvent.KEY_LEFT:
                if (cube.getX() - cube.getDimension() < 10) {
                    return;
                }
                cube.move(Direction.LEFT);
                break;
            case KeyboardEvent.KEY_DOWN:
                if (cube.getY() + cube.getDimension() > grid.getWidth()) {
                    return;
                }
                cube.move(Direction.DOWN);
                break;
            case KeyboardEvent.KEY_UP:
                if (cube.getY() - cube.getDimension() < 10) {
                    return;
                }
                cube.move(Direction.UP);
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        // no implementation required
    }
}
