package df.root;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "dfroot";

    @Override
    protected void attachBaseContext(Context newBase) {
        // device-protected storage: bootstrap.c reads prefs from /data/user_de/0/df.root/
        super.attachBaseContext(newBase.createDeviceProtectedStorageContext());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // ViewPager2 requires API 32; this device (HarmonyOS 4.2) is API 31.
        // Skip all UI and go straight to the exploit.
        startActivity(new Intent(this, RunActivity.class));
        finish();
    }
}
