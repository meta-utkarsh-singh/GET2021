import { Pass } from "./Pass";

class FourWheelPass extends Pass {
    private dailyPrice: Number = 20;
    private monthlyPrice: Number = 500;
    private yearlyPrice: Number = 3500;

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