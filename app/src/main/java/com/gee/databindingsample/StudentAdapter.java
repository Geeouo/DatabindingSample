package com.gee.databindingsample;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.gee.databindingsample.databinding.ItemImageviewBinding;
import com.gee.databindingsample.databinding.ItemTextBinding;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Create by Gee on 2020/7/19.
 * _____
 * / ____|
 * | |  __  ___  ___
 * | | |_ |/ _ \/ _ \
 * | |__| |  __/  __/
 * \_____|\___|\___|
 */
public class StudentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Student> students = new ArrayList<>();
    public static final int TEXT = 1;
    public static final int IMAGE = 2;

    public StudentAdapter(List<Student> students) {
        this.students = students;
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0)
            return IMAGE;
        else return TEXT;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TEXT) {
            ItemTextBinding itemTextBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_text, parent, false);
            return new TextViewHolder(itemTextBinding);
        } else {
            ItemImageviewBinding itemImageviewBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_imageview, parent, false);
            return new ImageViewViewHolder(itemImageviewBinding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TextViewHolder) {
            ((TextViewHolder) holder).getViewDataBinding().setStudent(students.get(position));
        } else if (holder instanceof ImageViewViewHolder) {
            ((ImageViewViewHolder) holder).getViewDataBinding().setStudent(students.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class TextViewHolder extends RecyclerView.ViewHolder {
        ItemTextBinding pViewDataBinding = null;

        public ItemTextBinding getViewDataBinding() {
            return pViewDataBinding;
        }

        public TextViewHolder(ItemTextBinding viewDataBinding) {
            super(viewDataBinding.getRoot());
            this.pViewDataBinding = viewDataBinding;
        }

        public void bindData(Student student) {
            getViewDataBinding().setStudent(student);
        }
    }

    public class ImageViewViewHolder extends RecyclerView.ViewHolder {
        ItemImageviewBinding pViewDataBinding = null;

        public ItemImageviewBinding getViewDataBinding() {
            return pViewDataBinding;
        }

        public ImageViewViewHolder(ItemImageviewBinding viewDataBinding) {
            super(viewDataBinding.getRoot());
            this.pViewDataBinding = viewDataBinding;
        }

        public void bindData(Student student) {
            getViewDataBinding().setStudent(student);
        }
    }


    @BindingAdapter({"loadPic"})
    public static void loadPic(ImageView imageView, int resourceId) {
        imageView.setImageResource(resourceId);
    }
}
