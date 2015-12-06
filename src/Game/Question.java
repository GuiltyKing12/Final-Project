package Game;

import java.util.Random;

public class Question {
	private String rawText;
	private String finalText;
	private Fraction fraction1;
	private Fraction fraction2;
	private Fraction fraction3;
	private int level;
	private QuestionType type;
	private Fraction solution;
	Random rand = new Random();
	
	public Question(String text, QuestionType type, int level) {
		this.rawText = text;
		this.type = type;
		this.level = level;
		
		generateFractions();
		formatText();
		computeSolution();
	}
	
	private void generateFractions() {
		fraction1 = getRandomFraction();
		fraction2 = getRandomFraction();
		
		if (type == QuestionType.ADDSUB || type == QuestionType.SUBADD) {
			fraction3 = getRandomFraction();
		}
	}
	
	
	
	public Fraction getRandomFraction() {
		int initial = 4;
		int levelScaling = level * 2;		
		int randNumerator = rand.nextInt(initial + levelScaling) + 1;
		int randDenominator = rand.nextInt((initial - 1) + levelScaling) + 2;
		
		if (type == QuestionType.WORD) {
			while (randNumerator > randDenominator) {
				randNumerator = rand.nextInt(initial + levelScaling) + 1;
			}
		}
		
		return new Fraction(randNumerator, randDenominator);
	}	
	
	private void formatText() {
		String firstFractionText = fraction1.getNumerator() + "/" + fraction1.getDenominator();
		String secondFractionText = fraction2.getNumerator() + "/" + fraction2.getDenominator();
		rawText = rawText.replace("{FRACTION1}", firstFractionText);
		rawText = rawText.replace("{FRACTION2}", secondFractionText);
		
		if (fraction3 != null) {
			String thirdFractionText = fraction3.getNumerator() + "/" + fraction3.getDenominator();
			rawText = rawText.replace("{FRACTION3}", thirdFractionText);
		}
		
		finalText = rawText;
	}

	@Override
	public String toString() {
		return finalText;
	}
	
	public void computeSolution() {
		// TODO: CALCULATE SOLUTIONS FOR EACH TYPE OF QUESTION
		
		switch (type) {
			case SUBTRACT:
				solution = subtract();
				break;
				
			case ADD:
				solution = add();
				break;
				
			case SUBADD:
				solution = subAdd();
				break;
				
			case ADDSUB:
				solution = addSub();
				break;
				
			case MULTIPLY:
				solution = multiply();
				break;
				
			case LESS:
				
				break;
				
			case GREATER:
				break;
				
			case EQUAL:
				break;
				
			case WORD:
				
				break;
		}
	}
	
	public Fraction subtract() {
		if (!fraction1.hasCommonDenominator(fraction2)) {
			fraction1.computeCommonDenominator(fraction2);
		}

		int numResult = fraction1.getNumerator() - fraction2.getNumerator();
		int commonDenominator = fraction1.getDenominator();
		
		return new Fraction(numResult, commonDenominator);
	}
	
	public Fraction add() {
		if (!fraction1.hasCommonDenominator(fraction2)) {
			fraction1.computeCommonDenominator(fraction2);
		}
		
		int numResult = fraction1.getNumerator() + fraction2.getNumerator();
		int commonDenominator = fraction1.getDenominator();
		
		return new Fraction(numResult, commonDenominator);
	}
	
	public Fraction subAdd() {
		if (!fraction1.hasCommonDenominator(fraction2, fraction3)) {
			fraction1.computeCommonDenominator(fraction2, fraction3);
		}
		
		int numResult = fraction1.getNumerator() - fraction2.getNumerator() + fraction3.getNumerator();
		int commonDenominator = fraction1.getDenominator();
		
		return new Fraction(numResult, commonDenominator);
	}
	
	public Fraction addSub() {
		if (!fraction1.hasCommonDenominator(fraction2, fraction3)) {
			fraction1.computeCommonDenominator(fraction2, fraction3);
		}
		
		
		int numResult = fraction1.getNumerator() + fraction2.getNumerator() - fraction3.getNumerator();
		int commonDenominator = fraction1.getDenominator();
		
		return new Fraction(numResult, commonDenominator);
	}
	
	public Fraction multiply() {
		int numResult = fraction1.getNumerator() * fraction2.getNumerator();
		int denResult = fraction1.getDenominator() * fraction2.getDenominator();
		
		return new Fraction (numResult, denResult);
	}
	
	public Fraction divide() {
		Fraction f2Recipricol = fraction2.getRecipricol();
		
		int numResult = fraction1.getNumerator() * f2Recipricol.getNumerator();
		int denResult = fraction1.getDenominator() * f2Recipricol.getDenominator();
		
		return new Fraction (numResult, denResult);
	}
	
	public Fraction getSolution() {
		return solution;
	}
	
	public String getSolutionString() {
		String temp = solution.toString();
		return temp;
	}
	
	public double getSolutionValue() {
		return solution.getValue();
	}
}
