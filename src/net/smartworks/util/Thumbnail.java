/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 12. 12.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.media.jai.JAI;
import javax.media.jai.RenderedOp;

public class Thumbnail {

	public Thumbnail() {}
	
	public static void createImage(String loadFile, String saveFile, String sizeType, String extension) throws IOException {	

		File file = new File(saveFile);
		RenderedOp renderedOp = JAI.create("fileload", loadFile);
		BufferedImage bufferedImage = renderedOp.getAsBufferedImage();
		int width = 0;
		int height = 0;
		if(sizeType.equals("big")) {
			width = 110;
			height = 110;
		} else if(sizeType.equals("small")) {
			width = 48;
			height = 48;
		} else if(sizeType.equals("thumb")) {
			width = 200;
			height = 200;
		}
		BufferedImage thumb = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		thumb.createGraphics().drawImage(bufferedImage, 0, 0, width, height, null);
		ImageIO.write(thumb, extension, file);

/*		가로, 세로 사이즈 유지
 * 		Image image = bufferedImage.getScaledInstance(width, -1, Image.SCALE_SMOOTH);
		BufferedImage thumb = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
		thumb.getGraphics().drawImage(image, 0, 0, null);
		ImageIO.write(thumb, extension, save);
*
*/

	}

}