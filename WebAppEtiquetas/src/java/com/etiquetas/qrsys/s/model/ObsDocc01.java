package com.etiquetas.qrsys.s.model;

public class ObsDocc01 implements java.io.Serializable {

    private int cveObs;
    private String strObs;

    public ObsDocc01() {
    }

    public ObsDocc01(int cveObs) {
        this.cveObs = cveObs;
    }

    public ObsDocc01(int cveObs, String strObs) {
        this.cveObs = cveObs;
        this.strObs = strObs;
    }

    public int getCveObs() {
        return this.cveObs;
    }

    public void setCveObs(int cveObs) {
        this.cveObs = cveObs;
    }

    public String getStrObs() {
        return this.strObs;
    }

    public void setStrObs(String strObs) {
        this.strObs = strObs;
    }

}
