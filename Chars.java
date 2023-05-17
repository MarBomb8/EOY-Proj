import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Chars {
    private int x;
    private int y;
    private int dx;
    private int dy;
    private int w;
    private int h;
    private ImageIcon img;

    public Chars() {
		x= 1;
		y = 1;
		w = 1;
		h = 1;
		img = new ImageIcon("");
		dx = 0;
		dy = 0;
	}
	public Chars(int xV, int yV, int width, int height, int dx, ImageIcon i) {
		x = xV;
		y= yV;
		w = width;
		h = height;
		img = i;
		dx = 1;
		dy = 2;
	}
	public Chars(int xV, int yV, int wV, int hV, ImageIcon i) {
		x = xV;
		y= yV;
		w = 30;
		h = 30;
		img = i;
		dx = 0;
		dy = -4;
	}

    

    public ImageIcon getImg() {
        return this.img;
    }

    public void setImg(ImageIcon img) {
        this.img = img;
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

    public int getDx() {
        return this.dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return this.dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
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
    public boolean collision(wbs wa){
      Rectangle water= new Rectangle(wa.getX(), wa.getY(), wa.getW(), wa.getH());
       Rectangle player= new Rectangle(x,y,w,h);

       if(water.intersects(player)){
       if(wa.getX() <= x+w && wa.getX()>=x){
        setX(wa.getX()-1-w);
    
        return true;
       }
       else if(wa.getX() <=x){
        setX(wa.getX()+wa.getW()+1);
  

         return true;
       }


    }
       return false;
    }
    public boolean jumpcollision(wbs wa){
        Rectangle water= new Rectangle(wa.getX(), wa.getY(), wa.getW(), wa.getH());
        Rectangle player= new Rectangle(x,y,w,h);
 
        if(water.intersects(player)){
return true;
        }

        return false;
    }  

}
