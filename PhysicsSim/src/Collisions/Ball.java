package Collisions;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Ball {
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public int getDy() {
		return dy;
	}
	public void setDy(int dy) {
		this.dy = dy;
	}
	public int getDx() {
		return dx;
	}
	public void setDx(int dx) {
		this.dx = dx;
	}
	int x, y, radius;
	int dy;
	int dx;
	public Ball(int x, int y, int radius){
		this.x = x;
		this.y = y;
		dx = (int)(Math.random() * 5 + 1);
		dy = (int)(Math.random() * 5 + 1);
		this.radius = radius;
	}
	public void draw(Graphics g){
		g.setColor(Color.BLACK);
		
		g.fillOval(x, y, radius, radius);
	}
}
