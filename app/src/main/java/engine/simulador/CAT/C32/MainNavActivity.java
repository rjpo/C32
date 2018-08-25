package engine.simulador.CAT.C32;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Handler;
import java.util.UUID;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;

import com.xw.repo.BubbleSeekBar;


public class MainNavActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener,
        SeekBar.OnSeekBarChangeListener,
        General.General_Listener,
        Engine.Engine_Listener,
        Pressure.Pressure_listener,
        Tempetarures.Temperatures_listener,
        Swich.Swich_listener,
        BubbleSeekBar.OnProgressChangedListener {



    Handler bluetoothIn;
    final int handlerState = 0;
    private BluetoothAdapter btAdapter = null;
    private BluetoothSocket btSocket = null;
    private StringBuilder DataStringIN = new StringBuilder();
    private MainNavActivity.ConnectedThread MyConexionBT;
    // Identificador unico de servicio - SPP UUID
    private static final UUID BTMODULEUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    // String para la direccion MAC
    private static String address = null;
    //-------------------------------------------


    CheckBox cbox;
    Switch swith, keySw;
    int progres, progres2, progres3;
    BubbleSeekBar seekBar, seek;
    double mpro;
    int round;

    public static int option;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_nav);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        seekBar = (BubbleSeekBar) findViewById(R.id.engine);
        //seekBar.setOnSeekBarChangeListener(this);
        seekBar.setOnProgressChangedListener(this);

        seek = (BubbleSeekBar) findViewById(R.id.throttle);
        //seek.setOnSeekBarChangeListener(this);

        swith=(Switch)findViewById(R.id.switch1);


        cbox = (CheckBox)findViewById(R.id.checkBox);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();




        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        FragmentManager fm =getSupportFragmentManager();

        switch (option){
            case 1: fm.beginTransaction().add(R.id.contenido,new General()).commit();break;
            case 2: fm.beginTransaction().add(R.id.contenido,new Pressure()).commit();break;
            case 3: fm.beginTransaction().add(R.id.contenido,new Engine()).commit();break;
            case 4: fm.beginTransaction().add(R.id.contenido,new Tempetarures()).commit();break;
            case 5: fm.beginTransaction().add(R.id.contenido,new Swich()).commit();break;
            default: fm.beginTransaction().add(R.id.contenido,new General()).commit();break;


        }


        btAdapter = BluetoothAdapter.getDefaultAdapter(); // get Bluetooth adapter
        VerificarEstadoBT();

    }


    public void onClick1(View v){
        if (v.getId()==R.id.checkBox){
           /* if (cbox.isChecked()){
                byte w[]={1, 8, 0, 0, 0, 0, 0, 4};
                w[6]=1;
                for (int i=0;i<w.length;i++) {
                    MyConexionBT.write(w[i]);
                }*/

        }
    }

    public void onClick(View view) {
        try {
            if (view.getId() == R.id.switch1) {
                if (swith.isChecked()) {
                    //keySw.setChecked(true);
                    byte w[] = {1, 8, 0, 0, 0, 0, 0, 4};
                    w[6] = 1;
                    for (int i = 0; i < w.length; i++) {
                        MyConexionBT.write(w[i]);
                    }

                } else {
                    //keySw.setChecked(false);
                    byte w[] = {1, 8, 0, 0, 0, 0, 0, 4};
                    for (int i = 0; i < w.length; i++) {
                        MyConexionBT.write(w[i]);
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void onBackPressed() {
       // DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //if (drawer.isDrawerOpen(GravityCompat.START)) {
          //  drawer.closeDrawer(GravityCompat.START);
        //} else {
          //  super.onBackPressed();
        //}
        //si no queda ningún fragment sale de este activity
        if (getFragmentManager().getBackStackEntryCount() == 0) {
            // super.onBackPressed();
            finish();

        } else { //si no manda al fragment anterior.
            getFragmentManager().popBackStack();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_nav, menu);
        return true;
    }








    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fm = getSupportFragmentManager();

        if (id == R.id.nav_camera) {
            fm.beginTransaction().add(R.id.contenido,new General()).commit();
        } else if (id == R.id.nav_gallery) {
            fm.beginTransaction().add(R.id.contenido,new Pressure()).commit();
        } else if (id == R.id.nav_slideshow) {
            fm.beginTransaction().add(R.id.contenido,new Engine()).commit();
        } else if (id == R.id.nav_manage) {
            fm.beginTransaction().add(R.id.contenido,new Tempetarures()).commit();
        } else if (id == R.id.nav_switches){
            fm.beginTransaction().add(R.id.contenido,new Swich()).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private BluetoothSocket createBluetoothSocket(BluetoothDevice device) throws IOException
    {
        //crea un conexion de salida segura para el dispositivo
        //usando el servicio UUID
        return device.createRfcommSocketToServiceRecord(BTMODULEUUID);
    }

    @Override
    public void onResume()
    {
        super.onResume();
        //Consigue la direccion MAC desde DeviceListActivity via intent
        Intent intent = getIntent();
        //Consigue la direccion MAC desde DeviceListActivity via EXTRA
        address = intent.getStringExtra(DispositivosBT.EXTRA_DEVICE_ADDRESS);//<-<- PARTE A MODIFICAR >->->
        //Setea la direccion MAC
        BluetoothDevice device = btAdapter.getRemoteDevice(address);

        try
        {
            btSocket = createBluetoothSocket(device);
        } catch (IOException e) {
            Toast.makeText(getBaseContext(), "La creacción del Socket fallo", Toast.LENGTH_LONG).show();
        }
        // Establece la conexión con el socket Bluetooth.
        try
        {
            btSocket.connect();
        } catch (IOException e) {
            try {
                btSocket.close();
            } catch (IOException e2) {}
        }
        MyConexionBT = new MainNavActivity.ConnectedThread(btSocket);
        MyConexionBT.start();
    }

    @Override
    public void onPause()
    {
        super.onPause();
        try
        { // Cuando se sale de la aplicación esta parte permite
            // que no se deje abierto el socket
            btSocket.close();
        } catch (IOException e2) {}
    }

    //Comprueba que el dispositivo Bluetooth Bluetooth está disponible y solicita que se active si está desactivado
    public void VerificarEstadoBT() {

        if(btAdapter==null) {
            Toast.makeText(getBaseContext(), "El dispositivo no soporta bluetooth", Toast.LENGTH_LONG).show();
        } else {
            if (btAdapter.isEnabled()) {
            } else {
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                //startActivityForResult(enableBtIntent, 1);
            }
        }
    }



    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
        progres = i + 1050;
        progres3 = i;
        progres2 = progres/2;
        mpro = Math.floor(progres2);
        round = (int)mpro;

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

        switch (seekBar.getId()) {
            case R.id.engine:
                try {

                    byte w[] = {1, 49, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((progres >> 24) & 0xFF);
                    w[4] = (byte) ((progres >> 16) & 0xFF);
                    w[5] = (byte) ((progres >> 8) & 0xFF);
                    w[6] = (byte) (progres & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        MyConexionBT.write(w[i]);
                    }

                    byte ww[] = {1, 50, 0, 0, 0, 0, 0, 4};
                    ww[3] = (byte) ((round >> 24) & 0xFF);
                    ww[4] = (byte) ((round >> 16) & 0xFF);
                    ww[5] = (byte) ((round >> 8) & 0xFF);
                    ww[6] = (byte) (round & 0xFF);

                    for (int i = 0; i < ww.length; i++) {
                        MyConexionBT.write(ww[i]);
                    }

                    byte www[] = {1, 51, 0, 0, 0, 0, 0, 4};
                    www[3] = (byte) ((round >> 24) & 0xFF);
                    www[4] = (byte) ((round >> 16) & 0xFF);
                    www[5] = (byte) ((round >> 8) & 0xFF);
                    www[6] = (byte) (round & 0xFF);

                    for (int i = 0; i < www.length; i++) {
                        MyConexionBT.write(www[i]);
                    }
                }catch (Exception e){}

        return;
            case R.id.throttle:
                try {
                    byte w1[] = {1, 46, 0, 0, 0, 0, 0, 4};
                    w1[3] = (byte) ((progres3 >> 24) & 0xFF);
                    w1[4] = (byte) ((progres3 >> 16) & 0xFF);
                    w1[5] = (byte) ((progres3 >> 8) & 0xFF);
                    w1[6] = (byte) (progres3 & 0xFF);

                    for (int i = 0; i < w1.length; i++) {
                        MyConexionBT.write(w1[i]);
                    }
                }catch (Exception e){}
         return;
    }
    }
////////////AQUI_GENERAL///////////////
    @Override
    public void onGeneral_SeekChange(byte b) { try {
        MyConexionBT.write(b);}catch (Exception e){}
    }

    //////////////////AQUI_ENGINE/////////////////////////////////////
    @Override
    public void onEngineSeekbarChange(byte b) {
        try {
        MyConexionBT.write(b);}catch (Exception e){}
        }

    @Override
    public void onPresure_SeekChange(byte b) {
        try {
            MyConexionBT.write(b);
        }catch (Exception e){}
    }

    @Override
    public void onTemperatures_SeekChanger(byte b) {
        try {
            MyConexionBT.write(b);
        }catch (Exception e){}
        }

    @Override
    public void onSwich_SwichChange(byte b) {
        try {
            MyConexionBT.write(b);
        }catch (Exception e){}
    }


    //aqui ta
    @Override
    public void onProgressChanged(int progress, float progressFloat) {
        progres = progress + 1050;
        progres3 = progress;
        progres2 = progres/2;
        mpro = Math.floor(progres2);
        round = (int)mpro;
    }

    @Override
    public void getProgressOnActionUp(int progress, float progressFloat) {
        switch (seekBar.getId()) {
            case R.id.engine:
                try {

                    byte w[] = {1, 49, 0, 0, 0, 0, 0, 4};
                    w[3] = (byte) ((progres >> 24) & 0xFF);
                    w[4] = (byte) ((progres >> 16) & 0xFF);
                    w[5] = (byte) ((progres >> 8) & 0xFF);
                    w[6] = (byte) (progres & 0xFF);

                    for (int i = 0; i < w.length; i++) {
                        MyConexionBT.write(w[i]);
                    }

                    byte ww[] = {1, 50, 0, 0, 0, 0, 0, 4};
                    ww[3] = (byte) ((round >> 24) & 0xFF);
                    ww[4] = (byte) ((round >> 16) & 0xFF);
                    ww[5] = (byte) ((round >> 8) & 0xFF);
                    ww[6] = (byte) (round & 0xFF);

                    for (int i = 0; i < ww.length; i++) {
                        MyConexionBT.write(ww[i]);
                    }

                    byte www[] = {1, 51, 0, 0, 0, 0, 0, 4};
                    www[3] = (byte) ((round >> 24) & 0xFF);
                    www[4] = (byte) ((round >> 16) & 0xFF);
                    www[5] = (byte) ((round >> 8) & 0xFF);
                    www[6] = (byte) (round & 0xFF);

                    for (int i = 0; i < www.length; i++) {
                        MyConexionBT.write(www[i]);
                    }
                }catch (Exception e){}

                return;
            case R.id.throttle:
                try {
                    byte w1[] = {1, 46, 0, 0, 0, 0, 0, 4};
                    w1[3] = (byte) ((progres3 >> 24) & 0xFF);
                    w1[4] = (byte) ((progres3 >> 16) & 0xFF);
                    w1[5] = (byte) ((progres3 >> 8) & 0xFF);
                    w1[6] = (byte) (progres3 & 0xFF);

                    for (int i = 0; i < w1.length; i++) {
                        MyConexionBT.write(w1[i]);
                    }
                }catch (Exception e){}
                return;
        }
    }

    @Override
    public void getProgressOnFinally(int progress, float progressFloat) {

    }


    //Crea la clase que permite crear el evento de conexion
    public class ConnectedThread extends Thread
    {
        private final InputStream mmInStream;
        private final OutputStream mmOutStream;

        public ConnectedThread(BluetoothSocket socket)
        {
            InputStream tmpIn = null;
            OutputStream tmpOut = null;
            try
            {
                tmpIn = socket.getInputStream();
                tmpOut = socket.getOutputStream();
            } catch (IOException e) { }
            mmInStream = tmpIn;
            mmOutStream = tmpOut;
        }

        public void run()
        {
            byte[] buffer = new byte[256];
            int bytes;

            // Se mantiene en modo escucha para determinar el ingreso de datos
            while (true) {
                try {
                    bytes = mmInStream.read(buffer);
                    String readMessage = new String(buffer, 0, bytes);
                    // Envia los datos obtenidos hacia el evento via handler
                    bluetoothIn.obtainMessage(handlerState, bytes, -1, readMessage).sendToTarget();
                } catch (IOException e) {
                    break;
                }
            }
        }
        //Envio de trama
        public void write(Byte input)
        {
            try {
                mmOutStream.write(input.byteValue());
            }
            catch (IOException e)
            {
                //si no es posible enviar datos se cierra la conexión
                Toast.makeText(getBaseContext(), "La Conexión fallo", Toast.LENGTH_LONG).show();
                finish();
            }
        }
    }
    public void write(String key, String value) {
        Log.e("WRITE_KEY", key+" "+value);
        SharedPreferences global = getSharedPreferences("stores", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = global.edit();
        editor.putString(key, value).apply();
    }

    public String get(String key) {
        Log.e("RUN_KEY", key);
        SharedPreferences global = getSharedPreferences("stores", Context.MODE_PRIVATE);
        Log.e("VALUE_KEY",  global.getString(key, ""));
        return global.getString(key, "");
    }


}
