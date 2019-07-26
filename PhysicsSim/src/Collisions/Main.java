package Collisions;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main extends JPanel implements Runnable, KeyListener, MouseWheelListener {

	private static final String title = "Collision Simulation";
	public static final double WIDTH = 1280;
	public static final double HEIGHT = 720;
	public static final int NUM = 20;
	public static Ball[] balls = new Ball[NUM];
	public static void main(String[] args) {

		JFrame frame = new JFrame();
		frame.setSize((int)WIDTH, (int)HEIGHT);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		frame.add(new Main(), BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle(title);
		frame.setVisible(true);
	}

	private boolean isRunning = false;
	private Thread thread;

	public Main() {

		setFocusable(true);
		for(int i = 0; i < balls.length; i++){
			balls[i] = new Ball(640, 360, 50);
		}
		start();
	}

	public void start() {

		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}

	public void run() {

		long start, elapsed, wait;
		while (isRunning) {
			start = System.nanoTime();
			tick();
			repaint();

			elapsed = System.nanoTime() - start;
			wait = (100 / 6) - elapsed / 1000000;
			if (wait <= 0)
				wait = 5;;
			try {
				Thread.sleep(wait);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void tick() {
		for(int i = 0; i < balls.length; i++){
			balls[i].setX(balls[i].getX() + balls[i].getDx());
			balls[i].setY(balls[i].getY() + balls[i].getDy());
			if(balls[i].getX() <= 0 || balls[i].getX() >= WIDTH - balls[i].getRadius()) balls[i].setDx(balls[i].getDx() * - 1);
			if(balls[i].getY() <= 0|| balls[i].getY() >= HEIGHT - 75) balls[i].setDy(balls[i].getDy() * - 1);
		}
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, (int)WIDTH, (int)HEIGHT);
		for(int i = 0; i < balls.length; i++){
			balls[i].draw(g);
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {

	}

	public void keyReleased(KeyEvent e) {
	}

	public void mouseWheelMoved(MouseWheelEvent e) {
	}
}