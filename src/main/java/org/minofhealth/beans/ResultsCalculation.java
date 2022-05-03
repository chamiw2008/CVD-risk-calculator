/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.minofhealth.beans;

/**
 *
 * @author chami
 */
public class ResultsCalculation {

    public static String calculateBMICategory(int bmi) {

        //BMI	
        //1	<20	
        //2	20-24	
        //3	25-29	
        //4	30-35	
        //5	>=35	
        //x	Any
        if (bmi <= 20) {
            return "1";
        }

        if (bmi >= 20 && bmi <= 24) {
            return "2";
        }

        if (bmi >= 25 && bmi <= 29) {
            return "3";
        }

        if (bmi >= 30 && bmi <= 35) {
            return "4";
        }

        if (bmi >= 35) {
            return "5";
        }

        return "x";

    }

    public static String calculateTCLCategory(float tcl) {

        //Cholestrol	
        //1	<4 mmol/dl	
        //2	4-4.9 mmol/dl	
        //3	5-5.9 mmol/dl	
        //4	6-6.9 mmol/l	
        //5	>=7 mmol/l	
        //x	unknown
        if (tcl <= 4) {
            return "1";
        }

        if (tcl >= 4 && tcl <= 4.9) {
            return "2";
        }

        if (tcl >= 5 && tcl <= 5.9) {
            return "3";
        }

        if (tcl >= 6 && tcl <= 6.9) {
            return "4";
        }

        if (tcl >= 7) {
            return "5";
        }

        return "x";

    }

    
    public static String calculateRiskCategory(int risk) {

        //Risk	
 
        if (risk < 5) {
            return "A - <5%";
        }

        if (risk >= 5 && risk < 10) {
            return "B - 5% - <10%";
        }

        if (risk >= 10 && risk < 20) {
            return "C - 10% - <20%";
        }

        if (risk>= 20 && risk < 30) {
            return "D - 20% - <30%";
        }

        if (risk>= 30) {
            return "E - >30%";
        }

        return "x";

    }

    
    
    public static String calculateSBPCategory(int sbp) {

        // SBP	
        //1	>=180 mmHg	
        //2	160-179 mmHg	
        //3	140-159 mmHg	
        //4	120-139 mmHg	
        //5	<120 mmHg
        if (sbp >= 180) {
            return "1";
        }

        if (sbp >= 160 && sbp <= 179) {
            return "1";
        }

        if (sbp >= 140 && sbp <= 159) {
            return "1";
        }

        if (sbp >= 120 && sbp <= 139) {
            return "1";
        }

        if (sbp <= 120) {
            return "1";
        }

        return "x";

    }

    public static String calculateAgeCategory(int age) {

        //Age	
        //1	70-74 Years	
        //2	65-69 Years	
        //3	60-64 Years	
        if (age >= 70 && age <= 74) {
            return "1";
        }

        if (age >= 65 && age <= 69) {
            return "2";
        }

        if (age >= 60 && age <= 64) {
            return "3";
        }

        //Age
        //4	55-59 Years	
        //5	50-54 Years	
        //6	45-49 Years	
        //7	40-44 Years
        if (age >= 55 && age <= 59) {
            return "4";
        }

        if (age >= 50 && age <= 54) {
            return "5";
        }

        if (age >= 45 && age <= 49) {
            return "6";
        }

        if (age >= 40 && age <= 44) {
            return "7";
        }

        return "x";

    }

}
