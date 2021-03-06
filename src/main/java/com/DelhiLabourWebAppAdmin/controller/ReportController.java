package com.DelhiLabourWebAppAdmin.controller;

import com.DelhiLabourWebAppAdmin.service.ReportService;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author abhishekjain on 30/3/18.
 */

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @RequestMapping(value = "/returnsFilled", method = RequestMethod.GET)
    public ResponseEntity<?> downloadCourseReport(HttpServletResponse response) {
        try {
            XSSFWorkbook workbook=null;
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename= Returns_Filled.xlsx");
            workbook = reportService.getFilledReturnReport();
            workbook.write(response.getOutputStream());
            workbook.close();
            return ResponseEntity.ok("working");
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/centralized_report", method = RequestMethod.GET)
    public ResponseEntity<?> downloadCentralizedDatababseReport(HttpServletResponse response) {
        try {
            XSSFWorkbook workbook=null;
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename= centralized_database.xlsx");
            workbook = reportService.getCentralizedDatabaseReport();
            workbook.write(response.getOutputStream());
            workbook.close();
            return ResponseEntity.ok("working");
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/user_report", method = RequestMethod.GET)
    public ResponseEntity<?> userReport(HttpServletResponse response) {
        try {
            XSSFWorkbook workbook=null;
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename= user_report.xlsx");
            workbook = reportService.getUsersReport();
            workbook.write(response.getOutputStream());
            workbook.close();
            return ResponseEntity.ok("working");
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/feedback_report", method = RequestMethod.GET)
    public ResponseEntity<?> feedbackReport(HttpServletResponse response) {
        try {
            XSSFWorkbook workbook=null;
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename= feedback_report.xlsx");
            workbook = reportService.getFeedbackReport();
            workbook.write(response.getOutputStream());
            workbook.close();
            return ResponseEntity.ok("working");
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
