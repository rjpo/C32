package engine.simulador.CAT.C32;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xw.repo.BubbleSeekBar;


public class Tempetarures extends Fragment {


    int pro;
    BubbleSeekBar seekBar,seekBar1, seekBar2, seekBar3, seekBar4, seekBar5, seekBar6, seekBar7, seekBar8,seekBar9;


    Temperatures_listener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tempetarures, container, false);

        seekBar1=(BubbleSeekBar) rootView.findViewById(R.id.tempengine);
        seekBar2=(BubbleSeekBar) rootView.findViewById(R.id.tempengineoil);
        seekBar3=(BubbleSeekBar) rootView.findViewById(R.id.tempfuel);
        seekBar4=(BubbleSeekBar) rootView.findViewById(R.id.tempfuelrail);
        seekBar5=(BubbleSeekBar) rootView.findViewById(R.id.tempambient);
        seekBar6=(BubbleSeekBar) rootView.findViewById(R.id.tempmanifold);
        seekBar7=(BubbleSeekBar) rootView.findViewById(R.id.tempmanifold2);
        seekBar8=(BubbleSeekBar) rootView.findViewById(R.id.templeft);
        seekBar9=(BubbleSeekBar) rootView.findViewById(R.id.tempraight);

        seekBar1.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                pro=1;
            }

            @Override
            public void getProgressOnActionUp(int progress, float progressFloat) {
                try {
                    // TEMPERATURA ENGINE CALIBRADO
                    byte w[] = {1, 15, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((pro >> 24) & 0xFF);
                    w[4] = (byte) ((pro >> 16) & 0xFF);
                    w[5] = (byte) ((pro >> 8) & 0xFF);
                    w[6] = (byte) (pro & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onTemperatures_SeekChanger(w[i]);
                    }
                }catch (Exception e){}
            }

            @Override
            public void getProgressOnFinally(int progress, float progressFloat) {

            }
        });

        /*seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int l, boolean fromUser) {
                pro = l;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                try {
                    // TEMPERATURA ENGINE CALIBRADO
                    byte w[] = {1, 15, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((pro >> 24) & 0xFF);
                    w[4] = (byte) ((pro >> 16) & 0xFF);
                    w[5] = (byte) ((pro >> 8) & 0xFF);
                    w[6] = (byte) (pro & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onTemperatures_SeekChanger(w[i]);
                    }
                }catch (Exception e){}

            }
        });*/

        seekBar2.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                pro=1;
            }

            @Override
            public void getProgressOnActionUp(int progress, float progressFloat) {
                try {
                    // TEMPERATURA ENGINE OIL CALIBRADO
                    byte w[] = {1, 13, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((pro >> 24) & 0xFF);
                    w[4] = (byte) ((pro >> 16) & 0xFF);
                    w[5] = (byte) ((pro >> 8) & 0xFF);
                    w[6] = (byte) (pro & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onTemperatures_SeekChanger(w[i]);
                    }
                }catch (Exception e){}
            }

            @Override
            public void getProgressOnFinally(int progress, float progressFloat) {

            }
        });

        /*seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int l, boolean fromUser) {
                pro = l;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                try {
                    // TEMPERATURA ENGINE OIL CALIBRADO
                    byte w[] = {1, 13, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((pro >> 24) & 0xFF);
                    w[4] = (byte) ((pro >> 16) & 0xFF);
                    w[5] = (byte) ((pro >> 8) & 0xFF);
                    w[6] = (byte) (pro & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onTemperatures_SeekChanger(w[i]);
                    }
                }catch (Exception e){}

            }
        });*/

        seekBar3.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                pro=1;
            }

            @Override
            public void getProgressOnActionUp(int progress, float progressFloat) {
                try {
                    // TEMPERATURA FUEL CALIBRADO
                    byte w[] = {1, 11, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((pro >> 24) & 0xFF);
                    w[4] = (byte) ((pro >> 16) & 0xFF);
                    w[5] = (byte) ((pro >> 8) & 0xFF);
                    w[6] = (byte) (pro & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onTemperatures_SeekChanger(w[i]);
                    }
                }catch (Exception e){}
            }

            @Override
            public void getProgressOnFinally(int progress, float progressFloat) {


            }
        });

        /*seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int l, boolean fromUser) {
                pro = l;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                try {
                    // TEMPERATURA FUEL CALIBRADO
                    byte w[] = {1, 11, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((pro >> 24) & 0xFF);
                    w[4] = (byte) ((pro >> 16) & 0xFF);
                    w[5] = (byte) ((pro >> 8) & 0xFF);
                    w[6] = (byte) (pro & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onTemperatures_SeekChanger(w[i]);
                    }
                }catch (Exception e){}

            }
        });*/

        seekBar4.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                pro=1;
            }

            @Override
            public void getProgressOnActionUp(int progress, float progressFloat) {
                try {
                    // TEMPERATURA FUEL RAIL CALIBRADO
                    byte w[] = {1, 12, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((pro >> 24) & 0xFF);
                    w[4] = (byte) ((pro >> 16) & 0xFF);
                    w[5] = (byte) ((pro >> 8) & 0xFF);
                    w[6] = (byte) (pro & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onTemperatures_SeekChanger(w[i]);
                    }
                }catch (Exception e){}
            }

            @Override
            public void getProgressOnFinally(int progress, float progressFloat) {

            }
        });

        /*seekBar4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int l, boolean fromUser) {
                pro = l;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                try {
                    // TEMPERATURA FUEL RAIL CALIBRADO
                    byte w[] = {1, 12, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((pro >> 24) & 0xFF);
                    w[4] = (byte) ((pro >> 16) & 0xFF);
                    w[5] = (byte) ((pro >> 8) & 0xFF);
                    w[6] = (byte) (pro & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onTemperatures_SeekChanger(w[i]);
                    }
                }catch (Exception e){}

            }
        });*/

        seekBar5.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                pro=1;
            }

            @Override
            public void getProgressOnActionUp(int progress, float progressFloat) {
                try {
                    // TEMPERATURA AMBIENTE CALIBRADO
                    byte w[] = {1, 45, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((pro >> 24) & 0xFF);
                    w[4] = (byte) ((pro >> 16) & 0xFF);
                    w[5] = (byte) ((pro >> 8) & 0xFF);
                    w[6] = (byte) (pro & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onTemperatures_SeekChanger(w[i]);
                    }
                }catch (Exception e){}
            }

            @Override
            public void getProgressOnFinally(int progress, float progressFloat) {

            }
        });

        /*seekBar5.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int l, boolean fromUser) {
                pro = l;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                try {
                    // TEMPERATURA AMBIENTE CALIBRADO
                    byte w[] = {1, 45, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((pro >> 24) & 0xFF);
                    w[4] = (byte) ((pro >> 16) & 0xFF);
                    w[5] = (byte) ((pro >> 8) & 0xFF);
                    w[6] = (byte) (pro & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onTemperatures_SeekChanger(w[i]);
                    }
                }catch (Exception e){}

            }
        });*/

        seekBar6.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                pro=1;
            }

            @Override
            public void getProgressOnActionUp(int progress, float progressFloat) {
                try {
                    // TEMPERATURA MANIFOLD 1 CALIBRADO
                    byte w[] = {1, 10, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((pro >> 24) & 0xFF);
                    w[4] = (byte) ((pro >> 16) & 0xFF);
                    w[5] = (byte) ((pro >> 8) & 0xFF);
                    w[6] = (byte) (pro & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onTemperatures_SeekChanger(w[i]);
                    }
                }catch (Exception e){}
            }

            @Override
            public void getProgressOnFinally(int progress, float progressFloat) {

            }
        });

        /*seekBar6.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int l, boolean fromUser) {
                pro = l;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                try {
                    // TEMPERATURA MANIFOLD 1 CALIBRADO
                    byte w[] = {1, 10, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((pro >> 24) & 0xFF);
                    w[4] = (byte) ((pro >> 16) & 0xFF);
                    w[5] = (byte) ((pro >> 8) & 0xFF);
                    w[6] = (byte) (pro & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onTemperatures_SeekChanger(w[i]);
                    }
                }catch (Exception e){}

            }
        });*/

        seekBar7.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                pro=1;
            }

            @Override
            public void getProgressOnActionUp(int progress, float progressFloat) {
                try {
                    // TEMPERATURA MANIFOLD 2 CALIBRADO
                    byte w[] = {1, 9, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((pro >> 24) & 0xFF);
                    w[4] = (byte) ((pro >> 16) & 0xFF);
                    w[5] = (byte) ((pro >> 8) & 0xFF);
                    w[6] = (byte) (pro & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onTemperatures_SeekChanger(w[i]);
                    }
                }catch (Exception e){}
            }

            @Override
            public void getProgressOnFinally(int progress, float progressFloat) {

            }
        });

        /*seekBar7.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int l, boolean fromUser) {
                pro = l;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                try {
                    // TEMPERATURA MANIFOLD 2 CALIBRADO
                    byte w[] = {1, 9, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((pro >> 24) & 0xFF);
                    w[4] = (byte) ((pro >> 16) & 0xFF);
                    w[5] = (byte) ((pro >> 8) & 0xFF);
                    w[6] = (byte) (pro & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onTemperatures_SeekChanger(w[i]);
                    }
                }catch (Exception e){}

            }
        });*/

        seekBar8.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                pro=1;
            }

            @Override
            public void getProgressOnActionUp(int progress, float progressFloat) {
                try {
                    // TEMPERATURA LEFT
                    byte w[] = {1, 41, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((pro >> 24) & 0xFF);
                    w[4] = (byte) ((pro >> 16) & 0xFF);
                    w[5] = (byte) ((pro >> 8) & 0xFF);
                    w[6] = (byte) (pro & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onTemperatures_SeekChanger(w[i]);
                    }
                }catch (Exception e){}
            }

            @Override
            public void getProgressOnFinally(int progress, float progressFloat) {

            }
        });

        /*seekBar8.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int l, boolean fromUser) {
                pro = l;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                try {
                    // TEMPERATURA LEFT
                    byte w[] = {1, 41, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((pro >> 24) & 0xFF);
                    w[4] = (byte) ((pro >> 16) & 0xFF);
                    w[5] = (byte) ((pro >> 8) & 0xFF);
                    w[6] = (byte) (pro & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onTemperatures_SeekChanger(w[i]);
                    }
                }catch (Exception e){}

            }
        });*/

        seekBar9.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                pro=1;
            }

            @Override
            public void getProgressOnActionUp(int progress, float progressFloat) {
                try {
                    // TEMPERATURA RAIGHT
                    byte w[] = {1, 42, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((pro >> 24) & 0xFF);
                    w[4] = (byte) ((pro >> 16) & 0xFF);
                    w[5] = (byte) ((pro >> 8) & 0xFF);
                    w[6] = (byte) (pro & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onTemperatures_SeekChanger(w[i]);
                    }
                }catch (Exception e){}
            }

            @Override
            public void getProgressOnFinally(int progress, float progressFloat) {

            }
        });

        /*seekBar9.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int l, boolean fromUser) {
                pro = l;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                try {
                    // TEMPERATURA RAIGHT
                    byte w[] = {1, 42, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((pro >> 24) & 0xFF);
                    w[4] = (byte) ((pro >> 16) & 0xFF);
                    w[5] = (byte) ((pro >> 8) & 0xFF);
                    w[6] = (byte) (pro & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onTemperatures_SeekChanger(w[i]);
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
        listener = (Temperatures_listener) getActivity();
    }



    public static interface Temperatures_listener {
        public void onTemperatures_SeekChanger(byte b);
    }
}