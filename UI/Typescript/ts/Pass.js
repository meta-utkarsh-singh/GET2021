"use strict";
exports.__esModule = true;
exports.Pass = void 0;
var Pass = /** @class */ (function () {
    function Pass(vehicleType, duration) {
        var _this = this;
        this.getTime = function () {
            return _this.time;
        };
        this.getVehicleType = function () {
            return _this.vehicleType;
        };
        this.getDuration = function () {
            return _this.duration;
        };
        this.time = new Date();
        this.vehicleType = vehicleType;
        this.duration = duration;
    }
    return Pass;
}());
exports.Pass = Pass;
