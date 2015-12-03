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
	private double solution;
	Random rand = new Random();
	
	public Question(String text, QuestionType type, int level) {
		this.rawText = text;
		this.type = type;
		this.level = level;
		
		generateFractions();
		computeSolution();
		formatText();
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
				
				break;
				
			case ADD:
				break;
				
			case SUBADD:
				break;
				
			case ADDSUB:
				break;
				
			case MULTIPLY:
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
}
