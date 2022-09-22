//Sa iau de pe un site temperaturile aerului  
package com.laurik.weatherstationproject;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AdvancedWeather extends SeaTemperature{
   private double tempAirToday;
   private double tempAirTommorow;
   private double tempAirNextWeek;
   private String linkAir; 
    
    public AdvancedWeather(String seaLink, String airLink){
        super(seaLink);
        linkAir =airLink; 
    }
    
   @Override
    public void Update()throws IOException{
    super.Update();
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
            Pattern patternAirToday = Pattern.compile("<spandata-testid=\"TemperatureValue\"class=\"DetailsSummary--highTempValue--3Oteu\">([0-9]+\\.*[0-9]*)");
            Matcher matcherAirToday = patternAirToday.matcher(dataString);
            
            if(matcherAirToday.find()) { //daca s gasit ceva cu matcher 
                //System.out.println("Temperatura apei este: " + matcherAirToday.group());
                tempAirToday = Double.parseDouble(matcherAirToday.group(1));
            }else{
                System.out.println("Nu s-a gasit nimic");
            }
            
            Pattern patternAirTommorow = Pattern.compile("<spandata-testid=\"TemperatureValue\"class=\"DailyContent--temp--3d4dn\">([0-9]+\\.*[0-9]*)");
            Matcher matcherAirTommorow = patternAirTommorow.matcher(dataString);
            
            if(matcherAirTommorow.find()) { //daca s gasit ceva cu matcher 
                //System.out.println("Temperatura este: " + matcherYesterday.group(1));
                tempAirTommorow = Double.parseDouble(matcherAirTommorow.group(1));
            }else{
                System.out.println("Nu s-a gasit nimic");
            }
            
            Pattern patternAirNextWeek = Pattern.compile("<spandata-testid=\"TemperatureValue\"class=\"DailyContent--temp--3d4dn\">([0-9]+\\.*[0-9]*)");
            Matcher matcherAirNextWeek = patternAirNextWeek .matcher(dataString);
            
            if(matcherAirNextWeek.find()) { //daca s gasit ceva cu matcher 
                //System.out.println("Temperatura este: " + matcher.group(1));
                tempAirNextWeek = Double.parseDouble(matcherAirNextWeek.group(1));
            }else{
                System.out.println("Nu s-a gasit nimic");
            }
                                      
    }
    
        public double getAirToday(){
        return tempAirToday;
    }
    
    public double getAirTommorow(){
        return tempAirTommorow;
    }
    
    public double getAirNextWeek(){
        return tempAirNextWeek;
    }
    }
    

