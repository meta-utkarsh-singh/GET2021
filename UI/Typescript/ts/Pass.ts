export class Pass {

    private time: Date;
    private vehicleType: String;
    private duration: String;

    public constructor(vehicleType: String, duration: String) {
        this.time = new Date();
        this.vehicleType = vehicleType;
        this.duration = duration;
    }

    public getTime = () => {
        return this.time;
    }

    public getVehicleType = () => {
        return this.vehicleType;
    }

    public getDuration = () => {
        return this.duration;
    }
}