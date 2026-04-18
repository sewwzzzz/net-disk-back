package com.netdisk.utils;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.math.BigDecimal;

public class ScaleFilter {
    private static final Logger logger = LoggerFactory.getLogger(ScaleFilter.class);


    public static Boolean createThumbnailWidthFFmpeg(File file, int thumbnailWidth, File targetFile, Boolean delSource, String ffmpegPath) {
        try {
            BufferedImage src = ImageIO.read(file);
            //thumbnailWidth 缩略图的宽度   thumbnailHeight 缩略图的高度
            int sorceW = src.getWidth();
            int sorceH = src.getHeight();
            //小于 指定高宽不压缩
            if (sorceW <= thumbnailWidth) {
                return false;
            }
            compressImage(file, thumbnailWidth, targetFile, delSource, ffmpegPath);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void compressImageWidthPercentage(File sourceFile, BigDecimal widthPercentage, File targetFile, String ffmpegPath) {
        try {
            BigDecimal widthResult = widthPercentage.multiply(new BigDecimal(ImageIO.read(sourceFile).getWidth()));
            compressImage(sourceFile, widthResult.intValue(), targetFile, true, ffmpegPath);
        } catch (Exception e) {
            logger.error("压缩图片失败");
        }
    }

    public static void createCover4Video(File sourceFile, Integer width, File targetFile, String ffmpegPath) {
        try {
            String ffmpeg = StringTools.isEmpty(ffmpegPath) ? "ffmpeg" : ffmpegPath + "/ffmpeg";
            String cmd = ffmpeg + " -i \"%s\" -y -vframes 1 -vf scale=%d:%d/a \"%s\"";
            ProcessUtils.executeCommand(String.format(cmd, sourceFile.getAbsoluteFile(), width, width, targetFile.getAbsoluteFile()), false);
        } catch (Exception e) {
            logger.error("生成视频封面失败", e);
        }
    }

    public static void compressImage(File sourceFile, Integer width, File targetFile, Boolean delSource, String ffmpegPath) {
        try {
            String ffmpeg = StringTools.isEmpty(ffmpegPath) ? "ffmpeg" : ffmpegPath + "/ffmpeg";
            String cmd = ffmpeg + " -i \"%s\" -vf scale=%d:-1 \"%s\" -y";
            ProcessUtils.executeCommand(String.format(cmd, sourceFile.getAbsoluteFile(), width, targetFile.getAbsoluteFile()), false);
            if (delSource) {
                FileUtils.forceDelete(sourceFile);
            }
        } catch (Exception e) {
            logger.error("压缩图片失败");
        }
    }

    public static void main(String[] args) {
        // 测试压缩图片和生成视频封面
        compressImageWidthPercentage(new File("C:\\Users\\11929\\Pictures\\avatar.jpg"), new BigDecimal(0.7),
                new File("C:\\Users\\11929\\Pictures\\avatar-cp.jpg"), "D:\\ffmpeg\\ffmpeg-2026-03-15-git-6ba0b59d8b-full_build\\bin");
        createCover4Video(new File("C:\\Users\\11929\\Videos\\2026-04-18-13-09.mp4"), 200, new File("C:\\Users\\11929\\Videos\\2026-04-18-13-09-cp.jpg"), "D:\\ffmpeg\\ffmpeg-2026-03-15-git-6ba0b59d8b-full_build\\bin");
    }
}