package com.example.smdprojectfinal.OC;

public class ScoreData {
    String WinnerName,WinnerScore,RunnerName,RunnerScore;

    public ScoreData(String winnerName, String winnerScore, String runnerName, String runnerScore) {
        WinnerName = winnerName;
        WinnerScore = winnerScore;
        RunnerName = runnerName;
        RunnerScore = runnerScore;
    }

    public void setWinnerName(String winnerName) {
        WinnerName = winnerName;
    }

    public void setWinnerScore(String winnerScore) {
        WinnerScore = winnerScore;
    }

    public void setRunnerName(String runnerName) {
        RunnerName = runnerName;
    }

    public void setRunnerScore(String runnerScore) {
        RunnerScore = runnerScore;
    }

    public String getWinnerName() {
        return WinnerName;
    }

    public String getWinnerScore() {
        return WinnerScore;
    }

    public String getRunnerName() {
        return RunnerName;
    }

    public String getRunnerScore() {
        return RunnerScore;
    }
}
