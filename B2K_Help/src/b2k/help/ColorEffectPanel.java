package b2k.help;


import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class ColorEffectPanel extends JPanel
//    implements NumInterface
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ColorEffectPanel(Color color, Color color1, int i, int j)
    {
        drawColorEffect = new DrawColorEffect();
        drawColorEffect.setColor1(color);
        drawColorEffect.setColo2(color1);
        drawColorEffect.setNum1(i);
        drawColorEffect.setNum2(j);
        drawColorEffect.setNum5(0);
        edit();
    }

    public ColorEffectPanel(Color color, Color color1, int i)
    {
        this(color, color1, i, 1);
    }

    public ColorEffectPanel(Color color, Color color1)
    {
        this(color, color1, 0, 1);
    }

    public ColorEffectPanel()
    {
        this(new Color(200, 200, 220), new Color(245, 245, 255), 0, 1);
    }

    private void edit()
    {
        setOpaque(true);
        setDoubleBuffered(true);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D graphics2d = (Graphics2D)g;
        graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Insets insets = getBorder() != null ? getBorder().getBorderInsets(this) : getInsets();
        int i = insets.left;
        int j = insets.right;
        int k = insets.top;
        int l = insets.bottom;
        int i1 = getWidth() - i - j;
        int j1 = getHeight() - k - l;
        double d = 0.0D + (double)i1;
        double d1 = 0.0D + (double)j1;
        double d2 = Math.atan(d1 / d);
        double d3 = d * Math.sin(d2);
        double d4 = d3 * Math.sin(d2) * 2D;
        double d5 = d3 * Math.cos(d2) * 2D;
        Color color = drawColorEffect.getColor1();
        Color color1 = drawColorEffect.getColor2();
        int k1 = drawColorEffect.getNum2();
        int l1 = drawColorEffect.setNum3();
        if(drawColorEffect.getNum5() == 0)
        {
            if(drawColorEffect.getNum1() == 0)
                graphics2d.setPaint(new GradientPaint(i, k, color, i, k + j1 / k1, color1, true));
            else
            if(drawColorEffect.getNum1() == 1)
                graphics2d.setPaint(new GradientPaint(i, k, color, i + i1 / k1, k, color1, true));
            else
            if(drawColorEffect.getNum1() == 2)
                graphics2d.setPaint(new GradientPaint(new java.awt.geom.Point2D.Double(0.0D + (double)i, 0.0D + (double)k), color, new java.awt.geom.Point2D.Double(d4 / (double)k1 + (double)i, d5 / (double)k1 + (double)k), color1, true));
            else
            if(drawColorEffect.getNum1() == 3)
                graphics2d.setPaint(new GradientPaint(new java.awt.geom.Point2D.Double(0.0D + (double)i + (double)i1, 0.0D + (double)k), color, new java.awt.geom.Point2D.Double(-d4 / (double)k1 + (double)i + (double)i1, d5 / (double)k1 + (double)k), color1, true));
            graphics2d.fillRect(i, k, i1, j1);
        } else
        if(drawColorEffect.getNum5() == 1)
        {
            if(drawColorEffect.getNum1() == 0)
            {
                graphics2d.setPaint(new GradientPaint(i, k, color, i, k + (j1 * l1) / 100, color1, false));
                graphics2d.fillRect(i, k, i1, (j1 * l1) / 100);
                graphics2d.setPaint(new GradientPaint(i, k + (j1 * l1) / 100, color1, i, k + j1, color, false));
                graphics2d.fillRect(i, k + (j1 * l1) / 100, i1, j1 - (j1 * l1) / 100);
            } else
            if(drawColorEffect.getNum1() == 1)
            {
                graphics2d.setPaint(new GradientPaint(i, k, color, i + (i1 * l1) / 100, k, color1, false));
                graphics2d.fillRect(i, k, (i1 * l1) / 100, j1);
                graphics2d.setPaint(new GradientPaint(i + (i1 * l1) / 100, k, color1, i + i1, k, color, false));
                graphics2d.fillRect(i + (i1 * l1) / 100, k, i1 - (i1 * l1) / 100, j1);
            } else
            if(drawColorEffect.getNum1() == 2)
            {
                graphics2d.setPaint(new GradientPaint(new java.awt.geom.Point2D.Double(0.0D + (double)i, 0.0D + (double)k), color, new java.awt.geom.Point2D.Double(d4 / (double)k1 + (double)i, d5 / (double)k1 + (double)k), color1, true));
                graphics2d.fillRect(i, k, i1, j1);
            } else
            if(drawColorEffect.getNum1() == 3)
            {
                graphics2d.setPaint(new GradientPaint(new java.awt.geom.Point2D.Double(0.0D + (double)i + (double)i1, 0.0D + (double)k), color, new java.awt.geom.Point2D.Double(-d4 / (double)k1 + (double)i + (double)i1, d5 / (double)k1 + (double)k), color1, true));
                graphics2d.fillRect(i, k, i1, j1);
            }
        } else
        if(drawColorEffect.getNum5() == 2)
        {
            graphics2d.setPaint(drawColorEffect.getGP1());
            graphics2d.fillRect(i, k, i1, j1);
        }
        int i2 = drawColorEffect.getNum4();
        ImageIcon imageicon = drawColorEffect.getImage1();
        float f = drawColorEffect.getFloat1();
        if(imageicon != null)
        {
            java.awt.Composite composite = graphics2d.getComposite();
            AlphaComposite alphacomposite = AlphaComposite.getInstance(3, f);
            graphics2d.setComposite(alphacomposite);
            int j2 = imageicon.getIconWidth();
            int k2 = imageicon.getIconHeight();
            switch(i2)
            {
            default:
                break;

            case 0: // '\0'
                int l2 = i + (i1 - j2) / 2;
                int j5 = k + (j1 - k2) / 2;
                g.drawImage(imageicon.getImage(), l2, j5, this);
                break;

            case 1: // '\001'
                g.drawImage(imageicon.getImage(), i, k, i1, j1, this);
                break;

            case 2: // '\002'
                double d6 = (double)i1 / (double)j2;
                double d8 = (double)j1 / (double)k2;
                double d11 = Math.min(d6, d8);
                int i3 = i + (i1 - (int)((double)j2 * d11)) / 2;
                int k5 = k + (j1 - (int)((double)k2 * d11)) / 2;
                g.drawImage(imageicon.getImage(), i3, k5, (int)((double)j2 * d11), (int)((double)k2 * d11), this);
                break;

            case 3: // '\003'
                double d7 = (double)i1 / (double)j2;
                double d9 = (double)j1 / (double)k2;
                double d12 = Math.max(d7, d9);
                g.drawImage(imageicon.getImage(), i, k, (int)((double)j2 * d12), (int)((double)k2 * d12), this);
                break;

            case 4: // '\004'
                for(int l7 = k; l7 < j1; l7 += k2)
                {
                    for(int j8 = i; j8 < i1; j8 += j2)
                        g.drawImage(imageicon.getImage(), j8, l7, this);

                }

                break;

            case 5: // '\005'
                int i8 = 0;
                for(int k8 = k; k8 < j1; k8 += k2)
                {
                    for(int l8 = i - i8; l8 < i1; l8 += j2)
                        g.drawImage(imageicon.getImage(), l8, k8, this);

                    i8 = i8 != 0 ? 0 : j2 / 2;
                }

                break;

            case 6: // '\006'
                int j3 = i + (i1 - j2) / 2;
                int l5 = k;
                g.drawImage(imageicon.getImage(), j3, l5, this);
                break;

            case 7: // '\007'
                int k3 = i;
                int i6 = k + (j1 - k2) / 2;
                g.drawImage(imageicon.getImage(), k3, i6, this);
                break;

            case 8: // '\b'
                int l3 = (i + i1) - j2;
                int j6 = k + (j1 - k2) / 2;
                g.drawImage(imageicon.getImage(), l3, j6, this);
                break;

            case 9: // '\t'
                int i4 = i + (i1 - j2) / 2;
                int k6 = (k + j1) - k2;
                g.drawImage(imageicon.getImage(), i4, k6, this);
                break;

            case 10: // '\n'
                int j4 = i;
                int l6 = k;
                g.drawImage(imageicon.getImage(), j4, l6, this);
                break;

            case 11: // '\013'
                int k4 = (i + i1) - j2;
                int i7 = k;
                g.drawImage(imageicon.getImage(), k4, i7, this);
                break;

            case 12: // '\f'
                int l4 = i;
                int j7 = (k + j1) - k2;
                g.drawImage(imageicon.getImage(), l4, j7, this);
                break;

            case 13: // '\r'
                int i5 = (i + i1) - j2;
                int k7 = (k + j1) - k2;
                g.drawImage(imageicon.getImage(), i5, k7, this);
                break;
            }
            graphics2d.setComposite(composite);
        }
    }

    public void setImageIcon(ImageIcon imageicon, int i, float f)
    {
        drawColorEffect.setImage1(imageicon);
        drawColorEffect.setNum4(i);
        drawColorEffect.setFloat1(f);
        repaint();
    }

    public void setIcon1(ImageIcon imageicon)
    {
        drawColorEffect.setImage1(imageicon);
        repaint();
    }

    public ImageIcon getIcon1()
    {
        return drawColorEffect.getImage1();
    }

    public void setFloat1(float f)
    {
        drawColorEffect.setFloat1(f);
        repaint();
    }

    public float getFloat1()
    {
        return drawColorEffect.getFloat1();
    }

    public void setNum4(int i)
    {
        drawColorEffect.setNum4(i);
        repaint();
    }

    public int getNum4()
    {
        return drawColorEffect.getNum4();
    }

    public int getNum2()
    {
        return drawColorEffect.getNum2();
    }

    public void setNum2(int i)
    {
        drawColorEffect.setNum2(i);
        drawColorEffect.setNum5(0);
        repaint();
    }

    public Color getColor1()
    {
        return drawColorEffect.getColor1();
    }

    public void setColor1(Color color)
    {
        drawColorEffect.setColor1(color);
        repaint();
    }

    public Color getColor2()
    {
        return drawColorEffect.getColor2();
    }

    public void setColor2(Color color)
    {
        drawColorEffect.setColo2(color);
        repaint();
    }

    public int getNum1()
    {
        return drawColorEffect.getNum1();
    }

    public void setNum1(int i)
    {
        drawColorEffect.setNum1(i);
        drawColorEffect.setNum5(0);
        repaint();
    }

    public int getNum3()
    {
        return drawColorEffect.setNum3();
    }

    public void setNum3(int i)
    {
        if(i >= 0 && i <= 100)
        {
            drawColorEffect.setNum3(i);
            drawColorEffect.setNum5(1);
            repaint();
        }
    }

    public void setGradientpaint(GradientPaint gradientpaint)
    {
        drawColorEffect.setGP1(gradientpaint);
        if(gradientpaint != null)
        {
            drawColorEffect.setNum5(2);
            repaint();
        }
    }

    public DrawColorEffect getDrawColorEffect()
    {
        return drawColorEffect;
    }

    public void setDrawColorEffect(DrawColorEffect dce)
    {
        if(dce == null)
        {
            throw new IllegalArgumentException("DrawColorEffect must be not null.");
        } else
        {
            drawColorEffect = dce;
            return;
        }
    }

    public static final int num0 = 0;
    public static final int num1 = 1;
    public static final int num2 = 2;
    public static final int num3 = 3;
    public static final int num4 = 4;
    public static final int num5 = 5;
    public static final int num6 = 6;
    public static final int num7 = 7;
    public static final int num8 = 8;
    public static final int num9 = 9;
    public static final int num10 = 10;
    public static final int num11 = 11;
    public static final int num12 = 12;
    public static final int num13 = 13;
    private DrawColorEffect drawColorEffect;
}
