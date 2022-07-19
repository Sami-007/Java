import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;

class start_window extends JFrame implements ActionListener {

	
	JButton button_1,button_2,button_3,button_4;
	JLabel lable_1;


	ImageIcon mainImage,image_1,image_2,image_3,image_4;
	

	static int total_player=2;
	


	start_window (){

	
		
		
		setLayout(null);
		setTitle("Snake & Ladder");
		setSize(355,527);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.GRAY);
		UIManager.put("JFrame.activeTitleBackground", Color.red);
		setLocationRelativeTo(null);
		setUndecorated(true);
		

		mainImage = new ImageIcon("start_img.jpg");
		image_1 = new ImageIcon("button_1.png");
		image_2 = new ImageIcon("button_2.png");
		image_3 = new ImageIcon("button_3.png");
		image_4 = new ImageIcon("button_4.png");

	
	



		button_1 = new JButton(image_1);
		button_2 = new JButton(image_2);
		button_3 = new JButton(image_3);
		button_4 = new JButton(image_4);


		button_1.setBounds(80,190,200,50);
		button_2.setBounds(80,270,200,50);
		button_3.setBounds(80,340,200,50);
		button_4.setBounds(80,410,200,50);

		button_1.setForeground(Color.white);
		button_2.setForeground(Color.white);
		button_3.setForeground(Color.white);
		button_4.setForeground(Color.white);

		button_1.setContentAreaFilled( false );
		button_2.setContentAreaFilled( false );
		button_3.setContentAreaFilled( false );
		button_4.setContentAreaFilled( false );
		

		button_1.setBorder( null );
		button_2.setBorder( null );
		button_3.setBorder( null );
		button_4.setBorder( null );



		button_1.addActionListener(this);
		button_2.addActionListener(this);
		button_3.addActionListener(this);
		button_4.addActionListener(this);
		

		add(button_1);
		add(button_2);
		add(button_3);
		add(button_4);

		 

		 	// main Image

		lable_1 = new JLabel(mainImage);
		lable_1.setBounds(0,0,355,527);
		add(lable_1);

		setVisible(true);
	}


public void actionPerformed(ActionEvent ae){


	JButton btn=(JButton)ae.getSource();

	if(btn==button_1){
		
		setVisible(false);
		new uCode();
	}
	else if(btn==button_2){
		
		total_player=3;
		setVisible(false);
		new uCode(); 
	}
	else if(btn==button_3){
		
		total_player=4;
		setVisible(false);
		new uCode(); 
	}
	else if(btn==button_4){
		
		new uCode(); 
		System.exit(0);
	}


}
	
}

public class start{

	 public static void main(String[] args) {
		new start_window ();
		
	}
}





class uCode extends JFrame implements ActionListener,Runnable {

	JButton button_1,button_2,button_3,button_4;
	JButton player_1,player_2,player_3,player_4;
	JButton reset,back;

	ImageIcon mainImage,diceImage,winner,reset_img,back_img,image_1,image_2,image_3,image_4,diceImage_1,diceImage_2,diceImage_3,diceImage_4,diceImage_5,diceImage_6;
	JLabel lable_1,dice,lable_P1,lable_P2,lable_P3,lable_P4,winner_name;

	Thread thread;
	

	uCode(){

	

		
		setLayout(null);
		setTitle("Snake & Ladder");
		setSize(1000,575);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.GRAY);
		setLocationRelativeTo(null);
		
		


		mainImage = new ImageIcon("main_image.jpg");
		diceImage = new ImageIcon("dice.gif");
		winner = new ImageIcon("winner.gif");
		reset_img = new ImageIcon("reset.png");
		back_img = new ImageIcon("back.png");

		image_1 = new ImageIcon("player1.jpg");
		image_2 = new ImageIcon("player2.jpg");
		image_3 = new ImageIcon("player3.jpg");
		image_4 = new ImageIcon("player4.jpg");

		diceImage_1 = new ImageIcon("1.png");
		diceImage_2 = new ImageIcon("2.png");
		diceImage_3 = new ImageIcon("3.png");
		diceImage_4 = new ImageIcon("4.png");
		diceImage_5 = new ImageIcon("5.png");
		diceImage_6 = new ImageIcon("6.png");


		// Lable when player win
		winner_name = new JLabel();

		winner_name.setBounds(790,0,200,50);
		winner_name.setForeground(Color.white);
		winner_name.setBackground(Color.GRAY);
		add(winner_name);

		// Lable as P1 P2 P3 P4

		lable_P1 = new JLabel("P1");
		lable_P2 = new JLabel("P2");
		lable_P3 = new JLabel("P3");
		lable_P4 = new JLabel("P4");

		lable_P1.setBounds(790,50,50,50);
		lable_P2.setBounds(790,110,50,50);
		lable_P3.setBounds(950,50,50,50);
		lable_P4.setBounds(950,110,50,50);

		lable_P1.setForeground(Color.white);
		lable_P2.setForeground(Color.white);
		lable_P3.setForeground(Color.white);
		lable_P4.setForeground(Color.white);


		add(lable_P1);
		add(lable_P2);
		add(lable_P3);
		add(lable_P4);	

		
		//Players as Buttons green blue red etc

		button_1 = new JButton(image_1);
		button_2 = new JButton(image_2);
		button_3 = new JButton(image_3);
		button_4 = new JButton(image_4);

		button_1.setBounds(820,50,50,50);
		button_2.setBounds(820,110,50,50);
		button_3.setBounds(880,50,50,50);
		button_4.setBounds(880,110,50,50);

		add(button_1);
		add(button_2);
		add(button_3);
		add(button_4);


		// main Image

		lable_1 = new JLabel(mainImage);
		lable_1.setBounds(0,0,768,539);
		add(lable_1);

		// button reset and back

		reset = new JButton(reset_img);
		back = new JButton(back_img);


		reset.setBounds(780,180,100,50);
		back.setBounds(880,180,100,50);

		back.setContentAreaFilled( false );
		reset.setContentAreaFilled( false );

		reset.setBorder( null );
		back.setBorder( null );

		reset.addActionListener(this);
		back.addActionListener(this);

		add(reset);
		add(back);

		// label as Dice

		dice = new JLabel(diceImage);
		dice.setBounds(810,275,110,100);
		add(dice);


		// players Button to play

		player_1 = new JButton("P1");
		player_2 = new JButton("P2");
		player_3 = new JButton("P3");
		player_4 = new JButton("P4");


		player_1.setBounds(780,420,90,50);
		player_2.setBounds(780,480,90,50);
		player_3.setBounds(880,420,90,50);
		player_4.setBounds(880,480,90,50);

		player_1.setForeground(Color.green);
		player_2.setForeground(Color.green);
		player_3.setForeground(Color.green);
		player_4.setForeground(Color.green);

		player_1.setBackground(Color.GREEN);
		player_2.setBackground(Color.RED);
		player_3.setBackground(Color.RED);
		player_4.setBackground(Color.RED);



		player_1.addActionListener(this);
		player_2.addActionListener(this);
		player_3.addActionListener(this);
		player_4.addActionListener(this);
		

		add(player_1);
		add(player_2);
		add(player_3);
		add(player_4);

		 thread= new Thread(this);

		setVisible(true);
	}


int players=start_window.total_player;
int turn=1;
int[][] position= new int [][]{
	{10,485,1},
	{10,485,1},
	{10,485,1},
	{10,485,1}
};


JButton jb = new JButton();
int rand=0,location=0;
int x = 10;
int y = 485;
int z = 0;
boolean check=true;	

public void actionPerformed(ActionEvent ae){


	
	JButton btn=(JButton)ae.getSource();
	lable_1.setIcon(mainImage);
	winner_name.setText("");

	// for player 1  
	if(btn.getText().equals("P1") && turn==1){

		random_num(button_1 , 1);

		if(rand != 6){
			player_1.setBackground(Color.RED);
			player_2.setBackground(Color.GREEN);
			turn=2;
					}
	}
	//for player 2
	else if(btn.getText().equals("P2") && turn==2){

		random_num(button_2 , 2);

		if(rand != 6){
			if(players>=3){
				player_2.setBackground(Color.RED);
				player_3.setBackground(Color.GREEN);
				turn=3;
				}
			else{
				player_2.setBackground(Color.RED);
				player_1.setBackground(Color.GREEN);
				turn=1;
				}
		}			
	}
	//for player 3
	if(players>=3 && turn==3){

			if(btn.getText().equals("P3") ){


				random_num(button_3,3); 

				if(rand != 6){
					if(players==4){
						player_3.setBackground(Color.RED);
						player_4.setBackground(Color.GREEN);
						turn=4;
						}
					else{
						player_3.setBackground(Color.RED);
						player_1.setBackground(Color.GREEN);
						turn=1;
						}

				}	
					
			}
	}
	//for player 4
	if(players>=4 && turn==4){

		if(btn.getText().equals("P4") ){

			random_num(button_4,4);

			if(rand != 6){
				player_4.setBackground(Color.RED);
				player_1.setBackground(Color.GREEN);
				turn=1;
			}
		}
	}

	// for reset button
	if(btn==reset || btn==back){

						x= 10;
						y = 485;
						z = 0;
						button_1.setBounds(820,50,50,50);
						button_2.setBounds(820,110,50,50);
						button_3.setBounds(880,50,50,50);
						button_4.setBounds(880,110,50,50);
						lable_1.setIcon(mainImage);

						player_1.setBackground(Color.GREEN);
						player_2.setBackground(Color.RED);
						player_3.setBackground(Color.RED);
						player_4.setBackground(Color.RED);
						
						turn=1;

						for(int k=0 ; k<4 ; k++){
	
							position[k][0]=10;
							position[k][1]=485;
							position[k][2]=1;				
						}
	}

	// for back button
if(btn==back){

		setVisible(false);
		new start_window(); 
	}

}


// To generate random number and calling thread
public void random_num(JButton b , int player_num) {

	int run=0;
	int n =0 ;
	Random r = new Random();
	n=r.nextInt(6)+1;
	
	switch(n){
		case 1:dice. setIcon(diceImage_1);
				break;
		case 2:dice. setIcon(diceImage_2);
				break;
		case 3:dice. setIcon(diceImage_3);
				break;
		case 4:dice. setIcon(diceImage_4);
				break;
		case 5:dice. setIcon(diceImage_5);
				break;
		case 6:dice. setIcon(diceImage_6);
				break;
	}
	
	jb = b;
	location = player_num;
	rand = n;

	if(check){
		thread.start();
		check=false;
	}
	else thread.resume();
}


// movie position of players

public void run(){

	try{
			
		for(int i=0 ; ; i++){
				//getting player possion for moving
				if(i==1){
					x=position[location-1][0];
					y=position[location-1][1];
					z=position[location-1][2];
				}
					// for moving forword
					if(z>=0){
						jb.setBounds(x,y,50,50);
						x=x+77;
						if(z==10){
							z=-11;
							y=y-53;
							}		
					}
					//for moving backword
					else{
						x=x-77;
						jb.setBounds(x,y,50,50);
						if(z==-1){
							z=0;
							y=y-54;
							}	
					}

				z++;						
				thread.sleep(200);


			

				//after player move to the dice position
				if(i==rand){

				
					// for laders
					if(x==626 && y==485 || x==164 && y==378 || x==472 && y==218 || x==395 && y==164 || x==626 && y==111){

							if(x==626 && y==485){
								x=626;
								y=378;
								z=10;
								jb.setBounds(x,y,50,50);
								x=703;
							}
							else if(x==164 && y==378){
								x=10;
								y=164;
								z=2;
								jb.setBounds(x,y,50,50);
								x=87;					
							}	
							else if(x==472 && y==218){
								x=549;
								y=164;
								z=9;
								jb.setBounds(x,y,50,50);
								x=626;
							}
							else if(x==395 && y==164){
								x=241;
								y=4;
								z=-4;
								jb.setBounds(x,y,50,50);
							}
							else if( x==626 && y==111){
								x=549;
								y=4;
								z=-8;
								jb.setBounds(x,y,50,50);
							}			
						}

					//for snakes	
					if(x==241 && y==378 || x==395 && y==271 || x==626 && y==218 || x==549 && y==164 || x==780 && y==4 || x==87 && y==4){

							if(x==241 && y==378){
								x=241;
								y=432;
								z=-3;
								jb.setBounds(x,y,50,50);
								
							}
							else if(x==395 && y==271){
								x=318;
								y=485;
								z=6;
								jb.setBounds(x,y,50,50);
								x=395;
							}
							else if(x==626 && y==218){
								x=549;
								y=325;
								z=-7;
								jb.setBounds(x,y,50,50);
								
							}
							else if(x==549 && y==164){
								x=549;
								y=378;
								z=9;
								jb.setBounds(x,y,50,50);
								x=626;
							}
							else if(x==780 && y==4){
								x=703;
								y=218;
								z=-9;
								jb.setBounds(x,y,50,50);
								x=780;
							}
							else if(x==87 && y==4){
								x=241;
								y=378;
								z=5;
								jb.setBounds(x,y,50,50);
								x=318;
							}
						}	

					// if player win
					if(y<=-50 || x==10 && y==4){

						x= 10;
						y = 485;
						z = 0;
						button_1.setBounds(820,50,50,50);
						button_2.setBounds(820,110,50,50);
						button_3.setBounds(880,50,50,50);
						button_4.setBounds(880,110,50,50);
						lable_1.setIcon(winner);
						if(turn==1){
							winner_name.setText("  P"+(turn)+" is Winner Of This Game");
						}
						else
							winner_name.setText("  P"+(turn-1)+" is Winner Of This Game");

						player_1.setBackground(Color.GREEN);
						player_2.setBackground(Color.RED);
						player_3.setBackground(Color.RED);
						player_4.setBackground(Color.RED);
						
						turn=1;

						for(int k=0 ; k<4 ; k++){
	
							position[k][0]=10;
							position[k][1]=485;
							position[k][2]=1;				
						}
					}			
					else{
						position[location-1][0]=x;
						position[location-1][1]=y;
						position[location-1][2]=z;				
					}

					i=0;	
					thread.suspend();
				}
			}
	}
	catch(Exception e){

	}		
}

	
}

