import java.applet.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Grapher{

	public static void main(String[] args)
	{
		// Get everything going.

		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				GraphFrame frame = new GraphFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class GraphFrame extends JFrame
{

	public GraphFrame()
	{
		// Set parameters of the frame.
		setTitle("QuickSort Graph");
		setSize(3 * 400, 2 * 400);

		// Add component to frame
		GraphComponent component = new GraphComponent();
		add(component);
	}
}


class GraphComponent extends JComponent
{
	private final int xScale = 10;
	private final int yScale = 10;
	private final int size = 400;
	private final int MIN_X = 20;
	private final int MIN_Y = 20;

	public GraphComponent()
	{

	}


	public void paintComponent(Graphics g)
	{
		final int MAX_Y = this.getHeight()-MIN_Y;
		final int MAX_X = this.getWidth()-MIN_X;
		g.drawLine(MIN_X, MIN_Y, MIN_X, MAX_Y);
		g.drawLine(MIN_X, MAX_Y, MAX_X, MAX_Y);
		for(int i = 1;i+1<MAX_Y/10;i++){
			g.drawLine(MIN_X-5, (MAX_Y)-(10*i), MIN_X+5, (MAX_Y)-(10*i));
		}
		for(int i = 1;i+2<MAX_X/10;i++){
			g.drawLine((MAX_X)-(10*i),MAX_Y-5, (MAX_X)-(10*i), MAX_Y+5);
		}
		int x1 = 0;
		int y1 = 0;
		for(int i = 1;i<MAX_X;i++){
			int x2 = i*xScale;
			int y2 = Sort.quicksort(Student.StudentAr(x2))/10;
			g.drawLine(x1,y1,x2,y2);
			x1=x2;
			y1=y2;
		}
	}
}
