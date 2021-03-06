package com.ssm.chapter14.view;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class ExcelView extends AbstractXlsView {
    private String fileName = null;
    private ExcelExportService excelExportService;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public ExcelExportService getExcelExportService() {
        return excelExportService;
    }

    public void setExcelExportService(ExcelExportService excelExportService) {
        this.excelExportService = excelExportService;
    }

    public ExcelView(ExcelExportService excelExportService) {
        this.excelExportService = excelExportService;
    }
    public  ExcelView(String viewName,ExcelExportService excelExportService)
    {
        this.setBeanName(viewName);
    }
    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (excelExportService == null)
        {
            throw new RuntimeException("导出服务接口不能为空");
        }
        if (StringUtils.isEmpty(fileName)){
            String reqCharset = request.getCharacterEncoding();
            reqCharset = reqCharset == null?"UTF-8":reqCharset;
            fileName = new String(fileName.getBytes(reqCharset),"ISO8859-1");
            response.setHeader("Content-disposition","attachment;filename="+fileName);
        }
        excelExportService.makeWorkBook(model,workbook);
    }
}
