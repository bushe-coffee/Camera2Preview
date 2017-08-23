package com.test.jnicamera.dialogUtils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.test.jnicamera.R;

public class SystemDialog {

    private static SystemDialog Instance = null;

    private SystemDialog() {
    }

    public static SystemDialog getInstance() {
        if (Instance == null) {
            synchronized (SystemDialog.class) {
                Instance = new SystemDialog();
            }
        }

        return Instance;
    }

    public void showPositiveDialog(Activity activity, String message,
                                          DialogResultCallBack callBack) {
        if (activity != null && !activity.isFinishing()) {
            BaseDialog dialog = new BaseDialog();
            dialog.setDialog(getPositiveDialog(activity, message, callBack));
            dialog.show(activity.getFragmentManager(), "System Dialog contain positive button");
        }
    }

    //***********************************************************************

    private static AlertDialog.Builder createAlertDialogBuilder(@NonNull final Context context) {
        AlertDialog.Builder builder;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(context, R.style.Theme_AppCompat_Dialog);
        } else {
            builder = new AlertDialog.Builder(context);
        }

        return builder;
    }

    private Dialog getPositiveDialog(Context context, String messageId, final DialogResultCallBack callBack) {
        AlertDialog.Builder builder = createAlertDialogBuilder(context);
        builder.setMessage(messageId)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if (callBack != null) {
                            Bundle data = new Bundle();
                            data.putString("result", "sure");
                            callBack.onDialogConfirm(data);
                        }
                    }
                });

        return builder.create();
    }
}
