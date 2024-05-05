package com.sd.listeners;

import com.sd.utils.DataProviderUtills;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotationTransformer implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
       annotation.setDataProvider("getData");
       annotation.setDataProviderClass(DataProviderUtills.class);
       annotation.setRetryAnalyzer(RetryFailedTests.class);
    }
}
