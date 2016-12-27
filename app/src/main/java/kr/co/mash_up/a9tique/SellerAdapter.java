package kr.co.mash_up.a9tique;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

/**
 * Created by CY on 2016. 11. 15..
 */


public class SellerAdapter extends RecyclerView.Adapter<SellerAdapter.MyViewHolder> {

    private List<Setting> settingList;

    // seller adapter
    public SellerAdapter(List<Setting> settingList) {
        this.settingList = settingList;
    }

    // view holder
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView menu;
        public EditText editTxt;

        public MyViewHolder(View view) {
            super(view);
            menu = (TextView) view.findViewById(R.id.menu);
            editTxt = (EditText) view.findViewById(R.id.edit_txt);
        }
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.seller_list_row, parent, false);

        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Setting setting = settingList.get(position);
        holder.menu.setText(setting.getMenu());
        // 메뉴에 따른 힌트 설정
        switch (position) {
            case 0:
                holder.editTxt.setHint("판매자 성함을 입력해 주세요.");
                break;
            case 1:
                holder.editTxt.setHint("등록하시는 매장명을 입력해 주세요.");
                break;
            case 2:
                holder.editTxt.setHint("매장에 대한 정보를 입력해 주세요.");
                break;
            case 3:
                holder.editTxt.setHint("상품 문의가 가능한 연락처를 남겨 주세요.");
                break;
        }
    }

    @Override
    public int getItemCount() {
        return settingList.size();
    }
}
