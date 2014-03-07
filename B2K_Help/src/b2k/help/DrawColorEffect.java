package b2k.help;



import java.awt.Color;
import java.awt.GradientPaint;

import javax.swing.ImageIcon;

public class DrawColorEffect
{

    public DrawColorEffect()
    {
        this(new Color(205, 205, 225), new Color(245, 245, 255), 0, 1);
    }

    public DrawColorEffect(Color color, Color color1, int i, int j)
    {
        num1 = 0;
        num2 = 1;
        num3 = 50;
        num4 = 0;
        float1 = 1.0F;
        num5 = 0;
        c1 = color;
        c2 = color1;
        num1 = i;
        num2 = j;
    }

    public Color getColor1()
    {
        return c1;
    }

    public void setColor1(Color color)
    {
        c1 = color;
    }

    public Color getColor2()
    {
        return c2;
    }

    public void setColo2(Color color)
    {
        c2 = color;
    }

    public int getNum1()
    {
        return num1;
    }

    public void setNum1(int i)
    {
        num1 = i >= 0 && i <= 3 ? i : 0;
    }

    public int getNum2()
    {
        return num2;
    }

    public void setNum2(int i)
    {
        num2 = i >= 1 ? i : num2;
    }

    public void createIcon(ImageIcon imageicon, int i, float f)
    {
        img1 = imageicon;
        num4 = i;
        float1 = f;
    }

    public void setImage1(ImageIcon imageicon)
    {
        img1 = imageicon;
    }

    public ImageIcon getImage1()
    {
        return img1;
    }

    public void setFloat1(float f)
    {
        if(f < 0.0F || f > 1.0F)
        {
            throw new IllegalArgumentException("Alpha: " + f + " Must be between 0.0f and 1.0f.");
        } else
        {
            float1 = f;
            return;
        }
    }

    public float getFloat1()
    {
        return float1;
    }

    public void setNum4(int i)
    {
        num4 = i;
    }

    public int getNum4()
    {
        return num4;
    }

    public int setNum3()
    {
        return num3;
    }

    public void setNum3(int i)
    {
        if(i >= 0 && i <= 100)
            num3 = i;
    }

    public void setGP1(GradientPaint gradientpaint)
    {
        if(gradientpaint != null)
            gp1 = gradientpaint;
    }

    public GradientPaint getGP1()
    {
        return gp1;
    }

    public int getNum5()
    {
        return num5;
    }

    public void setNum5(int i)
    {
        num5 = i;
    }

    private Color c1;
    private Color c2;
    private int num1;
    private int num2;
    private int num3;
    private GradientPaint gp1;
    private ImageIcon img1;
    private int num4;
    private float float1;
    public static final int NUM0 = 0;
    public static final int NUM1 = 1;
    public static final int NUM2 = 2;
    private int num5;
}
