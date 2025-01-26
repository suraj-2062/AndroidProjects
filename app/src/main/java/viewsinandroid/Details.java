package viewsinandroid;

public class Details {
    private int imageview;
    private String textview;

    public Details(int imageview,String textview){
        this.imageview=imageview;
        this.textview=textview;
    }

    public int getImageView() {
        return imageview;
    }

    public String getTextView() {
        return textview;
    }
}
