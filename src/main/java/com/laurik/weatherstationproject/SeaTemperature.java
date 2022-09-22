/*
O clasa ce ii dam ca parametru construcotului link ul : 
Extrage prin metode :
-Tem apei de azi
-de ieri si 
-de sapt viitoare .
Constructorul doar sa puna link ul intr un camp al clasei iar accesare si extragerea intr o metoda 
numita update.
*/
package com.laurik.weatherstationproject;

import java.net.URL;
import java.util.Scanner;
import java.io.IOException;
import java.util.regex.*;

public class SeaTemperature {
    private String linkAir ;
    private double tempToday = 0;
    private double tempYesterday = 0;
   private double tempLastWeek = 0;
    
    public SeaTemperature(String site ){
    linkAir = site  ;
    }
    
    public void Update() throws IOException{
        
            URL url = new URL(linkAir); // deschidem pagina web 
            Scanner scan = new Scanner(url.openStream()); // citim din pag web cu open Stream continutul 
            StringBuffer data = new StringBuffer(); // creem un string cu dimensiune  mai mare, data
            String dataString;
            
            
            while(scan.hasNext()){ // cat timp avem ce sa citimp in continuare 
                data.append(scan.next()); //data.append= adaugam date noi in data , scan.next()= citim date de tip Stringbuffer 
            }
            dataString = data.toString(); // to string converteste datele din StringBuffer in String
            //System.out.println(dataString);
            
            //div id='temp1'><h3>25.1
            Pattern patternToday = Pattern.compile("id='temp1'><h3>([0-9]+\\.*[0-9]*)");
            Matcher matcherToday = patternToday.matcher(dataString);
            
            if(matcherToday.find()) { //daca s gasit ceva cu matcher 
                //System.out.println("Temperatura este: " + matcher.group(1));
                tempToday = Double.parseDouble(matcherToday.group(1));
            }else{
                System.out.println("Nu s-a gasit nimic");
            }
            
            Pattern patternYesterday = Pattern.compile("id='temp2'><p>ieri:<spanclass='vvch'>([0-9]+\\.*[0-9]*)");
            Matcher matcherYesterday = patternYesterday.matcher(dataString);
            
            if(matcherYesterday.find()) { //daca s gasit ceva cu matcher 
                //System.out.println("Temperatura este: " + matcherYesterday.group(1));
                tempYesterday = Double.parseDouble(matcherYesterday.group(1));
            }else{
                System.out.println("Nu s-a gasit nimic");
            }
            
            Pattern patternLastWeek = Pattern.compile("</span></p><p>acumosaptamana:<spanclass='vvch'>([0-9]+\\.*[0-9]*)");
            Matcher matcherLastWeek  = patternLastWeek .matcher(dataString);
            
            if(matcherLastWeek .find()) { //daca s gasit ceva cu matcher 
                //System.out.println("Temperatura este: " + matcher.group(1));
                tempLastWeek  = Double.parseDouble(matcherLastWeek .group(1));
            }else{
                System.out.println("Nu s-a gasit nimic");
            }
                           
      
    }
    
    
    public double getTempToday(){
        return tempToday;
    }
    
    public double getTempYesterday(){
        return tempYesterday;
    }
    
    public double getLastWeek(){
        return tempLastWeek;
    }
}
    
    

