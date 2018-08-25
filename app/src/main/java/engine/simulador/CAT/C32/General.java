package engine.simulador.CAT.C32;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothSocket;
import android.os.Handler;

import java.util.UUID;

import android.widget.Switch;
import android.widget.CompoundButton;

import com.xw.repo.BubbleSeekBar;


public class General extends Fragment  {


    General_Listener listener;

    Handler bluetoothIn;
    final int handlerState = 0;
    private BluetoothAdapter btAdapter = null;
    private BluetoothSocket btSocket = null;
    private StringBuilder DataStringIN = new StringBuilder();
   /// private General.ConnectedThread MyConexionBT;
    // Identificador unico de servicio - SPP UUID
    private static final UUID BTMODULEUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    // String para la direccion MAC
    private static String address = null;
    //-------------------------------------------

    private View rootView = null;

    int progres;
    //SeekBar seekBarr, seekBar1, seekBar2,seekBar3,seekBar4,seekBar5;
    BubbleSeekBar seekBareop, seekBarintake, seekBarfuel_presu,seekBarcoolant,seekBartempfuel,seekBartempengineoil;
    Switch swichshutdown, swichcoolantLevel;
    public static final String SEEKBAREOP = "seekBareop";
    public static final String SEEKBARINTAKE = "seekBarintake";
    public static final String SEEKBARFUEL_PRESU = "seekBarfuel_presu";
    public static final String SEEKBARCOOLANT = "seekBarcoolant";
    public static final String SEEKBARTEMPFUEL = "seekBartempfuel";
    public static final String SEEKBARTEMPENGINEOIL = "seekBartempengineoil";
    public final String SWICHCOOLANTLEVEL = "swichcoolantLevel";
    public final String SWICHSHUTDOWN = "swichshutdown";
    public final String FALSE = "false", TRUE = "true";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {


        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //rootView = inflater.inflate(R.layout.fragment_general, container, false);

        View vi = inflater.inflate(R.layout.fragment_general, container, false);

        seekBareop = (BubbleSeekBar)vi.findViewById(R.id.eop);
        seekBarintake = (BubbleSeekBar) vi.findViewById(R.id.intake);
        seekBarfuel_presu = (BubbleSeekBar)vi.findViewById(R.id.gfuel_pre);
        seekBarcoolant = (BubbleSeekBar)vi.findViewById(R.id.ecp);
        seekBartempfuel = (BubbleSeekBar)vi.findViewById(R.id.gfurl_trmp);
        seekBartempengineoil = (BubbleSeekBar)vi.findViewById(R.id.enoiltemp);
        swichshutdown = (Switch)vi.findViewById(R.id.switch1);
        swichcoolantLevel = (Switch)vi.findViewById(R.id.switch2);

        if (!((MainNavActivity)getActivity()).get(SEEKBAREOP).equalsIgnoreCase("")) {
            Log.e("LOAD_VALUE_KEY", SEEKBAREOP);
            seekBareop.setProgress(Float.parseFloat(
                    ((MainNavActivity)getActivity()).get(SEEKBAREOP)
            ));
        }

        if (!((MainNavActivity)getActivity()).get(SEEKBARFUEL_PRESU).equalsIgnoreCase("")) {
            Log.e("LOAD_VALUE_KEY", SEEKBARFUEL_PRESU);
            seekBarfuel_presu.setProgress(Float.parseFloat(
                    ((MainNavActivity)getActivity()).get(SEEKBARFUEL_PRESU)
            ));
        }

        if (!((MainNavActivity)getActivity()).get(SEEKBARINTAKE).equalsIgnoreCase("")) {
            Log.e("LOAD_VALUE_KEY", SEEKBARINTAKE);
            seekBarintake.setProgress(Float.parseFloat(
                    ((MainNavActivity)getActivity()).get(SEEKBARINTAKE)
            ));
        }

        if (!((MainNavActivity)getActivity()).get(SEEKBARCOOLANT).equalsIgnoreCase("")) {
            Log.e("LOAD_VALUE_KEY", SEEKBARCOOLANT);
            seekBarcoolant.setProgress(Float.parseFloat(
                    ((MainNavActivity)getActivity()).get(SEEKBARCOOLANT)
            ));
        }

        if (!((MainNavActivity)getActivity()).get(SEEKBARTEMPFUEL).equalsIgnoreCase("")) {
            Log.e("LOAD_VALUE_KEY", SEEKBARTEMPFUEL);
            seekBartempfuel.setProgress(Float.parseFloat(
                    ((MainNavActivity)getActivity()).get(SEEKBARTEMPFUEL)
            ));
        }

        if (!((MainNavActivity)getActivity()).get(SEEKBARTEMPENGINEOIL).equalsIgnoreCase("")) {
            Log.e("LOAD_VALUE_KEY", SEEKBARTEMPENGINEOIL);
            seekBartempengineoil.setProgress(Float.parseFloat(
                    ((MainNavActivity)getActivity()).get(SEEKBARTEMPENGINEOIL)
            ));
        }

        String swichcoolantLevel_state = ((MainNavActivity)getActivity()).get(SWICHCOOLANTLEVEL);

        if (!swichcoolantLevel_state.equalsIgnoreCase("")) {
            this.setSwich(swichcoolantLevel, swichcoolantLevel_state);
        }

        String swichshutdown_state = ((MainNavActivity)getActivity()).get(SWICHSHUTDOWN);

        if (!swichshutdown_state.equalsIgnoreCase("")) {
            this.setSwich(swichshutdown, swichshutdown_state);
        }


        seekBartempengineoil.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                progres=1;
                Log.e("WRITE_KEY_FRAGMENT", ""+progressFloat);
                ((MainNavActivity)getActivity()).write(SEEKBARTEMPENGINEOIL, ""+progressFloat);
            }

            @Override
            public void getProgressOnActionUp(int progress, float progressFloat) {
                try {
                    byte w2[] = {1, 13, 0, 0, 0, 0, 0, 4};
                    w2[3] = (byte) ((progres >> 24) & 0xFF);
                    w2[4] = (byte) ((progres >> 16) & 0xFF);
                    w2[5] = (byte) ((progres >> 8) & 0xFF);
                    w2[6] = (byte) (progres & 0xFF);

                    for (int i = 0; i < w2.length; i++) {
                        listener.onGeneral_SeekChange(w2[i]);
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
                progres=l;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                try {
                    byte w2[] = {1, 13, 0, 0, 0, 0, 0, 4};
                    w2[3] = (byte) ((progres >> 24) & 0xFF);
                    w2[4] = (byte) ((progres >> 16) & 0xFF);
                    w2[5] = (byte) ((progres >> 8) & 0xFF);
                    w2[6] = (byte) (progres & 0xFF);

                    for (int i = 0; i < w2.length; i++) {
                        listener.onGeneral_SeekChange(w2[i]);
                    }

                }catch (Exception e){}
            }
        });*/

        seekBartempfuel.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                progres=1;
                Log.e("WRITE_KEY_FRAGMENT", ""+progressFloat);
                ((MainNavActivity)getActivity()).write(SEEKBARTEMPFUEL, ""+progressFloat);
            }

            @Override
            public void getProgressOnActionUp(int progress, float progressFloat) {
                try {
                    byte w2[] = {1, 11, 0, 0, 0, 0, 0, 4};
                    w2[3] = (byte) ((progres >> 24) & 0xFF);
                    w2[4] = (byte) ((progres >> 16) & 0xFF);
                    w2[5] = (byte) ((progres >> 8) & 0xFF);
                    w2[6] = (byte) (progres & 0xFF);

                    for (int i = 0; i < w2.length; i++) {
                        listener.onGeneral_SeekChange(w2[i]);
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
                progres=l;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                try {
                    byte w2[] = {1, 11, 0, 0, 0, 0, 0, 4};
                    w2[3] = (byte) ((progres >> 24) & 0xFF);
                    w2[4] = (byte) ((progres >> 16) & 0xFF);
                    w2[5] = (byte) ((progres >> 8) & 0xFF);
                    w2[6] = (byte) (progres & 0xFF);

                    for (int i = 0; i < w2.length; i++) {
                        listener.onGeneral_SeekChange(w2[i]);
                    }

                }catch (Exception e){}
            }
        });*/

        seekBarcoolant.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                progres=1;
                Log.e("WRITE_KEY_FRAGMENT", ""+progressFloat);
                ((MainNavActivity)getActivity()).write(SEEKBARCOOLANT, ""+progressFloat);
            }

            @Override
            public void getProgressOnActionUp(int progress, float progressFloat) {
                try {
                    byte w2[] = {1, 31, 0, 0, 0, 0, 0, 4};
                    w2[3] = (byte) ((progres >> 24) & 0xFF);
                    w2[4] = (byte) ((progres >> 16) & 0xFF);
                    w2[5] = (byte) ((progres >> 8) & 0xFF);
                    w2[6] = (byte) (progres & 0xFF);

                    for (int i = 0; i < w2.length; i++) {
                        listener.onGeneral_SeekChange(w2[i]);
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
                progres=l;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //calibrado ENGINE COOLANT PRESSURE
                try {
                    byte w2[] = {1, 31, 0, 0, 0, 0, 0, 4};
                    w2[3] = (byte) ((progres >> 24) & 0xFF);
                    w2[4] = (byte) ((progres >> 16) & 0xFF);
                    w2[5] = (byte) ((progres >> 8) & 0xFF);
                    w2[6] = (byte) (progres & 0xFF);

                    for (int i = 0; i < w2.length; i++) {
                        listener.onGeneral_SeekChange(w2[i]);
                    }

                }catch (Exception e){}
            }
        });*/

        seekBarfuel_presu.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                progres=1;
                Log.e("WRITE_KEY_FRAGMENT", ""+progressFloat);
                ((MainNavActivity)getActivity()).write(SEEKBARFUEL_PRESU, ""+progressFloat);
            }

            @Override
            public void getProgressOnActionUp(int progress, float progressFloat) {
                try {
                    byte w2[] = {1, 18, 0, 0, 0, 0, 0, 4};
                    w2[3] = (byte) ((progres >> 24) & 0xFF);
                    w2[4] = (byte) ((progres >> 16) & 0xFF);
                    w2[5] = (byte) ((progres >> 8) & 0xFF);
                    w2[6] = (byte) (progres & 0xFF);

                    for (int i = 0; i < w2.length; i++) {
                        listener.onGeneral_SeekChange(w2[i]);
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
                progres =l;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                try {
                    byte w2[] = {1, 18, 0, 0, 0, 0, 0, 4};
                    w2[3] = (byte) ((progres >> 24) & 0xFF);
                    w2[4] = (byte) ((progres >> 16) & 0xFF);
                    w2[5] = (byte) ((progres >> 8) & 0xFF);
                    w2[6] = (byte) (progres & 0xFF);

                    for (int i = 0; i < w2.length; i++) {
                        listener.onGeneral_SeekChange(w2[i]);
                    }

                }catch (Exception e){}
            }
        });*/

        seekBarintake.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                progres=1;
                Log.e("WRITE_KEY_FRAGMENT", ""+progressFloat);
                ((MainNavActivity)getActivity()).write(SEEKBARINTAKE, ""+progressFloat);
            }

            @Override
            public void getProgressOnActionUp(int progress, float progressFloat) {
                try {
                    byte w1[] = {1, 23, 0, 0, 0, 0, 0, 4};
                    w1[3] = (byte) ((progres >> 24) & 0xFF);
                    w1[4] = (byte) ((progres >> 16) & 0xFF);
                    w1[5] = (byte) ((progres >> 8) & 0xFF);
                    w1[6] = (byte) (progres & 0xFF);

                    for (int i = 0; i < w1.length; i++) {
                        listener.onGeneral_SeekChange(w1[i]);
                    }

                }catch (Exception e){}
            }

            @Override
            public void getProgressOnFinally(int progress, float progressFloat) {

            }
        });

        /*seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                progres=i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                try {
                    byte w1[] = {1, 23, 0, 0, 0, 0, 0, 4};
                    w1[3] = (byte) ((progres >> 24) & 0xFF);
                    w1[4] = (byte) ((progres >> 16) & 0xFF);
                    w1[5] = (byte) ((progres >> 8) & 0xFF);
                    w1[6] = (byte) (progres & 0xFF);

                    for (int i = 0; i < w1.length; i++) {
                        listener.onGeneral_SeekChange(w1[i]);
                    }

                }catch (Exception e){}
            }

        });*/

        seekBareop.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                progres=1;
                Log.e("WRITE_KEY_FRAGMENT", ""+progressFloat);
                ((MainNavActivity)getActivity()).write(SEEKBAREOP, ""+progressFloat);
            }

            @Override
            public void getProgressOnActionUp(int progress, float progressFloat) {
                try {

                    byte w[] = {1, 20, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((progres >> 24) & 0xFF);
                    w[4] = (byte) ((progres >> 16) & 0xFF);
                    w[5] = (byte) ((progres >> 8) & 0xFF);
                    w[6] = (byte) (progres & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        listener.onGeneral_SeekChange(w[i]);
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

                byte w[] = {1, 20, 0, 0, 0, 0, 0, 4};
                w[3] = (byte) ((progres >> 24) & 0xFF);
                w[4] = (byte) ((progres >> 16) & 0xFF);
                w[5] = (byte) ((progres >> 8) & 0xFF);
                w[6] = (byte) (progres & 0xFF);

                for (int i = 0; i < w.length; i++) {
                    listener.onGeneral_SeekChange(w[i]);
                }
            }catch (Exception e){}
            }
        });*/

        swichshutdown.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                try {
                    if (swichshutdown.isChecked()) {
                        byte w[] = {1, 7, 0, 0, 0, 0, 0, 4};
                        w[6] = 1;
                        for (int i = 0; i < w.length; i++) {
                            listener.onGeneral_SeekChange(w[i]);
                        }
                        ((MainNavActivity)getActivity()).write(SWICHSHUTDOWN, "true");

                    } else {
                        byte w[] = {1, 7, 0, 0, 0, 0, 0, 4};
                        for (int i = 0; i < w.length; i++) {
                            listener.onGeneral_SeekChange(w[i]);
                        }
                        ((MainNavActivity)getActivity()).write(SWICHSHUTDOWN, "false");
                    }
                }catch (Exception e){}
            }
        });

        swichcoolantLevel.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                try {
                    if (swichcoolantLevel.isChecked()) {
                        byte w[] = {1, 3, 0, 0, 0, 0, 0, 4};
                        w[6] = 1;
                        for (int i = 0; i < w.length; i++) {
                            listener.onGeneral_SeekChange(w[i]);
                        }
                        ((MainNavActivity)getActivity()).write(SWICHCOOLANTLEVEL, "true");

                    } else {
                        byte w[] = {1, 3, 0, 0, 0, 0, 0, 4};
                        for (int i = 0; i < w.length; i++) {
                            listener.onGeneral_SeekChange(w[i]);
                        }
                        ((MainNavActivity)getActivity()).write(SWICHCOOLANTLEVEL, "false");
                    }
                }catch (Exception e){}
            }
        });

        //getActivity().startService(new Intent(getActivity(),MainActivity.class));
        //getActivity().startService(new Intent(getActivity(),DispositivosBT.class));
        // Inflate the layout for this fragment
        return vi;
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
        listener = (General_Listener) getActivity();
    }



    public static interface General_Listener {
        public void onGeneral_SeekChange(byte b);
    }

    public void setSwich(Switch s, String STATUS) {
        switch (STATUS) {
            case TRUE:
                s.setChecked(true);
                break;
            case FALSE:
                s.setChecked(false);
                break;
        }
    }


}
