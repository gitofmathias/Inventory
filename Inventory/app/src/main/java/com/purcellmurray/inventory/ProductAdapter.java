package com.purcellmurray.inventory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dodobal-1 on 9/2/16.
 */
public class ProductAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<Product> mDataSource;

    public ProductAdapter(Context context, ArrayList<Product> items) {
        mContext = context;
        mDataSource = items;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mDataSource.size();
    }

    //2
    @Override
    public Object getItem(int position) {
        return mDataSource.get(position);
    }

    //3
    @Override
    public long getItemId(int position) {
        return position;
    }

    //4
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get view for row item
        View rowView = mInflater.inflate(R.layout.list_item_product, parent, false);

        TextView modelTextView =
                (TextView) rowView.findViewById(R.id.product_list_model);

        TextView descriptionTextView =
                (TextView) rowView.findViewById(R.id.product_list_description);

        Product product = (Product) getItem(position);
        modelTextView.setText(product.title);
        descriptionTextView.setText(product.description);
        return rowView;
    }
}
