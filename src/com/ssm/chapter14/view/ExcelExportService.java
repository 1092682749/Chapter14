package com.ssm.chapter14.view;

import org.apache.poi.ss.usermodel.Workbook;

import java.util.Map;

public interface ExcelExportService {
    public void makeWorkBook(Map<String,Object> modle, Workbook workbook);
}
