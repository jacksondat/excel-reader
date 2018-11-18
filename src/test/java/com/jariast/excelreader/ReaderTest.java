package com.jariast.excelreader;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Before;
import org.junit.Test;

public class ReaderTest {
	
	private Reader reader;
	
	@Before
	public void setup() throws EncryptedDocumentException, InvalidFormatException, IOException{
		reader = new Reader(getClass().getClassLoader().getResource("prueba.xlsx").getPath());
	}

	@Test
	public void test() {
		List<String> headers = reader.getHeaders("HojaPrueba");
		assertNotNull(headers);
		assertTrue(headers.contains("Nombre"));
	}

}
