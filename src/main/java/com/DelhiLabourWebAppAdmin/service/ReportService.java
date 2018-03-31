package com.DelhiLabourWebAppAdmin.service;

import com.DelhiLabourWebAppAdmin.model.AnnualReturn;
import com.DelhiLabourWebAppAdmin.repository.AnnualReturnRepository;
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

    @Autowired
    AnnualReturnRepository annualReturnRepository;

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


}