package kr.co.mash_up.a9tique.ui.addeditproduct;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.File;

import butterknife.BindView;
import kr.co.mash_up.a9tique.R;
import kr.co.mash_up.a9tique.base.ui.BaseViewHolder;
import kr.co.mash_up.a9tique.data.ProductImage;


public class ProductImageNormalViewHolder extends BaseViewHolder<ProductImage> {

    @BindView(R.id.iv_product_image)
    ImageView ivProductImage;

    public static ProductImageNormalViewHolder newInstance(@NonNull ViewGroup parent) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_normal_product_image_list, parent, false);
        return new ProductImageNormalViewHolder(itemView);
    }

    public ProductImageNormalViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bind(ProductImage productImage) {
        Glide.with(itemView.getContext())
                .load(new File(productImage.getImagePath()))
                .fitCenter()
                .centerCrop()
                .into(ivProductImage);
    }
}