class Customer {
    constructor(name, cmnd, birthday, email, address, typeCustomer, discount, quantinyIncluded, rendDays, typeService, typeRoom) {
        this.name = name;
        this.cmnd = cmnd;
        this.birthday = birthday;
        this.email = email;
        this.address = address;
        this.typeCustomer = typeCustomer;
        this.discount = discount;
        this.quantinyIncluded = quantinyIncluded;
        this.rendDays = rendDays;
        this.typeService = typeService;
        this.typeRoom = typeRoom;
    }
    getName(){
        return this.name;
    }
    getCmnd(){
        return this.cmnd;
    }
    getBirthday(){
        return this.birthday;
    }
    getEmail(){
        return this.email;
    }
    getAddress(){
        return this.address;
    }
    getTypeCustomer(){
        return this.typeCustomer;
    }
    getDiscount(){
        return this.discount;
    }
    getQuantinyIncluded(){
        return this.quantinyIncluded;
    }
    getRendDays(){
        return this.rendDays;
    }
    getTypeService(){
        return this.typeService;
    }
    getTypeRoom(){
        return this.typeRoom;
    }
    setName(name){
        this.name = name;
    }
    setCmnd(cmnd){
        this.cmnd = cmnd;
    }
    setBirthday(birthday){
        this.birthday = birthday;
    }
    setEmail(email){
        this.email = email;
    }
    setAddress(address){
        this.address = address;
    }
    setTypeCustomer(typeCustomer){
        this.typeCustomer = typeCustomer;
    }
    setDiscount(discount){
        this.discount = discount;
    }
    setQuantinyIncluded(quantinyIncluded){
        this.quantinyIncluded = quantinyIncluded;
    }
    setRendDays(rendDays){
        this.rendDays = rendDays;
    }
    setTypeService(typeService){
        this.typeService = typeService;
    }
    setTypeRoom(typeRoom){
        this.typeRoom = typeRoom;
    }
    totalPay(){
        let money = 0;
        if (this.getTypeService() === "Villa"){
            money = 500;
        }
        else if (this.getTypeService() === "House"){
            money = 300;
        }
        else  if (this.getTypeService() === "Room"){
            money = 200;
        }
        return this.getRendDays() * money * (1 - this.getDiscount() / 100);
    }
}