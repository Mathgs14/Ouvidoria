package util;

import entities.Feedback;

import java.util.ArrayList;

public class FeedbackList {
    ArrayList<Feedback> feedbackList;

    int feedbackID;

    public FeedbackList() {
        this.feedbackList = new ArrayList<Feedback>();
        this.feedbackID = 0;
    }

    public void addFeedback(String tipo, String manifestacao, int autor) {
        Feedback feedback = new Feedback(tipo, manifestacao, autor, feedbackID);
        this.feedbackList.add(feedback);

        this.feedbackID += 1;
    }

    public void addFeedback(Feedback feedback) {
        this.feedbackList.add(feedback);
    }

    public ArrayList<Feedback> all(){
        ArrayList<Feedback> list = new ArrayList<Feedback>();
        for (Feedback feedback : this.feedbackList) {
            list.add(feedback);
        }
        return list;
    }

    public ArrayList<Feedback> userFeedbackByMatricula(int matricula){
        ArrayList<Feedback> list = new ArrayList<Feedback>();

        for (Feedback feedback : this.feedbackList) {
            if(feedback.getAuthor()==(matricula)){
                list.add(feedback);
            }
        }
        return list;
    }

    public void deleteFeedbacks(int feedbackID) {
        try {
            for (Feedback feedback : this.feedbackList) {
                if(feedback.getId() == feedbackID){
                    feedbackList.remove(feedback);

                }
            }
        }catch (Exception e){
            System.out.println("FeedBack não encontrado");
        }

    }

    public void deleteAll() {
        this.feedbackList.clear();
    }
}
