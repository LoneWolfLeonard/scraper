package leonardscraperlauncher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class LeonardScraperLauncher {
    public static void main(String[] args) throws IOException, InterruptedException, InterruptedException {
       int counteroftheloop  = 0;
       int loopcap = 22;
       int subloopcount = 0;
       String[] URLHolderArrayL = new String[22]; 
       File file3 = new File("urlstoscrape.txt");  
       File UrlLoaderFile = new File("UrlLoader.txt");
       BufferedReader br3 = new BufferedReader(new FileReader(file3));
       String Manipulator = "";     
       
        //Read the url list and populate current url with scraping url.
	String line3;
	while ((line3 = br3.readLine()) != null) 
            {          
            if(subloopcount == 22)
            {
                subloopcount = 0;                
            }
            
            URLHolderArrayL[subloopcount] = line3;
                
             subloopcount++;
            }
             subloopcount = 0;
             br3.close();

                   while (counteroftheloop != loopcap)
                {  
                    
                // Run LeonardScraper2
                Process proc = Runtime.getRuntime().exec("java -jar Leonard_Scraper_2.jar");
                InputStream in = proc.getInputStream();
                InputStream err = proc.getErrorStream();       
                //Give it time to run
                TimeUnit.SECONDS.sleep(120);                 
                    
                //Move Number Matching URL name from URLHolder Array To Manipulator                       
               Manipulator = URLHolderArrayL[counteroftheloop];
               System.out.println(Manipulator);
               
               //Write URL TO UrlLoader.txt for LeonardScraper2 To Use On Next Iteration
                   FileWriter fw3 = new FileWriter(UrlLoaderFile);
                   PrintWriter out3 = new PrintWriter(fw3);     
                   out3.print(Manipulator);
                    out3.flush(); 
                     out3.close();
                     fw3.close();
                
                
                counteroftheloop++;
                }
                   //Reset UrlLoader.txt for next use
                   FileWriter fw3 = new FileWriter(UrlLoaderFile);
                   PrintWriter out3 = new PrintWriter(fw3);     
                   out3.print("http://www.pcs-company.com/viewproduct/mold-components/mold-date-(amp)-recycling-inserts/pcs-cumsa%E2%84%A2-date-stamps/date-stamp-plus/mold-components/part-ejection/ejector-pins/PEH");
                    out3.flush(); 
                     out3.close(); 
                     fw3.close();
       
    }    
}
