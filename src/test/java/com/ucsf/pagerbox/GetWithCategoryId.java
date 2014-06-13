package com.ucsf.pagerbox;

import org.openqa.selenium.*;
import org.testng.annotations.Test;
import com.ucsf.automation.core.PNameParentTestCase;
import java.io.*;

/**
 * @description	Automation script to pull information from https://www.pagerbox.com/website/index.cfm
 * @author 		Gustavo Rivero
 * @date		06/13/2014
 * @contact		gustavo.rivero@ucsf.edu
 */
public class GetWithCategoryId extends PNameParentTestCase{
	
	// configuration attributes
	private final String PATH_TO_TXT_FILE 	= "C:/Users/rodriguezg/Desktop/pagerbox.txt";
	private final String PATH_TO_READ		= "C:/Users/rodriguezg/Desktop/categoryids.txt";
	private final String TARGET_URL			= "https://www.pagerbox.com/website/index.cfm?fuseaction=displayCategory&UserCategoryID=";	
	
	// returns url to get groups info
	private String constructURL( String sCategoryID ){		
		return TARGET_URL + sCategoryID;
	}
	
	@Test
	public void hackPage(){

		// aux vars
		PrintWriter 	printWriter;
		FileWriter 		w;
		FileReader		r;
		BufferedWriter 	bw;
		BufferedReader	br;
//		String 			currURL;
//		String 			pageNumber;
//		String 			nameInPB;
//		String 			pagerBoxID;
		
		// get file to populate
		File file 	= new File( this.PATH_TO_TXT_FILE );
		File toRead = new File( this.PATH_TO_READ );		
		file.getParentFile().mkdirs();
		toRead.getParentFile().mkdirs();
		
		try {
			
			// init contents
			w 			= new FileWriter(file);
			r			= new FileReader(toRead);
			bw 			= new BufferedWriter(w);
			br			= new BufferedReader(r);
			printWriter = new PrintWriter(bw);
			String line;
			
			// write csv header
			printWriter.println ( "CategoryId, Pagerbox UserIDs, Names" );
			
			// go through each user id of the file and pull info from the url into a txt file 
			//Integer i = 0; //index to test small amounts of rows
			while ((line = br.readLine()) != null) {				
				
		        // use comma as separator
				String categoryID = line.split("\n")[0];
				String output_groups_ids;
				String output_groups_names;
				
				// go to page
				this.getDriver().get( constructURL(categoryID) );												
				
				//if select != null need to get multiple info 
				if( getDriver().findElements(By.cssSelector("select")).size()!=0 ){												
					
					output_groups_names = (String)((JavascriptExecutor)getDriver()).executeScript(
						    "var people = document.getElementsByTagName('option'); var output = '\"'; " +
						    "for(var i=0; i<people.length ; i++){ if( i!=0 ) output+= '; '; output += people[i].label.split('--')[0].replace(/\"/g, ''); } output += '\"'; return output;" ).toString();
					
					output_groups_ids = (String)((JavascriptExecutor)getDriver()).executeScript(
						    "var people = document.getElementsByTagName('option'); var output = '\"'; " +
						    "for(var i=0; i<people.length ; i++){ if( i!=0 ) output+= ', '; output += people[i].value; } output += '\"'; return output;" ).toString();								
					
					printWriter.println ( categoryID + "," + output_groups_ids + "," + output_groups_names );
											
				}else{
				
					// else, nothing to pull				
					printWriter.println ( categoryID + ",null,null" );
				
				}						
				//i++; if(i==10) break;
			}			 			
			
			printWriter.close();
			
		} catch (Exception e) {			
			e.printStackTrace();
		}	
				
		
	}		
	
}
