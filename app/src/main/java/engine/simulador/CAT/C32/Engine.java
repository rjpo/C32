package engine.simulador.CAT.C32;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xw.repo.BubbleSeekBar;


public class Engine extends Fragment {

    int progres;
    Engine_Listener listener;
    Store storage;
    BubbleSeekBar seekBar, seekBarr, seekBar1, seekBar2,seekBar3,seekBar4,seekBar5;
    public static String SEEKBAR = "seekBar";
    public static String SEEKBARR = "seekBarr";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        storage = new Store();
        View vie = inflater.inflate(R.layout.fragment_engine, container, false);
        seekBarr = (BubbleSeekBar) vie.findViewById(R.id.tbc1);
        seekBar = (BubbleSeekBar) vie.findViewById(R.id.atmos);
        seekBar1 = (BubbleSeekBar) vie.findViewById(R.id.turbo2);
        seekBar2 = (BubbleSeekBar) vie.findViewById(R.id.intakeman);
        seekBar3 = (BubbleSeekBar) vie.findViewById(R.id.turbo3);
        seekBar4 = (BubbleSeekBar) vie.findViewById(R.id.turbo4);
        seekBar5 = (BubbleSeekBar) vie.findViewById(R.id.intakeman2);

        seekBar.setProgress(Float.parseFloat(storage.get(SEEKBAR)));
        seekBar.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                progres=progress;
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
                storage.write(SEEKBAR, ""+progressFloat);
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

        seekBar2.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                progres=progress;
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

