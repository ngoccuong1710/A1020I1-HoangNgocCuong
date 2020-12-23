class Employee{
    constructor(name, cmnd, birthday, email, sdt, trinhDo, viTri, luong) {
        this.name = name;
        this.cmnd = cmnd;
        this.birthday = birthday;
        this.email = email;
        this.sdt = sdt;
        this.trinhDo = trinhDo;
        this.viTri = viTri;
        this.luong = luong;
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
    getSdt(){
        return this.sdt;
    }
    getTrinhDo(){
        return this.trinhDo;
    }
    getViTri(){
        return this.viTri;
    }
    getLuong(){
        if(this.getViTri() === "Mânger"){
            this.luong = 500;
        }
        else if (this.getViTri() === "Sale"){
            this.luong = 300;
        }
        else if (this.getViTri() === "Marketing"){
            this.luong = 200;
        }
        return this.luong;
    }
    setName(name){
        this.name = name;
    }
    setCmnd(cmnd){
        this.cmnd = cmnd;
    }
    setBirthday(bỉrthday){
        this.birthday = bỉrthday;
    }
    setEmail(email){
        this.email = email;
    }
    setSdt(sdt){
        this.sdt = sdt;
    }
    setTrinhDo(trinhDo){
        this.trinhDo = trinhDo;
    }
    setViTri(viTri){
        this.viTri = viTri;
    }
}