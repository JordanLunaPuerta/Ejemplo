package pe.edu.utp.carcare.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pe.edu.utp.carcare.R;
import pe.edu.utp.carcare.models.FuelUpEntry;

/**
 * Created by GrupoUTP on 03/06/2017.
 */

public class EntriesAdapter extends
        RecyclerView.Adapter<EntriesAdapter.ViewHolder> {
    private List<FuelUpEntry> entries;
    @Override
    public EntriesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.content_entry, parent,false));
    }

    @Override
    public void onBindViewHolder(EntriesAdapter.ViewHolder holder, int position) {
        holder.gallonsTextView.setText(entries.get(position).getGallonsAsString());
        holder.totalPriceTextView.setText(entries.get(position).getTotalPriceAsString());
        holder.contextTextView.setText(entries.get(position).getContext());
    }

    @Override
    public int getItemCount() {
        return entries.size();
    }

    public List<FuelUpEntry> getEntries() {
        return entries;
    }

    public EntriesAdapter setEntries(List<FuelUpEntry> entries) {
        this.entries = entries;
        return this;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView gallonsTextView;
        TextView totalPriceTextView;
        TextView contextTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            gallonsTextView = (TextView) itemView.findViewById(R.id.gallonsTextView);
            totalPriceTextView = (TextView) itemView.findViewById(R.id.totalPriceTextView);
            contextTextView = (TextView) itemView.findViewById(R.id.contextTextView);
        }
    }
}
