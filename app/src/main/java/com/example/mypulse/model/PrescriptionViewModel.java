package com.example.mypulse.model;

import androidx.annotation.NonNull;

public class PrescriptionViewModel {

   String remark;
   int prescriptionimage;

    public PrescriptionViewModel(String remark, int prescriptionimage) {
        this.remark = remark;
        this.prescriptionimage = prescriptionimage;
    }
    public PrescriptionViewModel() {
        this.remark = remark;
        this.prescriptionimage = prescriptionimage;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getPrescriptionimage() {
        return prescriptionimage;
    }

    public void setPrescriptionimage(int prescriptionimage) {
        this.prescriptionimage = prescriptionimage;
    }
}
