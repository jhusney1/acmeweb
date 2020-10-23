package com.acme.statusmgr.beans;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class DiskStatus {
    long id;
    String contentHeader;
    //String diskCommand = "chkdsk c:";
    String diskCommandOutput;

    public DiskStatus(long id, String contentHeader) {

        this.id = id;
        this.contentHeader = contentHeader;

    }


    public long getId() {
        return id;
    }

    public String getContentHeader() {

        return contentHeader;
    }

    public String getDiskCommandOutput() {

        return diskCommandOutput;
    }


    public void checkDisk() {
        Runtime rt = Runtime.getRuntime();

        try {
            Process chkProcess = rt.exec(new String[]{"cmd","/C", "Dir", "/S", "C:\\*.java"});

            String result = new BufferedReader(new InputStreamReader(chkProcess.getInputStream())).lines().collect(Collectors.joining("\n"));
            this.diskCommandOutput = result;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
