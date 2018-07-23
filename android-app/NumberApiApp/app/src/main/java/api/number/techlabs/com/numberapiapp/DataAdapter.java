package api.number.techlabs.com.numberapiapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.FactsHolder> {

    private List<String> factsDataset;

    public class FactsHolder extends RecyclerView.ViewHolder {
        public TextView sNo;
        public TextView numberFact;
        public FactsHolder(View v) {
            super(v);
            sNo = (TextView) v.findViewById(R.id.sno);
            numberFact =(TextView) v.findViewById(R.id.numberFact);
        }
    }

    public DataAdapter(List<String> factDataset) {
        this.factsDataset = new ArrayList<String>();
        this.factsDataset = factDataset;
    }

    @Override
    public FactsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LinearLayout factLayout = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_template, parent, false);
        return new FactsHolder(factLayout);
    }

    @Override
    public void onBindViewHolder(FactsHolder holder, int position) {
        holder.sNo.setText(" "+(position+1)+" ");
        holder.numberFact.setText(factsDataset.get(factsDataset.size()-position-1));
    }

    @Override
    public int getItemCount() {
        return factsDataset.size();
    }


}