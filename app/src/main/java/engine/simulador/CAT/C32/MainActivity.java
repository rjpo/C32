package engine.simulador.CAT.C32;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Handler bluetoothIn;
    final int handlerState = 0;
    private BluetoothAdapter btAdapter = null;
    private BluetoothSocket btSocket = null;
    private StringBuilder DataStringIN = new StringBuilder();
    public ConnectedThread MyConexionBT;
    // Identificador unico de servicio - SPP UUID
    private static final UUID BTMODULEUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    // String para la direccion MAC
    private static String address = null;
    //-------------------------------------------

    //private BluetoothDevice device;

    public static String EXTRA_DEVICE_ADDRESS = "device_address";

    Button boton1, boton2, boton3, boton4, boton5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        boton1 = (Button) findViewById(R.id.boton11);
        boton2 = (Button) findViewById(R.id.boton22);
        boton3 = (Button) findViewById(R.id.boton33);
        boton4 = (Button) findViewById(R.id.boton44);
        boton5 = (Button) findViewById(R.id.boton55);
        boton1.setOnClickListener(this);
        boton2.setOnClickListener(this);
        boton3.setOnClickListener(this);
        boton4.setOnClickListener(this);
        boton5.setOnClickListener(this);



        btAdapter = BluetoothAdapter.getDefaultAdapter(); // get Bluetooth adapter
        VerificarEstadoBT();
    }




    @Override
    public void onClick(View view) {
        try {
            switch (view.getId()) {
                case R.id.boton11:
                    MainNavActivity.option=1;
                    Intent i1 = new Intent(this, MainNavActivity.class);
                    i1.putExtra(EXTRA_DEVICE_ADDRESS, address);
                    startActivity(i1);
                    //General fragment1 = new General();
                    //FragmentManager fragmentManager = getSupportFragmentManager();
                    //FragmentTransaction FragmentTransaction = fragmentManager.beginTransaction();
                    //FragmentTransaction.add(R.id.activity2, fragment1, null);
                    return;

                case R.id.boton22:
                    MainNavActivity.option=2;
                    Intent in = new Intent(this, MainNavActivity.class);
                    in.putExtra(EXTRA_DEVICE_ADDRESS, address);
                    startActivity(in);
                    return;
                case R.id.boton33:
                    MainNavActivity.option=3;
                    Intent i =new Intent(this, MainNavActivity.class);
                    i.putExtra(EXTRA_DEVICE_ADDRESS, address);
                    startActivity(i);
                    return;
                case R.id.boton44:
                    MainNavActivity.option=4;
                    Intent i2 = new Intent(this, MainNavActivity.class);
                    i2.putExtra(EXTRA_DEVICE_ADDRESS, address);
                    startActivity(i2);
                    return;
                case R.id.boton55:
                    MainNavActivity.option=5;
                    Intent i3 = new Intent(this, MainNavActivity.class);
                    i3.putExtra(EXTRA_DEVICE_ADDRESS, address);
                    startActivity(i3);
                    return;


            }
        } catch (Exception e) {
            System.out.print("Verifique valores ingresados");
        }

    }

    public BluetoothSocket createBluetoothSocket(BluetoothDevice device) throws IOException
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
        MyConexionBT = new ConnectedThread(btSocket);
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
    private void VerificarEstadoBT() {

        if(btAdapter==null) {
            Toast.makeText(getBaseContext(), "El dispositivo no soporta bluetooth", Toast.LENGTH_LONG).show();
        } else {
            if (btAdapter.isEnabled()) {
            } else {
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, 1);
            }
        }
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

    /*public class MyApplication extends Application{
        BluetoothDevice device;

        public synchronized BluetoothDevice getBtConnection(){
            if (device==null){}
            return device;
        }



    }
*/

}
