package com.example.exceltodatabase.service;

import com.example.exceltodatabase.entity.Customer;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Service
public class ExcelUploadService {
    public static boolean isValidExcelFile(MultipartFile file){
        return Objects.equals(file.getContentType(), "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");      //validate the file format
    }

    public static List<Customer> getCustomersDataFromExcel(InputStream inputStream) throws IOException {
        List<Customer> customers = new ArrayList<>();

        XSSFWorkbook workBook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workBook.getSheet("customers");

        int rowIndex = 0;
        for (Row row : sheet){      //iterate between rows
            if (rowIndex == 0){
                rowIndex++;
                continue;           //passing the first row since it is heading
            }

            Iterator<Cell> cellIterator = row.iterator();       //iterate between cell in a row
            int cellIndex = 0;
            Customer customer = new Customer();
            while (cellIterator.hasNext()){
                Cell cell = cellIterator.next();
                if (cellIndex == 0)
                    customer.setAccountNumber(cell.getStringCellValue());
                if (cellIndex == 1)
                    customer.setName(cell.getStringCellValue());
                if (cellIndex == 2)
                    customer.setAddressLine1(cell.getStringCellValue());
                if (cellIndex == 3)
                    customer.setAddressLine2(cell.getStringCellValue());
                if (cellIndex == 4)
                    customer.setAddressLine3(cell.getStringCellValue());
                if (cellIndex == 5)
                    customer.setSVATCreditNoteNo(cell.getStringCellValue());
                if (cellIndex == 6)
                    customer.setInvoiceNo(cell.getStringCellValue());
                if (cellIndex == 7)
                    customer.setCustomerVATNo(cell.getStringCellValue());
                if (cellIndex == 8)
                    customer.setCustomerSVATNo(cell.getStringCellValue());
                if (cellIndex == 9)
                    customer.setSubTotal(cell.getNumericCellValue());
                if (cellIndex == 10)
                    customer.setTLandCESS(cell.getNumericCellValue());
                if (cellIndex == 11)
                    customer.setTotal(cell.getNumericCellValue());
                if (cellIndex == 12)
                    customer.setSVATAmount(cell.getNumericCellValue());
                if (cellIndex == 13)
                    customer.setEmailID(cell.getStringCellValue());
                cellIndex++;
                }
            customers.add(customer);
            }
        return customers;
    }
}
