package org.academiadecodigo.asciimos.mapeditorgfx.cube;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cube {

    private int dimension;
    private Rectangle rectangle;

    public Cube(int x, int y, int dimension) {
        this.dimension = dimension;

        rectangle = new Rectangle(x, y, dimension, dimension);
        rectangle.setColor(Color.RED);
    }

    public void move(Direction direction) {
        switch (direction) {
            case UP:
                rectangle.translate(0, -dimension);
                break;
            case DOWN:
                rectangle.translate(0, dimension);
                break;
            case LEFT:
                rectangle.translate(-dimension, 0);
                break;
            case RIGHT:
                rectangle.translate(dimension, 0);
                break;
        }
    }

    public void fill() {
        rectangle.fill();
    }

    public int getDimension() {
        return dimension;
    }

    public int getX() {
        return rectangle.getX();
    }

    public int getY() {
        return rectangle.getY();
    }
}
