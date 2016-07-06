import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.awt.*;

public class Playground extends Canvas implements DotMatrix,MouseListener{
	public int scale=5;
	
	private ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();
	
	@Override
	public void addCell(int x, int y) 
	{		
		Rectangle rectangle = new Rectangle(x,y,scale,scale);
		rectangles.add(rectangle);
		System.out.println("Zelle hinzugefügt X:" + x + "Y:" + y);
		repaint();
	}
	@Override
	public void removeCell(int x, int y) 
	{

		Rectangle rectangle = new Rectangle(x,y,scale,scale);
		rectangles.remove(rectangle);

		repaint();
	}
	public boolean getCell(int x, int y)
	{
		return rectangles.contains(new Rectangle(x,y,scale,scale));
	}
	public void paint(Graphics g)				//Zeichnet alles
	{
		//super.paint(g);
		
		int h = getHeight();
		int w = getWidth();
		int i =0;

		for(int j=0; j<rectangles.size();j++)
		{
			g.fillRect((rectangles.get(j).x-1)*scale, (rectangles.get(j).y-1)*scale, scale, scale);
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

}
