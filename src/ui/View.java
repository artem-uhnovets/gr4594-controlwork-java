package ui;

import presenter.Presenter;

public interface View {
    void start();
    void print(String text);
    void setPresenter(Presenter presenter);
    Presenter getPresenter();
    public void repeatLine();
}
