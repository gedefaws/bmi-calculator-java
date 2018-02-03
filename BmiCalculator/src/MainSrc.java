/**
 * A simple program that calculates BMI for user's body weight. What is BMI?:
 * https://www.thecalculatorsite.com/articles/health/bmi-formula-for-bmi-calculations.php
 *  
 */

import java.util.*;
import java.text.*;
public class MainSrc {

	final static double KG_TO_LBS = 2.20462;
	final static double M_TO_IN = 39.3701;
	private static DecimalFormat TWO_DECIMAL_PLACES = new DecimalFormat(".##");
	
	public static void main(String[] args) {
		double height, weight;

		System.out.println("The BMI Calculator by iasjem");		
		System.out.println();
		
		Scanner askUser= new Scanner(System.in);
		
		System.out.println("What is your weight (kg)?");
		weight = askUser.nextDouble();
		
		System.out.println("What is your height (m)?");
		height = askUser.nextDouble();
		
		System.out.println();
		System.out.println("Your body weight is:");
		System.out.println("In Metric units: " + TWO_DECIMAL_PLACES.format(metricFormula(height, weight)) + " kg");
		System.out.println("In Imperial units: " + TWO_DECIMAL_PLACES.format(imperialFormula(height, weight)) + " lbs");
		System.out.println("As a result, you are " + getCategory(metricFormula(height, weight)));
		
		askUser.close();
		System.exit(0);
	}
	
	// THE METRIC FORMULA
	public static double metricFormula(double m, double kg) {
		double result=0;
		
		result = kg / (Math.pow(m, 2));
		
		return result;
	}
	
	// THE IMPERIAL FORMULA
	public static double imperialFormula(double m, double kg) {
		double result=0;
		// convert kg to lbs and m to in
		double lbs = Math.round(kg * KG_TO_LBS);
		double in = Math.round((m * M_TO_IN) *100);
	
		result = (lbs / (Math.pow((in/100), 2)))* 703;
		
		return result;
	}
	
	// THE BMI CATEGORIES
	public static String getCategory (double result) {
		String category;
		if (result < 15) {
			category = "very severely underweight";
		} else if (result >=15 && result <= 16) {
			category = "severely underweight";
		} else if (result >16 && result <= 18.5) {
			category = "underweight";
		} else if (result >18.5 && result <= 25) {
			category = "normal (healthy weight)";
		} else if (result >25 && result <= 30) {
			category = "overweight";
		} else if (result >30 && result <= 35) {
			category = "moderately obese";
		} else if (result >35 && result <= 40) {
			category = "severely obese";
		} else {
			category ="very severely obese";
		}
		return category;
	}
	// Hope you like it! :)
}
