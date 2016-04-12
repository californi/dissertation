package edu.hkust.cse.phoneAdapter.context;

import android.location.Location;

import java.util.ArrayList;
import java.util.Calendar;

public class SaidaDoCasoDeTeste {
    private String NomeDoPredicado;
    private String EstadoNovo;
    private int Volume;
    private int Vibracao;
    private int ModoAviao;
    private String EstadoAtual;
    private ArrayList<String> BtDeviceList;
    private Location Localizacao;
    private Calendar Calendar;

    public String getEstadoAtual() {
        return EstadoAtual;
    }

    public void setEstadoAtual(String estadoAtual) {
        EstadoAtual = estadoAtual;
    }

    public String getNomeDoPredicado() {
        return NomeDoPredicado;
    }

    public void setNomeDoPredicado(String nomeDoPredicado) {
        NomeDoPredicado = nomeDoPredicado;
    }

    public String getEstadoNovo() {
        return EstadoNovo;
    }

    public void setEstadoNovo(String estadoNovo) {
        EstadoNovo = estadoNovo;
    }

    public int getVolume() {
        return Volume;
    }

    public void setVolume(int volume) {
        Volume = volume;
    }

    public int getVibracao() {
        return Vibracao;
    }

    public void setVibracao(int vibracao) {
        Vibracao = vibracao;
    }

    public int getModoAviao() {
        return ModoAviao;
    }

    public void setModoAviao(int modoAviao) {
        ModoAviao = modoAviao;
    }

    public ArrayList<String> getBtDeviceList() {
        return BtDeviceList;
    }

    public void setBtDeviceList(ArrayList<String> btDeviceList) {
        BtDeviceList = btDeviceList;
    }

    public Location getLocalizacao() {
        return Localizacao;
    }

    public void setLocalizacao(Location localizacao) {
        Localizacao = localizacao;
    }

    public java.util.Calendar getCalendar() {
        return Calendar;
    }

    public void setCalendar(java.util.Calendar calendar) {
        Calendar = calendar;
    }
}
