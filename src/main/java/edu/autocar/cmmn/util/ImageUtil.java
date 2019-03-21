package edu.autocar.cmmn.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class ImageUtil {
	public static byte[] thumb(byte[] data) throws Exception {
		return thumb(data, 100, 100);
	}

	public static byte[] thumb(byte[] data, int width, int height) throws Exception {
		try (ByteArrayInputStream in = new ByteArrayInputStream(data);
				ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			Thumbnails.of(in)
				.size(width, height)
				.crop(Positions.CENTER)
				.toOutputStream(out);
			return out.toByteArray();
		}
	}

	public static void thumb(File srcFile, File thumbFile) throws Exception {
		thumb(srcFile, thumbFile, 100, 100);
	}

	public static void thumb(File srcFile, File thumbFile, int width, int height) throws Exception {
		Thumbnails.of(srcFile)
			.size(width, height)
			.crop(Positions.CENTER)
			.outputFormat("jpg")
			.toFile(thumbFile);
	}
}
