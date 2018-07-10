package motor.simulador.luisf.c175_2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Handler;

import java.util.EmptyStackException;
import java.util.UUID;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;
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
    BubbleSeekBar seekBarr, seekBar1, seekBar2,seekBar3,seekBar4,seekBar5;
    Switch swich1, swich2;


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

        seekBarr = (BubbleSeekBar)vi.findViewById(R.id.eop);
        seekBar1 = (BubbleSeekBar) vi.findViewById(R.id.intake);
        seekBar2 = (BubbleSeekBar)vi.findViewById(R.id.gfuel_pre);
        seekBar3 = (BubbleSeekBar)vi.findViewById(R.id.ecp);
        seekBar4 = (BubbleSeekBar)vi.findViewById(R.id.gfurl_trmp);
        seekBar5 = (BubbleSeekBar)vi.findViewById(R.id.enoiltemp);
        swich1 = (Switch)vi.findViewById(R.id.switch1);
        swich2 = (Switch)vi.findViewById(R.id.switch2);


        seekBar5.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                progres=1;
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

        seekBar4.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                progres=1;
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

        seekBar3.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                progres=1;
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

        seekBar2.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                progres=1;
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

        seekBar1.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                progres=1;
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

        seekBarr.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                progres=1;
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

        swich1.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                try {
                    if (swich1.isChecked()) {
                        byte w[] = {1, 7, 0, 0, 0, 0, 0, 4};
                        w[6] = 1;
                        for (int i = 0; i < w.length; i++) {
                            listener.onGeneral_SeekChange(w[i]);
                        }

                    } else {
                        byte w[] = {1, 7, 0, 0, 0, 0, 0, 4};
                        for (int i = 0; i < w.length; i++) {
                            listener.onGeneral_SeekChange(w[i]);
                        }
                    }
                }catch (Exception e){}
            }
        });

        swich2.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                try {
                    if (swich2.isChecked()) {
                        byte w[] = {1, 3, 0, 0, 0, 0, 0, 4};
                        w[6] = 1;
                        for (int i = 0; i < w.length; i++) {
                            listener.onGeneral_SeekChange(w[i]);
                        }

                    } else {
                        byte w[] = {1, 3, 0, 0, 0, 0, 0, 4};
                        for (int i = 0; i < w.length; i++) {
                            listener.onGeneral_SeekChange(w[i]);
                        }
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


}
