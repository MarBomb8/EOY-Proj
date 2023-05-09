import javax.swing.ImageIcon;

public class WB {
	private int x, y, w, h;
	private ImageIcon WBImg;
	
	public WB() {
		x= 1;
		y = 1;
		w = 1;
		h = 1;
		WBImg = new ImageIcon("WB.png");
	
	}
	//use for aliens
	
	
	//getters and setters
	public ImageIcon getWBImg() {
		return WBImg;
	}
	public void setX(int xV) {
		x=xV;
	}
	public void setY(int yV) {
		y=yV;
	}
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	
	public void setW(int width) {
		w+=width;
	}
	public void setH(int height) {
		h+=height;
	}
	public int getW() {
		return w;
	}
	public int getH() {
		return h;
	}
	

	
	
}
    

