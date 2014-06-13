package com.ucsf.pagerbox;

import org.openqa.selenium.*;
import org.testng.annotations.Test;
import com.ucsf.automation.core.PNameParentTestCase;
import java.io.*;

/**
 * @description	Automation script to pull information from https://www.pagerbox.com/website/index.cfm
 * @author 		Gustavo Rivero
 * @date		05/15/2014
 * @contact		gustavo.rivero@ucsf.edu.uy
 */
public class GetGroups extends PNameParentTestCase{
	
	// configuration attributes
	private final String PATH_TO_TXT_FILE 	= "C:/Users/rodriguezg/Desktop/pagerbox.txt";
	private final String PATH_TO_READ		= "C:/Users/rodriguezg/Desktop/codes.txt";
	private final String TARGET_URL_PART1	= "https://www.pagerbox.com/page/index.cfm?fuseaction=sendPage&userID=";
	private final String TARGET_URL_PART2	= "&CFID=1169910&CFTOKEN=44737066";
	
	// returns url to get groups info
	private String constructURL( String sUserID ){		
		return TARGET_URL_PART1 + sUserID + TARGET_URL_PART2;
	}
	
	@Test
	public void hackPage(){

		// aux vars
		PrintWriter 	printWriter;
		FileWriter 		w;
		FileReader		r;
		BufferedWriter 	bw;
		BufferedReader	br;
		
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
			printWriter.println ( "Pagerbox User ID, Group, Group Names" );
			
			// go through each user id of the file and pull info from the url into a txt file 
			//Integer i = 0; index to test small amounts of rows
			while ((line = br.readLine()) != null) {				
				
		        // use comma as separator
				String userID = line.split("\n")[0];
				String output_groups_ids;
				String output_groups_names;
				
				// go to page
				this.getDriver().get( constructURL(userID) );												
				
				// get groups ids with javascript
				output_groups_ids = (String)((JavascriptExecutor)getDriver()).executeScript(
						"var elems = document.getElementsByTagName('a');var output =''; for(var i=0; i< elems.length; i++) if( elems[i].href.indexOf('&UserCategoryID=') != -1 ) output += elems[i].href.split('&UserCategoryID=')[1].split('&')[0] + ';'; return output.substring(0,output.length-1);" ).toString();
				
				// get groups names with javascript
				output_groups_names = "\"" + (String)((JavascriptExecutor)getDriver()).executeScript(
						"var elems = document.getElementsByTagName('a');var output =''; for(var i=0; i< elems.length; i++) if( elems[i].href.indexOf('&UserCategoryID=') != -1 ) output += elems[i].innerHTML + ';'; return output.substring(0,output.length-1);" ).toString() + "\"";
				
				// write in txt file
				printWriter.println ( userID + "," + output_groups_ids + "," + output_groups_names );		
				// i++; if(i==65) break;
			}			 			
			
			printWriter.close();
			
		} catch (Exception e) {			
			e.printStackTrace();
		}	
				
		
	}		
	
}
