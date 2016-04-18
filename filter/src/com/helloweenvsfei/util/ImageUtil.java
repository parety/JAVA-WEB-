package com.helloweenvsfei.util;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ImageUtil {

	/**
	 * 
	 * @param imageData
	 *            JPG ͼ���ļ�
	 * @param waterMarkFile
	 *            ˮӡͼƬ
	 * @return ��ˮӡ���ͼ������
	 * @throws IOException
	 */
	public static byte[] waterMark(byte[] imageData, String waterMarkFile)
			throws IOException {

		// ˮӡͼƬ���ұ߾� �±߾�
		int paddingRight = 10;
		int paddingBottom = 10;

		// ԭʼͼ��
		Image image = new ImageIcon(imageData).getImage();
		int imageWidth = image.getWidth(null);
		int imageHeight = image.getHeight(null);

		// ˮӡͼƬ
		Image waterMark = ImageIO.read(new File(waterMarkFile));
		int waterMarkWidth = waterMark.getWidth(null);
		int waterMarkHeight = waterMark.getHeight(null);

		// ���ͼƬ�ߴ��С���򲻴�ˮӡ��ֱ�ӷ���
		if (imageWidth < waterMarkWidth + 2 * paddingRight
				|| imageHeight < waterMarkHeight + 2 * paddingBottom) {
			return imageData;
		}
		BufferedImage bufferedImage = new BufferedImage(imageWidth,
				imageHeight, BufferedImage.TYPE_INT_RGB);

		Graphics g = bufferedImage.createGraphics();

		// ����ԭʼͼ��
		g.drawImage(image, 0, 0, imageWidth, imageHeight, null);
		// ����ˮӡͼƬ
		g.drawImage(waterMark, imageWidth - waterMarkWidth - paddingRight,
				imageHeight - waterMarkHeight - paddingBottom, waterMarkWidth,
				waterMarkHeight, null);
		g.dispose();

		// ת��JPEG��ʽ
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		encoder.encode(bufferedImage);
		byte[] data = out.toByteArray();
		out.close();
		return data;
	}
}
