/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStoneWall.Utility;

import java.awt.image.BufferedImage;
import org.apache.commons.io.FilenameUtils;
import DataStoneWall.Steganography.HaarTransform;

/**
 *
 * @author AbdulRehman
 */
public class RecoverImage {

    public static BufferedImage RecoverTransformImage(BufferedImage image, String ext) {
        HaarTransform haarTransformer = new HaarTransform();
        haarTransformer.fileExt = ext;
        haarTransformer.loadImage(image);
        BufferedImage recoverImage = haarTransformer.recoverTransformImage(image);
        return recoverImage;
    }

}
