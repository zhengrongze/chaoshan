package com.mc.controller;

import com.mc.utils.execl.TimeUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName XlsController
 * @Author ZhengRongZe
 * @Date 2019/2/24 19:12
 **/
@RestController
@RequestMapping(value = "xls")
public class XlsController {
    @GetMapping(value = "/export")
    public void export(HttpServletResponse response) throws IOException {
        //创建Excel的文档对象
        HSSFWorkbook workbook = new HSSFWorkbook();
        //以当前年月作为工作表
        HSSFSheet sheet = workbook.createSheet(TimeUtils.getYearWithMonth());
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);
        row.setHeightInPoints((short)(30));
        sheet.setColumnWidth(1,200*256);
        cell.setCellValue("2019年1月份办公室考勤");
        HSSFCellStyle style=workbook.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平居中
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中
        cell.setCellStyle(style);
        HSSFRow row1 = sheet.createRow(1);
        HSSFCell cell1 = row.createCell(2);
        cell1.setCellValue("   1、本月公休共7天（周日4天，例休2天，法休1天）；2、本月4个周日，按0.5天计算，故得本月例休2天）；3、全勤24天，4.计薪天数：25天");


// 输出Excel文件，将其写入execl
        OutputStream output;
        output = response.getOutputStream();
        response.reset();

        String exportName = new SimpleDateFormat("yyyyMMdd").format(new Date()) + "统计数据";

        String str = new String(exportName.getBytes("gbk"), "ISO-8859-1");

        response.setContentType("application/vnd.ms-excel;charset=UTF-8"); // 下载文版类型

        response.setHeader("Content-disposition", "attachment; filename=" + str + ".xls");

        response.setCharacterEncoding("UTF-8");

        workbook.write(output);

        output.close();
    }

}
