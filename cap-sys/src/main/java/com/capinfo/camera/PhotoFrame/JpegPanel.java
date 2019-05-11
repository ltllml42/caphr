package PhotoFrame;

import java.awt.Graphics;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

public class JpegPanel extends javax.swing.JPanel {

	public static final long serialVersionUID = 1L;
	public  BufferedImage image1;
	public  int nType; //jpeg 为1   plate车牌为2

	public JpegPanel()
	{
		setBackground(new java.awt.Color(51, 51, 51));
	}

	public void RefreshImage(byte[] Image, int iType)
	{
		try
		{
			nType = iType;
			//将Bytes数组转为Image：}
			image1 = ImageIO.read(new ByteArrayInputStream(Image));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}



	@Override
	public void paintComponent(Graphics g1)
	{
		int x = 0;
		int y = 0;
		Graphics g = (Graphics) g1;

		super.paintComponent(g1);
		if (null == image1)
		{
			//System.out.println("image1 == null");
			return;
		}

		if (nType == 1 )
		{
			//g.drawRect(x, y, 423, 367);
			//g.drawImage(image1, x, y, 423, 367/*image1.getWidth(this), image1.getHeight(this)*/, this);
			g.drawRect(x, y, 380, 310);
			g.drawImage(image1, x, y, 380, 310/*image1.getWidth(this), image1.getHeight(this)*/, this);
			g = null;
		}
		else
		{
			g.drawRect(x, y, 165, 45);
			g.drawImage(image1, x, y, 165, 45/*image1.getWidth(this), image1.getHeight(this)*/, this);
			g = null;
		}
	}
}

