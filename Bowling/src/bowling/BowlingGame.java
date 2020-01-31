package bowling;

public class BowlingGame {
	private int[][] results;
	static final int maxFrame = 10;
	static final int maxAttempt = 2;
	static final int maxPins = 10;
	private int frame;
	private int attempt;
	private boolean finished;
	private int additionalRolls;
	
	public BowlingGame() {
		results = new int[maxFrame+1][maxAttempt];
		resetScore();
	}
	
	public void resetScore() {
		for(int i=0; i<maxFrame+1; i++) {
			for(int j=0; j<maxAttempt; j++) {
				results[i][j] = 0;
			}
		}
		frame = 0;
		attempt = 0;
		finished = false;
		additionalRolls = 0;
	}
	
	public void roll(int pins) {
		if(isFinished()) {
			return;
		}
		checkPins(pins);
		setResults(pins);
		checkIfNeedAdditionalRolls();
		checkIfFinished();
		incrementFrameAndAttempt();
	}
	
	public int calculateScore() {
		return calculateBasicScore() + calculateBonusScore();
	}
	
	public int calculateBasicScore() {
		int score = 0;
		for(int i = 0; i < maxFrame; i++) {
			score += sumFrameScore(i);
		}
		return score;
	}
	
	public int calculateBonusScore() {
		int bonusScore = 0;
		for(int i = 0; i < maxFrame; i++) {
			if(isStrike(i)) {
				bonusScore += nextTwoRollsScore(i);
			}
			else if (isSpare(i)) {
				bonusScore += nextRollScore(i);
			}
		}
		return bonusScore;
	}
	
	
	
	public int getResults(int i,int j) {
		return results[i][j];
	}
	
	private void setResults(int pins) {
		results[frame][attempt] = pins;
	}
	
	private void checkPins(int pins) {
		if(pins < 0) {
			throw new IllegalArgumentException("Pins can't be negative!"); 
		}
		else if(pins > 10) {
			throw new IllegalArgumentException("Pins can't be greater than 10!"); 
		}
		else if(attempt == 1 && pins + getResults(frame, 0) > 10 && frame < maxAttempt) {
			throw new IllegalArgumentException("Sum of pins in frame can't be greater than 10!"); 
		}
		
	}
	private boolean isStrike(int frame) {
		return (getResults(frame, 0) == maxPins) ? true : false;
	}
	
	private boolean isSpare(int frame) {
		return (sumFrameScore(frame) == maxPins) ? true : false;
	}
	
	private void incrementFrameAndAttempt() {
		if((isStrike(frame) && frame < maxFrame) || attempt == 1) {
			frame++;
			attempt = 0;
		}
		else {
			attempt++;
		}
		
	}
	
	private void checkIfNeedAdditionalRolls() {
		if(frame == maxFrame - 1) {
			if(isStrike(maxFrame-1)) 
				additionalRolls = 2;
			else if(isSpare(maxFrame-1)) 
				additionalRolls = 1;
			else
				additionalRolls = 0;
		}
	}
	
	private boolean isFinished() {
		return finished;
	}
	
	private void checkIfFinished() {
		if((frame == maxFrame-1 && attempt == 1 && additionalRolls == 0) 
				|| (frame == maxFrame && attempt == 0 && additionalRolls == 1)
				|| (frame == maxFrame && attempt == 1 && additionalRolls == 2)) {
			finished = true;
		}
	}
	
	private int nextTwoRollsScore(int frame) {
		int score = getResults(frame+1, 0);
		if(isStrike(frame+1) && frame < maxFrame-1) {
			score += getResults(frame+2, 0);
		}
		else{
			score += getResults(frame+1, 1);
		}
		return score;
	}
	
	private int nextRollScore(int frame) {
		return getResults(frame+1, 0);
	}
	
	public int sumFrameScore(int frame) {
		return getResults(frame, 0) + getResults(frame, 1);
		
	}
}
