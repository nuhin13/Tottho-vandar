package com.nuhin13.knowledge.Bank;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by nuhin13 on 10/8/2016.
 */
public class ListForBD_5 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);
        ContentAdapter adapter = new ContentAdapter(recyclerView.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return recyclerView;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // public ImageView avator;
        public TextView question;
        public TextView answer;

        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_list, parent, false));
            // avator = (ImageView) itemView.findViewById(R.id.list_avatar);
            question = (TextView) itemView.findViewById(R.id.question_details);
            answer = (TextView) itemView.findViewById(R.id.answer_details);
            answer.setVisibility(View.GONE);

        }
    }

    /**
     * Adapter to display recycler view.
     */
    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
        // Set numbers of List in RecyclerView.
        private static final int LENGTH = 36;

        private final String[] mquestion;
        private final String[] manswer;
        //   private final Drawable[] mPlaceAvators;

        public ContentAdapter(Context context) {
            Resources resources = context.getResources();
            mquestion = resources.getStringArray(R.array.bd_pakistan_amol);
            manswer = resources.getStringArray(R.array.science_mohasunno_ans);

        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            // holder.avator.setImageDrawable(mPlaceAvators[position % mPlaceAvators.length]);
            holder.question.setText(mquestion[position % mquestion.length]);
            holder.answer.setText(manswer[position % manswer.length]);
        }

        @Override
        public int getItemCount() {
            return LENGTH;
        }
    }
}
