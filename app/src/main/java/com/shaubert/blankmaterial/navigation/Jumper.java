package com.shaubert.blankmaterial.navigation;


public interface Jumper extends com.shaubert.ui.jumper.Jumper {

    void setRedirectListener(RedirectListener redirectListener);

    void processRedirectStack(ActivityStack stack);

}
