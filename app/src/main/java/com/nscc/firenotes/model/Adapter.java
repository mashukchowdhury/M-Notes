package com.nscc.firenotes.model;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.nscc.firenotes.NoteDetails;
import com.nscc.firenotes.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    List<String>titles;
    List<String> content;

    public Adapter(List<String> title,List<String> content)
    {
        this.titles = title;
        this.content = content;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_view_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        holder.noteTitle.setText(titles.get(position));
        holder.noteContent.setText(content.get(position));
        holder.mCardView.setCardBackgroundColor(holder.view.getResources().getColor(getRandomColor(), null));


        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), NoteDetails.class);
                v.getContext().startActivity(i);
            }
        });

    }

    private int getRandomColor() {
        List<Integer>colorCode = new ArrayList<>();
        colorCode.add(R.color.skyblue);
        colorCode.add(R.color.pink);
        colorCode.add(R.color.lightPurple);
        colorCode.add(R.color.yellow);
        colorCode.add(R.color.lightGreen);

        Random randomColor = new Random();
        int number = randomColor.nextInt(colorCode.size());

        return colorCode.get(number);
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView noteTitle, noteContent;
        View view;
        CardView mCardView;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            noteTitle = itemView.findViewById(R.id.titles);
            noteContent = itemView.findViewById((R.id.content));
            mCardView = itemView.findViewById(R.id.noteCard);
            view = itemView;
        }
    }
}
