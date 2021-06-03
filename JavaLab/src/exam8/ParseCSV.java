package exam8;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class ParseCSV {
    public static void main(String[] args) throws IOException {
        /*
        將exam/e8/Employee.csv Copy至c:\java
        利用Commons csv library來處理csv檔案
        網址如下  https://commons.apache.org/proper/commons-csv/
        1.下載commons-csv-1.8-bin.zip，解壓縮後將jar放至lib目錄
        2.eclipse中設定library
        3.參考官方的User Guide處理此csv
        取得薪水的加總
         */
    	 Reader in= new FileReader("C:\\java\\Employees.csv");
    	 Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
    	 int SalSum = 0;
    	 for(CSVRecord ExRecord : records) {
     	    SalSum +=Integer.valueOf(ExRecord.get(2).replaceAll("\"", "").replaceAll(",", ""));
    	 }
    	 System.out.println(SalSum);
    	
    } 	
}
