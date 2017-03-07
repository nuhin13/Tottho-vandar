/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.nuhin13.knowledge.Bank;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Provides UI for the view with Tile.
 */
public class TileContentFragment extends Fragment {


    public int card_position;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);
        ContentAdapter adapter = new ContentAdapter(recyclerView.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        // Set padding for Tiles
        int tilePadding = getResources().getDimensionPixelSize(R.dimen.tile_padding);
        int tile = getResources().getDimensionPixelOffset(R.dimen.md_keylines);
        recyclerView.setPadding(tilePadding, tilePadding, tilePadding, tilePadding);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        return recyclerView;



    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView picture;
        public TextView name;
        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_tile, parent, false));
            picture = (ImageView) itemView.findViewById(R.id.tile_picture);
            name = (TextView) itemView.findViewById(R.id.tile_title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    //Toast.makeText(v.getContext(),Integer.toString(position),Toast.LENGTH_SHORT).show();

/*
                    Context context = v.getContext();
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra(DetailActivity.EXTRA_POSITION, getAdapterPosition());
                    context.startActivity(intent);*/

                    if(position==0){

                        Context context1 = v.getContext();
                        Intent intent1 = new Intent(context1, DetailActivity.class);
                        intent1.putExtra(DetailActivity.EXTRA_POSITION, getAdapterPosition());
                        context1.startActivity(intent1);

                    }
                    if(position==1){

                        Context context2 = v.getContext();
                        Intent intent2 = new Intent(context2, DetailsForInternational.class);
                        intent2.putExtra(DetailsForInternational.EXTRA_POSITION, getAdapterPosition());
                        context2.startActivity(intent2);

                    }
                    if(position==2){

                        Context context3 = v.getContext();
                        Intent intent3 = new Intent(context3, DetailsForScienceTec.class);
                        intent3.putExtra(DetailsForScienceTec.EXTRA_POSITION, getAdapterPosition());
                        context3.startActivity(intent3);

                    }
                    if(position==3){

                        Context context4 = v.getContext();
                        Intent intent4 = new Intent(context4, DetailsForSports.class);
                        intent4.putExtra(DetailsForUptodate.EXTRA_POSITION, getAdapterPosition());
                        context4.startActivity(intent4);

                    }
                    if(position==4){

                        Context context5 = v.getContext();
                        Intent intent5 = new Intent(context5, DetailsForHistory.class);
                        intent5.putExtra(DetailsForSports.EXTRA_POSITION, getAdapterPosition());
                        context5.startActivity(intent5);

                    }
                    if(position==5){

                        Context context6 = v.getContext();
                        Intent intent6 = new Intent(context6, DetailsForFunnyItem.class);
                        intent6.putExtra(DetailsForHistory.EXTRA_POSITION, getAdapterPosition());
                        context6.startActivity(intent6);

                    }
                    if(position==6){

                        Context context7 = v.getContext();
                        Intent intent7 = new Intent(context7, DetailsForBanglaIQ.class);
                        intent7.putExtra(DetailsForFunnyItem.EXTRA_POSITION, getAdapterPosition());
                        context7.startActivity(intent7);

                    }
                   /* if(position==7){

                        Context context8 = v.getContext();
                        Intent intent8 = new Intent(context8, DetailsForBanglaIQ.class);
                        intent8.putExtra(DetailsForBCS.EXTRA_POSITION, getAdapterPosition());
                        context8.startActivity(intent8);

                    }
                    if(position==8){

                        Context context9 = v.getContext();
                        Intent intent9 = new Intent(context9, DetailsForBanglaIQ.class);
                        intent9.putExtra(DetailsForBanglaIQ.EXTRA_POSITION, getAdapterPosition());
                        context9.startActivity(intent9);

                    }*/

                }
            });

            ImageButton favoriteImageButton =
                    (ImageButton) itemView.findViewById(R.id.share_button);
            favoriteImageButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Snackbar.make(v, "Added to Favorite",
                            Snackbar.LENGTH_LONG).show();
                }
            });
        }

       /* public void positionAction(View view) {
            int position = (int) view.getTag();
            Toast.makeText(view.getContext(),Integer.toString(position),Toast.LENGTH_SHORT).show();
        }*/




    }

    /**
     * Adapter to display recycler view.
     */
    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
        // Set numbers of Tiles in RecyclerView.
        private static final int LENGTH = 7;

        private final String[] mPlaces;
        private final Drawable[] mPlacePictures;
        public ContentAdapter(Context context) {
            Resources resources = context.getResources();
            mPlaces = resources.getStringArray(R.array.titile);
            TypedArray a = resources.obtainTypedArray(R.array.places_picture);
            mPlacePictures = new Drawable[a.length()];
            for (int i = 0; i < mPlacePictures.length; i++) {
                mPlacePictures[i] = a.getDrawable(i);
            }
            //a.recycle();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.picture.setImageDrawable(mPlacePictures[position % mPlacePictures.length]);
            holder.name.setText(mPlaces[position % mPlaces.length]);


        }

        @Override
        public int getItemCount() {
            return LENGTH;
        }
    }


}