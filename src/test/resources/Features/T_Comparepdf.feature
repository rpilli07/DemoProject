Feature: feature to Compare pdf files

Scenario:Validate Compare Pdf files

Given The files "<pdf1>" "<pdf2>" location for comparison
When I compare the pdf files
Then the comparison results should reflect any changes in the files


Examples:
	|pdf1|pdf2|
	|/Users/shirishaprathi/Desktop/Certifications/certificate-of-completion-for-automation-specialist-level-1.pdf|/Users/shirishaprathi/Desktop/Certifications/certificate-of-completion-for-automation-specialist-level-1.pdf|