package entities;

public class Feedback {
    private String type;
    private String feedback;
    private int author;
    private int Id;

    public Feedback (String type, String feedback, int author, int id){
        this.type = type;
        this.feedback = feedback;
        this.author = author;
        this.Id = id;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    @Override
    public String toString(){

        String feedbackString = this.Id + " -> tipo: " + this.type + "|\n" +
                                "| " + this.feedback+ "|\n";

        return feedbackString;
    }
}
