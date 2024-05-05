package com.sd.constants;

import com.sd.enums.ConfigProperties;
import com.sd.utils.PropertyUtils;

public final class FrameworkConstants {

    private FrameworkConstants(){}
    private static final String CHROMEDRIVERPATH = System.getProperty("user.dir")+"/src/test/resources/executables/chromedriver.exe";
    private static final String CONFIGFILEPATH = System.getProperty("user.dir")+"/src/test/resources/config/config.properties";
    private static final String CONFIGJSONFILEPATH = System.getProperty("user.dir")+"/src/test/resources/config/config.json";
    private static final String EXCELPATH = System.getProperty("user.dir")+"/src/test/resources/excel/testdata.xlsx";
    private static final String EXTENTREPORTFOLFERTPATH = System.getProperty("user.dir")+"/extent-test-output/";
    private static final String RUNMANAGERSHEET = "RunnerManager";
    private static final String DATASHEET = "Data";
    private static final int EXPLICITWAIT = 10;
    private static  String extentReportFilePath ="";

    public static String getRunmanagerSheet(){
        return RUNMANAGERSHEET;
    }
    public static String getDataSheet(){
        return DATASHEET;
    }

    public static String getExtentReportFilePath() throws Exception {
        if (extentReportFilePath.isEmpty()){
                extentReportFilePath = createReportPath();
        }
        return extentReportFilePath;
    }
    public static String getExcelpath(){
        return EXCELPATH;
    }
    private static String createReportPath() throws Exception {
        if (PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")){
            return EXTENTREPORTFOLFERTPATH+System.currentTimeMillis()+"/index.html";
        }
        return EXTENTREPORTFOLFERTPATH+"/index.html";
    }


    public static String getConfigjsonfilepath(){
        return CONFIGJSONFILEPATH;
    }

    public static int getExplicitwait(){
        return EXPLICITWAIT;
    }


    public static String getConfigfilepath(){
        return CONFIGFILEPATH;
    }
    public static String getChromeDriverPath(){
        return CHROMEDRIVERPATH;
    }
}
