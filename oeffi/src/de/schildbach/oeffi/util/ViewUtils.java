package de.schildbach.oeffi.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewParent;

import de.schildbach.pte.dto.Style;

public class ViewUtils {
    public static void setVisibility(final View view, final boolean visible) {
        view.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    public static boolean isVisible(final View view) {
        View v = view;
        while (v != null) {
            final int visibility = view.getVisibility();
            if (visibility != View.VISIBLE)
                return false;
            final ViewParent parent = v.getParent();
            if (!(parent instanceof View))
                break;
            v = (View) parent;
        }
        return true;
    }

    public static void drawOutlinedText(Canvas canvas, CharSequence text, float x, float y, int labelColor, Paint paint, float density) {
        final int strokeColor = Style.deriveForegroundColor(labelColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(strokeColor);
        paint.setStrokeWidth(density * 2);
        canvas.drawText(text, 0, text.length(), x, y, paint);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(labelColor);
        canvas.drawText(text, 0, text.length(), x, y, paint);
    }
}
