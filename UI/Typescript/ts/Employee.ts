class Employee {
    private id: Number;
    private name: String;
    private gender: String;
    private email: String;
    private contactNo: String;
    private password: String;
    private vehicle: Object;
    private vehiclePass: Object;

    public constructor(id: Number, name: String, gender: String, email: String, contactNo: String, password: String) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.contactNo = contactNo;
        this.password = password;
        this.vehicle = undefined;
        this.vehiclePass = undefined;
    }

    public getId = () => {
        return this.id;
    }

    public getName = () => {
        return this.name;
    }

    public getGender = () => {
        return this.gender;
    }

    public getEmail = () => {
        return this.email;
    }

    public getContact = () => {
        return this.contactNo
    }

    public getVehicle = () => {
        return this.vehicle;
    }

    public getVehiclePass = () => {
        return this.vehiclePass;
    }
}