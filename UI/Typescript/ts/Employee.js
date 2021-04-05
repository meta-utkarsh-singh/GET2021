var Employee = /** @class */ (function () {
    function Employee(id, name, gender, email, contactNo, password) {
        var _this = this;
        this.getId = function () {
            return _this.id;
        };
        this.getName = function () {
            return _this.name;
        };
        this.getGender = function () {
            return _this.gender;
        };
        this.getEmail = function () {
            return _this.email;
        };
        this.getContact = function () {
            return _this.contactNo;
        };
        this.getVehicle = function () {
            return _this.vehicle;
        };
        this.getVehiclePass = function () {
            return _this.vehiclePass;
        };
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.contactNo = contactNo;
        this.password = password;
        this.vehicle = undefined;
        this.vehiclePass = undefined;
    }
    return Employee;
}());
