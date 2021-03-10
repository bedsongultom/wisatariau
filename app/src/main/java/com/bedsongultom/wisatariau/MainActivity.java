package com.bedsongultom.wisatariau;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.bedsongultom.wisatariau.ui.about.AboutFragment;
import com.bedsongultom.wisatariau.ui.browser.BrowserFragment;
import com.bedsongultom.wisatariau.ui.gallery.GalleryFragment;
import com.bedsongultom.wisatariau.ui.home.HomeFragment;
import com.bedsongultom.wisatariau.ui.map.MapFragment;
import com.bedsongultom.wisatariau.ui.video.VideoFragment;
import com.bedsongultom.wisatariau.ui.web.WebFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    /*FragmentManager fm;
    FragmentTransaction ft;*/
    private AppBarConfiguration mAppBarConfiguration;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        window.setStatusBarColor(Color.TRANSPARENT);
*/

        /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.



        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_web, R.id.nav_map, R.id.nav_gallery, R.id.nav_video, R.id.nav_browser, R.id.nav_newsupdate, R.id.nav_newsdetail, R.id.nav_about, R.id.nav_exit)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);




/*

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.replace(R.id.nav_host_fragment, new HomeFragment()).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);*/

    }

   /* @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }*/

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}

   /* @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.nav_home:
                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();
                ft.replace(R.id.nav_host_fragment, new HomeFragment());
                ft.addToBackStack(null);
                ft.commit();
                break;

            case R.id.nav_web:
                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();
                ft.replace(R.id.nav_host_fragment, new WebFragment());
                ft.addToBackStack(null);
                ft.commit();
                break;

            case R.id.nav_map:
                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();

                ft.replace(R.id.nav_host_fragment, new MapFragment());
                ft.addToBackStack(null);
                ft.commit();
                break;
            case R.id.nav_gallery:
                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();

                ft.replace(R.id.nav_host_fragment, new GalleryFragment());
                ft.addToBackStack(null);
                ft.commit();

                break;

            case R.id.nav_video:
                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();

                ft.replace(R.id.nav_host_fragment, new VideoFragment());
                ft.addToBackStack(null);
                ft.commit();
                break;

            case R.id.nav_browser:
                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();

                ft.replace(R.id.nav_host_fragment, new BrowserFragment());
                ft.addToBackStack(null);
                ft.commit();
                break;

            case R.id.nav_about:

                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();

                ft.replace(R.id.nav_host_fragment, new AboutFragment());
                ft.addToBackStack(null);
                ft.commit();
                break;

            case R.id.nav_exit:
                finish();
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }*/

