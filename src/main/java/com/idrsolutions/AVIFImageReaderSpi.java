package com.idrsolutions;

import com.idrsolutions.image.ImageFormat;
import com.idrsolutions.image.ImageTypeFinder;
import java.io.IOException;
import java.util.Locale;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class AVIFImageReaderSpi extends JDeliImageReaderSpi {

    private static final String[] names = {"AVIF"};
    private static final String[] suffixes = {"avif"};
    private static final String[] MIMETypes = {"image/avif"};

    public AVIFImageReaderSpi () {

        super(names, suffixes, MIMETypes);
    }

    @Override
    public String getDescription(final Locale locale) {
        return "AVIF JDeli Image Reader";
    }

    @Override
    public boolean canDecodeInput(final Object source) throws IOException {
        if(isRegistered()) {
            final ImageInputStream input = (ImageInputStream) source;
            final byte[] b = new byte[140];
            input.read(b);

            return ImageTypeFinder.getImageType(b).equals(ImageFormat.AVIF_IMAGE);
        } else {
            return false;
        }
    }

    @Override
    public ImageReader createReaderInstance() throws IOException {
        return createReaderInstance("avif");
    }
}
