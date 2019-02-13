package org.academiadecodigo.asciimos.mapeditorgfx.Cube;

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

    public void moveUP() {
        rectangle.translate(0, -dimension);
    }

    public void moveDown() {
        rectangle.translate(0, dimension);
    }

    public void moveLeft() {
        rectangle.translate(-dimension, 0);
    }

    public void moveRight() {
        rectangle.translate(dimension, 0);
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
