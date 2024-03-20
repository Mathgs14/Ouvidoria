package util;

import entities.Feedback;

import java.util.ArrayList;

public class FeedbackList {
    ArrayList<Feedback> feedbackList;

    int feedbackID;

    public ArrayList<Feedback> getFeedbackList() {
        return feedbackList;
    }

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
            if(feedback.getauthorMatricula()==(matricula)){
                list.add(feedback);
            }
        }
        return list;
    }


    public void deleteFeedbacks(int feedbackID) {
        try {
            this.feedbackList.removeIf(feedback -> feedback.getId() == feedbackID);
        }catch (Exception e){
            System.out.println("FeedBack não encontrado");
        }

    }


    public void printUserFeedback(int userMatricula){
        if(this.feedbackList.size() == 0){
            System.out.println("Nenhum feedback foi feito");
        }
        else{
            for (Feedback currentFeedback : this.feedbackList) {
                if (currentFeedback.getauthorMatricula() == userMatricula) {
                    System.out.println(currentFeedback);
                }
            }
        }
    }


    public void printAllFeedbacks(){
        if(this.feedbackList.size() == 0){
            System.out.println("Nenhum feedback foi feito");
        }
        else {
            for (Feedback feedback : this.feedbackList) {
                System.out.println(feedback);
            }
        }
    }

    public void deleteAll() {
        this.feedbackList.clear();
    }
}
