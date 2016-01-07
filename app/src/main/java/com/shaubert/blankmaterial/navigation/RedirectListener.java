package com.shaubert.blankmaterial.navigation;

public interface RedirectListener {

    boolean onRedirect(Jumper jumper, ActivityStack.Record record, ActivityStack stack);

}