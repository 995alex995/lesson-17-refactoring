package exercises.ella;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game implements MouseListener, ActionListener {

	Timer timer = new Timer(1000, this);
	int time = 0;
	JFrame frame = new JFrame();
	PicturePanel panel = new PicturePanel();
	SideBar bar = new SideBar();
	JPanel mainPanel = new JPanel();
	Emojis emoji = new Emojis();
	int gameNumber = 0;
	boolean checkMe = false;
	boolean checkMe2 = false;
	boolean checkMe3 = false;
	boolean checkMe4 = false;
	boolean checkMe5 = false;
	boolean checkMe6 = false;
	boolean checkMe7 = false;
	boolean checkMe21 = false;
	boolean checkMe22 = false;
	boolean checkMe23 = false;
	boolean checkMe24 = false;
	boolean checkMe25 = false;
	boolean checkMe26 = false;
	boolean checkMe27 = false;
	JButton snakeButton;
	JButton ringButton;
	JButton backpackButton;
	JButton sparklesButton;
	JButton pawprintsButton;
	JButton diamondButton;
	JButton balloonButton;
	
	JButton appleButton;
	JButton bowButton;
	JButton keyButton;
	JButton cloudButton;
	JButton chickenButton;
	JButton roseButton;
	JButton earthButton;
	JButton cactusButton;
	
	
	

	public static void main(String[] args) {

		Game ellasGame = new Game();

	}

	Game() {

		setup();
		timer.start();

	}


	void setup() {

		// System.out.println(xList);
		frame.setSize(1800, 1000);
		// mainPanel.setPreferredSize(new Dimension(500, 500));
		frame.setLayout(new BorderLayout());
		mainPanel.add(panel, BorderLayout.WEST);
		mainPanel.add(bar, BorderLayout.EAST);
		frame.add(mainPanel);
		panel.setPreferredSize(new Dimension(1500, 1000));
		frame.setVisible(true);
		frame.addMouseListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createLevelOneButtons();

	}

	void createLevelOneButtons() {
		
        snakeButton = addButton("snake.png", 1100, 420);
		ringButton = addButton("WeddingRing.png", 1460, 500);
        backpackButton = addButton("backpack.png", 840, 770);
		sparklesButton = addButton("sparkles.png", 680, 756);
        pawprintsButton = addButton("pawprints.png", 1079, 782);
        diamondButton = addButton("diamond.png", 315, 900);
        balloonButton = addButton("balloon.png", 698, 336);
	}

	void createLevelTwoButtons() {
		appleButton = addButton("apple.png", 503, 931);
		bowButton = addButton("bow.png", 953, 903);
		roseButton = addButton("rose.png", 719, 664);
		cloudButton = addButton("cloud.png", 460, 529);
		chickenButton = addButton("chicken.png", 351, 575);
		earthButton = addButton("earth.png", 1224, 879);
		cactusButton = addButton("cactus.png", 578, 588);
	}

	private JButton addButton(String fileName, int xPosition, int yPosition) {
		JButton button = new JButton();
		try {
			Image image = ImageIO.read(getClass().getResource(fileName));
			ImageIcon imageIcon = new ImageIcon();
			imageIcon.setImage(image);
			button.setIcon(imageIcon);
			panel.setLayout(null);
			panel.add(button);
			button.addMouseListener(this);
			button.setBorder(null);
			button.setBounds(xPosition, yPosition, 30, 30);
		} catch (Exception e) {
			System.out.println(e);
		}
		return button; }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getX());
		System.out.println(e.getY());

	}
	
	void itemFound(JButton button, boolean check) {

		button.setVisible(false);
		bar.foundBalloon();
		check = true;
	}
	

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == (snakeButton)) {
			itemFound(snakeButton, checkMe);
		}
		if (e.getSource() == (ringButton)) {
			itemFound(ringButton, checkMe2);
		}
		if (e.getSource() == (backpackButton)) {
			itemFound(backpackButton, checkMe3);
		}
		if (e.getSource() == (sparklesButton)) {
			itemFound(sparklesButton, checkMe4);
		}
		if (e.getSource() == (pawprintsButton)) {
			itemFound(pawprintsButton, checkMe5);
		}
		if (e.getSource() == (diamondButton)) {
			itemFound(diamondButton, checkMe6);
		}
		if (e.getSource() == (balloonButton)) {
			itemFound(balloonButton, checkMe7);
		}
		
		if (checkFoundAll()) {
			timer.stop();
			JOptionPane.showMessageDialog(null, "Congratulations! You found all the pictures! \n You finished the puzzle in: " + time + " seconds. \n Ready for level 2?");
			
			panel.nextLevelPicture();
			bar.nextLevelBar();
			gameNumber += 1;
			checkMe = false;
			checkMe2 = false;
			checkMe3 = false;
			checkMe4 = false;
			checkMe5 = false;
			checkMe6 = false;
			checkMe7 = false;
			createLevelTwoButtons();
			time = 0;
			timer.restart();

		}

		if (e.getSource() == (appleButton)) {
			itemFound(appleButton, checkMe21);
		}
		if (e.getSource() == (bowButton)) {
			itemFound(bowButton, checkMe22);
		}
		if (e.getSource() == (roseButton)) {
			itemFound(roseButton, checkMe23);
		}
		if (e.getSource() == (cloudButton)) {
			itemFound(cloudButton, checkMe24);
		}
		if (e.getSource() == (chickenButton)) {
			itemFound(chickenButton, checkMe25);
		}
		if (e.getSource() == (earthButton)) {
			itemFound(earthButton, checkMe26);
		}
		if (e.getSource() == (cactusButton)) {
			itemFound(cactusButton, checkMe27);
		}
		
		if (checkFoundAll2()) {
			timer.stop();
			JOptionPane.showMessageDialog(null, "Congratulations! You found all the pictures! \n You finished the puzzle in: " + time + " seconds.");
			System.exit(0);
		}
	}

	private boolean checkFoundAll() {
		return checkMe == true && checkMe2 == true && checkMe3 == true && checkMe4 == true && checkMe5 == true
				&& checkMe6 == true && checkMe7 == true;
	}
	
	private boolean checkFoundAll2() {
		return checkMe21 == true && checkMe22 == true && checkMe23 == true && checkMe24 == true && checkMe25 == true
				&& checkMe26 == true && checkMe27 == true; 
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		time += 1;
		bar.showTime(time);
	}

}