package com.example.kenkogym.utils.models.objects;


public class Days {
    private int status;
    private String titlo;
    private Long Id;

    public Days(int status, String titlo, Long id) {
        this.status = status;
        this.titlo = titlo;
        this.Id = id;
    }

    public int getStatus() {
        return status;
    }

    public String getTitlo() {
        return titlo;
    }

    public Long getId() {
        return Id;
    }
}
