package unpad.aftismo;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import unpad.aftismo.utils.Common;

public class PecsActivity extends AppCompatActivity implements View.OnDragListener, View.OnLongClickListener {

    private static final String TAG = PecsActivity.class.getSimpleName();
    private ImageView pecs1, pecs2, pecs3, pecs4, pecs5, pecs6, pecs7, pecs8, pecs9, pecs10, pecs11, pecs12, pecs13, pecs14, pecs15, pecs16, pecs17, pecs18;
    private static final String TEXT_VIEW_TAG = "DRAG TEXT";
    private static final int ACTIVITY_NUM = 1;
    Context mContext = PecsActivity.this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pecs);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbarPecs);
        setSupportActionBar(toolbar);

        setUpBottomNavigationView();
        findViews();
        implementEvents();
    }

    //Find all views and set Tag to all draggable views
    private void findViews() {
        pecs1 = findViewById(R.id.pecs1);
        pecs2 = findViewById(R.id.pecs2);
        pecs3 = findViewById(R.id.pecs3);
        pecs4 = findViewById(R.id.pecs4);
        pecs5 = findViewById(R.id.pecs5);
        pecs6 = findViewById(R.id.pecs6);
        pecs7 = findViewById(R.id.pecs7);
        pecs8 = findViewById(R.id.pecs8);
        pecs9 = findViewById(R.id.pecs9);
        pecs10 = findViewById(R.id.pecs10);
        pecs11 = findViewById(R.id.pecs11);
        pecs12 = findViewById(R.id.pecs12);
        pecs13 = findViewById(R.id.pecs13);
        pecs14 = findViewById(R.id.pecs14);
        pecs15 = findViewById(R.id.pecs15);
        pecs16 = findViewById(R.id.pecs16);
        pecs17 = findViewById(R.id.pecs17);
        pecs18 = findViewById(R.id.pecs18);
        pecs1.setTag(TEXT_VIEW_TAG);
        pecs2.setTag(TEXT_VIEW_TAG);
        pecs3.setTag(TEXT_VIEW_TAG);
        pecs4.setTag(TEXT_VIEW_TAG);
        pecs5.setTag(TEXT_VIEW_TAG);
        pecs6.setTag(TEXT_VIEW_TAG);
        pecs7.setTag(TEXT_VIEW_TAG);
        pecs8.setTag(TEXT_VIEW_TAG);
        pecs9.setTag(TEXT_VIEW_TAG);
        pecs10.setTag(TEXT_VIEW_TAG);
        pecs11.setTag(TEXT_VIEW_TAG);
        pecs12.setTag(TEXT_VIEW_TAG);
        pecs13.setTag(TEXT_VIEW_TAG);
        pecs14.setTag(TEXT_VIEW_TAG);
        pecs15.setTag(TEXT_VIEW_TAG);
        pecs16.setTag(TEXT_VIEW_TAG);
        pecs17.setTag(TEXT_VIEW_TAG);
        pecs18.setTag(TEXT_VIEW_TAG);
    }

    //Implement long click and drag listener
    private void implementEvents() {
        //add or remove any view that you don't want to be dragged
        pecs1.setOnLongClickListener(this);
        pecs2.setOnLongClickListener(this);
        pecs3.setOnLongClickListener(this);
        pecs4.setOnLongClickListener(this);
        pecs5.setOnLongClickListener(this);
        pecs6.setOnLongClickListener(this);
        pecs7.setOnLongClickListener(this);
        pecs8.setOnLongClickListener(this);
        pecs9.setOnLongClickListener(this);
        pecs10.setOnLongClickListener(this);
        pecs11.setOnLongClickListener(this);
        pecs12.setOnLongClickListener(this);
        pecs13.setOnLongClickListener(this);
        pecs14.setOnLongClickListener(this);
        pecs15.setOnLongClickListener(this);
        pecs16.setOnLongClickListener(this);
        pecs17.setOnLongClickListener(this);
        pecs18.setOnLongClickListener(this);

        //add or remove any layout view that you don't want to accept dragged view
        findViewById(R.id.top_layout).setOnDragListener(this);
        findViewById(R.id.bottomLayout).setOnDragListener(this);
    }

    @Override
    public boolean onLongClick(View view) {
        // Create a new ClipData.
        // This is done in two steps to provide clarity. The convenience method
        // ClipData.newPlainText() can create a plain text ClipData in one step.

        // Create a new ClipData.Item from the ImageView object's tag
        ClipData.Item item = new ClipData.Item((CharSequence) view.getTag());

        // Create a new ClipData using the tag as a label, the plain text MIME type, and
        // the already-created item. This will create a new ClipDescription object within the
        // ClipData, and set its MIME type entry to "text/plain"
        String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

        ClipData data = new ClipData(view.getTag().toString(), mimeTypes, item);

        // Instantiates the drag shadow builder.
        View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);

        // Starts the drag
        view.startDrag(data//data to be dragged
                , shadowBuilder //drag shadow
                , view//local data about the drag and drop operation
                , 0//no needed flags
        );

        //Set view visibility to INVISIBLE as we are going to drag the view
        view.setVisibility(View.INVISIBLE);
        return true;
    }

    // This is the method that the system calls when it dispatches a drag event to the
    // listener.
    @Override
    public boolean onDrag(View view, DragEvent event) {
        // Defines a variable to store the action type for the incoming event
        int action = event.getAction();
        // Handles each of the expected events
        switch (action) {
            case DragEvent.ACTION_DRAG_STARTED:
                // Determines if this View can accept the dragged data
                if (event.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                    // if you want to apply color when drag started to your view you can uncomment below lines
                    // to give any color tint to the View to indicate that it can accept
                    // data.

                    //  view.getBackground().setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_IN);//set background color to your view

                    // Invalidate the view to force a redraw in the new tint
                    //  view.invalidate();

                    // returns true to indicate that the View can accept the dragged data.
                    return true;

                }

                // Returns false. During the current drag and drop operation, this View will
                // not receive events again until ACTION_DRAG_ENDED is sent.
                return false;

            case DragEvent.ACTION_DRAG_ENTERED:
                // Applies a YELLOW or any color tint to the View, when the dragged view entered into drag acceptable view
                // Return true; the return value is ignored.

//                view.getBackground().setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_IN);

                // Invalidate the view to force a redraw in the new tint
                view.invalidate();

                return true;
            case DragEvent.ACTION_DRAG_LOCATION:
                // Ignore the event
                return true;
            case DragEvent.ACTION_DRAG_EXITED:
                // Re-sets the color tint to blue, if you had set the BLUE color or any color in ACTION_DRAG_STARTED. Returns true; the return value is ignored.

                //  view.getBackground().setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_IN);

                //If u had not provided any color in ACTION_DRAG_STARTED then clear color filter.
//                view.getBackground().clearColorFilter();
                // Invalidate the view to force a redraw in the new tint
                view.invalidate();

                return true;
            case DragEvent.ACTION_DROP:
                // Gets the item containing the dragged data
                ClipData.Item item = event.getClipData().getItemAt(0);

                // Gets the text data from the item.
                String dragData = item.getText().toString();


                // Turns off any color tints
//                view.getBackground().clearColorFilter();

                // Invalidates the view to force a redraw
                view.invalidate();

                View v = (View) event.getLocalState();
                ViewGroup owner = (ViewGroup) v.getParent();
                owner.removeView(v);//remove the dragged view
                LinearLayout container = (LinearLayout) view;//caste the view into LinearLayout as our drag acceptable layout is LinearLayout
                container.addView(v);//Add the dragged view
                v.setVisibility(View.VISIBLE);//finally set Visibility to VISIBLE

                // Returns true. DragEvent.getResult() will return true.
                return true;
            case DragEvent.ACTION_DRAG_ENDED:
                // Turns off any color tinting
//                view.getBackground().clearColorFilter();

                // Invalidates the view to force a redraw
                view.invalidate();

                /* Does a getResult(), and displays what happened.
                if (event.getResult())
                    Toast.makeText(this, "The drop was handled.", Toast.LENGTH_SHORT).show();

                else
                    Toast.makeText(this, "The drop didn't work.", Toast.LENGTH_SHORT).show();*/


                // returns true; the value is ignored.
                return true;

            // An unknown action type was received.
            default:
                Log.e("DragDrop Example", "Unknown action type received by OnDragListener.");
                break;
        }
        return false;
    }

    private void setUpBottomNavigationView() {
        BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.navigation);
        Common.setupBottomNavigationView(bottomNavigationViewEx);
        Common.enableNavigation(mContext, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }

    //Exit when BACK buton clicked
    boolean isBackButtonClicked = false;

    @Override
    public void onBackPressed() {
        if(isBackButtonClicked) {
            super.onBackPressed();
            return;
        }
        this.isBackButtonClicked = true;
        Toast.makeText(this, "Please click BACK again to exit this application", Toast.LENGTH_SHORT).show();
    }


}
