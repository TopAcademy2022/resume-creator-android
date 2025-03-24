package resume.creator.android;

import android.graphics.drawable.Drawable;

public class CardItem {
    private String title;
    private Drawable imageVelue;

    public CardItem(String title, Drawable imageVelue) {
        this.title = title;
        this.imageVelue = imageVelue;
    }

    public String getTitle() {
        return title;
    }

    public Drawable getImageVelue() {
        return imageVelue;
    }

}
