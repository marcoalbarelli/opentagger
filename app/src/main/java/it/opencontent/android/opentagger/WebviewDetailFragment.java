package it.opencontent.android.opentagger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import it.opencontent.android.opentagger.dummy.DummyContent;

/**
 * A fragment representing a single Webview detail screen.
 * This fragment is either contained in a {@link WebviewListActivity}
 * in two-pane mode (on tablets) or a {@link WebviewDetailActivity}
 * on handsets.
 */
public class WebviewDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private DummyContent.DummyItem mItem;

    private View rootView;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public WebviewDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_webview_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null && rootView != null) {
            ((TextView) rootView.findViewById(R.id.webview_detail)).setText(mItem.content);

            WebView myWebView = (WebView) rootView.findViewById(R.id.webview_webview);
            myWebView.setWebViewClient(new WebViewClient());
            myWebView.loadUrl(mItem.uri);

        }

        return rootView;
    }

    public void goBack(){
        if(rootView != null){
            WebView myWebView = (WebView) rootView.findViewById(R.id.webview_webview);
            if(myWebView != null && myWebView.canGoBack()){
                myWebView.goBack();
            }
        }
    }

}
