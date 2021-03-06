package fall2018.csc2017;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import fall2018.csc2017.slidingtiles.R;

/**
 * An adapter for the recycle view used in GameSelectActivity
 * https://guides.codepath.com/android/using-the-recyclerview heavily used as well as
 * https://stackoverflow.com/questions/40584424/simple-android-recyclerview-example
 */
public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.CustomViewHolder> {
    /**
     * Data to be displayed on recycler view
     */
    public List<String> dataSet;

    /**
     * An onclick listener
     */
    private OnItemClickListener clickListener;

    /**
     * An interface for the onclick listener that requires the method on item click
     */
    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }

    /**
     * Method that sets the onclick listener
     * @param listener the listener to bind it to
     */
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.clickListener = listener;
    }

    /**
     * A view holder class that stores
     */
    public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        /**
         * The text view component to use
         */
        public TextView myTextView;

        /**
         * The constructor
         * @param view the view for the view holder
         */
        public CustomViewHolder(final View view) {
            super(view);
            myTextView = view.findViewById(R.id.myText);
            myTextView.setTextColor(Color.WHITE);
            myTextView.setGravity(Gravity.CENTER);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (clickListener != null) {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION) {
                            clickListener.onItemClick(view, position);
                        }
                    }
                }
            });

        }

        @Override
        public void onClick(View view) {
//            int position = getAdapterPosition();
//            if (position != RecyclerView.NO_POSITION) {
//                Toast.makeText(context, dataSet.get(position), Toast.LENGTH_SHORT).show();
//            }
        }
    }

    /**
     * The constructor for the adapter
     * @param dataSet the data to adapt
     */
    public RecycleAdapter(List<String> dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    @NonNull
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.recycle_widget, parent, false);

        return new CustomViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder viewHolder, int position) {
        String gameName = dataSet.get(position);
        viewHolder.myTextView.setText(gameName);
        //viewHolder.myButton.setEnabled(true);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
