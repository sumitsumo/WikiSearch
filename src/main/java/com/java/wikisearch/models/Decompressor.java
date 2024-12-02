package com.java.wikisearch.models;

import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;

import java.io.*;

public class Decompressor {
    public static void decompressBz2(String source, String dest) throws Exception
    {
        try (InputStream in = new BZip2CompressorInputStream(new FileInputStream(source));
             OutputStream out = new FileOutputStream(dest))
        {
            byte[] buffer = new byte[1024];
            int n;
            while ((n = in.read(buffer)) > 0) {
                out.write(buffer, 0, n);
            }
        }
    }
}