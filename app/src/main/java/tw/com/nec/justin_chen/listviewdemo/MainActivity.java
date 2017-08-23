package tw.com.nec.justin_chen.listviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.list);

        mListView.setAdapter(new MyAdapter());

    }

    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;

            // 自訂的物件
            Holder holder;

            if(v == null){
                v = LayoutInflater.from(getApplicationContext()).inflate(R.layout.list_item, null);
                holder = new Holder();
                holder.image = (ImageView) v.findViewById(R.id.image);
                holder.text = (TextView) v.findViewById(R.id.text);

                v.setTag(holder);
            } else{
                holder = (Holder) v.getTag();
            }

            switch(position) {
                case 0:
                    holder.image.setImageResource(R.drawable.android1);
                    holder.text.setText("android1");
                    break;
                case 1:
                    holder.image.setImageResource(R.drawable.android2);
                    holder.text.setText("android2");
                    break;
                case 2:
                    holder.image.setImageResource(R.drawable.android3);
                    holder.text.setText("android3");
                    break;
            }

            return v;

        }

        class Holder{
            ImageView image;
            TextView text;
        }

    }

}
