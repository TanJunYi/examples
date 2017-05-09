package net.irext.ircontrol.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import net.irext.ircontrol.R;
import net.irext.webapi.model.StbOperator;

import java.util.List;

/**
 * Filename:       OperatorAdapter.java
 * Revised:        Date: 2017-04-10
 * Revision:       Revision: 1.0
 * <p>
 * Description:    Adapter class of STB Operator
 * <p>
 * Revision log:
 * 2017-04-10: created by strawmanbobi
 */
public class OperatorAdapter extends BaseAdapter {

    private List<StbOperator> mOperators;
    private LayoutInflater mInflater;

    public OperatorAdapter(Context ctx, List<StbOperator> list) {
        this.mOperators = list;
        this.mInflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public OperatorAdapter(Context ctx) {
        this.mInflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setOperators(List<StbOperator> list) {
        this.mOperators = list;
    }

    @Override
    public int getCount() {
        return mOperators.size();
    }

    @Override
    public Object getItem(int position) {
        return mOperators.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_operator, parent, false);
            holder.textView = (TextView)convertView.findViewById(R.id.tv_operator_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }
        holder.textView.setText(mOperators.get(position).getOperator_name());
        return convertView;
    }

    private static class ViewHolder {
        TextView textView;
    }
}
