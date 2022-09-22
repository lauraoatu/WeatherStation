
package com.laurik.weatherstationproject;
import java.awt.*;    
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;    
    
public class GUI extends JFrame{
    // import statements  
  
  JLabel JTempI;
  JLabel JTempSeaI;
  JLabel JTempT;
  JLabel JTempSeaT;
// constructor  
GUI()  
{   
    
    super("Weather Station");
  // creating 9 buttons 
JLabel JIstambul = new JLabel("Istambul");
JLabel Tennevoll = new JLabel("Tennevoll"); 

JLabel JSunI = new JLabel();
ImageIcon iconSun = new ImageIcon("sun.jfif");
JSunI.setIcon(iconSun);


JLabel JSunT = new JLabel();
ImageIcon iconSunWithCloudls = new ImageIcon("sunwithclouds.png");
JSunT.setIcon(iconSunWithCloudls);

JTempI = new JLabel("Temperatura aerului" );
JTempT = new JLabel("Temperatura aerului");

JLabel JSeaI = new JLabel();
ImageIcon seaw = new ImageIcon("seaw.png");
JSeaI.setIcon(seaw);

JLabel JSeaT = new JLabel();
ImageIcon seawT = new ImageIcon("seaw.png");
JSeaT.setIcon(seawT);

JTempSeaI = new JLabel("Temperatura marii");
JTempSeaT = new JLabel("Temperatura marii");

JButton btn1 = new JButton("Update");
btn1.addActionListener(new ActionListener() { 
  @Override
  public void actionPerformed(ActionEvent e) { 
    pressButtonIs();
      } 
} );
JButton btn2 = new JButton("Update");
btn2.addActionListener(new ActionListener() { 
  @Override
  public void actionPerformed(ActionEvent e) { 
    pressButtonTen();
      } 
} );

// adding buttons to the frame  
// since, we are using the parameterless constructor, therefore;   
// the number of columns is equal to the number of buttons we   
// are adding to the frame. The row count remains one.  
add(JIstambul); add(Tennevoll); add(JSunI);  
add(JSunT); add(JTempI); add(JTempT);  
add(JSeaI); add(JSeaT); add(JTempSeaI); 
add(JTempSeaT); add(btn1); add(btn2);   
// setting the grid layout   
// a 3 * 3 grid is created with the horizontal gap 20   
// and vertical gap 25  
setLayout(new GridLayout(6, 2, 20, 25));// (3[coloana], 3 [rand], 20[pixel coloana], 20 [pixel rand])   
setSize(500, 600); //marimea ferestrei   
setVisible(true);  // face fereastra sa fie vizibila
}  
public void pressButtonIs(){
    try {
        AdvancedWeather weatherI = new AdvancedWeather("https://ro.seatemperature.net/current/turkey/istanbul-istanbul-turkey","https://weather.com/ro-RO/weather/tenday/l/33d1e415eb66f3e1ab35c3add45fccf4512715d329edbd91c806a6957e123b49");
        weatherI.Update();
        System.out.println("S-a apasat butonul Istambul");
        JTempI.setText("Temperatura aerului este: " + weatherI.getAirToday() + " °C");
        JTempSeaI.setText("Temperatura marii este : " + weatherI.getTempToday() + " °C" );
        System.out.println("Temperatura din Instambul est " + weatherI.getAirToday());
        System.out.println("Temperatura din Instambul est " + weatherI.getTempToday());
        
    } catch (IOException ex) {
        System.out.println("Nu s-a accesat site-ul");
    }
}
    public void pressButtonTen(){
    try {
        AdvancedWeather weatherI = new AdvancedWeather("https://ro.seatemperature.net/current/norway/tennevoll-troms-norway","https://weather.com/ro-RO/weather/tenday/l/afebe51fb25d0b94ec6536e88f4ea8a0faf560cc4e2c50ab210b9b2f51ec815f");
        weatherI.Update();
        System.out.println("S-a apasat butonul Tennevoll");
        JTempT.setText("Temperatura aerului este: " + weatherI.getAirToday() + " °C");
        JTempSeaT.setText("Temperatura marii este : " + weatherI.getTempToday() + " °C" );
        System.out.println("Temperatura din Tennevoll est " + weatherI.getAirToday());
        System.out.println("Temperatura din Tennevoll est " + weatherI.getTempToday());
        
    } catch (IOException ex) {
        System.out.println("Nu s-a accesat site-ul");
    }
}
}

/*
jBtnSelection.addActionListener(new ActionListener() { 
  public void actionPerformed(ActionEvent e) { 
    selectionButtonPressed();
  } 
} );
*/
