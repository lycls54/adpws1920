package main.java.de.haw.adp.exercise1;

public class Element {
    private Element pred;
    private Element succ;
    private String content;
    private int index;

    public Element() {
    }

    public Element(String content) {
        this.content = content;
    }

    public Element getPred() {
        return pred;
    }

    public void setPred(Element pred) {
        this.pred = pred;
    }

    public Element getSucc() {
        return succ;
    }

    public void setSucc(Element succ) {
        this.succ = succ;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
