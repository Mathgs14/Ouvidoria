/**
 * The FeedbackList class manages a list of feedback submissions.
 * It provides functionality to add, retrieve, delete, and print feedback submissions.
 */
package util;

import entities.Feedback;
import java.util.ArrayList;

public class FeedbackList {
    private ArrayList<Feedback> feedbackList;
    private int feedbackID;

    /**
     * Constructor for creating a new FeedbackList object.
     * Initializes the list of feedback submissions and sets the initial feedback ID.
     */
    public FeedbackList() {
        this.feedbackList = new ArrayList<>();
        this.feedbackID = 0;
    }

    /**
     * Retrieves the list of feedback submissions.
     * @return The list of feedback submissions
     */
    public ArrayList<Feedback> getFeedbackList() {
        return feedbackList;
    }

    /**
     * Adds a new feedback submission to the list.
     * @param tipo The type/category of feedback
     * @param manifestacao The content of the feedback
     * @param autor The student ID of the author
     */
    public void addFeedback(String tipo, String manifestacao, int autor) {
        Feedback feedback = new Feedback(tipo, manifestacao, autor, feedbackID);
        this.feedbackList.add(feedback);
        this.feedbackID++;
    }

    /**
     * Adds a new feedback submission to the list.
     * @param feedback The Feedback object representing the new feedback submission
     */
    public void addFeedback(Feedback feedback) {
        this.feedbackList.add(feedback);
    }

    /**
     * Retrieves all feedback submissions from the list.
     * @return An ArrayList containing all feedback submissions
     */
    public ArrayList<Feedback> all(){
        return new ArrayList<>(this.feedbackList);
    }

    /**
     * Retrieves feedback submissions submitted by a specific user.
     * @param matricula The student ID of the user whose feedback submissions are to be retrieved
     * @return An ArrayList containing feedback submissions submitted by the specified user
     */
    public ArrayList<Feedback> userFeedbackByMatricula(int matricula){
        ArrayList<Feedback> list = new ArrayList<>();
        for (Feedback feedback : this.feedbackList) {
            if(feedback.getauthorMatricula() == matricula){
                list.add(feedback);
            }
        }
        return list;
    }

    /**
     * Deletes a specific feedback submission from the list.
     * @param feedbackID The unique ID of the feedback submission to be deleted
     */
    public void deleteFeedbacks(int feedbackID) {
        this.feedbackList.removeIf(feedback -> feedback.getId() == feedbackID);
    }

    /**
     * Prints feedback submissions submitted by a specific user.
     * @param userMatricula The student ID of the user whose feedback submissions are to be printed
     */
    public void printUserFeedback(int userMatricula){
        boolean hasFeedback = false;
        for (Feedback currentFeedback : this.feedbackList) {
            if (currentFeedback.getauthorMatricula() == userMatricula) {
                System.out.println(currentFeedback);
                hasFeedback = true;
            }
        }
        if (!hasFeedback) {
            System.out.println("Nenhum feedback foi feito por este usuário.");
        }
    }

    /**
     * Prints all feedback submissions.
     */
    public void printAllFeedbacks(){
        if(this.feedbackList.isEmpty()){
            System.out.println("Nenhum feedback foi feito.");
        } else {
            for (Feedback feedback : this.feedbackList) {
                System.out.println(feedback);
            }
        }
    }

    /**
     * Deletes all feedback submissions from the list.
     */
    public void deleteAll() {
        this.feedbackList.clear();
    }
}
