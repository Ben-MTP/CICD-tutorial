package com.msoft.core.utils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author ManhKM on 2/2/2023
 * @project cicd-tutorial
 * <p>
 * Những hàm hỗ trợ kiểm tra OS
 */
public class OSUtils {

    public static boolean isWindows() {

        return System.getProperty("os.name").toLowerCase().startsWith("windows");
    }

    public static String getHomeDirectory() {
        return System.getProperty("user.home");
    }

    /**
     * Hàm xử lý việc thực thi command basic
     *
     * @return
     */
    public static String runtimeExecute(String script) {
        Process process = null;
        if (isWindows()) {
            try {
                process = Runtime.getRuntime()
                        .exec(script);
            } catch (IOException e) {
                e.printStackTrace();
                return "NOT OKAY";
            }
        } else {
            try {
                process = Runtime.getRuntime()
                        .exec(script);
            } catch (IOException e) {
                e.printStackTrace();
                return "NOT OKAY";
            }
        }
        StreamGobbler streamGobbler =
                new StreamGobbler(process.getInputStream(), System.out::println);
        Future<?> future = Executors.newSingleThreadExecutor().submit(streamGobbler);

        int exitCode = 0;
        try {
            exitCode = process.waitFor();
            assert exitCode == 0;
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return "NOT OKAY";
        }
        return "Running(runtimeExecute) DONE with command: " + script;
    }

    public static String processBuilderExecute(String[] script) {
        ProcessBuilder builder = new ProcessBuilder();
        if (isWindows()) {
            builder.command(script);
        } else {
            builder.command(script);
        }
        builder.directory(new File(getHomeDirectory()));
        try {
            Process process = builder.start();
            StreamGobbler streamGobbler = new StreamGobbler(process.getInputStream(),
                    System.out::println);
            Future<?> future = Executors.newSingleThreadExecutor().submit(streamGobbler);
            int exitCode = process.waitFor();
            assert exitCode == 0;
            future.get(10, TimeUnit.SECONDS);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "NOT OKAY";
        } catch (ExecutionException e) {
            e.printStackTrace();
            return "NOT OKAY";
        } catch (TimeoutException e) {
            e.printStackTrace();
            return "NOT OKAY";
        }
        return "Running(processBuilderExecute) DONE with command: " + script.toString();

    }

    public static void main(String[] args) {
        System.out.println("isWindows: " + isWindows());
        String homeDirectory = getHomeDirectory();
        System.out.println("Home Directory: " + homeDirectory);
        String script = "cmd.exe /c dir %s";
//        String[] scripts = {"cmd.exe", "/c", "dir"};
        String[] scripts = {"notepad"};
//        String script = "notepad";
//        String result = runtimeExecute(String.format(script, homeDirectory));
        String result = processBuilderExecute(scripts);
        System.out.println("Result Execution: " + result);
    }
}
