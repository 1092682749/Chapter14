package com.ssm.chapter14.controller;

import com.ssm.chapter14.pojo.PageParams;
import com.ssm.chapter14.pojo.Role;
import com.ssm.chapter14.service.RoleService;
import com.ssm.chapter14.view.ExcelExportService;
import com.ssm.chapter14.view.ExcelView;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/view")
public class ViewController {
    @Autowired
    RoleService roleService;
    @RequestMapping(value = "/export",method = RequestMethod.GET)
    public ModelAndView export(){
        ModelAndView mav = new ModelAndView();
        ExcelView excelView = new ExcelView(exportService());
        excelView.setFileName("所有角色.xlsx");
        Role role = new Role();
        PageParams pageParams = new PageParams();
        pageParams.setStart(0);
        pageParams.setLimit(10000);
        role.setPageParams(pageParams);
        List<Role> roles = roleService.findeRole();
        mav.addObject("roles",roles);
        mav.setView(excelView);
        return mav;
    }
    @SuppressWarnings({"unchecked"})
    private ExcelExportService exportService(){
        return (Map<String,Object> model, Workbook workBook)->{
            List<Role> roles = (List<Role>) model.get("roles");
            Sheet sheet = workBook.createSheet("所有角色");
            Row title = sheet.createRow(0);
            title.createCell(0).setCellValue("编号");
            title.createCell(1).setCellValue("名称");
            title.createCell(2).setCellValue("备注");
            for (int i=0; i<roles.size(); i++)
            {
                Role role = roles.get(i);
                int rowIdx = i + 1;
                Row row = sheet.createRow(rowIdx);
                row.createCell(0).setCellValue(role.getId());
                row.createCell(1).setCellValue(role.getRoleName());
                row.createCell(2).setCellValue(role.getNote());
            }
        };
    }
}
