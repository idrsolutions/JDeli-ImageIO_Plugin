package com.idrsolutions;

import com.idrsolutions.image.encoder.OutputFormat;
import java.io.IOException;
import java.util.Locale;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.ImageWriter;

public class AVIFImageWriterSpi extends JDeliImageWriterSpi {

    private static final String[] names = {"AVIF"};
    private static final String[] suffixes = {"avif"};
    private static final String[] MIMETypes = {"image/avif"};

    public AVIFImageWriterSpi () {
        super(names, suffixes, MIMETypes);
    }

    @Override
    public boolean canEncodeImage(final ImageTypeSpecifier imageType) {
        final int bands = imageType.getNumBands();
        return bands == 1 || bands == 2 || bands == 3 || bands == 4;
    }

    @Override
    public String getDescription(final Locale locale) {
        return "AVIF Image Writer";
    }

    @Override
    public ImageWriter createWriterInstance(final Object extension) throws IOException {
        return super.createWriterInstance(OutputFormat.AVIF);
    }

}
