package com.sd.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.sd.constants.FrameworkConstants;
import com.sd.enums.AuthorType;
import com.sd.enums.CategoriesType;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {
    private ExtentReport() {
    }

    private static ExtentReports extent;
    public static   ExtentTest test;

    public static void initReports() throws Exception {
        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
            extent.attachReporter(spark);
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("Swag Test Report");
            spark.config().setReportName("Swag Test Report");
            spark.config().setReportName("Ankit Yadav");
        }
    }

    public static void flushReports() throws Exception {
        if (Objects.nonNull(extent)) {
            extent.flush();
        }
        ExtentManager.unload();
        Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
    }

    public static void createTest(String testcasename) {
         ExtentManager.setExtTest(extent.createTest(testcasename));
    }
    public static void addAuthors(AuthorType[] authors){
        for (AuthorType temp : authors){
            ExtentManager.getExtTest().assignAuthor(temp.toString());
        }
    }
    public static void addCategories(CategoriesType[] categories){
        for (CategoriesType temp : categories){
            ExtentManager.getExtTest().assignAuthor(temp.toString());
        }
    }
}
