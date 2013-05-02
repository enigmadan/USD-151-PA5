import java.applet.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class grapher{
  private final int xScale = 10;          
	private final int yScale = 10;
	private final int size = 400;
	private final int MIN_X = 20;
	private final int MIN_Y = 20;

	public static void main(String[] args)
	{
		// Get everything going.

		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				TreeFrame frame = new TreeFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

	class TreeFrame extends JFrame
	{

		public TreeFrame()
		{
			// Set parameters of the frame.
			setTitle("QuickSort Graph");
			setSize(3 * size, 2 * size);

			// Add component to frame
			TreeComponent component = new TreeComponent();
			add(component);
		}
	}


	class TreeComponent extends JComponent
	{

		public TreeComponent()
		{

			p1 = new Point2D.Double(size, size + POSITION_TRUNK * size);
			p2 = new Point2D.Double(size, POSITION_TRUNK * size);
		}


		public void paintComponent(Graphics g)
		{
			final int MAX_Y = (this.getHeight()-MIN_Y);
			g.drawLine(20, 0, 20, 200);
			g.drawLine(20, 200, 200, 200);
			for(int i = 0;i<MAX_Y/10;i++){
				g.drawLine(MIN_X-5, MAX_Y/(10*i), MIN_X+5, MAX_Y/(10*i));
			}
		}
	}
}

