import { Pass } from "./Pass";

class CyclePass extends Pass {
    private dailyPrice: Number = 5;
    private monthlyPrice: Number = 100;
    private yearlyPrice: Number = 500;

    public getDailyPrice = () => {
        return this.dailyPrice;
    }
    
    public getMonthlyPrice = () => {
        return this.monthlyPrice;
    }

    public getYearlyPrice = () => {
        return this.yearlyPrice;
    }
}