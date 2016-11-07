package id.yusuf.radhika.linetoolbar;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter adapter;
    Menu menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Line");

        adapter.setFragmentList(new FirstFragment());
        adapter.setFragmentList(new SecondFragment());

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setOnTabSelectedListener(this);

        setIcon();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.people) {
            Toast.makeText(getApplicationContext(), "People", Toast.LENGTH_SHORT).show();
            return true;
        }else if(id == R.id.search){
            Toast.makeText(getApplicationContext(), "Search", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        menu.findItem(R.id.people).setVisible(false);
        return super.onCreateOptionsMenu(menu);
    }

    private void initComponent(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.ViewPager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
    }

    private void setIcon(){
        int icons[] = {R.drawable.ic_chat_white_24dp, R.drawable.ic_people_white_24dp};

        for (int x=0; x<tabLayout.getTabCount(); x++) {
            tabLayout.getTabAt(x).setIcon(icons[x]);
        }

    }



    // ===== implement ==== //

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        MenuItem people = menu.findItem(R.id.people);
        MenuItem search = menu.findItem(R.id.search);


        if(tab.getPosition()==0){
            search.setVisible(true);
            people.setVisible(false);
        }else{
            search.setVisible(false);
            people.setVisible(true);
        }

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
