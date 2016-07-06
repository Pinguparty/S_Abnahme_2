import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.awt.*;

public class Playground extends Canvas implements DotMatrix,MouseListener{
	public int scale=5;
	
	private ArrayList<Point> points = new ArrayList<Point>();
	
	@Override
	public void addCell(int x, int y) 
	{		
		Point point = new Point(x,y);
		points.add(point);
		System.out.println("Zelle hinzugefügt X:" + x + "Y:" + y);
		repaint();
	}
	@Override
	public void removeCell(int x, int y) 
	{

		Point point = new Point(x,y);
		if (points.remove(point) == true){
			System.out.println("Zelle entfernt");
		}
		else
		{
			System.out.println("removeCell aufgerufen");
		}
		
		repaint();
	}
	public boolean getCell(int x, int y)
	{
		return points.contains(new Point(x,y));
	}
	public void paint(Graphics g)				//Zeichnet alles
	{
		//super.paint(g);
		
		int h = getHeight();
		int w = getWidth();
		int i =0;

		for(int j=0; j<points.size();j++)
		{
			g.fillRect((points.get(j).x-1)*scale, (points.get(j).y-1)*scale, scale, scale);
		}
		
		while(i<h)
		{
			g.drawLine(0,i,getWidth(),i);
			i+=scale;
		}
		i=0;
		while(i<w)
		{
			g.drawLine(i, 0, i, getHeight());
			i+=scale;
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Du hast geklickt!!! x: " + e.getX() + " y: " + e.getY());
		Point point = new Point((e.getX()/scale)+1,(e.getY()/scale)+1);
		if(getCell(point.x,point.y) == true)
		{
			removeCell(point.x,point.y);
		}
		else
		{
			addCell(point.x,point.y);
		}
	}



	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println();
	}



	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
