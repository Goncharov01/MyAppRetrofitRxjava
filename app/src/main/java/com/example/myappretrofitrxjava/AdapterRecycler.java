package com.example.myappretrofitrxjava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.RecyclerViewHolder> {

    private Context context;
    private List<TaskModel> taskModels = new ArrayList<>();

    public AdapterRecycler(Context context, List<TaskModel> taskModels) {
        this.context = context;
        this.taskModels = taskModels;
    }


    class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private TextView nameView;
        private TextView idView;
        private TextView ageView;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            nameView = itemView.findViewById(R.id.taskName);
            idView = itemView.findViewById(R.id.taskId);
            ageView = itemView.findViewById(R.id.taskAge);
        }
    }


    @NonNull
    @Override
    public AdapterRecycler.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context)
               .inflate(R.layout.task_list_item,parent,false);

        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecycler.RecyclerViewHolder holder, int position) {
        if (taskModels.size() != 0) {
            TaskModel taskModel = this.taskModels.get(position);
            holder.nameView.setText(taskModel.getName());
            holder.ageView.setText(taskModel.getAge());
            holder.idView.setText(taskModel.getId());
        }

    }

    @Override
    public int getItemCount() {
        return taskModels.size();
    }

    public void onChange (List<TaskModel> taskModels){
        this.taskModels.clear();
        this.taskModels.addAll(taskModels);
        notifyDataSetChanged();

    }


}






