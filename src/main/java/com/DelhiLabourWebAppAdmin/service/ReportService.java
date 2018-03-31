package com.DelhiLabourWebAppAdmin.service;

import com.DelhiLabourWebAppAdmin.model.AnnualReturn;
import com.DelhiLabourWebAppAdmin.model.Centralized_Database;
import com.DelhiLabourWebAppAdmin.model.ContactUs;
import com.DelhiLabourWebAppAdmin.model.RegisterPOJO;
import com.DelhiLabourWebAppAdmin.repository.AnnualReturnRepository;
import com.DelhiLabourWebAppAdmin.repository.Centralized_DatabaseRepository;
import com.DelhiLabourWebAppAdmin.repository.ContactUsRepository;
import com.DelhiLabourWebAppAdmin.repository.RegisterPOJORepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author abhishekjain on 30/3/18.
 */
@Service
public class ReportService {

    String headers[] = {"Sr No.", "act_name", "UIN", "factory_name", "industry_nature", "name_manager", "name_occupier", "postal_address", "registration_number"};
    String headersForCenDB[]={"Sr No.","aadhar","Act_name","State"};
    String headersForUsers[]={"Sr No.","Username","Name","Email","Phone","Adhaar"};
    String headersForFeedback[]={"Sr No.","Name","Subject","Email","Message"};

    @Autowired
    AnnualReturnRepository annualReturnRepository;

    @Autowired
    Centralized_DatabaseRepository centralized_databaseRepository;

    @Autowired
    RegisterPOJORepository registerPOJORepository;

    @Autowired
    ContactUsRepository contactUsRepository;

    public XSSFWorkbook getFilledReturnReport() {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet("Data");
        XSSFRow row = null;
        int rowid = 0;
        int cellid = 0;
        row = spreadsheet.createRow(rowid++);
        for (int i = 0; i < headers.length; i++) {
            Cell cell = row.createCell(cellid++);
            cell.setCellValue(headers[i]);
        }
        int sNo = 0;

        List<AnnualReturn> annualReturns = annualReturnRepository.findAll();
        for (AnnualReturn annualReturn : annualReturns) {
            cellid = 0;
            row = spreadsheet.createRow(rowid++);
            for (int i = 0; i < headers.length; i++) {
                Cell cell = row.createCell(cellid++);
                switch (i) {
                    case 0:
                        cell.setCellValue(++sNo);
                        break;
                    case 1:
                        cell.setCellValue(annualReturn.getAct_name());
                        break;
                    case 2:
                        cell.setCellValue(annualReturn.getFactory_name());
                        break;
                    case 3:
                        cell.setCellValue(annualReturn.getIndustry_nature());
                        break;
                    case 4:
                        cell.setCellValue(annualReturn.getName_manager());
                        break;
                    case 5:
                        cell.setCellValue(annualReturn.getName_occupier());
                        break;
                    case 6:
                        cell.setCellValue(annualReturn.getPostal_address());
                        break;
                    case 7:
                        cell.setCellValue(annualReturn.getUIN());
                        break;
                    case 8:
                        cell.setCellValue(annualReturn.getRegistration_number());
                        break;
                }
            }

        }
        return workbook;
    }

    public XSSFWorkbook getCentralizedDatabaseReport() {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet("Data");
        XSSFRow row = null;
        int rowid = 0;
        int cellid = 0;
        row = spreadsheet.createRow(rowid++);
        for (int i = 0; i < headersForCenDB.length; i++) {
            Cell cell = row.createCell(cellid++);
            cell.setCellValue(headersForCenDB[i]);
        }
        int sNo = 0;

        List<Centralized_Database> centralized_records = centralized_databaseRepository.findAll();
        for (Centralized_Database records : centralized_records) {
            cellid = 0;
            row = spreadsheet.createRow(rowid++);
            for (int i = 0; i < headersForCenDB.length; i++) {
                Cell cell = row.createCell(cellid++);
                switch (i) {
                    case 0:
                        cell.setCellValue(++sNo);
                        break;
                    case 1:
                        cell.setCellValue(records.getAadhar());
                        break;
                    case 2:
                        cell.setCellValue(records.getAct_name());
                        break;
                    case 3:
                        cell.setCellValue(records.getState());
                        break;
                }
            }
        }
        return workbook;
    }

    public XSSFWorkbook getUsersReport() {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet("Data");
        XSSFRow row = null;
        int rowid = 0;
        int cellid = 0;
        row = spreadsheet.createRow(rowid++);
        for (int i = 0; i < headersForUsers.length; i++) {
            Cell cell = row.createCell(cellid++);
            cell.setCellValue(headersForUsers[i]);
        }
        int sNo = 0;

        List<RegisterPOJO> registerPOJOS = registerPOJORepository.findAll();
        for (RegisterPOJO records : registerPOJOS) {
            cellid = 0;
            row = spreadsheet.createRow(rowid++);
            for (int i = 0; i < headersForUsers.length; i++) {
                Cell cell = row.createCell(cellid++);
                switch (i) {
                    case 0:
                        cell.setCellValue(++sNo);
                        break;
                    case 1:
                        cell.setCellValue(records.getUnm());
                        break;
                    case 2:
                        cell.setCellValue(records.getFullname());
                        break;
                    case 3:
                        cell.setCellValue(records.getEmail());
                        break;
                    case 4:
                        cell.setCellValue(records.getNumber());
                        break;
                    case 5:
                        cell.setCellValue(records.getAddhar());
                        break;
                }
            }
        }
        return workbook;
    }

    public XSSFWorkbook getFeedbackReport() {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet("Data");
        XSSFRow row = null;
        int rowid = 0;
        int cellid = 0;
        row = spreadsheet.createRow(rowid++);
        for (int i = 0; i < headersForFeedback.length; i++) {
            Cell cell = row.createCell(cellid++);
            cell.setCellValue(headersForFeedback[i]);
        }
        int sNo = 0;

        List<ContactUs> feedbacks = contactUsRepository.findAll();
        for (ContactUs records : feedbacks) {
            cellid = 0;
            row = spreadsheet.createRow(rowid++);
            for (int i = 0; i < headersForFeedback.length; i++) {
                Cell cell = row.createCell(cellid++);
                switch (i) {
                    case 0:
                        cell.setCellValue(++sNo);
                        break;
                    case 1:
                        cell.setCellValue(records.getName());
                        break;
                    case 2:
                        cell.setCellValue(records.getSubject());
                        break;
                    case 3:
                        cell.setCellValue(records.getEmail());
                        break;
                    case 4:
                        cell.setCellValue(records.getMessage());
                        break;
                }
            }
        }
        return workbook;
    }



}