package engine.simulador.CAT.C32;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;

import static engine.simulador.CAT.C32.ClearStorage.FALSE;
import static engine.simulador.CAT.C32.ClearStorage.SWICHCOOLANTLEVEL;
import static engine.simulador.CAT.C32.ClearStorage.SWICHESTOP;
import static engine.simulador.CAT.C32.ClearStorage.SWICHFUELPP;
import static engine.simulador.CAT.C32.ClearStorage.SWICHFUELWSLEVEL;
import static engine.simulador.CAT.C32.ClearStorage.SWICHOILFILTER;
import static engine.simulador.CAT.C32.ClearStorage.SWICHSHUTDOWN;
import static engine.simulador.CAT.C32.ClearStorage.SWICHTHROTBACK;
import static engine.simulador.CAT.C32.ClearStorage.TRUE;


public class Swich extends Fragment {

    Swich_listener listener;

    Switch swichoilFilter, swichcoolantLevel, swichfuelwslevel, swichfuelpp, swichthrotback, swichestop, swichshutdown;

    int on;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_swich, container, false);
        // Inflate the layout for this fragment
        swichoilFilter = (Switch)rootView.findViewById(R.id.oilFilter);
        swichcoolantLevel = (Switch)rootView.findViewById(R.id.coolantLevel);
        swichfuelwslevel = (Switch)rootView.findViewById(R.id.fuelWSlevell);
        swichfuelpp = (Switch)rootView.findViewById(R.id.fuelPPSwitch);
        swichthrotback = (Switch)rootView.findViewById(R.id.throtBack);
        swichestop = (Switch)rootView.findViewById(R.id.estop);
        swichshutdown = (Switch)rootView.findViewById(R.id.shutdownSwitch);

        String swichoilfilter_state = ((MainNavActivity)getActivity()).get(SWICHOILFILTER);

        if (!swichoilfilter_state.equalsIgnoreCase("")) {
            this.setSwich(swichoilFilter, swichoilfilter_state);
        }

        String swichcoolantLevel_state = ((MainNavActivity)getActivity()).get(SWICHCOOLANTLEVEL);

        if (!swichcoolantLevel_state.equalsIgnoreCase("")) {
            this.setSwich(swichcoolantLevel, swichcoolantLevel_state);
        }

        String swichshutdown_state = ((MainNavActivity)getActivity()).get(SWICHSHUTDOWN);

        if (!swichshutdown_state.equalsIgnoreCase("")) {
            this.setSwich(swichshutdown, swichshutdown_state);
        }

        String swichestop_state = ((MainNavActivity)getActivity()).get(SWICHESTOP);

        if (!swichestop_state.equalsIgnoreCase("")) {
            this.setSwich(swichestop, swichestop_state);
        }

        String swichthrotBack_state = ((MainNavActivity)getActivity()).get(SWICHTHROTBACK);

        if (!swichthrotBack_state.equalsIgnoreCase("")) {
            this.setSwich(swichthrotback, swichthrotBack_state);
        }

        String swichfuelwslevel_state = ((MainNavActivity)getActivity()).get(SWICHFUELWSLEVEL);

        if (!swichfuelwslevel_state.equalsIgnoreCase("")) {
            this.setSwich(swichfuelwslevel, swichfuelwslevel_state);
        }

        String swichfuelpp_state = ((MainNavActivity)getActivity()).get(SWICHFUELPP);

        if (!swichfuelpp_state.equalsIgnoreCase("")) {
            this.setSwich(swichfuelpp, swichfuelpp_state);
        }


        swichoilFilter.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                try {

                    if (swichoilFilter.isChecked()) {
                        byte w[] = {1, 1, 0, 0, 0, 0, 0, 4};
                        w[6] = 1;
                        for (int i = 0; i < w.length; i++) {
                            listener.onSwich_SwichChange(w[i]);
                        }
                        ((MainNavActivity)getActivity()).write(SWICHOILFILTER, "true");

                    } else {
                        byte w[] = {1, 1, 0, 0, 0, 0, 0, 4};
                        for (int i = 0; i < w.length; i++) {
                            listener.onSwich_SwichChange(w[i]);
                        }
                        ((MainNavActivity)getActivity()).write(SWICHOILFILTER, "false");
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
                            listener.onSwich_SwichChange(w[i]);
                        }
                        ((MainNavActivity)getActivity()).write(SWICHCOOLANTLEVEL, "true");

                    } else {
                        byte w[] = {1, 3, 0, 0, 0, 0, 0, 4};
                        for (int i = 0; i < w.length; i++) {
                            listener.onSwich_SwichChange(w[i]);
                        }
                        ((MainNavActivity)getActivity()).write(SWICHCOOLANTLEVEL, "false");
                    }
                }catch (Exception e){}
            }
        });

        swichfuelwslevel.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                try {
                    if (swichfuelwslevel.isChecked()) {
                        byte w[] = {1, 2, 0, 0, 0, 0, 0, 4};
                        w[6] = 1;
                        for (int i = 0; i < w.length; i++) {
                            listener.onSwich_SwichChange(w[i]);
                        }
                        ((MainNavActivity)getActivity()).write(SWICHFUELWSLEVEL, "true");

                    } else {
                        byte w[] = {1, 2, 0, 0, 0, 0, 0, 4};
                        for (int i = 0; i < w.length; i++) {
                            listener.onSwich_SwichChange(w[i]);
                        }
                        ((MainNavActivity)getActivity()).write(SWICHFUELWSLEVEL, "false");
                    }
                }catch (Exception e){}
            }
        });

        swichfuelpp.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                try {
                    if (swichfuelpp.isChecked()) {
                        byte w[] = {1, 4, 0, 0, 0, 0, 0, 4};
                        w[6] = 1;
                        for (int i = 0; i < w.length; i++) {
                            listener.onSwich_SwichChange(w[i]);
                        }
                        ((MainNavActivity)getActivity()).write(SWICHFUELPP, "true");

                    } else {
                        byte w[] = {1, 4, 0, 0, 0, 0, 0, 4};
                        for (int i = 0; i < w.length; i++) {
                            listener.onSwich_SwichChange(w[i]);
                        }
                        ((MainNavActivity)getActivity()).write(SWICHFUELPP, "false");
                    }
                }catch (Exception e){}
            }
        });

        swichthrotback.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                try {
                    if (swichthrotback.isChecked()) {
                        byte w[] = {1, 5, 0, 0, 0, 0, 0, 4};
                        w[6] = 1;
                        for (int i = 0; i < w.length; i++) {
                            listener.onSwich_SwichChange(w[i]);
                        }
                        ((MainNavActivity)getActivity()).write(SWICHTHROTBACK, "true");

                    } else {
                        byte w[] = {1, 5, 0, 0, 0, 0, 0, 4};
                        for (int i = 0; i < w.length; i++) {
                            listener.onSwich_SwichChange(w[i]);
                        }
                        ((MainNavActivity)getActivity()).write(SWICHTHROTBACK, "false");
                    }
                }catch (Exception e){}
            }
        });

        swichestop.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                try {
                    if (swichestop.isChecked()) {
                        byte w[] = {1, 6, 0, 0, 0, 0, 0, 4};
                        w[6] = 1;
                        for (int i = 0; i < w.length; i++) {
                            listener.onSwich_SwichChange(w[i]);
                        }
                        ((MainNavActivity)getActivity()).write(SWICHESTOP, "true");

                    } else {
                        byte w[] = {1, 6, 0, 0, 0, 0, 0, 4};
                        for (int i = 0; i < w.length; i++) {
                            listener.onSwich_SwichChange(w[i]);
                        }
                        ((MainNavActivity)getActivity()).write(SWICHESTOP, "false");
                    }
                }catch (Exception e){}
            }
        });

        swichshutdown.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                try {
                    if (swichshutdown.isChecked()) {
                        byte w[] = {1, 7, 0, 0, 0, 0, 0, 4};
                        w[6] = 1;
                        for (int i = 0; i < w.length; i++) {
                            listener.onSwich_SwichChange(w[i]);
                        }
                        ((MainNavActivity)getActivity()).write(SWICHSHUTDOWN, "true");

                    } else {
                        byte w[] = {1, 7, 0, 0, 0, 0, 0, 4};
                        for (int i = 0; i < w.length; i++) {
                            listener.onSwich_SwichChange(w[i]);
                        }
                        ((MainNavActivity)getActivity()).write(SWICHSHUTDOWN, "false");
                    }
                }catch (Exception e){}
            }
        });



        return rootView;
    }

   /* public void sw(View view){
        if (view.getId()==R.id.oilFilter) {
            if (swich1.isChecked()) {
                byte w[] = {1, 1, 0, 0, 0, 0, 0, 4};
                w[6] = 1;
                for (int i = 0; i < w.length; i++) {
                    listener.onSwich_SwichChange(w[i]);
                }

            } else {
                byte w[] = {1, 1, 0, 0, 0, 0, 0, 4};
                for (int i = 0; i < w.length; i++) {
                    listener.onSwich_SwichChange(w[i]);
                }
            }
        }
    }*/

    public int aMethodMainActivityCanCAll(String withSomeParameter){
        int aResultToMainActivity = 0;
        //MainActivity can call methods on the fragment to communicate things like
        //requesting some status, or pass throguh requests from other fragment.
        return aResultToMainActivity;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listener = (Swich_listener) getActivity();
    }


    public interface Swich_listener {
        public void onSwich_SwichChange(byte b);
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
