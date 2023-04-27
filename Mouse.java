public class Mouse {
    private int x,y,w,h;

    public Mouse() {
		x= 1;
		y = 1;
		w = 1;
		h = 1;
	}
	public Mouse(int xV, int yV, int width, int height) {
		x = xV;
		y= yV;
		w = width;
		h = height;
	}

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return this.w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return this.h;
    }

    public void setH(int h) {
        this.h = h;
    }

}
