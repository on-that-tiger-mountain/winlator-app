package com.winlator.contentdialog;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.winlator.R;

public class AboutDialog extends ContentDialog {
    public AboutDialog(Context context) {
        super(context, R.layout.about_dialog);
        findViewById(R.id.LLBottomBar).setVisibility(View.GONE);

        try {
            final PackageInfo pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);

            TextView tvWebpage = findViewById(R.id.TVWebpage);
            tvWebpage.setText(Html.fromHtml("<a href=\"https://www.winlator.org\">winlator.org</a>", Html.FROM_HTML_MODE_LEGACY));
            tvWebpage.setMovementMethod(LinkMovementMethod.getInstance());

            ((TextView)findViewById(R.id.TVAppVersion)).setText(context.getString(R.string.version)+" "+pInfo.versionName);

            String creditsAndThirdPartyAppsHTML = String.join("<br />",
                "Winlator 11.0 Unofficial Revision by (<a href=\"https://github.com/on-that-tiger-mountain/Winlator-11.0-Unofficial-Revision-by-tiger\">tiger</a>)",
                "Winlator 11.0 Original Version by (<a href=\"https://github.com/brunodev85/winlator\">brunodev85</a>)",
                "GLIBC Patches by (<a href=\"https://github.com/termux-pacman/glibc-packages\">Termux Pacman</a>)",
                "Wine (<a href=\"https://www.winehq.org\">winehq.org</a>)",
                "Box86/Box64 by <a href=\"https://github.com/ptitSeb\">ptitseb</a>",
                "Mesa (Turnip/Zink/VirGL) (<a href=\"https://www.mesa3d.org\">mesa3d.org</a>)",
                "MTDataFilesProvider by (<a href=\"https://github.com/ewt45/winlator-fork/commit/b86061357897af69d29cd0c5b54ea0d88d067e2b\">ewt45/bubu23456</a>)",
                "zink-22.2.5-fix by (<a href=\"https://github.com/on-that-tiger-mountain/mesa3d-custom/tree/zink-22.2.5-fix\">tiger</a>)",
                "DXVK (<a href=\"https://github.com/doitsujin/dxvk\">github.com/doitsujin/dxvk</a>)",
                "DXVK-Sarek by (<a href=\"https://github.com/pythonlover02/DXVK-Sarek\">pythonlover02</a>)",
                "DXVK-Sarek-Mali-Gpu-fix by (<a href=\"https://github.com/zeyadadev/DXVK-Sarek\">zeyadadev</a>)",
                "DXVK-Sarek-pal4 by (<a href=\"https://github.com/on-that-tiger-mountain/dxvk/tree/DXVK-Sarek-pal4\">tiger</a>)",
                "VKD3D (<a href=\"https://gitlab.winehq.org/wine/vkd3d\">gitlab.winehq.org/wine/vkd3d</a>)",
                "CNC DDraw (<a href=\"https://github.com/FunkyFr3sh/cnc-ddraw\">github.com/FunkyFr3sh/cnc-ddraw</a>)",
                "(<a href=\"https://github.com/alexvorxx\">alexvorxx</a>) (Mods/Tips) and others."
            );

            TextView tvCreditsAndThirdPartyApps = findViewById(R.id.TVCreditsAndThirdPartyApps);
            tvCreditsAndThirdPartyApps.setText(Html.fromHtml(creditsAndThirdPartyAppsHTML, Html.FROM_HTML_MODE_LEGACY));
            tvCreditsAndThirdPartyApps.setMovementMethod(LinkMovementMethod.getInstance());
        }
        catch (PackageManager.NameNotFoundException e) {}
    }
}
