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
	
	public static void createImage(String loadFile, String saveFile, int zoom) throws IOException {	

		File save = new File(saveFile);
		RenderedOp rOp = JAI.create("fileload", loadFile);
		BufferedImage im = rOp.getAsBufferedImage();
		if(zoom <= 0) zoom = 1;
		int width = im.getWidth();
		int height = im.getHeight();
		if (width <= 500 || height <= 500){
			width = im.getWidth();
		 	height = im.getHeight();
		} else {
			width = 500;
			height = 500;
		}
		BufferedImage thumb = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = thumb.createGraphics();						
		g2.drawImage(im, 0, 0, width, height, null);						
		ImageIO.write(thumb, "jpg", save);

	}

}