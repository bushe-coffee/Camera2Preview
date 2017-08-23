package com.test.jnicamera.dialogUtils;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.NonNull;

public class BaseDialog extends DialogFragment {

    private Dialog mDialog = null;

    public void setDialog(@NonNull final Dialog dialog) {
        this.mDialog = dialog;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return mDialog;
    }
}
