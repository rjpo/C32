package motor.simulador.luisf.c175_2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothSocket;
import android.os.Handler;
import java.util.UUID;
import android.widget.SeekBar;
import android.widget.Switch;

import com.xw.repo.BubbleSeekBar;
import com.xw.repo.BubbleSeekBar.OnProgressChangedListenerAdapter;


public class Pressure extends Fragment {

   Pressure_listener listener;


    private View rootView = null;


    int pro;
    BubbleSeekBar seekBar,seekBar1, seekBar2, seekBar3, seekBar4, seekBar5, seekBar6, seekBar7;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }

    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_pressure, container, false);
        View rootView = inflater.inflate(R.layout.fragment_pressure, container, false);
        seekBar=(BubbleSeekBar) rootView.findViewById(R.id.hcprrail);
        seekBar1=(BubbleSeekBar) rootView.findViewById(R.id.unfil);
        seekBar2=(BubbleSeekBar) rootView.findViewById(R.id.engine_i);
        seekBar3=(BubbleSeekBar) rootView.findViewById(R.id.filtre_in);
        seekBar4=(BubbleSeekBar) rootView.findViewById(R.id.transfer);
        seekBar5=(BubbleSeekBar) rootView.findViewById(R.id.fuel_presu);
        seekBar6=(BubbleSeekBar) rootView.findViewById(R.id.coolant);
        seekBar7=(BubbleSeekBar) rootView.findViewById(R.id.crankcase);

        seekBar7.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                pro=progress;

            }

            @Override
            public void getProgressOnActionUp(int progress, float progressFloat) {
                try {
                    // CALIBRADO CRANKCASE
                    byte w[] = {1, 26, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((pro >> 24) & 0xFF);
                    w[4] = (byte) ((pro >> 16) & 0xFF);
                    w[5] = (byte) ((pro >> 8) & 0xFF);
                    w[6] = (byte) (pro & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onPresure_SeekChange(w[i]);
                    }
                }catch (Exception e){}
            }

            @Override
            public void getProgressOnFinally(int progress, float progressFloat) {

            }
        });




        /*seekBar7.setOnSeekBarChangeListener(new  SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                pro = i;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                try {
                    // CALIBRADO CRANKCASE
                    byte w[] = {1, 26, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((pro >> 24) & 0xFF);
                    w[4] = (byte) ((pro >> 16) & 0xFF);
                    w[5] = (byte) ((pro >> 8) & 0xFF);
                    w[6] = (byte) (pro & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onPresure_SeekChange(w[i]);
                    }
                }catch (Exception e){}
            }

        });*/

        seekBar6.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                pro=progress;
            }

            @Override
            public void getProgressOnActionUp(int progress, float progressFloat) {
                try {
                    byte w[] = {1, 31, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((pro >> 24) & 0xFF);
                    w[4] = (byte) ((pro >> 16) & 0xFF);
                    w[5] = (byte) ((pro >> 8) & 0xFF);
                    w[6] = (byte) (pro & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onPresure_SeekChange(w[i]);
                    }
                }catch (Exception e){}
            }

            @Override
            public void getProgressOnFinally(int progress, float progressFloat) {

            }
        });

        /*seekBar6.setOnSeekBarChangeListener(new  SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                pro = i;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                try {
                    byte w[] = {1, 31, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((pro >> 24) & 0xFF);
                    w[4] = (byte) ((pro >> 16) & 0xFF);
                    w[5] = (byte) ((pro >> 8) & 0xFF);
                    w[6] = (byte) (pro & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onPresure_SeekChange(w[i]);
                    }
                }catch (Exception e){}
            }

        });*/

        seekBar5.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                pro=progress;
            }

            @Override
            public void getProgressOnActionUp(int progress, float progressFloat) {
                try {
                    byte w[] = {1, 18, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((pro >> 24) & 0xFF);
                    w[4] = (byte) ((pro >> 16) & 0xFF);
                    w[5] = (byte) ((pro >> 8) & 0xFF);
                    w[6] = (byte) (pro & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onPresure_SeekChange(w[i]);
                    }
                }catch (Exception e){}
            }

            @Override
            public void getProgressOnFinally(int progress, float progressFloat) {

            }
        });

        /*seekBar5.setOnSeekBarChangeListener(new  SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                pro = i;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                try {
                    byte w[] = {1, 18, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((pro >> 24) & 0xFF);
                    w[4] = (byte) ((pro >> 16) & 0xFF);
                    w[5] = (byte) ((pro >> 8) & 0xFF);
                    w[6] = (byte) (pro & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onPresure_SeekChange(w[i]);
                    }
                }catch (Exception e){}
            }

        });*/

        seekBar4.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                pro=progress;
            }

            @Override
            public void getProgressOnActionUp(int progress, float progressFloat) {
                try {
                    //calibrado TRANSFER
                    byte w[] = {1, 22, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((pro >> 24) & 0xFF);
                    w[4] = (byte) ((pro >> 16) & 0xFF);
                    w[5] = (byte) ((pro >> 8) & 0xFF);
                    w[6] = (byte) (pro & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onPresure_SeekChange(w[i]);
                    }
                }catch (Exception e){}
            }

            @Override
            public void getProgressOnFinally(int progress, float progressFloat) {

            }
        });
        /*
        seekBar4.setOnSeekBarChangeListener(new  SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                pro = i;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                try {
                    //calibrado TRANSFER
                    byte w[] = {1, 22, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((pro >> 24) & 0xFF);
                    w[4] = (byte) ((pro >> 16) & 0xFF);
                    w[5] = (byte) ((pro >> 8) & 0xFF);
                    w[6] = (byte) (pro & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onPresure_SeekChange(w[i]);
                    }
                }catch (Exception e){}
            }

        });*/

        seekBar3.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                pro=progress;
            }

            @Override
            public void getProgressOnActionUp(int progress, float progressFloat) {
                try {
                    byte w[] = {1, 27, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((pro >> 24) & 0xFF);
                    w[4] = (byte) ((pro >> 16) & 0xFF);
                    w[5] = (byte) ((pro >> 8) & 0xFF);
                    w[6] = (byte) (pro & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onPresure_SeekChange(w[i]);
                    }
                }catch (Exception e){}
            }

            @Override
            public void getProgressOnFinally(int progress, float progressFloat) {

            }
        });

        /*seekBar3.setOnSeekBarChangeListener(new  SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                pro = i;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                try {
                    byte w[] = {1, 27, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((pro >> 24) & 0xFF);
                    w[4] = (byte) ((pro >> 16) & 0xFF);
                    w[5] = (byte) ((pro >> 8) & 0xFF);
                    w[6] = (byte) (pro & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onPresure_SeekChange(w[i]);
                    }
                }catch (Exception e){}
            }

        });*/

        seekBar2.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                pro=progress;
            }

            @Override
            public void getProgressOnActionUp(int progress, float progressFloat) {
                try {
                    // CALIBRADO ENGINE OULET FILTRE
                    byte w[] = {1, 20, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((pro >> 24) & 0xFF);
                    w[4] = (byte) ((pro >> 16) & 0xFF);
                    w[5] = (byte) ((pro >> 8) & 0xFF);
                    w[6] = (byte) (pro & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onPresure_SeekChange(w[i]);
                    }
                }catch (Exception e){}
            }

            @Override
            public void getProgressOnFinally(int progress, float progressFloat) {

            }
        });

        /*seekBar2.setOnSeekBarChangeListener(new  SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                pro = i;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                try {
                    // CALIBRADO ENGINE OULET FILTRE
                    byte w[] = {1, 20, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((pro >> 24) & 0xFF);
                    w[4] = (byte) ((pro >> 16) & 0xFF);
                    w[5] = (byte) ((pro >> 8) & 0xFF);
                    w[6] = (byte) (pro & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onPresure_SeekChange(w[i]);
                    }
                }catch (Exception e){}
            }

        });*/

        seekBar1.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                pro=progress;
            }

            @Override
            public void getProgressOnActionUp(int progress, float progressFloat) {
                try {
                    byte w[] = {1, 30, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((pro >> 24) & 0xFF);
                    w[4] = (byte) ((pro >> 16) & 0xFF);
                    w[5] = (byte) ((pro >> 8) & 0xFF);
                    w[6] = (byte) (pro & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onPresure_SeekChange(w[i]);
                    }
                }catch (Exception e){}
            }

            @Override
            public void getProgressOnFinally(int progress, float progressFloat) {

            }
        });

        /*seekBar1.setOnSeekBarChangeListener(new  SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                pro = i;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                try {
                    byte w[] = {1, 30, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((pro >> 24) & 0xFF);
                    w[4] = (byte) ((pro >> 16) & 0xFF);
                    w[5] = (byte) ((pro >> 8) & 0xFF);
                    w[6] = (byte) (pro & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onPresure_SeekChange(w[i]);
                    }
                }catch (Exception e){}
            }

        });*/

        seekBar.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                pro=progress;
            }

            @Override
            public void getProgressOnActionUp(int progress, float progressFloat) {
                try {
                    //calibrado HCRP
                    byte w[] = {1, 28, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((pro >> 24) & 0xFF);
                    w[4] = (byte) ((pro >> 16) & 0xFF);
                    w[5] = (byte) ((pro >> 8) & 0xFF);
                    w[6] = (byte) (pro & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onPresure_SeekChange(w[i]);
                    }
                }catch (Exception e){}
            }

            @Override
            public void getProgressOnFinally(int progress, float progressFloat) {

            }
        });

        /*seekBar.setOnSeekBarChangeListener(new  SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                pro = i;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                try {
                    //calibrado HCRP
                    byte w[] = {1, 28, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((pro >> 24) & 0xFF);
                    w[4] = (byte) ((pro >> 16) & 0xFF);
                    w[5] = (byte) ((pro >> 8) & 0xFF);
                    w[6] = (byte) (pro & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onPresure_SeekChange(w[i]);
                    }
                }catch (Exception e){}
            }

    });*/

        return rootView;


    }
    public int aMethodMainActivityCanCAll(String withSomeParameter){
        int aResultToMainActivity = 0;
        //MainActivity can call methods on the fragment to communicate things like
        //requesting some status, or pass throguh requests from other fragment.
        return aResultToMainActivity;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listener = (Pressure_listener) getActivity();
    }

    public  interface Pressure_listener{
        void onPresure_SeekChange(byte b);
   }

}
