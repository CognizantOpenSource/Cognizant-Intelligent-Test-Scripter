/*
 * Copyright 2014 - 2017 Cognizant Technology Solutions
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cognizant.cognizantits.ide.main.shr.mobile.android;

import com.cognizant.cognizantits.ide.main.shr.mobile.MobileUtil;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * 
 */
public class AndroidUtil extends MobileUtil {

    private static AndroidUtil androidUtil;

    public static AndroidUtil get() {
        if (androidUtil == null) {
            androidUtil = new AndroidUtil();
        }
        return androidUtil;
    }

    public void rotateScreenshot(File screenShotFile) {
        try {
            BufferedImage img = ImageIO.read(screenShotFile);
            BufferedImage target;
            switch (AndroidTree.get().getRotation()) {
                case "1":
                    target = rotate(img, Math.toRadians(90), 0);
                    target = rotate(target, Math.toRadians(180), 90);
                    break;
                case "2":
                    target = rotate(img, Math.toRadians(180), 90);
                    break;
                case "3":
                    target = rotate(img, Math.toRadians(90), 90);
                    target = rotate(target, Math.toRadians(180), 90);
                    target = rotate(target, Math.toRadians(180), 90);
                    break;
                default:
                    return;
            }
            if (target != null) {
                ImageIO.write(target, "png", screenShotFile);
            }
        } catch (IOException ex) {
            Logger.getLogger(AndroidUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Affine transform only works with perfect squares. The following code is
     * used to take any rectangle image and rotate it correctly. To do this it
     * chooses a center point that is half the greater length and tricks the
     * library to think the image is a perfect square, then it does the rotation
     * and tells the library where to find the correct top left point. The
     * special cases in each orientation happen when the extra image that
     * doesn't exist is either on the left or on top of the image being rotated.
     * In both cases the point is adjusted by the difference in the longer side
     * and the shorter side to get the point at the correct top left corner of
     * the image. NOTE: the x and y axes also rotate with the image so where
     * width > height the adjustments always happen on the y axis and where the
     * height > width the adjustments happen on the x axis.
     *
     */
    private BufferedImage rotate(BufferedImage image, double theta, int thetaInDegrees) {

        AffineTransform xform = new AffineTransform();

        if (image.getWidth() > image.getHeight()) {
            xform.setToTranslation(0.5 * image.getWidth(), 0.5 * image.getWidth());
            xform.rotate(theta);

            int diff = image.getWidth() - image.getHeight();

            switch (thetaInDegrees) {
                case 90:
                    xform.translate(-0.5 * image.getWidth(), -0.5 * image.getWidth() + diff);
                    break;
                case 180:
                    xform.translate(-0.5 * image.getWidth(), -0.5 * image.getWidth() + diff);
                    break;
                default:
                    xform.translate(-0.5 * image.getWidth(), -0.5 * image.getWidth());
                    break;
            }
        } else if (image.getHeight() > image.getWidth()) {
            xform.setToTranslation(0.5 * image.getHeight(), 0.5 * image.getHeight());
            xform.rotate(theta);

            int diff = image.getHeight() - image.getWidth();

            switch (thetaInDegrees) {
                case 180:
                    xform.translate(-0.5 * image.getHeight() + diff, -0.5 * image.getHeight());
                    break;
                case 270:
                    xform.translate(-0.5 * image.getHeight() + diff, -0.5 * image.getHeight());
                    break;
                default:
                    xform.translate(-0.5 * image.getHeight(), -0.5 * image.getHeight());
                    break;
            }
        } else {
            xform.setToTranslation(0.5 * image.getWidth(), 0.5 * image.getHeight());
            xform.rotate(theta);
            xform.translate(-0.5 * image.getHeight(), -0.5 * image.getWidth());
        }

        AffineTransformOp op = new AffineTransformOp(xform, AffineTransformOp.TYPE_BILINEAR);

        return op.filter(image, null);
    }

}
