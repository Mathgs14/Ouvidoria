/**
 * The Feedback class represents feedback submitted by users in the system.
 */
package entities;

public class Feedback {
    private String type;
    private String feedback;
    private int authorMatricula;
    private int Id;

    /**
     * Constructor for creating a new Feedback object.
     * @param type The type/category of feedback
     * @param feedback The content of the feedback
     * @param authorMatricula The student ID of the author
     * @param id The unique ID of the feedback
     */
    public Feedback (String type, String feedback, int authorMatricula, int id){
        this.type = type;
        this.feedback = feedback;
        this.authorMatricula = authorMatricula;
        this.Id = id;
    }

    /**
     * Getter method for retrieving the feedback content.
     * @return The content of the feedback
     */
    public String getFeedback() {
        return feedback;
    }

    /**
     * Setter method for setting the feedback content.
     * @param feedback The content of the feedback
     */
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    /**
     * Getter method for retrieving the author's student ID.
     * @return The student ID of the author
     */
    public int getauthorMatricula() {
        return authorMatricula;
    }

    /**
     * Setter method for setting the author's student ID.
     * @param authorMatricula The student ID of the author
     */
    public void setauthorMatricula(int authorMatricula) {
        this.authorMatricula = authorMatricula;
    }

    /**
     * Getter method for retrieving the type/category of feedback.
     * @return The type/category of feedback
     */
    public String getType() {
        return type;
    }

    /**
     * Setter method for setting the type/category of feedback.
     * @param type The type/category of feedback
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Getter method for retrieving the unique ID of the feedback.
     * @return The unique ID of the feedback
     */
    public int getId() {
        return Id;
    }

    /**
     * Setter method for setting the unique ID of the feedback.
     * @param id The unique ID of the feedback
     */
    public void setId(int id) {
        Id = id;
    }

    /**
     * Overrides the toString method to provide a string representation of the Feedback object.
     * @return A string representation of the Feedback object
     */
    @Override
    public String toString(){
        String feedbackString = "id:" + this.Id + "tipo: " + this.type + "|\n" +
                "| " + this.feedback+ "|\n";
        return feedbackString;
    }
}
