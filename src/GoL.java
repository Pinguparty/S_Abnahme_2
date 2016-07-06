import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GoL extends Frame implements WindowListener
{
	public int scale=5;
	Playground grid;
	
	public GoL()
	{
		
		grid = new Playground();	
	

		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
		
		grid.addMouseListener(grid);
			
		setLayout(new BorderLayout());
			
	
		add(grid,BorderLayout.CENTER);
		
		//Ab hier Control Panel (SOUTH)
		
		Panel control = new Panel();
		control.setLayout(new GridLayout(3,2));
		add(control,BorderLayout.SOUTH);
		
		control.add(new Label("Skalierung: "));
		
		Scrollbar scalebar = new Scrollbar(Scrollbar.HORIZONTAL,5,1,1,50);
		scalebar.addAdjustmentListener(new AdjustmentListener()
		{
			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) 
			{
				grid.scale = scalebar.getValue();
				grid.repaint();
			}
		});
		scalebar.setSize(getWidth()/2, 100);
		control.add(scalebar);
		
		control.add(new Label("Geschwindigkeit: "));
		
		Scrollbar speed = new Scrollbar(Scrollbar.HORIZONTAL,5,1,1,50);
		scalebar.addAdjustmentListener(new AdjustmentListener()
		{
			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) 
			{
				//grid.speed = speed.getValue();
				//grid.repaint();
			}
		});
		speed.setSize(getWidth()/2, 100);
		control.add(speed);
		
		control.add(new Label());
		
		Button knopf = new Button("TEST");
		knopf.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				if(grid.getCell(15,15) == true)
				{
					grid.removeCell(15, 15);
				}
				else
				{
					grid.addCell(15,15);
				}
			}
		});
		control.add(knopf);
		
		//Fenster Sichtbar machen			
		setSize(500,500);
		setVisible(true);
	}



	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

