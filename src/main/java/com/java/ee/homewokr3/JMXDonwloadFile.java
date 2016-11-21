package com.java.ee.homewokr3;

import javax.management.*;
import java.io.IOException;
import java.lang.management.ManagementFactory;

public class JMXDonwloadFile {

    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException,
            InstanceAlreadyExistsException, MBeanRegistrationException, InterruptedException, IOException {

        MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();

        DownloadFileManagerMBean downloadFileManager = new DownloadFileManager();
        platformMBeanServer.registerMBean(downloadFileManager, new ObjectName("test:name=system_manager"));
        //Thread.sleep(Integer.MAX_VALUE);
    }
}
