package motor.simulador.luisf.c175_2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;


public class Swich extends Fragment {

    Swich_listener listener;

    Switch swich, swich1, swich2, swich3, swich4, swich5, swich6, swich7;

    int on;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_swich, container, false);
        // Inflate the layout for this fragment
        swich = (Switch)rootView.findViewById(R.id.oilFilter);
        swich1 = (Switch)rootView.findViewById(R.id.coolantLevel);
        swich2 = (Switch)rootView.findViewById(R.id.fuelWSlevell);
        swich3 = (Switch)rootView.findViewById(R.id.fuelPPSwitch);
        swich4 = (Switch)rootView.findViewById(R.id.throtBack);
        swich5 = (Switch)rootView.findViewById(R.id.estop);
        swich6 = (Switch)rootView.findViewById(R.id.shutdownSwitch);
        swich7 = (Switch)rootView.findViewById(R.id.keySwi);

        swich.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                try {

                    if (swich.isChecked()) {
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
                }catch (Exception e){}
            }
        });

        swich1.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                try {
                    if (swich1.isChecked()) {
                        byte w[] = {1, 3, 0, 0, 0, 0, 0, 4};
                        w[6] = 1;
                        for (int i = 0; i < w.length; i++) {
                            listener.onSwich_SwichChange(w[i]);
                        }

                    } else {
                        byte w[] = {1, 3, 0, 0, 0, 0, 0, 4};
                        for (int i = 0; i < w.length; i++) {
                            listener.onSwich_SwichChange(w[i]);
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
                        byte w[] = {1, 2, 0, 0, 0, 0, 0, 4};
                        w[6] = 1;
                        for (int i = 0; i < w.length; i++) {
                            listener.onSwich_SwichChange(w[i]);
                        }

                    } else {
                        byte w[] = {1, 2, 0, 0, 0, 0, 0, 4};
                        for (int i = 0; i < w.length; i++) {
                            listener.onSwich_SwichChange(w[i]);
                        }
                    }
                }catch (Exception e){}
            }
        });

        swich3.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                try {
                    if (swich3.isChecked()) {
                        byte w[] = {1, 4, 0, 0, 0, 0, 0, 4};
                        w[6] = 1;
                        for (int i = 0; i < w.length; i++) {
                            listener.onSwich_SwichChange(w[i]);
                        }

                    } else {
                        byte w[] = {1, 4, 0, 0, 0, 0, 0, 4};
                        for (int i = 0; i < w.length; i++) {
                            listener.onSwich_SwichChange(w[i]);
                        }
                    }
                }catch (Exception e){}
            }
        });

        swich4.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                try {
                    if (swich4.isChecked()) {
                        byte w[] = {1, 5, 0, 0, 0, 0, 0, 4};
                        w[6] = 1;
                        for (int i = 0; i < w.length; i++) {
                            listener.onSwich_SwichChange(w[i]);
                        }

                    } else {
                        byte w[] = {1, 5, 0, 0, 0, 0, 0, 4};
                        for (int i = 0; i < w.length; i++) {
                            listener.onSwich_SwichChange(w[i]);
                        }
                    }
                }catch (Exception e){}
            }
        });

        swich5.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                try {
                    if (swich5.isChecked()) {
                        byte w[] = {1, 6, 0, 0, 0, 0, 0, 4};
                        w[6] = 1;
                        for (int i = 0; i < w.length; i++) {
                            listener.onSwich_SwichChange(w[i]);
                        }

                    } else {
                        byte w[] = {1, 6, 0, 0, 0, 0, 0, 4};
                        for (int i = 0; i < w.length; i++) {
                            listener.onSwich_SwichChange(w[i]);
                        }
                    }
                }catch (Exception e){}
            }
        });

        swich6.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                try {
                    if (swich6.isChecked()) {
                        byte w[] = {1, 7, 0, 0, 0, 0, 0, 4};
                        w[6] = 1;
                        for (int i = 0; i < w.length; i++) {
                            listener.onSwich_SwichChange(w[i]);
                        }

                    } else {
                        byte w[] = {1, 7, 0, 0, 0, 0, 0, 4};
                        for (int i = 0; i < w.length; i++) {
                            listener.onSwich_SwichChange(w[i]);
                        }
                    }
                }catch (Exception e){}
            }
        });

        swich7.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                try {
                    if (swich7.isChecked()) {
                        byte w[] = {1, 8, 0, 0, 0, 0, 0, 4};
                        w[6] = 1;
                        for (int i = 0; i < w.length; i++) {
                            listener.onSwich_SwichChange(w[i]);
                        }

                    } else {
                        byte w[] = {1, 8, 0, 0, 0, 0, 0, 4};
                        for (int i = 0; i < w.length; i++) {
                            listener.onSwich_SwichChange(w[i]);
                        }
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
}
