package b2k.help;



import java.awt.Component;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JComponent;


public class MyEffectManager
{

    public MyEffectManager()
    {
    }

    public static Window getWindow(Component component)
    {
        for(java.awt.Container container = component.getParent(); container != null; container = container.getParent())
            if(container instanceof Window)
                return (Window)container;

        return null;
    }

    public static void setComponent(Component component)
    {
        if(num == 30)
            num = 0;
        else
            num++;
    }

    public static Point getPoint(JComponent jcomponent, JComponent jcomponent1)
    {
        Point point = jcomponent.getLocationOnScreen();
        if(GraphicsEnvironment.isHeadless())
            return point;
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        GraphicsConfiguration graphicsconfiguration = null;
        GraphicsEnvironment graphicsenvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice agraphicsdevice[] = graphicsenvironment.getScreenDevices();
        for(int i = 0; i < agraphicsdevice.length; i++)
        {
            if(agraphicsdevice[i].getType() != 0)
                continue;
            GraphicsConfiguration graphicsconfiguration1 = agraphicsdevice[i].getDefaultConfiguration();
            if(!graphicsconfiguration1.getBounds().contains(point))
                continue;
            graphicsconfiguration = graphicsconfiguration1;
            break;
        }

        if(graphicsconfiguration == null)
            graphicsconfiguration = jcomponent.getGraphicsConfiguration();
        Rectangle rectangle;
        Insets insets;
        if(graphicsconfiguration != null)
        {
            insets = toolkit.getScreenInsets(graphicsconfiguration);
            rectangle = graphicsconfiguration.getBounds();
        } else
        {
            insets = new Insets(0, 0, 0, 0);
            rectangle = new Rectangle(toolkit.getScreenSize());
        }
        int j = rectangle.width - Math.abs(insets.left + insets.right);
        int k = rectangle.height - Math.abs(insets.top + insets.bottom);
        Dimension dimension = jcomponent1.getPreferredSize();
        if(point.x + dimension.width > rectangle.x + j)
            point.x = (rectangle.x + j) - dimension.width;
        if(point.y + jcomponent.getHeight() + dimension.height > rectangle.y + k)
            point.y = point.y - dimension.height;
        else
            point.y = point.y + jcomponent.getHeight();
        if(point.x < rectangle.x)
            point.x = rectangle.x;
        if(point.y < rectangle.y)
            point.y = rectangle.y;
        return point;
    }

//    private static at fldif = new at();
    private static int num = 10;

}
