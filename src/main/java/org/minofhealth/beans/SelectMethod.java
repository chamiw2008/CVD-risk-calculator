/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.minofhealth.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author chami
 */
@ManagedBean
@SessionScoped
public class SelectMethod implements Serializable {

    private String calcMethod;
    private int age;
    private String genderFlag;
    private float totalCholestrol;
    private int sbp;
    private String smokingFlag;
    private int dmFlag;
    private float height;
    private int weigth;
    private String combinationID;
    private int riskPercentage;
    private String riskCategory;

    /**
     *     private String calcMethod;
    private int age = 46;
    private String genderFlag;
    private float totalCholestrol = 4.6f;
    private int sbp = 130;
    private String smokingFlag;
    private int dmFlag;
    private float height = 1.83f;
    private int weigth = 102;
    private String combinationID;
    private int riskPercentage;
    private String riskCategory;
     * 
     * 
     * @return the calcMethod
     */
    public String getCalcMethod() {
        return calcMethod;
    }

    /**
     * @param calcMethod the calcMethod to set
     */
    public void setCalcMethod(String calcMethod) {
        this.calcMethod = calcMethod;
    }

    public String submitted() throws IOException {

        System.out.println("The selected method is:" + getCalcMethod());

        if (getCalcMethod().equalsIgnoreCase("lbm")) {

            return "lab-method";

        } else {

            return "non-lab-method";
        }

    }

    public String calculateLab() throws IOException {

        System.out.println("DM Flag: " + getDmFlag());

        System.out.println("Gender Flag: " + getGenderFlag());

        String ageCategory = ResultsCalculation.calculateAgeCategory(getAge());
        System.out.println("Age Flag: " + ageCategory);

        System.out.println("Smoking Flag: " + getSmokingFlag());

        String sbpCategory = ResultsCalculation.calculateSBPCategory(getSbp());
        System.out.println("SBP Flag: " + sbpCategory);

        String tclCategory = ResultsCalculation.calculateTCLCategory(getTotalCholestrol());
        System.out.println("TCL Flag: " + tclCategory);

        String flag = "x" + getDmFlag() + getGenderFlag() + ageCategory + getSmokingFlag() + sbpCategory + tclCategory;
        System.out.println("Comparison String : " + flag);

        setCombinationID(flag);

        try {

            HashMap<String, Integer> read = ReadCSV.read(SelectRisk.getRiskMap());
            Integer get = read.get(flag);

            setRiskPercentage(get);

            setRiskCategory(ResultsCalculation.calculateRiskCategory(get));

        } catch (Exception ex) {
            Logger.getLogger(SelectMethod.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "results?faces-redirect=true";
    }

    public String calculateNonLab() throws IOException {

        float bmi = 0;
        try {
            bmi = getWeigth() / (getHeight() * getHeight());
        } catch (Exception e) {
        }

        System.out.println("BMI: " + bmi);
        String bmiFlag = ResultsCalculation.calculateBMICategory(Math.round(bmi));
        System.out.println("BMI Flag: " + bmiFlag);

        System.out.println("Gender Flag: " + getGenderFlag());

        String ageCategory = ResultsCalculation.calculateAgeCategory(getAge());
        System.out.println("Age Flag: " + ageCategory);

        System.out.println("Smoking Flag: " + getSmokingFlag());

        String sbpCategory = ResultsCalculation.calculateSBPCategory(getSbp());
        System.out.println("SBP Flag: " + sbpCategory);

        String flag = bmiFlag + "x" + getGenderFlag() + ageCategory + getSmokingFlag() + sbpCategory + "x";
        System.out.println("Comparison String : " + flag);

        setCombinationID(flag);

        try {

            HashMap<String, Integer> read = ReadCSV.read(SelectRisk.getRiskMap());
            Integer get = read.get(flag);

            setRiskPercentage(get);

            setRiskCategory(ResultsCalculation.calculateRiskCategory(get));

        } catch (Exception ex) {
            Logger.getLogger(SelectMethod.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "results?faces-redirect=true";
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the genderFlag
     */
    public String getGenderFlag() {
        return genderFlag;
    }

    /**
     * @param genderFlag the genderFlag to set
     */
    public void setGenderFlag(String genderFlag) {
        this.genderFlag = genderFlag;
    }

    /**
     * @return the totalCholestrol
     */
    public float getTotalCholestrol() {
        return totalCholestrol;
    }

    /**
     * @param totalCholestrol the totalCholestrol to set
     */
    public void setTotalCholestrol(float totalCholestrol) {
        this.totalCholestrol = totalCholestrol;
    }

    /**
     * @return the sbp
     */
    public int getSbp() {
        return sbp;
    }

    /**
     * @param sbp the sbp to set
     */
    public void setSbp(int sbp) {
        this.sbp = sbp;
    }

    /**
     * @return the smokingFlag
     */
    public String getSmokingFlag() {
        return smokingFlag;
    }

    /**
     * @param smokingFlag the smokingFlag to set
     */
    public void setSmokingFlag(String smokingFlag) {
        this.smokingFlag = smokingFlag;
    }

    /**
     * @return the dmFlag
     */
    public int getDmFlag() {
        return dmFlag;
    }

    /**
     * @param dmFlag the dmFlag to set
     */
    public void setDmFlag(int dmFlag) {
        this.dmFlag = dmFlag;
    }

    /**
     * @return the height
     */
    public float getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(float height) {
        this.height = height;
    }

    /**
     * @return the weigth
     */
    public int getWeigth() {
        return weigth;
    }

    /**
     * @param weigth the weigth to set
     */
    public void setWeigth(int weigth) {
        this.weigth = weigth;
    }

    /**
     * @return the combinationID
     */
    public String getCombinationID() {
        return combinationID;
    }

    /**
     * @param combinationID the combinationID to set
     */
    public void setCombinationID(String combinationID) {
        this.combinationID = combinationID;
    }

    /**
     * @return the riskPercentage
     */
    public int getRiskPercentage() {
        return riskPercentage;
    }

    /**
     * @param riskPercentage the riskPercentage to set
     */
    public void setRiskPercentage(int riskPercentage) {
        this.riskPercentage = riskPercentage;
    }

    /**
     * @return the riskCategory
     */
    public String getRiskCategory() {
        return riskCategory;
    }

    /**
     * @param riskCategory the riskCategory to set
     */
    public void setRiskCategory(String riskCategory) {
        this.riskCategory = riskCategory;
    }

}
