package com.example.mypulse.model;

public class DoctorModel {


   String name;
   String addarea;
   String drname;
   String degree;
   String degreename;
   String exp;
   String mobile;
   int doctorimage;

    public int getDoctorimage() {
        return doctorimage;
    }

    public void setDoctorimage(int doctorimage) {
        this.doctorimage = doctorimage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddarea() {
        return addarea;
    }

    public void setAddarea(String addarea) {
        this.addarea = addarea;
    }

    public String getDrname() {
        return drname;
    }

    public void setDrname(String drname) {
        this.drname = drname;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getDegreename() {
        return degreename;
    }

    public void setDegreename(String degreename) {
        this.degreename = degreename;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }



    public DoctorModel(String name, String addarea, String drname, String degree, String degreename, String exp, String mobile, int doctorimageimage) {

        this.name = name;
        this.addarea = addarea;
        this.drname = drname;
        this.degree = degree;
        this.degreename = degreename;
        this.exp = exp;
        this.mobile = mobile;
        this.doctorimage = doctorimageimage;
    }



    public DoctorModel() {

        this.name = name;
        this.addarea = addarea;
        this.drname = drname;
        this.degree = degree;
        this.degreename = degreename;
        this.exp = exp;
        this.mobile = mobile;
        this.doctorimage = doctorimage;
    }
}
