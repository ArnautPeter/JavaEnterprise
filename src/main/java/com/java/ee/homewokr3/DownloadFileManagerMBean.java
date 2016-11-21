package com.java.ee.homewokr3;

import java.io.IOException;

public interface DownloadFileManagerMBean {
    String getUrl();

    void setUrl(String url);

    void downloadFile() throws IOException;
}
