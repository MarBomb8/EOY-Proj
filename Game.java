
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.event.*; 


import javax.swing.ImageIcon;

public class Game  extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener{

	
	private BufferedImage back; 
	private Mouse mousep;
	private int key; 
	private MC mainchar;
	private ImageIcon background;
    private Long Time, startTime, startTime2, currentTime, lvlTimer, jumptimer;
    private int screen;
	private boolean jump,checkjump;
	private wbs WB;
	
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
		jump = false;
		checkjump = false; 
		jumptimer = System.currentTimeMillis();
        screen = 1;
        currentTime = System.currentTimeMillis()/1000;
        lvlTimer = System.currentTimeMillis();
		mousep = new Mouse(1,1,1,1);
		mainchar = new MC(200,300); 
		WB = new wbs(-100,-100,500, 500);
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
        //g2d.drawString("" + timer(), 50, 10);
		if (screen == 1 && timer()>= 1){
            background = new ImageIcon("boss bg.png");
            screen = 2;
        }
        if (screen == 2 ){
            background = new ImageIcon("level select.png");
        }
		if(screen ==3){
			background = new ImageIcon("terrain.png");
			g2d.drawImage(mainchar.getImg().getImage(), mainchar.getX(), mainchar.getY(), 80, 100, this);
			g2d.drawImage(WB.getImg().getImage(), 50, 300, 300, 300, this);
			g2d.drawImage(WB.getImg().getImage(), 400, 300, 300, 300, this);
			if(jump){
				jumptimer = (long)0;
				System.out.println(jumptimer);
				mainchar.setY(mainchar.getY()-70);
				jump=false;
				checkjump = true;
			}
		}
				
			if(screen ==4){
				background = new ImageIcon("portugal.png");
				g2d.drawImage(mainchar.getImg().getImage(), mainchar.getX(), mainchar.getY(), 80, 100, this);
				g2d.drawImage(WB.getImg().getImage(), 50, 300, 300, 300, this);
				g2d.drawImage(WB.getImg().getImage(), 400, 300, 300, 300, this);
				if(jump){
					jumptimer = (long)0;
					System.out.println(jumptimer);
					mainchar.setY(mainchar.getY()-70);
					jump=false;
					checkjump = true;	
				
			}
			if(checkjump){ 
				jumptimer++;
				if(jumptimer >= 100)     {
					System.out.println(jump);
					mainchar.setY(mainchar.getY()+70);
					jump = false;
					System.out.println(jumptimer);
					checkjump = false;

		}
			}
		}
		
		

		
		
		
		
		System.out.println(jumptimer);
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
		if(e.getKeyCode() ==68) {
			mainchar.setX(mainchar.getX()+10);
		}
		if(e.getKeyCode()==65) {
			mainchar.setX(mainchar.getX()-10);
		}
		if(e.getKeyCode()==32) {
			
			System.out.println("jumping");
			if(!jump&& !checkjump){
				jump = true;
			
			
		
	
			
		}
	}
	}
	
	//test


	//DO NOT DELETE
	




    @Override
    public void keyReleased(KeyEvent e) {

        // TODO Auto-generated method stub
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
		screen = 4;
	}
	
}



	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

