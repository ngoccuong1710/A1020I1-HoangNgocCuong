import {IEmployee} from "./employee";
import {ICustomer} from "./customer";
import {IService} from "./service";

export interface IContract {
  id: number;
  idContract: string;
  startDate: string;
  endDate: string;
  deposit: number;
  totalMoney: number;
  employee: IEmployee;
  customer: ICustomer;
  service: IService;
}
