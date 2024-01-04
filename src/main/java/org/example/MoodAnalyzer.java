package org.example;

public class MoodAnalyzer {
    private String message;
    public MoodAnalyzer() {
        this.message = "I am in Happy Mood";//"I am in Sad Mood";
    }
    public MoodAnalyzer(String message) {
        this.message = message;
    }
    public String analyseMood() throws MoodAnalysisException {
        try {
            if (message == null) {
                throw new MoodAnalysisException(MoodAnalysisError.NULL_MOOD, "Message is null");
            } else if (message.trim().isEmpty()) {
                throw new MoodAnalysisException(MoodAnalysisError.EMPTY_MOOD, "Message is empty");
            } else if (message.contains("Any Mood")) {
                return "HAPPY";
            } else if (message.contains("Sad")) {
                return "SAD";
            } else if (message.contains("Happy")) {
                return "HAPPY";
            }
            throw new MoodAnalysisException(MoodAnalysisError.INVALID_MOOD, "Invalid mood");
        } catch (NullPointerException e) {
            throw new MoodAnalysisException(MoodAnalysisError.NULL_MOOD, "Message is null");
        }
    }
}
