package com.web.java;

import java.util.Scanner;

public class HangMan_49 {

	
	    private static final String[] WORDS = {"java", "programming", "hangman", "computer", "algorithm", "openai"};
	    private static final int MAX_TRIES = 6;

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        String wordToGuess = selectRandomWord().toLowerCase();
	        char[] guessedLetters = new char[wordToGuess.length()];
	        for (int i = 0; i < guessedLetters.length; i++) {
	            guessedLetters[i] = '_';
	        }

	        int attemptsLeft = MAX_TRIES;
	        boolean wordGuessed = false;

	        System.out.println("Welcome to Hangman!");
	        System.out.println("Guess the word:");

	        while (attemptsLeft > 0 && !wordGuessed) {
	            System.out.println("\nAttempts left: " + attemptsLeft);
	            System.out.println("Current word: " + String.valueOf(guessedLetters));

	            System.out.print("Enter a letter: ");
	            char guess = scanner.next().toLowerCase().charAt(0);

	            boolean found = false;
	            for (int i = 0; i < wordToGuess.length(); i++) {
	                if (wordToGuess.charAt(i) == guess) {
	                    guessedLetters[i] = guess;
	                    found = true;
	                }
	            }

	            if (!found) {
	                attemptsLeft--;
	                System.out.println("Incorrect guess!");
	            }

	            if (String.valueOf(guessedLetters).equals(wordToGuess)) {
	                wordGuessed = true;
	            }
	        }

	        if (wordGuessed) {
	            System.out.println("Congratulations! You guessed the word: " + wordToGuess);
	        } else {
	            System.out.println("Sorry, you've run out of attempts. The word was: " + wordToGuess);
	        }

	        scanner.close();
	    }

	    private static String selectRandomWord() {
	        return WORDS[(int) (Math.random() * WORDS.length)];
	    }
	}

