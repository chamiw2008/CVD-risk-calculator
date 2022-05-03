/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.minofhealth.beans;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 *
 * @author chami
 */
public class ReadCSV {

    public static HashMap<String, Integer> read(HashMap<String, Integer> riskMap) throws Exception {

        ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance()
                .getExternalContext().getContext();
        String realPath = ctx.getRealPath("/");

        String requestContextPath = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
        //System.out.println("Path :" + requestContextPath);

        //parsing a CSV file into Scanner class constructor
        File file = new File(realPath + "\\WEB-INF\\CVD-risk.txt");

        Scanner sc = new Scanner(file);

        sc.useDelimiter("\\n");   //sets the delimiter pattern  
        
        //Skip the header line
        sc.nextLine();
        
        while (sc.hasNext()) //returns a boolean value  
        {

            String line = sc.next();
            String[] split = line.split("\\t");
            //System.out.println(split[9] + " - " + split[10]);
            riskMap.put(split[9], Integer.parseInt(split[10]));

        }
        sc.close();  //closes the scanner  
        return riskMap;
    }


}
