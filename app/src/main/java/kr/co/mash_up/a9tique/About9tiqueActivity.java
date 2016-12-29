package kr.co.mash_up.a9tique;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class About9tiqueActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about9tique);

        // 툴바 (메뉴 이름, 뒤로 가기 버튼)
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // 툴바 제목: 메뉴 이름 (About 9tique)
        TextView tvToolbarTitle = (TextView) findViewById(R.id.tv_toolbar_title);
        tvToolbarTitle.setText("About 9tique");

        // 뒤로 가기 버튼: 클릭 시 액티비티 종료
        ImageButton ibtnToolbarBack = (ImageButton) findViewById(R.id.ibtn_toolbar_back);
        ibtnToolbarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // 9tique 상세 설명 텍스트 뷰
        TextView tvAboutTitle = (TextView)findViewById(R.id.tv_about_title);
        tvAboutTitle.setText("9TIQUE");

        TextView tvAboutText = (TextView)findViewById(R.id.tv_about_text);
        tvAboutText.setText("9tique는 광장시장 내 수입 구제시장을\n" +
                "기반으로 한 의류 소개 플랫폼입니다.\n" +
                "200개의 수입 구제 매장과 함께하고 있으며,\n" +
                "보다 편리한 수입 구제 상가\n" +
                "이용 경험을 제공하고 있습니다.");

        TextView tvAboutAddress = (TextView)findViewById(R.id.tv_about_address);
        tvAboutAddress.setText("000@gmail.com\n" +
        "010.000.0000\n" + "주소지");
    }
}
