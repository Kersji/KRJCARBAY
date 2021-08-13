'use strict'

// Define buttons
let searchButton = document.querySelector("#search");
let addButton = document.querySelector("#add");
let amendButton = document.querySelector("#amend");
let removeButton = document.querySelector("#remove");
let clearButton = document.querySelector("#clear");

let closeVehicleXButton = document.querySelector("#closeVehicleX");
let closeVehicleButton = document.querySelector("#closeVehicle");

// Define display and entry fields
let displayInfoH = document.querySelector("#displayInfoH");
let displayInfo = document.querySelector("#displayInfo");
let vehicleId = document.querySelector("#vehicleId");
let registrationNumber = document.querySelector("#registrationNumber");
let make = document.querySelector("#make");
let model = document.querySelector("#model");
let colour = document.querySelector("#colour");
let mileage = document.querySelector("#mileage");
let engineSize = document.querySelector("#engineSize");
let registrationDate = document.querySelector("#registrationDate");
let fuelType = document.querySelector("#fuelType");
let gearboxType = document.querySelector("#gearboxType");
let bodyType = document.querySelector("#bodyType");
  
// Clear display fields
const clearDisplayFields = () => {
    displayInfo.innerHTML = ``;
    vehicleId.value = ``;
    registrationNumber.value = ``;
    make.value = ``;
    model.value = ``;
    colour.value = ``;
    mileage.value = ``;
    engineSize.value = ``;
    registrationDate.value = ``;
    fuelType.value = ``;
    gearboxType.value = ``;
    bodyType.value = ``;
}

// Display user information
const displayUserMsgH = (msg) => {

    displayInfoH.innerHTML = ``;
    const TEXT = document.createTextNode(msg);
    const HEADING = document.createElement("h4");
    HEADING.appendChild(TEXT);
    displayInfoH.appendChild(HEADING);
}

// Display user information
const displayUserMsg = (msg) => {

    displayInfo.innerHTML = ``;
    const TEXT = document.createTextNode(msg);
    const HEADING = document.createElement("h6");
    HEADING.appendChild(TEXT);
    displayInfo.appendChild(HEADING);
}

// Display informational message
const displayInfoMsgH = (msg) => {

    // Clear display fields
    clearDisplayFields();

    // Display error message
    displayUserMsgH(msg);
}

// Display informational message
const displayInfoMsg = (msg) => {

    // Clear display fields
    clearDisplayFields();

    // Display error message
    displayUserMsg(msg);
}

// Display vehicle information
const displayVehicleInfo = (vehicle, msg) => {
    
    // Clear display fields
    clearDisplayFields();
   
    // Display user message
    displayUserMsg(msg);

    // Set frontend fields
    vehicleId.value = vehicle.vehicle_id;
    registrationNumber.value = vehicle.registration_number;
    make.value = vehicle.make;
    model.value = vehicle.model;
    colour.value = vehicle.colour;
    mileage.value = vehicle.mileage;
    engineSize.value = vehicle.engine_size;
    registrationDate.value = vehicle.registration_date;
    fuelType.value = vehicle.fuel_type;
    gearboxType.value = vehicle.gearbox_type;
    bodyType.value = vehicle.body_type;
}

// Display vehicle list
const displayVehicleList = (vehicleList) => {
    
    // Clear header user information
    displayInfoH.innerHTML = ``;
    
    if (vehicleList.length > 0) {
        for (let i=0; i<vehicleList.length ; i++) {
            // Create parent element
            const cardParent = document.querySelector('#cardList');

            // Create a new card 
            const child = document.createElement('div');
            const childBody = document.createElement('div');
    
            const childVehicleId = document.createElement('h6');
            const childRegistrationNumber = document.createElement('h6');
            const childMake = document.createElement('h6');
            const childModel = document.createElement('h6');
            const childColour = document.createElement('h6');   
            const childMileage = document.createElement('h6');
            const childEngineSize = document.createElement('h6');
            const childRegistrationDate = document.createElement('h6');
            const childFuelType = document.createElement('h6');
            const childGearboxType = document.createElement('h6');
            const childBodyType = document.createElement('h6');   

            // Modify elements, passing in the data
            childVehicleId.textContent = " Vehicle Id: " + vehicleList[i].vehicle_id;
            childRegistrationNumber.textContent = "Registration Number: " + vehicleList[i].registration_number;
            childMake.textContent = "Make: " + vehicleList[i].make;
            childModel.textContent = "Model: " + vehicleList[i].model;
            childColour.textContent = "Colour: " + vehicleList[i].colour;
            childMileage.textContent = "Mileage: " + vehicleList[i].mileage;
            childEngineSize.textContent = "Engine Size: " + vehicleList[i].engine_size;
            childRegistrationDate.textContent = "Registration Date: " + vehicleList[i].registration_date;
            childFuelType.textContent = "Fuel Type: " + vehicleList[i].fuel_type;
            childGearboxType.textContent = "Gearbox Type: " + vehicleList[i].gearbox_type;
            childBodyType.textContent = "Body Type: " + vehicleList[i].body_type;   

            // Modify the classes 
            childBody.className = "card-body";
            child.className = "card";

            // Append the elements
            childBody.appendChild(childVehicleId);
            childBody.appendChild(childRegistrationNumber); 
            childBody.appendChild(childMake);
            childBody.appendChild(childModel);
            childBody.appendChild(childColour);
            childBody.appendChild(childMileage);
            childBody.appendChild(childEngineSize);
            childBody.appendChild(childRegistrationDate);
            childBody.appendChild(childFuelType);
            childBody.appendChild(childGearboxType);
            childBody.appendChild(childBodyType);  

            child.appendChild(childBody);
            cardParent.appendChild(child);     

        } 
    } else {
        displayInfoMsgH(`No Vehicles to display`);
    }

}

// Add a vehicle
const addVehicle = (event) => {
    event.preventDefault();

    if (registrationNumber.value != ``) {

        // Create the object to be sent to the createVehicle API
        let vehicleData = {
            registration_number:    registrationNumber.value,
            make:                   make.value,
            model:                  model.value,
            colour:                 colour.value,
            mileage:                mileage.value,
            engine_size:            engineSize.value,
            registration_date:      registrationDate.value,
            fuel_type:              fuelType.value,
            gearbox_type:           gearboxType.value,
            body_type:              bodyType.value
        };

        axios.post(`http://localhost:8080/CarBay/createVehicle`, vehicleData, {
            headers: {
            'Access-Control-Allow-Origin': '*',
        }})
        .then((response) => displayVehicleInfo(response.data, `Vehicle ${response.data.vehicle_id} successfully added`))
        .catch((error) =>  displayInfoMsg(`ERROR! Vehicle not added`));
    } else {
        displayInfoMsg(`ERROR! Please enter Vehicle details`);
    }
    
}

// Search a vehicle by Id (vehicleId)
const searchVehicle = (event) => {
    event.preventDefault();

    if (vehicleId.value != ``) {
        axios.get(`http://localhost:8080/CarBay/searchVehicle/${vehicleId.value}`, {
            headers: {
            'Access-Control-Allow-Origin': '*',
        }})
        // .then((response) => displayVehicleInfo(response.data, `Vehicle ${vehicleId.value} found` ))
        .then((response) => displayVehicleInfo(response.data, `` ))
        .catch((error) =>  displayInfoMsg(`ERROR! Vehicle ${vehicleId.value} not found`));
    } else {
        displayInfoMsg(`ERROR! Please enter a Vehicle Id to search`);
    }
    
}

// Refresh vehicle list
const refreshVehicleList = () => {
  
    axios.get(`http://localhost:8080/CarBay/readAllVehicle`, {
        headers: {
       'Access-Control-Allow-Origin': '*',
    }})
    .then((response) => displayVehicleList(response.data))
    .catch((error) =>  displayInfoMsgH(`ERROR! No Vehicles to display`));
}

// Amend vehicle information by Id (vehicleId)
const amendVehicle = (event) => {
    event.preventDefault();

    if (vehicleId.value != ``) {

        // Create the object to be sent to the updateVehicle API
        let vehicleData = {
            registration_number:    registrationNumber.value,
            make:                   make.value,
            model:                  model.value,
            colour:                 colour.value,
            mileage:                mileage.value,
            engine_size:            engineSize.value,
            registration_date:      registrationDate.value,
            fuel_type:              fuelType.value,
            gearbox_type:           gearboxType.value,
            body_type:              bodyType.value
        };

        axios.patch(`http://localhost:8080/CarBay/updateVehicle/${vehicleId.value}`, vehicleData, {
            headers: {
            'Access-Control-Allow-Origin': '*',
        }})
        .then((response) => displayVehicleInfo(response.data, `Vehicle ${response.data.vehicle_id} successfully amended`))
        .catch((error) =>  displayInfoMsg(`ERROR! Vehicle not amended`));
    } else {
        displayInfoMsg(`ERROR! Please search for the Vehicle to amend first`);
    }
    
}

// Remove a vehicle by Id (vehicleId)
const removeVehicle = (event) => {
    event.preventDefault();

    if (vehicleId.value != ``) {
        axios.delete(`http://localhost:8080/CarBay/deleteVehicle/${vehicleId.value}`, {
            headers: {
            'Access-Control-Allow-Origin': '*',
        }})
        .then((response) => displayInfoMsg(`Vehicle ${vehicleId.value} removed`))
        .catch((error) =>  displayInfoMsg(`ERROR! Vehicle ${vehicleId.value} not found`));
    } else {
        displayInfoMsg(`ERROR! Please search for the Vehicle to remove first`);
    }
    
}

// Clear modal display
const clearVehicleModalDisplay = (event) => {
    event.preventDefault();

    // Clear display fields on frontend
    clearDisplayFields();        
}

// Clear display fields on frontend
clearDisplayFields();

// Refresh vehicle list
refreshVehicleList();

// Search for a vehicle by Id (vehicleId)
searchButton.addEventListener(`click`, searchVehicle);

// Add a vehicle
addButton.addEventListener(`click`, addVehicle);

// Amend a vehicle by Id (vehicleId)
amendButton.addEventListener(`click`, amendVehicle);

// Remove a vehicle by Id (vehicleId)
removeButton.addEventListener(`click`, removeVehicle);

// Close X vehicle modal display
closeVehicleXButton.addEventListener(`click`, clearVehicleModalDisplay);

// Close button vehicle modal display
closeVehicleButton.addEventListener(`click`, clearVehicleModalDisplay);

// Clear display
clearButton.addEventListener(`click`, clearVehicleModalDisplay);