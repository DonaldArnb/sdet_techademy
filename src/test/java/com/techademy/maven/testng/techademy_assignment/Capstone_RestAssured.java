package com.techademy.maven.testng.techademy_assignment;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;


public class Capstone_RestAssured {
    public String country;

    //Test to fetch data from Escel (genric function)
    @Test
    public void testTranslationCountries() throws IOException {
        InputStream ExcelFileToRead = new FileInputStream("C:\\techademy\\Selenium\\techademy_selenium\\techademy_assignment\\TestData.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
        XSSFWorkbook test = new XSSFWorkbook();
        XSSFSheet sheet = wb.getSheetAt(0);
        XSSFRow row;
        XSSFCell cell;
        Iterator rows = sheet.rowIterator();
        while (rows.hasNext()) {
            row = (XSSFRow) rows.next();
            Iterator cells = row.cellIterator();
            while (cells.hasNext()) {
                cell = (XSSFCell) cells.next();
                country = cell.getStringCellValue();
                System.out.println(cell.getStringCellValue());
                RestAssured.baseURI = "https://restcountries.com/v3.1/translation/";
                // Send a GET request to the API
                Response response = RestAssured.get(country);
                // Verify that the response has a 200 OK status code
                response.then().assertThat().statusCode(200);
                // Verify that the response body contains the expected data type
                response.then().assertThat().contentType("application/json");
            }

        }

    }

    //Test to validate response body for germany
    @Test
    public void validateBodyofGermany() {
        RestAssured.baseURI = "https://restcountries.com/v3.1/translation/";
        Response response = RestAssured.get("germany");
        ResponseBody body = response.getBody();
        JsonPath jsonPathEvaluator = response.jsonPath();

        //Validate the common country of the places

        List<String> common = jsonPathEvaluator.getList("name.common");
        for (String c : common) {
            Assert.assertEquals(c, "Germany");
        }

        //Validate the common country of the places

        List<String> official = jsonPathEvaluator.getList("name.official");
        for (String o : official) {
            Assert.assertEquals(o, "Federal Republic of Germany");
        }
    }

    //Test to validate response body for alemania

    @Test
    public void validateBodyofAlemania() {
        RestAssured.baseURI = "https://restcountries.com/v3.1/translation/";
        Response response = RestAssured.get("alemania");
        ResponseBody body = response.getBody();
        JsonPath jsonPathEvaluator = response.jsonPath();

        //Validate the common country of the places

        List<String> common = jsonPathEvaluator.getList("name.common");
        for (String c : common) {
            Assert.assertEquals(c, "Germany");
        }

        //Validate the common country of the places

        List<String> official = jsonPathEvaluator.getList("name.official");
        for (String o : official) {
            Assert.assertEquals(o, "Federal Republic of Germany");
        }
    }

    //Test to validate response body for Saksamaa

    @Test
    public void validateBodyofSaksamaa() {
        RestAssured.baseURI = "https://restcountries.com/v3.1/translation/";
        Response response = RestAssured.get("Saksamaa");
        ResponseBody body = response.getBody();
        JsonPath jsonPathEvaluator = response.jsonPath();

        //Validate the common country of the places

        List<String> common = jsonPathEvaluator.getList("name.common");
        for (String c : common) {
            Assert.assertEquals(c, "Germany");
        }

        //Validate the common country of the places

        List<String> official = jsonPathEvaluator.getList("name.official");
        for (String o : official) {
            Assert.assertEquals(o, "Federal Republic of Germany");
        }
    }

}


