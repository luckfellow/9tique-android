package kr.co.mash_up.a9tique.ui.sellproducts;

import java.util.List;

import kr.co.mash_up.a9tique.base.BasePresenter;
import kr.co.mash_up.a9tique.base.BaseView;
import kr.co.mash_up.a9tique.data.Product;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface SellProductsContract {

    /**
     * View -> Presenter
     */
    interface Presenter extends BasePresenter {

        void result(int requestCode, int resultCode);

        void loadProducts(boolean forceUpdate);

        void loadMoreProducts(int loadingFooterPosition);

        void editProduct();

        void detailProductSeller(Product product);

        void detailProductCustomer(Product product);

        void removeProduct(Product product);

        void removeProductAll(List<Product> products);

        void updateProductStatus(Product product, int position);
    }

    /**
     * Presenter -> View
     */
    interface View extends BaseView<Presenter> {

        void setLodingIndicator(boolean active);

        void setProgressbar(boolean active);

        void setFooterView(boolean active, int position);

        void showProducts(List<Product> products);

        void showLoadingProductsError();

        void refreshProducts();

        void showNoProducts();  // recyclerview empty support로 필요없는 메소드가되버림

        void showProductDetailForSeller(Product product);

        void showProductDetailForCustomer(Product product);

        void updateProductStatus(int position);

        void showEditProduct();

        void showSuccessfullyRemovedMessage();

        void showFailureRemovedMessage();

        void showSuccessfullyRemovedAllMessage();

        void showFailureRemovedAllMessage();

        void showSuccessfullyUpdatedStatusMessage();

        void showFailureUpdatedStatusMessage();

        boolean isActive();
    }
}
