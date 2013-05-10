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
	private final int xScale = 1;
	private final int yScale = 1;
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
		for(int j = 1; j<40;j++){
			int R = (int) (Math.random( )*256);
			int G = (int)(Math.random( )*256);
			int B= (int)(Math.random( )*256);
			g.setColor(new Color(R, G, B));
			int x1 = 0;
			int y1 = 0;
			int z1 = 0;
			for(int i = 1;i<MAX_X/xScale;i++){
				int x2 = i*xScale;
				g.drawLine((i-1)*xScale+MIN_X, MAX_Y-(i-1)/yScale, i*xScale+MIN_X, MAX_Y-i/yScale);
				g.drawLine((i-1)*xScale+MIN_X, MAX_Y-(int)Math.pow((i-1)*yScale,2), i*xScale+MIN_X, MAX_Y-(int)Math.pow(i*yScale,2));

				int y2 = Sort.quicksort(Student.StudentAr(x2))/yScale;
				g.drawLine(x1+MIN_X,MAX_Y-y1,x2+MIN_X,MAX_Y-y2);
				x1=x2;
				y1=y2;
			}
		}
	}
}
