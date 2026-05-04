package Stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.*;
import de.redsix.pdfcompare.PdfComparator;
import de.redsix.pdfcompare.CompareResult;
import org.junit.jupiter.api.Assertions;
import java.io.IOException;


public class T_PdfCompare {
	String filepath1;
	String filepath2;
	boolean isIdentical;
	
	@Given("The files {string} {string} location for comparison")
	public void the_files_location_for_comparison(String string, String string2) {
		filepath1 = string;
		filepath2 = string2;	 
	}

	@When("I compare the pdf files")
	public void i_compare_the_pdf_files() throws IOException {
		String Tresult = "/Users/shirishaprathi/Desktop/Certifications/result";
		isIdentical = new PdfComparator(filepath1,filepath2).compare().writeTo(Tresult);
	  
	}

	@Then("the comparison results should reflect any changes in the files")
	public void the_comparison_results_should_reflect_any_changes_in_the_files() {
		System.out.println("Are the PDFs identical? " + isIdentical);

        // This will make the Cucumber report show a FAILURE if isIdentical is false
		Assertions.assertTrue(isIdentical, "PDF Comparison Failed: The files are NOT identical. See result.pdf for differences.");
	}
	
}