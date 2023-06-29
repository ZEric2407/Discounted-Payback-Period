package com.example.dpp;

import java.util.Calendar;

public abstract class Interest {
    protected double debt;
    protected double initialDebt;
    protected Calendar debtStart;
    protected int discRate;
    protected Calendar pmtDue;

    public double getInitialDebt(){
        return initialDebt;
    }
    public double getDebt(){
        return debt;
    }

    public int getDiscRate(){
        return discRate;
    }

    public Calendar getPmtDue(){
        return pmtDue;
    }
    public abstract double updateDebt();

    public void setPmtDue(Calendar date){
        this.pmtDue = date;
    }
    public abstract void updateDebtAndPmtDue();

    public double addDebt(int amt) {
        try {
            debt += amt;
        } catch (NullPointerException e){
            debt = amt;
        }
        return debt;
    }

    public double makePayment(int amt){
        updateDebt();
        debt -= amt;
        if (debt < 0){
            debt = 0;
        }
        return debt;
    }

    public int changeRate(int rate){
        discRate = rate;
        return discRate;
    }

    public abstract double getAnnuity(int years);

    public abstract double declareCF(double amt, Calendar date);
    public abstract String getInterestPlan();

}
