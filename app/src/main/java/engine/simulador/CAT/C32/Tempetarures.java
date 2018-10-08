package engine.simulador.CAT.C32;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xw.repo.BubbleSeekBar;

import static engine.simulador.CAT.C32.ClearStorage.SEEKBARTEMPAMBIENT;
import static engine.simulador.CAT.C32.ClearStorage.SEEKBARTEMPENGINE;
import static engine.simulador.CAT.C32.ClearStorage.SEEKBARTEMPENGINEOIL;
import static engine.simulador.CAT.C32.ClearStorage.SEEKBARTEMPFUEL;
import static engine.simulador.CAT.C32.ClearStorage.SEEKBARTEMPFUELRAIL;
import static engine.simulador.CAT.C32.ClearStorage.SEEKBARTEMPLEFT;
import static engine.simulador.CAT.C32.ClearStorage.SEEKBARTEMPMANIFOLD;
import static engine.simulador.CAT.C32.ClearStorage.SEEKBARTEMPMANIFOLD2;
import static engine.simulador.CAT.C32.ClearStorage.SEEKBARTEMPRIGHT;


public class Tempetarures extends Fragment {


    int pro;
    BubbleSeekBar seekBartempengine, seekBartempengineoil, seekBartempfuel, seekBartempfuelrail, seekBartempambient, seekBartempmanifold, seekBartempmanifold2, seekBartempleft, seekBartempraight;



    Temperatures_listener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tempetarures, container, false);

        seekBartempengine=(BubbleSeekBar) rootView.findViewById(R.id.tempengine);
        seekBartempengineoil=(BubbleSeekBar) rootView.findViewById(R.id.tempengineoil);
        seekBartempfuel=(BubbleSeekBar) rootView.findViewById(R.id.tempfuel);
        seekBartempfuelrail=(BubbleSeekBar) rootView.findViewById(R.id.tempfuelrail);
        seekBartempambient=(BubbleSeekBar) rootView.findViewById(R.id.tempambient);
        seekBartempmanifold=(BubbleSeekBar) rootView.findViewById(R.id.tempmanifold);
        seekBartempmanifold2=(BubbleSeekBar) rootView.findViewById(R.id.tempmanifold2);
        seekBartempleft=(BubbleSeekBar) rootView.findViewById(R.id.templeft);
        seekBartempraight=(BubbleSeekBar) rootView.findViewById(R.id.tempraight);

        if (!((MainNavActivity)getActivity()).get(SEEKBARTEMPENGINE).equalsIgnoreCase("")) {
            Log.e("LOAD_VALUE_KEY", SEEKBARTEMPENGINE);
            seekBartempengine.setProgress(Float.parseFloat(
                    ((MainNavActivity)getActivity()).get(SEEKBARTEMPENGINE)
            ));
        }

        if (!((MainNavActivity)getActivity()).get(SEEKBARTEMPENGINEOIL).equalsIgnoreCase("")) {
            Log.e("LOAD_VALUE_KEY", SEEKBARTEMPENGINEOIL);
            seekBartempengineoil.setProgress(Float.parseFloat(
                    ((MainNavActivity)getActivity()).get(SEEKBARTEMPENGINEOIL)
            ));
        }

        if (!((MainNavActivity)getActivity()).get(SEEKBARTEMPFUEL).equalsIgnoreCase("")) {
            Log.e("LOAD_VALUE_KEY", SEEKBARTEMPFUEL);
            seekBartempfuel.setProgress(Float.parseFloat(
                    ((MainNavActivity)getActivity()).get(SEEKBARTEMPFUEL)
            ));
        }

        if (!((MainNavActivity)getActivity()).get(SEEKBARTEMPFUELRAIL).equalsIgnoreCase("")) {
            Log.e("LOAD_VALUE_KEY", SEEKBARTEMPFUELRAIL);
            seekBartempfuelrail.setProgress(Float.parseFloat(
                    ((MainNavActivity)getActivity()).get(SEEKBARTEMPFUELRAIL)
            ));
        }

        if (!((MainNavActivity)getActivity()).get(SEEKBARTEMPAMBIENT).equalsIgnoreCase("")) {
            Log.e("LOAD_VALUE_KEY", SEEKBARTEMPAMBIENT);
            seekBartempambient.setProgress(Float.parseFloat(
                    ((MainNavActivity)getActivity()).get(SEEKBARTEMPAMBIENT)
            ));
        }

        if (!((MainNavActivity)getActivity()).get(SEEKBARTEMPMANIFOLD).equalsIgnoreCase("")) {
            Log.e("LOAD_VALUE_KEY", SEEKBARTEMPMANIFOLD);
            seekBartempmanifold.setProgress(Float.parseFloat(
                    ((MainNavActivity)getActivity()).get(SEEKBARTEMPMANIFOLD)
            ));
        }

        if (!((MainNavActivity)getActivity()).get(SEEKBARTEMPMANIFOLD2).equalsIgnoreCase("")) {
            Log.e("LOAD_VALUE_KEY", SEEKBARTEMPMANIFOLD2);
            seekBartempmanifold2.setProgress(Float.parseFloat(
                    ((MainNavActivity)getActivity()).get(SEEKBARTEMPMANIFOLD2)
            ));
        }

        if (!((MainNavActivity)getActivity()).get(SEEKBARTEMPLEFT).equalsIgnoreCase("")) {
            Log.e("LOAD_VALUE_KEY", SEEKBARTEMPLEFT);
            seekBartempleft.setProgress(Float.parseFloat(
                    ((MainNavActivity)getActivity()).get(SEEKBARTEMPLEFT)
            ));
        }

        if (!((MainNavActivity)getActivity()).get(SEEKBARTEMPRIGHT).equalsIgnoreCase("")) {
            Log.e("LOAD_VALUE_KEY", SEEKBARTEMPRIGHT);
            seekBartempraight.setProgress(Float.parseFloat(
                    ((MainNavActivity)getActivity()).get(SEEKBARTEMPRIGHT)
            ));
        }

        seekBartempengine.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int pro, float progressFloat) {
                pro=1;
                Log.e("WRITE_KEY_FRAGMENT", ""+progressFloat);
                ((MainNavActivity)getActivity()).write(SEEKBARTEMPENGINE, ""+progressFloat);
            }

            @Override
            public void getProgressOnActionUp(int pro, float progressFloat) {
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
            public void getProgressOnFinally(int pro, float progressFloat) {

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

        seekBartempengineoil.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int pro, float progressFloat) {
                pro=1;
                Log.e("WRITE_KEY_FRAGMENT", ""+progressFloat);
                ((MainNavActivity)getActivity()).write(SEEKBARTEMPENGINEOIL, ""+progressFloat);
            }

            @Override
            public void getProgressOnActionUp(int pro, float progressFloat) {
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
            public void getProgressOnFinally(int pro, float progressFloat) {

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

        seekBartempfuel.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int pro, float progressFloat) {
                pro=1;
                Log.e("WRITE_KEY_FRAGMENT", ""+progressFloat);
                ((MainNavActivity)getActivity()).write(SEEKBARTEMPFUEL, ""+progressFloat);
            }

            @Override
            public void getProgressOnActionUp(int pro, float progressFloat) {
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
            public void getProgressOnFinally(int pro, float progressFloat) {


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

        seekBartempfuelrail.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int pro, float progressFloat) {
                pro=1;
                Log.e("WRITE_KEY_FRAGMENT", ""+progressFloat);
                ((MainNavActivity)getActivity()).write(SEEKBARTEMPFUELRAIL, ""+progressFloat);
            }

            @Override
            public void getProgressOnActionUp(int pro, float progressFloat) {
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
            public void getProgressOnFinally(int pro, float progressFloat) {

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

        seekBartempambient.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int pro, float progressFloat) {
                pro=1;
                Log.e("WRITE_KEY_FRAGMENT", ""+progressFloat);
                ((MainNavActivity)getActivity()).write(SEEKBARTEMPAMBIENT, ""+progressFloat);
            }

            @Override
            public void getProgressOnActionUp(int pro, float progressFloat) {
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
            public void getProgressOnFinally(int pro, float progressFloat) {

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

        seekBartempmanifold.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int pro, float progressFloat) {
                pro=1;
                Log.e("WRITE_KEY_FRAGMENT", ""+progressFloat);
                ((MainNavActivity)getActivity()).write(SEEKBARTEMPMANIFOLD, ""+progressFloat);
            }

            @Override
            public void getProgressOnActionUp(int pro, float progressFloat) {
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
            public void getProgressOnFinally(int pro, float progressFloat) {

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

        seekBartempmanifold2.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int pro, float progressFloat) {
                pro=1;
                Log.e("WRITE_KEY_FRAGMENT", ""+progressFloat);
                ((MainNavActivity)getActivity()).write(SEEKBARTEMPMANIFOLD2, ""+progressFloat);
            }

            @Override
            public void getProgressOnActionUp(int pro, float progressFloat) {
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
            public void getProgressOnFinally(int pro, float progressFloat) {

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

        seekBartempleft.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int pro, float progressFloat) {
                pro=1;
                Log.e("WRITE_KEY_FRAGMENT", ""+progressFloat);
                ((MainNavActivity)getActivity()).write(SEEKBARTEMPLEFT, ""+progressFloat);
            }

            @Override
            public void getProgressOnActionUp(int pro, float progressFloat) {
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
            public void getProgressOnFinally(int pro, float progressFloat) {

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

        seekBartempraight.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int pro, float progressFloat) {
                pro=1;
                Log.e("WRITE_KEY_FRAGMENT", ""+progressFloat);
                ((MainNavActivity)getActivity()).write(SEEKBARTEMPRIGHT, ""+progressFloat);
            }

            @Override
            public void getProgressOnActionUp(int pro, float progressFloat) {
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
            public void getProgressOnFinally(int pro, float progressFloat) {

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