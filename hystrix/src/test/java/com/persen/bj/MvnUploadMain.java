package com.persen.bj;

import java.io.*;

/**
 * Created by lijianyu on 2018/12/14.
 */
public class MvnUploadMain {
    private static final String MVN_STR = "" +
            "mvn deploy:deploy-file -Dpackaging=jar " +
            "-Durl=http://127.0.0.1:8080/repository/release " +
            "-DrepositoryId=pingxin-release";

    public static void main(String[] args) {
        try {
            upload();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void upload() throws IOException {
        String file = "/Users/persenlee/tmp/px/xx.log";
        FileReader fr = new FileReader(file);
        BufferedReader bf = new BufferedReader(fr);
        String str;
        // 按行读取字符串
        while ((str = bf.readLine()) != null) {
            if (str.indexOf("SNAPSHOT") > 0) {
                continue;
            }
            String cmdStr = parse(str);
            System.out.println(cmdStr);
//            Process process = Runtime.getRuntime().exec(cmdStr);
//
//            try {
//                process.waitFor();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        bf.close();
        fr.close();

    }

    private static String parse(String line) {
        String groupId = null;
        String artifactId = null;
        String version = null;
        String path = null;
        String file = null;

        StringBuilder builder = new StringBuilder(MVN_STR);
        String strs[] = line.split("/");
        int length = strs.length;
        file = strs[length - 1];
        version = strs[length - 2];
        artifactId = strs[length - 3];

        StringBuilder groupBuilder = new StringBuilder("cn.");
        StringBuilder pathBuilder = new StringBuilder("/Users/persenlee/tmp/");
        pathBuilder.append(line);
        for (int i = 0; i < length - 3; i++) {
            groupBuilder.append(strs[i]);
            if (i != length - 4) {
                groupBuilder.append('.');
            }

        }
        groupId = groupBuilder.toString();
        path = pathBuilder.toString();

        builder.append(" -DgroupId=").append(groupId);
        builder.append(" -DartifactId=").append(artifactId);
        builder.append(" -Dversion=").append(version);
        builder.append(" -Dfile=").append(path);
        return builder.toString();
    }
}
