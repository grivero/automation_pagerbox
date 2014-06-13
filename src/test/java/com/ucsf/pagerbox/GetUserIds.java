package com.ucsf.pagerbox;

import org.openqa.selenium.*;
import org.testng.annotations.Test;

import com.ucsf.automation.core.PNameParentTestCase;

import java.io.*;

/**
 * @description	Automation script to pull information from https://www.pagerbox.com/website/index.cfm
 * @author 		Gustavo Rivero
 * @date		05/07/2014
 * @contact		gustavo.rivero@ucsf.edu
 */
public class GetUserIds extends PNameParentTestCase {
	
	// configuration attributes
	private final String PATH_TO_TXT_FILE 	= "C:/Users/rodriguezg/Desktop/pagerbox.txt";// could be a path to any .txt file with write access
	private final int START_INDEX 			= 7190000;// 4430000;
	private final int END_INDEX				= 7199999;// 4439999;
	private final String TARGET_URL			= "https://www.pagerbox.com/search/index.cfm?fuseaction=search&keywords=4430000";

	// helper method to init webDriver instance in target_url
	public void initAutomation(){
		this.getDriver().get( TARGET_URL );
	}
	
	@Test
	public void hackPage(){				

		// init automation
		initAutomation();
		
		// aux vars
		PrintWriter 	printWriter;
		FileWriter 		w;
		BufferedWriter 	bw;
		String 			currURL;
		String 			pageNumber;
		String 			nameInPB;
		String 			pagerBoxID;
		
		// get file to populate
		File file = new File( this.PATH_TO_TXT_FILE );
		file.getParentFile().mkdirs();
				
		try {
			
			// init contents
			w 			= new FileWriter(file);
			bw 			= new BufferedWriter(w);									
			printWriter = new PrintWriter(bw);
			
			// we just write null					
			printWriter.println ( "Page Number, Name in Pagerbox, PagerBoxID#" );
			 				
			// init counter			
			for( Integer count = START_INDEX; count <= END_INDEX ; count++ ){
				
				// to avoid crash, after 1000 calculations i make a 3 seconds stop
				if( count % 100 == 0 )					
					Thread.sleep(3000);									
				
				// write page number in input
				getDriver().findElement( By.cssSelector("input[name=keywords]") ).sendKeys( Integer.toString(count) );				
				// click on button
				getDriver().findElement(By.cssSelector("input[value=Search]")).click();				
				// get url
				currURL = getDriver().getCurrentUrl();				
				// get pageNumber
				pageNumber 	= "\"" + Integer.toString(count) + "\""; 
				
				// if param has userID we proceed collecting some more params
				if( currURL.contains("userID") ){
										
					nameInPB	= "\"" + getDriver().findElement(By.cssSelector(".emph>font>nobr>b")).getText().replaceAll("[\"]","")+ "\"";
					pagerBoxID 	= "\"" + currURL.split("userID=")[1].split("&")[0] + "\"";
					
					printWriter.println ( pageNumber + "," + nameInPB + "," + pagerBoxID );
					
				}else{
					
					//if select != null need to get multiple info 
					if( getDriver().findElements(By.cssSelector("select")).size()!=0 ){												
						
						nameInPB = (String)((JavascriptExecutor)getDriver()).executeScript(
							    "var people = document.getElementsByTagName('option'); var output = '\"'; " +
							    "for(var i=0; i<people.length ; i++){ if( i!=0 ) output+= '; '; output += people[i].label.split('--')[0].replace(/\"/g, ''); } output += '\"'; return output;" ).toString();
						
						String IDs = (String)((JavascriptExecutor)getDriver()).executeScript(
							    "var people = document.getElementsByTagName('option'); var output = '\"'; " +
							    "for(var i=0; i<people.length ; i++){ if( i!=0 ) output+= ', '; output += people[i].value; } output += '\"'; return output;" ).toString();								
						
						printWriter.println ( pageNumber + "," + nameInPB + "," + IDs );
												
					}else{
					
						// else, nothing to pull				
						printWriter.println ( pageNumber + ",null,null" );
					
					}
					
									
				}																																														
				
			}
				
			// close file
			printWriter.close();
			
		} catch (Exception e) {			
			e.printStackTrace();
		}	
				
		
	}		
	
}
