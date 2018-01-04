package me.gujun.android.taggroup.demo;

import android.app.DatePickerDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.TextView;

import me.gujun.android.taggroup.TagGroup;

/**
 * Created by X on 12/23/2017.
 */

public class DateRangePicker extends FrameLayout {
    public DateRangePicker(@NonNull Context context) {
        this(context, null);
    }

    public DateRangePicker(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DateRangePicker(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(@NonNull Context context) {
        View view = inflate(context, R.layout.view_date_tag, this);

        TagGroup tagGroup = (TagGroup) view.findViewById(R.id.tag_group);
        TextView dateStart = (TextView) view.findViewById(R.id.tv_date_start);
        TextView dateTo = (TextView) view.findViewById(R.id.tv_date_to);

        tagGroup.setTags("今天", "本周", "本月", "本季度", "上月", "上周", "上季度", "本年");
        tagGroup.setOnTagClickListener(new TagGroup.OnTagClickListener() {
            @Override
            public void onTagClick(String tag) {

            }
        });
        dateStart.setOnClickListener(onClickListener);
        dateTo.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            final TextView textView = (TextView) view;
            DatePickerDialog datePickerDialog = new DatePickerDialog(view.getContext(), new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    textView.setText(year + "-" + (month + 1) + "-" + dayOfMonth + " 00:00");
                }
            }, 2017, 12, 25);
            datePickerDialog.show();
        }
    };
}
