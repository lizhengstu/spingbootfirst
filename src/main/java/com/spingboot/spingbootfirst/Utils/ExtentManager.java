package com.spingboot.spingbootfirst.Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ExtentManager {
    //生成的路径以及文件名
    private static final String OUTPUT_FOLDER = "test-output/";
    private static final String FILE_NAME = "index5.html";
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }

    public static void createInstance() {
        //文件夹不存在的话进行创建
        File reportDir = new File(OUTPUT_FOLDER);
        if (!reportDir.exists() && !reportDir.isDirectory()) {
            reportDir.mkdir();
        }
        extent = new ExtentReports();
        extent.attachReporter(createSparkReporter(OUTPUT_FOLDER + FILE_NAME));
        //extent.setSystemInfo("os", "Linux");
        extent.setReportUsesManualConfiguration(true);
    }

    private static ExtentSparkReporter createSparkReporter(String filePath) {
        ExtentSparkReporter spark = new ExtentSparkReporter(filePath);
        spark.config(
                ExtentSparkReporterConfig.builder()
                        .theme(Theme.DARK)
                        .reportName("ISTP API自动化测试报告")
                        .documentTitle("ISTP API自动化测试报告")
                        .build());
        return spark;
    }
}
