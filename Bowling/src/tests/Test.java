package tests;

import bowling.BowlingGame;
import static org.junit.jupiter.api.Assertions.*;


class Test {
	
	@org.junit.jupiter.api.Test
	public void testBowlingGameCreate() {
		BowlingGame bowlingGame = new BowlingGame();
		assertNotNull(bowlingGame);
		
	}
	
	@org.junit.jupiter.api.Test
	public void testRoll() {
		BowlingGame bowlingGame = new BowlingGame();
		
		bowlingGame.roll(0);
		assertEquals(0, bowlingGame.getResults(0,0));
		
		bowlingGame.roll(1);
		assertEquals(1, bowlingGame.getResults(0,1));
		
		bowlingGame.roll(2);
		assertEquals(2, bowlingGame.getResults(1,0));
		
		bowlingGame.roll(3);
		assertEquals(3, bowlingGame.getResults(1,1));
		
		bowlingGame.roll(4);
		assertEquals(4, bowlingGame.getResults(2,0));
		
		bowlingGame.roll(5);
		assertEquals(5, bowlingGame.getResults(2,1));
		
		bowlingGame.roll(6);
		assertEquals(6, bowlingGame.getResults(3,0));
		
		bowlingGame.roll(4);
		assertEquals(4, bowlingGame.getResults(3,1));
		
		bowlingGame.roll(10);
		assertEquals(10, bowlingGame.getResults(4,0));
		assertEquals(0, bowlingGame.getResults(4,1));
		
		bowlingGame.roll(9);
		assertEquals(9, bowlingGame.getResults(5,0));
		
		bowlingGame.roll(0);
		assertEquals(0, bowlingGame.getResults(5,1));
		
		bowlingGame.roll(9);
		assertEquals(9, bowlingGame.getResults(6,0));
		
		bowlingGame.roll(0);
		assertEquals(0, bowlingGame.getResults(6,1));
		
		bowlingGame.roll(8);
		assertEquals(8, bowlingGame.getResults(7,0));
		
		bowlingGame.roll(1);
		assertEquals(1, bowlingGame.getResults(7,1));
		
		bowlingGame.roll(7);
		assertEquals(7, bowlingGame.getResults(8,0));
		
		bowlingGame.roll(2);
		assertEquals(2, bowlingGame.getResults(8,1));
		
		bowlingGame.roll(6);
		assertEquals(6, bowlingGame.getResults(9,0));
		
		bowlingGame.roll(3);
		assertEquals(3, bowlingGame.getResults(9,1));
		
		bowlingGame.roll(5);
		assertEquals(0, bowlingGame.getResults(10,0));
		assertEquals(0, bowlingGame.getResults(10,1));
		
		
	}

	@org.junit.jupiter.api.Test
	public void testCalculateScoreAllSpares() {
		BowlingGame bowlingGame = new BowlingGame();
		
		bowlingGame.roll(5);
		bowlingGame.roll(5);
		assertEquals(10, bowlingGame.calculateScore());
	
		bowlingGame.roll(5);
		bowlingGame.roll(5);
		assertEquals(25, bowlingGame.calculateScore());
		
		bowlingGame.roll(5);
		bowlingGame.roll(5);
		assertEquals(40, bowlingGame.calculateScore());
		
		bowlingGame.roll(5);
		bowlingGame.roll(5);
		assertEquals(55, bowlingGame.calculateScore());
		
		bowlingGame.roll(5);
		bowlingGame.roll(5);
		assertEquals(70, bowlingGame.calculateScore());
		
		bowlingGame.roll(5);
		bowlingGame.roll(5);
		assertEquals(85, bowlingGame.calculateScore());
		
		bowlingGame.roll(5);
		bowlingGame.roll(5);
		assertEquals(100, bowlingGame.calculateScore());
		
		bowlingGame.roll(5);
		bowlingGame.roll(5);
		assertEquals(115, bowlingGame.calculateScore());
		
		bowlingGame.roll(5);
		bowlingGame.roll(5);
		assertEquals(130, bowlingGame.calculateScore());
		
		bowlingGame.roll(5);
		bowlingGame.roll(5);
		assertEquals(145, bowlingGame.calculateScore());
				
		bowlingGame.roll(5);
		assertEquals(150, bowlingGame.calculateScore());
		
		bowlingGame.roll(4);
		assertEquals(5, bowlingGame.getResults(10, 0));
		assertEquals(0, bowlingGame.getResults(10, 1));
		
	}
	
	@org.junit.jupiter.api.Test
	public void testCalculateScoreAllStrikes() {
		BowlingGame bowlingGame = new BowlingGame();
		
		bowlingGame.roll(10);
		assertEquals(10, bowlingGame.calculateScore());
		
		bowlingGame.roll(10);
		assertEquals(30, bowlingGame.calculateScore());

		bowlingGame.roll(10);
		assertEquals(60, bowlingGame.calculateScore());
		
		bowlingGame.roll(10);
		assertEquals(90, bowlingGame.calculateScore());
		
		bowlingGame.roll(10);
		assertEquals(120, bowlingGame.calculateScore());
		
		bowlingGame.roll(10);
		assertEquals(150, bowlingGame.calculateScore());
		
		bowlingGame.roll(10);
		assertEquals(180, bowlingGame.calculateScore());
		
		bowlingGame.roll(10);
		assertEquals(210, bowlingGame.calculateScore());
		
		bowlingGame.roll(10);
		assertEquals(240, bowlingGame.calculateScore());
		
		bowlingGame.roll(10);
		assertEquals(270, bowlingGame.calculateScore());
		
		bowlingGame.roll(10);
		assertEquals(290, bowlingGame.calculateScore());
		
		bowlingGame.roll(10);
		assertEquals(300, bowlingGame.calculateScore());
	}
	
	@org.junit.jupiter.api.Test
	public void testExceptions() {
		BowlingGame bowlingGame = new BowlingGame();
		
		Exception exception = assertThrows(Exception.class, () -> bowlingGame.roll(-1));
		assertEquals("Pins can't be negative!", exception.getMessage());
		
		exception = assertThrows(Exception.class, () -> bowlingGame.roll(11));
		assertEquals("Pins can't be greater than 10!", exception.getMessage());
		
		bowlingGame.roll(5);
		exception = assertThrows(Exception.class, () -> bowlingGame.roll(6));
		assertEquals("Sum of pins in frame can't be greater than 10!", exception.getMessage());
	}
	
	
}
