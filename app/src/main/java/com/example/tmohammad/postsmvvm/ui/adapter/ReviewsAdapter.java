package com.example.tmohammad.postsmvvm.ui.adapter;

import android.arch.paging.PagedListAdapter;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tmohammad.postsmvvm.R;
import com.example.tmohammad.postsmvvm.databinding.MovieViewItemBinding;
import com.example.tmohammad.postsmvvm.databinding.ReviewViewItemBinding;
import com.example.tmohammad.postsmvvm.model.Movie;
import com.example.tmohammad.postsmvvm.model.Review;

public class ReviewsAdapter extends PagedListAdapter<Review, ReviewsAdapter.ReviewViewHolder> {

    /**
     * DiffUtil to compare the movie data (old and new)
     * for issuing notify commands suitably to update the list
     */
    private static DiffUtil.ItemCallback<Review> REVIEW_COMPARATOR
            = new DiffUtil.ItemCallback<Review>() {
        @Override
        public boolean areItemsTheSame(Review oldItem, Review newItem) {
            return oldItem.getId().equals(newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(Review oldItem, Review newItem) {
            return oldItem.getContent().equals(newItem.getContent());
        }
    };

    public ReviewsAdapter() {
        super(REVIEW_COMPARATOR);
    }

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Uses DataBinding to inflate the Item View
        MovieViewItemBinding itemBinding = MovieViewItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ReviewViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    /**
     * View Holder for a {@link Movie} RecyclerView list item.
     */
    public class ReviewViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final ReviewViewItemBinding mDataBinding;

        ReviewViewHolder(ReviewViewItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.mDataBinding = itemBinding;

            View itemView = itemBinding.getRoot();
            itemView.setOnClickListener(this);
        }

        void bind(Review review) {
            if (review == null) {
                //Binding the elements in the code when the movie is null
                Resources resources = mDataBinding.getRoot().getContext().getResources();
                mDataBinding.authorName.setText(resources.getString(R.string.loading));
                mDataBinding.reviewContent.setVisibility(View.GONE);
            } else {
                //When movie is not null, data binding will be automatically done in the layout
                mDataBinding.setReview(review);
                //For Immediate Binding
                mDataBinding.executePendingBindings();
            }
        }

        /**
         * Called when a view has been clicked.
         *
         * @param view The view that was clicked.
         */
        @Override
        public void onClick(View view) {
            if (getAdapterPosition() > RecyclerView.NO_POSITION) {
                Review review = getItem(getAdapterPosition());
//                if (movie != null && !TextUtils.isEmpty(movie.url)) {
//                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(movie.url));
//                    view.getContext().startActivity(intent);
//                }
            }
        }
    }
}
