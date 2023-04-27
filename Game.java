
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage; 
import java.awt.event.*; 


import javax.swing.ImageIcon;

public class Game  extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener{

	
	private BufferedImage back; 
	private Mouse mousep;
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
		mousep = new Mouse(1,1,1,1);
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
        }
		if(screen ==3){
			background = new ImageIcon("terrain.png");
		}
		
		

		
		
		
		
		
		twoDgraph.drawImage(back, null, 0, 0);
		
		
		
		
		
		
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
		
	
	//test


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
		mousep.setX(arg0.getX());
		mousep.setY(arg0.getY());
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
		if(screen == 2 && mousep.getX()>=34 && mousep.getX()<=218 && mousep.getY()>=202 && mousep.getY()<=280) {
		screen = 3;
	}
	if(screen == 2 && mousep.getX()>=34 && mousep.getX()<=222 && mousep.getY()>=436 && mousep.getY()<=516) {
		screen = 3;
	}
	}



	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

