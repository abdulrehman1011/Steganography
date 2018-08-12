/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStoneWall.Utility;

import java.awt.image.BufferedImage;
import DataStoneWall.Steganography.HaarTransform;

/**
 *
 * @author AbdulRehman
 */
public class TransformImage {

    public static BufferedImage TransformNormalImage(BufferedImage image, String ext) {
        HaarTransform haarTransformer = new HaarTransform();
        haarTransformer.fileExt = ext;
        haarTransformer.loadImage(image);
        BufferedImage transformImage = haarTransformer.generateTransformImg(image);
        return transformImage;
    }
}
