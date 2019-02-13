package org.academiadecodigo.asciimos.mapeditorgfx.Engine;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import java.util.ArrayList;

public class Grid {

    private int size;
    private int x;
    private int y;

    private int width;

    private int dimension;
    private int timesDrawn;

    private ArrayList<Rectangle> rectangles = new ArrayList<>();

    public Grid(int size, int dimension) {
        this.x = 10;
        this.y = 10;

        this.size = size;
        this.dimension = dimension;

        this.width = dimension*size;
    }

    public void drawGrid() {
        // reset X
        x = 10;

        // draw
        for (int i = 1; i <= size; i++) {
            Rectangle rectangle = new Rectangle(x, y, dimension, dimension);
            rectangle.draw();
            rectangles.add(rectangle);

            x += dimension;
        }

        // -1 because for starts at 0
        if (timesDrawn == size -1) {
            return;
        }

        // increments to create a new line
        y += dimension;

        timesDrawn += 1;
        drawGrid();
    }

    public void toggleSquare(int x, int y) {
        for (Rectangle rectangle : rectangles) {
            if (rectangle.getX() == x && rectangle.getY() == y) {
                if (!rectangle.isFilled()) {
                    rectangle.fill();
                    return;
                }
                rectangle.draw();
            }
        }
    }

    public void load(String data) {
        for (Rectangle rectangle : rectangles) {
            int index = rectangles.indexOf(rectangle);
            if(data.charAt(index) == '1') {
                rectangle.fill();
                continue;
            }
            rectangle.draw();
        }
    }

    public int getWidth() {
        return width;
    }

    @Override
    public String toString(){
        String data = "";
        for (Rectangle rectangle : rectangles) {
            if (rectangle.isFilled()) {
                data += 1;
                continue;
            }
            data += 0;
        }
        return data;
    }
}
