package com.java.ee.homewokr3;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class DownloadFileManager implements DownloadFileManagerMBean {
    public String urlq = "https://pbs.twimg.com/profile_images/426420605945004032/K85ZWV2F_400x400.png";
    private String fileName = "D:\\files\\1.png";

    @Override
    public String getUrl() {
        return urlq;
    }

    @Override
    public void setUrl(String url) {
        this.urlq = url;
    }

    @Override
    public void downloadFile() throws IOException {
        URL url = null;
        try {
            url = new URL(getUrl());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(url.openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {

            byte[] buffer = new byte[1024];
            int count = 0;
            while ((count = bufferedInputStream.read(buffer, 0, 1024)) != -1) {
                fileOutputStream.write(buffer, 0, count);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private Properties loadProperties() {
        Properties properties = new Properties();
        InputStream inputStream = getClass().getResourceAsStream("hm3.properties");
        System.out.println(inputStream);
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
