package com.jariast.excelreader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Reader {

	private static final int HEADERS_INDEX = 0;
	
	protected Workbook workbook;
	
	public Reader(String filePath) throws EncryptedDocumentException, InvalidFormatException, IOException {
		workbook = WorkbookFactory.create(new File(filePath));
	}
	
	public List<String> getHeaders(String sheetName){
		Sheet sheet = getSheetByName(sheetName);
		Row headerRow = getHeaderRow(sheet);
		return getCellValuesByRow(headerRow);
	}
	
	private Sheet getSheetByName(String sheetName) {
		return workbook.getSheet(sheetName);
	}
	
	private List<String> getCellValuesByRow(Row row){
		List<String> cellValues = new ArrayList<String>();
		for (Cell cell : row) {
			cellValues.add(cell.getStringCellValue());
		}
		return cellValues;
	}
	
	private Row getHeaderRow(Sheet sheet) {
		return sheet.getRow(HEADERS_INDEX);
	}
	
}
