import javax.swing.ImageIcon;

public class Coins {
    
   private int x;
  private int y;
  private int dx;
  private int dy;
  private int w;
  private int h;
  private ImageIcon img;
  
  public Coins() {
		x= 1;
		y = 1;
		w = 1;
		h = 1;
		img = new ImageIcon("");
		dx = 0;
		dy = 0;
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

  public ImageIcon getImg() {
    return this.img;
  }

  public void setImg(ImageIcon img) {
    this.img = img;
  }

   








}
