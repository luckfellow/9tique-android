package kr.co.mash_up.a9tique;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

import butterknife.BindView;
import butterknife.OnClick;
import kr.co.mash_up.a9tique.base.ui.BaseFragment;


public class AddEditProductFragment extends BaseFragment {

    public static final String TAG = AddEditProductFragment.class.getSimpleName();
    public static final String PARAM_PRODUCT_ID = "productId";
    public static final int REQUEST_CODE_CATEGORY_SELECTION = 1000;

    private Integer mParamProductId;

    @BindView(R.id.tv_image_count)
    TextView mTvImageCount;

    @BindView(R.id.rv_image)
    RecyclerView mRvImage;

    @BindView(R.id.et_brand_description)
    EditText mEtBrandDescription;

    @BindView(R.id.et_name_description)
    EditText mEtNameDescription;

    @BindView(R.id.et_size_description)
    EditText mEtSizeDescription;

    @BindView(R.id.et_price_description)
    EditText mEtPriceDescription;

    @BindView(R.id.tv_category_description)
    TextView mTvCategoryDescription;

    @BindView(R.id.et_detail_description)
    EditText mEtDetailDescription;

    ProductImageListAdapter mProductImageListAdapter;

    public AddEditProductFragment() {
        // Required empty public constructor
    }

    public static AddEditProductFragment newInstance() {
        AddEditProductFragment fragment = new AddEditProductFragment();
//        Bundle args = new Bundle();
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParamProductId = getArguments().getInt(PARAM_PRODUCT_ID);
        }
        setRetainInstance(true);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_add_edit_product;
    }

    @Override
    public void initView(View rootView) {
        mRvImage.setHasFixedSize(true);
        mRvImage.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        mProductImageListAdapter = new ProductImageListAdapter(getActivity());
        mRvImage.setAdapter(mProductImageListAdapter);

        // Test
        ProductImage productImage;
        for (int i = 0; i < 2; i++) {
            productImage = new ProductImage();
            productImage.setImageType(ProductImageListAdapter.VIEW_TYPE_NORMAL);
            mProductImageListAdapter.addItem(0, productImage);
        }

        //Todo: 이미지 갯수 표시
        mTvImageCount.setText(String.format(Locale.KOREA, "%d/4", mProductImageListAdapter.getItemCount() - 1));
    }

    @OnClick(R.id.iv_category_select)
    public void categorySelect() {
        startActivityForResult(new Intent(getActivity(), CategorySelectionActivity.class), REQUEST_CODE_CATEGORY_SELECTION);
        // Todo: 전환 애니메이션 구현
//        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }

    @OnClick(R.id.btn_complete)
    public void productRegister() {

        //Todo: 모델객체에 저장
        mEtBrandDescription.getText().toString();
        mEtNameDescription.getText().toString();
        mEtSizeDescription.getText().toString();
        mEtPriceDescription.getText().toString();
        mTvCategoryDescription.getText().toString();
        mEtDetailDescription.getText().toString();


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CODE_CATEGORY_SELECTION:
                    String mainCategory = data.getStringExtra("mainCategory");
                    String subCategory = data.getStringExtra("subCategory");
                    if (subCategory != null) {
                        mTvCategoryDescription.setText(mainCategory + " > " + subCategory);
                    } else {
                        mTvCategoryDescription.setText(mainCategory);
                    }
                    break;
            }
        }
    }
}