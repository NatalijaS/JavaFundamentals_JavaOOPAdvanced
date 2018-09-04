package _07_OpenClosedAndLiskovSubstitution_Lab._05_Square;

class Rectangle {

    private int m_width;
    private int m_height;

    Rectangle(int m_width, int m_height) {
        this.setWidth(m_width);
        this.setHeight(m_height);
    }

    Rectangle(int m_width) {
        this.setWidth(m_width);
        this.setHeight(m_width);
    }

    int getWidth() {
        return this.m_width;
    }

    private void setWidth(int width) {
        this.m_width = width;
    }

    int getHeight() {
        return this.m_height;
    }

    private void setHeight(int height) {
        this.m_height = height;
    }

    int getArea() {
        return this.m_width * this.m_height;
    }
}
