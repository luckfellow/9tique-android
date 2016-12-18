package kr.co.mash_up.a9tique.ui.products;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import kr.co.mash_up.a9tique.R;
import kr.co.mash_up.a9tique.base.ui.BaseFragment;
import kr.co.mash_up.a9tique.data.Product;
import kr.co.mash_up.a9tique.ui.OnItemClickListener;

//Todo: 리스트 무한 스크롤
public class SubCategoryFragment extends BaseFragment {

    @BindView(R.id.rv_products)
    RecyclerView mRvProducts;

    private ProductListAdapter mProductListAdapter;

    private static final String ARG_PARAM_TITLE = "title";

    private String mParamTitle;

    public SubCategoryFragment() {
        // Required empty public constructor
    }

    public static SubCategoryFragment newInstance(String paramTitle) {
        SubCategoryFragment fragment = new SubCategoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM_TITLE, paramTitle);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParamTitle = getArguments().getString(ARG_PARAM_TITLE);
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_sub_category;
    }

    @Override
    public void initView(View rootView) {
        mRvProducts.setHasFixedSize(true);
        mRvProducts.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        mProductListAdapter = new ProductListAdapter(getActivity());
        mProductListAdapter.setOnItemClickListener(product -> {
            //Todo: show detail product activity
            //Todo: remove snackbar
            Snackbar.make(getView(), "show detail product activity", Snackbar.LENGTH_SHORT)
                    .show();
        });
        mRvProducts.setAdapter(mProductListAdapter);
    }
}