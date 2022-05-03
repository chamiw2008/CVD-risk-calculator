/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.minofhealth.beans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author chami
 */
@ManagedBean
@ApplicationScoped
public class SelectRisk implements Serializable {

    private static HashMap<String, Integer> riskMap = new HashMap<String, Integer>();

    @PostConstruct
    public void SelectRisk() {
        
        //System.out.println("Running post construct");

        try {
            riskMap = ReadCSV.read(riskMap);
        } catch (Exception ex) {
            Logger.getLogger(SelectRisk.class.getName()).log(Level.SEVERE, null, ex);
        }

        //System.out.println("riskMap: " + this.riskMap.size());
    }

    /**
     * @return the riskMap
     */
    public static HashMap<String, Integer> getRiskMap() {
        return riskMap;
    }

    /**
     * @param aRiskMap the riskMap to set
     */
    public static void setRiskMap(HashMap<String, Integer> aRiskMap) {
        riskMap = aRiskMap;
    }

}
