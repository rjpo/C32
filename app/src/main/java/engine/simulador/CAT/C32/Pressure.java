package engine.simulador.CAT.C32;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xw.repo.BubbleSeekBar;

import static engine.simulador.CAT.C32.ClearStorage.SEEKBARCOOLANT;
import static engine.simulador.CAT.C32.ClearStorage.SEEKBARCRANKCASE;
import static engine.simulador.CAT.C32.ClearStorage.SEEKBAREOP;
import static engine.simulador.CAT.C32.ClearStorage.SEEKBARFILTRE_IN;
import static engine.simulador.CAT.C32.ClearStorage.SEEKBARFUEL_PRESU;
import static engine.simulador.CAT.C32.ClearStorage.SEEKBARHCPRAIL;
import static engine.simulador.CAT.C32.ClearStorage.SEEKBARTRANSFER;
import static engine.simulador.CAT.C32.ClearStorage.SEEKBARUNFIL;


public class Pressure extends Fragment {

   Pressure_listener listener;


    private View rootView = null;


    int pro;
    BubbleSeekBar seekBarhcprail,seekBarunfil, seekBareop, seekBarfiltre_in, seekBartransfer, seekBarfuel_presu, seekBarcoolant, seekBarcrankcase;

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
        seekBarhcprail=(BubbleSeekBar) rootView.findViewById(R.id.hcprrail);
        seekBarunfil=(BubbleSeekBar) rootView.findViewById(R.id.unfil);
        seekBareop=(BubbleSeekBar) rootView.findViewById(R.id.engine_i);
        seekBarfiltre_in=(BubbleSeekBar) rootView.findViewById(R.id.filtre_in);
        seekBartransfer=(BubbleSeekBar) rootView.findViewById(R.id.transfer);
        seekBarfuel_presu=(BubbleSeekBar) rootView.findViewById(R.id.fuel_presu);
        seekBarcoolant=(BubbleSeekBar) rootView.findViewById(R.id.coolant);
        seekBarcrankcase=(BubbleSeekBar) rootView.findViewById(R.id.crankcase);

        if (!((MainNavActivity)getActivity()).get(SEEKBARHCPRAIL).equalsIgnoreCase("")) {
            Log.e("LOAD_VALUE_KEY", SEEKBARHCPRAIL);
            seekBarhcprail.setProgress(Float.parseFloat(
                    ((MainNavActivity)getActivity()).get(SEEKBARHCPRAIL)
            ));
        }

        if (!((MainNavActivity)getActivity()).get(SEEKBARUNFIL).equalsIgnoreCase("")) {
            Log.e("LOAD_VALUE_KEY", SEEKBARUNFIL);
            seekBarunfil.setProgress(Float.parseFloat(
                    ((MainNavActivity)getActivity()).get(SEEKBARUNFIL)
            ));
        }

        if (!((MainNavActivity)getActivity()).get(SEEKBAREOP).equalsIgnoreCase("")) {
            Log.e("LOAD_VALUE_KEY", SEEKBAREOP);
            seekBareop.setProgress(Float.parseFloat(
                    ((MainNavActivity)getActivity()).get(SEEKBAREOP)
            ));
        }

        if (!((MainNavActivity)getActivity()).get(SEEKBARFILTRE_IN).equalsIgnoreCase("")) {
            Log.e("LOAD_VALUE_KEY", SEEKBARFILTRE_IN);
            seekBarfiltre_in.setProgress(Float.parseFloat(
                    ((MainNavActivity)getActivity()).get(SEEKBARFILTRE_IN)
            ));
        }

        if (!((MainNavActivity)getActivity()).get(SEEKBARTRANSFER).equalsIgnoreCase("")) {
            Log.e("LOAD_VALUE_KEY", SEEKBARTRANSFER);
            seekBartransfer.setProgress(Float.parseFloat(
                    ((MainNavActivity)getActivity()).get(SEEKBARTRANSFER)
            ));
        }

        if (!((MainNavActivity)getActivity()).get(SEEKBARFUEL_PRESU).equalsIgnoreCase("")) {
            Log.e("LOAD_VALUE_KEY", SEEKBARFUEL_PRESU);
            seekBarfuel_presu.setProgress(Float.parseFloat(
                    ((MainNavActivity)getActivity()).get(SEEKBARFUEL_PRESU)
            ));
        }

        if (!((MainNavActivity)getActivity()).get(SEEKBARCOOLANT).equalsIgnoreCase("")) {
            Log.e("LOAD_VALUE_KEY", SEEKBARCOOLANT);
            seekBarcoolant.setProgress(Float.parseFloat(
                    ((MainNavActivity)getActivity()).get(SEEKBARCOOLANT)
            ));
        }

        if (!((MainNavActivity)getActivity()).get(SEEKBARCRANKCASE).equalsIgnoreCase("")) {
            Log.e("LOAD_VALUE_KEY", SEEKBARCRANKCASE);
            seekBarcrankcase.setProgress(Float.parseFloat(
                    ((MainNavActivity)getActivity()).get(SEEKBARCRANKCASE)
            ));
        }

        seekBarcrankcase.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                pro=progress;
                Log.e("WRITE_KEY_FRAGMENT", ""+progressFloat);
                ((MainNavActivity)getActivity()).write(SEEKBARCRANKCASE, ""+progressFloat);

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

        seekBarcoolant.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                pro=progress;
                Log.e("WRITE_KEY_FRAGMENT", ""+progressFloat);
                ((MainNavActivity)getActivity()).write(SEEKBARCOOLANT, ""+progressFloat);
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

        seekBarfuel_presu.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                pro=progress;
                Log.e("WRITE_KEY_FRAGMENT", ""+progressFloat);
                ((MainNavActivity)getActivity()).write(SEEKBARFUEL_PRESU, ""+progressFloat);

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

        seekBartransfer.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                pro=progress;
                Log.e("WRITE_KEY_FRAGMENT", ""+progressFloat);
                ((MainNavActivity)getActivity()).write(SEEKBARTRANSFER, ""+progressFloat);
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

        seekBarfiltre_in.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                pro=progress;
                Log.e("WRITE_KEY_FRAGMENT", ""+progressFloat);
                ((MainNavActivity)getActivity()).write(SEEKBARFILTRE_IN, ""+progressFloat);
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

        seekBareop.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                pro=progress;
                Log.e("WRITE_KEY_FRAGMENT", ""+progressFloat);
                ((MainNavActivity)getActivity()).write(SEEKBAREOP, ""+progressFloat);
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

        seekBarunfil.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                pro=progress;
                Log.e("WRITE_KEY_FRAGMENT", ""+progressFloat);
                ((MainNavActivity)getActivity()).write(SEEKBARUNFIL, ""+progressFloat);
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

        seekBarhcprail.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                pro=progress;
                Log.e("WRITE_KEY_FRAGMENT", ""+progressFloat);
                ((MainNavActivity)getActivity()).write(SEEKBARHCPRAIL, ""+progressFloat);
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
