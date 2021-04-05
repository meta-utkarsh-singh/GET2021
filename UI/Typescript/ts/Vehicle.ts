class Vehicle {

    private vehicleCompany: String;
    private vehicleModel: String;
    private vehicleType: String;
    private vehicleNo: String;
    private identification: String;

    public constructor(vehicleCompany: String, vehicleModel: String, vehicleType: String, vehicleNo: String, identification: String) {
        this.vehicleCompany = vehicleCompany;
        this.vehicleModel = vehicleModel;
        this.vehicleType = vehicleType;
        this.vehicleNo = vehicleNo;
        this.identification = identification;
    }

    public getVehicleCompany = () => {
        return this.vehicleCompany;
    }

    public getVehicleModel = () => {
        return this.vehicleModel;
    }

    public getVehicleType = () => {
        return this.vehicleType;
    }

    public getVehicleNo = () => {
        return this.vehicleNo;
    }

    public getIdentification = () => {
        return this.identification;
    }
}