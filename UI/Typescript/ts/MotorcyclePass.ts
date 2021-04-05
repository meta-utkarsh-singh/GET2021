import { Pass } from "./Pass";

class MotorcyclePass extends Pass {
    private dailyPrice: Number = 10;
    private monthlyPrice: Number = 200;
    private yearlyPrice: Number = 1000;

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