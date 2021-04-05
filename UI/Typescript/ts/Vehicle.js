var Vehicle = /** @class */ (function () {
    function Vehicle(vehicleCompany, vehicleModel, vehicleType, vehicleNo, identification) {
        var _this = this;
        this.getVehicleCompany = function () {
            return _this.vehicleCompany;
        };
        this.getVehicleModel = function () {
            return _this.vehicleModel;
        };
        this.getVehicleType = function () {
            return _this.vehicleType;
        };
        this.getVehicleNo = function () {
            return _this.vehicleNo;
        };
        this.getIdentification = function () {
            return _this.identification;
        };
        this.vehicleCompany = vehicleCompany;
        this.vehicleModel = vehicleModel;
        this.vehicleType = vehicleType;
        this.vehicleNo = vehicleNo;
        this.identification = identification;
    }
    return Vehicle;
}());
