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
	private boolean hasBeenDrawn;
	
	public Question() {
		
	}
	
	public Question(String text, QuestionType type, int level) {
		this.rawText = text;
		this.type = type;
		this.level = level;
		this.hasBeenDrawn = false;
		solution = new Fraction();
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
		
		if (type == QuestionType.WORD1 || type == QuestionType.WORD2 || type == QuestionType.WORD3 || type == QuestionType.WORD4 || type == QuestionType.WORD5) {
			while (randNumerator > randDenominator) {
				randNumerator = rand.nextInt(initial + levelScaling) + 1;
			}
		}
		
		return new Fraction(randNumerator, randDenominator);
	}	
	
	private void formatText() {
		String firstFractionText = fraction1.getNumerator() + "/" + fraction1.getDenominator();
		rawText = rawText.replace("{FRACTION1}", firstFractionText);
		
		if (fraction2 != null) {
			String secondFractionText = fraction2.getNumerator() + "/" + fraction2.getDenominator();
			rawText = rawText.replace("{FRACTION2}", secondFractionText);			
		}
		else {
			
		}
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
				solution = less();
				break;
				
			case GREATER:
				solution = greater();
				break;
				
			case EQUAL:
				solution = equals();
				break;
				
			case WORD1:
				Fraction temp = fraction1;
				fraction1 = new Fraction(1, 1);
				fraction2 = temp;
				solution = subtract();
				break;
				
			case WORD2:
			case WORD3:
				int qNum = 20;
				fraction1.setNumerator(fraction1.getNumerator() * qNum);
				Fraction tempFrac = fraction1;
				fraction1 = new Fraction(qNum, 1);
				fraction2 = tempFrac;
				solution = subtract();
				break;
				
			case WORD4:
				qNum = 24;
				fraction1.setNumerator(fraction1.getNumerator() * qNum);
				Fraction tempFrac2 = fraction1;
				fraction1 = new Fraction(qNum, 1);
				fraction2 = tempFrac2;
				solution = subtract();
				break;
				
			case WORD5:
				solution = subtract();
				break;
		}
	}
	
	private Fraction less() {
		if (fraction1.isLessThan(fraction2.value)) {
			return new Fraction(1, 1);
		}
		return new Fraction(0, 1);
	}
	
	private Fraction greater() {
		if (fraction1.isGreaterThan(fraction2.value)) {
			return new Fraction(1, 1);
		}
		return new Fraction(0, 1);
	}
	
	private Fraction equals() {
		if (fraction1.equals(fraction2)) {
			return new Fraction(1, 1);
		}
		
		return new Fraction(0, 1);
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

	public boolean isHasBeenDrawn() {
		return hasBeenDrawn;
	}

	public void setHasBeenDrawn(boolean hasBeenDrawn) {
		this.hasBeenDrawn = hasBeenDrawn;
	}
	
	public QuestionType getType() {
		return type;
	}
	
}
