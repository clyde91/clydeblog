package com.clyde.blog.model;

import java.util.List;

/**
 * @author clyde
 */
public class ArchitectureGuessDTO {
    private String photo;
    private Integer type;
    private List<String> options;
    private Integer answer;
    private String question;

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "ArchitectureGuessDTO{" +
                "photo='" + photo + '\'' +
                ", type=" + type +
                ", options=" + options +
                ", answer=" + answer +
                ", question='" + question + '\'' +
                '}';
    }
}
