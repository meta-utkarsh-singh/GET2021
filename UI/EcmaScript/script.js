let countClickEmpHead = 0;
let countClickVehHead = 0;
let countClickFeedbackHead = 0;
let countPressKey = 0;
let empNameEntered = "";
let empPassEntered = "";
let empConfirmPassEntered = "";
let empPhoneEntered = "";
let regId = 0;
let companyNameEntered = "";
let modelEntered = "";
let vehicleSelected = "";
let passSelected = "";
let cycleDaily = 5;
let cycleMonthly = 100;
let cycleYearly = 500;
let motorcycleDaily = 10;
let motorcycleMonthly = 200;
let motorcycleYearly = 1000;
let fourWheelerDaily = 20;
let fourWheelerMonthly = 500;
let fourWheelerYearly = 3500;

/** Helper method to check password validation */

let validatePass = (empPassEntered) => {
    let passUpper = false;
    let passLower = false;
    let passNum = false;
    for(let i = 0 ; i < empPassEntered.length ; i++) {
        let ch = empPassEntered.charAt(i);
        if(isFinite(ch)) {
            passNum = true;
        }
        else if(ch == ch.toUpperCase()) {
            passUpper = true;
        }
        else if(ch == ch.toLowerCase()) {
            passLower = true;
        }
    } 
    if(passNum && passUpper && passLower) {
        return true;
    }
    return false;
}

/** Helper method to check phone no validity */ 

let validatePhone = () => {
    let valid = true;
    for(let i = 0 ; i < empPhoneEntered.length ; i++){
        if(!isFinite(empPhoneEntered.charAt(i))) {
            valid = false;
            break;
        }
    }
    return valid;
}

/** getter for forms and pricing section */

let empForm = document.getElementById("add-emp");
let vehForm = document.getElementById("add-veh");
let feedbackForm = document.getElementById("feedback");
let pricing = document.getElementById("pricing");

/** getters for employee form components */

let empHead = document.getElementById("add-emp-head");
let empFname = document.getElementById("fname");
let empGender = document.getElementById("gender");
let empEmail = document.getElementById("email");
let empPassword = document.getElementById("password");
let empConfirmPassword = document.getElementById("conf-pwd");
let empPhone = document.getElementById("phone-no");
let empSubmit = document.getElementById("submit-emp");

/** getters for vehicle form components */

let vehHead = document.getElementById("add-veh-head");
let companyName = document.getElementById("c-name");
let make = document.getElementById("make");
let type = document.getElementById("type");
let vehicleNumber = document.getElementById("vehicle-no");
let vehicleIdentification = document.getElementById("id-veh");
let vehSubmit = document.getElementById("submit-veh");

/** getters for feedback form components */

let feedbackHead = document.getElementById("feedback-head");
let feedbackEmpName = document.getElementById("emp-feedback-name");
let empId = document.getElementById("emp-id");
let feedbackContent = document.getElementById("feed-content");
let feedbackSubmit = document.getElementById("submit-feedback");

/** getter for input in emp form */

let iEmpFirstName = document.getElementById("i-firstname");
let male = document.getElementById("male");
let female = document.getElementById("female");
let iEmpMail = document.getElementById("i-mail");
let iEmpPassword = document.getElementById("i-pwd");
let iEmpConfPassword = document.getElementById("i-confpwd");
let iEmpPhone = document.getElementById("i-pno");

/** getter for labels in input form */

let lEmpFirstName = document.getElementById("l-fname");
let gender = document.getElementById("l-gender");
let lEmail = document.getElementById("l-email");
let lPassword = document.getElementById("l-password");
let lConfirmPassword = document.getElementById("l-confpwd");
let lPhoneNumber = document.getElementById("l-pno");

/**getter for input in vehicle form */

let iCompanyName = document.getElementById("i-cname");
let iMake = document.getElementById("i-make-model");
let car  = document.getElementById("car");
let bike = document.getElementById("bike");
let truck = document.getElementById("truck");
let iVehicleNumber = document.getElementById("i-vno");
let iEmployeeId = document.getElementById("i-eid");
let iIdentification = document.getElementById("i-identification");

/** getter for pricing components */

let pricingCycle = document.getElementById("pricing-cycle");
let pricingMotorcycle = document.getElementById("pricing-motorcycle");
let pricingFourWheeler = document.getElementById("pricing-four-wheelers");

/** getter for component of pricing cycle */

let priceDailyCycle = document.getElementById("price-daily-cycle");
let priceMonthlyCycle = document.getElementById("price-monthly-cycle");
let priceYearlyCycle = document.getElementById("price-yearly-cycle");
let getPassCycle = document.getElementById("pass-cycle");
let cycleInr = document.getElementById("c-inr");
let cycleYen = document.getElementById("c-yen");

/** getter for component of pricing motorcycle */

let priceDailyMotorcycle = document.getElementById("price-daily-motorcycle");
let priceMonthlyMotorcycle = document.getElementById("price-monthly-motorcycle");
let priceYearlyMotorcycle = document.getElementById("price-yearly-motorcycle");
let getPassMotorMotorcycle = document.getElementById("pass-motorcycle");
let motorcycleInr = document.getElementById("m-inr");
let motorcycleYen = document.getElementById("m-yen");

/** getter for component of pricing four wheeler */

let priceDailyFourWheeler = document.getElementById("price-daily-four-wheelers");
let priceMonthlyFourWheeler = document.getElementById("price-monthly-four-wheelers");
let priceYearlyFourWheeler = document.getElementById("price-yearly-four-wheelers");
let getPassFourWheeler = document.getElementById("pass-four-wheeler");
let fourWheelInr = document.getElementById("f-inr");
let fourWheelYen = document.getElementById("f-yen");

/**Sets display none initially at page load time */

empForm.classList.add("d-none");
vehForm.classList.add("d-none");
feedbackForm.classList.add("d-none");
pricing.classList.add("d-none");

/** onclick event : display the form when the heading is clicked */

empHead.onclick = () => {
    if(countClickEmpHead % 2 == 0) {
        empForm.classList.remove("d-none");
        vehForm.classList.add("d-none");
        feedbackForm.classList.add("d-none");
        countClickVehHead = 0;
        countClickFeedbackHead = 0;
        countClickEmpHead = 1;
    }    
    else {
        empForm.classList.add("d-none");
        countClickEmpHead = 0;
    }
};

vehHead.onclick = () => {
    if(countClickVehHead % 2 == 0) {
        vehForm.classList.remove("d-none");
        empForm.classList.add("d-none");
        feedbackForm.classList.add("d-none");
        countClickFeedbackHead = 0;
        countClickEmpHead = 0;
        countClickVehHead = 1;
    }    
    else {
        vehForm.classList.add("d-none");
        countClickVehHead = 0;
    }
};

feedbackHead.onclick = () => {
    if(countClickFeedbackHead % 2 == 0) {
        feedbackForm.classList.remove("d-none");
        empForm.classList.add("d-none");
        vehForm.classList.add("d-none");
        countClickVehHead = 0;
        countClickFeedbackHead = 1;
        countClickEmpHead = 0;
    }    
    else {
        feedbackForm.classList.add("d-none");
        countClickFeedbackHead = 0;
    }
};

/**event handler for employee form */

iEmpFirstName.onkeydown = (event)=>{
    countPressKey = countPressKey + 1;
    if(isFinite(event.key)){
        alert("Please do not enter numbers");
    }
    else if(event.key == "Enter" && countPressKey < 3){
        alert("Enter valid name");
    }
    else if(event.key == "Enter") {
        empFname.classList.add("d-none");
        gender.innerText ="Please select your gender "+empNameEntered;
        empGender.classList.remove("d-none");
    }
    if(event.key!="Enter") {
        empNameEntered = empNameEntered + event.key;
    }
}

empGender.onkeydown = (event) => {
    empGender.classList.add("d-none");
    lEmail.innerHTML = "Please enter email " + empNameEntered;
    empEmail.classList.remove("d-none");
}

iEmpMail.onkeydown = (event) => {
    if(event.key == "Enter") {
        empEmail.classList.add("d-none");
        lPassword.innerHTML = "Please enter your password "+empNameEntered;
        empPassword.classList.remove("d-none");
    }
}

iEmpPassword.onkeydown = (event) => {
    let ch = event.key;
    empPassEntered = document.getElementById("i-pwd").value;
    if(!validatePass(empPassEntered) || empPassEntered.length < 10) {
        iEmpPassword.classList.remove("border-orange");
        iEmpPassword.classList.remove("border-green");
        iEmpPassword.classList.add("border-red");
    }
    else if(validatePass(empPassEntered) && empPassEntered.length == 10) {
        iEmpPassword.classList.remove("border-green");
        iEmpPassword.classList.add("border-orange");
        iEmpPassword.classList.remove("border-red");
    }
    else if(validatePass(empPassEntered) && empPassEntered.length > 10) {
        iEmpPassword.classList.remove("border-red");
        iEmpPassword.classList.remove("border-orange");
        iEmpPassword.classList.add("border-green");
    }
    if(ch == "Enter" && validatePass(empPassEntered) && empPassEntered.length >= 8) {
        empPassword.classList.add("d-none");
        lConfirmPassword = "Please re-enter the password for confirmation "+empNameEntered; 
        empConfirmPassword.classList.remove("d-none");
    }
    else if(ch == "Enter") {
        alert("Enter valid password");
    }
}

iEmpConfPassword.onkeydown = (event) => {
    let ch = event.key;
    empConfirmPassEntered = document.getElementById("i-confpwd").value;
    if(ch == "Enter" && empConfirmPassEntered != empPassEntered) {
        alert("Password do not match");
    }
    else if(ch == "Enter") {
        empConfirmPassword.classList.add("d-none");
        lPhoneNumber.innerHTML = "Please enter your phone number "+empNameEntered;
        empPhone.classList.remove("d-none");
    }
}

iEmpPhone.onkeydown = (event) => {
    let ch = event.key;
    empPhoneEntered = document.getElementById("i-pno").value;
    if(ch == "Enter" && !validatePhone() && empPhoneEntered.length < 9) {
        alert("Enter valid phone number");
    }
    else if(ch == "Enter") {
        regId++;
        empPhone.classList.add("d-none");
        empForm.classList.add("d-none");
        countClickEmpHead = 0;
        empFname.classList.remove("d-none");
        alert("Hello, "+empNameEntered+" your registration ID is"+regId);
        window.location.reload();
    }
}

/** event handler for vehicle form */

iCompanyName.onkeydown = (event) => {
    companyNameEntered = document.getElementById("c-name").value;
    if(event.key == "Enter") {
        companyName.classList.add("d-none");
        make.classList.remove("d-none");
    }
}

iMake.onkeydown = (event) => {
    modelEntered = document.getElementById("i-make-model").value;
    if(event.key == "Enter") {
        make.classList.add("d-none");
        type.classList.remove("d-none");
    }
}

type.onkeydown = (event) => {
    if(car.checked) {
        vehicleSelected = "Car";
    }
    else if(truck.checked) {
        vehicleSelected = "truck";
    }
    else if(bike.checked) {
        vehicleSelected = "bike";
    }
    if(event.key == "Enter") {
        type.classList.add("d-none");
        console.log(vehicleSelected);
        vehicleNumber.classList.remove("d-none");
    }
}

iVehicleNumber.onkeydown = (event) => {
    if(event.key == "Enter") {
        vehicleNumber.classList.add("d-none");
        vehicleIdentification.classList.remove("d-none");
    }
}

vehicleIdentification.onkeydown = (event) => {
    if(event.key == "Enter") {
        vehicleIdentification.classList.add("d-none");
        vehForm.classList.add("d-none");
        companyName.classList.remove("d-none");
        pricing.classList.remove("d-none");
        if(vehicleSelected == "Car" || vehicleSelected == "truck") {
            pricingFourWheeler.classList.remove("d-none");
        }
        else if(vehicleSelected == "bike") {
            pricingMotorcycle.classList.remove("d-none");
        }
    }
}

priceDailyFourWheeler.onclick = (event) => {
    passSelected = "daily4";
}

priceMonthlyFourWheeler.onclick = (event) => {
    passSelected = "monthly4";
}

priceYearlyFourWheeler.onclick = (event) => {
    passSelected = "yearly4";
}

priceDailyCycle.onclick = (event) => {
    passSelected = "dailyC";
}

priceMonthlyCycle.onclick = (event) => {
    passSelected = "monthlyC";
}

priceYearlyCycle.onclick = (event) => {
    passSelected = "yearlyC";
}

priceDailyMotorcycle.onclick = (event) => {
    passSelected = "dailyM";
}

priceMonthlyMotorcycle.onclick = (event) => {
    passSelected = "monthlyM";
}

priceYearlyMotorcycle.onclick = (event) => {
    passSelected = "yearlyM";
}

getPassCycle.onclick = (event) => {
    if(passSelected == "monthlyC") {
        alert("Your total amount is " + document.getElementById("price-monthly-cycle").innerText);
    }
    else if(passSelected == "dailyC") {
        alert("Your total amount is " + document.getElementById("price-daily-cycle").innerText);
    }
    else if(passSelected == "yearlyC") {
        alert("Your total amount is " + document.getElementById("price-yearly-cycle").innerText);
    }
}
console.log(getPassFourWheeler);
getPassFourWheeler.onclick = (event) => {
    console.log(passSelected);
    if(passSelected == "daily4") {
        alert("Your total amount is " + document.getElementById("price-daily-four-wheelers").innerText);
    }
    else if(passSelected == "monthly4") {
        alert("Your total amount is " + document.getElementById("price-monthly-four-wheelers").innerText);
    }
    else if(passSelected == "yearly4") {
        alert("Your total amount is " + document.getElementById("price-yearly-four-wheelers").innerText);
    }
}

getPassMotorMotorcycle.onclick = (event) => {
    if(passSelected == "dailyM") {
        alert("Your total amount is " + document.getElementById("price-daily-motorcycle").innerText);
    }
    else if(passSelected == "monthlyM") {
        alert("Your total amount is " + document.getElementById("price-monthly-motorcycle").innerText);
    }
    else if(passSelected == "yearlyM") {
        alert("Your total amount is " + document.getElementById("price-yearly-motorcycle").innerText);
    }
}

fourWheelInr.onclick = (event) => {
    priceDailyFourWheeler.innerHTML = "Rs "+fourWheelerDaily*70+" Daily";
    priceMonthlyFourWheeler.innerHTML = "Rs "+fourWheelerMonthly*70+" Monthly";
    priceYearlyFourWheeler.innerHTML = "Rs "+fourWheelerYearly*70+" Yearly"; 
}

cycleInr.onclick = (event) => {
    priceDailyCycle.innerHTML = "Rs "+cycleDaily*70+" Daily";
    priceMonthlyCycle.innerHTML = "Rs "+cycleMonthly*70+" Monthly";
    priceYearlyCycle.innerHTML = "Rs "+cycleYearly*70+" Yearly"; 
}

motorcycleInr.onclick = (event) => {
    priceDailyMotorcycle.innerHTML = "Rs "+motorcycleDaily*70+" Daily";
    priceMonthlyMotorcycle.innerHTML = "Rs "+motorcycleMonthly*70+" Monthly";
    priceYearlyMotorcycle.innerHTML = "Rs "+motorcycleYearly*70+" Yearly"; 
}

fourWheelYen.onclick = (event) => {
    priceDailyFourWheeler.innerHTML = "YEN "+fourWheelerDaily*80+" Daily";
    priceMonthlyFourWheeler.innerHTML = "YEN "+fourWheelerMonthly*80+" Monthly";
    priceYearlyFourWheeler.innerHTML = "YEN "+fourWheelerYearly*80+" Yearly"; 
}

cycleYen.onclick = (event) => {
    priceDailyCycle.innerHTML = "YEN "+cycleDaily*80+" Daily";
    priceMonthlyCycle.innerHTML = "YEN "+cycleMonthly*80+" Monthly";
    priceYearlyCycle.innerHTML = "YEN "+cycleYearly*80+" Yearly"; 
}

motorcycleYen.onclick = (event) => {
    priceDailyMotorcycle.innerHTML = "YEN "+motorcycleDaily*80+" Daily";
    priceMonthlyMotorcycle.innerHTML = "YEN "+motorcycleMonthly*80+" Monthly";
    priceYearlyMotorcycle.innerHTML = "YEN "+motorcycleYearly*80+" Yearly"; 
}