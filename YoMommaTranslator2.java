 
package yomommatranslator2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class YoMommaTranslator2 {


    public static void main(String[] args)throws FileNotFoundException {
        
     
        System.out.println(textSlangTranslator("LOL WTH Mom, SRSLY I will be there TMRW"));
        
   
  
    }//main
    
    
   public static String textSlangTranslator(String input)throws FileNotFoundException {
       
       Map<String,String> acronymMap = new HashMap<>();
       Scanner acronymFileScanner = new Scanner(new File("acronyms.txt"));
        
        while(acronymFileScanner.hasNextLine()) {
            //takes a line from file, puts it into array
            String[] split = acronymFileScanner.nextLine().split("\\t");
            //puts elements into map
            acronymMap.put(split[0], split[1]);
            
        }
        
        //puts each word in string as an element in array
        String[] inputArray = input.split(" ");
        
        String newString = "";
        //loop for the length of the inputArray
        for(int i = 0; i < inputArray.length; i++ ) {
            //if the key portion of the map contains inputArray[i]
            if(acronymMap.containsKey(inputArray[i])) {
                //put the value portion of the key at inputArray[i] in a string
                newString += acronymMap.get(inputArray[i]) + " ";
            }
            else {
                /*if the value at inputArray[i] does not contain any key value from
                acronymMap, then just add that word to newString as well */
                newString += inputArray[i] + " ";
            }
        }
        
        
        return newString;
        
       
       
   }//method



    
}//class
