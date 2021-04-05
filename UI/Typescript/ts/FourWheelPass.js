"use strict";
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
exports.__esModule = true;
var Pass_1 = require("./Pass");
var FourWheelPass = /** @class */ (function (_super) {
    __extends(FourWheelPass, _super);
    function FourWheelPass() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.dailyPrice = 20;
        _this.monthlyPrice = 500;
        _this.yearlyPrice = 3500;
        _this.getDailyPrice = function () {
            return _this.dailyPrice;
        };
        _this.getMonthlyPrice = function () {
            return _this.monthlyPrice;
        };
        _this.getYearlyPrice = function () {
            return _this.yearlyPrice;
        };
        return _this;
    }
    return FourWheelPass;
}(Pass_1.Pass));
