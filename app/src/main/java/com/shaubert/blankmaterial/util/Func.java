package com.shaubert.blankmaterial.util;

public interface Func<PARAM, RESULT> {
    RESULT perform(PARAM param);
}
