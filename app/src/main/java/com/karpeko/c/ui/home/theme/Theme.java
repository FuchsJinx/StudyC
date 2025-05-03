package com.karpeko.c.ui.home.theme;

public class Theme {
    private int id;
    private String title;
    private boolean isChecked;

    public Theme(int id, String title) {
        this.id = id;
        this.title = title;
        this.isChecked = false;
    }

    public int getId() { return id; }
    public String getTitle() {return title;}

    public boolean isChecked() { return isChecked; }
    public void setChecked(boolean checked) { isChecked = checked; }
}
