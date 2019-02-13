package com.example.art.pokemon_go_alpha;
import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * Класс выставляет значение высоты равное значению ширины.
 */
public class SquareImageView extends AppCompatImageView {

    public SquareImageView(Context context) {
        super(context, null);
    }

    public SquareImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        setMeasuredDimension(width, width);
    }
}