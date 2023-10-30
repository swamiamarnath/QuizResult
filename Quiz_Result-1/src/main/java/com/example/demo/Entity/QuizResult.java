package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class QuizResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Use Long instead of String for ID
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getQuizCategory() {
		return quizCategory;
	}

	public void setQuizCategory(String quizCategory) {
		this.quizCategory = quizCategory;
	}

	public String getQuizLevel() {
		return quizLevel;
	}

	public void setQuizLevel(String quizLevel) {
		this.quizLevel = quizLevel;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	private String userName;
    private int score;
    private String quizCategory;
    private String quizLevel;
    private String feedback;

   

    public QuizResult(String userName, int score, String quizCategory, String quizLevel, String feedback) {
        this.userName = userName;
        this.score = score;
        this.quizCategory = quizCategory;
        this.quizLevel = quizLevel;
        this.feedback = feedback;
    }

    public QuizResult() {
        // Default constructor
    }
}
