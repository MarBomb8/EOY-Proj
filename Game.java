
import javax.lang.model.util.ElementScanner6;
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
	private MC mainchar, mbappe, ron;
	private ImageIcon background;
    private Long Time, startTime, startTime2, currentTime, lvlTimer, jumptimer;
    private int screen;
	private boolean jump,checkjump, jumpcoll;
	private wbs WB;
	private red RC;
	
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
		jumpcoll=false;
		jumptimer = System.currentTimeMillis();
        screen = 1;
        currentTime = System.currentTimeMillis()/1000;
        lvlTimer = System.currentTimeMillis();
		mousep = new Mouse(1,1,1,1);
		mainchar = new MC(300,300); 
		WB = new wbs(50,200,200, 200);
		ron = new MC(1,1,1, new ImageIcon("Ron.gif"));
		mbappe = new MC(500,300,1, new ImageIcon("Mbappe.gif"));
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
            screen = 3;
        }
       
		if(screen ==3){
			background = new ImageIcon("terrain.png");
			g2d.drawImage(mainchar.getImg().getImage(), mainchar.getX(), mainchar.getY(), 80, 100, this);
			g2d.drawImage(mbappe.getImg().getImage(), mbappe.getX(), mbappe.getY(),120, 120, this);
			mbappe.move(getWidth(), getHeight());
			//g2d.drawImage(mbappe.getImg().getImage(), mbappe.getX(), mbappe.getY(),100, 130, this);
			//System.out.println("mb x" + mbappe.getX());
			g2d.drawImage(WB.getImg().getImage(), 150, 330, 100, 300, this);
		int checkwin= mainchar.charchollsion(mbappe);
		switch(checkwin){
			case 1:
				screen = 2;
				break;
			case 2:
				screen = 4;
				break;
		}
		jumping();	
			}
			
			if(screen == 2){
				background = new ImageIcon("Lose.png");
				
			}
				
			if(screen == 4){
				background = new ImageIcon("winbg.png");
				g2d.drawImage(ron.getImg().getImage(), ron.getX(), ron.getY(),100, 100, this);
				g2d.drawImage(mainchar.getImg().getImage(), mainchar.getX(), mainchar.getY(), 80, 100, this);
				jumping();
			}
		
		
		

		
		
		
			move();
		//System.out.println(jumptimer);
		twoDgraph.drawImage(back, null, 0, 0);

		
		
		
		
		
}

public void jumping(){
	//mainchar.jumpcollision(WB);
	if(jump){
		jumptimer = (long)0;
		System.out.println(jumptimer);
		mainchar.setY(mainchar.getY()-90);
		jump=false;
		checkjump = true;	

	
}
//System.out.println("jump" +checkjump);
if(checkjump){ 
	jumptimer++;
	System.out.println(jumptimer);
	if(jumptimer >= 100)     {
		if(mainchar.jumpcollision(WB)){
			//i don't know
		}
		System.out.println(jump);
		//mainchar.setY(mainchar.getY()+90);
		jump = false;
		//mainchar.setY(300);
		jumptimer=(long)0;
		//System.out.println(jumptimer);
		checkjump = false;

}
// if(!jumpcoll){
// 	mainchar.setY(300);
// }
}
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
	
	}
	


	public void move(){
		System.out.println(key);
		if(key ==68) {
			if(jumpcoll){
				mainchar.setX(mainchar.getX()+10);

			}
			else if(!mainchar.collision(WB))
			mainchar.setX(mainchar.getX()+10);
			// else if(mainchar.getX()+mainchar.getW()>= WB.getX()+WB.getW())
			// mainchar.setX(mainchar.getX()+10);
			// else
			// mainchar.setX(mainchar.getX()-1);

		
		}
		if(key==65) {
			if(jumpcoll){
				mainchar.setX(mainchar.getX()-10);

			}
			else if(!mainchar.collision(WB))
			mainchar.setX(mainchar.getX()-10);
			// else if(mainchar.getX()<= WB.getX()+WB.getW())
			// mainchar.setX(mainchar.getX()-10);
			// else
			// mainchar.setX(mainchar.getX()+1);
		}
		if(key==32) {
			
			System.out.println("jumping");
			if(!jump && !checkjump){
				jump = true;
				//checkjump=true;
				jumpcoll= mainchar.jumpcollision(WB);
		
	
			
		}
	}

	}
	//test


	//DO NOT DELETE
	




    @Override
    public void keyReleased(KeyEvent e) {
		jumpcoll= false;
		key=-1;
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
		System.out.println("pressed");
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

