package engine.simulador.CAT.C32;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xw.repo.BubbleSeekBar;

import static engine.simulador.CAT.C32.ClearStorage.SEEKBARATMOS;
import static engine.simulador.CAT.C32.ClearStorage.SEEKBARINTAKE;
import static engine.simulador.CAT.C32.ClearStorage.SEEKBARINTAKEMAN2;
import static engine.simulador.CAT.C32.ClearStorage.SEEKBARTBC1;
import static engine.simulador.CAT.C32.ClearStorage.SEEKBARTURBO2;
import static engine.simulador.CAT.C32.ClearStorage.SEEKBARTURBO3;
import static engine.simulador.CAT.C32.ClearStorage.SEEKBARTURBO4;


public class Engine extends Fragment {

    int progres;
    Engine_Listener listener;
    BubbleSeekBar seekBaratmos, seekBartbc1, seekBarturbo2, seekBarintake,seekBarturbo3,seekBarturbo4,seekBarintakeman2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View vie = inflater.inflate(R.layout.fragment_engine, container, false);
        seekBartbc1 = (BubbleSeekBar) vie.findViewById(R.id.tbc1);
        seekBaratmos = (BubbleSeekBar) vie.findViewById(R.id.atmos);
        seekBarturbo2 = (BubbleSeekBar) vie.findViewById(R.id.turbo2);
        seekBarintake = (BubbleSeekBar) vie.findViewById(R.id.intakeman);
        seekBarturbo3 = (BubbleSeekBar) vie.findViewById(R.id.turbo3);
        seekBarturbo4 = (BubbleSeekBar) vie.findViewById(R.id.turbo4);
        seekBarintakeman2 = (BubbleSeekBar) vie.findViewById(R.id.intakeman2);


        if (!((MainNavActivity)getActivity()).get(SEEKBARATMOS).equalsIgnoreCase("")) {
            Log.e("LOAD_VALUE_KEY", SEEKBARATMOS);
            seekBaratmos.setProgress(Float.parseFloat(
                    ((MainNavActivity)getActivity()).get(SEEKBARATMOS)
            ));
        }

        if (!((MainNavActivity)getActivity()).get(SEEKBARTBC1).equalsIgnoreCase("")) {
            Log.e("LOAD_VALUE_KEY", SEEKBARTBC1);
            seekBartbc1.setProgress(Float.parseFloat(
                    ((MainNavActivity)getActivity()).get(SEEKBARTBC1)
            ));
        }

        if (!((MainNavActivity)getActivity()).get(SEEKBARTURBO2).equalsIgnoreCase("")) {
            Log.e("LOAD_VALUE_KEY", SEEKBARTURBO2);
            seekBarturbo2.setProgress(Float.parseFloat(
                    ((MainNavActivity)getActivity()).get(SEEKBARTURBO2)
            ));
        }

        if (!((MainNavActivity)getActivity()).get(SEEKBARINTAKE).equalsIgnoreCase("")) {
            Log.e("LOAD_VALUE_KEY", SEEKBARINTAKE);
            seekBarintake.setProgress(Float.parseFloat(
                    ((MainNavActivity)getActivity()).get(SEEKBARINTAKE)
            ));
        }

        if (!((MainNavActivity)getActivity()).get(SEEKBARTURBO3).equalsIgnoreCase("")) {
            Log.e("LOAD_VALUE_KEY", SEEKBARTURBO3);
            seekBarturbo3.setProgress(Float.parseFloat(
                    ((MainNavActivity)getActivity()).get(SEEKBARTURBO3)
            ));
        }

        if (!((MainNavActivity)getActivity()).get(SEEKBARTURBO4).equalsIgnoreCase("")) {
            Log.e("LOAD_VALUE_KEY", SEEKBARTURBO4);
            seekBarturbo4.setProgress(Float.parseFloat(
                    ((MainNavActivity)getActivity()).get(SEEKBARTURBO4)
            ));
        }

        if (!((MainNavActivity)getActivity()).get(SEEKBARINTAKEMAN2).equalsIgnoreCase("")) {
            Log.e("LOAD_VALUE_KEY", SEEKBARINTAKEMAN2);
            seekBarintakeman2.setProgress(Float.parseFloat(
                    ((MainNavActivity)getActivity()).get(SEEKBARINTAKEMAN2)
            ));
        }

        seekBaratmos.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                progres=progress;
                Log.e("WRITE_KEY_FRAGMENT", ""+progressFloat);
                ((MainNavActivity)getActivity()).write(SEEKBARATMOS, ""+progressFloat);
            }

            @Override
            public void getProgressOnActionUp(int progress, float progressFloat) {
                try {
                    //calibrado ATMOSFERICO
                    byte w[] = {1, 24, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((progres >> 24) & 0xFF);
                    w[4] = (byte) ((progres >> 16) & 0xFF);
                    w[5] = (byte) ((progres >> 8) & 0xFF);
                    w[6] = (byte) (progres & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onEngineSeekbarChange(w[i]);
                    }

                }catch (Exception e){}
            }

            @Override
            public void getProgressOnFinally(int progress, float progressFloat) {

            }
        });

        /*seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                progres = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                try {
                    //calibrado ATMOSFERICO
                    byte w[] = {1, 24, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((progres >> 24) & 0xFF);
                    w[4] = (byte) ((progres >> 16) & 0xFF);
                    w[5] = (byte) ((progres >> 8) & 0xFF);
                    w[6] = (byte) (progres & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onEngineSeekbarChange(w[i]);
                    }

                }catch (Exception e){}
            }
        });*/

        seekBarintakeman2.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                progres=progress;
                Log.e("WRITE_KEY_FRAGMENT", ""+progressFloat);
                ((MainNavActivity)getActivity()).write(SEEKBARINTAKEMAN2, ""+progressFloat);
            }

            @Override
            public void getProgressOnActionUp(int progress, float progressFloat) {
                try {
                    //calibrado MANIFOULD 2
                    byte w[] = {1, 17, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((progres >> 24) & 0xFF);
                    w[4] = (byte) ((progres >> 16) & 0xFF);
                    w[5] = (byte) ((progres >> 8) & 0xFF);
                    w[6] = (byte) (progres & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onEngineSeekbarChange(w[i]);
                    }

                }catch (Exception e){}
            }

            @Override
            public void getProgressOnFinally(int progress, float progressFloat) {

            }
        });

        /*seekBar5.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                progres = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                try {
                    //calibrado MANIFOULD 2
                    byte w[] = {1, 17, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((progres >> 24) & 0xFF);
                    w[4] = (byte) ((progres >> 16) & 0xFF);
                    w[5] = (byte) ((progres >> 8) & 0xFF);
                    w[6] = (byte) (progres & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onEngineSeekbarChange(w[i]);
                    }

                }catch (Exception e){}
            }
        });*/

        seekBarturbo4.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                progres=progress;
                Log.e("WRITE_KEY_FRAGMENT", ""+progressFloat);
                ((MainNavActivity)getActivity()).write(SEEKBARTURBO4, ""+progressFloat);
            }

            @Override
            public void getProgressOnActionUp(int progress, float progressFloat) {
                try {
                    byte w[] = {1, 21, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((progres >> 24) & 0xFF);
                    w[4] = (byte) ((progres >> 16) & 0xFF);
                    w[5] = (byte) ((progres >> 8) & 0xFF);
                    w[6] = (byte) (progres & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onEngineSeekbarChange(w[i]);
                    }
                }catch (Exception e){}
            }

            @Override
            public void getProgressOnFinally(int progress, float progressFloat) {

            }
        });

        /*seekBar4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                progres = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                try {
                    byte w[] = {1, 21, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((progres >> 24) & 0xFF);
                    w[4] = (byte) ((progres >> 16) & 0xFF);
                    w[5] = (byte) ((progres >> 8) & 0xFF);
                    w[6] = (byte) (progres & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onEngineSeekbarChange(w[i]);
                    }
                }catch (Exception e){}
            }
        });*/

        seekBarturbo3.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                progres=progress;
                Log.e("WRITE_KEY_FRAGMENT", ""+progressFloat);
                ((MainNavActivity)getActivity()).write(SEEKBARTURBO3, ""+progressFloat);
            }

            @Override
            public void getProgressOnActionUp(int progress, float progressFloat) {
                try {
                    byte w[] = {1, 29, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((progres >> 24) & 0xFF);
                    w[4] = (byte) ((progres >> 16) & 0xFF);
                    w[5] = (byte) ((progres >> 8) & 0xFF);
                    w[6] = (byte) (progres & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onEngineSeekbarChange(w[i]);
                    }
                }catch (Exception e){}
            }

            @Override
            public void getProgressOnFinally(int progress, float progressFloat) {

            }
        });

        /*seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                progres = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                try {
                    byte w[] = {1, 29, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((progres >> 24) & 0xFF);
                    w[4] = (byte) ((progres >> 16) & 0xFF);
                    w[5] = (byte) ((progres >> 8) & 0xFF);
                    w[6] = (byte) (progres & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onEngineSeekbarChange(w[i]);
                    }
                }catch (Exception e){}
            }
        });*/

        seekBarintake.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                progres=progress;
                Log.e("WRITE_KEY_FRAGMENT", ""+progressFloat);
                ((MainNavActivity)getActivity()).write(SEEKBARINTAKE, ""+progressFloat);
            }

            @Override
            public void getProgressOnActionUp(int progress, float progressFloat) {
                try {
                    //calibrado MANIFOULD 1
                    byte w[] = {1, 23, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((progres >> 24) & 0xFF);
                    w[4] = (byte) ((progres >> 16) & 0xFF);
                    w[5] = (byte) ((progres >> 8) & 0xFF);
                    w[6] = (byte) (progres & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onEngineSeekbarChange(w[i]);
                    }
                }catch (Exception e){}
            }

            @Override
            public void getProgressOnFinally(int progress, float progressFloat) {

            }
        });

        /*seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                progres = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                try {
                    //calibrado MANIFOULD 1
                    byte w[] = {1, 23, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((progres >> 24) & 0xFF);
                    w[4] = (byte) ((progres >> 16) & 0xFF);
                    w[5] = (byte) ((progres >> 8) & 0xFF);
                    w[6] = (byte) (progres & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onEngineSeekbarChange(w[i]);
                    }
                }catch (Exception e){}
            }
        });*/

        seekBarturbo2.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                progres=progress;
                Log.e("WRITE_KEY_FRAGMENT", ""+progressFloat);
                ((MainNavActivity)getActivity()).write(SEEKBARTURBO2, ""+progressFloat);
            }

            @Override
            public void getProgressOnActionUp(int progress, float progressFloat) {
                try {
                    byte w[] = {1, 25, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((progres >> 24) & 0xFF);
                    w[4] = (byte) ((progres >> 16) & 0xFF);
                    w[5] = (byte) ((progres >> 8) & 0xFF);
                    w[6] = (byte) (progres & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onEngineSeekbarChange(w[i]);
                    }
                }catch (Exception e){}
            }

            @Override
            public void getProgressOnFinally(int progress, float progressFloat) {

            }
        });

        /*seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                progres = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                try {
                    byte w[] = {1, 25, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((progres >> 24) & 0xFF);
                    w[4] = (byte) ((progres >> 16) & 0xFF);
                    w[5] = (byte) ((progres >> 8) & 0xFF);
                    w[6] = (byte) (progres & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onEngineSeekbarChange(w[i]);
                    }
                }catch (Exception e){}
            }
        });*/

        seekBartbc1.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                progres=progress;
                Log.e("WRITE_KEY_FRAGMENT", ""+progressFloat);
                ((MainNavActivity)getActivity()).write(SEEKBARTBC1, ""+progressFloat);
            }

            @Override
            public void getProgressOnActionUp(int progress, float progressFloat) {
                try {
                    byte w[] = {1, 19, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((progres >> 24) & 0xFF);
                    w[4] = (byte) ((progres >> 16) & 0xFF);
                    w[5] = (byte) ((progres >> 8) & 0xFF);
                    w[6] = (byte) (progres & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onEngineSeekbarChange(w[i]);
                    }
                }catch (Exception e){}
            }

            @Override
            public void getProgressOnFinally(int progress, float progressFloat) {

            }
        });

        /*seekBarr.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                progres = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                try {
                    byte w[] = {1, 19, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((progres >> 24) & 0xFF);
                    w[4] = (byte) ((progres >> 16) & 0xFF);
                    w[5] = (byte) ((progres >> 8) & 0xFF);
                    w[6] = (byte) (progres & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onEngineSeekbarChange(w[i]);
                    }
                }catch (Exception e){}
            }
        });*/

        return vie;
    }

    public int aMethodMainActivityCanCAll(String withSomeParameter){
        int aResultToMainActivity = 0;
        //MainActivity can call methods on the fragment to communicate things like
        //requesting some status, or pass throguh requests from other fragment.
        return aResultToMainActivity;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listener = (Engine_Listener) getActivity();
    }

    public interface Engine_Listener {
        public void onEngineSeekbarChange(byte b);
    }
}

