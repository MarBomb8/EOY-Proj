
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage; 
import java.awt.event.*; 


public class Game  extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener{

	
	private BufferedImage back; 
	private int key; 
	private ImageIcon background;
    private Long Time, startTime, startTime2, currentTime, lvlTimer;
    private int screen;
	
	public Game() {
		new Thread(this).start();	
		this.addKeyListener(this);
		new Thread(this).start();	
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		key =-1; 
		background = new ImageIcon ("");
		background = new ImageIcon ("Loadbg.gif");
        startTime = System.currentTimeMillis();
		startTime2 = System.currentTimeMillis();
        screen = 1;
        currentTime = System.currentTimeMillis()/1000;
        lvlTimer = System.currentTimeMillis();
	}

	
	
	public void run()
	   {
	   	try
	   	{
	   		while(true)
	   		{
	   		   Thread.currentThread().sleep(5);
	            repaint();
	         }
	      }
	   		catch(Exception e)
	      {
	      }
	  	}
	

	
	
	
	public void paint(Graphics g){
		
		Graphics2D twoDgraph = (Graphics2D) g; 
		if( back ==null)
			back=(BufferedImage)( (createImage(getWidth(), getHeight()))); 
		

		Graphics g2d = back.createGraphics();
	
		g2d.clearRect(0,0,getSize().width, getSize().height);
		
		g2d.setFont( new Font("Broadway", Font.BOLD, 50));
		
		g2d.setColor(Color.white);

       

		g2d.drawImage(background.getImage(), 0,0, getWidth(), getHeight(), this);
        g2d.drawString("" + timer(), 50, 10);
		if (screen == 1 && timer()>= 11){
            background = new ImageIcon("boss bg.png");
            screen = 2;
        }
        if (screen == 2 ){
            background = new ImageIcon("level select.png");
            screen = 3;
        }
		
		

		
		
		
		
		
		twoDgraph.drawImage(back, null, 0, 0);
		
		
		
		
		
		
}

public void wordColl(){
    Rectangle box = new Rectangle(b.getX(), b.getY(), b.getW(), b.getH());
}


private long timer() {
    startTime = (System.currentTimeMillis()/1000)-currentTime;
    //System.out.println(startTime);
    return startTime; 
}



	//DO NOT DELETE
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}




//DO NOT DELETE
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		key= e.getKeyCode();
		System.out.println(key);
		
	
	


	//DO NOT DELETE
	
}



    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }
    public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
        System.out.println("ysure");
	}



	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

