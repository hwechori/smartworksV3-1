/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 12. 12.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.media.jai.JAI;
import javax.media.jai.RenderedOp;

public class Thumbnail {

	public Thumbnail() {}
	
	public static void createImage(String loadFile, String saveFile, String sizeType, String extension) throws IOException {	

		File save = new File(saveFile);
		RenderedOp rOp = JAI.create("fileload", loadFile);
		BufferedImage im = rOp.getAsBufferedImage();
		int width;
		int height;
		if(sizeType.equals("big")) {
			width = 110;
			height = 110;
		} else {
			width = 48;
			height = 48;
		}
		BufferedImage thumb = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = thumb.createGraphics();						
		g2.drawImage(im, 0, 0, width, height, null);						
		ImageIO.write(thumb, extension, save);

	}

}