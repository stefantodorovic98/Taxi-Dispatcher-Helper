package com.example.taxidispatcher.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.taxidispatcher.R;
import com.example.taxidispatcher.model.Street;

import java.util.List;

public class CustomBaseAdapter extends BaseAdapter {

    private Context context;
    private List<Street> streetList;
    LayoutInflater layoutInflater;

    public CustomBaseAdapter(Context context, List<Street> streetList) {
        this.context = context;
        this.streetList = streetList;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return this.streetList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View convertView = layoutInflater.inflate(R.layout.street_row, null);

        TextView streetName = convertView.findViewById(R.id.streetName);
        streetName.setText(streetList.get(i).getName());

        TextView option1 = convertView.findViewById(R.id.option1);
        option1.setText(streetList.get(i).getOption_1());

        TextView option2 = convertView.findViewById(R.id.option2);
        option2.setText(streetList.get(i).getOption_2());

        TextView option3 = convertView.findViewById(R.id.option3);
        option3.setText(streetList.get(i).getOption_3());

        return convertView;
    }
}
