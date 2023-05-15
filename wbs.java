import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class wbs {
    int x;
    int y;
    int w;
    int h;
    ImageIcon img;

    public ImageIcon getImg() {
        return this.img;
    }

    public void setImg(ImageIcon img) {
        this.img = img;
    }
    public boolean collision(MC s) {
		Rectangle WB = new Rectangle(s.getX(), s.getY(), s.getW(),s.getH());
		Rectangle MC = new Rectangle(getX(), getY(), getW(), getH());
		
		if(WB.intersects(MC)) {
			return true; 
		}
		
		return false;
	}

    public wbs() {
		x= 1;
		y = 1;
		w = 1;
		h = 1;
		img = new ImageIcon("WB.png");
	}
	public wbs(int xV, int yV, int wV, int hV) {
		x = 900;
		y= yV;
		w = wV;
		h = hV;
		img = new ImageIcon("WB.png");
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

    public ImageIcon ImageIcon() {
        return null;
    }

    public int size() {
        return 0;
    }

    public JComponent get(int a) {
        return null;
    }

    

}
