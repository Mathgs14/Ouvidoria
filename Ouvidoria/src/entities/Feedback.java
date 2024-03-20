package entities;

public class Feedback {
    private String type;
    private String feedback;
    private int authorMatricula;
    private int Id;


    public Feedback (String type, String feedback, int authorMatricula, int id){
        this.type = type;
        this.feedback = feedback;
        this.authorMatricula = authorMatricula;
        this.Id = id;
    }

    public String getFeedback() {
        return feedback;
    }


    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }


    public int getauthorMatricula() {
        return authorMatricula;
    }


    public void setauthorMatricula(int authorMatricula) {
        this.authorMatricula = authorMatricula;
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

        String feedbackString = "id:" + this.Id + "tipo: " + this.type + "|\n" +
                                "| " + this.feedback+ "|\n";

        return feedbackString;
    }
}
