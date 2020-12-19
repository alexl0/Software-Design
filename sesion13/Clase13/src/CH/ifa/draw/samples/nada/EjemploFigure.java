package CH.ifa.draw.samples.nada;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Vector;

import CH.ifa.draw.standard.AbstractFigure;

public class EjemploFigure extends AbstractFigure {
	
	private Point point;

	public void draw(Graphics g) { 
		g.setColor(java.awt.Color.BLUE); 
		g.fillRect((int)point.getX(),(int)point.getY(),100,100);
	} 
	public Rectangle displayBox() { 
		return new Rectangle((int)point.getX(),(int)point.getY(),100,100);
	}
	public Vector handles() { 
		return new Vector();
	}

	public EjemploFigure(Point point) {
		this.point=point;
	}

	@Override
	protected void basicMoveBy(int dx, int dy) {
		// TODO Auto-generated method stub

	}

	@Override
	public void basicDisplayBox(Point origin, Point corner) {
		// TODO Auto-generated method stub

	}


}
