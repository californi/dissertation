package edu.hkust.cse.phoneAdapter.test;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.location.Location;
import android.location.LocationManager;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ServiceTestRule;
import android.widget.SimpleAdapter;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeoutException;

import edu.hkust.cse.phoneAdapter.context.AdaptationManager;
import edu.hkust.cse.phoneAdapter.context.ContextManager;
import edu.hkust.cse.phoneAdapter.context.ContextName;
import edu.hkust.cse.phoneAdapter.context.SaidaDoCasoDeTeste;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Bento Siqueira on 22/12/2015.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExecucaoAbordagemTeste {

    @Rule
    public ServiceTestRule mServiceRule = new ServiceTestRule();
    private Context contexto = InstrumentationRegistry.getTargetContext();
    Intent serviceIntentAM = new Intent(contexto, AdaptationManager.class);
    static AdaptationManager serviceAM;

    Intent serviceIntentCM = new Intent(contexto, ContextManager.class);
    static ContextManager serviceCM;

    boolean mBound = false;

    static String bt_casa = "1C:39:47:0D:4A:BC";
    static String bt_escritorio = "DC:53:60:4F:02:AA";
    static String bt_carro = "00:FF:CD:6A:12:6B";
    static String bt_NaoCasaNemEscritorio = "00:00:00:00:00:00";
    static String Casa = "-20.999935,-48.210638";
    static String Escritorio = "-21.979769,-47.880300";
    static String NaoCasaNemEscritorio = "0.0,0.0";

    private ServiceConnection mConnectionAM = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className, IBinder ibinder) {
            AdaptationManager.AdaptationManagerBinder binder = (AdaptationManager.AdaptationManagerBinder) ibinder;
            serviceAM = binder.getService();
            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            mBound = false;
        }
    };


    @Before
    public void setUp() {

    }

    @After
    public void tearDown(){
        serviceAM.SaidaDoCasoDeTeste = null;
        this.mBound = false; // Novo
        this.mServiceRule = null;
    }

    @Test
    public void test01_T(){
        assertTrue(testCase1());  //OK
    }

    @Test
    public void test02_T(){
        assertTrue(testCase2());  //OK
    }

    @Test
    public void test03_T(){
        assertTrue(testCase3());  //OK
    }

    @Test
    public void test04_T(){
        assertTrue(testCase4());  //OK
    }

    @Test
    public void test05_T(){
        assertTrue(testCase5());  //OK
    }

    @Test
    public void test06_T(){
        assertTrue(testCase6());  //OK
    }

    @Test
    public void test07_T(){
        assertTrue(testCase7());  //OK
    }

    @Test
    public void test08_T(){
        assertTrue(testCase8());  //OK
    }

    @Test
    public void test09_T(){
        assertTrue(testCase9());  //OK
    }

    @Test
    public void test10_T(){
        assertTrue(testCase10());  //OK
    }

    @Test
    public void test11_T(){
        assertTrue(testCase11());  //OK
    }

    @Test
    public void test12_T(){
        assertTrue(testCase12());  //OK
    }

    @Test
    public void test13_T(){
        assertTrue(testCase13());  //OK
    }

    @Test
    public void test14_T(){
        assertTrue(testCase14());  //OK
    }

    @Test
    public void test15_T(){
        assertTrue(testCase15());  //OK
    }

    @Test
    public void test16_T(){
        assertTrue(testCase16());  //OK
    }

    @Test
    public void test17_T(){
        assertTrue(testCase17());  //OK
    }

    @Test
    public void test18_T(){
        assertTrue(testCase18());  //OK
    }

    @Test
    public void test19_T(){
        assertTrue(testCase19());  //OK
    }

    @Test
    public void test20_T(){
        assertTrue(testCase20()); //OK
    }

    @Test
    public void test21_T(){
        assertTrue(testCase21()); //OK
    }

    @Test
    public void test22_T(){
        assertTrue(testCase22()); //OK
    }

    @Test
    public void test23_T(){
        assertTrue(testCase23()); //OK
    }

    @Test
    public void test24_T(){
        assertTrue(testCase24()); //OK
    }

    @Test
    public void test25_T(){
        assertTrue(testCase25()); //OK
    }

    @Test
    public void test26_T(){
        assertTrue(testCase26()); //OK
    }

    @Test
    public void test27_T(){
        assertTrue(testCase27()); //OK
    }

    @Test
    public void test28_T(){
        assertTrue(testCase28()); //OK
    }

    @Test
    public void test29_T(){
        assertTrue(testCase29()); //OK
    }

    @Test
    public void test30_T(){
        assertTrue(testCase30()); //OK
    }

    @Test
    public void test31_T(){
        assertTrue(testCase31()); //
    }

    @Test
    public void test32_T(){
        assertTrue(testCase32()); //
    }

    @Test
    public void test33_T(){
        assertTrue(testCase33()); //
    }

    @Test
    public void test34_T(){
        assertTrue(testCase34()); //
    }

    @Test
    public void test35_T(){
        assertTrue(testCase35()); //
    }

    @Test
    public void test36_T(){
        assertTrue(testCase36()); //
    }

    @Test
    public void test37_T(){
        assertTrue(testCase37()); //
    }

    @Test
    public void test38_T(){
        assertTrue(testCase38()); //
    }

    @Test
    public void test39_T(){
        assertTrue(testCase39()); //
    }

    @Test
    public void test40_T(){
        assertTrue(testCase40()); //
    }

    @Test
    public void test41_T(){
        assertTrue(testCase41()); //
    }

    @Test
    public void test42_T(){
        assertTrue(testCase42()); //
    }

    @Test
    public void test43_T(){
        assertTrue(testCase43()); //
    }

    @Test
    public void test44_T(){
        assertTrue(testCase44()); //
    }

    @Test
    public void test45_T(){
        assertTrue(testCase45()); //
    }

    @Test
    public void test46_T(){
        assertTrue(testCase46()); //
    }

    @Test
    public void test47_T(){
        assertTrue(testCase47()); //
    }

    @Test
    public void test48_T(){
        assertTrue(testCase48()); //
    }

    @Test
    public void test49_T(){
        assertTrue(testCase49()); //
    }

    @Test
    public void test50_HT(){
        assertTrue(testCase50()); //
    }

    @Test
    public void test51_HT(){
        assertTrue(testCase51()); //
    }

    @Test
    public void test52_HT(){
        assertTrue(testCase52()); //
    }

    @Test
    public void test53_HT(){
        assertTrue(testCase53()); //
    }

    @Test
    public void test54_HT(){
        assertTrue(testCase54()); //
    }

    @Test
    public void test55_HT(){
        assertTrue(testCase55()); //
    }

    @Test
    public void test56_HT(){
        assertTrue(testCase56()); //
    }

    @Test
    public void test57_HT(){
        assertTrue(testCase57()); //
    }

    @Test
    public void test58_HT(){
        assertTrue(testCase58()); //
    }

    @Test
    public void test59_HT(){
        assertTrue(testCase59()); //
    }

    @Test
    public void test60_HT(){
        assertTrue(testCase60()); //
    }

    @Test
    public void test61_HT(){
        assertTrue(testCase61()); //
    }

    @Test
    public void test62_HT(){
        assertTrue(testCase62()); //
    }

    @Test
    public void test63_HT(){
        assertTrue(testCase63()); //
    }
    @Test
    public void test64_HT(){
        assertTrue(testCase64()); //
    }

    @Test
    public void test65_HT(){
        assertTrue(testCase65()); //
    }

    @Test
    public void test66_HT(){
        assertTrue(testCase66()); //
    }

    @Test
    public void test67_HT(){
        assertTrue(testCase67()); //
    }

    @Test
    public void test68_HT(){
        assertTrue(testCase68()); //
    }

    @Test
    public void test69_HT(){
        assertTrue(testCase69()); //
    }

    @Test
    public void test70_HT(){
        assertTrue(testCase70()); //
    }

    @Test
    public void test71_HT(){
        assertTrue(testCase71()); //
    }

    @Test
    public void test72_HT(){
        assertTrue(testCase72()); //
    }

    @Test
    public void test73_HT(){
        assertTrue(testCase73()); //
    }

    @Test
    public void test74_HT(){
        assertTrue(testCase74()); //
    }

    @Test
    public void test75_HT(){
        assertTrue(testCase75()); //
    }

    @Test
    public void test76_HT(){
        assertTrue(testCase76()); //
    }

    @Test
    public void test77_HT(){
        assertTrue(testCase77()); //
    }

    @Test
    public void test78_HT(){
        assertTrue(testCase78()); //
    }

    @Test
    public void test79_HT(){
        assertTrue(testCase79()); //
    }

    @Test
    public void test80_HT(){
        assertTrue(testCase80()); //
    }

    @Test
    public void test81_HT(){
        assertTrue(testCase81()); //
    }

    @Test
    public void test82_HT(){
        assertTrue(testCase82()); //
    }

    @Test
    public void test83_HT(){
        assertTrue(testCase83()); //
    }

    @Test
    public void test84_HT(){
        assertTrue(testCase84()); //
    }

    @Test
    public void test85_HT(){
        assertTrue(testCase85()); //
    }

    @Test
    public void test86_HT(){
        assertTrue(testCase86()); //
    }

    @Test
    public void test87_HT(){
        assertTrue(testCase87()); //
    }

    @Test
    public void test88_HT(){
        assertTrue(testCase88()); //
    }

    @Test
    public void test89_HT(){
        assertTrue(testCase89()); //
    }

    @Test
    public void test90_HT2(){
        assertTrue(testCase90()); //
    }

    @Test
    public void test91_HT2(){
        assertTrue(testCase91()); //
    }

    @Test
    public void test92_HT2(){
        assertTrue(testCase92()); //
    }

    @Test
    public void test93_HT2(){
        assertTrue(testCase93()); //
    }

    @Test
    public void test94_HT2(){
        assertTrue(testCase94()); //
    }

    @Test
    public void test95_HT2(){
        assertTrue(testCase95()); //
    }

    @Test
    public void test96_HT2(){
        assertTrue(testCase96()); //
    }

    @Test
    public void test97_HT2(){
        assertTrue(testCase97()); //
    }

    @Test
    public void test98_HT2(){
        assertTrue(testCase98()); //
    }

    @Test
    public void test99_HT2(){
        assertTrue(testCase99()); //
    }

    @Test
    public void test100_HT2(){
        assertTrue(testCase100()); //
    }

    @Test
    public void test101_HT2(){
        assertTrue(testCase101()); //
    }

    @Test
    public void test102_HT2(){
        assertTrue(testCase102()); //
    }

    /*
    * lambda(q0,k)
    * q0 = Geral
    * k = AtivarEscritorio
    * */
    private boolean testCase1() {
        SaidaDoCasoDeTeste saida1 = lambda_q0_k1();
        boolean resultado1 = AtivarEscritorio(saida1);

        return (resultado1);
    }

    /*
    * lambda(q0,k)
    * q0 = Geral
    * k = AtivarEscritorio
    * */
    private boolean testCase2() {
        SaidaDoCasoDeTeste saida1 = lambda_q0_k2();
        boolean resultado1 = AtivarEscritorio(saida1);

        return (resultado1);
    }

    /*
    * lambda(q0,k)lambda(q6,l)
    * q0 = Geral, q6 = Escritorio
    * k = AtivarEscritorio, l = DesativarEscritorio
    * */
    private boolean testCase3(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_k1();
        boolean resultado1 = AtivarEscritorio(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q6_l1();
        boolean resultado2 = DesativarEscritorio(saida2);

        return (resultado1 && resultado2);
    }


    /*
    * lambda(q0,k)lambda(q6,l)
    * q0 = Geral, q6 = Escritorio
    * k = AtivarEscritorio, l = DesativarEscritorio
    * */
    private boolean testCase4(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_k1();
        boolean resultado1 = AtivarEscritorio(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q6_l2();
        boolean resultado2 = DesativarEscritorio(saida2);

        return (resultado1 && resultado2);
    }

    /*
    * lambda(q0,k)lambda(q6,l)
    * q0 = Geral, q6 = Escritorio
    * k = AtivarEscritorio, l = DesativarEscritorio
    * */
    private boolean testCase5(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_k2();
        boolean resultado1 = AtivarEscritorio(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q6_l1();
        boolean resultado2 = DesativarEscritorio(saida2);

        return (resultado1 && resultado2);
    }

    /*
    * lambda(q0,k)lambda(q6,l)
    * q0 = Geral, q6 = Escritorio
    * k = AtivarEscritorio, l = DesativarEscritorio
    * */
    private boolean testCase6(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_k2();
        boolean resultado1 = AtivarEscritorio(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q6_l2();
        boolean resultado2 = DesativarEscritorio(saida2);

        return (resultado1 && resultado2);
    }

    /*
    * lambda(q0,k)lambda(q6,m)
    * q0 = Geral, q6 = Escritorio
    * k = AtivarEscritorio, m = AtivarReuniao
    * */
    private boolean testCase7(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_k1();
        boolean resultado1 = AtivarEscritorio(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q6_m();
        boolean resultado2 = AtivarReuniao(saida2);

        return (resultado1 && resultado2);
    }

    /*
    * lambda(q0,k)lambda(q6,m)
    * q0 = Geral, q6 = Escritorio
    * k = AtivarEscritorio, m = AtivarReuniao
    * */
    private boolean testCase8(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_k2();
        boolean resultado1 = AtivarEscritorio(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q6_m();
        boolean resultado2 = AtivarReuniao(saida2);

        return (resultado1 && resultado2);
    }

    /*
    * lambda(q0,k)lambda(q6,m)lambda(q7,n)
    * q0 = Geral, q6 = Escritorio, q7 = Reuniao
    * k = AtivarEscritorio, m = AtivarReuniao, n = DesativarReuniao
    * */
    private boolean testCase9(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_k1();
        boolean resultado1 = AtivarEscritorio(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q6_m();
        boolean resultado2 = AtivarReuniao(saida2);
        SaidaDoCasoDeTeste saida3 = lambda_q7_n();
        boolean resultado3 = DesativarReuniao(saida3);

        return (resultado1 && resultado2 && resultado3);
    }

    /*
    * lambda(q0,k)lambda(q6,m)lambda(q7,n)
    * q0 = Geral, q6 = Escritorio, q7 = Reuniao
    * k = AtivarEscritorio, m = AtivarReuniao, n = DesativarReuniao
    * */
    private boolean testCase10(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_k2();
        boolean resultado1 = AtivarEscritorio(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q6_m();
        boolean resultado2 = AtivarReuniao(saida2);
        SaidaDoCasoDeTeste saida3 = lambda_q7_n();
        boolean resultado3 = DesativarReuniao(saida3);

        return (resultado1 && resultado2 && resultado3);
    }

    /*
    * lambda(q0,k)lambda(q6,m)lambda(q7,n)lambda(q6,l)
    * q0 = Geral, q6 = Escritorio, q7 = Reuniao
    * k = AtivarEscritorio, m = AtivarReuniao, n = DesativarReuniao, l = DesativarEscritorio
    * */
    private boolean testCase11(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_k1();
        boolean resultado1 = AtivarEscritorio(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q6_m();
        boolean resultado2 = AtivarReuniao(saida2);
        SaidaDoCasoDeTeste saida3 = lambda_q7_n();
        boolean resultado3 = DesativarReuniao(saida3);
        SaidaDoCasoDeTeste saida4 = lambda_q6_l1();
        boolean resultado4 = DesativarEscritorio(saida4);

        return (resultado1 && resultado2 && resultado3 && resultado4);
    }

    /*
    * lambda(q0,k)lambda(q6,m)lambda(q7,n)lambda(q6,l)
    * q0 = Geral, q6 = Escritorio, q7 = Reuniao
    * k = AtivarEscritorio, m = AtivarReuniao, n = DesativarReuniao, l = DesativarEscritorio
    * */
    private boolean testCase12(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_k1();
        boolean resultado1 = AtivarEscritorio(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q6_m();
        boolean resultado2 = AtivarReuniao(saida2);
        SaidaDoCasoDeTeste saida3 = lambda_q7_n();
        boolean resultado3 = DesativarReuniao(saida3);
        SaidaDoCasoDeTeste saida4 = lambda_q6_l2();
        boolean resultado4 = DesativarEscritorio(saida4);

        return (resultado1 && resultado2 && resultado3 && resultado4);
    }

    /*
    * lambda(q0,k)lambda(q6,m)lambda(q7,n)lambda(q6,l)
    * q0 = Geral, q6 = Escritorio, q7 = Reuniao
    * k = AtivarEscritorio, m = AtivarReuniao, n = DesativarReuniao, l = DesativarEscritorio
    * */
    private boolean testCase13(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_k2();
        boolean resultado1 = AtivarEscritorio(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q6_m();
        boolean resultado2 = AtivarReuniao(saida2);
        SaidaDoCasoDeTeste saida3 = lambda_q7_n();
        boolean resultado3 = DesativarReuniao(saida3);
        SaidaDoCasoDeTeste saida4 = lambda_q6_l1();
        boolean resultado4 = DesativarEscritorio(saida4);

        return (resultado1 && resultado2 && resultado3 && resultado4);
    }

    /*
    * lambda(q0,k)lambda(q6,m)lambda(q7,n)lambda(q6,l)
    * q0 = Geral, q6 = Escritorio, q7 = Reuniao
    * k = AtivarEscritorio, m = AtivarReuniao, n = DesativarReuniao, l = DesativarEscritorio
    * */
    private boolean testCase14(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_k2();
        boolean resultado1 = AtivarEscritorio(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q6_m();
        boolean resultado2 = AtivarReuniao(saida2);
        SaidaDoCasoDeTeste saida3 = lambda_q7_n();
        boolean resultado3 = DesativarReuniao(saida3);
        SaidaDoCasoDeTeste saida4 = lambda_q6_l2();
        boolean resultado4 = DesativarEscritorio(saida4);

        return (resultado1 && resultado2 && resultado3 && resultado4);
    }


    /*
    * lambda(q0,o)
    * q0 = Geral
    * o = AtivarSincronizacao
    * */
    private boolean testCase15(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_o2();
        boolean resultado1 = AtivarSincronizacao(saida1);

        return resultado1;
    }

    /*
    * lambda(q0,o)lambda(q8,p)
    * q0 = general, q8 = Sincronizacao
    * o = AtivarSincronizacao, p = DesativarSincronizacao
    * */
    private boolean testCase16(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_o2();
        boolean resultado1 = AtivarSincronizacao(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q8_p();
        boolean resultado2 = DesativarSincronizacao(saida2);

        return (resultado1 && resultado2);
    }

    /*
    * lambda(q0,c)
    * q0 = general
    * c = AtivarRua
    * */
    private boolean testCase17(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_c();
        boolean resultado1 = AtivarRua(saida1);

        return resultado1;
    }

    /*
    * lambda(q0,c)lambda(q1,d)
    * q0 = general, q1 = Na rua
    * c = AtivarRua, d = DesativarRua
    * */
    private boolean testCase18(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_c();
        boolean resultado1 = AtivarRua(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q1_b1();
        boolean resultado2 = DesativarRua(saida2);

        return (resultado1 && resultado2);
    }

    /*
    * lambda(q0,c)lambda(q1,d)
    * q0 = general, q1 = Na rua
    * c = AtivarRua, d = DesativarRua
    * */
    private boolean testCase19(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_c();
        boolean resultado1 = AtivarRua(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q1_b2();
        boolean resultado2 = DesativarRua(saida2);

        return (resultado1 && resultado2);
    }

    /*
    * lambda(q0,c)lambda(q1,d)
    * q0 = general, q1 = Na rua
    * c = AtivarRua, d = DesativarRua
    * */
    private boolean testCase20(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_c();
        boolean resultado1 = AtivarRua(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q1_b3();
        boolean resultado2 = DesativarRua(saida2);

        return (resultado1 && resultado2);
    }

    /*
    * lambda(q0,c)lambda(q1,a)
    * q0 = general, q1 = Na rua
    * c = AtivarRua, a = AtivarCorrida
    * */
    private boolean testCase21(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_c();
        boolean resultado1 = AtivarRua(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q1_a();
        boolean resultado2 = AtivarCorrida(saida2);

        return (resultado1 && resultado2);
    }

    /*
    * lambda(q0,c)lambda(q1,a),lambda(q2,b)
    * q0 = general, q1 = Na rua, q2 = Corrida de Rua
    * c = AtivarRua, a = AtivarCorrida, b = DesativarCorrida
    * */
    private boolean testCase22(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_c();
        boolean resultado1 = AtivarRua(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q1_a();
        boolean resultado2 = AtivarCorrida(saida2);
        SaidaDoCasoDeTeste saida3 = lambda_q2_d1();
        boolean resultado3 = DesativarCorrida(saida3);

        return (resultado1 && resultado2 && resultado3);
    }

    /*
    * lambda(q0,c)lambda(q1,a),lambda(q2,b)
    * q0 = general, q1 = Na rua, q2 = Corrida de Rua
    * c = AtivarRua, a = AtivarCorrida, b = DesativarCorrida
    * */
    private boolean testCase23(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_c();
        boolean resultado1 = AtivarRua(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q1_a();
        boolean resultado2 = AtivarCorrida(saida2);
        SaidaDoCasoDeTeste saida3 = lambda_q2_d2();
        boolean resultado3 = DesativarCorrida(saida3);

        return (resultado1 && resultado2 && resultado3);
    }

    /*
    * lambda(q0,c)lambda(q1,a),lambda(q2,b)lambda(q1,d)
    * q0 = general, q1 = Na rua, q2 = Corrida de Rua
    * c = AtivarRua, a = AtivarCorrida, b = DesativarCorrida, d = DesativarRua
    * */
    private boolean testCase24(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_c();
        boolean resultado1 = AtivarRua(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q1_a();
        boolean resultado2 = AtivarCorrida(saida2);
        SaidaDoCasoDeTeste saida3 = lambda_q2_d1();
        boolean resultado3 = DesativarCorrida(saida3);
        SaidaDoCasoDeTeste saida4 = lambda_q1_b1();
        boolean resultado4 = DesativarRua(saida4);

        return (resultado1 && resultado2 && resultado3 && resultado4);
    }

    /*
    * lambda(q0,c)lambda(q1,a),lambda(q2,b)lambda(q1,d)
    * q0 = general, q1 = Na rua, q2 = Corrida de Rua
    * c = AtivarRua, a = AtivarCorrida, b = DesativarCorrida, d = DesativarRua
    * */
    private boolean testCase25(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_c();
        boolean resultado1 = AtivarRua(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q1_a();
        boolean resultado2 = AtivarCorrida(saida2);
        SaidaDoCasoDeTeste saida3 = lambda_q2_d1();
        boolean resultado3 = DesativarCorrida(saida3);
        SaidaDoCasoDeTeste saida4 = lambda_q1_b2();
        boolean resultado4 = DesativarRua(saida4);

        return (resultado1 && resultado2 && resultado3 && resultado4);
    }

    /*
    * lambda(q0,c)lambda(q1,a),lambda(q2,b)lambda(q1,d)
    * q0 = general, q1 = Na rua, q2 = Corrida de Rua
    * c = AtivarRua, a = AtivarCorrida, b = DesativarCorrida, d = DesativarRua
    * */
    private boolean testCase26(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_c();
        boolean resultado1 = AtivarRua(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q1_a();
        boolean resultado2 = AtivarCorrida(saida2);
        SaidaDoCasoDeTeste saida3 = lambda_q2_d1();
        boolean resultado3 = DesativarCorrida(saida3);
        SaidaDoCasoDeTeste saida4 = lambda_q1_b3();
        boolean resultado4 = DesativarRua(saida4);

        return (resultado1 && resultado2 && resultado3 && resultado4);
    }

    /*
    * lambda(q0,c)lambda(q1,a),lambda(q2,b)lambda(q1,d)
    * q0 = general, q1 = Na rua, q2 = Corrida de Rua
    * c = AtivarRua, a = AtivarCorrida, b = DesativarCorrida, d = DesativarRua
    * */
    private boolean testCase27(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_c();
        boolean resultado1 = AtivarRua(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q1_a();
        boolean resultado2 = AtivarCorrida(saida2);
        SaidaDoCasoDeTeste saida3 = lambda_q2_d2();
        boolean resultado3 = DesativarCorrida(saida3);
        SaidaDoCasoDeTeste saida4 = lambda_q1_b1();
        boolean resultado4 = DesativarRua(saida4);

        return (resultado1 && resultado2 && resultado3 && resultado4);
    }

    /*
    * lambda(q0,c)lambda(q1,a),lambda(q2,b)lambda(q1,d)
    * q0 = general, q1 = Na rua, q2 = Corrida de Rua
    * c = AtivarRua, a = AtivarCorrida, b = DesativarCorrida, d = DesativarRua
    * */
    private boolean testCase28(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_c();
        boolean resultado1 = AtivarRua(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q1_a();
        boolean resultado2 = AtivarCorrida(saida2);
        SaidaDoCasoDeTeste saida3 = lambda_q2_d2();
        boolean resultado3 = DesativarCorrida(saida3);
        SaidaDoCasoDeTeste saida4 = lambda_q1_b2();
        boolean resultado4 = DesativarRua(saida4);

        return (resultado1 && resultado2 && resultado3 && resultado4);
    }

    /*
    * lambda(q0,c)lambda(q1,a),lambda(q2,b)lambda(q1,d)
    * q0 = general, q1 = Na rua, q2 = Corrida de Rua
    * c = AtivarRua, a = AtivarCorrida, b = DesativarCorrida, d = DesativarRua
    * */
    private boolean testCase29(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_c();
        boolean resultado1 = AtivarRua(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q1_a();
        boolean resultado2 = AtivarCorrida(saida2);
        SaidaDoCasoDeTeste saida3 = lambda_q2_d2();
        boolean resultado3 = DesativarCorrida(saida3);
        SaidaDoCasoDeTeste saida4 = lambda_q1_b3();
        boolean resultado4 = DesativarRua(saida4);

        return (resultado1 && resultado2 && resultado3 && resultado4);
    }

    /*
    * lambda(q0,i)
    * q0 = general
    * i = AtivarCasa
    * */
    private boolean testCase30(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_i1();
        boolean resultado1 = AtivarCasa(saida1);

        return  resultado1;
    }

    /*
    * lambda(q0,i)
    * q0 = general
    * i = AtivarCasa
    * */
    private boolean testCase31(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_i2();
        boolean resultado1 = AtivarCasa(saida1);

        return  resultado1;
    }

    /*
    * lambda(q0,o)
    * q0 = general
    * i = AtivarSincronizacao
    * */
    private boolean testCase32(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_o1();
        boolean resultado1 = AtivarSincronizacao(saida1);

        return  resultado1;
    }


    /*
    * lambda(q0,o)lambda(q8,p)
    * q0 = general
    * o = AtivarSincronizacao, p = DesativarSincronizacao
    * */
    private boolean testCase33(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_o1();
        boolean resultado1 = AtivarSincronizacao(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q8_p();
        boolean resultado2 = DesativarSincronizacao(saida2);

        return  (resultado1 && resultado2);
    }

    /*
    * lambda(q0,e)
    * q0 = general
    * e = AtivarDirigindo
    * */
    private boolean testCase34(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_e();
        boolean resultado1 = AtivarDirigindo(saida1);

        return resultado1;
    }

    /*
    * lambda(q0,e)
    * q0 = general
    * e = AtivarDirigindo
    * */
    private boolean testCase35(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_i1();
        boolean resultado1 = AtivarCasa(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q3_e();
        boolean resultado2 = AtivarDirigindo(saida2);

        return (resultado1 && resultado2);
    }

    /*
    * lambda(q0,e)
    * q0 = general
    * e = AtivarDirigindo
    * */
    private boolean testCase36(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_i2();
        boolean resultado1 = AtivarCasa(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q3_e();
        boolean resultado2 = AtivarDirigindo(saida2);

        return (resultado1 && resultado2);
    }

    /*
    * lambda(q0,e)
    * q0 = general
    * e = AtivarDirigindo
    * */
    private boolean testCase37(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_e();
        boolean resultado1 = AtivarDirigindo(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q4_f();
        boolean resultado2 = DesativarDirigindo(saida2);

        return (resultado1 && resultado2);
    }

    /*
    * lambda(q0,e)
    * q0 = general
    * e = AtivarDirigindo
    * */
    private boolean testCase38(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_i1();
        boolean resultado1 = AtivarCasa(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q3_e();
        boolean resultado2 = AtivarDirigindo(saida2);
        SaidaDoCasoDeTeste saida3 = lambda_q4_f();
        boolean resultado3 = DesativarDirigindo(saida3);

        return (resultado1 && resultado2 && resultado3);
    }

    /*
    * lambda(q0,e)
    * q0 = general
    * e = AtivarDirigindo
    * */
    private boolean testCase39(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_i2();
        boolean resultado1 = AtivarCasa(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q3_e();
        boolean resultado2 = AtivarDirigindo(saida2);
        SaidaDoCasoDeTeste saida3 = lambda_q4_f();
        boolean resultado3 = DesativarDirigindo(saida3);

        return (resultado1 && resultado2 && resultado3);
    }


    /*
    * lambda(q0,e)lambda(q4,g)
    * q0 = general, q4 = Dirigindo
    * e = AtivarDirigindo, g = AtivarDirigindoRapido
    * */
    private boolean testCase40(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_e();
        boolean resultado1 = AtivarDirigindo(saida1);
        SaidaDoCasoDeTeste saida2 =lambda_q4_g();
        boolean resultado2 = AtivarDirigindoRapido(saida2);

        return  (resultado1 && resultado2);
    }

    /*
    * lambda(q0,e)lambda(q4,g)lambda(q5,h)
    * q0 = general, q4 = Dirigindo, q5 = DirigindoRapido
    * e = AtivarDirigindo, g = AtivarDirigindoRapido, h = DesativarDirigindoRapido
    * */
    private boolean testCase41(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_e();
        boolean resultado1 = AtivarDirigindo(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q4_g();
        boolean resultado2 = AtivarDirigindoRapido(saida2);
        SaidaDoCasoDeTeste saida3 = lambda_q5_h1();
        boolean resultado3 = DesativarDirigindoRapido(saida3);

        return (resultado1 && resultado2 && resultado3);
    }

    /*
    * lambda(q0,e)lambda(q4,g)lambda(q5,h)
    * q0 = general, q4 = Dirigindo, q5 = DirigindoRapido
    * e = AtivarDirigindo, g = AtivarDirigindoRapido, h = DesativarDirigindoRapido
    * */
    private boolean testCase42(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_e();
        boolean resultado1 = AtivarDirigindo(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q4_g();
        boolean resultado2 = AtivarDirigindoRapido(saida2);
        SaidaDoCasoDeTeste saida3 = lambda_q5_h2();
        boolean resultado3 = DesativarDirigindoRapido(saida3);

        return (resultado1 && resultado2 && resultado3);
    }

    /*
    * lambda(q0,e)lambda(q4,g)lambda(q5,h)lambda(q4,f)
    * q0 = general, q4 = Dirigindo, q5 = DirigindoRapido
    * e = AtivarDirigindo, g = AtivarDirigindoRapido, h = DesativarDirigindoRapido, f = DesativarDirigindo
    * */
    private boolean testCase43(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_e();
        boolean resultado1 = AtivarDirigindo(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q4_g();
        boolean resultado2 = AtivarDirigindoRapido(saida2);
        SaidaDoCasoDeTeste saida3 = lambda_q5_h1();
        boolean resultado3 = DesativarDirigindoRapido(saida3);
        SaidaDoCasoDeTeste saida4 = lambda_q4_f();
        boolean resultado4 = DesativarDirigindo(saida4);

        return (resultado1 && resultado2 && resultado3 && resultado4);
    }

    /*
    * lambda(q0,e)lambda(q4,g)lambda(q5,h)lambda(q4,f)
    * q0 = general, q4 = Dirigindo, q5 = DirigindoRapido
    * e = AtivarDirigindo, g = AtivarDirigindoRapido, h = DesativarDirigindoRapido, f = DesativarDirigindo
    * */
    private boolean testCase44(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_e();
        boolean resultado1 = AtivarDirigindo(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q4_g();
        boolean resultado2 = AtivarDirigindoRapido(saida2);
        SaidaDoCasoDeTeste saida3 = lambda_q5_h2();
        boolean resultado3 = DesativarDirigindoRapido(saida3);
        SaidaDoCasoDeTeste saida4 = lambda_q4_f();
        boolean resultado4 = DesativarDirigindo(saida4);

        return (resultado1 && resultado2 && resultado3 && resultado4);
    }

    /*
    * lambda(q0,i)lambda(q3,e)lambda(q4,g)
    * q0 = general, q4 = Dirigindo, q3 = Casa
    * i = AtivarCasa, e = AtivarDirigindo, g = AtivarDirigindoRapido
    * */
    private boolean testCase45(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_i1();
        boolean resultado1 = AtivarCasa(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q3_e();
        boolean resultado2 = AtivarDirigindo(saida2);
        SaidaDoCasoDeTeste saida3 = lambda_q4_g();
        boolean resultado3 = AtivarDirigindoRapido(saida3);

        return (resultado1 && resultado2 && resultado3);
    }

    /*
    * lambda(q0,i)lambda(q3,e)lambda(q4,g)
    * q0 = general, q4 = Dirigindo, q3 = Casa
    * i = AtivarCasa, e = AtivarDirigindo, g = AtivarDirigindoRapido
    * */
    private boolean testCase46(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_i1();
        boolean resultado1 = AtivarCasa(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q3_e();
        boolean resultado2 = AtivarDirigindo(saida2);
        SaidaDoCasoDeTeste saida3 = lambda_q4_g();
        boolean resultado3 = AtivarDirigindoRapido(saida3);
        SaidaDoCasoDeTeste saida4 = lambda_q5_h1();
        boolean resultado4 = DesativarDirigindoRapido(saida4);

        return (resultado1 && resultado2 && resultado3 && resultado4);
    }

    /*
    * lambda(q0,i)lambda(q3,e)lambda(q4,g)
    * q0 = general, q4 = Dirigindo, q3 = Casa
    * i = AtivarCasa, e = AtivarDirigindo, g = AtivarDirigindoRapido
    * */
    private boolean testCase47(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_i1();
        boolean resultado1 = AtivarCasa(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q3_e();
        boolean resultado2 = AtivarDirigindo(saida2);
        SaidaDoCasoDeTeste saida3 = lambda_q4_g();
        boolean resultado3 = AtivarDirigindoRapido(saida3);
        SaidaDoCasoDeTeste saida4 = lambda_q5_h2();
        boolean resultado4 = DesativarDirigindoRapido(saida4);

        return (resultado1 && resultado2 && resultado3 && resultado4);
    }

    /*
    * lambda(q0,i)lambda(q3,e)lambda(q4,g)
    * q0 = general, q4 = Dirigindo, q3 = Casa
    * i = AtivarCasa, e = AtivarDirigindo, g = AtivarDirigindoRapido
    * */
    private boolean testCase48(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_i1();
        boolean resultado1 = AtivarCasa(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q3_e();
        boolean resultado2 = AtivarDirigindo(saida2);
        SaidaDoCasoDeTeste saida3 = lambda_q4_g();
        boolean resultado3 = AtivarDirigindoRapido(saida3);
        SaidaDoCasoDeTeste saida4 = lambda_q5_h1();
        boolean resultado4 = DesativarDirigindoRapido(saida4);
        SaidaDoCasoDeTeste saida5 = lambda_q4_f();
        boolean resultado5 = DesativarDirigindo(saida5);

        return (resultado1 && resultado2 && resultado3 && resultado4 && resultado5);
    }

        /*
    * lambda(q0,i)lambda(q3,e)lambda(q4,g)
    * q0 = general, q4 = Dirigindo, q3 = Casa
    * i = AtivarCasa, e = AtivarDirigindo, g = AtivarDirigindoRapido
    * */
    private boolean testCase49(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_i1();
        boolean resultado1 = AtivarCasa(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q3_e();
        boolean resultado2 = AtivarDirigindo(saida2);
        SaidaDoCasoDeTeste saida3 = lambda_q4_g();
        boolean resultado3 = AtivarDirigindoRapido(saida3);
        SaidaDoCasoDeTeste saida4 = lambda_q5_h2();
        boolean resultado4 = DesativarDirigindoRapido(saida4);
        SaidaDoCasoDeTeste saida5 = lambda_q4_f();
        boolean resultado5 = DesativarDirigindo(saida5);

        return (resultado1 && resultado2 && resultado3 && resultado4 && resultado5);
    }

    /**  hybrid approach  */
    /*
* lambda(q0,k1)lambda(q6,e)
* q0 = general, q4 = Dirigindo, q6 = Escritorio
* k = AtivarEscritorio, e = AtivarDirigindo
* */
    private boolean testCase50(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_k1();
        boolean resultado1 = AtivarEscritorio(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q6_e();
        boolean resultado2 = AtivarDirigindo(saida2);

        return (resultado1 && resultado2);
    }


    /*
* lambda(q0,k1)lambda(q6,e)
* q0 = general, q4 = Dirigindo, q6 = Escritorio
* k = AtivarEscritorio, e = AtivarDirigindo
* */
    private boolean testCase51(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_k2();
        boolean resultado1 = AtivarEscritorio(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q6_e();
        boolean resultado2 = AtivarDirigindo(saida2);

        return (resultado1 && resultado2);
    }


    /*
    * lambda(q0,k1)lambda(q6,e)
    * q0 = general, q4 = Dirigindo, q1 = Rua
    * k = AtivarEscritorio, e = AtivarDirigindo, c = AtivarRua
    * */
    private boolean testCase52(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_c();
        boolean resultado1 = AtivarRua(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q1_e();
        boolean resultado2 = AtivarDirigindo(saida2);

        return (resultado1 && resultado2);
    }

    /*
    * lambda(q0,i)lambda(q3,j)
    * q0 = general, q3 = Casa
    * i = AtivarCasa1, j = DesativarCasa1
    * */
    private boolean testCase53(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_i1();
        boolean resultado1 = AtivarCasa(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q3_j1();
        boolean resultado2 = DesativarCasa(saida2);

        return (resultado1 && resultado2);
    }

    /*
    * lambda(q0,i)lambda(q3,j)
    * q0 = general, q3 = Casa
    * i = AtivarCasa2, j = DesativarCasa1
    * */
    private boolean testCase54(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_i2();
        boolean resultado1 = AtivarCasa(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q3_j1();
        boolean resultado2 = DesativarCasa(saida2);

        return (resultado1 && resultado2);
    }

    /*
* lambda(q0,i)lambda(q3,j)
* q0 = general, q3 = Casa
* i = AtivarCasa1, j = DesativarCasa2
* */
    private boolean testCase55(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_i1();
        boolean resultado1 = AtivarCasa(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q3_j2();
        boolean resultado2 = DesativarCasa(saida2);

        return (resultado1 && resultado2);
    }

    /*
* lambda(q0,i)lambda(q3,j)
* q0 = general, q3 = Casa
* i = AtivarCasa2, j = DesativarCasa2
* */
    private boolean testCase56(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_i2();
        boolean resultado1 = AtivarCasa(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q3_j2();
        boolean resultado2 = DesativarCasa(saida2);

        return (resultado1 && resultado2);
    }

    /*
    * lambda(q0,c)
    * q0 = general
    * c = !AtivarRua
    * */
    private boolean testCase57(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_c_negacao();
        boolean resultado1 = AtivarRua(saida1);

        return !(resultado1);
    }


    /*
    * lambda(q0,c)lambda(q1,b)
    * q0 = general, q1 = Na rua
    * c = AtivarRua, b = !DesativarRua1
    * */
    private boolean testCase58(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_c();
        boolean resultado1 = AtivarRua(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q1_b1_negacao();
        boolean resultado2 = DesativarRua(saida2);

        return (resultado1 && !resultado2);
    }

    /*
    * lambda(q0,c)lambda(q1,b)
    * q0 = general, q1 = Na rua
    * c = AtivarRua, b = !DesativarRua2 e !DesativarRua3
    * */
    private boolean testCase59(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_c();
        boolean resultado1 = AtivarRua(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q1_b2_negacao();
        boolean resultado2 = DesativarRua(saida2);

        return (resultado1 && !resultado2);
    }

    /*
    * lambda(q0,c)lambda(q1,a)
    * q0 = general, q1 = Na rua
    * c = AtivarRua, a = AtivarCorrida
    * */
    private boolean testCase60(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_c();
        boolean resultado1 = AtivarRua(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q1_a_negacao();
        boolean resultado2 = AtivarCorrida(saida2);

        return (resultado1 && !resultado2);
    }

    /*
    * lambda(q0,c)lambda(q1,a),lambda(q2,d)
    * q0 = general, q1 = Na rua, q2 = Corrida de Rua
    * c = AtivarRua, a = AtivarCorrida, d = !DesativarCorrida1
    * */
    private boolean testCase61(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_c();
        boolean resultado1 = AtivarRua(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q1_a();
        boolean resultado2 = AtivarCorrida(saida2);
        SaidaDoCasoDeTeste saida3 = lambda_q2_d1_negacao();
        boolean resultado3 = DesativarCorrida(saida3);

        return (resultado1 && resultado2 && !resultado3);
    }

    /*
    * lambda(q0,c)lambda(q1,a),lambda(q2,d)
    * q0 = general, q1 = Na rua, q2 = Corrida de Rua
    * c = AtivarRua, a = AtivarCorrida, d = !DesativarCorrida2
    * */
    private boolean testCase62(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_c();
        boolean resultado1 = AtivarRua(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q1_a();
        boolean resultado2 = AtivarCorrida(saida2);
        SaidaDoCasoDeTeste saida3 = lambda_q2_d2_negacao();
        boolean resultado3 = DesativarCorrida(saida3);

        return (resultado1 && resultado2 && !resultado3);
    }

    /*
    * lambda(q0,e)
    * q0 = general
    * e = !AtivarDirigindoGeral
    * */
    private boolean testCase63(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_e_negacao();
        boolean resultado1 = AtivarDirigindo(saida1);

        return !resultado1;
    }

    /*
    * lambda(q0,k)lambda(q3,e)
    * q0 = general, q3 = casa
    * i1 = AtivarCasa, e = !AtivarDirigindo_Casa
    * */
    private boolean testCase64(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_i1();
        boolean resultado1 = AtivarCasa(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q3_e_negacao();
        boolean resultado2 = AtivarDirigindo(saida2);

        return (resultado1 && !resultado2);
    }

    /*
    * lambda(q0,k)lambda(q3,e)
    * q0 = general, q3 = casa
    * i2 = AtivarCasa, e = !AtivarDirigindo_Casa
    * */
    private boolean testCase65(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_i2();
        boolean resultado1 = AtivarCasa(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q3_e_negacao();
        boolean resultado2 = AtivarDirigindo(saida2);

        return (resultado1 && !resultado2);
    }

    /*
* lambda(q0,k)lambda(q3,e)
* q0 = general, q6 = escritorio, q4 = dirigindo
* k1 = AtivarEscritorio, e = !AtivarDirigindo_Escritorio
* */
    private boolean testCase66(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_k1();
        boolean resultado1 = AtivarEscritorio(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q6_e_negacao();
        boolean resultado2 = AtivarDirigindo(saida2);

        return (resultado1 && !resultado2);
    }

    /*
* lambda(q0,k)lambda(q3,e)
* q0 = general, q6 = escritorio, q4 = dirigindo
* k2 = AtivarEscritorio, e = !AtivarDirigindo_Escritorio
* */
    private boolean testCase67(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_k2();
        boolean resultado1 = AtivarEscritorio(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q6_e_negacao();
        boolean resultado2 = AtivarDirigindo(saida2);

        return (resultado1 && !resultado2);
    }

    /*
* lambda(q0,a)lambda(q1,e)
* q0 = general, q1 = Na rua, q4 = dirigindo
* a = AtivarRua, e = !AtivarDirigindo_Rua
* */
    private boolean testCase68(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_c();
        boolean resultado1 = AtivarRua(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q1_e_negacao();
        boolean resultado2 = AtivarDirigindo(saida2);

        return (resultado1 && !resultado2);
    }

    /*
    * lambda(q0,e),lambda(q4,f)
    * q0 = general
    * e = AtivarDirigindo, !DesativarDirigindo
    * */
    private boolean testCase69(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_e();
        boolean resultado1 = AtivarDirigindo(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q4_f_negacao();
        boolean resultado2 = DesativarDirigindo(saida2);

        return (resultado1 && !resultado2);
    }

    /*
* lambda(q0,e)lambda(q4,g)
* q0 = general, q4 = Dirigindo
* e = AtivarDirigindo, g = !AtivarDirigindoRapido
* */
    private boolean testCase70(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_e();
        boolean resultado1 = AtivarDirigindo(saida1);
        SaidaDoCasoDeTeste saida2 =lambda_q4_g_negacao();
        boolean resultado2 = AtivarDirigindoRapido(saida2);

        return  (resultado1 && !resultado2);
    }

    /*
* lambda(q0,e)lambda(q4,g)lambda(q5,h)
* q0 = general, q4 = Dirigindo, q5 = DirigindoRapido
* e = AtivarDirigindo, g = AtivarDirigindoRapido, h = !DesativarDirigindoRapido
* */
    private boolean testCase71(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_e();
        boolean resultado1 = AtivarDirigindo(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q4_g();
        boolean resultado2 = AtivarDirigindoRapido(saida2);
        SaidaDoCasoDeTeste saida3 = lambda_q5_h1_negacao();
        boolean resultado3 = DesativarDirigindoRapido(saida3);

        return (resultado1 && resultado2 && !resultado3);
    }

    /*
    * lambda(q0,e)lambda(q4,g)lambda(q5,h)
    * q0 = general, q4 = Dirigindo, q5 = DirigindoRapido
    * e = AtivarDirigindo, g = AtivarDirigindoRapido, h = !DesativarDirigindoRapido
    * */
    private boolean testCase72(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_e();
        boolean resultado1 = AtivarDirigindo(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q4_g();
        boolean resultado2 = AtivarDirigindoRapido(saida2);
        SaidaDoCasoDeTeste saida3 = lambda_q5_h2_negacao();
        boolean resultado3 = DesativarDirigindoRapido(saida3);

        return (resultado1 && resultado2 && !resultado3);
    }

    /*
* lambda(q0,i)
* q0 = general
* i = !AtivarCasa
* */
    private boolean testCase73(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_i1_negacao();
        boolean resultado1 = AtivarCasa(saida1);

        return  !resultado1;
    }

    /*
    * lambda(q0,i)
    * q0 = general
    * i = !AtivarCasa
    * */
    private boolean testCase74(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_i2_negacao();
        boolean resultado1 = AtivarCasa(saida1);

        return  !resultado1;
    }

    /*
 * lambda(q0,i)lambda(q3,j)
 * q0 = general, q3 = Casa
 * i = AtivarCasa1, j = !DesativarCasa1
 * */
    private boolean testCase75(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_i1();
        boolean resultado1 = AtivarCasa(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q3_j1_negacao();
        boolean resultado2 = DesativarCasa(saida2);

        return (resultado1 && !resultado2);
    }

    /*
    * lambda(q0,i)lambda(q3,j)
    * q0 = general, q3 = Casa
    * i = AtivarCasa2, j = !DesativarCasa1
    * */
    private boolean testCase76(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_i2();
        boolean resultado1 = AtivarCasa(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q3_j1_negacao();
        boolean resultado2 = DesativarCasa(saida2);

        return (resultado1 && !resultado2);
    }

    /*
* lambda(q0,i)lambda(q3,j)
* q0 = general, q3 = Casa
* i = AtivarCasa1, j = !DesativarCasa2
* */
    private boolean testCase77(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_i1();
        boolean resultado1 = AtivarCasa(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q3_j2_negacao();
        boolean resultado2 = DesativarCasa(saida2);

        return (resultado1 && !resultado2);
    }

    /*
* lambda(q0,i)lambda(q3,j)
* q0 = general, q3 = Casa
* i = AtivarCasa2, j = !DesativarCasa2
* */
    private boolean testCase78(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_i2();
        boolean resultado1 = AtivarCasa(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q3_j2_negacao();
        boolean resultado2 = DesativarCasa(saida2);

        return (resultado1 && !resultado2);
    }

    /*
* lambda(q0,k)
* q0 = Geral
* k = !AtivarEscritorio
* */
    private boolean testCase79() {
        SaidaDoCasoDeTeste saida1 = lambda_q0_k1_negacao();
        boolean resultado1 = AtivarEscritorio(saida1);

        return (!resultado1);
    }

    /*
    * lambda(q0,k)
    * q0 = Geral
    * k = AtivarEscritorio
    * */
    private boolean testCase80() {
        SaidaDoCasoDeTeste saida1 = lambda_q0_k2_negacao();
        boolean resultado1 = AtivarEscritorio(saida1);

        return (!resultado1);
    }

    /*
 * lambda(q0,k)lambda(q6,l)
 * q0 = Geral, q6 = Escritorio
 * k = AtivarEscritorio, l = !DesativarEscritorio
 * */
    private boolean testCase81(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_k1();
        boolean resultado1 = AtivarEscritorio(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q6_l1_negacao();
        boolean resultado2 = DesativarEscritorio(saida2);

        return (resultado1 && !resultado2);
    }


    /*
    * lambda(q0,k)lambda(q6,l)
    * q0 = Geral, q6 = Escritorio
    * k = AtivarEscritorio, l = !DesativarEscritorio
    * */
    private boolean testCase82(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_k1();
        boolean resultado1 = AtivarEscritorio(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q6_l2_negacao();
        boolean resultado2 = DesativarEscritorio(saida2);

        return (resultado1 && !resultado2);
    }

    /*
    * lambda(q0,k)lambda(q6,m)
    * q0 = Geral, q6 = Escritorio
    * k = AtivarEscritorio, m = !AtivarReuniao
    * */
    private boolean testCase83(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_k1();
        boolean resultado1 = AtivarEscritorio(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q6_m_negacao();
        boolean resultado2 = AtivarReuniao(saida2);

        return (resultado1 && !resultado2);
    }

    /*
    * lambda(q0,k)lambda(q6,m)
            * q0 = Geral, q6 = Escritorio
    * k = AtivarEscritorio, m = !AtivarReuniao
    * */
    private boolean testCase84(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_k2();
        boolean resultado1 = AtivarEscritorio(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q6_m_negacao();
        boolean resultado2 = AtivarReuniao(saida2);

        return (resultado1 && !resultado2);
    }

    /*
* lambda(q0,k)lambda(q6,m)lambda(q7,n)
* q0 = Geral, q6 = Escritorio, q7 = Reuniao
* k = AtivarEscritorio, m = AtivarReuniao, n = !DesativarReuniao
* */
    private boolean testCase85(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_k1();
        boolean resultado1 = AtivarEscritorio(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q6_m();
        boolean resultado2 = AtivarReuniao(saida2);
        SaidaDoCasoDeTeste saida3 = lambda_q7_n_negacao();
        boolean resultado3 = DesativarReuniao(saida3);

        return (resultado1 && resultado2 && !resultado3);
    }

    /*
    * lambda(q0,k)lambda(q6,m)lambda(q7,n)
    * q0 = Geral, q6 = Escritorio, q7 = Reuniao
    * k = AtivarEscritorio, m = AtivarReuniao, n = !DesativarReuniao
    * */
    private boolean testCase86(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_k2();
        boolean resultado1 = AtivarEscritorio(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q6_m();
        boolean resultado2 = AtivarReuniao(saida2);
        SaidaDoCasoDeTeste saida3 = lambda_q7_n_negacao();
        boolean resultado3 = DesativarReuniao(saida3);

        return (resultado1 && resultado2 && !resultado3);
    }

    /*
* lambda(q0,o)
* q0 = Geral
* o = !AtivarSincronizacao
* */
    private boolean testCase87(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_o_negacao();
        boolean resultado1 = AtivarSincronizacao(saida1);

        return !resultado1;
    }

    /*
* lambda(q0,o)lambda(q8,p)
* q0 = general, q8 = Sincronizacao
* o = AtivarSincronizacao, p = !DesativarSincronizacao
* */
    private boolean testCase88(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_o1();
        boolean resultado1 = AtivarSincronizacao(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q8_p_negacao();
        boolean resultado2 = DesativarSincronizacao(saida2);

        return (resultado1 && !resultado2);
    }

    /*
* lambda(q0,o)lambda(q8,p)
* q0 = general, q8 = Sincronizacao
* o = AtivarSincronizacao, p = !DesativarSincronizacao
* */
    private boolean testCase89(){
        SaidaDoCasoDeTeste saida1 = lambda_q0_o2();
        boolean resultado1 = AtivarSincronizacao(saida1);
        SaidaDoCasoDeTeste saida2 = lambda_q8_p_negacao();
        boolean resultado2 = DesativarSincronizacao(saida2);

        return (resultado1 && !resultado2);
    }

     //q3 → q0 → q6 → q7
    //s16 → s19 → s21 → s24
    private boolean testCase90(){
        //s16 - AtivarCasa_Bluetooth (q0_i1)
        SaidaDoCasoDeTeste saida1 = lambda_q0_i1();
        boolean resultado1 = AtivarCasa(saida1);
        //s19 - DesativarCasa_GPS (q3_j2)
        SaidaDoCasoDeTeste saida2 = lambda_q3_j2();
        boolean resultado2 = DesativarCasa(saida2);
        //s21 - AtivarEscritorio_GPS (q0_k2)
        SaidaDoCasoDeTeste saida3 = lambda_q0_k2();
        boolean resultado3 = AtivarEscritorio(saida3);
        //s24 - AtivarReuniao (q6_m)
        SaidaDoCasoDeTeste saida4 = lambda_q6_m();
        boolean resultado4 = AtivarReuniao(saida4);

        return (resultado1 && resultado2 && resultado3 && resultado4);
    }

    //q5 → q4 → q0 → q6 → q7
    //s13 → s14 → s12 → s21 → s24
    private boolean testCase91(){
        //s8 - AtivarDirigindoGeral
        SaidaDoCasoDeTeste saida1 = lambda_q0_e();
        boolean resultado1 = AtivarDirigindo(saida1);
        //s13 - AtivarDirigindoRapido (q4_g)
        SaidaDoCasoDeTeste saida2 = lambda_q4_g();
        boolean resultado2 = AtivarDirigindoRapido(saida2);
        //s14 - DesativarDirigindoRapido_GPSNaoValido (q5_h1)
        SaidaDoCasoDeTeste saida3 = lambda_q5_h1();
        boolean resultado3 = DesativarDirigindoRapido(saida3);
        //s12 - DesativarDirigindo (q4_f)
        SaidaDoCasoDeTeste saida4 = lambda_q4_f();
        boolean resultado4 = DesativarDirigindo(saida4);
        //s21 - AtivarEscritorio_GPS (q0_k2)
        SaidaDoCasoDeTeste saida5 = lambda_q0_k2();
        boolean resultado5 = AtivarEscritorio(saida5);
        //s24 - AtivarReuniao (q6_m)
        SaidaDoCasoDeTeste saida6 = lambda_q6_m();
        boolean resultado6 = AtivarReuniao(saida6);

        return (resultado1 && resultado2 && resultado3 && resultado4 && resultado5 && resultado6);
    }

    //q3 → q0 → q4 → q5
    //s17 → s18 → s8 → s13
    private boolean testCase92(){
        //s17	AtivarCasa_GPS (q0_i2)
        SaidaDoCasoDeTeste saida1 = lambda_q0_i2();
        boolean resultado1 = AtivarCasa(saida1);
        //s18	DesativarCasa_Bluetooth (q3_j1)
        SaidaDoCasoDeTeste saida2 = lambda_q3_j1();
        boolean resultado2 = DesativarCasa(saida2);
        //s8	AtivarDirigindo_Geral (q0_e)
        SaidaDoCasoDeTeste saida3 = lambda_q0_e();
        boolean resultado3 = AtivarDirigindo(saida3);
        //s13	AtivarDirigindoRapido (q4_g)
        SaidaDoCasoDeTeste saida4 = lambda_q4_g();
        boolean resultado4 = AtivarDirigindoRapido(saida4);

        return (resultado1 && resultado2 && resultado3 && resultado4);
    }

    //q6 → q0 → q4 → q5
    //s21 → s22 → s8 → s13
    private boolean testCase93(){
        //s21	AtivarEscritorio_GPS (q0_k2)
        SaidaDoCasoDeTeste saida1 = lambda_q0_k2();
        boolean resultado1 = AtivarEscritorio(saida1);
        //s22	DesativarEscritorio_Bluetooth (q6_l1)
        SaidaDoCasoDeTeste saida2 = lambda_q6_l1();
        boolean resultado2 = DesativarEscritorio(saida2);
        //s8	AtivarDirigindo_Geral (q0_e)
        SaidaDoCasoDeTeste saida3 = lambda_q0_e();
        boolean resultado3 = AtivarDirigindo(saida3);
        //s13	AtivarDirigindoRapido (q4_g)
        SaidaDoCasoDeTeste saida4 = lambda_q4_g();
        boolean resultado4 = AtivarDirigindoRapido(saida4);

        return (resultado1 && resultado2 && resultado3 && resultado4);
    }

    //q5 → q4 → q0 → q6 → q7
    //s13 → s14 → s12 → s20 → s24
    private boolean testCase94(){
        //s8	AtivarDirigindo_Geral (q0_e)
        SaidaDoCasoDeTeste saida1 = lambda_q0_e();
        boolean resultado1 = AtivarDirigindo(saida1);
        //s13	AtivarDirigindoRapido (q4_g)
        SaidaDoCasoDeTeste saida2 = lambda_q4_g();
        boolean resultado2 = AtivarDirigindoRapido(saida2);
        //s14	DesativarDirigindoRapido_GPSNaoValido (q5_h1)
        SaidaDoCasoDeTeste saida3 = lambda_q5_h1();
        boolean resultado3 = DesativarDirigindoRapido(saida3);
        //s12	DesativarDirigindo (q4_f)
        SaidaDoCasoDeTeste saida4 = lambda_q4_f();
        boolean resultado4 = DesativarDirigindo(saida4);
        //s20	AtivarEscritorio_Bluetooh (q0_k1)
        SaidaDoCasoDeTeste saida5 = lambda_q0_k1();
        boolean resultado5 = AtivarEscritorio(saida5);
        //s24	AtivarReuniao (q6_m)
        SaidaDoCasoDeTeste saida6 = lambda_q6_m();
        boolean resultado6 = AtivarReuniao(saida6);

        return (resultado1 && resultado2 && resultado3 && resultado4 && resultado5 && resultado6);
    }

    //q3 → q0 → q1 → q2
    //s16 → s19 → s1 → s5
    private boolean testCase95(){
        //s16	AtivarCasa_Bluetooth (q0_i1)
        SaidaDoCasoDeTeste saida1 = lambda_q0_i1();
        boolean resultado1 = AtivarCasa(saida1);
        //s19	DesativarCasa_GPS (q3_j2)
        SaidaDoCasoDeTeste saida2 = lambda_q3_j2();
        boolean resultado2 = DesativarCasa(saida2);
        //s1	AtivarRua (q0_c)
        SaidaDoCasoDeTeste saida3 = lambda_q0_c();
        boolean resultado3 = AtivarRua(saida3);
        //s5	AtivarCorrida (q1_a)
        SaidaDoCasoDeTeste saida4 = lambda_q1_a();
        boolean resultado4 = AtivarCorrida(saida4);

        return (resultado1 && resultado2 && resultado3 && resultado4);
    }

    //q5 → q4 → q0 → q1
    //s13 → s14 → s12 → s1
    private boolean testCase96(){
        //s8	AtivarDirigindo_Geral (q0_e)
        SaidaDoCasoDeTeste saida1 = lambda_q0_e();
        boolean resultado1 = AtivarDirigindo(saida1);
        //s13	AtivarDirigindoRapido (q4_g)
        SaidaDoCasoDeTeste saida2 = lambda_q4_g();
        boolean resultado2 = AtivarDirigindoRapido(saida2);
        //s14	DesativarDirigindoRapido_GPSNaoValido (q5_h1)
        SaidaDoCasoDeTeste saida3 = lambda_q5_h1();
        boolean resultado3 = DesativarDirigindoRapido(saida3);
        //s12	DesativarDirigindo (q4_f)
        SaidaDoCasoDeTeste saida4 = lambda_q4_f();
        boolean resultado4 = DesativarDirigindo(saida4);
        //s1	AtivarRua (q0_c)
        SaidaDoCasoDeTeste saida5 = lambda_q0_c();
        boolean resultado5 = AtivarRua(saida5);

        return (resultado1 && resultado2 && resultado3 && resultado4 && resultado5);
    }

    //q5 → q4 → q0 → q3
    //s13 → s14 → s12 → s16
    private  boolean testCase97(){
        //s8	AtivarDirigindo_Geral (q0_e)
        SaidaDoCasoDeTeste saida1 = lambda_q0_e();
        boolean resultado1 = AtivarDirigindo(saida1);
        //s13	AtivarDirigindoRapido (q4_g)
        SaidaDoCasoDeTeste saida2 = lambda_q4_g();
        boolean resultado2 = AtivarDirigindoRapido(saida2);
        //s14	DesativarDirigindoRapido_GPSNaoValido (q5_h1)
        SaidaDoCasoDeTeste saida3 = lambda_q5_h1();
        boolean resultado3 = DesativarDirigindoRapido(saida3);
        //s12	DesativarDirigindo (q4_f)
        SaidaDoCasoDeTeste saida4 = lambda_q4_f();
        boolean resultado4 = DesativarDirigindo(saida4);
        //s16	AtivarCasa_Bluetooth (q0_i1)
        SaidaDoCasoDeTeste saida5 = lambda_q0_i1();
        boolean resultado5 = AtivarCasa(saida5);

        return (resultado1 && resultado2 && resultado3 && resultado4 && resultado5);
    }

    //q5 → q4 → q0 → q6
    //s13 → s14 → s12 → s20
    private boolean testCase98(){
        //s8	AtivarDirigindo_Geral (q0_e)
        SaidaDoCasoDeTeste saida1 = lambda_q0_e();
        boolean resultado1 = AtivarDirigindo(saida1);
        //s13	AtivarDirigindoRapido (q4_g)
        SaidaDoCasoDeTeste saida2 = lambda_q4_g();
        boolean resultado2 = AtivarDirigindoRapido(saida2);
        //s14	DesativarDirigindoRapido_GPSNaoValido (q5_h1)
        SaidaDoCasoDeTeste saida3 = lambda_q5_h1();
        boolean resultado3 = DesativarDirigindoRapido(saida3);
        //s12	DesativarDirigindo (q4_f)
        SaidaDoCasoDeTeste saida4 = lambda_q4_f();
        boolean resultado4 = DesativarDirigindo(saida4);
        //s20   AtivarEscritorio_Bluetooh (q0_k1)
        SaidaDoCasoDeTeste saida5 = lambda_q0_k1();
        boolean resultado5 = AtivarEscritorio(saida5);

        return (resultado1 && resultado2 && resultado3 && resultado4 && resultado5);
    }

    //q5 → q4 → q0 → q8
    //s13 → s14 → s12 → s26
    private boolean testCase99(){
        //s8	AtivarDirigindo_Geral (q0_e)
        SaidaDoCasoDeTeste saida1 = lambda_q0_e();
        boolean resultado1 = AtivarDirigindo(saida1);
        //s13	AtivarDirigindoRapido (q4_g)
        SaidaDoCasoDeTeste saida2 = lambda_q4_g();
        boolean resultado2 = AtivarDirigindoRapido(saida2);
        //s14	DesativarDirigindoRapido_GPSNaoValido (q5_h1)
        SaidaDoCasoDeTeste saida3 = lambda_q5_h1();
        boolean resultado3 = DesativarDirigindoRapido(saida3);
        //s12	DesativarDirigindo (q4_f)
        SaidaDoCasoDeTeste saida4 = lambda_q4_f();
        boolean resultado4 = DesativarDirigindo(saida4);
        //s26	AtivarSincronizacao_BTCasa (q0_o1)
        SaidaDoCasoDeTeste saida5 = lambda_q0_o1();
        boolean resultado5 = AtivarSincronizacao(saida5);

        return (resultado1 && resultado2 && resultado3 && resultado4 && resultado5);
    }

    //q5 → q4 → q0 → q8
    //s13 → s14 → s12 → s26
    private boolean testCase100(){
        //s8	AtivarDirigindo_Geral (q0_e)
        SaidaDoCasoDeTeste saida1 = lambda_q0_e();
        boolean resultado1 = AtivarDirigindo(saida1);
        //s13	AtivarDirigindoRapido (q4_g)
        SaidaDoCasoDeTeste saida2 = lambda_q4_g();
        boolean resultado2 = AtivarDirigindoRapido(saida2);
        //s14	DesativarDirigindoRapido_GPSNaoValido (q5_h1)
        SaidaDoCasoDeTeste saida3 = lambda_q5_h1();
        boolean resultado3 = DesativarDirigindoRapido(saida3);
        //s12	DesativarDirigindo (q4_f)
        SaidaDoCasoDeTeste saida4 = lambda_q4_f();
        boolean resultado4 = DesativarDirigindo(saida4);
        //s26	AtivarSincronizacao_BTEscritorio (q0_o1)
        SaidaDoCasoDeTeste saida5 = lambda_q0_o2();
        boolean resultado5 = AtivarSincronizacao(saida5);

        return (resultado1 && resultado2 && resultado3 && resultado4 && resultado5);
    }

    //q6 → q0 → q1 → q2
    //s20 → s23 → s1 → s5
    private boolean testCase101(){
        //s20   AtivarEscritorio_Bluetooh (q0_k1)
        SaidaDoCasoDeTeste saida1 = lambda_q0_k1();
        boolean resultado1 = AtivarEscritorio(saida1);
        //s23	DesativarEscritorio_GPS (q6_l2)
        SaidaDoCasoDeTeste saida2 = lambda_q6_l2();
        boolean resultado2 = DesativarEscritorio(saida2);
        //s1	AtivarRua (q0_c)
        SaidaDoCasoDeTeste saida3 = lambda_q0_c();
        boolean resultado3 = AtivarRua(saida3);
        //s5	AtivarCorrida (q1_a)
        SaidaDoCasoDeTeste saida4 = lambda_q1_a();
        boolean resultado4 = AtivarCorrida(saida4);

        return (resultado1 && resultado2 && resultado3 && resultado4);
    }

    //q6 → q0 → q1 → q2
    //s21 → s23 → s1 → s5
    private boolean testCase102(){
        //s21   AtivarEscritorio_GPS (q0_k2)
        SaidaDoCasoDeTeste saida1 = lambda_q0_k2();
        boolean resultado1 = AtivarEscritorio(saida1);
        //s23	DesativarEscritorio_GPS (q6_l2)
        SaidaDoCasoDeTeste saida2 = lambda_q6_l2();
        boolean resultado2 = DesativarEscritorio(saida2);
        //s1	AtivarRua (q0_c)
        SaidaDoCasoDeTeste saida3 = lambda_q0_c();
        boolean resultado3 = AtivarRua(saida3);
        //s5	AtivarCorrida (q1_a)
        SaidaDoCasoDeTeste saida4 = lambda_q1_a();
        boolean resultado4 = AtivarCorrida(saida4);


        return (resultado1 && resultado2 && resultado3 && resultado4);
    }


    private SaidaDoCasoDeTeste lambda_q0_k1() {

        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        //parametros.setmGpsAvailable(false);
        //parametros.setmLocation(NaoCasaNemEscritorio);
        //parametros.setmSpeed(0);
        ArrayList<String> mBtDeviceList=new ArrayList<String>();
        mBtDeviceList.add(bt_escritorio);//[OBRIGATORIO]
        parametros.setmBtDeviceList(mBtDeviceList);
        //Calendar hora = Calendar.getInstance();
        //parametros.setmTime(hora.getTime());
        //parametros.setmWeekday(hora.get(Calendar.DAY_OF_WEEK));

        AdicionarParametrosNoCasoDeTeste(parametros);

        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q0_k2() {

        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        parametros.setmGpsAvailable(true); //[OBRIGATORIO]
        parametros.setmLocation(Escritorio); //[OBRIGATORIO]

        AdicionarParametrosNoCasoDeTeste(parametros);

        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q6_l1() {
        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        ArrayList<String> mBtDeviceList = new ArrayList<String>();
        mBtDeviceList.add(bt_NaoCasaNemEscritorio); //[OBRIGATORIO] diferente de escritorio
        parametros.setmBtDeviceList(mBtDeviceList);

        AdicionarParametrosNoCasoDeTeste(parametros);

        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q6_l2() {
        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        parametros.setmGpsAvailable(true); //[OBRIGATORIO]
        parametros.setmLocation(NaoCasaNemEscritorio); //[OBRIGATORIO] // constante = Escritorio

        AdicionarParametrosNoCasoDeTeste(parametros);

        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q6_m() {
        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        ArrayList<String> mBtDeviceList = new ArrayList<String>();
        mBtDeviceList.add(bt_NaoCasaNemEscritorio);
        mBtDeviceList.add(bt_NaoCasaNemEscritorio);
        mBtDeviceList.add(bt_NaoCasaNemEscritorio);
        parametros.setmBtDeviceList(mBtDeviceList);

        Calendar hora = Calendar.getInstance();
        hora.setTime(new Date()); //colocando o objeto Date no Calendar
        hora.set(Calendar.HOUR_OF_DAY, 14); //zerando as horas, minuots e segundos..
        hora.set(Calendar.MINUTE, 0);
        hora.set(Calendar.SECOND, 0);

        parametros.setmTime(hora.getTime()); //[OBRIGATORIO]

        AdicionarParametrosNoCasoDeTeste(parametros);
        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q7_n() {
        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        Calendar hora = Calendar.getInstance();
        hora.setTime(new Date()); //colocando o objeto Date no Calendar
        hora.set(Calendar.HOUR_OF_DAY, 16); //zerando as horas, minuots e segundos..
        hora.set(Calendar.MINUTE, 0);
        hora.set(Calendar.SECOND, 0);
        parametros.setmTime(hora.getTime()); //[OBRIGATORIO]

        AdicionarParametrosNoCasoDeTeste(parametros);

        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q0_o1() {
        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        ArrayList<String> mBtDeviceList=new ArrayList<String>();
        mBtDeviceList.add(bt_casa); //[OBRIGATORIO] //bt_casa
        parametros.setmBtDeviceList(mBtDeviceList);

        AdicionarParametrosNoCasoDeTeste(parametros);
        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q0_o2() {
        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        ArrayList<String> mBtDeviceList=new ArrayList<String>();
        mBtDeviceList.add(bt_escritorio); //[OBRIGATORIO] //bt_escritorio
        parametros.setmBtDeviceList(mBtDeviceList);

        AdicionarParametrosNoCasoDeTeste(parametros);
        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q8_p() {
        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        ArrayList<String> mBtDeviceList = new ArrayList<String>();
        mBtDeviceList.add(bt_NaoCasaNemEscritorio); //[OBRIGATORIO]
        parametros.setmBtDeviceList(mBtDeviceList);

        AdicionarParametrosNoCasoDeTeste(parametros);

        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q0_c() {
        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        parametros.setmGpsAvailable(true); //[OBRIGATORIO]
        parametros.setmLocation(NaoCasaNemEscritorio); //[OBRIGATORIO]

        AdicionarParametrosNoCasoDeTeste(parametros);

        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q1_d1() {
        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        parametros.setmGpsAvailable(false); //[OBRIGATORIO]

        AdicionarParametrosNoCasoDeTeste(parametros);

        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q1_d2() {
        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        parametros.setmSpeed(5);

        AdicionarParametrosNoCasoDeTeste(parametros);

        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q1_a() {
        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        parametros.setmGpsAvailable(true); //[OBRIGATORIO]
        parametros.setmSpeed(6); //[OBRIGATORIO]

        AdicionarParametrosNoCasoDeTeste(parametros);
        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q1_b1() {
        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        parametros.setmGpsAvailable(false); //[OBRIGATORIO]

        AdicionarParametrosNoCasoDeTeste(parametros);

        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q1_b2() {
        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        parametros.setmLocation(Casa); //[OBRIGATORIO]

        AdicionarParametrosNoCasoDeTeste(parametros);

        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q1_b3() {
        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        parametros.setmLocation(Escritorio); //[OBRIGATORIO]

        AdicionarParametrosNoCasoDeTeste(parametros);

        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q2_d1() {
        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        parametros.setmGpsAvailable(false); //[OBRIGATORIO]

        AdicionarParametrosNoCasoDeTeste(parametros);

        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q2_d2() {
        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        parametros.setmSpeed(5); // km/h =< 5 //[OBRIGATORIO]

        AdicionarParametrosNoCasoDeTeste(parametros);

        return ExecutarLambda();
    }


    private SaidaDoCasoDeTeste lambda_q0_i1() {
        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        ArrayList<String> mBtDeviceList=new ArrayList<String>();
        mBtDeviceList.add(bt_casa); //bt_casa //[OBRIGATORIO]
        parametros.setmBtDeviceList(mBtDeviceList);

        AdicionarParametrosNoCasoDeTeste(parametros);

        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q0_i2() {
        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        parametros.setmGpsAvailable(true); //[OBRIGATORIO]
        parametros.setmLocation(Casa); //Casa //[OBRIGATORIO]

        AdicionarParametrosNoCasoDeTeste(parametros);

        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q3_j1() {
        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();


        ArrayList<String> mBtDeviceList = new ArrayList<String>();
        mBtDeviceList.add(bt_NaoCasaNemEscritorio); //[OBRIGATORIO] //qualquer
        parametros.setmBtDeviceList(mBtDeviceList);

        AdicionarParametrosNoCasoDeTeste(parametros);
        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q3_j2() {
        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        parametros.setmGpsAvailable(true); //[OBRIGATORIO]
        parametros.setmLocation(NaoCasaNemEscritorio); //[OBRIGATORIO] //Qualquer;

        AdicionarParametrosNoCasoDeTeste(parametros);
        return ExecutarLambda();

    }

    //Mesmo parametros para todos
    private SaidaDoCasoDeTeste lambda_q0_e() {
        LambdaDirigindo();
        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q4_f() {
        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        ArrayList<String> mBtDeviceList = new ArrayList<String>();
        mBtDeviceList.add(bt_NaoCasaNemEscritorio); //[OBRIGATORIO] //diferente de bt_carro

        parametros.setmBtDeviceList(mBtDeviceList);

        AdicionarParametrosNoCasoDeTeste(parametros);
        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q4_g() {
        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        parametros.setmGpsAvailable(true); //[OBRIGATORIO] //true
        parametros.setmSpeed(71); //[OBRIGATORIO] //km/h > 70

        AdicionarParametrosNoCasoDeTeste(parametros);

        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q5_h1() {
        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        parametros.setmGpsAvailable(false); //[OBRIGATORIO] //false

        AdicionarParametrosNoCasoDeTeste(parametros);
        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q5_h2() {
        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        parametros.setmSpeed(70); //[OBRIGATORIO] //km/h <= 70

        AdicionarParametrosNoCasoDeTeste(parametros);
        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q1_e() {
        LambdaDirigindo();
        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q3_e() {
        LambdaDirigindo();
        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q6_e() {
        LambdaDirigindo();
        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q0_c_negacao() {
        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        parametros.setmGpsAvailable(false); //[OBRIGATORIO]
        parametros.setmLocation(NaoCasaNemEscritorio); //[OBRIGATORIO]

        AdicionarParametrosNoCasoDeTeste(parametros);

        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q1_b1_negacao() {
        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        parametros.setmGpsAvailable(true); //[OBRIGATORIO]

        AdicionarParametrosNoCasoDeTeste(parametros);

        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q1_b2_negacao() {
        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        parametros.setmLocation(NaoCasaNemEscritorio); //[OBRIGATORIO]

        AdicionarParametrosNoCasoDeTeste(parametros);

        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q1_a_negacao() {
        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        parametros.setmGpsAvailable(true); //[OBRIGATORIO]
        parametros.setmSpeed(5); //[OBRIGATORIO]

        AdicionarParametrosNoCasoDeTeste(parametros);
        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q2_d1_negacao() {
        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        parametros.setmGpsAvailable(true); //[OBRIGATORIO]

        AdicionarParametrosNoCasoDeTeste(parametros);

        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q2_d2_negacao() {
        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        parametros.setmSpeed(6); // km/h =< 5 //[OBRIGATORIO]

        AdicionarParametrosNoCasoDeTeste(parametros);

        return ExecutarLambda();
    }

    //Mesmo parametros para todos
    private SaidaDoCasoDeTeste lambda_q0_e_negacao() {
        LambdaDirigindo_negacao();
        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q3_e_negacao() {
        LambdaDirigindo_negacao();
        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q6_e_negacao() {
        LambdaDirigindo_negacao();
        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q1_e_negacao() {
        LambdaDirigindo_negacao();
        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q4_f_negacao() {
        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        ArrayList<String> mBtDeviceList = new ArrayList<String>();
        mBtDeviceList.add(bt_carro); //[OBRIGATORIO] //diferente de bt_carro

        parametros.setmBtDeviceList(mBtDeviceList);

        AdicionarParametrosNoCasoDeTeste(parametros);
        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q4_g_negacao() {
        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        parametros.setmGpsAvailable(false); //[OBRIGATORIO] //true
        parametros.setmSpeed(70); //[OBRIGATORIO] //km/h > 70

        AdicionarParametrosNoCasoDeTeste(parametros);

        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q5_h1_negacao() {
        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        parametros.setmGpsAvailable(true); //[OBRIGATORIO] //false

        AdicionarParametrosNoCasoDeTeste(parametros);
        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q5_h2_negacao() {
        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        parametros.setmSpeed(71); //[OBRIGATORIO] //km/h <= 70

        AdicionarParametrosNoCasoDeTeste(parametros);
        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q0_i1_negacao() {
        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        ArrayList<String> mBtDeviceList=new ArrayList<String>();
        mBtDeviceList.add(bt_NaoCasaNemEscritorio); //bt_casa //[OBRIGATORIO]
        parametros.setmBtDeviceList(mBtDeviceList);

        AdicionarParametrosNoCasoDeTeste(parametros);

        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q0_i2_negacao() {
        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        parametros.setmGpsAvailable(false); //[OBRIGATORIO]
        parametros.setmLocation(NaoCasaNemEscritorio); //Casa //[OBRIGATORIO]

        AdicionarParametrosNoCasoDeTeste(parametros);

        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q3_j1_negacao() {
        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();


        ArrayList<String> mBtDeviceList = new ArrayList<String>();
        mBtDeviceList.add(bt_casa); //[OBRIGATORIO] //qualquer
        parametros.setmBtDeviceList(mBtDeviceList);

        AdicionarParametrosNoCasoDeTeste(parametros);
        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q3_j2_negacao() {
        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        parametros.setmGpsAvailable(false); //[OBRIGATORIO]
        parametros.setmLocation(Casa); //[OBRIGATORIO] //Qualquer;

        AdicionarParametrosNoCasoDeTeste(parametros);
        return ExecutarLambda();

    }

    private SaidaDoCasoDeTeste lambda_q0_k1_negacao() {

        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        //parametros.setmGpsAvailable(false);
        //parametros.setmLocation(NaoCasaNemEscritorio);
        //parametros.setmSpeed(0);
        ArrayList<String> mBtDeviceList=new ArrayList<String>();
        mBtDeviceList.add(bt_NaoCasaNemEscritorio);//[OBRIGATORIO]
        parametros.setmBtDeviceList(mBtDeviceList);
        //Calendar hora = Calendar.getInstance();
        //parametros.setmTime(hora.getTime());
        //parametros.setmWeekday(hora.get(Calendar.DAY_OF_WEEK));

        AdicionarParametrosNoCasoDeTeste(parametros);

        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q0_k2_negacao() {

        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        parametros.setmGpsAvailable(false); //[OBRIGATORIO]
        parametros.setmLocation(NaoCasaNemEscritorio); //[OBRIGATORIO]

        AdicionarParametrosNoCasoDeTeste(parametros);

        return ExecutarLambda();
    }

    private void LambdaDirigindo_negacao(){
        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        ArrayList<String> mBtDeviceList=new ArrayList<String>();
        mBtDeviceList.add(bt_NaoCasaNemEscritorio); //[OBRIGATORIO] //bt_carro
        parametros.setmBtDeviceList(mBtDeviceList); //

        AdicionarParametrosNoCasoDeTeste(parametros);
    }

    private SaidaDoCasoDeTeste lambda_q6_l1_negacao() {
        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        ArrayList<String> mBtDeviceList = new ArrayList<String>();
        mBtDeviceList.add(bt_escritorio); //[OBRIGATORIO] diferente de escritorio
        parametros.setmBtDeviceList(mBtDeviceList);

        AdicionarParametrosNoCasoDeTeste(parametros);

        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q6_l2_negacao() {
        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        parametros.setmGpsAvailable(true); //[OBRIGATORIO]
        parametros.setmLocation(Escritorio); //[OBRIGATORIO] // constante = Escritorio

        AdicionarParametrosNoCasoDeTeste(parametros);

        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q6_m_negacao() {
        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        ArrayList<String> mBtDeviceList = new ArrayList<String>();
        mBtDeviceList.add(bt_NaoCasaNemEscritorio);
        parametros.setmBtDeviceList(mBtDeviceList);

        Calendar hora = Calendar.getInstance();
        hora.setTime(new Date()); //colocando o objeto Date no Calendar
        hora.set(Calendar.HOUR_OF_DAY, 13); //zerando as horas, minuots e segundos..
        hora.set(Calendar.MINUTE, 0);
        hora.set(Calendar.SECOND, 0);

        parametros.setmTime(hora.getTime()); //[OBRIGATORIO]

        AdicionarParametrosNoCasoDeTeste(parametros);
        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q7_n_negacao() {
        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        Calendar hora = Calendar.getInstance();
        hora.setTime(new Date()); //colocando o objeto Date no Calendar
        hora.set(Calendar.HOUR_OF_DAY, 14); //zerando as horas, minuots e segundos..
        hora.set(Calendar.MINUTE, 0);
        hora.set(Calendar.SECOND, 0);
        parametros.setmTime(hora.getTime()); //[OBRIGATORIO]

        AdicionarParametrosNoCasoDeTeste(parametros);

        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q0_o_negacao() {
        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        ArrayList<String> mBtDeviceList=new ArrayList<String>();
        mBtDeviceList.add(bt_NaoCasaNemEscritorio); //[OBRIGATORIO] //bt_NaoCasaNemEscritorio
        parametros.setmBtDeviceList(mBtDeviceList);

        AdicionarParametrosNoCasoDeTeste(parametros);
        return ExecutarLambda();
    }

    private SaidaDoCasoDeTeste lambda_q8_p_negacao() {
        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        ArrayList<String> mBtDeviceList = new ArrayList<String>();
        mBtDeviceList.add(bt_casa); //[OBRIGATORIO]
        mBtDeviceList.add(bt_escritorio); //[OBRIGATORIO]
        parametros.setmBtDeviceList(mBtDeviceList);

        AdicionarParametrosNoCasoDeTeste(parametros);

        return ExecutarLambda();
    }

    private void LambdaDirigindo(){
        EntradaDoCasoDeTeste parametros = new EntradaDoCasoDeTeste();

        ArrayList<String> mBtDeviceList=new ArrayList<String>();
        mBtDeviceList.add(bt_carro); //[OBRIGATORIO] //bt_carro
        parametros.setmBtDeviceList(mBtDeviceList); //

        AdicionarParametrosNoCasoDeTeste(parametros);
    }

    private SaidaDoCasoDeTeste ExecutarLambda(){
        // Vincular o serviço para uso, como um caso de teste pode ter várias lambdas então precisa dessa verificacao.
        IBinder binder = null;
        if(!mBound) {
            try {
                binder = mServiceRule.bindService(serviceIntentAM, mConnectionAM, Context.BIND_AUTO_CREATE);
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }
        // Pegar a referencia do serviço, ou chamar métodos publicos diretamente do vinculador.
        //AdaptationManager service = ((AdaptationManager.AdaptationManagerBinder) binder).getService();

        IntentFilter iFilter = new IntentFilter();
        iFilter.addAction("edu.hkust.cse.phoneAdapter.newContext");
        while (!mBound) SystemClock.sleep(1);
        contexto.registerReceiver(serviceAM.mReceiver, iFilter);
        AdaptationManager.EmTeste = true;
        serviceAM.mReceiver.onReceive(contexto, serviceIntentAM);

        return serviceAM.SaidaDoCasoDeTeste;
    }

    private boolean AtivarEscritorio(SaidaDoCasoDeTeste saida){
        if(saida == null)
            return false;
        else{
            boolean booEa = saida.getEstadoAtual().equals("general");
            boolean booP =  saida.getNomeDoPredicado().contains("AtivarEscritorio");
            boolean booEn = saida.getEstadoNovo().equals("Escritorio");
            boolean booVo = saida.getVolume() == 0;
            boolean booVi = saida.getVibracao() == 1;
            boolean booMv = saida.getModoAviao() == 0;

            return (booEa && booP && booEn && booVo && booVi && booMv);
        }
    }

    private boolean DesativarEscritorio(SaidaDoCasoDeTeste saida){
        if(saida == null)
            return false;
        else {
            boolean booEa = saida.getEstadoAtual().equals("Escritorio");
            boolean booP = saida.getNomeDoPredicado().contains("DesativarEscritorio");
            boolean booEn = saida.getEstadoNovo().equals("general");
            boolean booVo = saida.getVolume() == 50;
            boolean booVi = saida.getVibracao() == 0;
            boolean booMv = saida.getModoAviao() == 0;

            return (booEa && booP && booEn && booVo && booVi && booMv);
        }
    }

    private boolean AtivarReuniao(SaidaDoCasoDeTeste saida){
        if(saida == null)
            return false;
        else{
            boolean booEa = saida.getEstadoAtual().equals("Escritorio");
            boolean booP =  saida.getNomeDoPredicado().contains("AtivarReuniao");
            boolean booEn = saida.getEstadoNovo().equals("Reuniao");
            boolean booVo = saida.getVolume() == 0;
            boolean booVi = saida.getVibracao() == 0;
            boolean booMv = saida.getModoAviao() == 1;

            return  (booEa && booP  && booEn && booVo && booVi && booMv);
        }
    }

    private boolean DesativarReuniao(SaidaDoCasoDeTeste saida){
        if(saida == null)
            return false;
        else{
            boolean booEa = saida.getEstadoAtual().equals("Reuniao");
            boolean booP =  saida.getNomeDoPredicado().contains("DesativarReuniao");
            boolean booEn = saida.getEstadoNovo().equals("Escritorio");
            boolean booVo = saida.getVolume() == 0;
            boolean booVi = saida.getVibracao() == 1;
            boolean booMv = saida.getModoAviao() == 0;

            return  (booEa && booP  && booEn && booVo && booVi && booMv);
        }
    }

    private boolean AtivarSincronizacao(SaidaDoCasoDeTeste saida){
        if(saida == null)
            return false;
        else {
            boolean booEa = saida.getEstadoAtual().equals("general");
            boolean booP = saida.getNomeDoPredicado().contains("AtivarSincronizacao");
            boolean booEn = saida.getEstadoNovo().equals("Sincronizacao");
            boolean booVo = saida.getVolume() == 50;
            boolean booVi = saida.getVibracao() == 0;
            boolean booMv = saida.getModoAviao() == 0;

            return (booEa && booP && booEn && booVo && booVi && booMv);
        }
    }

    private boolean DesativarSincronizacao(SaidaDoCasoDeTeste saida){
        if(saida == null)
            return false;
        else {
            boolean booEa = saida.getEstadoAtual().equals("Sincronizacao");
            boolean booP = saida.getNomeDoPredicado().contains("DesativarSincronizacao");
            boolean booEn = saida.getEstadoNovo().equals("general");
            boolean booVo = saida.getVolume() == 50;
            boolean booVi = saida.getVibracao() == 0;
            boolean booMv = saida.getModoAviao() == 0;

            return (booEa && booP && booEn && booVo && booVi && booMv);
        }
    }

    private boolean AtivarRua(SaidaDoCasoDeTeste saida){

        if(saida == null)
            return false;
        else {
            boolean booEa = saida.getEstadoAtual().equals("general");
            boolean booP = saida.getNomeDoPredicado().contains("AtivarRua");
            boolean booEn = saida.getEstadoNovo().equals("Na rua");
            boolean booVo = saida.getVolume() == 100;
            boolean booVi = saida.getVibracao() == 0;
            boolean booMv = saida.getModoAviao() == 0;

            return (booEa && booP && booEn && booVo && booVi && booMv);
        }
    }

    private boolean DesativarRua(SaidaDoCasoDeTeste saida){
        if(saida == null)
            return false;
        else {
            boolean booEa = saida.getEstadoAtual().equals("Na rua");
            boolean booP = saida.getNomeDoPredicado().contains("DesativarRua");
            boolean booEn = saida.getEstadoNovo().equals("general");
            boolean booVo = saida.getVolume() == 50;
            boolean booVi = saida.getVibracao() == 0;
            boolean booMv = saida.getModoAviao() == 0;

            return (booEa && booP && booEn && booVo && booVi && booMv);
        }
    }

    private boolean AtivarCorrida(SaidaDoCasoDeTeste saida){
        if(saida == null)
            return false;
        else {
            boolean booEa = saida.getEstadoAtual().equals("Na rua");
            boolean booP = saida.getNomeDoPredicado().contains("AtivarCorrida");
            boolean booEn = saida.getEstadoNovo().equals("Corrida de rua");
            boolean booVo = saida.getVolume() == 100;
            boolean booVi = saida.getVibracao() == 0;
            boolean booMv = saida.getModoAviao() == 0;

            return (booEa && booP && booEn && booVo && booVi && booMv);
        }
    }

    private  boolean DesativarCorrida(SaidaDoCasoDeTeste saida){
        if(saida == null)
            return false;
        else {
            boolean booEa = saida.getEstadoAtual().equals("Corrida de rua");
            boolean booP = saida.getNomeDoPredicado().contains("DesativarCorrida");
            boolean booEn = saida.getEstadoNovo().equals("Na rua");
            boolean booVo = saida.getVolume() == 100;
            boolean booVi = saida.getVibracao() == 0;
            boolean booMv = saida.getModoAviao() == 0;

            return (booEa && booP && booEn && booVo && booVi && booMv);
        }
    }

    private boolean AtivarCasa(SaidaDoCasoDeTeste saida){
        if(saida == null)
            return false;
        else {
            boolean booEa = saida.getEstadoAtual().equals("general");
            boolean booP = saida.getNomeDoPredicado().contains("AtivarCasa");
            boolean booEn = saida.getEstadoNovo().equals("Casa");
            boolean booVo = saida.getVolume() == 100;
            boolean booVi = saida.getVibracao() == 0;
            boolean booMv = saida.getModoAviao() == 0;

            return (booEa && booP && booEn && booVo && booVi && booMv);
        }
    }

    private  boolean DesativarCasa(SaidaDoCasoDeTeste saida){
        if(saida == null)
            return false;
        else {
            boolean booEa = saida.getEstadoAtual().equals("Casa");
            boolean booP = saida.getNomeDoPredicado().contains("DesativarCasa");
            boolean booEn = saida.getEstadoNovo().equals("general");
            boolean booVo = saida.getVolume() == 50;
            boolean booVi = saida.getVibracao() == 0;
            boolean booMv = saida.getModoAviao() == 0;

            return (booEa && booP && booEn && booVo && booVi && booMv);
        }
    }

    private boolean AtivarDirigindo(SaidaDoCasoDeTeste saida){
        if(saida == null)
            return false;
        else {
            boolean booEa = saida.getEstadoAtual().equals("general") || saida.getEstadoAtual().equals("Casa") || saida.getEstadoAtual().equals("Na rua") || saida.getEstadoAtual().equals("Escritorio");
            boolean booP = saida.getNomeDoPredicado().contains("AtivarDirigindo");
            boolean booEn = saida.getEstadoNovo().equals("Dirigindo");
            boolean booVo = saida.getVolume() == 50;
            boolean booVi = saida.getVibracao() == 0;
            boolean booMv = saida.getModoAviao() == 0;

            return (booEa && booP && booEn && booVo && booVi && booMv);
        }
    }

    private boolean DesativarDirigindo(SaidaDoCasoDeTeste saida) {
        if (saida == null)
            return false;
        else {
            boolean booEa = saida.getEstadoAtual().equals("Dirigindo");
            boolean booP = saida.getNomeDoPredicado().contains("DesativarDirigindo");
            boolean booEn = saida.getEstadoNovo().equals("general");
            boolean booVo = saida.getVolume() == 50;
            boolean booVi = saida.getVibracao() == 0;
            boolean booMv = saida.getModoAviao() == 0;

            return (booEa && booP && booEn && booVo && booVi && booMv);
        }
    }

    private boolean AtivarDirigindoRapido(SaidaDoCasoDeTeste saida){
        if(saida == null)
            return false;
        else {
            boolean booEa = saida.getEstadoAtual().equals("Dirigindo");
            boolean booP = saida.getNomeDoPredicado().contains("AtivarDirigindoRapido");
            boolean booEn = saida.getEstadoNovo().equals("DirigindoRapido");
            boolean booVo = saida.getVolume() == 10;
            boolean booVi = saida.getVibracao() == 0;
            boolean booMv = saida.getModoAviao() == 0;

            return (booEa && booP && booEn && booVo && booVi && booMv);
        }
    }

    private boolean DesativarDirigindoRapido(SaidaDoCasoDeTeste saida){
        if(saida == null)
            return false;
        else {
            boolean booEa = saida.getEstadoAtual().equals("DirigindoRapido");
            boolean booP = saida.getNomeDoPredicado().contains("DesativarDirigindoRapido");
            boolean booEn = saida.getEstadoNovo().equals("Dirigindo");
            boolean booVo = saida.getVolume() == 50;
            boolean booVi = saida.getVibracao() == 0;
            boolean booMv = saida.getModoAviao() == 0;

            return (booEa && booP && booEn && booVo && booVi && booMv);
        }
    }

    private void AdicionarParametrosNoCasoDeTeste(EntradaDoCasoDeTeste paramentos){
        // Dados podem ser passados para o serviço via Intent.
        serviceIntentAM.setAction("edu.hkust.cse.phoneAdapter.newContext");
        serviceIntentAM.putExtra(ContextName.GPS_AVAILABLE, paramentos.getmGpsAvailable());
        serviceIntentAM.putExtra(ContextName.GPS_LOCATION, paramentos.getmLocation());
        serviceIntentAM.putExtra(ContextName.GPS_SPEED, paramentos.getmSpeed());

        if(paramentos.getmBtDeviceList() == null)
        {
            ArrayList<String> s = new ArrayList<String>();
            //s.add(bt_NaoCasaNemEscritorio);
            paramentos.setmBtDeviceList(s);
        }

        serviceIntentAM.putExtra(ContextName.BT_DEVICE_LIST, paramentos.getmBtDeviceList());
        serviceIntentAM.putExtra(ContextName.BT_COUNT, paramentos.getmBtDeviceList().length);
        serviceIntentAM.putExtra(ContextName.TIME, paramentos.getmTime());
        serviceIntentAM.putExtra(ContextName.WEEKDAY, paramentos.getmWeekday());
    }
}