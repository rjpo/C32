package engine.simulador.CAT.C32;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xw.repo.BubbleSeekBar;


public class Engine extends Fragment {

    int progres;
    Engine_Listener listener;
    BubbleSeekBar seekBar, seekBarr, seekBar1, seekBarintake,seekBar3,seekBar4,seekBar5;
    public static final String SEEKBAR = "seekBar";
    public static final String SEEKBARR = "seekBarr";
    public static final String SEEKBAR1 = "seekBar1";
    public static final String SEEKBARINTAKE = "seekBarintake";
    public static final String SEEKBAR3 = "seekBar3";
    public static final String SEEKBAR4 = "seekBar4";
    public static final String SEEKBAR5 = "seekBar5";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View vie = inflater.inflate(R.layout.fragment_engine, container, false);
        seekBarr = (BubbleSeekBar) vie.findViewById(R.id.tbc1);
        seekBar = (BubbleSeekBar) vie.findViewById(R.id.atmos);
        seekBar1 = (BubbleSeekBar) vie.findViewById(R.id.turbo2);
        seekBarintake = (BubbleSeekBar) vie.findViewById(R.id.intakeman);
        seekBar3 = (BubbleSeekBar) vie.findViewById(R.id.turbo3);
        seekBar4 = (BubbleSeekBar) vie.findViewById(R.id.turbo4);
        seekBar5 = (BubbleSeekBar) vie.findViewById(R.id.intakeman2);


        if (!((MainNavActivity)getActivity()).get(SEEKBAR).equalsIgnoreCase("")) {
            Log.e("LOAD_VALUE_KEY", SEEKBAR);
            seekBar.setProgress(Float.parseFloat(
                    ((MainNavActivity)getActivity()).get(SEEKBAR)
            ));
        }

        if (!((MainNavActivity)getActivity()).get(SEEKBARR).equalsIgnoreCase("")) {
            Log.e("LOAD_VALUE_KEY", SEEKBARR);
            seekBarr.setProgress(Float.parseFloat(
                    ((MainNavActivity)getActivity()).get(SEEKBARR)
            ));
        }

        if (!((MainNavActivity)getActivity()).get(SEEKBAR1).equalsIgnoreCase("")) {
            Log.e("LOAD_VALUE_KEY", SEEKBAR1);
            seekBar1.setProgress(Float.parseFloat(
                    ((MainNavActivity)getActivity()).get(SEEKBAR1)
            ));
        }

        if (!((MainNavActivity)getActivity()).get(SEEKBARINTAKE).equalsIgnoreCase("")) {
            Log.e("LOAD_VALUE_KEY", SEEKBARINTAKE);
            seekBarintake.setProgress(Float.parseFloat(
                    ((MainNavActivity)getActivity()).get(SEEKBARINTAKE)
            ));
        }

        if (!((MainNavActivity)getActivity()).get(SEEKBAR3).equalsIgnoreCase("")) {
            Log.e("LOAD_VALUE_KEY", SEEKBAR3);
            seekBar3.setProgress(Float.parseFloat(
                    ((MainNavActivity)getActivity()).get(SEEKBAR3)
            ));
        }

        if (!((MainNavActivity)getActivity()).get(SEEKBAR4).equalsIgnoreCase("")) {
            Log.e("LOAD_VALUE_KEY", SEEKBAR4);
            seekBar4.setProgress(Float.parseFloat(
                    ((MainNavActivity)getActivity()).get(SEEKBAR4)
            ));
        }

        if (!((MainNavActivity)getActivity()).get(SEEKBAR5).equalsIgnoreCase("")) {
            Log.e("LOAD_VALUE_KEY", SEEKBAR5);
            seekBar5.setProgress(Float.parseFloat(
                    ((MainNavActivity)getActivity()).get(SEEKBAR5)
            ));
        }

        seekBar.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                progres=progress;
                Log.e("WRITE_KEY_FRAGMENT", ""+progressFloat);
                ((MainNavActivity)getActivity()).write(SEEKBAR, ""+progressFloat);
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

        seekBar5.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                progres=progress;
                Log.e("WRITE_KEY_FRAGMENT", ""+progressFloat);
                ((MainNavActivity)getActivity()).write(SEEKBAR5, ""+progressFloat);
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

        seekBar4.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                progres=progress;
                Log.e("WRITE_KEY_FRAGMENT", ""+progressFloat);
                ((MainNavActivity)getActivity()).write(SEEKBAR4, ""+progressFloat);
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

        seekBar3.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                progres=progress;
                Log.e("WRITE_KEY_FRAGMENT", ""+progressFloat);
                ((MainNavActivity)getActivity()).write(SEEKBAR3, ""+progressFloat);
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

        seekBar1.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                progres=progress;
                Log.e("WRITE_KEY_FRAGMENT", ""+progressFloat);
                ((MainNavActivity)getActivity()).write(SEEKBAR1, ""+progressFloat);
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

        seekBarr.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                progres=progress;
                Log.e("WRITE_KEY_FRAGMENT", ""+progressFloat);
                ((MainNavActivity)getActivity()).write(SEEKBARR, ""+progressFloat);
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

